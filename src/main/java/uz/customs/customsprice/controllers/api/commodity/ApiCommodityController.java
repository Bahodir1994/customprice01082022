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

    public ApiCommodityController(AppsService appsService, CommodityService commodityService, ConturyService conturyService, MethodService methodService, PackagingService packagingService, Tnved2Service tnved2Service) {
        this.appsService = appsService;
        this.commodityService = commodityService;
        this.conturyService = conturyService;
        this.methodService = methodService;
        this.packagingService = packagingService;
        this.tnved2Service = tnved2Service;
    }


    @PostMapping
    public ResponseEntity<Object> valuesave(@RequestBody @Valid Commodity commodity, BindingResult br) {
        Map<String, String> errors = new HashMap<>();
        if (br.hasErrors()) {
            errors = br.getFieldErrors().stream().collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
            errors.put("message", "Error");
            errors.put("status", "400");
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        } else {
            Optional<Apps> appIdGet = Optional.ofNullable(appsService.findById(commodity.getAppId()));
            if (appIdGet.isPresent()) {
                Country country = conturyService.getByCodeAndLngaTpcd(commodity.getOriginCountry(), "UZ");
                commodity.setOrignCountrNm(country.getCdNm());

                Method method = methodService.getById(commodity.getMethod());
                commodity.setMethodNm(method.getName());

                Packaging packaging = packagingService.getByIdAndLngaTpcd(commodity.getPackType(), "UZ");
                commodity.setPackTypeNm(packaging.getCdNm());

                Tnved2 tnved2 = tnved2Service.getByIdAndFinishdate(commodity.getHsCode());
                commodity.setHsName(tnved2.getName());

                commodityService.saveCommodity(commodity);
                return ResponseHandler.generateResponse("Commodity ma`lumotlari saqlandi!", HttpStatus.OK, commodity);
            } else {
                JSONObject obj = new JSONObject();
                obj.put("message", "Error");
                obj.put("appId", "Топилмади!");
                obj.put("status", "400");
                return new ResponseEntity<>(obj.toMap(), HttpStatus.OK);
            }
        }
    }
}
