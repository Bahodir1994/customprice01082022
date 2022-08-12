package uz.customs.customsprice.controllers.indec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import uz.customs.customsprice.controllers.indec.DTO.FilterDTO;
import uz.customs.customsprice.entity.InDec;
import uz.customs.customsprice.entity.InitialDecision.*;
import uz.customs.customsprice.entity.earxiv.Earxiv;
import uz.customs.customsprice.entity.users.User;
import uz.customs.customsprice.repository.*;
import uz.customs.customsprice.service.*;
import uz.customs.customsprice.service.apps.AppsRaspService;
import uz.customs.customsprice.service.apps.AppsService;
import uz.customs.customsprice.service.apps.RollBackAppService;
import uz.customs.customsprice.service.apps.RollbackSpService;
import uz.customs.customsprice.service.catalog.ConturyService;
import uz.customs.customsprice.service.catalog.LocationService;
import uz.customs.customsprice.service.catalog.TermsService;
import uz.customs.customsprice.service.catalog.TransportTypeService;
import uz.customs.customsprice.service.commodity.CommodityService;
import uz.customs.customsprice.service.earxiv.EarxivService;
import uz.customs.customsprice.service.payment.PaymentServise;
import uz.customs.customsprice.service.status.StatusHService;
import uz.customs.customsprice.service.status.StatusMService;
import uz.customs.customsprice.service.status.StatusService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/apps")
public class AppsController {
    private final AppsService appsService;
    private final ConturyService conturyService;
    private final LocationService locationService;
    private final StatusService statusService;
    private final TermsService termsService;
    private final AppsService appsservice;
    private final AppsRaspService appsRaspService;
    private final AppsRepo appsRepo;
    private final TransportTypeService transportTypeService;
    private final StatusMService statusMService;
    private final StatusHService statusHService;
    private final StatusHRepo statusHRepo;
    private final RollBackAppService rollBackAppService;
    private final RollbackSpService rollbackSpService;
    private final RollBackAppRepo rollBackAppRepo;
    private final UserRepository userRepository;
    private final InDecService inDecService;
    private final UsersService usersService;
    private final CommodityService commodityService;
    private final EarxivService earxivService;
    private final PaymentServise paymentServise;

    @Autowired
    InDecRepo inDecRepo;

    @Autowired
    EarxivRepo earxivRepo;

    private final String INITIALDECISION = "/resources/pages/InitialDecision/InitialDecision1";
    private final String INITIALDECISIONRASP = "/resources/pages/InitialDecision/InitialDecisionRasp";
    private final String INITIALDECISIONVIEW = "/resources/pages/InitialDecision/InitialDecisionView";
    private final String INITIALDECISIONSAVERASP = "/resources/pages/InitialDecision/InitialDecisionRasp1";
    private final String INITIALDECISIONROLLBACK = "/resources/pages/InitialDecision/InitialDecisionRollBack";
    private final String INITIAL_DECISION_APP = "/resources/pages/InitialDecision/ListInDec";
    private final String INITIAL_DECISION_NOT_SORTED = "/resources/pages/InitialDecision/ListInDec/ListInDecTable";
    private final String INITIAL_DECISION_NOT_SORTEDS = "/resources/pages/InitialDecision/ListInDec/ListInDecTableAJAX";
    private final String DOUBLE_ROLLBACKP_PROJECT = "/resources/pages/InitialDecision/ListInDec/doubleRollBackProject";
    private final String SAVE_DOUBLE_ROLLBACKP_PROJECT = "/resources/pages/InitialDecision/ListInDec/saveDoubleRollBackProject";
    private final String APPS_STATUS_HISTORY_MODAL = "/resources/pages/InitialDecision/AppsHistoryModal";
    private final String INITIAL_DECISION_RASP_TABLE = "/resources/pages/InitialDecision/ListInDec/ListInDecRasp";
    private final String INITIAL_DECISION_TERMS_TABLE = "/resources/pages/InitialDecision/ListInDec/ListInDecTermsTable";
    private final String INITIAL_DECISION_TERMS_ROLLBACK = "/resources/pages/InitialDecision/ListInDec/ListInDecTermsRollBack";
    private final String INITIAL_DECISION_PROCESS = "/resources/pages/InitialDecision/ListInDec/ListInDecProcessApp";
    private final String INITIAL_DECISION_SUBMITTED = "/resources/pages/InitialDecision/ListInDec/ListInDecSubmittedApp";
    private final String INITIAL_DECISION_SIGNED = "/resources/pages/InitialDecision/ListInDec/ListInDecSignedApp";
    private final String INITIAL_DECISION_APP_RETURNED = "/resources/pages/InitialDecision/ListInDec/ListAppReturned";

    public AppsController(AppsService appsService, ConturyService conturyService, LocationService locationService, StatusService statusService, TermsService termsService, AppsService appsservice, AppsRaspService appsRaspService, AppsRepo appsRepo, TransportTypeService transportTypeService, StatusMService statusMService, StatusHService statusHService, StatusHRepo statusHRepo, RollBackAppService rollBackAppService, RollbackSpService rollbackSpService, RollBackAppRepo rollBackAppRepo, UserRepository userRepository, InDecService inDecService, UsersService usersService, CommodityService commodityService, EarxivService earxivService, PaymentServise paymentServise) {
        this.appsService = appsService;
        this.conturyService = conturyService;
        this.locationService = locationService;
        this.statusService = statusService;
        this.termsService = termsService;
        this.appsservice = appsservice;
        this.appsRaspService = appsRaspService;
        this.appsRepo = appsRepo;
        this.transportTypeService = transportTypeService;
        this.statusMService = statusMService;
        this.statusHService = statusHService;
        this.statusHRepo = statusHRepo;
        this.rollBackAppService = rollBackAppService;
        this.rollbackSpService = rollbackSpService;
        this.rollBackAppRepo = rollBackAppRepo;
        this.userRepository = userRepository;
        this.inDecService = inDecService;
        this.usersService = usersService;
        this.commodityService = commodityService;
        this.earxivService = earxivService;
        this.paymentServise = paymentServise;
    }

    /*todo Тақсимланган аризалар рўйхатини сақлаш (инспекторлар кесимида)*/
    @PostMapping(value = INITIALDECISIONSAVERASP)
    @ResponseBody
    public ModelAndView InitialDecisionViewSave(HttpServletRequest request, @RequestParam String appId, @RequestParam String inspectorId, @RequestParam String inspectorName, @RequestParam String selectedBar, RedirectAttributes redirAttrs) {

        String userId = (String) request.getSession().getAttribute("userId");
        String userName = (String) request.getSession().getAttribute("userName");
        Integer userRole = (Integer) request.getSession().getAttribute("userRole");
        String userRoleName = (String) request.getSession().getAttribute("userRoleName");
        String userLocation = (String) request.getSession().getAttribute("userLocation");
        String userLocationName = (String) request.getSession().getAttribute("userLocationName");
        String userPost = (String) request.getSession().getAttribute("userPost");
        String userIdS = (String) request.getSession().getAttribute("userIdS");

        if (!Objects.equals(inspectorId, "notSelected") && !Objects.equals(inspectorId, "") && inspectorId != null) {
            AppsRasp appsRasp = new AppsRasp();
            appsRasp = appsRaspService.findByAppsId(appId);
            if (appsRasp != null){
                appsRasp = appsRaspService.findByAppsId(appId);
            }else {
                appsRasp = new AppsRasp();
            }

            appsRasp.setAppId(appId);
            appsRasp.setInsUser(userId);
            appsRasp.setInspectorId(inspectorId);
            appsRasp.setInspectorName(inspectorName);
            appsRasp.setLocation(userLocation);
            appsRasp.setPost(userPost);
            appsRaspService.saveRasp(appsRasp);

            Apps app = appsservice.findById(appId);
            Status status = statusService.getById(111);
            app.setStatus(111);
            app.setStatusNm(status.getName());
            appsservice.saveAppsStatus(app);

            /**todo ЛОК га ёзиш start todo**/
            StatusM statusM = statusMService.getByAppId(appId);
            statusM.setAppId(app.getId());
            statusM.setStatus(String.valueOf(app.getStatus()));
            statusM.setStatusComment(app.getStatusNm());
            statusM.setInsUser(userId);
            statusMService.saveStatusM(statusM);

            StatusH statusH = new StatusH();
            statusH.setStmainID(statusM.getId());
            statusH.setAppId(statusM.getAppId());
            statusH.setStatus(String.valueOf(app.getStatus()));
            statusH.setStatusComment(app.getStatusNm());
            statusH.setInsUser(userId);
            statusH.setSortedInsId(inspectorId);
            statusH.setSortedInsNm(inspectorName);
            statusHService.saveStatusH(statusH);
            /**todo ЛОК га ёзиш end todo**/

        }


        ModelAndView mav = new ModelAndView("resources/pages/InitialDecision/ListInDec");
        List<Apps> notSortedList = appsservice.getListNotSorted(request, userLocation, userPost, userId, userRole);
        mav.addObject("notSortedListSize", notSortedList.size());


        mav.addObject("selectedBarVal", selectedBar);

        return mav;
    }

    /*todo Аризалар рўйхати(дастлабки)*/
    @PostMapping(value = INITIALDECISIONRASP)
    @ResponseBody
    public ModelAndView InitialDecisionRasp(HttpServletRequest request, @RequestParam(name = "id") String id, @RequestParam String status) {
        ModelAndView mav = new ModelAndView("resources/pages/InitialDecision/InitialDecisionRasp");
        String userId = (String) request.getSession().getAttribute("userId");
        String userName = (String) request.getSession().getAttribute("userName");
        Integer userRole = (Integer) request.getSession().getAttribute("userRole");
        String userRoleName = (String) request.getSession().getAttribute("userRoleName");
        String userLocation = (String) request.getSession().getAttribute("userLocation");
        String userLocationName = (String) request.getSession().getAttribute("userLocationName");
        String userPost = (String) request.getSession().getAttribute("userPost");

        List<Apps> notSortedList = new ArrayList<>();
        notSortedList = appsservice.getListNotSorted(request, userLocation, userPost, userId, userRole);
        mav.addObject("notSortedList", notSortedList);

        List<Apps> sortedList = new ArrayList<>();
        sortedList = appsservice.getListSorted(request);
        mav.addObject("sortedList", sortedList);

        List<InDec> termsList = new ArrayList<>();
        termsList = appsservice.getListInDec(request);
        mav.addObject("termsList", termsList);

//        List<Users> usersList = new ArrayList<>();
//        usersList = usersService.getByLocationAndPostAndRole(userLocation, userPost, 8);
//        mav.addObject("userSelectList", usersList);

        return mav;
    }

    /*todo Қайтарилган аризалар рўйхати (тузатиш учун қайтарилган ёки тўлиқ қайтарилган) */
    @PostMapping(value = INITIAL_DECISION_APP_RETURNED)
    @ResponseBody
    public ModelAndView ListAppReturned(HttpServletRequest request, @RequestParam(name = "id") String status) {
        ModelAndView mav = new ModelAndView("resources/pages/InitialDecision/ListInDec/ListInDecRasp");
        String userId = (String) request.getSession().getAttribute("userId");
        String userName = (String) request.getSession().getAttribute("userName");
        Integer userRole = (Integer) request.getSession().getAttribute("userRole");
        String userRoleName = (String) request.getSession().getAttribute("userRoleName");
        String userLocation = (String) request.getSession().getAttribute("userLocation");
        String userLocationName = (String) request.getSession().getAttribute("userLocationName");
        String userPost = (String) request.getSession().getAttribute("userPost");

//        List<Apps> sortedList = new ArrayList<>();
//        sortedList = appsservice.getListSorted(request);
//        mav.addObject("sortedList", sortedList);

        List<Apps> listAppReturned = appsservice.getListAppReturned(request, status);
//        mav.addObject("listAppReturned", listAppReturned);
        mav.addObject("sortedList", listAppReturned);
        mav.addObject("status", status);

        return mav;
    }

    @PostMapping(value = INITIALDECISION)
    @ResponseBody
    public ModelAndView InitialDecision(HttpServletRequest request) {

        String userId = (String) request.getSession().getAttribute("userId");
        String userLocation = (String) request.getSession().getAttribute("userLocation");
        String userPost = (String) request.getSession().getAttribute("userPost");

        ModelAndView mav = new ModelAndView("resources/pages/InitialDecision/InitialDecision");
        List<Apps> arizalar = appsservice.getlistAllIsp(userId);
        mav.addObject("appsForInspector", arizalar);
        return mav;
    }

    @PostMapping(value = INITIALDECISIONVIEW)
    @ResponseBody
    public ModelAndView InitialDecisionView(HttpSession session, HttpServletRequest request, @RequestParam String appId) {
        ModelAndView mav = new ModelAndView("resources/pages/InitialDecision/InitialDecisionView");

        Integer userRole = (Integer) request.getSession().getAttribute("userRole");
        String userId = (String) request.getSession().getAttribute("userId");
        Apps apps = appsservice.findById(appId);

        List<Earxiv> earxivList = new ArrayList<>();
        earxivList = earxivRepo.findByAppId(appId);

        if (userRole == 8 && (apps.getStatus() == 110 || apps.getStatus() == 135 || apps.getStatus() == 111 || apps.getStatus() == 118) ) {
            Status status = statusService.getById(115);
            apps.setStatus(status.getId());
            apps.setStatusNm(status.getName());
            appsservice.saveAppsStatus(apps);

            /**todo ЛОК га ёзиш start todo**/
            StatusM statusM = statusMService.getByAppId(appId);
            statusM.setAppId(apps.getId());
            statusM.setStatus(String.valueOf(apps.getStatus()));
            statusM.setStatusComment(apps.getStatusNm());
            statusM.setInsUser(userId);
            statusMService.saveStatusM(statusM);

            StatusH statusH = new StatusH();
            statusH.setStmainID(statusM.getId());
            statusH.setAppId(statusM.getAppId());
            statusH.setStatus(String.valueOf(apps.getStatus()));
            statusH.setStatusComment(apps.getStatusNm());
            statusH.setInsUser(userId);
            statusHService.saveStatusH(statusH);
            /**todo ЛОК га ёзиш end todo**/

        }
        List<String> first = new ArrayList<String>();
        first.add("1");
        first.add("2");
        first.add("3");
        first.add("4");
        List<String> second = new ArrayList<String>();
        second.add("5");
        second.add("6");

        mav.addObject("earxivList", earxivList);
        mav.addObject("appId", appId);
        mav.addObject("appStatus", apps.getStatus());
        mav.addObject("userRole", userRole);

        List<Apps> InitialDecisionViewApp = appsservice.getInitialDecisionView(appId);
        mav.addObject("appInfo", InitialDecisionViewApp);

        List<Commodity> getInitialDecisionViewCommodity = appsservice.getInitialDecisionViewCommodity(appId);
        mav.addObject("allCommodityFor", getInitialDecisionViewCommodity);

        List<TransportType> getInDecViewTrType = transportTypeService.getByAppId(appId);
        mav.addObject("transports", getInDecViewTrType);

        List<RollbackSp> listRollbackSpFirst = rollbackSpService.getlistRollbackSpFirstSecond(first);
        mav.addObject("rollbackInfoForFirst", listRollbackSpFirst);

        List<RollbackSp> listRollbackSpSecond = rollbackSpService.getlistRollbackSpFirstSecond(second);
        mav.addObject("rollbackInfoForSecond", listRollbackSpSecond);

        int Sizes = getInitialDecisionViewCommodity.size();
        mav.addObject("cmdtIdFirst", getInitialDecisionViewCommodity.get(0).getId());

        return mav;
    }

    @PostMapping(value = INITIALDECISIONROLLBACK)
    @ResponseBody
    public ResponseEntity<Object> InitialDecisionRollBack(@RequestBody RollbackSaveDTO rollbackSaveDTO, HttpServletRequest request) {

        String userId = (String) request.getSession().getAttribute("userId");
        String userName = (String) request.getSession().getAttribute("userName");
        Integer userRole = (Integer) request.getSession().getAttribute("userRole");
        String userRoleName = (String) request.getSession().getAttribute("userRoleName");
        String userLocation = (String) request.getSession().getAttribute("userLocation");
        String userLocationName = (String) request.getSession().getAttribute("userLocationName");
        String userPost = (String) request.getSession().getAttribute("userPost");

        try {
            Apps app = appsservice.findById(rollbackSaveDTO.getAppId());
            int statusApp = 0;
            if (Objects.equals(rollbackSaveDTO.getCorrection(), "true")){
                List<String> firstIds = new ArrayList<String>();
                firstIds.add(rollbackSaveDTO.getId1());
                firstIds.add(rollbackSaveDTO.getId2());
                firstIds.add(rollbackSaveDTO.getId3());
                firstIds.add(rollbackSaveDTO.getId4());
                statusApp = 125;
                Status status = statusService.getById(statusApp);
                app.setStatus(statusApp);
                app.setStatusNm(status.getName());
                app.setComment(rollbackSaveDTO.getTextareaFor1());
                appsservice.saveAppsStatus(app);

                /**todo ЛОК га ёзиш start todo**/
                StatusM statusM = statusMService.getByAppId(rollbackSaveDTO.getAppId());
                statusM.setAppId(app.getId());
                statusM.setStatus(String.valueOf(app.getStatus()));
                statusM.setStatusComment(app.getStatusNm());
                statusM.setInsUser(userId);
                statusMService.saveStatusM(statusM);

                StatusH statusH = new StatusH();
                statusH.setStmainID(statusM.getId());
                statusH.setAppId(statusM.getAppId());
                statusH.setStatus(String.valueOf(app.getStatus()));
                statusH.setStatusComment(app.getStatusNm());
                statusH.setInsUser(userId);
                statusH.setComment(rollbackSaveDTO.getTextareaFor1());
                statusHService.saveStatusH(statusH);
                /**todo ЛОК га ёзиш end todo**/
                for (int i = 0; i < firstIds.size(); i++) {
                    if (!Objects.equals(firstIds.get(i), "") && firstIds.get(i) != null && !Objects.equals(firstIds.get(i), "null")){
                        RollBackApp rollBackApp = new RollBackApp();
                        rollBackApp.setAppId(rollbackSaveDTO.getAppId());
                        rollBackApp.setStatusHId(statusH.getId());
                        rollBackApp.setInsUser(userId);
                        rollBackApp.setRollbackId(firstIds.get(i));
                        Optional<RollbackSp> rollbackSp = rollbackSpService.getById(firstIds.get(i));
                        rollBackApp.setRollbackName(rollbackSp.get().getRollbackName());
                        rollBackAppService.saveRollBack(rollBackApp);
                    }
                }
            }
            if (Objects.equals(rollbackSaveDTO.getEntirely(), "true")){
                List<String> secondIds = new ArrayList<String>();
                secondIds.add(rollbackSaveDTO.getId5());
                secondIds.add(rollbackSaveDTO.getId6());
                statusApp = 116;
                Status status = statusService.getById(statusApp);
                app.setStatus(statusApp);
                app.setStatusNm(status.getName());
                app.setComment(rollbackSaveDTO.getTextareaFor2());
                appsservice.saveAppsStatus(app);

                /**todo ЛОК га ёзиш start todo**/
                StatusM statusM = statusMService.getByAppId(rollbackSaveDTO.getAppId());
                statusM.setAppId(app.getId());
                statusM.setStatus(String.valueOf(app.getStatus()));
                statusM.setStatusComment(app.getStatusNm());
                statusM.setInsUser(userId);
                statusMService.saveStatusM(statusM);

                StatusH statusH = new StatusH();
                statusH.setStmainID(statusM.getId());
                statusH.setAppId(statusM.getAppId());
                statusH.setStatus(String.valueOf(app.getStatus()));
                statusH.setStatusComment(app.getStatusNm());
                statusH.setInsUser(userId);
                statusH.setComment(rollbackSaveDTO.getTextareaFor2());
                statusHService.saveStatusH(statusH);
                /**todo ЛОК га ёзиш end todo**/

                for (int i = 0; i < secondIds.size(); i++) {
                    if (!Objects.equals(secondIds.get(i), "") && secondIds.get(i) != null && !Objects.equals(secondIds.get(i), "null")){
                        RollBackApp rollBackApp = new RollBackApp();
                        rollBackApp.setAppId(rollbackSaveDTO.getAppId());
                        rollBackApp.setStatusHId(statusH.getId());
                        rollBackApp.setInsUser(userId);
                        rollBackApp.setRollbackId(secondIds.get(i));
                        Optional<RollbackSp> rollbackSp = rollbackSpService.getById(secondIds.get(i));
                        rollBackApp.setRollbackName(rollbackSp.get().getRollbackName());
                        rollBackAppService.saveRollBack(rollBackApp);
                    }
                }
            }
            Map<String, Object> stringStringMap = new HashMap<>();
            stringStringMap.put("success", "success");
            return new ResponseEntity<>(stringStringMap, HttpStatus.OK);
        }catch (Exception ee){
            Map<String, Object> stringStringMap = new HashMap<>();
            stringStringMap.put("Error", "Error");
            return new ResponseEntity<>(stringStringMap, HttpStatus.BAD_REQUEST);
        }
    }

    /*todo Аризалар рўйхати(дастлабки)*/
    @PostMapping(value = INITIAL_DECISION_APP)
    @ResponseBody
    public ModelAndView InitialDecisionApp(
            @RequestParam(required = false)String selectedBar,
            HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("resources/pages/InitialDecision/ListInDec");
        String userId = (String) request.getSession().getAttribute("userId");
        String userName = (String) request.getSession().getAttribute("userName");
        Integer userRole = (Integer) request.getSession().getAttribute("userRole");
        String userRoleName = (String) request.getSession().getAttribute("userRoleName");
        String userLocation = (String) request.getSession().getAttribute("userLocation");
        String userLocationName = (String) request.getSession().getAttribute("userLocationName");
        String userPost = (String) request.getSession().getAttribute("userPost");

        List<Apps> listAppReturned = appsservice.getListAppReturned(request, "125");
        mav.addObject("listAppReturnedSize", listAppReturned.size());
        if (Objects.equals(selectedBar, "") || selectedBar == null){
            selectedBar = "yangi";
        }
        mav.addObject("selectedBarVal", selectedBar);
        mav.addObject("userRole", userRole);
        return mav;
    }

    /*todo Аризалар рўйхати(дастлабки)*/
    @PostMapping(value = INITIAL_DECISION_NOT_SORTED)
    @ResponseBody
    public ModelAndView InitialDecisionNotSorted(HttpServletRequest request, @RequestParam(name = "selectedBar") String selectedBar) {

        String userId = (String) request.getSession().getAttribute("userId");
        String userName = (String) request.getSession().getAttribute("userName");
        Integer userRole = (Integer) request.getSession().getAttribute("userRole");
        String userRoleName = (String) request.getSession().getAttribute("userRoleName");
        String userLocation = (String) request.getSession().getAttribute("userLocation");
        String userLocationName = (String) request.getSession().getAttribute("userLocationName");
        String userPost = (String) request.getSession().getAttribute("userPost");

        /**Агар тизимга кирган ходим роли 8(дбсб инспектори) бўлса унга янги мақомдаги аризалар кўринмаслиги керак*/
        /**Сабаби аризалар тақсимланмаган бўлади.*/
        List<Location> locations = locationService.getAll();
        List<Location> locationsOne = Collections.singletonList(locationService.getById(userLocation));
        List<Country> countries = conturyService.getAllByLngaTpcd("UZ");
        ModelAndView mav = null;
        List<Integer> statusGet = new ArrayList<Integer>();
        List<Status> statuses = new ArrayList<Status>();
        if (Objects.equals(selectedBar, "yangi")){
            mav = new ModelAndView("resources/pages/InitialDecision/ListInDec/ListInDecTable");
            if (userRole == 7) {
                statusGet.add(100);
                statusGet.add(101);
                statusGet.add(110);
                statusGet.add(111);
                statusGet.add(115);
                statusGet.add(116);
                statusGet.add(117);
                statusGet.add(118);
                statusGet.add(135);
                statusGet.add(150);
                statusGet.add(165);
            }else {
                statusGet.add(100);
                statusGet.add(101);
                statusGet.add(110);
                statusGet.add(111);
            }
            statuses = statusService.findByIdIn(statusGet);
        }
        if (Objects.equals(selectedBar, "koribChiqilmoqda") || Objects.equals(selectedBar, "radEtilganlar") || Objects.equals(selectedBar, "raxbariyatda")){
            mav = new ModelAndView("resources/pages/InitialDecision/ListInDec/ListInDecTableSecond");
            if(Objects.equals(selectedBar, "koribChiqilmoqda")){
                statusGet.add(115);
                statusGet.add(116);
                statusGet.add(118);
                statusGet.add(135);
                statusGet.add(145);
                statusGet.add(150);
                statuses = statusService.findByIdIn(statusGet);
            }
            if(Objects.equals(selectedBar, "radEtilganlar")){
                statusGet.add(120);
                statusGet.add(125);
                statuses = statusService.findByIdIn(statusGet);
            }
            if(Objects.equals(selectedBar, "raxbariyatda")){
                statusGet.add(117);
                statusGet.add(160);
                statusGet.add(165);
                statuses = statusService.findByIdIn(statusGet);
            }
        }
        if (Objects.equals(selectedBar, "qabulQilinganDastlabkiQaror") || Objects.equals(selectedBar, "bekorQilinganDastlabkiQaror")){
            mav = new ModelAndView("resources/pages/InitialDecision/ListInDec/ListInDecTableThird");
            if (Objects.equals(selectedBar, "qabulQilinganDastlabkiQaror")){
                statusGet.add(170);
                statusGet.add(172);
                statuses = statusService.findByIdIn(statusGet);
            }
            if (Objects.equals(selectedBar, "bekorQilinganDastlabkiQaror")){
                statusGet.add(171);
                statusGet.add(176);
                statusGet.add(195);
                statuses = statusService.findByIdIn(statusGet);
            }
        }

        mav.addObject("userRole", userRole);
        mav.addObject("selectedBar", selectedBar);
        mav.addObject("countries", countries);
        mav.addObject("statusGets", statuses);
        if(Objects.equals(userLocation, "1701") || Objects.equals(selectedBar, "qabulQilinganDastlabkiQaror") || Objects.equals(selectedBar, "bekorQilinganDastlabkiQaror")) {
            mav.addObject("locations", locations);
        }
        else{mav.addObject("locations", locationsOne);}

        return mav;
    }

    @PostMapping(value = APPS_STATUS_HISTORY_MODAL)
    public ResponseEntity<Object> findByAppIdToStatusHistoryAndRollback(@RequestBody FilterDTO filterDTO, HttpServletRequest request){
        List<StatusH> statusH = new ArrayList<StatusH>();
        try {
            statusH = statusHService.sfsdgtbgjk(filterDTO.getAppIdForHistory());
            statusH.removeAll(Collections.singleton(null));
            Map<String, Object> response = new HashMap<>();
            response.put("statusH", statusH);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = INITIAL_DECISION_NOT_SORTEDS)
    public ResponseEntity<Object> findByStatusAndLocationIdAndAppDateBetween(@RequestBody FilterDTO filterDTO, HttpServletRequest request) {
        String userId = (String) request.getSession().getAttribute("userId");
        String userName = (String) request.getSession().getAttribute("userName");
        Integer userRole = (Integer) request.getSession().getAttribute("userRole");
        String userRoleName = (String) request.getSession().getAttribute("userRoleName");
        String userLocation = (String) request.getSession().getAttribute("userLocation");
        String userLocationName = (String) request.getSession().getAttribute("userLocationName");
        String userPost = (String) request.getSession().getAttribute("userPost");
        String userPostName = (String) request.getSession().getAttribute("userPostName");
        String userIdS = (String) request.getSession().getAttribute("userIdS");

        List<Location> locations = locationService.getAll();
        List<User> usersList = new ArrayList<>();
        usersList = usersService.getByLocationAndPostAndRole(userLocation, userPost, 8);


        List<Apps> tutorials = new ArrayList<Apps>();
        Pageable paging = PageRequest.of(filterDTO.getPage(), filterDTO.getSize());
        java.sql.Date starts = null, ends = null, inDecStarts = null, inDecEnds = null, inDecEndDateStarts = null, inDecEndDateEnds = null;
        String locationIdChange = "", locationForStatisticBar = "", inspectorIdRasp = "", inspectorIdIs = "";
        Integer statusPay = null;
        List<Integer> statusGet = new ArrayList<Integer>();
        Page<Apps> pageTuts = null;

        if (!Objects.equals(filterDTO.getAppDateStart(), "") && filterDTO.getAppDateStart() != null) {
            starts = java.sql.Date.valueOf(String.format(filterDTO.getAppDateStart(), "YYYY-MM-DD"));
        }
        if (!Objects.equals(filterDTO.getAppDateEnd(), "") && filterDTO.getAppDateEnd() != null) {
            ends = java.sql.Date.valueOf(String.format(filterDTO.getAppDateEnd(), "YYYY-MM-DD"));
        }
        if (!Objects.equals(filterDTO.getInDecStarts(), "") && filterDTO.getInDecStarts() != null) {
            inDecStarts = java.sql.Date.valueOf(String.format(filterDTO.getInDecStarts(), "YYYY-MM-DD"));
        }
        if (!Objects.equals(filterDTO.getInDecEnds(), "") && filterDTO.getInDecEnds() != null) {
            inDecEnds = java.sql.Date.valueOf(String.format(filterDTO.getInDecEnds(), "YYYY-MM-DD"));
        }
        if (!Objects.equals(filterDTO.getInDecEndDateStarts(), "") && filterDTO.getInDecEndDateStarts() != null) {
            inDecEndDateStarts = java.sql.Date.valueOf(String.format(filterDTO.getInDecEndDateStarts(), "YYYY-MM-DD"));
        }
        if (!Objects.equals(filterDTO.getInDecEndDateEnds(), "") && filterDTO.getInDecEndDateEnds() != null) {
            inDecEndDateEnds = java.sql.Date.valueOf(String.format(filterDTO.getInDecEndDateEnds(), "YYYY-MM-DD"));
        }
        if (!Objects.equals(filterDTO.getStatusPay(), "") && filterDTO.getInDecEndDateEnds() != null) {
            statusPay = Integer.valueOf(filterDTO.getStatusPay());
        }
        if (!Objects.equals(userLocation, "1701") && userRole != 9) {
            locationIdChange = userLocation;
            if (userRole != 7 && userRole != 6){
                inspectorIdIs = userIdS;
            }
        } else {
            locationIdChange = filterDTO.getLocationId();
        }

        /*********************************************************************************/
        if (Objects.equals(filterDTO.getSelectedBar(), "qabulQilinganDastlabkiQaror") || Objects.equals(filterDTO.getSelectedBar(), "bekorQilinganDastlabkiQaror")){
            Integer endActivValue = null;
            if (Objects.equals(filterDTO.getSelectedBar(), "bekorQilinganDastlabkiQaror")){
                if (Objects.equals(filterDTO.getStatus(), "")) {
                    statusGet.add(171);
                    statusGet.add(176);
                    statusGet.add(195);
                } else {
                    statusGet.add(Integer.valueOf(filterDTO.getStatus()));
                }
                endActivValue = null;
            }
            /*********************************************************************************/
            if (Objects.equals(filterDTO.getSelectedBar(), "qabulQilinganDastlabkiQaror")){
                if (Objects.equals(filterDTO.getStatus(), "")) {
                    statusGet.add(170);
                    statusGet.add(172);
                } else {
                    statusGet.add(Integer.valueOf(filterDTO.getStatus()));
                }
                endActivValue = 100;
            }
            pageTuts = appsRepo.qwefrads(
                    starts,
                    ends,

                    filterDTO.getAppNum(),
                    filterDTO.getLocationId(),
                    filterDTO.getPersonFio(),
                    statusPay,
                    filterDTO.getInDecNum(),
                    inDecStarts,
                    inDecEnds,
                    filterDTO.getTermsNm(),
                    inDecEndDateStarts,
                    inDecEndDateEnds,
                    statusGet,
                    filterDTO.getSortedInspector(),
//                    endActivValue,
                    paging);
        }
        /*********************************************************************************/
//        if (Objects.equals(filterDTO.getSelectedBar(), "yangi")) {
//            if (Objects.equals(filterDTO.getStatus(), "")) {
//                statusGet.add(100);
//                statusGet.add(101);
//                statusGet.add(110);
//            } else {
//                statusGet.add(Integer.valueOf(filterDTO.getStatus()));
//            }
//            pageTuts = appsRepo.gfhfgthfgt(
//                    starts,
//                    ends,
//                    filterDTO.getAppNum(),
//                    locationIdChange,
//                    filterDTO.getPersonFio(),
//                    filterDTO.getSellerOrg(),
//                    filterDTO.getOrignOrg(),
//                    filterDTO.getSenderOrg(),
//                    statusGet,
//                    paging);
//        }
        else if(Objects.equals(filterDTO.getSelectedBar(), "yangi") ||Objects.equals(filterDTO.getSelectedBar(), "koribChiqilmoqda") || Objects.equals(filterDTO.getSelectedBar(), "radEtilganlar") || Objects.equals(filterDTO.getSelectedBar(), "raxbariyatda")){
            /*********************************************************************************/
            if (Objects.equals(filterDTO.getSelectedBar(), "yangi")){
                if (Objects.equals(filterDTO.getStatus(), "")) {
                    if(userRole == 7) {
                        statusGet.add(100);
                        statusGet.add(101);
                        statusGet.add(110);
                        statusGet.add(111);
                        statusGet.add(115);
                        statusGet.add(116);
                        statusGet.add(117);
                        statusGet.add(118);
                        statusGet.add(135);
                        statusGet.add(150);
                        statusGet.add(165);
                    }else {
                        statusGet.add(100);
                        statusGet.add(101);
                        statusGet.add(110);
                        statusGet.add(111);
                    }
                } else {
                    statusGet.add(Integer.valueOf(filterDTO.getStatus()));
                }
            }
            if (Objects.equals(filterDTO.getSelectedBar(), "koribChiqilmoqda")){
                if (Objects.equals(filterDTO.getStatus(), "")) {
                    statusGet.add(115);
                    statusGet.add(116);
                    statusGet.add(118);
                    statusGet.add(135);
                    statusGet.add(145);
                    statusGet.add(150);
                } else {
                    statusGet.add(Integer.valueOf(filterDTO.getStatus()));
                }
            }
            /*********************************************************************************/
            if (Objects.equals(filterDTO.getSelectedBar(), "radEtilganlar")){
                if (Objects.equals(filterDTO.getStatus(), "")) {
                    statusGet.add(120);
                    statusGet.add(125);
                } else {
                    statusGet.add(Integer.valueOf(filterDTO.getStatus()));
                }
            }
            /*********************************************************************************/
            if (Objects.equals(filterDTO.getSelectedBar(), "raxbariyatda")){
                if (Objects.equals(filterDTO.getStatus(), "")) {
                    statusGet.add(117);
                    statusGet.add(160);
                    statusGet.add(165);
                } else {
                    statusGet.add(Integer.valueOf(filterDTO.getStatus()));
                }
            }
            pageTuts = appsRepo.asdasdsad(
                    starts,
                    ends,
                    filterDTO.getAppNum(),
                    locationIdChange,
                    filterDTO.getPersonFio(),
                    filterDTO.getSellerOrg(),
                    filterDTO.getOrignOrg(),
                    filterDTO.getSenderOrg(),
                    inspectorIdIs,
                    statusGet,
                    filterDTO.getSortedInspector(),
                    paging);
        }
        tutorials = pageTuts.getContent();

        List<Apps> appsStatisticBarFirst = new ArrayList<Apps>();
        List<Apps> appsStatisticBarSecond = new ArrayList<Apps>();
        List<Apps> appsStatisticBarThird = new ArrayList<Apps>();
        List<Apps> appsStatisticBarFourth = new ArrayList<Apps>();
        List<InDec> appsStatisticBarFifth = new ArrayList<InDec>();
        List<InDec> appsStatisticBarSixth = new ArrayList<InDec>();
        if (Objects.equals(userLocation, "1701") || userRole == 9){
            locationForStatisticBar = "";
            inspectorIdRasp = "";
        }
        if(!Objects.equals(userLocation, "1701") && userRole == 8){
            locationForStatisticBar = userLocation;
            inspectorIdRasp = userIdS;
        }else if(!Objects.equals(userLocation, "1701")){
           locationForStatisticBar = userLocation;
           inspectorIdRasp = "";
        }

        List<Integer> statusForStatisticsBarFirst = new ArrayList<Integer>();
        if (userRole == 7){
            statusForStatisticsBarFirst.add(100);
            statusForStatisticsBarFirst.add(101);
            statusForStatisticsBarFirst.add(110);
            statusForStatisticsBarFirst.add(111);
            statusForStatisticsBarFirst.add(115);
            statusForStatisticsBarFirst.add(116);
            statusForStatisticsBarFirst.add(117);
            statusForStatisticsBarFirst.add(118);
            statusForStatisticsBarFirst.add(135);
            statusForStatisticsBarFirst.add(150);
            statusForStatisticsBarFirst.add(165);
        }else {
            statusForStatisticsBarFirst.add(100);
            statusForStatisticsBarFirst.add(101);
            statusForStatisticsBarFirst.add(110);
            statusForStatisticsBarFirst.add(111);
        }
        List<Integer> statusForStatisticsBarSecond = new ArrayList<Integer>();
        statusForStatisticsBarSecond.add(115);
        statusForStatisticsBarSecond.add(116);
        statusForStatisticsBarSecond.add(118);
        statusForStatisticsBarSecond.add(135);
        statusForStatisticsBarSecond.add(145);
        statusForStatisticsBarSecond.add(150);
        List<Integer> statusForStatisticsBarThird = new ArrayList<Integer>();
        statusForStatisticsBarThird.add(120);
        statusForStatisticsBarThird.add(125);
        List<Integer> statusForStatisticsBarFourht = new ArrayList<Integer>();
        statusForStatisticsBarFourht.add(117);
        statusForStatisticsBarFourht.add(160);
        statusForStatisticsBarFourht.add(165);
        List<Integer> statusForStatisticsBarFifth = new ArrayList<Integer>();
        statusForStatisticsBarFifth.add(170);
        statusForStatisticsBarFifth.add(172);
        List<Integer> statusForStatisticsBarSixth = new ArrayList<Integer>();
        statusForStatisticsBarSixth.add(171);
        statusForStatisticsBarSixth.add(176);
        statusForStatisticsBarSixth.add(195);

        String locUni = "";
        appsStatisticBarFirst = appsRepo.second(locationForStatisticBar, inspectorIdRasp, statusForStatisticsBarFirst);
        appsStatisticBarSecond = appsRepo.second(locationForStatisticBar, inspectorIdRasp, statusForStatisticsBarSecond);
        appsStatisticBarThird = appsRepo.thirt(locationForStatisticBar, inspectorIdRasp, statusForStatisticsBarThird);
        appsStatisticBarFourth = appsRepo.fourth(locationForStatisticBar, inspectorIdRasp, statusForStatisticsBarFourht);
        appsStatisticBarFifth = inDecRepo.fifth(locUni, 100, statusForStatisticsBarFifth);
        appsStatisticBarSixth = inDecRepo.sixth(locUni,statusForStatisticsBarSixth);

        Map<String, Object> response = new HashMap<>();
        response.put("tutorials", tutorials);
        response.put("currentPage", pageTuts.getNumber());
        response.put("totalItems", pageTuts.getTotalElements());
        response.put("totalPages", pageTuts.getTotalPages());
        response.put("ItemsSize", pageTuts.getSize());
        response.put("usersList", usersList);
        response.put("userRole", userRole);
        response.put("selectedBar", filterDTO.getSelectedBar());
        response.put("locations", locations);

        response.put("barFirst", appsStatisticBarFirst.size());
        response.put("barSecond", appsStatisticBarSecond.size());
        response.put("barThird", appsStatisticBarThird.size());
        response.put("barFourth", appsStatisticBarFourth.size());
        response.put("barFifth", appsStatisticBarFifth.size());
        response.put("barSixth", appsStatisticBarSixth.size());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value = DOUBLE_ROLLBACKP_PROJECT)
    public ResponseEntity<Object> rollbackFromXbbbAndXbbProjects(@RequestBody FilterDTO filterDTO, HttpServletRequest request){
        String userId = (String) request.getSession().getAttribute("userId");
        String userName = (String) request.getSession().getAttribute("userName");
        Integer userRole = (Integer) request.getSession().getAttribute("userRole");
        String userRoleName = (String) request.getSession().getAttribute("userRoleName");
        String userLocation = (String) request.getSession().getAttribute("userLocation");
        String userLocationName = (String) request.getSession().getAttribute("userLocationName");
        String userPost = (String) request.getSession().getAttribute("userPost");
        String userPostName = (String) request.getSession().getAttribute("userPostName");

        Map<String, Object> objectMap = new HashMap<>();
        Optional<StatusH> statusH = statusHRepo.findById(filterDTO.getStId());
        if (Objects.equals(statusH.get().getStatus(), "116")){

            StatusM statusM = statusMService.getByAppId(statusH.get().getAppId());
            StatusH statusH2 = statusHService.getTop1ByAppIdAndStatus(statusH.get().getAppId(), "116");

            if (statusM != null && Objects.equals(statusM.getStatus(), "116") && userRole == 7){
                List<RollBackApp> rollBackApp = new ArrayList<>();
                rollBackApp = rollBackAppService.getByStatusHId(filterDTO.getStId());
                objectMap.put("rollBackApp", rollBackApp);
                    if (Objects.equals(statusH2.getId(), filterDTO.getStId())){
                    objectMap.put("statusWork", "116");
                    }else{
                    objectMap.put("statusWork", "none");
                }
                objectMap.put("indexing", filterDTO.getIndex());
                objectMap.put("stId", filterDTO.getStId());
                return new ResponseEntity<>(objectMap, HttpStatus.OK);
            }else {
                List<RollBackApp> rollBackApp = new ArrayList<>();
                rollBackApp = rollBackAppService.getByStatusHId(filterDTO.getStId());
                objectMap.put("rollBackApp", rollBackApp);
                objectMap.put("statusWork", "none");
                objectMap.put("indexing", filterDTO.getIndex());
                objectMap.put("stId", filterDTO.getStId());
                return new ResponseEntity<>(objectMap, HttpStatus.OK);
            }
        }
        if (Objects.equals(statusH.get().getStatus(), "117")) {
            StatusM statusM = statusMService.getByAppId(statusH.get().getAppId());
            if (statusM != null && Objects.equals(statusM.getStatus(), "117") && userRole == 6){
                List<RollBackApp> rollBackApp = new ArrayList<>();
                rollBackApp = rollBackAppService.getByStatusHId(filterDTO.getStId());
                objectMap.put("rollBackApp", rollBackApp);
                objectMap.put("statusWork", "117");
                objectMap.put("indexing", filterDTO.getIndex());
                objectMap.put("stId", filterDTO.getStId());
                return new ResponseEntity<>(objectMap, HttpStatus.OK);
            }else {
                List<RollBackApp> rollBackApp = new ArrayList<>();
                rollBackApp = rollBackAppService.getByStatusHId(filterDTO.getStId());
                objectMap.put("rollBackApp", rollBackApp);
                objectMap.put("statusWork", "none");
                objectMap.put("indexing", filterDTO.getIndex());
                objectMap.put("stId", filterDTO.getStId());
                return new ResponseEntity<>(objectMap, HttpStatus.OK);
            }
        }
        if (Objects.equals(statusH.get().getStatus(), "120")) {
            StatusM statusM = statusMService.getByAppId(statusH.get().getAppId());
            if (statusM != null && Objects.equals(statusM.getStatus(), "120")){
                List<RollBackApp> rollBackApp = new ArrayList<>();
                rollBackApp = rollBackAppService.getByStatusHId(filterDTO.getStId());
                objectMap.put("rollBackApp", rollBackApp);
                objectMap.put("statusWork", "120");
                objectMap.put("indexing", filterDTO.getIndex());
                objectMap.put("stId", filterDTO.getStId());
                return new ResponseEntity<>(objectMap, HttpStatus.OK);
            }else {
                List<RollBackApp> rollBackApp = new ArrayList<>();
                rollBackApp = rollBackAppService.getByStatusHId(filterDTO.getStId());
                objectMap.put("rollBackApp", rollBackApp);
                objectMap.put("statusWork", "120");
                objectMap.put("indexing", filterDTO.getIndex());
                objectMap.put("stId", filterDTO.getStId());
                return new ResponseEntity<>(objectMap, HttpStatus.OK);
            }
        }
        if (Objects.equals(statusH.get().getStatus(), "160")) {
            StatusM statusM = statusMService.getByAppId(statusH.get().getAppId());
            if (statusM != null && Objects.equals(statusM.getStatus(), "160") && userRole == 6){
                List<RollBackApp> rollBackApp = new ArrayList<>();
                rollBackApp = rollBackAppService.getByStatusHId(filterDTO.getStId());
                objectMap.put("rollBackApp", rollBackApp);
                objectMap.put("statusWork", "160");
                objectMap.put("indexing", filterDTO.getIndex());
                objectMap.put("stId", filterDTO.getStId());
                return new ResponseEntity<>(objectMap, HttpStatus.OK);
            }else {
                List<RollBackApp> rollBackApp = new ArrayList<>();
                rollBackApp = rollBackAppService.getByStatusHId(filterDTO.getStId());
                objectMap.put("rollBackApp", rollBackApp);
                objectMap.put("statusWork", "none");
                objectMap.put("indexing", filterDTO.getIndex());
                objectMap.put("stId", filterDTO.getStId());
                return new ResponseEntity<>(objectMap, HttpStatus.OK);
            }
        }
        if (Objects.equals(statusH.get().getStatus(), "145")) {
            StatusM statusM = statusMService.getByAppId(statusH.get().getAppId());
            if (statusM != null && Objects.equals(statusM.getStatus(), "145") && userRole == 7){
                List<RollBackApp> rollBackApp = new ArrayList<>();
                rollBackApp = rollBackAppService.getByStatusHId(filterDTO.getStId());
                objectMap.put("rollBackApp", rollBackApp);
                objectMap.put("statusWork", "145");
                objectMap.put("indexing", filterDTO.getIndex());
                objectMap.put("stId", filterDTO.getStId());
                return new ResponseEntity<>(objectMap, HttpStatus.OK);
            }else {
                List<RollBackApp> rollBackApp = new ArrayList<>();
                rollBackApp = rollBackAppService.getByStatusHId(filterDTO.getStId());
                objectMap.put("rollBackApp", rollBackApp);
                objectMap.put("statusWork", "none");
                objectMap.put("indexing", filterDTO.getIndex());
                objectMap.put("stId", filterDTO.getStId());
                return new ResponseEntity<>(objectMap, HttpStatus.OK);
            }
        }
        if (Objects.equals(statusH.get().getStatus(), "170")) {
            StatusM statusM = statusMService.getByAppId(statusH.get().getAppId());
            if (statusM != null && Objects.equals(statusM.getStatus(), "170") && userRole == 6){
                List<RollBackApp> rollBackApp = new ArrayList<>();
                rollBackApp = rollBackAppService.getByStatusHId(filterDTO.getStId());
                objectMap.put("rollBackApp", rollBackApp);
                objectMap.put("statusWork", "170");
                objectMap.put("indexing", filterDTO.getIndex());
                objectMap.put("stId", filterDTO.getStId());
                return new ResponseEntity<>(objectMap, HttpStatus.OK);
            }else {
                List<RollBackApp> rollBackApp = new ArrayList<>();
                rollBackApp = rollBackAppService.getByStatusHId(filterDTO.getStId());
                objectMap.put("rollBackApp", rollBackApp);
                objectMap.put("statusWork", "none");
                objectMap.put("indexing", filterDTO.getIndex());
                objectMap.put("stId", filterDTO.getStId());
                return new ResponseEntity<>(objectMap, HttpStatus.OK);
            }
        }
        else {
            List<RollBackApp> rollBackApp = new ArrayList<>();
            rollBackApp = rollBackAppService.getByStatusHId(filterDTO.getStId());
            objectMap.put("rollBackApp", rollBackApp);
            objectMap.put("statusWork", "none");
            objectMap.put("indexing", filterDTO.getIndex());
            objectMap.put("stId", filterDTO.getStId());
            return new ResponseEntity<>(objectMap, HttpStatus.OK);
        }
    }

    @PostMapping(value = SAVE_DOUBLE_ROLLBACKP_PROJECT)
    public ResponseEntity<Object> saveRollbackFromXbbbAndXbbProjects(@RequestBody FilterDTO filterDTO, HttpServletRequest request){
        String userId = (String) request.getSession().getAttribute("userId");
        String userName = (String) request.getSession().getAttribute("userName");
        Integer userRole = (Integer) request.getSession().getAttribute("userRole");
        String userRoleName = (String) request.getSession().getAttribute("userRoleName");
        String userLocation = (String) request.getSession().getAttribute("userLocation");
        String userLocationName = (String) request.getSession().getAttribute("userLocationName");
        String userPost = (String) request.getSession().getAttribute("userPost");
        String userPostName = (String) request.getSession().getAttribute("userPostName");

        Map<String, Object> objectMap = new HashMap<>();
        try {
            Optional<StatusH> statusHAppId = statusHRepo.findById(filterDTO.getStId());
            Status status =new Status();
            if (Objects.equals(filterDTO.getStatusGetSaveRollbackType(), "toInspector")){

                /**todo ЛОК га ёзиш start todo**/
                StatusM statusM = statusMService.getByAppId(statusHAppId.get().getAppId());
                statusM.setStatus(String.valueOf(118));
                status = statusService.getById(118);
                statusM.setStatusComment(status.getName());
                statusM.setInsUser(userId);
                statusMService.saveStatusM(statusM);

                StatusH statusH = new StatusH();
                statusH.setStmainID(statusM.getId());
                statusH.setAppId(statusM.getAppId());
                statusH.setStatus(String.valueOf(118));
                statusH.setStatusComment(status.getName());
                statusH.setInsUser(userId);
                statusH.setComment(filterDTO.getDoubleRollbackCommentTextarea());
                statusHService.saveStatusH(statusH);
                /**todo ЛОК га ёзиш end todo**/

                Apps apps = appsService.findById(statusHAppId.get().getAppId());
                apps.setStatus(118);
                apps.setStatusNm(status.getName());
                appsService.saveAppsStatus(apps);
            }if(Objects.equals(filterDTO.getStatusGetSaveRollbackType(), "toXbbb")){
                if (userRole==6){
                    /**todo ЛОК га ёзиш start todo**/
                    StatusM statusM = statusMService.getByAppId(statusHAppId.get().getAppId());
                    statusM.setStatus(String.valueOf(120));
                    status = statusService.getById(120);
                    statusM.setStatusComment(status.getName());
                    statusM.setInsUser(userId);
                    statusMService.saveStatusM(statusM);

                    StatusH statusH = new StatusH();
                    statusH.setStmainID(statusM.getId());
                    statusH.setAppId(statusM.getAppId());
                    statusH.setStatus(String.valueOf(120));
                    statusH.setStatusComment(status.getName());
                    statusH.setInsUser(userId);
                    statusH.setComment(filterDTO.getDoubleRollbackCommentTextarea());
                    statusHService.saveStatusH(statusH);
                    /**todo ЛОК га ёзиш end todo**/

                    Apps apps = appsService.findById(statusHAppId.get().getAppId());
                    apps.setStatus(120);
                    apps.setStatusNm(status.getName());
                    appsService.saveAppsStatus(apps);
                }
                else {
                    /**todo ЛОК га ёзиш start todo**/
                    StatusM statusM = statusMService.getByAppId(statusHAppId.get().getAppId());
                    statusM.setStatus(String.valueOf(117));
                    status = statusService.getById(117);
                    statusM.setStatusComment(status.getName());
                    statusM.setInsUser(userId);
                    statusMService.saveStatusM(statusM);

                    StatusH statusH = new StatusH();
                    statusH.setStmainID(statusM.getId());
                    statusH.setAppId(statusM.getAppId());
                    statusH.setStatus(String.valueOf(117));
                    statusH.setStatusComment(status.getName());
                    statusH.setInsUser(userId);
                    statusH.setComment(filterDTO.getDoubleRollbackCommentTextarea());
                    statusHService.saveStatusH(statusH);
                    /**todo ЛОК га ёзиш end todo**/

                    Apps apps = appsService.findById(statusHAppId.get().getAppId());
                    apps.setStatus(117);
                    apps.setStatusNm(status.getName());
                    appsService.saveAppsStatus(apps);
                }
            }else if (Objects.equals(filterDTO.getStatusGetSaveRollbackType(), "toDublicate")){
                Apps apps = appsService.findById(statusHAppId.get().getAppId());

                Status status1 = new Status();
                status1 = statusService.getById(172);

                apps.setStatus(172);
                apps.setStatusNm(status1.getName());

                appsService.saveAppsOne(apps);

                /**todo ЛОК га ёзиш start todo**/
                StatusM statusM = statusMService.getByAppId(statusHAppId.get().getAppId());
                statusM.setStatus(String.valueOf(172));
                status = statusService.getById(172);
                statusM.setStatusComment(status.getName());
                statusM.setInsUser(userId);
                statusMService.saveStatusM(statusM);

                StatusH statusH = new StatusH();
                statusH.setStmainID(statusM.getId());
                statusH.setAppId(statusM.getAppId());
                statusH.setStatus(String.valueOf(172));
                statusH.setStatusComment(status.getName());
                statusH.setInsUser(userId);
                statusH.setComment(filterDTO.getDoubleRollbackCommentTextarea());
                statusHService.saveStatusH(statusH);
                /**todo ЛОК га ёзиш end todo**/

                Apps appsNewDublcate = new Apps();
                Status status2 =new Status();
                status2 = statusService.getById(110);

                appsNewDublcate.setStatus(110);
                appsNewDublcate.setStatusNm(status2.getName());

                appsNewDublcate.setPersonId(apps.getPersonId());
                appsNewDublcate.setAppNum(apps.getAppNum());
                appsNewDublcate.setAppDate(apps.getAppDate());
                appsNewDublcate.setInsTime(apps.getInsTime());
                appsNewDublcate.setCustomerCountry(apps.getCustomerCountry());
                appsNewDublcate.setCustomerCountryNm(apps.getCustomerCountryNm());
                appsNewDublcate.setSenderCountry(apps.getSenderCountry());
                appsNewDublcate.setSenderCountryNm(apps.getSenderCountryNm());
                appsNewDublcate.setSenderOrg(apps.getSenderOrg());
                appsNewDublcate.setSellerOrg(apps.getSellerOrg());
                appsNewDublcate.setTerms(apps.getTerms());
                appsNewDublcate.setTermsNm(apps.getTermsNm());
                appsNewDublcate.setTermsAddr(apps.getTermsAddr());
                appsNewDublcate.setPersonFio(apps.getPersonFio());
                appsNewDublcate.setOrgName(apps.getOrgName());
                appsNewDublcate.setPersonPosition(apps.getPersonPosition());
                appsNewDublcate.setPersonAddr(apps.getPersonAddr());
                appsNewDublcate.setPersonTin(apps.getPersonTin());
                appsNewDublcate.setPersonPin(apps.getPersonPin());
                appsNewDublcate.setPersonMail(apps.getPersonMail());
                appsNewDublcate.setPersonPhone(apps.getPersonPhone());
                appsNewDublcate.setLocationId(apps.getLocationId());
                appsNewDublcate.setLocationNm(apps.getLocationNm());
                appsNewDublcate.setTransExp(apps.getTransExp());
                appsNewDublcate.setComment(apps.getComment());
                appsNewDublcate.setImporterNm(apps.getImporterNm());
                appsNewDublcate.setImporterTin(apps.getImporterTin());
                appsNewDublcate.setVersionNum(apps.getVersionNum());
                appsService.saveAppsOne(appsNewDublcate);

                List<Commodity> commodity = new ArrayList<>();
                commodity = commodityService.getListAppId(apps.getId());


                String findPay = "NO";
                for (int i = 0; i < commodity.size(); i++) {
                        if (Objects.equals(commodity.get(i).getPaymentYN(), "YES")){
                            findPay = "YES";
                        }
                }


                for (int i = 0; i < commodity.size(); i++) {
                    Commodity commodityNew = new Commodity();
                    commodityNew.setAppId(appsNewDublcate.getId());
                    commodityNew.setCmdtNum(commodity.get(i).getCmdtNum());
                    commodityNew.setOriginCountry(commodity.get(i).getOriginCountry());
                    commodityNew.setOrignCountrNm(commodity.get(i).getOrignCountrNm());
                    commodityNew.setOriginOrg(commodity.get(i).getOriginOrg());
                    commodityNew.setTradeName(commodity.get(i).getTradeName());
                    commodityNew.setTradeMark(commodity.get(i).getTradeMark());
                    commodityNew.setMark(commodity.get(i).getMark());
                    commodityNew.setModel(commodity.get(i).getModel());
                    commodityNew.setArticle(commodity.get(i).getArticle());
                    commodityNew.setSort(commodity.get(i).getSort());
                    commodityNew.setStandarts(commodity.get(i).getStandarts());
                    commodityNew.setFunctions(commodity.get(i).getFunctions());
                    commodityNew.setComProp(commodity.get(i).getComProp());
                    commodityNew.setTechChar(commodity.get(i).getTechChar());
                    commodityNew.setProductGoal(commodity.get(i).getProductGoal());
                    commodityNew.setHsCode(commodity.get(i).getHsCode());
                    commodityNew.setHsName(commodity.get(i).getHsName());
                    commodityNew.setBrutto(commodity.get(i).getBrutto());
                    commodityNew.setNetto(commodity.get(i).getNetto());
                    commodityNew.setBasicQty(commodity.get(i).getBasicQty());
                    commodityNew.setExtraUnits(commodity.get(i).getExtraUnits());
                    commodityNew.setExtraQty(commodity.get(i).getExtraQty());
                    commodityNew.setPrice(commodity.get(i).getPrice());
                    commodityNew.setCustomsPrice(commodity.get(i).getCustomsPrice());
                    commodityNew.setCurrencyType(commodity.get(i).getCurrencyType());
                    commodityNew.setCargoSpace(commodity.get(i).getCargoSpace());
                    commodityNew.setPackType(commodity.get(i).getPackType());
                    commodityNew.setPackTypeNm(commodity.get(i).getPackTypeNm());
                    commodityNew.setPackQty(commodity.get(i).getPackQty());
                    commodityNew.setExtraInfo(commodity.get(i).getExtraInfo());
                    commodityNew.setHsDecNum(commodity.get(i).getHsDecNum());
                    commodityNew.setHsDecDate(commodity.get(i).getHsDecDate());
                    commodityNew.setInDecDate(commodity.get(i).getInDecDate());
                    commodityNew.setInDecNum(commodity.get(i).getInDecNum());
                    commodityNew.setMethod(commodity.get(i).getMethod());
                    commodityNew.setMethodNm(commodity.get(i).getMethodNm());
                    commodityNew.setMethodDescription(commodity.get(i).getMethodDescription());
                    commodityNew.setPaymentYN(findPay);
                    commodityNew.setCurrencyNm(commodity.get(i).getCurrencyNm());
                    commodityNew.setCurrencyNmSymbol(commodity.get(i).getCurrencyNmSymbol());
                    commodityService.saveCommodity(commodityNew);
                }

                List<Earxiv> earxiv = new ArrayList<>();
                earxiv = earxivService.getByAppId(apps.getId());
                for (int i = 0; i < earxiv.size(); i++) {
                    Earxiv earxivNew = new Earxiv();
                    earxivNew.setAppId(appsNewDublcate.getId());
                    earxivNew.setFolderId(earxiv.get(i).getFolderId());
                    earxivNew.setName(earxiv.get(i).getName());
                    earxivNew.setUserInn(earxiv.get(i).getUserInn());
                    earxivNew.setUserPnfl(earxiv.get(i).getUserPnfl());
                    earxivNew.setDocname(earxiv.get(i).getDocname());
                    earxivNew.setDocType(earxiv.get(i).getDocType());
                    earxivNew.setFileId(earxiv.get(i).getFileId());
                    earxivNew.setStatus(earxiv.get(i).getStatus());
                    earxivNew.setDocTypeName(earxiv.get(i).getDocTypeName());
                    earxivNew.setSetFolderId(earxiv.get(i).getSetFolderId());
                    earxivNew.setPartyNo(earxiv.get(i).getPartyNo());
                    earxivNew.setDocId(earxiv.get(i).getDocId());
                    earxivNew.setHash(earxiv.get(i).getHash());
                    earxivNew.setFileNum(earxiv.get(i).getFileNum());
                    earxivNew.setFileDate(earxiv.get(i).getFileDate());
                    earxivNew.setDocNameEx(earxiv.get(i).getDocNameEx());
                    earxivService.save(earxivNew);
                }

                List<TransportType> transportTypes = new ArrayList<>();
                transportTypes = transportTypeService.getAllByAppId(apps.getId());
                for (int i = 0; i < transportTypes.size(); i++) {
                    TransportType transportType = new TransportType();
                    transportType.setAppId(appsNewDublcate.getId());
                    transportType.setFinishCountry(transportTypes.get(i).getFinishCountry());
                    transportType.setFinishCountryNm(transportTypes.get(i).getFinishCountryNm());
                    transportType.setEndCountry(transportTypes.get(i).getEndCountry());
                    transportType.setEndCountryNm(transportTypes.get(i).getEndCountryNm());
                    transportType.setTarnsportType(transportTypes.get(i).getTarnsportType());
                    transportType.setTarnsportTypeNm(transportTypes.get(i).getTarnsportTypeNm());
                    transportType.setTransportPrice(transportTypes.get(i).getTransportPrice());
                    transportTypeService.savetrtype(transportType);
                }

                AppsRasp appsRasp =appsRaspService.findByAppsId(statusHAppId.get().getAppId());
                AppsRasp appsRaspNewDublicate =new AppsRasp();

                appsRaspNewDublicate.setAppId(appsNewDublcate.getId());
                appsRaspNewDublicate.setInspectorId(appsRasp.getInspectorId());
                appsRaspNewDublicate.setInspectorName(appsRasp.getInspectorName());
                appsRaspNewDublicate.setLocation(appsRasp.getLocation());
                appsRaspNewDublicate.setPost(appsRasp.getPost());
                appsRaspNewDublicate.setInsUser("auto");
                appsRaspService.saveRasp(appsRaspNewDublicate);

                /**todo ЛОК га ёзиш start todo**/
                StatusM statusMDublicate = new StatusM();
                statusMDublicate.setAppId(appsNewDublcate.getId());
                statusMDublicate.setStatus(String.valueOf(110));
                status = statusService.getById(110);
                statusMDublicate.setStatusComment(status.getName());
                statusMDublicate.setInsUser(userId);
                statusMService.saveStatusM(statusMDublicate);

                StatusH statusHDublicate = new StatusH();
                statusHDublicate.setStmainID(statusMDublicate.getId());
                statusHDublicate.setAppId(statusMDublicate.getAppId());
                statusHDublicate.setStatus(String.valueOf(110));
                statusHDublicate.setStatusComment(status.getName());
                statusHDublicate.setInsUser(userId);
                statusHDublicate.setSortedInsId(appsRasp.getInspectorId());
                statusHDublicate.setSortedInsNm(appsRasp.getInspectorName());
                statusHDublicate.setComment("Дастлабки қарорга тузатиш ва ўзгартириш киритишга рухсат берилди");
                statusHService.saveStatusH(statusHDublicate);
                /**todo ЛОК га ёзиш end todo**/

                return new ResponseEntity<>(objectMap, HttpStatus.OK);
            }
            return new ResponseEntity<>(objectMap, HttpStatus.OK);
        }catch (Exception ee){
            return new ResponseEntity<>(objectMap, HttpStatus.BAD_REQUEST);
        }
    }

    /*todo Аризалар рўйхати(дастлабки)*/
    @PostMapping(value = INITIAL_DECISION_RASP_TABLE)
    @ResponseBody
    public ModelAndView InitialDecisionRaspTable(HttpServletRequest request, @RequestParam(name = "id") String status) {
        ModelAndView mav = new ModelAndView("resources/pages/InitialDecision/ListInDec/ListInDecRasp");
        String userId = (String) request.getSession().getAttribute("userId");
        String userName = (String) request.getSession().getAttribute("userName");
        Integer userRole = (Integer) request.getSession().getAttribute("userRole");
        String userRoleName = (String) request.getSession().getAttribute("userRoleName");
        String userLocation = (String) request.getSession().getAttribute("userLocation");
        String userLocationName = (String) request.getSession().getAttribute("userLocationName");
        String userPost = (String) request.getSession().getAttribute("userPost");

        List<Apps> sortedList = new ArrayList<>();
        sortedList = appsservice.getListSorted(request);
        mav.addObject("sortedList", sortedList);

        return mav;
    }

    /*todo Аризалар рўйхати(кўриб чиқилмоқда - жараёнда)*/
    @PostMapping(value = INITIAL_DECISION_PROCESS)
    @ResponseBody
    public ModelAndView InitialDecisionProcessApp(HttpServletRequest request, @RequestParam(name = "id") String id, @RequestParam String status) {
        ModelAndView mav = new ModelAndView("resources/pages/InitialDecision/ListInDec/ListInDecProcessApp");
        String userId = (String) request.getSession().getAttribute("userId");
        String userName = (String) request.getSession().getAttribute("userName");
        Integer userRole = (Integer) request.getSession().getAttribute("userRole");
        String userRoleName = (String) request.getSession().getAttribute("userRoleName");
        String userLocation = (String) request.getSession().getAttribute("userLocation");
        String userLocationName = (String) request.getSession().getAttribute("userLocationName");
        String userPost = (String) request.getSession().getAttribute("userPost");

        List<Apps> listProcessApp = appsservice.getListProcessApp(request, status);
        mav.addObject("listProcessApp", listProcessApp);

        return mav;
    }

    /*todo Аризалар рўйхати(кўриб чиқилмоқда - тасдиқлашга киритилган)*/
    @PostMapping(value = INITIAL_DECISION_SUBMITTED)
    @ResponseBody
    public ModelAndView InitialDecisionSubmittedApp(HttpServletRequest request, @RequestParam(name = "id") String id, @RequestParam String status) {
        ModelAndView mav = new ModelAndView("resources/pages/InitialDecision/ListInDec/ListInDecSubmittedApp");
        String userId = (String) request.getSession().getAttribute("userId");
        String userName = (String) request.getSession().getAttribute("userName");
        Integer userRole = (Integer) request.getSession().getAttribute("userRole");
        String userRoleName = (String) request.getSession().getAttribute("userRoleName");
        String userLocation = (String) request.getSession().getAttribute("userLocation");
        String userLocationName = (String) request.getSession().getAttribute("userLocationName");
        String userPost = (String) request.getSession().getAttribute("userPost");

        List<Apps> listSubmittedApp = appsservice.getListProcessApp(request, status);
        mav.addObject("listSubmittedApp", listSubmittedApp);

        return mav;
    }

    /*todo Аризалар рўйхати(кўриб чиқилмоқда - имзолашга киритилган)*/
    @PostMapping(value = INITIAL_DECISION_SIGNED)
    @ResponseBody
    public ModelAndView InitialDecisionSignedApp(HttpServletRequest request, @RequestParam(name = "id") String id, @RequestParam String status) {
        ModelAndView mav = new ModelAndView("resources/pages/InitialDecision/ListInDec/ListInDecSignedApp");
        String userId = (String) request.getSession().getAttribute("userId");
        String userName = (String) request.getSession().getAttribute("userName");
        Integer userRole = (Integer) request.getSession().getAttribute("userRole");
        String userRoleName = (String) request.getSession().getAttribute("userRoleName");
        String userLocation = (String) request.getSession().getAttribute("userLocation");
        String userLocationName = (String) request.getSession().getAttribute("userLocationName");
        String userPost = (String) request.getSession().getAttribute("userPost");

        List<Apps> listSignedApp = appsservice.getListProcessApp(request, status);
        mav.addObject("listSignedApp", listSignedApp);

        return mav;
    }

    /*todo Аризалар рўйхати(дастлабки)*/
    @PostMapping(value = INITIAL_DECISION_TERMS_TABLE)
    @ResponseBody
    public ModelAndView InitialDecisionTermsTable(HttpServletRequest request, @RequestParam(name = "id") String status) {
        ModelAndView mav = new ModelAndView("resources/pages/InitialDecision/ListInDec/ListInDecTerms");
        String userId = (String) request.getSession().getAttribute("userId");
        String userName = (String) request.getSession().getAttribute("userName");
        Integer userRole = (Integer) request.getSession().getAttribute("userRole");
        String userRoleName = (String) request.getSession().getAttribute("userRoleName");
        String userLocation = (String) request.getSession().getAttribute("userLocation");
        String userLocationName = (String) request.getSession().getAttribute("userLocationName");
        String userPost = (String) request.getSession().getAttribute("userPost");

        List<InDec> termsList = new ArrayList<>();
//        termsList = appsservice.getListInDec(request);
        termsList = appsservice.getListInDec(request);
        mav.addObject("termsList", termsList);

        return mav;
    }

    /*todo Аризалар рўйхати(дастлабки)*/
    @PostMapping(value = INITIAL_DECISION_TERMS_ROLLBACK)
    @ResponseBody
    public ModelAndView InitialDecisionTermsRollBack(HttpServletRequest request, @RequestParam(name = "id") String status) {
        ModelAndView mav = new ModelAndView("resources/pages/InitialDecision/ListInDec/ListInDecTerms");
        String userId = (String) request.getSession().getAttribute("userId");
        String userName = (String) request.getSession().getAttribute("userName");
        Integer userRole = (Integer) request.getSession().getAttribute("userRole");
        String userRoleName = (String) request.getSession().getAttribute("userRoleName");
        String userLocation = (String) request.getSession().getAttribute("userLocation");
        String userLocationName = (String) request.getSession().getAttribute("userLocationName");
        String userPost = (String) request.getSession().getAttribute("userPost");

        List<InDec> termsList = new ArrayList<>();
//        termsList = appsservice.getListInDec(request);
        termsList = appsservice.getListInDecRollBack(request);
        mav.addObject("termsList", termsList);

        return mav;
    }
}

