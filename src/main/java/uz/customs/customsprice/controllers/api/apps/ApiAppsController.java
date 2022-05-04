package uz.customs.customsprice.controllers.api.apps;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.customs.customsprice.controllers.api.files.AppsAndDocsAndTransportsDTO;
import uz.customs.customsprice.controllers.api.helper.ResponseHandler;
import uz.customs.customsprice.entity.InitialDecision.*;
import uz.customs.customsprice.entity.earxiv.Earxiv;
import uz.customs.customsprice.repository.EarxivRepo;
import uz.customs.customsprice.service.*;
import uz.customs.customsprice.service.earxiv.EarxivService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/appsrestapi")
public class ApiAppsController {
    private final AppsService appsService;
    private final ConturyService conturyService;
    private final LocationService locationService;
    private final StatusService statusService;
    private final TermsService termsService;
    private final PersonsService personsService;
    private final StatusHService statusHService;
    private final StatusMService statusMService;
    private final TransportTypeService transportTypeService;
    private final EarxivService earxivService;
    private final EarxivRepo earxivRepo;

    public ApiAppsController(AppsService appsService, ConturyService conturyService, LocationService locationService, StatusService statusService, TermsService termsService, PersonsService personsService, StatusHService statusHService, StatusMService statusMService, TransportTypeService transportTypeService, EarxivService earxivService, EarxivRepo earxivRepo) {
        this.appsService = appsService;
        this.conturyService = conturyService;
        this.locationService = locationService;
        this.statusService = statusService;
        this.termsService = termsService;
        this.personsService = personsService;
        this.statusHService = statusHService;
        this.statusMService = statusMService;
        this.transportTypeService = transportTypeService;
        this.earxivService = earxivService;
        this.earxivRepo = earxivRepo;
    }
    /*---------------------------------------------------------------------------------------------------------start*/
    /* Apps маълумотларини API орқали сақлаш учун учун*/
    @PostMapping
    public ResponseEntity<Object> valuesave(@RequestBody AppsAndDocsAndTransportsDTO appsAndDocsAndTransportsDTO, HttpServletRequest request, BindingResult br) {
        Map<String, String> errors = new HashMap<>();
        Apps apps = appsAndDocsAndTransportsDTO.getApps();
        List<TransportType> transportTypes = appsAndDocsAndTransportsDTO.getTransports();
        List<Earxiv> earxivS = appsAndDocsAndTransportsDTO.getDocs();
        if (br.hasErrors()) {
            errors = br.getFieldErrors().stream().collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
            JSONObject obj = new JSONObject();
            obj.put("message", "Error");
            obj.put("errors", errors);
            obj.put("status", "400");
            return new ResponseEntity<>(obj.toMap(), HttpStatus.BAD_REQUEST);
        } else {
            Optional<Persons> personsIdGet = personsService.getById(apps.getPersonId());
            if (personsIdGet.isPresent()) {
                Country country = conturyService.getByCodeAndLngaTpcd(apps.getCustomerCountry(), "UZ");
                apps.setCustomerCountryNm(country.getCdNm());

                country = conturyService.getByCodeAndLngaTpcd(apps.getSenderCountry(), "UZ");
                apps.setSenderCountryNm(country.getCdNm());

                Location location = locationService.getById(apps.getLocationId());
                apps.setLocationNm(location.getName1());

                Status status = statusService.getById(apps.getStatus());
                apps.setStatusNm(status.getName());

                Terms terms = termsService.findByIdAndLngaTpcd(apps.getTerms(), "UZ");
                apps.setTermsNm(terms.getSign());

                apps.setInsUser(personsIdGet.get().getTin());
                appsService.saveApps(apps);
                apps.getId();
                for (int i = 0; i < transportTypes.size(); i++) {
                    errors = new HashMap<>();
                    if (br.hasErrors()) {
                        errors = br.getFieldErrors().stream().collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
                        errors.put("message", "Error");
                        errors.put("status", "400");
                        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
                    } else {
                        Optional<Apps> appIdGet = Optional.ofNullable(appsService.findById(apps.getId()));
                        if (appIdGet.isPresent()) {
                            TransportType transportType = new TransportType();
                            transportType.setAppId(apps.getId());
                            transportType.setFinishCountry(transportTypes.get(i).getFinishCountry());
                            transportType.setEndCountry(transportTypes.get(i).getEndCountry());
                            transportType.setTarnsportType(transportTypes.get(i).getTarnsportType());
                            transportType.setTransportPrice(transportTypes.get(i).getTransportPrice());
                            transportTypeService.savetrtype(transportType);
                            ResponseHandler.generateResponse("TransportType ma`lumotlari saqlandi!", HttpStatus.OK, transportType);
                        } else {
                            JSONObject obj = new JSONObject();
                            obj.put("message", "Error");
                            obj.put("appId", "Ариза ID Топилмади!");
                            obj.put("status", "400");
                            return new ResponseEntity<>(obj.toMap(), HttpStatus.OK);
                        }
                    }
                }
                for (int i = 0; i < earxivS.size(); i++) {
                    Earxiv earxiv = new Earxiv();
                    List<Object[]> fileList = earxivService.getFile1(earxivS.get(i).getFileId());
                    if (fileList.size() > 0) {
                        earxiv.setAppId(apps.getId());
                        earxiv.setFolderId(fileList.get(0)[0] != null ? fileList.get(0)[0].toString() : "");
                        earxiv.setName(fileList.get(0)[1] != null ? fileList.get(0)[1].toString() : "");
                        earxiv.setUserInn(fileList.get(0)[2] != null ? fileList.get(0)[2].toString() : "");
                        earxiv.setUserPnfl(fileList.get(0)[3] != null ? fileList.get(0)[3].toString() : "");
                        earxiv.setDocname(fileList.get(0)[4] != null ? fileList.get(0)[4].toString() : "");
                        earxiv.setDocType(fileList.get(0)[5] != null ? fileList.get(0)[5].toString() : "");
                        earxiv.setFileId(fileList.get(0)[6] != null ? fileList.get(0)[6].toString() : "");
                        earxiv.setStatus(fileList.get(0)[7] != null ? fileList.get(0)[7].toString() : "");
                        earxiv.setDocTypeName(fileList.get(0)[8] != null ? fileList.get(0)[8].toString() : "");
                        earxiv.setHash(fileList.get(0)[9] != null ? fileList.get(0)[9].toString() : "");
                    } else {
                        earxiv.setAppId("");
                        earxiv.setFolderId("");
                        earxiv.setName("");
                        earxiv.setUserInn("");
                        earxiv.setUserPnfl("");
                        earxiv.setDocname("");
                        earxiv.setDocType("");
                        earxiv.setDocTypeName("");
                        earxiv.setFileId("");
                        earxiv.setStatus("");
                        earxiv.setHash("");
                    }
                    earxivService.create(earxiv);
                    ResponseHandler.generateResponse("Xujjat ma`lumotlari saqlandi!", HttpStatus.OK, earxiv);
                }


                /**todo ЛОК га ёзиш start todo**/
                StatusM statusM = new StatusM();
                statusM.setAppId(apps.getId());
                statusM.setStatus(String.valueOf(apps.getStatus()));
                statusM.setStatusComment(apps.getStatusNm());
                statusM.setInsUser(personsIdGet.get().getTin());
                statusMService.saveStatusM(statusM);

                StatusH statusH = new StatusH();
                statusH.setStmainID(statusM.getId());
                statusH.setAppId(statusM.getAppId());
                statusH.setStatus(String.valueOf(apps.getStatus()));
                statusH.setStatusComment(apps.getStatusNm());
                statusH.setInsUser(personsIdGet.get().getTin());
                statusHService.saveStatusH(statusH);
                /**todo ЛОК га ёзиш end todo**/

                JSONObject obj = new JSONObject();
                obj.put("message", "Success");
                obj.put("data", apps);
                obj.put("status", "200");
                ResponseEntity.status(0);
                return new ResponseEntity<>(obj.toMap(), HttpStatus.OK);
            }else {
                JSONObject obj = new JSONObject();
                obj.put("message", "Error");
                obj.put("errors", "Bunday ID li foydalanuvchi топилмади!");
                obj.put("status", "400");
                return new ResponseEntity<>(obj.toMap(), HttpStatus.BAD_REQUEST);
            }
        }
    }
}
