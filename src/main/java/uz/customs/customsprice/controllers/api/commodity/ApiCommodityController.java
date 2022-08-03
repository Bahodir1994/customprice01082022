package uz.customs.customsprice.controllers.api.commodity;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.customs.customsprice.controllers.api.files.CommodityDTO;
import uz.customs.customsprice.controllers.api.helper.ResponseHandler;
import uz.customs.customsprice.entity.InitialDecision.*;
import uz.customs.customsprice.entity.users.User;
import uz.customs.customsprice.repository.AppsRaspRepo;
import uz.customs.customsprice.repository.CommodityRepo;
import uz.customs.customsprice.repository.CurrencyEntityRepo;
import uz.customs.customsprice.service.*;
import uz.customs.customsprice.service.apps.AppsRaspService;
import uz.customs.customsprice.service.apps.AppsService;
import uz.customs.customsprice.service.catalog.ConturyService;
import uz.customs.customsprice.service.catalog.MethodService;
import uz.customs.customsprice.service.catalog.Tnved2Service;
import uz.customs.customsprice.service.classifier.PackagingService;
import uz.customs.customsprice.service.commodity.CommodityService;
import uz.customs.customsprice.service.status.StatusHService;
import uz.customs.customsprice.service.status.StatusMService;
import uz.customs.customsprice.service.status.StatusService;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/commodityrestapi")
public class ApiCommodityController {

    private final AppsService appsService;
    private final CommodityService commodityService;
    private final ConturyService conturyService;
    private final MethodService methodService;
    private final PackagingService packagingService;
    private final Tnved2Service tnved2Service;
    private final CurrencyEntityRepo currencyEntityRepo;
    private final CommodityRepo commodityRepo;
    private final StatusService statusService;
    private final StatusHService statusHService;
    private final StatusMService statusMService;
    private final UsersService usersService;
    private final AppsRaspService appsRaspService;
    private final AppsRaspRepo appsRaspRepo;


    public ApiCommodityController(AppsService appsService, CommodityService commodityService, ConturyService conturyService, MethodService methodService, PackagingService packagingService, Tnved2Service tnved2Service, CurrencyEntityRepo currencyEntityRepo, CommodityRepo commodityRepo, StatusService statusService, StatusHService statusHService, StatusMService statusMService, UsersService usersService, AppsRaspService appsRaspService, AppsRaspRepo appsRaspRepo) {
        this.appsService = appsService;
        this.commodityService = commodityService;
        this.conturyService = conturyService;
        this.methodService = methodService;
        this.packagingService = packagingService;
        this.tnved2Service = tnved2Service;
        this.currencyEntityRepo = currencyEntityRepo;
        this.commodityRepo = commodityRepo;
        this.statusService = statusService;
        this.statusHService = statusHService;
        this.statusMService = statusMService;
        this.usersService = usersService;
        this.appsRaspService = appsRaspService;
        this.appsRaspRepo = appsRaspRepo;
    }


    @PostMapping()
    public ResponseEntity<Object> valuesave(@RequestBody @Valid CommodityDTO commodityDTO, BindingResult br) {
        Map<String, String> errors = new HashMap<>();
        if (br.hasErrors()) {
            errors = br.getFieldErrors().stream().collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
            errors.put("message", "Error");
            errors.put("status", "400");
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }
        else {
            try {
                List<Commodity> commodity = commodityDTO.getCommodity();
                Optional<Apps> appIdGet = Optional.ofNullable(appsService.findById(commodity.get(1).getAppId()));
                Apps apps = appsService.findById(commodity.get(1).getAppId());
                if (appIdGet.isPresent())
                {
                    for (int i = 0; i < commodity.size(); i++) {
                        Country country = conturyService.getByCodeAndLngaTpcd(commodity.get(i).getOriginCountry(), "UZ");
                        commodity.get(i).setOrignCountrNm(country.getCdNm());

                        Method method = methodService.getById(commodity.get(i).getMethod());
                        commodity.get(i).setMethodNm(method.getName());

                        Packaging packaging = packagingService.getByIdAndLngaTpcd(commodity.get(i).getPackType(), "UZ");
                        commodity.get(i).setPackTypeNm(packaging.getCdNm());

                        Tnved2 tnved2 = tnved2Service.getByIdAndFinishdate(commodity.get(i).getHsCode());
                        commodity.get(i).setHsName(tnved2.getName());

                        CurrencyEntity currencyEntity = currencyEntityRepo.findByCodeAndLngaTpcd(commodity.get(i).getCurrencyType(), "RU");
                        commodity.get(i).setCurrencyNm(currencyEntity.getCdDesc());
                        commodity.get(i).setCurrencyNmSymbol(currencyEntity.getCdId());

                        if (commodity.get(i).getHsDecDate() != null && !"".equals(String.valueOf(commodity.get(i).getHsDecDate())) && !"null".equals(String.valueOf(commodity.get(i).getHsDecDate())))
                            commodity.get(i).setHsDecDate(commodity.get(i).getHsDecDate());
                        if (commodity.get(i).getInDecDate() != null && !"".equals(String.valueOf(commodity.get(i).getInDecDate())) && !"null".equals(String.valueOf(commodity.get(i).getInDecDate())))
                            commodity.get(i).setInDecDate(commodity.get(i).getInDecDate());
                        if (commodity.get(i).getInDecNum() != null && !"".equals(commodity.get(i).getInDecNum()) && !"null".equals(commodity.get(i).getInDecNum()))
                            commodity.get(i).setInDecNum(commodity.get(i).getInDecNum());
                        if (commodity.get(i).getExtraUnits() != null && !"".equals(commodity.get(i).getExtraUnits()) && !"null".equals(commodity.get(i).getExtraUnits()))
                            commodity.get(i).setExtraUnits(commodity.get(i).getExtraUnits());
                        commodityService.saveCommodity(commodity.get(i));
                    }

                    apps.setStatus(100);
                    Status status = statusService.getById(100);
                    apps.setStatusNm(status.getName());
                    appsService.saveAppsOne(apps);

                    String locationRasp = "";
                    locationRasp = apps.getLocationId();
                    String usePost = locationRasp.substring(2, 4);
                    List<User> usersList = new ArrayList<>();
                    usersList = usersService.getByLocationAndPostAndRole(locationRasp, (usePost+"_"+"08"), 8);
                    int min = 100000;
                    String inspID="";
                    String inspNm="";
                    for (int i = 0; i < usersList.size(); i++) {
                        List<AppsRasp> appsRasp = new ArrayList<>();

                        String idIs = usersList.get(i).getUserid();
                        appsRasp = appsRaspService.findByInspectorId(idIs);
                        int aaa = 0;
                        if(appsRasp != null){
                            aaa = appsRasp.size();
                        }
                        if(min>aaa){
                            min=appsRasp.size();
                            inspID = usersList.get(i).getUserid();
                            inspNm = usersList.get(i).getFullname();
                        }
                    }

                    /**todo ЛОК га ёзиш start todo**/
                    StatusM statusM = new StatusM();
                    statusM.setAppId(apps.getId());
                    statusM.setStatus(String.valueOf(apps.getStatus()));
                    statusM.setStatusComment(apps.getStatusNm());
                    statusM.setInsUser(apps.getPersonTin());
                    statusMService.saveStatusM(statusM);

                    StatusH statusH = new StatusH();
                    statusH.setStmainID(statusM.getId());
                    statusH.setAppId(statusM.getAppId());
                    statusH.setStatus(String.valueOf(apps.getStatus()));
                    statusH.setStatusComment(apps.getStatusNm());
                    statusH.setInsUser(apps.getPersonTin());
                    statusHService.saveStatusH(statusH);
                    /**todo ЛОК га ёзиш end todo**/

                    /**Auto Rasp**/
                    Optional<Apps> apps1 = Optional.ofNullable(appsService.findById(commodity.get(1).getAppId()));
                    Apps apps2 = appsService.getTop1ByAppNumOrderByInsTimeAsc(apps1.get().getAppNum());

                    AppsRasp appsRasp = appsRaspService.findByAppsId(apps2.getId());
                    if (appsRasp != null){
                        inspID = appsRasp.getInspectorId();
                        inspNm = appsRasp.getInspectorName();
                    }

                    AppsRasp appsRaspS = new AppsRasp();
                    appsRaspS.setAppId(apps.getId());
                    appsRaspS.setInsUser("auto");
                    appsRaspS.setInspectorId(inspID);
                    appsRaspS.setInspectorName(inspNm);
                    appsRaspS.setLocation(locationRasp);
                    appsRaspS.setPost(usePost+"_"+"08");
                    appsRaspService.saveRasp(appsRaspS);

                    Apps app = appsService.findById(apps.getId());
                    Status statusS = statusService.getById(110);
                    app.setStatus(110);
                    app.setStatusNm(statusS.getName());
                    appsService.saveAppsStatus(app);

                    /**todo ЛОК га ёзиш start todo**/
                    statusM.setAppId(app.getId());
                    statusM.setStatus(String.valueOf(app.getStatus()));
                    statusM.setStatusComment(app.getStatusNm());
                    statusM.setInsUser("auto");
                    statusMService.saveStatusM(statusM);

                    statusH.setStmainID(statusM.getId());
                    statusH.setAppId(statusM.getAppId());
                    statusH.setStatus(String.valueOf(app.getStatus()));
                    statusH.setStatusComment(app.getStatusNm());
                    statusH.setInsUser("auto");
                    statusH.setSortedInsId(inspID);
                    statusH.setSortedInsNm(inspNm);
                    statusHService.saveStatusH(statusH);
                    /**todo ЛОК га ёзиш end todo**/

                    return ResponseHandler.generateResponse("Commodity ma`lumotlari saqlandi!", HttpStatus.OK, commodity);
                }
                else {
                    JSONObject obj = new JSONObject();
                    obj.put("message", "Error");
                    obj.put("appId", "Топилмади!");
                    obj.put("status", "400");
                    return new ResponseEntity<>(obj.toMap(), HttpStatus.OK);
                }
            }catch (Exception ee){return null;}

        }
    }
}
