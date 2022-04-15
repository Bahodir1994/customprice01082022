package uz.customs.customsprice.controllers.indec;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import uz.customs.customsprice.entity.InitialDecision.*;
import uz.customs.customsprice.entity.files.Docs;
import uz.customs.customsprice.entity.users.User;
import uz.customs.customsprice.repository.AppsRepo;
import uz.customs.customsprice.repository.RollBackAppRepo;
import uz.customs.customsprice.repository.UserRepository;
import uz.customs.customsprice.repository.users.LoginRepo;
import uz.customs.customsprice.repository.users.UsersRepo;
import uz.customs.customsprice.service.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    private final UsersRepo usersRepo;
    private final LoginRepo loginRepo;
    private final TransportTypeService transportTypeService;
    private final UsersService usersService;
    private final StatusMService statusMService;
    private final StatusHService statusHService;
    private final RollBackAppService rollBackAppService;
    private final RollbackSpService rollbackSpService;
    private final RollBackAppRepo rollBackAppRepo;
    private final UserRepository userRepository;



    private final String INITIALDECISION = "/resources/pages/InitialDecision/InitialDecision1";
    private final String INITIALDECISIONRASP = "/resources/pages/InitialDecision/InitialDecisionRasp";
    private final String INITIALDECISIONVIEW = "/resources/pages/InitialDecision/InitialDecisionView";
    private final String INITIALDECISIONSAVERASP = "/resources/pages/InitialDecision/InitialDecisionRasp1";
    private final String INITIALDECISIONROLLBACK = "/resources/pages/InitialDecision/InitialDecisionRollBack";
    private final String INITIAL_DECISION_APP = "/resources/pages/InitialDecision/ListInDec";
    private final String INITIAL_DECISION_NOT_SORTED= "/resources/pages/InitialDecision/ListInDec/ListInDecTable";
    private final String INITIAL_DECISION_RASP_TABLE = "/resources/pages/InitialDecision/ListInDec/ListInDecRasp";
    private final String INITIAL_DECISION_TERMS_TABLE = "/resources/pages/InitialDecision/ListInDec/ListInDecTermsTable";

    public AppsController(AppsService appsService, ConturyService conturyService, LocationService locationService, StatusService statusService, TermsService termsService, AppsService appsservice, AppsRaspService appsRaspService, AppsRepo appsRepo, UsersRepo usersRepo, LoginRepo loginRepo, TransportTypeService transportTypeService, UsersService usersService, StatusMService statusMService, StatusHService statusHService, RollBackAppService rollBackAppService, RollbackSpService rollbackSpService, RollBackAppRepo rollBackAppRepo, UserRepository userRepository) {
        this.appsService = appsService;
        this.conturyService = conturyService;
        this.locationService = locationService;
        this.statusService = statusService;
        this.termsService = termsService;
        this.appsservice = appsservice;
        this.appsRaspService = appsRaspService;
        this.appsRepo = appsRepo;
        this.usersRepo = usersRepo;
        this.loginRepo = loginRepo;
        this.transportTypeService = transportTypeService;
        this.usersService = usersService;
        this.statusMService = statusMService;
        this.statusHService = statusHService;
        this.rollBackAppService = rollBackAppService;
        this.rollbackSpService = rollbackSpService;
        this.rollBackAppRepo = rollBackAppRepo;
        this.userRepository = userRepository;
    }

    /*todo Тақсимланган аризалар рўйхатини сақлаш (инспекторлар кесимида)*/
    @PostMapping(value = INITIALDECISIONSAVERASP)
    @ResponseBody
    public ModelAndView InitialDecisionViewSave(HttpServletRequest request, @RequestParam String appId, @RequestParam String inspectorId, @RequestParam String inspectorName, RedirectAttributes redirAttrs) {

        String userId = (String) request.getSession().getAttribute("userId");
        String userName = (String) request.getSession().getAttribute("userName");
        Integer userRole = (Integer) request.getSession().getAttribute("userRole");
        String userRoleName = (String) request.getSession().getAttribute("userRoleName");
        String userLocation = (String) request.getSession().getAttribute("userLocation");
        String userLocationName = (String) request.getSession().getAttribute("userLocationName");
        String userPost = (String) request.getSession().getAttribute("userPost");

        if (!Objects.equals(inspectorId, "notSelected")) {
            AppsRasp appsRasp = new AppsRasp();
            appsRasp.setAppId(appId);
            appsRasp.setInsUser(userId);
            appsRasp.setInspectorId(inspectorId);
            appsRasp.setInspectorName(inspectorName);
            appsRasp.setLocation(userLocation);
            appsRasp.setPost(userPost);
            appsRaspService.saveRasp(appsRasp);

            Apps app = appsservice.findById(appId);
            Status status = statusService.getById(110);
            app.setStatus(110);
            app.setStatusNm(status.getName());
            appsservice.saveAppsStatus(app);

            /**todo ЛОК га ёзиш start todo**/
            StatusM statusM = new StatusM();
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
            statusHService.saveStatusH(statusH);
            /**todo ЛОК га ёзиш end todo**/

        }


        ModelAndView mav = new ModelAndView("resources/pages/InitialDecision/ListInDec");
        List<Apps> notSortedList = new ArrayList<>();
        notSortedList = appsservice.getListNotSorted(request, userLocation, userPost, userId, userRole);
        mav.addObject("notSortedList", notSortedList);

        List sortedList = new ArrayList<>();
        sortedList = appsservice.getListSorted();
        mav.addObject("sortedList", sortedList);

        List<Apps> termsList = new ArrayList<>();
        termsList = appsservice.getListTerms();
        mav.addObject("termsList", termsList);

        List<Users> usersList = new ArrayList<>();
        usersList = usersService.getByLocationAndPostAndRole(userLocation, userPost, 8);
        mav.addObject("userSelectList", usersList);

        return mav;
    }

    /*todo Аризалар рўйхати(дастлабки)*/
    @PostMapping(value = INITIALDECISIONRASP)
    @ResponseBody
    public ModelAndView InitialDecisionRasp(HttpServletRequest request, @RequestParam(name = "id") String status) {
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
        sortedList = appsservice.getListSorted();
        mav.addObject("sortedList", sortedList);

        List<Apps> termsList = new ArrayList<>();
        termsList = appsservice.getListTerms();
        mav.addObject("termsList", termsList);

        List<Users> usersList = new ArrayList<>();
        usersList = usersService.getByLocationAndPostAndRole(userLocation, userPost, 8);
        mav.addObject("userSelectList", usersList);

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
    public ModelAndView InitialDecisionView(HttpSession session,HttpServletRequest request, @RequestParam String appId) {
        ModelAndView mav = new ModelAndView("resources/pages/InitialDecision/InitialDecisionView");

        Integer userRole = (Integer) request.getSession().getAttribute("userRole");
        Apps apps = appsservice.findById(appId);

        List<Apps> InitialDecisionViewApp = appsservice.getInitialDecisionView(appId);
        mav.addObject("appInfo", InitialDecisionViewApp);

        List<Commodity> getInitialDecisionViewCommodity = appsservice.getInitialDecisionViewCommodity(appId);
        mav.addObject("allCommodityFor", getInitialDecisionViewCommodity);

        List<TransportType> getInDecViewTrType = transportTypeService.getByAppId(appId);
        mav.addObject("transports", getInDecViewTrType);

        List<RollbackSp> listRollbackSp = rollbackSpService.getlistRollbackSp();
        mav.addObject("rollbackInfo", listRollbackSp);

        List<Docs> docsList = appsservice.getDocsListAppId(appId);


        mav.addObject("docsList", docsList);
        mav.addObject("appId", appId);

        return mav;
    }

    @PostMapping(value = INITIALDECISIONROLLBACK)
    @ResponseBody
    public ModelAndView InitialDecisionRollBack(HttpServletRequest request, @RequestParam String appId, @RequestParam String commentRollback, @RequestParam String rollback_ids,
                                                @RequestParam String rollback_names, @RequestParam Integer statusApp) {
        ModelAndView mav = new ModelAndView("resources/pages/InitialDecision/InitialDecisionRasp");

        String userId = (String) request.getSession().getAttribute("userId");
        String userName = (String) request.getSession().getAttribute("userName");
        Integer userRole = (Integer) request.getSession().getAttribute("userRole");
        String userRoleName = (String) request.getSession().getAttribute("userRoleName");
        String userLocation = (String) request.getSession().getAttribute("userLocation");
        String userLocationName = (String) request.getSession().getAttribute("userLocationName");
        String userPost = (String) request.getSession().getAttribute("userPost");

        String[] rollback_idArr = rollback_ids.split("~");
        String[] rollback_nameArr = rollback_names.split("~");

        Apps app = appsservice.findById(appId);
        Status status = statusService.getById(statusApp);
        app.setStatus(statusApp);
        app.setStatusNm(status.getName());
        app.setComment(commentRollback);
        appsservice.saveAppsStatus(app);


        for (int i = 0; i < rollback_idArr.length; i++) {
            RollBackApp rollBackApp = new RollBackApp();
            rollBackApp.setAppId(appId);
            rollBackApp.setInsUser(userId);
            rollBackApp.setRollbackId(rollback_idArr[i]);
            rollBackApp.setRollbackName(rollback_nameArr[i]);
            rollBackAppService.saveRollBack(rollBackApp);
        }

        /**todo ЛОК га ёзиш start todo**/
        StatusM statusM = new StatusM();
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
        statusHService.saveStatusH(statusH);
        /**todo ЛОК га ёзиш end todo**/

        List<Apps> notSortedList = appsservice.getListNotSorted(request, userLocation, userPost, userId, userRole);
        mav.addObject("notSortedList", notSortedList);

        List sortedList = appsservice.getListSorted();
        mav.addObject("sortedList", sortedList);

        List<Apps> termsList = appsservice.getListTerms();
        mav.addObject("termsList", termsList);

        List<Users> usersList = usersService.getByLocationAndPostAndRole(userLocation, userPost, 8);
        mav.addObject("userSelectList", usersList);

        return mav;
    }
    /*-----------------------------------------------------------------------------------------------------------end*/


    /*todo Аризалар рўйхати(дастлабки)*/
    @PostMapping(value = INITIAL_DECISION_APP)
    @ResponseBody
    public ModelAndView InitialDecisionApp(HttpServletRequest request, @RequestParam(name = "id") String status) {
        ModelAndView mav = new ModelAndView("resources/pages/InitialDecision/ListInDec");
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
        sortedList = appsservice.getListSorted();
        mav.addObject("sortedList", sortedList);

        List<Apps> termsList = new ArrayList<>();
        termsList = appsservice.getListTerms();
        mav.addObject("termsList", termsList);

        List<Users> usersList = new ArrayList<>();
        usersList = usersService.getByLocationAndPostAndRole(userLocation, userPost, 8);
        mav.addObject("userSelectList", usersList);

        return mav;
    }

    /*todo Аризалар рўйхати(дастлабки)*/
    @PostMapping(value = INITIAL_DECISION_NOT_SORTED)
    @ResponseBody
    public ModelAndView InitialDecisionNotSorted(HttpServletRequest request, @RequestParam(name = "id") String status) {
        ModelAndView mav = new ModelAndView("resources/pages/InitialDecision/ListInDec/ListInDecTable");
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

        List<User> usersList = new ArrayList<>();
//        usersList = usersService.getByLocationAndPostAndRole(userLocation, userPost, 8);
        usersList = userRepository.findByLocationAndPost(userLocation, userPost);
        mav.addObject("userSelectList", usersList);
        return mav;
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
        sortedList = appsservice.getListSorted();
        mav.addObject("sortedList", sortedList);

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

        List<Apps> termsList = new ArrayList<>();
        termsList = appsservice.getListTerms();
        mav.addObject("termsList", termsList);

        return mav;
    }


}

