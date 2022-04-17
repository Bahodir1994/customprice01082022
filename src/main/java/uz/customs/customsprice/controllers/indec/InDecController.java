package uz.customs.customsprice.controllers.indec;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.text.BadElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import uz.customs.customsprice.entity.InitialDecision.*;
import uz.customs.customsprice.entity.users.User;
import uz.customs.customsprice.repository.CommodityRepo;
import uz.customs.customsprice.repository.PaymentRepo;
import uz.customs.customsprice.service.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/saveInDec")
public class InDecController {
    private final InDecService inDecService;
    private final AppsService appsService;
    private final AppsService appsservice;
    private final CommodityService commodityService;
    private final CommodityRepo commodityRepo;
    private final ConturyService conturyService;
    private final MethodService methodService;
    private final PackagingService packagingService;
    private final Tnved2Service tnved2Service;
    private final LocationService locationService;
    private final StatusService statusService;
    private final PdfService pdfService;
    private final PaymentServise paymentServise;
    private final ExchangerateService exchangerateService;
    private final StatusMService statusMService;
    private final StatusHService statusHService;
    private final PaymentTypeService paymentTypeService;
    private final PaymTypeService paymTypeService;
    private final UsersService usersService;

    @Autowired
    PaymentRepo paymentRepo;

    private final String INITIALDECISIONCONFIRMCMDT = "/resources/pages/InitialDecision/InitialDecisionConfirm";
    private final String INITIALDECISIONTOHTMl = "/resources/pages/InitialDecision/Qaror";
    private final String INITIALDECISIONCONFIRMTOXBB = "/resources/pages/InitialDecision/InitialDecisionConfirToXBB";
    private final String INITIALDECISIONCONFIRMXBBFINISH = "/resources/pages/InitialDecision/InitialDecisionConfirXBBFinish";
    private final String INDEC_GENERATE_PDF = "/resources/pages/InitialDecision/InitialDecisionGeneratePdf";
    private final String INITIALDECISIONCONFIRMCMDT_CALC = "/resources/pages/InitialDecision/InitialDecisionCalc";
    private final String DELETINGCALCUALTE = "/resources/pages/InitialDecision/DeletePayments";

    public InDecController(InDecService inDecService, AppsService appsService, AppsService appsservice, CommodityService commodityService, CommodityRepo commodityRepo, ConturyService conturyService, MethodService methodService, PackagingService packagingService, Tnved2Service tnved2Service, LocationService locationService, StatusService statusService, PdfService pdfService, PaymentServise paymentServise, ExchangerateService exchangerateService, StatusMService statusMService, StatusHService statusHService, PaymentTypeService paymentTypeService, PaymTypeService paymTypeService, UsersService usersService) {
        this.inDecService = inDecService;
        this.appsService = appsService;
        this.appsservice = appsservice;
        this.commodityService = commodityService;
        this.commodityRepo = commodityRepo;
        this.conturyService = conturyService;
        this.methodService = methodService;
        this.packagingService = packagingService;
        this.tnved2Service = tnved2Service;
        this.locationService = locationService;
        this.statusService = statusService;
        this.pdfService = pdfService;
        this.paymentServise = paymentServise;
        this.exchangerateService = exchangerateService;
        this.statusMService = statusMService;
        this.statusHService = statusHService;
        this.paymentTypeService = paymentTypeService;
        this.paymTypeService = paymTypeService;
        this.usersService = usersService;
    }


    @PostMapping(value = INITIALDECISIONCONFIRMCMDT)
    public ModelAndView saveValue(HttpServletRequest request, @RequestParam String appId) {
        ModelAndView mav = new ModelAndView("resources/pages/InitialDecision/ListInDec");

        String userId = (String) request.getSession().getAttribute("userId");
        String userName = (String) request.getSession().getAttribute("userName");
        Integer userRole = (Integer) request.getSession().getAttribute("userRole");
        String userRoleName = (String) request.getSession().getAttribute("userRoleName");
        String userLocation = (String) request.getSession().getAttribute("userLocation");
        String userLocationName = (String) request.getSession().getAttribute("userLocationName");
        String userPost = (String) request.getSession().getAttribute("userPost");

        Apps apps = appsService.findById(appId);
        Status status1 = statusService.getById(145);

        /** Хбб тўл.ходимидан хбб тўл.бош га жўнатилган Ариза мақоми ўзгариши 145-(Тасдиқлашга тайёрланган (инспектор томонидан бошлиқга юборилган)) **/
        Status status2 = statusService.getById(145);
        apps.setStatus(145);
        apps.setStatusNm(status2.getName());
        appsService.saveAppsStatus(apps);

        /** mav object start **/
        List<Apps> notSortedList = new ArrayList<>();
        notSortedList = appsservice.getListNotSorted(request, userLocation, userPost, userId, userRole);
        mav.addObject("notSortedList", notSortedList);

        List<Apps> sortedList = new ArrayList<>();
        sortedList = appsservice.getListSorted();
        mav.addObject("sortedList", sortedList);

        List<InDec> termsList = new ArrayList<>();
        termsList = appsservice.getListInDec(request);
        mav.addObject("termsList", termsList);

        List<User> usersList = new ArrayList<>();
        usersList = usersService.getByLocationAndPostAndRole(userLocation, userPost, 8);
        mav.addObject("userSelectList", usersList);
        /** mav object end **/

        /**todo ЛОК га ёзиш start todo**/
        StatusM statusM = new StatusM();
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

        return mav;
    }

    @PostMapping(value = DELETINGCALCUALTE)
    public ModelAndView deleteValue(HttpServletRequest request, @RequestParam String payId, @RequestParam String cmdtId, @RequestParam String appId) {
        paymentRepo.deletePaymentById(payId);
        ModelAndView mav = new ModelAndView("resources/pages/InitialDecision/InitialDecisionSteps/Steps4");
        ModelAndView mav2 = new ModelAndView("resources/pages/InitialDecision/InitialDecisionSteps/Steps4StatusDefault");
        List<PaymenttypeEntity> paymenttypeEntityList = paymentTypeService.getListPaymentType();
        List<PaymtypeEntity> paymtypeEntityList = paymTypeService.getListPaymType();
        Optional<Commodity> commodityList = commodityService.getById(cmdtId);
        List<Payment> payments = paymentServise.getByCmdtId(cmdtId);
        Optional<Commodity> commodityTnved = commodityService.getById(cmdtId);
        Apps apps = appsService.findById(appId);
        Exchangerate exchangerate840 = exchangerateService.getTop1ByIdOrderByDateSetDesc("840");
        BigDecimal rate = BigDecimal.valueOf(exchangerate840.getRate()).multiply(BigDecimal.valueOf(exchangerate840.getAmount()));

        String userId = (String) request.getSession().getAttribute("userId");
        String userName = (String) request.getSession().getAttribute("userName");
        Integer userRole = (Integer) request.getSession().getAttribute("userRole");
        String userRoleName = (String) request.getSession().getAttribute("userRoleName");
        String userLocation = (String) request.getSession().getAttribute("userLocation");
        String userLocationName = (String) request.getSession().getAttribute("userLocationName");
        String userPost = (String) request.getSession().getAttribute("userPost");

//        mav.addObject("docsList", docsList);
//        mav.addObject("rollbackInfo", listRollbackSp);
//        mav.addObject("cmdtId", appId);
        mav.addObject("commodity", commodityList.get().getHsCode());
        mav.addObject("cmdtId", cmdtId);
        mav.addObject("appId", appId);
        mav.addObject("paymenttype", paymenttypeEntityList);
        mav.addObject("paymttype", paymtypeEntityList);
        if (payments.isEmpty() && userRole == 8) {
            return mav;
        } else {
            mav2.addObject("CmdtPayments", payments);
            mav2.addObject("cmdtTnved", commodityTnved.get().getHsCode());
            mav2.addObject("cmdtId", commodityTnved.get().getId());
            mav2.addObject("appStatus", apps.getStatus());
            mav2.addObject("appStatusName", apps.getStatusNm());
            mav2.addObject("userRole", userRole);
            mav2.addObject("rate", rate);
            mav = mav2;
        }
        return mav;
    }

    @PostMapping(value = INITIALDECISIONTOHTMl)
    public ModelAndView openHtmlInDec(InDec inDec, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("inDecHtml");
        return mav;
    }

    @PostMapping(value = INITIALDECISIONCONFIRMTOXBB)
    public ModelAndView saveToXBB(InDec inDec, HttpServletRequest request, @RequestParam String cmdtId, @RequestParam String appId) {
        ModelAndView mav = new ModelAndView("resources/pages/InitialDecision/ListInDec");

        String userId = (String) request.getSession().getAttribute("userId");
        String userName = (String) request.getSession().getAttribute("userName");
        Integer userRole = (Integer) request.getSession().getAttribute("userRole");
        String userRoleName = (String) request.getSession().getAttribute("userRoleName");
        String userLocation = (String) request.getSession().getAttribute("userLocation");
        String userLocationName = (String) request.getSession().getAttribute("userLocationName");
        String userPost = (String) request.getSession().getAttribute("userPost");

        Apps apps = appsService.findById(appId);
        Status status2 = statusService.getById(160);

        apps.setStatus(160);
        apps.setStatusNm(status2.getName());
        appsService.saveAppsStatus(apps);

        /** mav object start **/
        List<Apps> notSortedList = new ArrayList<>();
        notSortedList = appsservice.getListNotSorted(request, userLocation, userPost, userId, userRole);
        mav.addObject("notSortedList", notSortedList);

        List<Apps> sortedList = new ArrayList<>();
        sortedList = appsservice.getListSorted();
        mav.addObject("sortedList", sortedList);

        List<InDec> termsList = new ArrayList<>();
        termsList = appsservice.getListInDec(request);
        mav.addObject("termsList", termsList);

        List<User> usersList = new ArrayList<>();
        usersList = usersService.getByLocationAndPostAndRole(userLocation, userPost, 8);
        mav.addObject("userSelectList", usersList);
        /** mav object end **/

        /**todo ЛОК га ёзиш start todo**/
        StatusM statusM = new StatusM();
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

        return mav;
    }

    @PostMapping(value = INITIALDECISIONCONFIRMXBBFINISH)
    public ModelAndView saveFromXBB(InDec inDec, HttpServletRequest request, @RequestParam String cmdtId, @RequestParam String appId) throws IOException, BadElementException {
        ModelAndView mav = new ModelAndView("resources/pages/InitialDecision/ListInDec");

        String userId = (String) request.getSession().getAttribute("userId");
        String userName = (String) request.getSession().getAttribute("userName");
        Integer userRole = (Integer) request.getSession().getAttribute("userRole");
        String userRoleName = (String) request.getSession().getAttribute("userRoleName");
        String userLocation = (String) request.getSession().getAttribute("userLocation");
        String userLocationName = (String) request.getSession().getAttribute("userLocationName");
        String userPost = (String) request.getSession().getAttribute("userPost");
        Optional<Commodity> commodity = commodityService.getById(cmdtId);
        Status status1 = statusService.getById(145);

        Apps apps = appsService.findById(appId);
        Status status2 = statusService.getById(170);

        apps.setStatus(170);
        apps.setStatusNm(status2.getName());
        appsService.saveAppsStatus(apps);

        /** mav object start **/
        List<Apps> notSortedList = new ArrayList<>();
        notSortedList = appsservice.getListNotSorted(request, userLocation, userPost, userId, userRole);
        mav.addObject("notSortedList", notSortedList);

        List<Apps> sortedList = new ArrayList<>();
        sortedList = appsservice.getListSorted();
        mav.addObject("sortedList", sortedList);

        List<InDec> termsList = new ArrayList<>();
        termsList = appsservice.getListInDec(request);
        mav.addObject("termsList", termsList);

        List<User> usersList = new ArrayList<>();
        usersList = usersService.getByLocationAndPostAndRole(userLocation, userPost, 8);
        mav.addObject("userSelectList", usersList);

        /**todo ЛОК га ёзиш start todo**/
        StatusM statusM = new StatusM();
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


        /**todo Дастлаки қарор маълумотларини шакиллантириш **/
        inDec.setCmdtId(cmdtId);
//        inDec.setInDecNum();//?
//        inDec.setInDecDate();//?
        inDec.setInsUser(userId);
        inDec.setInDecLocation(apps.getLocationId());
        inDec.setInDecLocationNm(apps.getLocationNm());
        inDec.setPersonId(apps.getPersonId());
        inDec.setHsCode(commodity.get().getHsCode());
        inDec.setHsName(commodity.get().getHsName());
        inDec.setMethod(commodity.get().getMethod());
        inDec.setMethodNm(commodity.get().getMethodNm());
        inDec.setOriginCountry(commodity.get().getOriginCountry());
        inDec.setOrignCountrNm(commodity.get().getOrignCountrNm());
//        inDec.setInDecBasis(); //?
//        inDec.setCommentMarks(); //?
//        inDec.setCustomsPreference(); //?
//        inDec.setCustomsPayments(); //?
        inDec.setStatus(status1.getId());
        inDec.setStatusNm(status1.getName());
        inDecService.saveInDec(inDec);

        /**todo PDF GENERATSIYA  **/
//        pdfService.createPdf(appId, cmdtId, userName);
        return mav;
    }

    @PostMapping(value = INITIALDECISIONCONFIRMCMDT_CALC)
    public ModelAndView saveValueCalc(InDec inDec, HttpServletRequest request, @RequestParam String x, @RequestParam String cmdtId, @RequestParam String appId, @RequestParam Integer status, @RequestParam String listObject) throws JsonProcessingException {
        ModelAndView mav = new ModelAndView("resources/pages/InitialDecision/InitialDecisionSteps/Steps4StatusDefault");
        ObjectMapper objectMapper = new ObjectMapper();
        List<ResponseObject> listCar = objectMapper.readValue(listObject, new TypeReference<List<ResponseObject>>() {
        });

        String userId = (String) request.getSession().getAttribute("userId");
        String userName = (String) request.getSession().getAttribute("userName");
        Integer userRole = (Integer) request.getSession().getAttribute("userRole");
        String userRoleName = (String) request.getSession().getAttribute("userRoleName");
        String userLocation = (String) request.getSession().getAttribute("userLocation");
        String userLocationName = (String) request.getSession().getAttribute("userLocationName");
        String userPost = (String) request.getSession().getAttribute("userPost");


        ResponseObject object = null;
        listCar.forEach(responseObject -> System.out.println(responseObject.toString()));
        for (int i = 0; i < listCar.size(); i++) {
            Payment payment = new Payment();
            object = listCar.get(i);
            payment.setCmdtId(cmdtId);
            payment.setG47Base(object.getG47Base());
            payment.setG47AltBase(object.getG47AltBase());
            payment.setG47Rate(object.getG47Rate());
            payment.setG47AltRate(object.getG47AltRate());
            payment.setG47AltBaseCurrkod(object.getG47AltBaseCurrKod());
            payment.setCurrRate(object.getCurrRate());
            payment.setG47AltBaseEdIzm(object.getG47AltBaseEdIzm());
            payment.setG47Sum(object.getG47Sum());
            payment.setG47Sp(object.getG47Sp());
            payment.setG47Type(object.getG47Type());
            payment.setG47ClcType(object.getG47ClcType());
            paymentServise.savePayment(payment);
        }


        Apps apps = appsService.findById(appId);
        Optional<Commodity> commodity = commodityService.getById(cmdtId);
        Exchangerate exchangerate840 = exchangerateService.getTop1ByIdOrderByDateSetDesc("840");
        BigDecimal rate = BigDecimal.valueOf(exchangerate840.getRate()).multiply(BigDecimal.valueOf(exchangerate840.getAmount()));
        Commodity commodity1 = commodityService.findById(appId);
        commodity1.setPaymentYN("YES");
        commodityService.saveYN(commodity1);
//        Commodity comm = new Commodity();
//        comm = commodityRepo.getById(cmdtId);
//        comm.setPaymentYN("YES");
//        commodityService.saveYN(comm);


        List<Payment> payments = paymentServise.getByCmdtId(cmdtId);
        mav.addObject("cmdtId", cmdtId);
        mav.addObject("appId", appId);
        mav.addObject("appStatus", apps.getStatus());
        mav.addObject("appStatusName", apps.getStatusNm());
        mav.addObject("userRole", userRole);
        mav.addObject("cmdtTnved", commodity.get().getHsCode());
        mav.addObject("CmdtPayments", payments);
        mav.addObject("rate", rate);
        return mav;
    }
}