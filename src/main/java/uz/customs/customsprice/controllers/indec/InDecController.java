package uz.customs.customsprice.controllers.indec;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.text.BadElementException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import uz.customs.customsprice.entity.InDec;
import uz.customs.customsprice.entity.InitialDecision.*;
import uz.customs.customsprice.entity.InitialDecision.TPO.Pay;
import uz.customs.customsprice.entity.InitialDecision.TPO.Tpo;
import uz.customs.customsprice.repository.CommodityRepo;
import uz.customs.customsprice.repository.InDecRepo;
import uz.customs.customsprice.repository.PaymentRepo;
import uz.customs.customsprice.repository.Tpo.PayRepository;
import uz.customs.customsprice.repository.Tpo.TpoRepository;
import uz.customs.customsprice.service.*;
import uz.customs.customsprice.service.apps.AppsService;
import uz.customs.customsprice.service.catalog.*;
import uz.customs.customsprice.service.classifier.PackagingService;
import uz.customs.customsprice.service.commodity.CommodityService;
import uz.customs.customsprice.service.payment.PaymTypeService;
import uz.customs.customsprice.service.payment.PaymentServise;
import uz.customs.customsprice.service.payment.PaymentTypeService;
import uz.customs.customsprice.service.pdfGenerating.PdfService;
import uz.customs.customsprice.service.status.StatusHService;
import uz.customs.customsprice.service.status.StatusMService;
import uz.customs.customsprice.service.status.StatusService;
import uz.customs.customsprice.utils.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.*;

@Controller
@RequestMapping("/saveInDec")
public class InDecController {
    private final InDecService inDecService;
    private final InDecRepo inDecRepo;
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
    private final TpoRepository tpoRepository;
    private final PayRepository payRepository;

    @Autowired
    PaymentRepo paymentRepo;

    private final String INITIALDECISIONCONFIRMCMDT = "/resources/pages/InitialDecision/InitialDecisionConfirm";
    private final String INITIALDECISIONTOHTMl = "/resources/pages/InitialDecision/Qaror";
    private final String INITIALDECISIONCONFIRMTOXBB = "/resources/pages/InitialDecision/InitialDecisionConfirToXBB";
    private final String INITIALDECISIONCONFIRMXBBFINISH = "/resources/pages/InitialDecision/InitialDecisionConfirXBBFinish";
    private final String INDEC_GENERATE_PDF = "/resources/pages/InitialDecision/InitialDecisionGeneratePdf";
    private final String INITIALDECISIONCONFIRMCMDT_CALC = "/resources/pages/InitialDecision/InitialDecisionCalc";
    private final String DELETINGCALCUALTE = "/resources/pages/InitialDecision/DeletePayments";
    private final String INITIALDECISIONCONFIRMTPO = "/resources/pages/InitialDecision/InitialDecisionTPO";
    private final String INDECCANCELLED = "/resources/pages/InitialDecision/InitialDecisionCancelled";

    public InDecController(InDecService inDecService, InDecRepo inDecRepo, AppsService appsService, AppsService appsservice, CommodityService commodityService, CommodityRepo commodityRepo, ConturyService conturyService, MethodService methodService, PackagingService packagingService, Tnved2Service tnved2Service, LocationService locationService, StatusService statusService, PdfService pdfService, PaymentServise paymentServise, ExchangerateService exchangerateService, StatusMService statusMService, StatusHService statusHService, PaymentTypeService paymentTypeService, PaymTypeService paymTypeService, UsersService usersService, TpoRepository tpoRepository, PayRepository payRepository) {
        this.inDecService = inDecService;
        this.inDecRepo = inDecRepo;
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
        this.tpoRepository = tpoRepository;
        this.payRepository = payRepository;
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

        List<Commodity> commodityList = commodityService.getListCommdityPayment(appId);
        if (commodityList.size() == 0) {
            Apps apps = appsService.findById(appId);
            Status status1 = statusService.getById(145);

            /** ?????? ??????.?????????????????? ?????? ??????.?????? ???? ???????????????????? ?????????? ???????????? ???????????????? 145-(?????????????????????? ?????????????????????? (?????????????????? ?????????????????? ???????????????? ??????????????????)) **/
            Status status2 = statusService.getById(145);
            apps.setStatus(145);
            apps.setStatusNm(status2.getName());
            appsService.saveAppsStatus(apps);


            /**todo ?????? ???? ???????? start todo**/
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
            /**todo ?????? ???? ???????? end todo**/
        }
        return mav;
    }

    @PostMapping(value = DELETINGCALCUALTE)
    public ModelAndView deleteValue(HttpServletRequest request, @RequestParam String payId, @RequestParam String cmdtId, @RequestParam String appId) {

        int paymentCount = 0;
        List<Payment> payment = commodityService.getListPaymentCount(cmdtId);
        System.out.println("paymentpaymentpayment == " + payment);
        System.out.println("paymentpaymentpayment111== " + payment.get(0));
        paymentCount = Integer.parseInt(String.valueOf(payment.get(0)));
        if (paymentCount == 1) {
            Commodity commodity = commodityService.findById(cmdtId);
            commodity.setPaymentYN("NO");
            commodityService.saveYN(commodity);
        }
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
        if (payments.isEmpty() && userRole == 8 && apps.getStatus() != 125) {
            return mav;
        } else {
            mav2.addObject("CmdtPayments", payments);
            mav2.addObject("cmdtTnved", commodityTnved.get().getHsCode());
            mav2.addObject("cmdtId", commodityTnved.get().getId());
            mav2.addObject("appStatus", apps.getStatus());
            mav2.addObject("appStatusName", apps.getStatusNm());
            mav2.addObject("userRole", userRole);
            mav2.addObject("rate", rate);
//            mav2.addObject("cmdtPaymentYN", commodityService.getByAppId(appId).getPaymentYN());
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
        List<Apps> notSortedList = appsservice.getListNotSorted(request, userLocation, userPost, userId, userRole);
        mav.addObject("notSortedListSize", notSortedList.size());

        List<Apps> sortedList = appsservice.getListSorted(request);
        mav.addObject("sortedListSize", sortedList.size());

        List<InDec> termsList = appsservice.getListInDec(request);
        mav.addObject("termsListSize", termsList.size());

        List<InDec> termsRollBackList = appsservice.getListInDecRollBack(request);
        mav.addObject("termsRollBackListSize", termsRollBackList.size());

        List<Apps> listProcessApp = appsservice.getListProcessApp(request, "115");
        mav.addObject("listProcessAppSize", listProcessApp.size());

        List<Apps> listSubmittedApp = appsservice.getListProcessApp(request, "145");
        mav.addObject("listSubmittedAppSize", listSubmittedApp.size());

        List<Apps> listSignedApp = appsservice.getListProcessApp(request, "160");
        mav.addObject("listSignedAppSize", listSignedApp.size());

        /** mav object end **/

        /**todo ?????? ???? ???????? start todo**/
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
        /**todo ?????? ???? ???????? end todo**/

        return mav;
    }

    @PostMapping(value = INITIALDECISIONCONFIRMXBBFINISH)
    public ModelAndView saveFromXBB(InDec inDec, HttpServletRequest request, @RequestParam String cmdtId, @RequestParam String appId) throws IOException, BadElementException, ParseException {
        ModelAndView mav = new ModelAndView("resources/pages/InitialDecision/ListInDec");

        String userId = (String) request.getSession().getAttribute("userId");
        String userName = (String) request.getSession().getAttribute("userName");
        Integer userRole = (Integer) request.getSession().getAttribute("userRole");
        String userRoleName = (String) request.getSession().getAttribute("userRoleName");
        String userLocation = (String) request.getSession().getAttribute("userLocation");
        String userLocationName = (String) request.getSession().getAttribute("userLocationName");
        String userPost = (String) request.getSession().getAttribute("userPost");
        Optional<Commodity> commodity = commodityService.getById(cmdtId);
        Status status1 = statusService.getById(180);

        Apps apps = appsService.findById(appId);
        Status status2 = statusService.getById(170);

        apps.setStatus(170);
        apps.setStatusNm(status2.getName());
        appsService.saveAppsStatus(apps);

        /**todo ???????????????? ?????????? ???????????????????????????? ?????????????????????????? **/
        inDec.setCmdtId(cmdtId);
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


        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, 90); //minus number would decrement the days
        System.out.println(cal.getTime());

        inDec.setInDecEndDate(cal.getTime());
        inDec.setStatus(status1.getId());
        inDec.setStatusNm(status1.getName());
        inDecService.saveInDecS(inDec, userLocation);
        /** mav object start **/


        /**todo ?????? ???? ???????? start todo**/
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
        /**todo ?????? ???? ???????? end todo**/

        Apps appsFindChangeProccess = appsService.getByAppNumAndStatus(apps.getAppNum(), 172);
        if (appsFindChangeProccess != null){
            appsFindChangeProccess.setStatus(171);
            Status status = statusService.getById(171);
            appsFindChangeProccess.setStatusNm(status.getName());
            appsService.saveAppsOne(appsFindChangeProccess);

            List<Commodity> commodityChange = new ArrayList<>();
            commodityChange = commodityService.getListAppId(appsFindChangeProccess.getId());

            List<Commodity> commodityList = new ArrayList<>();
            commodityList = commodityService.getListAppId(apps.getId());
            for (int i = 0; i <commodityChange.size();  i++) {
                try {
                    InDec inDecToMark = new InDec();
                    inDecToMark = inDecService.getByCmtdId(commodityChange.get(i).getId());
                    if (inDecToMark != null){
                        inDecToMark.setEndActiv(200);
                        inDecToMark.setCommentEnded("?????????????????? ?????????????? ???????????????????? ?????????????? ?????????????? ?????????? ??????????????");
                        inDecService.saveInDecOne(inDecToMark);

                        InDec inDecNewEdit = new InDec();
                        inDecNewEdit = inDecService.getByCmtdId(commodityList.get(i).getId());
                        inDecNewEdit.setInDecNum(inDecToMark.getInDecNum());
                        inDecNewEdit.setInDecDate(inDecToMark.getInDecDate());
                        inDecNewEdit.setInDecEndDate(inDecToMark.getInDecEndDate());
                        inDecNewEdit.setStatus(inDecToMark.getStatus());
                        inDecNewEdit.setStatusNm(inDecToMark.getStatusNm());

                        inDecNewEdit.setG19Base(inDecToMark.getG19Base());
                        inDecNewEdit.setG19Sum(inDecToMark.getG19Sum());
                        inDecNewEdit.setG3a(inDecToMark.getG3a());
                        inDecNewEdit.setG3b(inDecToMark.getG3b());
                        inDecNewEdit.setG3c(inDecToMark.getG3c());
                        inDecNewEdit.setPayId(inDecToMark.getPayId());
                        inDecNewEdit.setStavka(inDecToMark.getStavka());
                        inDecNewEdit.setTpoId(inDecToMark.getTpoId());
                        String versionNum = "2";
                        inDecNewEdit.setVersionNum(versionNum);
                        inDecNewEdit.setCommentMarks(inDecToMark.getUpdTime().toString().substring(0, 10)+" ("+inDecToMark.getUpdTime().toString().substring(11, 16)+") "+" ???????????? ?????????????????? ?????????????? ???????????????????? ??????????????????");
                        inDecService.saveInDecOne(inDecNewEdit);
                    }
                    return mav;
                }catch (Exception ee){
                    System.out.println(ee);
                    return null;
                }
            }

            }
        return mav;
    }

    @PostMapping(value = INITIALDECISIONCONFIRMTPO)
    public ResponseEntity<Object> saveTPO(
            @RequestBody @Valid TpoValidDTO tpoValidDTO,
            BindingResult result,
            HttpServletRequest request
    ) throws IOException, BadElementException {

        String userId = (String) request.getSession().getAttribute("userId");
        String userName = (String) request.getSession().getAttribute("userName");
        Integer userRole = (Integer) request.getSession().getAttribute("userRole");
        String userRoleName = (String) request.getSession().getAttribute("userRoleName");
        String userLocation = (String) request.getSession().getAttribute("userLocation");
        String userLocationName = (String) request.getSession().getAttribute("userLocationName");
        String userPost = (String) request.getSession().getAttribute("userPost");

        Map<String, String> errors = new HashMap<>();
        JSONObject obj = new JSONObject();

        String g3a = Utils.nullClear(tpoValidDTO.getG3a());
        Date g3b = null;
        if (!Objects.equals(tpoValidDTO.getG3b(), "")) {
            g3b = java.sql.Date.valueOf(tpoValidDTO.getG3b());
        }
        String g3c = Utils.nullClear(tpoValidDTO.getG3c());
        InDec inDec = inDecRepo.findByG3aAndG3bAndG3c(g3a, g3b, g3c);
        InDec inDec1 = inDecService.getById(tpoValidDTO.getInDecId());

        if (!Utils.nullClear(inDec).equals("") && Utils.nullClear(inDec.getG3a()).equals(g3a) && inDec.getG3b().equals(g3b) && Utils.nullClear(inDec.getG3c()).equals(g3c)) {
            obj.put("message", "???????? ?????? ???????????? ?????????? ????????????????????, ?????????? ?????? ????????????????!");
            obj.put("status", HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(obj.toMap(), HttpStatus.BAD_REQUEST);
        } else {
            Tpo tpo = new Tpo();
            Pay pay = new Pay();
            tpo = tpoRepository.findByG3AAndG3BAndG3C(g3a, g3b, g3c);
            if (tpo == null) {
                obj.put("message", "???????? ?????? ??????????????????");
                obj.put("status", HttpStatus.BAD_REQUEST);
                return new ResponseEntity<>(obj.toMap(), HttpStatus.BAD_REQUEST);
            }
            String g19Type = "50";
            pay = payRepository.findByIdTpo(Utils.nullClear(tpo.getId()));
            if (!Utils.nullClear(pay).equals("") && !Utils.nullClear(pay.getG19Type()).equals("")) {
                inDec1.setStatus(185);
                Status status = statusService.getById(185);
                inDec1.setStatusNm(status.getName());
                inDec1.setTpoId(pay.getIdTpo());
                inDec1.setPayId(pay.getIdPay());
                inDec1.setG3a(g3a);
                inDec1.setG3b(g3b);
                inDec1.setG3c(g3c);
                inDec1.setG19Base(pay.getG19Base());
                inDec1.setStavka(pay.getStavka());
                inDec1.setG19Sum(pay.getG19Sum());
                inDecService.saveInDecOne(inDec1);
                return ResponseEntity.status(201).body(inDec1);
            } else {
                obj.put("message", "???????? ?????? ???????????????????????? ??????????????????");
                obj.put("status", HttpStatus.BAD_REQUEST);
                return new ResponseEntity<>(obj.toMap(), HttpStatus.BAD_REQUEST);
            }
        }
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
        Commodity commodity1 = commodityService.findById(cmdtId);
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

    @PostMapping(value = INDECCANCELLED)
    public ModelAndView saveInDecCancelled(HttpServletRequest request, @RequestParam String inDecId, @RequestParam String TPO_NUM) throws IOException, BadElementException {
        ModelAndView mav = new ModelAndView("resources/pages/InitialDecision/ListInDec/ListInDecTerms");
        String userId = (String) request.getSession().getAttribute("userId");
        String userName = (String) request.getSession().getAttribute("userName");
        Integer userRole = (Integer) request.getSession().getAttribute("userRole");
        String userRoleName = (String) request.getSession().getAttribute("userRoleName");
        String userLocation = (String) request.getSession().getAttribute("userLocation");
        String userLocationName = (String) request.getSession().getAttribute("userLocationName");
        String userPost = (String) request.getSession().getAttribute("userPost");


        InDec inDec1 = inDecService.getById(inDecId);
        inDec1.setEndActiv(200);
        inDec1.setCommentEnded(TPO_NUM);
        Date date1 = Calendar.getInstance().getTime();
        inDec1.setInDecUserEndedDate(date1);
        inDecService.saveInDecOne(inDec1);

        Commodity commodity = new Commodity();
        commodity = commodityService.findById(inDec1.getCmdtId());

        Apps apps = new Apps();
        apps = appsService.findById(commodity.getAppId());

        Status status = new Status();
        status = statusService.getById(195);

        apps.setStatus(195);
        apps.setStatusNm(status.getName());
        appsService.saveAppsOne(apps);

        /**todo ?????? ???? ???????? start todo**/
        StatusM statusM = statusMService.getByAppId(apps.getId());
        statusM.setStatus(String.valueOf(195));
        statusM.setStatusComment(status.getName());
        statusM.setInsUser(userId);
        statusMService.saveStatusM(statusM);

        StatusH statusH = new StatusH();
        statusH.setStmainID(statusM.getId());
        statusH.setAppId(statusM.getAppId());
        statusH.setStatus(String.valueOf(195));
        statusH.setStatusComment(status.getName());
        statusH.setInsUser(userId);
        statusH.setComment("?????????? ??????????????");
        statusHService.saveStatusH(statusH);
        /**todo ?????? ???? ???????? end todo**/

        List<InDec> termsList = appsservice.getListInDec(request);
        mav.addObject("termsList", termsList);
        mav.addObject("userRole", userRole);

        return mav;
    }

}

