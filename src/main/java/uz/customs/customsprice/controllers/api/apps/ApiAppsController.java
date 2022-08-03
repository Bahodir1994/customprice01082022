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
import uz.customs.customsprice.entity.classifier.TransportS;
import uz.customs.customsprice.entity.earxiv.Earxiv;
import uz.customs.customsprice.repository.EarxivRepo;
import uz.customs.customsprice.repository.TransportTypeRepo;
import uz.customs.customsprice.repository.classifier.TransportSRepository;
import uz.customs.customsprice.repository.classifier.TransportTypeSRepo;
import uz.customs.customsprice.service.apps.AppsService;
import uz.customs.customsprice.service.catalog.ConturyService;
import uz.customs.customsprice.service.catalog.LocationService;
import uz.customs.customsprice.service.catalog.TermsService;
import uz.customs.customsprice.service.catalog.TransportTypeService;
import uz.customs.customsprice.service.earxiv.EarxivService;
import uz.customs.customsprice.service.person.PersonsService;
import uz.customs.customsprice.service.status.StatusHService;
import uz.customs.customsprice.service.status.StatusMService;
import uz.customs.customsprice.service.status.StatusService;
import uz.customs.customsprice.utils.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.validation.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
    private final TransportSRepository transportSRepository;

    public ApiAppsController(AppsService appsService, ConturyService conturyService, LocationService locationService, StatusService statusService, TermsService termsService, PersonsService personsService, StatusHService statusHService, StatusMService statusMService, TransportTypeService transportTypeService, EarxivService earxivService, EarxivRepo earxivRepo, TransportTypeRepo transportTypeRepo, TransportTypeSRepo transportTypeSRepo, TransportSRepository transportSRepository) {
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
        this.transportSRepository = transportSRepository;
    }
    /*---------------------------------------------------------------------------------------------------------start*/
    /* Apps маълумотларини API орқали сақлаш учун */
    @PostMapping
    public ResponseEntity<Object> valuesave(@RequestBody AppsAndDocsAndTransportsDTO appsAndDocsAndTransportsDTO, HttpServletRequest request, BindingResult br) {
        Map<Integer, Object> errorTransportType = new HashMap<>();
        Map<String, String> errorApps = new HashMap<>();
        Map<Integer, Object> errorEarxiv = new HashMap<>();
        JSONObject jsonObject;
        JSONObject jsonObject2;
        /*1*/
        Apps apps = appsAndDocsAndTransportsDTO.getApps();
        /*2*/
        List<TransportType> transportTypes = appsAndDocsAndTransportsDTO.getTransports();
        /*3*/
        List<Earxiv> earxivS = appsAndDocsAndTransportsDTO.getDocs();

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
                    jsonObject.put(violation.getPropertyPath().toString(), violation.getMessage());
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
                    jsonObject2.put(violation.getPropertyPath().toString(), violation.getMessage());
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
        if (errorTransportType.size() > 0 || errorApps.size() > 0 || errorEarxiv.size() > 0) {
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
        } else {
            Optional<Persons> personsIdGet = personsService.getById(apps.getPersonId());
            if (personsIdGet.isPresent()) {
                Country country = conturyService.getByCodeAndLngaTpcd(apps.getCustomerCountry(), "UZ");
                apps.setCustomerCountryNm(country.getCdNm());
                country = conturyService.getByCodeAndLngaTpcd(apps.getSenderCountry(), "UZ");
                apps.setSenderCountryNm(country.getCdNm());
                Location location = locationService.getById(apps.getLocationId());
                apps.setLocationNm(location.getName1());

                Terms terms = termsService.findByIdAndLngaTpcd(apps.getTerms(), "UZ");
                apps.setTermsNm(terms.getSign());
                apps.setInsUser(personsIdGet.get().getTin());
                appsService.saveAppsS(apps);
                apps.getId();
                for (TransportType type : transportTypes) {
                    Optional<Apps> appIdGet = Optional.ofNullable(appsService.findById(apps.getId()));
                    if (appIdGet.isPresent()) {
                        TransportType transportType = new TransportType();
                        Country countryFinish = conturyService.getByCodeAndLngaTpcd(type.getFinishCountry(), "UZ");
                        Country countryEnd = conturyService.getByCodeAndLngaTpcd(type.getEndCountry(), "UZ");
                        TransportS transportS = transportSRepository.findByCodeAndLngaTpcd(type.getTarnsportType(), "UZ");
                        transportType.setAppId(apps.getId());
                        transportType.setFinishCountry(type.getFinishCountry());
                        transportType.setFinishCountryNm(countryFinish.getCdNm());
                        transportType.setEndCountry(type.getEndCountry());
                        transportType.setEndCountryNm(countryEnd.getCdNm());
                        transportType.setTarnsportType(type.getTarnsportType());
                        transportType.setTarnsportTypeNm(transportS.getCdNm());
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

                        String fileName = Utils.nullClear(fileList.get(0)[4].toString());
                        String file_extension = "", file_only_name = "";
                        String timeStampS = "";
                        int i_ex = fileName.lastIndexOf('.');
                        int p_ex = Math.max(fileName.lastIndexOf('/'), fileName.lastIndexOf('\\'));
                        if (i_ex > p_ex) {
                            file_extension = fileName.substring(i_ex);
                        }
                        if (file_extension.equals("")) file_only_name = fileName;
                        else file_only_name = fileName.substring(0, (fileName.length() - file_extension.length()));

                        timeStampS = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss.SSS").format(new Timestamp(System.currentTimeMillis()));
                        timeStampS = timeStampS.replaceAll("-", "").replaceAll(":", "").replaceAll(" ", "").replaceAll("\\.", "");
                        timeStampS = timeStampS /*+ "_" + InputName*/ + file_extension;

                        earxiv.setAppId(apps.getId());
                        earxiv.setFolderId(fileList.get(0)[0] != null ? fileList.get(0)[0].toString() : "");
                        earxiv.setName(fileList.get(0)[1] != null ? fileList.get(0)[1].toString() : "");
                        earxiv.setUserInn(fileList.get(0)[2] != null ? fileList.get(0)[2].toString() : "");
                        earxiv.setUserPnfl(fileList.get(0)[3] != null ? fileList.get(0)[3].toString() : "");
                        earxiv.setDocname(timeStampS);
                        earxiv.setDocType(fileList.get(0)[5] != null ? fileList.get(0)[5].toString() : "");
                        earxiv.setFileId(fileList.get(0)[6] != null ? fileList.get(0)[6].toString() : "");
                        earxiv.setStatus(fileList.get(0)[7] != null ? fileList.get(0)[7].toString() : "");
                        earxiv.setDocTypeName(fileList.get(0)[8] != null ? fileList.get(0)[8].toString() : "");
                        earxiv.setHash(fileList.get(0)[9] != null ? fileList.get(0)[9].toString() : "");
                        earxiv.setFileNum(fileList.get(0)[10] != null ? fileList.get(0)[10].toString() : "");
                        earxiv.setFileDate((Date) fileList.get(0)[11]);
                        earxiv.setDocNameEx(fileList.get(0)[4] != null ? fileList.get(0)[4].toString() : "");
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
                        earxiv.setFileNum("");
                        earxiv.setFileDate(null);
                        earxiv.setDocNameEx("");
                    }
                    earxivService.create(earxiv);
                    ResponseHandler.generateResponse("Xujjat ma`lumotlari saqlandi!", HttpStatus.OK, earxiv);
                }
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
        Map<String, String> errorAppsAll = new HashMap<>();
        if (appsAndDocsAndTransportsDTO.getApps() == null) {
            errorAppsAll.put("apps", "Ариза маълумотлари буш булиши мумкин эмас!");
        }
        if (appsAndDocsAndTransportsDTO.getTransports() == null) {
            errorAppsAll.put("transport", "Транспорт маълумотлари буш булиши мумкин эмас!");
        }
        if (appsAndDocsAndTransportsDTO.getDocs() == null) {
            errorAppsAll.put("docs", "Хужжат маълумотлари буш булиши мумкин эмас!");
        }

        if (errorAppsAll.size() > 0) {
            JSONObject obj = new JSONObject();
            obj.put("message", "Error");
            obj.put("errors", errorAppsAll);
            obj.put("status", "400");
            return new ResponseEntity<>(obj.toMap(), HttpStatus.BAD_REQUEST);
        }

        Apps apps = appsAndDocsAndTransportsDTO.getApps();
        List<TransportType> transportTypes = appsAndDocsAndTransportsDTO.getTransports();
        List<Earxiv> earxivS = appsAndDocsAndTransportsDTO.getDocs();

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
                    jsonObject.put(violation.getPropertyPath().toString(), violation.getMessage());
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
                    jsonObject2.put(violation.getPropertyPath().toString(), violation.getMessage());
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
        if (errorTransportType.size() > 0 || errorApps.size() > 0 || errorEarxiv.size() > 0) {
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
            Apps appsUpdate = appsService.findById(apps.getId());
            if (personsIdGet.isPresent() && appsUpdate != null) {
                /******************************************(Apps update all by appId)**********************************/
                List<Apps> apps1 = appsService.getByAppNum(appsUpdate.getAppNum());
                int versionNum = 0;
                versionNum = 1 + apps1.size();
                apps.setId(null);

                Country country = conturyService.getByCodeAndLngaTpcd(apps.getCustomerCountry(), "UZ");
                apps.setCustomerCountryNm(country.getCdNm());
                country = conturyService.getByCodeAndLngaTpcd(apps.getSenderCountry(), "UZ");
                apps.setSenderCountryNm(country.getCdNm());
                Location location = locationService.getById(apps.getLocationId());
                apps.setLocationNm(location.getName1());
                apps.setVersionNum(String.valueOf(versionNum));

                Terms terms = termsService.findByIdAndLngaTpcd(apps.getTerms(), "UZ");
                apps.setTermsNm(terms.getSign());
                apps.setInsUser(personsIdGet.get().getTin());
                apps.setAppNum(appsUpdate.getAppNum());
                appsService.saveAppsOne(apps);

                /*************(TransportType delete all by appId and save new transporttype Lists)*********************/
//                transportTypeRepo.deleteAllByAppId(appsUpdate.getId());
                for (TransportType type : transportTypes) {
                    Optional<Apps> appIdGet = Optional.ofNullable(appsService.findById(appsUpdate.getId()));
                    if (appIdGet.isPresent()) {
                        TransportType transportType = new TransportType();
                        Country countryFinish = conturyService.getByCodeAndLngaTpcd(type.getFinishCountry(), "UZ");
                        Country countryEnd = conturyService.getByCodeAndLngaTpcd(type.getEndCountry(), "UZ");
                        TransportS transportS = transportSRepository.findByCodeAndLngaTpcd(type.getTarnsportType(), "UZ");
                        transportType.setAppId(apps.getId());
                        transportType.setFinishCountry(type.getFinishCountry());
                        transportType.setFinishCountryNm(countryFinish.getCdNm());
                        transportType.setEndCountry(type.getEndCountry());
                        transportType.setEndCountryNm(countryEnd.getCdNm());
                        transportType.setTarnsportType(type.getTarnsportType());
                        transportType.setTarnsportTypeNm(transportS.getCdNm());
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
//                earxivRepo.deleteAllByAppId(appsUpdate.getId());
                for (int i = 0; i < earxivS.size(); i++) {
                    Earxiv earxiv = new Earxiv();
                    List<Object[]> fileList = earxivService.getFile1(earxivS.get(i).getFileId());
                    if (fileList.size() > 0) {

                        String fileName = Utils.nullClear(fileList.get(0)[4].toString());
                        String file_extension = "", file_only_name = "";
                        String timeStampS = "";
                        int i_ex = fileName.lastIndexOf('.');
                        int p_ex = Math.max(fileName.lastIndexOf('/'), fileName.lastIndexOf('\\'));
                        if (i_ex > p_ex) {
                            file_extension = fileName.substring(i_ex);
                        }
                        if (file_extension.equals("")) file_only_name = fileName;
                        else file_only_name = fileName.substring(0, (fileName.length() - file_extension.length()));

                        timeStampS = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss.SSS").format(new Timestamp(System.currentTimeMillis()));
                        timeStampS = timeStampS.replaceAll("-", "").replaceAll(":", "").replaceAll(" ", "").replaceAll("\\.", "");
                        timeStampS = timeStampS /*+ "_" + InputName*/ + file_extension;

                        earxiv.setAppId(apps.getId());
                        earxiv.setFolderId(fileList.get(0)[0] != null ? fileList.get(0)[0].toString() : "");
                        earxiv.setName(fileList.get(0)[1] != null ? fileList.get(0)[1].toString() : "");
                        earxiv.setUserInn(fileList.get(0)[2] != null ? fileList.get(0)[2].toString() : "");
                        earxiv.setUserPnfl(fileList.get(0)[3] != null ? fileList.get(0)[3].toString() : "");
                        earxiv.setDocname(timeStampS);
                        earxiv.setDocType(fileList.get(0)[5] != null ? fileList.get(0)[5].toString() : "");
                        earxiv.setFileId(fileList.get(0)[6] != null ? fileList.get(0)[6].toString() : "");
                        earxiv.setStatus(fileList.get(0)[7] != null ? fileList.get(0)[7].toString() : "");
                        earxiv.setDocTypeName(fileList.get(0)[8] != null ? fileList.get(0)[8].toString() : "");
                        earxiv.setHash(fileList.get(0)[9] != null ? fileList.get(0)[9].toString() : "");
                        earxiv.setFileNum(fileList.get(0)[10] != null ? fileList.get(0)[10].toString() : "");
                        earxiv.setFileDate((Date) fileList.get(0)[11]);
                        earxiv.setDocNameEx(fileList.get(0)[4] != null ? fileList.get(0)[4].toString() : "");
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
                        earxiv.setFileNum("");
                        earxiv.setFileDate(null);
                        earxiv.setDocNameEx("");
                    }
                    earxivService.create(earxiv);
                    ResponseHandler.generateResponse("Xujjat ma`lumotlari saqlandi!", HttpStatus.OK, earxiv);
                }
                JSONObject obj = new JSONObject();
                obj.put("message", "Success");
                obj.put("data", apps);
                obj.put("status", "200");
                ResponseEntity.status(0);
                return new ResponseEntity<>(obj.toMap(), HttpStatus.OK);
            } else {
                JSONObject obj = new JSONObject();
                obj.put("message", "Error");
                obj.put("errors", "Фойдаланувчи ёки ариза маълумотлари топилмади!");
                obj.put("status", "400");
                return new ResponseEntity<>(obj.toMap(), HttpStatus.BAD_REQUEST);
            }
        }
    }
}
