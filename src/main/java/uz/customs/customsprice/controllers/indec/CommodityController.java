package uz.customs.customsprice.controllers.indec;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uz.customs.customsprice.entity.InitialDecision.*;
import uz.customs.customsprice.entity.Rate.Rate20;
import uz.customs.customsprice.entity.Rate.Rate27New;
import uz.customs.customsprice.entity.Rate.Rate29;
import uz.customs.customsprice.entity.files.Docs;
import uz.customs.customsprice.payload.ResponseCustom;
import uz.customs.customsprice.repository.CommodityRepo;
import uz.customs.customsprice.service.*;
import uz.customs.customsprice.service.Rate.Rate20Service;
import uz.customs.customsprice.service.Rate.Rate27NewService;
import uz.customs.customsprice.service.Rate.Rate29Service;
import uz.customs.customsprice.utils.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/commodity")
public class CommodityController {
    //    Date date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
    Date date = new Date();

    private final CommodityService commodityService;
    private final CommodityRepo commodityRepo;
    private final AppsService appsservice;
    private final RollbackSpService rollbackSpService;
    private final DocsService docsService;
    private final PaymentTypeService paymentTypeService;
    private final PaymTypeService paymTypeService;
    private final ExchangerateService exchangerateService;
    private final Rate20Service rate20Service;
    private final Rate27NewService rate27NewService;
    private final Rate29Service rate29Service;
    private final PaymentServise paymentServise;
    private final AppsService appsService;


    private final String INITIALDECISIONVIEWCMDT = "/resources/pages/InitialDecision/InitialDecisionSteps/Steps";
    private final String INITIALDECISIONVIEWCMDTVAL = "/resources/pages/InitialDecision/InitialDecisionSteps/Steps44";
    private final String INDECCALCULATING = "/resources/pages/InitialDecision/InitialDecisionSteps/Steps4";

    public CommodityController(CommodityService commodityService, CommodityRepo commodityRepo, AppsService appsservice, RollbackSpService rollbackSpService, DocsService docsService, PaymentTypeService paymentTypeService, PaymTypeService paymTypeService, ExchangerateService exchangerateService, Rate20Service rate20Service, Rate27NewService rate27NewService, Rate29Service rate29Service, PaymentServise paymentServise, AppsService appsService) {
        this.commodityService = commodityService;
        this.commodityRepo = commodityRepo;
        this.appsservice = appsservice;
        this.rollbackSpService = rollbackSpService;
        this.docsService = docsService;
        this.paymentTypeService = paymentTypeService;
        this.paymTypeService = paymTypeService;
        this.exchangerateService = exchangerateService;
        this.rate20Service = rate20Service;
        this.rate27NewService = rate27NewService;
        this.rate29Service = rate29Service;
        this.paymentServise = paymentServise;
        this.appsService = appsService;
    }


    @PostMapping(value = INITIALDECISIONVIEWCMDT)
    @ResponseBody
    public ModelAndView InitialDecisionViewCmdt(HttpSession session, HttpServletRequest request, @RequestParam String cmdt_id, @RequestParam Integer x, @RequestParam String appId, @RequestParam(defaultValue = "0") String paymentType) {


        String COMMODITY_ID = Utils.nullClear(String.valueOf(session.getAttribute("COMMODITY_ID")));
        String APPLICATION_ID = Utils.nullClear(String.valueOf(session.getAttribute("APPLICATION_ID")));
        ModelAndView mav = new ModelAndView();

        Integer userRole = (Integer) request.getSession().getAttribute("userRole");
        Apps apps = appsservice.findById(APPLICATION_ID);
        List<Commodity> commodityList = appsservice.getCommodityList(cmdt_id);
        List<Docs> docsList = appsservice.getDocsListAppId(APPLICATION_ID);
        List<RollbackSp> listRollbackSp = rollbackSpService.getlistRollbackSp();
        List<PaymenttypeEntity> paymenttypeEntityList = paymentTypeService.getListPaymentType();
        List<PaymtypeEntity> paymtypeEntityList = paymTypeService.getListPaymType();

        mav.addObject("commodity", commodityList);
        mav.addObject("docsList", docsList);
        mav.addObject("rollbackInfo", listRollbackSp);
        mav.addObject("cmdtId", COMMODITY_ID);
        mav.addObject("paymenttype", paymenttypeEntityList);
        mav.addObject("paymttype", paymtypeEntityList);
        mav.addObject("appInfo", apps);

//
//        ModelAndView mav1 = new ModelAndView("resources/pages/InitialDecision/InitialDecisionSteps/Steps1");
//        ModelAndView mav2 = new ModelAndView("resources/pages/InitialDecision/InitialDecisionSteps/Steps2");
//        ModelAndView mav3 = new ModelAndView("resources/pages/InitialDecision/InitialDecisionSteps/Steps3");
//        ModelAndView mav4 = new ModelAndView("resources/pages/InitialDecision/InitialDecisionSteps/Steps4");
//        ModelAndView mav5 = new ModelAndView("resources/pages/InitialDecision/InitialDecisionSteps/Steps4Status145");
//        ModelAndView mav6 = new ModelAndView("resources/pages/InitialDecision/InitialDecisionSteps/Steps4Status160");
//        ModelAndView mav7 = new ModelAndView("resources/pages/InitialDecision/InitialDecisionSteps/Steps4StatusDefault");

        return mav;
    }

    @PostMapping(value = INITIALDECISIONVIEWCMDTVAL)
    public ResponseEntity<ResponseCustom> InitialDecisionViewCmdtTol(HttpSession session, HttpServletRequest request, @RequestParam String cmdt_id, @RequestParam Integer x, @RequestParam String appId, @RequestParam(defaultValue = "0") String paymentType) {

        ResponseCustom responseCustom = new ResponseCustom();

        Optional<Commodity> commodity = commodityService.getById(cmdt_id);
        String currCode = commodity.get().getCurrencyType();
        String tnved = commodity.get().getHsCode();
        BigDecimal g47AltRate = BigDecimal.valueOf(0.0);
        String g47AltBaseEdIzm = commodity.get().getExtraUnits(); //todo (Қўшимча ўлчов бирлиги коди)
        if (Utils.nullClear(g47AltBaseEdIzm).equals("166")) g47AltRate = commodity.get().getNetto(); //todo (Хос ставка миқдори)
        else g47AltRate = commodity.get().getExtraQty(); //todo (Хос ставка миқдори)

        Exchangerate exchangerate = exchangerateService.getTop1ByIdOrderByDateSetDesc(currCode);
        Exchangerate exchangerate840 = exchangerateService.getTop1ByIdOrderByDateSetDesc("840");
        BigDecimal rate = BigDecimal.valueOf(exchangerate.getRate()).multiply(BigDecimal.valueOf(exchangerate.getAmount()));
        BigDecimal rate840 = BigDecimal.valueOf(exchangerate840.getRate()).multiply(BigDecimal.valueOf(exchangerate840.getAmount()));
        BigDecimal cmdtPrice = commodity.get().getPrice();
        BigDecimal g47AltBase = BigDecimal.valueOf(0.0); //todo (Адвалор ставка)
        BigDecimal g47Rate = BigDecimal.valueOf(0.0); //todo (Хос ставка)
        BigDecimal g47Base = cmdtPrice.multiply(rate); // todo (Хисоблаш асоси)
        BigDecimal g47Base2 = cmdtPrice.multiply(rate); // todo (Хисоблаш асоси 2)
        System.out.println(g47Base2);
        BigDecimal sumAll = BigDecimal.valueOf(0.0);
        BigDecimal g47Sum = BigDecimal.valueOf(0.0);
        String unitRate = "";
        short typeRate = 0;
        BigDecimal advRate = BigDecimal.valueOf(0.0);
        BigDecimal altRate = BigDecimal.valueOf(0.0);

        String paymentTypeS = Utils.nullClear(paymentType);
        String g47ClcType = "";
        if (!"".equals(paymentTypeS) && !"0".equals(paymentTypeS)) {

            if ("20".equals(paymentTypeS)) {
                Rate20 rate20 = rate20Service.getdByTnved(tnved);
                typeRate = rate20.getTypeRate();
                unitRate = rate20.getUnitRateCode();
                advRate = rate20.getAdvRate();
                altRate = rate20.getAltRate();

                if (typeRate == 0) {
                    g47AltBase = (g47Base.multiply(advRate)).divide(BigDecimal.valueOf(100));
                    g47Rate = BigDecimal.valueOf(0.0);
                    g47Sum = g47AltBase;
                }

                if (typeRate == 1) {
                    g47AltBase = (g47Base.multiply(advRate)).divide(BigDecimal.valueOf(100));
//                    g47AltBase = (g47Base * Double.parseDouble(String.valueOf(advRate))) / 100;
                    if (unitRate.equals(g47AltBaseEdIzm)) {
                        g47Rate = altRate.multiply(g47AltRate).multiply(rate840);
                    } else {
                        g47Rate = BigDecimal.valueOf(0.0);

                    }

                    int res;
                    res = g47AltBase.compareTo(g47Rate); // compare bg1 with bg2
                    String str1 = " Қийматлар ўзаро тенг ";
                    String str2 = " 1 чи қиймат катта ";
                    String str3 = " 2 чи қиймат катта ";

                    if (res == 0) {
                        System.out.println(str1);
                    } else if (res == 1) {
                        g47Sum = g47AltBase;
                        System.out.println(str2);
                    } else if (res == -1) {
                        g47Sum = g47AltRate;
                        System.out.println(str3);
                    }
                }

                if (typeRate == 2) {
                    g47AltBase = (g47Base.multiply(advRate)).divide(BigDecimal.valueOf(100));
                    if (unitRate.equals(g47AltBaseEdIzm)) {
                        g47Rate = altRate.multiply(g47AltRate).multiply(rate840);
                    } else {
                        g47Rate = BigDecimal.valueOf(0.0);
                    }
                    g47Sum = g47AltBase.add(g47Rate);
                }
                g47ClcType = String.valueOf(typeRate);
            }

            if ("27".equals(paymentTypeS)) {
                Rate27New rate27New = rate27NewService.getdByTnved(tnved);
                if (!Utils.nullClear(rate27New).equals("")) {
                    typeRate = rate27New.getTypeRate();
                    unitRate = rate27New.getUnitRateCode();
                    advRate = rate27New.getAdvRate();
                    altRate = rate27New.getAltRate();
                }

                if (typeRate == 0) {
                    g47AltBase = g47Base.multiply(advRate).divide(BigDecimal.valueOf(100));
                    g47Rate = BigDecimal.valueOf(0.0);
                    g47Sum = g47AltBase;
                }

                if (typeRate == 1) {
                    g47AltBase = (g47Base.multiply(advRate)).divide(BigDecimal.valueOf(100));
                    if (unitRate.equals(g47AltBaseEdIzm)) {
                        g47Rate = altRate.multiply(g47AltRate).multiply(rate840);
                    } else {
                        g47Rate = BigDecimal.valueOf(0.0);

                    }
                    int res;
                    res = g47AltBase.compareTo(g47Rate); // compare bg1 with bg2
                    String str1 = " Қийматлар ўзаро тенг ";
                    String str2 = " 1 чи қиймат катта ";
                    String str3 = " 2 чи қиймат катта ";

                    if (res == 0) {
                        g47Sum = g47AltBase;
                        System.out.println(str1);
                    } else if (res == 1) {
                        g47Sum = g47AltBase;
                        System.out.println(str2);
                    } else if (res == -1) {
                        g47Sum = g47AltRate;
                        System.out.println(str3);
                    }
                }

                if (typeRate == 2) {
                    g47AltBase = (g47Base.multiply(advRate)).divide(BigDecimal.valueOf(100));
                    if (unitRate.equals(g47AltBaseEdIzm)) {
                        g47Rate = altRate.multiply(g47AltRate).multiply(rate840);
                    } else {
                        g47Rate = BigDecimal.valueOf(0.0);
                    }
                    g47Sum = g47AltBase.add(g47Rate);
                }
                g47ClcType = String.valueOf(typeRate);
            }

            if ("29".equals(paymentTypeS)) {
                Rate29 rate29 = rate29Service.getdByTnved(tnved);
                advRate = rate29.getVatRate();
                g47Sum = (advRate.multiply(g47Base)).divide(BigDecimal.valueOf(100));

                typeRate = 0;
                g47ClcType = String.valueOf(typeRate);
            }

            if ("10".equals(paymentTypeS)) {
                typeRate = 1;
                g47ClcType = String.valueOf(typeRate);
            }

        }

        String g47Type = "", g47AltBaseCurrKod = "", currRate = "";
        g47Type = paymentType;
//        g47ClcType = String.valueOf(typeRate);
        g47AltBaseCurrKod = String.valueOf(exchangerate840.getId());
        currRate = String.valueOf(rate840);

        responseCustom.setG47Base(String.valueOf(g47Base)); // todo (Хисоблаш асоси)
        responseCustom.setG47AltBase(String.valueOf(g47AltBase)); //todo (Адвалор ставка)
        responseCustom.setG47AltRate(String.valueOf(g47AltRate)); //todo (Хос ставка миқдори)
        responseCustom.setG47Rate(String.valueOf(g47Rate));  //todo (Хос ставка)
        responseCustom.setG47Sum(String.valueOf(g47Sum)); //todo (Ҳисобланган тўловлар)
        responseCustom.setUnitRate(unitRate);  //todo (Хос ставканинг Қўшимча ўлчов бирлигидаги коди)
        responseCustom.setAltRate(altRate.toString()); //todo (Хос ставка миқдорининг бирлик (1 - лик) миқдори)
        responseCustom.setAdvRate(advRate.toString()); //todo (Адвалор ставка фоиздаги миқдори)
        responseCustom.setG47AltBaseEdIzm(g47AltBaseEdIzm); //todo (Қўшимча ўлчов бирлиги коди)
        responseCustom.setRate840(rate840.toString()); //todo (1 - АҚШ долларининг сўмдаги миқдори)
        responseCustom.setTypeRate(String.valueOf(typeRate)); //todo (Ҳисоблаш шакли)
        responseCustom.setG47ClcType(g47ClcType); //todo (Ҳисоблаш шакли)
        responseCustom.setG47Type(String.valueOf(g47Type)); //todo (Тўлов тури)
        responseCustom.setG47AltBaseCurrKod(String.valueOf(g47AltBaseCurrKod)); //todo (валюта коди - бизда ҳозирча фақат АҚШ долларида бўлади)
        responseCustom.setCurrRate(String.valueOf(currRate)); //todo (1 - АҚШ долларининг сўмдаги миқдори)
        responseCustom.toString();
        return ResponseEntity.ok(responseCustom);
    }


    @PostMapping(value = INDECCALCULATING)
    @ResponseBody
    public ModelAndView InitialDecisionCalculating(HttpSession session, HttpServletRequest request, @RequestParam String cmdt_id, @RequestParam String appId) {
        ModelAndView mav = new ModelAndView("resources/pages/InitialDecision/InitialDecisionSteps/Steps4");
        ModelAndView mav2 = new ModelAndView("resources/pages/InitialDecision/InitialDecisionSteps/Steps4StatusDefault");
        Integer userRole = (Integer) request.getSession().getAttribute("userRole");
//        Apps apps = appsservice.findById(appId);
        Optional<Commodity> commodityList = commodityService.getById(cmdt_id);
        Apps apps = appsService.findById(appId);
//        List<Docs> docsList = appsservice.getDocsListAppId(appId);
//        List<RollbackSp> listRollbackSp = rollbackSpService.getlistRollbackSp();
        List<PaymenttypeEntity> paymenttypeEntityList = paymentTypeService.getListPaymentType();
        List<PaymtypeEntity> paymtypeEntityList = paymTypeService.getListPaymType();

        Exchangerate exchangerate840 = exchangerateService.getTop1ByIdOrderByDateSetDesc("840");
        BigDecimal rate = BigDecimal.valueOf(exchangerate840.getRate()).multiply(BigDecimal.valueOf(exchangerate840.getAmount()));

        mav.addObject("commodity", commodityList.get().getHsCode());
//        mav.addObject("docsList", docsList);
//        mav.addObject("rollbackInfo", listRollbackSp);
//        mav.addObject("cmdtId", appId);
        mav.addObject("cmdtId", cmdt_id);
        mav.addObject("appId", appId);
        mav.addObject("paymenttype", paymenttypeEntityList);
        mav.addObject("paymttype", paymtypeEntityList);
        List<Payment> payments = paymentServise.getByCmdtId(cmdt_id);
        Optional<Commodity> commodityTnved = commodityService.getById(cmdt_id);
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
}
