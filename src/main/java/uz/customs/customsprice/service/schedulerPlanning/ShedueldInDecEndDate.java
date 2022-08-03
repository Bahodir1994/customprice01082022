package uz.customs.customsprice.service.schedulerPlanning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import uz.customs.customsprice.entity.InitialDecision.*;
import uz.customs.customsprice.repository.InDecRepo;
import uz.customs.customsprice.service.apps.AppsService;
import uz.customs.customsprice.service.commodity.CommodityService;
import uz.customs.customsprice.service.status.StatusHService;
import uz.customs.customsprice.service.status.StatusMService;
import uz.customs.customsprice.service.status.StatusService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Configuration
@EnableScheduling
public class ShedueldInDecEndDate {

    @Autowired
    private InDecRepo inDecRepo;

    private final CommodityService commodityService;
    private final AppsService appsService;
    private final StatusMService statusMService;
    private final StatusService statusService;
    private final StatusHService statusHService;

    public ShedueldInDecEndDate(CommodityService commodityService, AppsService appsService, StatusMService statusMService, StatusService statusService, StatusHService statusHService) {
        this.commodityService = commodityService;
        this.appsService = appsService;
        this.statusMService = statusMService;
        this.statusService = statusService;
        this.statusHService = statusHService;
    }

    @Scheduled(cron = "0 0 3 * * *")
    public void scheduleTaskUsingCronExpression() {
        try {
            Apps apps = new Apps();
            List<InDec> inDecs = new ArrayList<>();
            inDecs = inDecRepo.findByEndActiv(100);
            Commodity commodity = new Commodity();

            Date date = new Date();
            long dd = date.getTime();
            for (int i = 0; i < inDecs.size(); i++) {
                if (inDecs.get(i).getInDecEndDate().getTime() < dd) {
                    commodity = commodityService.findById(inDecs.get(i).getCmdtId());
                    apps = appsService.findById(commodity.getAppId());
                    if (apps != null) {
                        if (apps.getStatus() != 176) {
                            apps.setStatus(176);
                            appsService.saveAppsOne(apps);

                            /**todo ЛОК га ёзиш start todo**/
                            StatusM statusM = statusMService.getByAppId(apps.getId());
                            statusM.setStatus(String.valueOf(176));
                            Status status = new Status();
                            status = statusService.getById(176);
                            statusM.setStatusComment(status.getName());
                            statusM.setInsUser("auto");
                            statusMService.saveStatusM(statusM);

                            StatusH statusH = new StatusH();
                            statusH.setStmainID(statusM.getId());
                            statusH.setAppId(statusM.getAppId());
                            statusH.setStatus(String.valueOf(176));
                            statusH.setStatusComment(status.getName());
                            statusH.setInsUser("auto");
                            statusH.setComment("Дастлабки қарорни амал қилиш муддати тугади");
                            statusHService.saveStatusH(statusH);
                            /**todo ЛОК га ёзиш end todo**/
                        }
                    }
                }
            }
            System.out.println("shceduler is running!");
        }catch (Exception ee){
            System.out.println("error");
        }

    }


//
//    @Scheduled(cron = "0 0 3 * * *")
//    public void scheduleTaskUsingCronExpressionForAppsClear() {
//        try {
//            Apps apps = new Apps();
//            List<InDec> inDecs = new ArrayList<>();
//            inDecs = inDecRepo.findByEndActiv(100);
//            Commodity commodity = new Commodity();
//
//            Date date = new Date();
//            long dd = date.getTime();
//            for (int i = 0; i < inDecs.size(); i++) {
//                if (inDecs.get(i).getInDecEndDate().getTime() < dd) {
//                    commodity = commodityService.findById(inDecs.get(i).getCmdtId());
//                    apps = appsService.findById(commodity.getAppId());
//                    if (apps != null) {
//                        if (apps.getStatus() != 176) {
//                            apps.setStatus(176);
//                            appsService.saveAppsOne(apps);
//
//                            /**todo ЛОК га ёзиш start todo**/
//                            StatusM statusM = statusMService.getByAppId(apps.getId());
//                            statusM.setStatus(String.valueOf(176));
//                            Status status = new Status();
//                            status = statusService.getById(176);
//                            statusM.setStatusComment(status.getName());
//                            statusM.setInsUser("auto");
//                            statusMService.saveStatusM(statusM);
//
//                            StatusH statusH = new StatusH();
//                            statusH.setStmainID(statusM.getId());
//                            statusH.setAppId(statusM.getAppId());
//                            statusH.setStatus(String.valueOf(176));
//                            statusH.setStatusComment(status.getName());
//                            statusH.setInsUser("auto");
//                            statusH.setComment("Дастлабки қарорни амал қилиш муддати тугади");
//                            statusHService.saveStatusH(statusH);
//                            /**todo ЛОК га ёзиш end todo**/
//                        }
//                    }
//                }
//            }
//            System.out.println("shceduler is running!");
//        }catch (Exception ee){
//            System.out.println("error");
//        }
//
//    }

}

//    @Scheduled(fixedDelay = 1000)
//    public void scheduleFixedDelayTask() {
//        System.out.println(
//                "Fixed delay task - " + System.currentTimeMillis() / 1000);}