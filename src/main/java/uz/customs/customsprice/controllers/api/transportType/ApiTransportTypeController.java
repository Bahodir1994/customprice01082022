package uz.customs.customsprice.controllers.api.transportType;

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
@RequestMapping("/transporttyperestapi")
public class ApiTransportTypeController {
    private final AppsService appsService;
    private final TransportTypeService transportTypeService;

    public ApiTransportTypeController(AppsService appsService, TransportTypeService transportTypeService) {
        this.appsService = appsService;
        this.transportTypeService = transportTypeService;
    }


    @PostMapping
    public ResponseEntity<Object> valuesave(@RequestBody @Valid TransportType transportType, BindingResult br) {
        Map<String, String> errors = new HashMap<>();
        if (br.hasErrors()) {
            errors = br.getFieldErrors().stream().collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
            errors.put("message", "Error");
            errors.put("status", "400");
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        } else {
            Optional<Apps> appIdGet = Optional.ofNullable(appsService.findById(transportType.getAppId()));
            if (appIdGet.isPresent()) {
                transportTypeService.savetrtype(transportType);
                return ResponseHandler.generateResponse("TransportType ma`lumotlari saqlandi!", HttpStatus.OK, transportType);
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
