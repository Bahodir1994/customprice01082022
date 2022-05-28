package uz.customs.customsprice.controllers.api.apps;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.customs.customsprice.controllers.api.files.AppsAndDocsAndTransportsDTO;
import uz.customs.customsprice.controllers.api.helper.ResponseHandler;
import uz.customs.customsprice.entity.InitialDecision.*;
import uz.customs.customsprice.entity.classifier.TransportTypeS;
import uz.customs.customsprice.entity.earxiv.Earxiv;
import uz.customs.customsprice.repository.EarxivRepo;
import uz.customs.customsprice.repository.TransportTypeRepo;
import uz.customs.customsprice.repository.classifier.TransportTypeSRepo;
import uz.customs.customsprice.service.*;
import uz.customs.customsprice.service.earxiv.EarxivService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.*;
import java.util.*;

@Controller
@Validated
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
    private final TransportTypeRepo transportTypeRepo;
    private final TransportTypeSRepo transportTypeSRepo;

    public ApiAppsController(AppsService appsService, ConturyService conturyService, LocationService locationService, StatusService statusService, TermsService termsService, PersonsService personsService, StatusHService statusHService, StatusMService statusMService, TransportTypeService transportTypeService, EarxivService earxivService, EarxivRepo earxivRepo, TransportTypeRepo transportTypeRepo, TransportTypeSRepo transportTypeSRepo) {
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
        this.transportTypeRepo = transportTypeRepo;
        this.transportTypeSRepo = transportTypeSRepo;
    }

    /*---------------------------------------------------------------------------------------------------------start*/
    /* Apps маълумотларини API орқали сақлаш учун учун*/
    @PostMapping
    public ResponseEntity<Object> valuesave(@RequestBody AppsAndDocsAndTransportsDTO appsAndDocsAndTransportsDTO, HttpServletRequest request, BindingResult br) {
        Map<Integer, Object> errorTransportType = new HashMap<>();
        Map<String, String> errorApps = new HashMap<>();
        Map<Integer, Object> errorEarxiv = new HashMap<>();
        JSONObject jsonObject;
        JSONObject jsonObject2;

        /*1*/Apps apps = appsAndDocsAndTransportsDTO.getApps();

        /*2*/List<TransportType> transportTypes = appsAndDocsAndTransportsDTO.getTransports();

        /*3*/List<Earxiv> earxivS = appsAndDocsAndTransportsDTO.getDocs();

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<TransportType>> violations;
        int e = 1;
        int k = 1;
        for (TransportType type : transportTypes) {
            violations = validator.validate(type);
            jsonObject = new JSONObject();
            if (!violations.isEmpty()) {
                for (ConstraintViolation violation : violations) {
                    System.out.println(violation.getPropertyPath());
                    System.out.println(violation.getMessage());
                    jsonObject.put(violation.getPropertyPath().toString(),violation.getMessage());
//                    errorTransportType.put(violation.getPropertyPath().toString() , violation.getMessage());
                }
                errorTransportType.put(e, jsonObject);
                e++;
            }
        }
        Set<ConstraintViolation<Earxiv>> violationearxivS;
        for (Earxiv type : earxivS) {
            violationearxivS = validator.validate(type);
            jsonObject2 = new JSONObject();
            if (!violationearxivS.isEmpty()) {
                for (ConstraintViolation violation : violationearxivS) {
                    System.out.println(violation.getPropertyPath());
                    System.out.println(violation.getMessage());
                    jsonObject2.put(violation.getPropertyPath().toString(),violation.getMessage());
//                    errorEarxiv.put(violation.getPropertyPath().toString() + e, violation.getMessage());
                }
                errorEarxiv.put(k, jsonObject2);
                k++;
            }
        }
        Set<ConstraintViolation<Apps>> violationApps;
//        for (Apps type : apps) {
        violationApps = validator.validate(apps);
        if (!violationApps.isEmpty()) {
            for (ConstraintViolation violation : violationApps) {
                System.out.println(violation.getPropertyPath());
                System.out.println(violation.getMessage());
                errorApps.put(violation.getPropertyPath().toString(), violation.getMessage());
            }
        }
//        }

        if(errorTransportType.size() > 0||errorApps.size() > 0||errorEarxiv.size() > 0) {
            JSONObject obj = new JSONObject();
            obj.put("message", "Error");

            if (errorTransportType.size() > 0) {
                obj.put("errorsTransportType", errorTransportType);
            }
            if (errorApps.size() > 0) {
                obj.put("errorsApps", errorApps);
            }

            if (errorEarxiv.size() > 0) {
                obj.put("errorEarxiv", errorEarxiv);
            }

            obj.put("status", "400");
            return new ResponseEntity<>(obj.toMap(), HttpStatus.BAD_REQUEST);

        }


        else {
            Optional<Persons> personsIdGet = personsService.getById(apps.getPersonId());
            if (personsIdGet.isPresent()) {
                Country country = conturyService.getByCodeAndLngaTpcd(apps.getCustomerCountry(), "UZ");
                apps.setCustomerCountryNm(country.getCdNm());

                country = conturyService.getByCodeAndLngaTpcd(apps.getSenderCountry(), "UZ");
                apps.setSenderCountryNm(country.getCdNm());

                Location location = locationService.getById(apps.getLocationId());
                apps.setLocationNm(location.getName1());
                apps.setStatus(100);
                Status status = statusService.getById(100);
                apps.setStatusNm(status.getName());

                Terms terms = termsService.findByIdAndLngaTpcd(apps.getTerms(), "UZ");
                apps.setTermsNm(terms.getSign());

                apps.setInsUser(personsIdGet.get().getTin());
                appsService.saveApps(apps);
                apps.getId();
                for (TransportType type : transportTypes) {
                    Optional<Apps> appIdGet = Optional.ofNullable(appsService.findById(apps.getId()));
                    if (appIdGet.isPresent()) {
                        TransportType transportType = new TransportType();
                        Country countryFinish = conturyService.getByCodeAndLngaTpcd(type.getFinishCountry(), "UZ");
                        Country countryEnd = conturyService.getByCodeAndLngaTpcd(type.getEndCountry(), "UZ");
                        TransportTypeS transportTypeS = transportTypeSRepo.findByCodeAndLngaTpcd(type.getTarnsportType(), "UZ");

                        transportType.setAppId(apps.getId());

                        transportType.setFinishCountry(type.getFinishCountry());
                        transportType.setFinishCountryNm(countryFinish.getCdNm());

                        transportType.setEndCountry(type.getEndCountry());
                        transportType.setEndCountryNm(countryEnd.getCdNm());

                        transportType.setTarnsportType(type.getTarnsportType());
                        transportType.setTarnsportTypeNm(transportTypeS.getCdNm());

                        transportType.setTransportPrice(type.getTransportPrice());
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
            } else {
                JSONObject obj = new JSONObject();
                obj.put("message", "Error");
                obj.put("errors", "Bunday ID li foydalanuvchi топилмади!");
                obj.put("status", "400");
                return new ResponseEntity<>(obj.toMap(), HttpStatus.BAD_REQUEST);
            }
        }

    }

    @PostMapping("/updateappsrestapi")
    public ResponseEntity<Object> updatevalue(@RequestBody AppsAndDocsAndTransportsDTO appsAndDocsAndTransportsDTO, HttpServletRequest request, BindingResult br) {
        Map<Integer, Object> errorTransportType = new HashMap<>();
        Map<String, String> errorApps = new HashMap<>();
        Map<Integer, Object> errorEarxiv = new HashMap<>();
        JSONObject jsonObject;
        JSONObject jsonObject2;

        /*1*/Apps apps = appsAndDocsAndTransportsDTO.getApps();
        /*2*/List<TransportType> transportTypes = appsAndDocsAndTransportsDTO.getTransports();
        /*3*/List<Earxiv> earxivS = appsAndDocsAndTransportsDTO.getDocs();

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<TransportType>> violations;
        int e = 1;
        int k = 1;
        for (TransportType type : transportTypes) {
            violations = validator.validate(type);
            jsonObject = new JSONObject();
            if (!violations.isEmpty()) {
                for (ConstraintViolation violation : violations) {
                    System.out.println(violation.getPropertyPath());
                    System.out.println(violation.getMessage());
                    jsonObject.put(violation.getPropertyPath().toString(),violation.getMessage());
                }
                errorTransportType.put(e, jsonObject);
                e++;
            }
        }
        Set<ConstraintViolation<Earxiv>> violationearxivS;
        for (Earxiv type : earxivS) {
            violationearxivS = validator.validate(type);
            jsonObject2 = new JSONObject();
            if (!violationearxivS.isEmpty()) {
                for (ConstraintViolation violation : violationearxivS) {
                    System.out.println(violation.getPropertyPath());
                    System.out.println(violation.getMessage());
                    jsonObject2.put(violation.getPropertyPath().toString(),violation.getMessage());
                }
                errorEarxiv.put(k, jsonObject2);
                k++;
            }
        }
        Set<ConstraintViolation<Apps>> violationApps;
        violationApps = validator.validate(apps);
        if (!violationApps.isEmpty()) {
            for (ConstraintViolation violation : violationApps) {
                System.out.println(violation.getPropertyPath());
                System.out.println(violation.getMessage());
                errorApps.put(violation.getPropertyPath().toString(), violation.getMessage());
            }
        }
        if(errorTransportType.size() > 0||errorApps.size() > 0||errorEarxiv.size() > 0) {
            JSONObject obj = new JSONObject();
            obj.put("message", "Error");
            if (errorTransportType.size() > 0) {obj.put("errorsTransportType", errorTransportType);}
            if (errorApps.size() > 0) {obj.put("errorsApps", errorApps);}
            if (errorEarxiv.size() > 0) {obj.put("errorEarxiv", errorEarxiv);}
            obj.put("status", "400");
            return new ResponseEntity<>(obj.toMap(), HttpStatus.BAD_REQUEST);
        }
        else {
            Optional<Persons> personsIdGet = personsService.getById(apps.getPersonId());
            if (personsIdGet.isPresent()) {
                /******************************************(Apps update all by appId)**********************************/
                Apps appsUpdate = appsService.findById(apps.getId());

                appsUpdate.setId(apps.getId());
                appsUpdate.setPersonId(apps.getPersonId());
                appsUpdate.setCustomerCountry(apps.getCustomerCountry());
                appsUpdate.setSenderCountry(apps.getSenderCountry());
                appsUpdate.setSenderOrg(apps.getSenderOrg());
                appsUpdate.setSellerOrg(apps.getSellerOrg());
                appsUpdate.setTerms(apps.getTerms());
                appsUpdate.setTermsAddr(apps.getTermsAddr());
                appsUpdate.setPersonFio(apps.getPersonFio());
                appsUpdate.setOrgName(apps.getOrgName());
                appsUpdate.setPersonPosition(apps.getPersonPosition());
                appsUpdate.setPersonAddr(apps.getPersonAddr());
                appsUpdate.setPersonTin(apps.getPersonTin());
                appsUpdate.setPersonPin(apps.getPersonPin());
                appsUpdate.setPersonMail(apps.getPersonMail());
                appsUpdate.setPersonPhone(apps.getPersonPhone());
                appsUpdate.setLocationId(apps.getLocationId());
                appsUpdate.setTransExp(apps.getTransExp());
                appsUpdate.setStatus(130);
                /*4*/Status status = statusService.getById(130);
                appsUpdate.setStatusNm(status.getName());

                /*1*/Country country = conturyService.getByCodeAndLngaTpcd(apps.getCustomerCountry(), "UZ");
                     appsUpdate.setCustomerCountryNm(country.getCdNm());
                /*2*/country = conturyService.getByCodeAndLngaTpcd(apps.getSenderCountry(), "UZ");
                     appsUpdate.setSenderCountryNm(country.getCdNm());
                /*3*/Location location = locationService.getById(apps.getLocationId());
                     appsUpdate.setLocationNm(location.getName1());
                /*5*/Terms terms = termsService.findByIdAndLngaTpcd(apps.getTerms(), "UZ");
                     appsUpdate.setTermsNm(terms.getSign());
                /*6*/appsUpdate.setInsUser(personsIdGet.get().getTin());

                appsService.saveApps(appsUpdate);
                /*************(TransportType delete all by appId and save new transporttype Lists)*********************/
                transportTypeRepo.deleteAllByAppId(appsUpdate.getId());
                for (TransportType type : transportTypes) {
                    Optional<Apps> appIdGet = Optional.ofNullable(appsService.findById(appsUpdate.getId()));
                    if (appIdGet.isPresent()) {
                        TransportType transportType = new TransportType();
                        Country countryFinish = conturyService.getByCodeAndLngaTpcd(type.getFinishCountry(), "UZ");
                        Country countryEnd = conturyService.getByCodeAndLngaTpcd(type.getEndCountry(), "UZ");
                        TransportTypeS transportTypeS = transportTypeSRepo.findByCodeAndLngaTpcd(type.getTarnsportType(), "UZ");

                        transportType.setAppId(apps.getId());

                        transportType.setFinishCountry(type.getFinishCountry());
                        transportType.setFinishCountryNm(countryFinish.getCdNm());

                        transportType.setEndCountry(type.getEndCountry());
                        transportType.setEndCountryNm(countryEnd.getCdNm());

                        transportType.setTarnsportType(type.getTarnsportType());
                        transportType.setTarnsportTypeNm(transportTypeS.getCdNm());

                        transportType.setTransportPrice(type.getTransportPrice());
                        transportTypeService.savetrtype(transportType);
                    } else {
                        JSONObject obj = new JSONObject();
                        obj.put("message", "Error");
                        obj.put("appId", "Ариза ID Топилмади!");
                        obj.put("status", "400");
                        return new ResponseEntity<>(obj.toMap(), HttpStatus.OK);
                    }
                }

                /********************(Earxiv delete all by appId and save new Earxiv Lists)****************************/
                earxivRepo.deleteAllByAppId(appsUpdate.getId());
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
                statusM.setStatus(String.valueOf(appsUpdate.getStatus()));
                statusM.setStatusComment(appsUpdate.getStatusNm());
                statusM.setInsUser(personsIdGet.get().getTin());
                statusMService.saveStatusM(statusM);

                StatusH statusH = new StatusH();
                statusH.setStmainID(statusM.getId());
                statusH.setAppId(statusM.getAppId());
                statusH.setStatus(String.valueOf(appsUpdate.getStatus()));
                statusH.setStatusComment(appsUpdate.getStatusNm());
                statusH.setInsUser(personsIdGet.get().getTin());
                statusHService.saveStatusH(statusH);
                /**todo ЛОК га ёзиш end todo**/

                JSONObject obj = new JSONObject();
                obj.put("message", "Success");
                obj.put("data", appsUpdate);
                obj.put("status", "200");
                ResponseEntity.status(0);
                return new ResponseEntity<>(obj.toMap(), HttpStatus.OK);
            } else {
                JSONObject obj = new JSONObject();
                obj.put("message", "Error");
                obj.put("errors", "Bunday ID li foydalanuvchi топилмади!");
                obj.put("status", "400");
                return new ResponseEntity<>(obj.toMap(), HttpStatus.BAD_REQUEST);
            }
        }

    }

}
