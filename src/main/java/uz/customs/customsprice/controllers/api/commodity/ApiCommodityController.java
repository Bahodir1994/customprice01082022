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
import uz.customs.customsprice.controllers.api.helper.ResponseHandler;
import uz.customs.customsprice.entity.InitialDecision.*;
import uz.customs.customsprice.repository.CommodityRepo;
import uz.customs.customsprice.repository.CurrencyEntityRepo;
import uz.customs.customsprice.service.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
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


    public ApiCommodityController(AppsService appsService, CommodityService commodityService, ConturyService conturyService, MethodService methodService, PackagingService packagingService, Tnved2Service tnved2Service, CurrencyEntityRepo currencyEntityRepo, CommodityRepo commodityRepo, StatusService statusService, StatusHService statusHService, StatusMService statusMService) {
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
    }


    @PostMapping
    public ResponseEntity<Object> valuesave(@RequestBody @Valid Commodity commodity, BindingResult br) {
        Map<String, String> errors = new HashMap<>();
        if (br.hasErrors()) {
            errors = br.getFieldErrors().stream().collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
            errors.put("message", "Error");
            errors.put("status", "400");
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }
        else {
            Optional<Apps> appIdGet = Optional.ofNullable(appsService.findById(commodity.getAppId()));
            Commodity commodity1 = new Commodity();
            commodity1 = commodityService.getByAppId(commodity.getAppId());
            Apps apps = new Apps();
            apps = appsService.findById(commodity.getAppId());
            if (commodity1 != null && !commodity1.equals("null") && !commodity1.equals("")) {
                commodityRepo.deleteAllByAppId(commodity.getAppId());
                apps = appsService.findById(commodity.getAppId());
                apps.setStatus(135);
                Status status = statusService.getById(135);
                apps.setStatusNm(status.getName());
                appsService.saveAppsOne(apps);


                /*todo commodity start*/
                Country country = conturyService.getByCodeAndLngaTpcd(commodity.getOriginCountry(), "UZ");
                commodity.setOrignCountrNm(country.getCdNm());

                Method method = methodService.getById(commodity.getMethod());
                commodity.setMethodNm(method.getName());

                Packaging packaging = packagingService.getByIdAndLngaTpcd(commodity.getPackType(), "UZ");
                commodity.setPackTypeNm(packaging.getCdNm());

                Tnved2 tnved2 = tnved2Service.getByIdAndFinishdate(commodity.getHsCode());
                commodity.setHsName(tnved2.getName());

                CurrencyEntity currencyEntity = currencyEntityRepo.findByCodeAndLngaTpcd(commodity.getCurrencyType(), "RU");
                commodity.setCurrencyNm(currencyEntity.getCdDesc());
                commodity.setCurrencyNmSymbol(currencyEntity.getCdId());

                if (commodity.getHsDecDate() != null && !"".equals(String.valueOf(commodity.getHsDecDate())) && !"null".equals(String.valueOf(commodity.getHsDecDate())))
                    commodity.setHsDecDate(commodity.getHsDecDate());
                if (commodity.getInDecDate() != null && !"".equals(String.valueOf(commodity.getInDecDate())) && !"null".equals(String.valueOf(commodity.getInDecDate())))
                    commodity.setInDecDate(commodity.getInDecDate());
                if (commodity.getInDecNum() != null && !"".equals(commodity.getInDecNum()) && !"null".equals(commodity.getInDecNum()))
                    commodity.setInDecNum(commodity.getInDecNum());
                if (commodity.getExtraUnits() != null && !"".equals(commodity.getExtraUnits()) && !"null".equals(commodity.getExtraUnits()))
                    commodity.setExtraUnits(commodity.getExtraUnits());
                commodityService.saveCommodity(commodity);
                /*todo commodity end*/


                /**todo ЛОК га ёзиш start todo**/
                StatusM statusM = statusMService.getByAppId(apps.getId());
//                StatusM statusM = new StatusM();
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
            }
            else {
                if (appIdGet.isPresent()) {
                    Country country = conturyService.getByCodeAndLngaTpcd(commodity.getOriginCountry(), "UZ");
                    commodity.setOrignCountrNm(country.getCdNm());

                    Method method = methodService.getById(commodity.getMethod());
                    commodity.setMethodNm(method.getName());

                    Packaging packaging = packagingService.getByIdAndLngaTpcd(commodity.getPackType(), "UZ");
                    commodity.setPackTypeNm(packaging.getCdNm());

                    Tnved2 tnved2 = tnved2Service.getByIdAndFinishdate(commodity.getHsCode());
                    commodity.setHsName(tnved2.getName());

                    CurrencyEntity currencyEntity = currencyEntityRepo.findByCodeAndLngaTpcd(commodity.getCurrencyType(), "RU");
                    commodity.setCurrencyNm(currencyEntity.getCdDesc());
                    commodity.setCurrencyNmSymbol(currencyEntity.getCdId());

                    if (commodity.getHsDecDate() != null && !"".equals(String.valueOf(commodity.getHsDecDate())) && !"null".equals(String.valueOf(commodity.getHsDecDate())))
                        commodity.setHsDecDate(commodity.getHsDecDate());
                    if (commodity.getInDecDate() != null && !"".equals(String.valueOf(commodity.getInDecDate())) && !"null".equals(String.valueOf(commodity.getInDecDate())))
                        commodity.setInDecDate(commodity.getInDecDate());
                    if (commodity.getInDecNum() != null && !"".equals(commodity.getInDecNum()) && !"null".equals(commodity.getInDecNum()))
                        commodity.setInDecNum(commodity.getInDecNum());
                    if (commodity.getExtraUnits() != null && !"".equals(commodity.getExtraUnits()) && !"null".equals(commodity.getExtraUnits()))
                        commodity.setExtraUnits(commodity.getExtraUnits());
                    commodityService.saveCommodity(commodity);

                    apps.setStatus(100);
                    Status status = statusService.getById(100);
                    apps.setStatusNm(status.getName());
                    appsService.saveAppsOne(apps);

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
//                    /**todo ЛОК га ёзиш end todo**/

                    return ResponseHandler.generateResponse("Commodity ma`lumotlari saqlandi!", HttpStatus.OK, commodity);
                }
                else {
                    JSONObject obj = new JSONObject();
                    obj.put("message", "Error");
                    obj.put("appId", "Топилмади!");
                    obj.put("status", "400");
                    return new ResponseEntity<>(obj.toMap(), HttpStatus.OK);
                }
            }

        }
        return null;
    }
}
