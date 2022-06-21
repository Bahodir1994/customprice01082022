package uz.customs.customsprice.controllers.InternationalSurvey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uz.customs.customsprice.entity.InitialDecision.Country;
import uz.customs.customsprice.entity.InitialDecision.Location;
import uz.customs.customsprice.entity.InternationalSurveyEntity.DirectionType;
import uz.customs.customsprice.entity.InternationalSurveyEntity.InternationalSurveyEntity;
import uz.customs.customsprice.repository.CountyRepo;
import uz.customs.customsprice.repository.InternationalSurveyRepo.DirectionTypeRepo;
import uz.customs.customsprice.repository.InternationalSurveyRepo.InternationalSurveyRepo;
import uz.customs.customsprice.repository.LocationRepo;
import uz.customs.customsprice.service.ConturyService;
import uz.customs.customsprice.service.InternationalSurveyS.DirectionTypeService;
import uz.customs.customsprice.service.InternationalSurveyS.ExcelService;
import uz.customs.customsprice.service.InternationalSurveyS.InternationalSurveyService;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/inrenationalsurvaey")
public class InternationalSurveyController {
    private final String INTERNATIONALSURVEYPAGE = "/resources/pages/InternationalSurvay/FilterIS";
    private final String INTERNATIONALSURVEYRESULTPAGE = "/resources/pages/InternationalSurvay/ResultIS";
    private final String INTERNATIONALSURVEYSAVEIS1 = "/resources/pages/InternationalSurvay/SaveIS1";
    private final String INTERNATIONALSURVEYSAVEIS2 = "/resources/pages/InternationalSurvay/SaveIS2";
    private final String INTERNATIONALSURVEYSAVEIS3 = "/resources/pages/InternationalSurvay/SaveIS3";
    private final String INTERNATIONALSURVEYSAVESUMAPPROVEDADD = "/resources/pages/InternationalSurvay/SaveSumApprovedAdd";
    private final String GET_REPORT_IN_SUR = "/resources/pages/InternationalSurvay/getReport/{formats}/{FromStart}/{ToEnd}";

    private final InternationalSurveyService internationalSurveyService;
    private final InternationalSurveyRepo internationalSurveyRepo;
    private final ConturyService conturyService;
    private final DirectionTypeRepo directionTypeRepo;
    private final LocationRepo locationRepo;
    private final DirectionTypeService directionTypeService;


    @Autowired
    ExcelService fileService;

    @Autowired
    CountyRepo countyRepo;

    public InternationalSurveyController(InternationalSurveyService internationalSurveyService, InternationalSurveyRepo internationalSurveyRepo, ConturyService conturyService, DirectionTypeRepo directionTypeRepo, LocationRepo locationRepo, DirectionTypeService directionTypeService) {
        this.internationalSurveyService = internationalSurveyService;
        this.internationalSurveyRepo = internationalSurveyRepo;
        this.conturyService = conturyService;
        this.directionTypeRepo = directionTypeRepo;
        this.locationRepo = locationRepo;
        this.directionTypeService = directionTypeService;
    }

    @PostMapping(value = INTERNATIONALSURVEYPAGE)
    @ResponseBody
    public ModelAndView FilterIS(HttpSession session, HttpServletRequest request) {
        String userId = (String) request.getSession().getAttribute("userId");
        String userName = (String) request.getSession().getAttribute("userName");
        Integer userRole = (Integer) request.getSession().getAttribute("userRole");
        String userRoleName = (String) request.getSession().getAttribute("userRoleName");
        String userLocation = (String) request.getSession().getAttribute("userLocation");
        String userLocationName = (String) request.getSession().getAttribute("userLocationName");
        String userPost = (String) request.getSession().getAttribute("userPost");


        ModelAndView mav = new ModelAndView("resources/pages/InternationalSurvey/FiltrIS");
        String lngaTpcd = "UZ";
        List<Country> countryList = countyRepo.findAllByLngaTpcdOrderByCodeAsc(lngaTpcd);
        List<DirectionType> directionType = directionTypeRepo.findAll();
        List<Location> location = locationRepo.findAll();
        mav.addObject("countryList", countryList);
        mav.addObject("userLocation", userLocation);
        mav.addObject("userRole", userRole);
        mav.addObject("directionType", directionType);
        mav.addObject("location", location);

        /*1*/
        int allInSur;
        /*2*/
        BigDecimal allSumProbability = BigDecimal.valueOf(0.00);
        /*3*/
        BigDecimal sumDef = BigDecimal.valueOf(0.00);
        /*4*/
        BigDecimal ApprovedSum = BigDecimal.valueOf(0.00);
        /*5*/
        BigDecimal sumOnControl = BigDecimal.valueOf(0.00);
        DecimalFormat df = new DecimalFormat("#,###.00");

        if (Objects.equals(userLocation, "1701")) {
            List<InternationalSurveyEntity> internationalSurveyEntity = new ArrayList<>();
            internationalSurveyEntity = internationalSurveyRepo.findAll();
            /*1*/
            allInSur = internationalSurveyEntity.size();
            /*2*/
            for (int i = 0; i < internationalSurveyEntity.size(); i++) {
                BigDecimal sum = internationalSurveyEntity.get(i).getSumProbability();
                if (sum != null) allSumProbability = allSumProbability.add(sum);
            }
            /*3*/
            for (int i = 0; i < internationalSurveyEntity.size(); i++) {
                BigDecimal sum = internationalSurveyEntity.get(i).getSum();

                if (sum != null) sumDef = sumDef.add(sum);
            }
            /*4*/
            for (int i = 0; i < internationalSurveyEntity.size(); i++) {
                BigDecimal sum = internationalSurveyEntity.get(i).getSumАpproved();
                if (sum != null) ApprovedSum = ApprovedSum.add(sum);
            }
            /*5*/
            for (int i = 0; i < internationalSurveyEntity.size(); i++) {
                BigDecimal sum = internationalSurveyEntity.get(i).getSumOnControl();
                if (sum != null) sumOnControl = sumOnControl.add(sum);
            }
        } else {
            List<InternationalSurveyEntity> internationalSurveyEntity = new ArrayList<InternationalSurveyEntity>();
            internationalSurveyEntity = internationalSurveyRepo.findByExecutiveTerritoryCode(userLocation);
            /*1*/
            allInSur = internationalSurveyEntity.size();
            /*2*/
            for (int i = 0; i < internationalSurveyEntity.size(); i++) {
                BigDecimal sum = internationalSurveyEntity.get(i).getSumProbability();
                if (sum != null) allSumProbability = allSumProbability.add(sum);
            }
            /*3*/
            for (int i = 0; i < internationalSurveyEntity.size(); i++) {
                BigDecimal sum2 = internationalSurveyEntity.get(i).getSum();
                if (sum2 != null) sumDef = sumDef.add(sum2);
            }
            /*4*/
            for (int i = 0; i < internationalSurveyEntity.size(); i++) {
                BigDecimal sum3 = internationalSurveyEntity.get(i).getSumАpproved();
                if (sum3 != null) ApprovedSum = ApprovedSum.add(sum3);
            }
            /*5*/
            for (int i = 0; i < internationalSurveyEntity.size(); i++) {
                BigDecimal sum4 = internationalSurveyEntity.get(i).getSumOnControl();
                if (sum4 != null) sumOnControl = sumOnControl.add(sum4);
            }
        }

        /**Statistic bar**/
        mav.addObject("AllInSurvey", allInSur);
        mav.addObject("AllSumProbability", df.format(allSumProbability));
        mav.addObject("AllSumDef", df.format(sumDef));
        mav.addObject("AllSumАpproved", df.format(ApprovedSum));
        mav.addObject("AllSumOnControl", df.format(sumOnControl));
        /**Statistic bar**/
        return mav;
    }

    @GetMapping(value = INTERNATIONALSURVEYRESULTPAGE)
    @ResponseBody
    public ModelAndView ResultIS(
            HttpSession session,
            HttpServletRequest request,
            @RequestParam(required = false) String userLocationCode,
            @RequestParam(required = false) String savedUserFirst,
            @RequestParam(required = false) String directionTypeCode,
            @RequestParam(required = false) String xbbMailDate,
            @RequestParam(required = false) String orgName,
            @RequestParam(required = false) String xbbMailNum,
            @RequestParam(required = false) String hsCode,
            @RequestParam(required = false) String productName,
            @RequestParam(required = false) String sendReqCountryCode,
            @RequestParam(required = false) String sumProbability,
            @RequestParam(required = false) String sendReqNum,
            @RequestParam(required = false) String reqDate,
            @RequestParam(required = false) String responseNum,
            @RequestParam(required = false) String responseDate,
            @RequestParam(required = false) String responseNumSendXbbNum,
            @RequestParam(required = false) String responseNumSendXbbDate,
            @RequestParam(required = false) String resultAnswerMailNum,
            @RequestParam(required = false) String resultAnswerMailDate,
            @RequestParam(required = false) String xbbVerdictNum,
            @RequestParam(required = false) String xbbVerdictDate,
            @RequestParam(required = false) String executiveTerritoryCode,
            @RequestParam(required = false) String status,
            @RequestParam(required = false) String comment,
            @RequestParam(required = false) String fabula,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "0") int size
    ) {
        String userId = (String) request.getSession().getAttribute("userId");
        String userLocation = (String) request.getSession().getAttribute("userLocation");
        Integer userRole = (Integer) request.getSession().getAttribute("userRole");
        List<Location> location = locationRepo.findAll();
        if (!Objects.equals(userLocation, "1701")) {
            executiveTerritoryCode = userLocation;
        }

        ModelAndView viewModel = new ModelAndView("resources/pages/InternationalSurvey/ResultIS");
        java.sql.Date xbbMailDateS = null;
        java.sql.Date reqDateS = null;
        java.sql.Date responseDateS = null;
        java.sql.Date responseNumSendXbbDateS = null;
        java.sql.Date resultAnswerMailDateS = null;
        java.sql.Date xbbVerdictDateS = null;
        if (xbbMailDate != null && xbbMailDate != "") {
            xbbMailDateS = java.sql.Date.valueOf(xbbMailDate);
        }
        if (reqDate != "" && reqDate != null) {
            reqDateS = java.sql.Date.valueOf(reqDate);
        }
        if (responseDate != "" && responseDate != null) {
            responseDateS = java.sql.Date.valueOf(responseDate);
        }
        if (responseNumSendXbbDate != "" && responseNumSendXbbDate != null) {
            responseNumSendXbbDateS = java.sql.Date.valueOf(responseNumSendXbbDate);
        }
        if (resultAnswerMailDate != "" && resultAnswerMailDate != null) {
            resultAnswerMailDateS = java.sql.Date.valueOf(resultAnswerMailDate);
        }
        if (xbbVerdictDate != "" && xbbVerdictDate != null) {
            resultAnswerMailDateS = java.sql.Date.valueOf(xbbVerdictDate);
        }
        try {
            String lngaTpcd = "UZ";
            List<Country> countryList = countyRepo.findAllByLngaTpcdOrderByCodeAsc(lngaTpcd);
            List<DirectionType> directionType = directionTypeRepo.findAll();

            String sortBy = "insTime";
            String sortDir = "desc";

            Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                    Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

            List<InternationalSurveyEntity> tutorials = new ArrayList<InternationalSurveyEntity>();
            Pageable paging = PageRequest.of(page, size, sort);
            Page<InternationalSurveyEntity> pageTuts =
                    internationalSurveyRepo.findAllByOrderByInsTimeAscAndOrgNameAndHsCode(
                            userLocationCode,
                            savedUserFirst,
                            directionTypeCode,
                            xbbMailNum,
                            xbbMailDateS,
                            orgName,
                            hsCode,
                            productName,
                            sendReqCountryCode,
                            sumProbability,
                            sendReqNum,
                            reqDateS,
                            responseNum,
                            responseDateS,
                            responseNumSendXbbNum,
                            responseNumSendXbbDateS,
                            resultAnswerMailNum,
                            resultAnswerMailDateS,
                            xbbVerdictNum,
                            xbbVerdictDateS,
                            executiveTerritoryCode,
                            status,
                            comment,
                            fabula,
                            paging
                    );
            tutorials = pageTuts.getContent();
            viewModel.addObject("tutorials", tutorials);
            viewModel.addObject("currentPage", pageTuts.getNumber());
            viewModel.addObject("totalItems", pageTuts.getTotalElements());
            viewModel.addObject("totalPages", pageTuts.getTotalPages());
            viewModel.addObject("getPageSize", pageTuts.getSize());

            viewModel.addObject("locationDirectory", location);
            viewModel.addObject("userId", userId);
            viewModel.addObject("userLocation", userLocation);
            viewModel.addObject("userRole", userRole);

            viewModel.addObject("countryList", countryList);
            viewModel.addObject("directionType", directionType);
            viewModel.addObject("location", location);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return viewModel;

    }

    @PostMapping(value = INTERNATIONALSURVEYSAVEIS1)
    public ResponseEntity<Object> addFirst(@RequestBody @Valid InternationalSurveyStep1DTO internationalSurveyStep1DTO, BindingResult result, HttpServletRequest request) {
        String userId = (String) request.getSession().getAttribute("userId");
        String userName = (String) request.getSession().getAttribute("userName");
        Integer userRole = (Integer) request.getSession().getAttribute("userRole");
        String userRoleName = (String) request.getSession().getAttribute("userRoleName");
        String userLocation = (String) request.getSession().getAttribute("userLocation");
        String userLocationName = (String) request.getSession().getAttribute("userLocationName");
        String userPost = (String) request.getSession().getAttribute("userPost");

        Map<String, String> errors = new HashMap<>();
        if (result.hasErrors()) {
            errors = result.getFieldErrors().stream().collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        } else {
            InternationalSurveyEntity internationalSurveyEntity = new InternationalSurveyEntity();
            if (!Objects.equals(internationalSurveyStep1DTO.getXbbMailNum(), "1701")) {
                internationalSurveyEntity.setXbbMailNum(internationalSurveyStep1DTO.getXbbMailNum());
            }
            if (!Objects.equals(internationalSurveyStep1DTO.getXbbMailDate(), "")) {
                if (userLocation != "1701" && internationalSurveyStep1DTO.getXbbMailDate() != "1111-11-11") {
                    internationalSurveyEntity.setXbbMailDate(Date.valueOf(internationalSurveyStep1DTO.getXbbMailDate()));
                }
            }
            internationalSurveyEntity.setOrgName(internationalSurveyStep1DTO.getOrgName());
            internationalSurveyEntity.setHsCode(internationalSurveyStep1DTO.getHsCode());
            internationalSurveyEntity.setProductName(internationalSurveyStep1DTO.getProductName());
            Country country = conturyService.getByCodeAndLngaTpcd(internationalSurveyStep1DTO.getSendReqCountryCode(), "UZ");
            internationalSurveyEntity.setSendReqCountryCode(internationalSurveyStep1DTO.getSendReqCountryCode());
            internationalSurveyEntity.setSendReqCountryNm(country.getCdNm());
            DirectionType directionType = directionTypeService.getByCode(internationalSurveyStep1DTO.getDirectionTypeSave());
            internationalSurveyEntity.setDirectionTypeCode(internationalSurveyStep1DTO.getDirectionTypeSave());
            internationalSurveyEntity.setDirectionTypeName(directionType.getName());
            if (!Objects.equals(internationalSurveyStep1DTO.getSumProbability(), "")) {
                internationalSurveyEntity.setSumProbability(internationalSurveyStep1DTO.getSumProbability());
            }
            internationalSurveyEntity.setSavedUserFirstId(userId);
            internationalSurveyEntity.setSavedUserFirst(userName);
            internationalSurveyEntity.setUserLocationCode(userLocation);
            internationalSurveyEntity.setUserLocationName(userLocationName);

            internationalSurveyEntity.setExecutiveTerritoryCode(userLocation);
            Optional<Location> location = locationRepo.findById(userLocation);
            internationalSurveyEntity.setExecutiveTerritoryName(location.get().getName1());
            /**100-First step**/ /**200-Second step**/ /**300-Third step**/
            internationalSurveyEntity.setStatus("100");
            /*finish*/
            internationalSurveyService.savingValue(internationalSurveyEntity);
            return ResponseEntity.status(201).body(internationalSurveyEntity);
        }
    }

    @PostMapping(value = INTERNATIONALSURVEYSAVEIS2)
    public ResponseEntity<Object> addSecond(@RequestBody @Valid InternationalSurveyStep2DTO internationalSurveyStep2DTO, BindingResult result, HttpServletRequest request) {
        String userId = (String) request.getSession().getAttribute("userId");
        String userName = (String) request.getSession().getAttribute("userName");
        Integer userRole = (Integer) request.getSession().getAttribute("userRole");
        String userRoleName = (String) request.getSession().getAttribute("userRoleName");
        String userLocation = (String) request.getSession().getAttribute("userLocation");
        String userLocationName = (String) request.getSession().getAttribute("userLocationName");
        String userPost = (String) request.getSession().getAttribute("userPost");
        Map<String, String> errors = new HashMap<>();
        if (result.hasErrors()) {
            errors = result.getFieldErrors().stream().collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
            if (Objects.equals(internationalSurveyStep2DTO.getExecutiveTerritoryCode(), "1701")) {
                errors.put("executiveTerritoryCode", "Маъсул худуд ДБҚ бўлиши мумкин эмас!");
            }
            return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
        } else {
            InternationalSurveyEntity internationalSurveyEntity = internationalSurveyService.getByIdAndStatus(internationalSurveyStep2DTO.getId(), internationalSurveyStep2DTO.getStatus());
            internationalSurveyEntity.setSendReqNum(internationalSurveyStep2DTO.getSendReqNum());
            if (!Objects.equals(internationalSurveyStep2DTO.getReqDate(), "")) {
                internationalSurveyEntity.setReqDate(Date.valueOf(internationalSurveyStep2DTO.getReqDate()));
            }
            internationalSurveyEntity.setResponseNum(internationalSurveyStep2DTO.getResponseNum());
            if (!Objects.equals(internationalSurveyStep2DTO.getResponseDate(), "")) {
                internationalSurveyEntity.setResponseDate(Date.valueOf(internationalSurveyStep2DTO.getResponseDate()));
            }
            internationalSurveyEntity.setResponseNumSendXbbNum(internationalSurveyStep2DTO.getResponseNumSendXbbNum());
            if (!Objects.equals(internationalSurveyStep2DTO.getResponseNumSendXbbDate(), "")) {
                internationalSurveyEntity.setResponseNumSendXbbDate(Date.valueOf(internationalSurveyStep2DTO.getResponseNumSendXbbDate()));
            }
            if (Objects.equals(internationalSurveyStep2DTO.getExecutiveTerritoryCode(), "1701")) {
                Map<String, String> errorsTerritorilCode = new HashMap<>();
                errorsTerritorilCode.put("executiveTerritoryCode", "Маъсул худуд ДБҚ бўлиши мумкин эмас!");
                return new ResponseEntity<Object>(errorsTerritorilCode, HttpStatus.BAD_REQUEST);
            }
            internationalSurveyEntity.setExecutiveTerritoryCode(internationalSurveyStep2DTO.getExecutiveTerritoryCode());
            Optional<Location> location = locationRepo.findById(internationalSurveyStep2DTO.getExecutiveTerritoryCode());
            internationalSurveyEntity.setExecutiveTerritoryName(location.get().getName1());
            internationalSurveyEntity.setDistributed(internationalSurveyStep2DTO.getDistributed());
            internationalSurveyEntity.setSavedUserSecondId(userId);
            internationalSurveyEntity.setSavedUserSecond(userName);
            internationalSurveyService.savingValue(internationalSurveyEntity);
            Map<String, String> notAllowedInputs = new HashMap<>();
            if ((internationalSurveyEntity.getResponseNum() == null) || (Objects.equals(internationalSurveyEntity.getResponseNum(), ""))) {
                notAllowedInputs.put("responseNum", "responseNum");
            }
            if ((internationalSurveyEntity.getResponseDate() == null)) {
                notAllowedInputs.put("responseDate", "responseDate");
            }
            if (internationalSurveyEntity.getResponseNumSendXbbNum() == null || Objects.equals(internationalSurveyEntity.getResponseNumSendXbbNum(), "")) {
                notAllowedInputs.put("responseNumSendXbbNum", "responseNumSendXbbNum");
            }
            if (internationalSurveyEntity.getResponseNumSendXbbDate() == null) {
                notAllowedInputs.put("responseNumSendXbbDate", "responseNumSendXbbDate");
            }
            /**100-First step**/ /**200-Second step**/ /**300-Third step**/
            if (notAllowedInputs.size() == 0) {
                internationalSurveyEntity.setStatus("200");
                internationalSurveyService.savingValue(internationalSurveyEntity);
            }
            return ResponseEntity.status(201).body(internationalSurveyEntity);
        }
    }

    @PostMapping(value = INTERNATIONALSURVEYSAVEIS3)
    public ResponseEntity<Object> addSecond(@RequestBody @Valid InternationalSurveyStep3DTO internationalSurveyStep3DTO, BindingResult result, HttpServletRequest request) {
        String userId = (String) request.getSession().getAttribute("userId");
        String userName = (String) request.getSession().getAttribute("userName");
        Integer userRole = (Integer) request.getSession().getAttribute("userRole");
        String userRoleName = (String) request.getSession().getAttribute("userRoleName");
        String userLocation = (String) request.getSession().getAttribute("userLocation");
        String userLocationName = (String) request.getSession().getAttribute("userLocationName");
        String userPost = (String) request.getSession().getAttribute("userPost");

        Map<String, String> errors = new HashMap<>();
        if (result.hasErrors()) {
            errors = result.getFieldErrors().stream().collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
            return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
        } else {
            InternationalSurveyEntity internationalSurveyEntity = internationalSurveyService.getByIdAndStatus(internationalSurveyStep3DTO.getId(), internationalSurveyStep3DTO.getStatus());
            internationalSurveyEntity.setResultAnswerMailNum(internationalSurveyStep3DTO.getResultAnswerMailNum());
            if (!Objects.equals(internationalSurveyStep3DTO.getResultAnswerMailDate(), "")) {
                internationalSurveyEntity.setResultAnswerMailDate(Date.valueOf(internationalSurveyStep3DTO.getResultAnswerMailDate()));
            }
            internationalSurveyEntity.setXbbVerdictNum(internationalSurveyStep3DTO.getXbbVerdictNum());
            if (!Objects.equals(internationalSurveyStep3DTO.getXbbVerdictDate(), "")) {
                internationalSurveyEntity.setXbbVerdictDate(Date.valueOf(internationalSurveyStep3DTO.getXbbVerdictDate()));
            }
            if (!Objects.equals(internationalSurveyStep3DTO.getSum(), "")) {
                internationalSurveyEntity.setSum(internationalSurveyStep3DTO.getSum());
            }
            if (!Objects.equals(internationalSurveyStep3DTO.getSumАpproved(), "")) {
                internationalSurveyEntity.setSumАpproved(internationalSurveyStep3DTO.getSumАpproved());
            }
            internationalSurveyEntity.setSumOnControl(
                    internationalSurveyEntity.getSum().subtract(internationalSurveyStep3DTO.getSumАpproved())
            );
            internationalSurveyEntity.setSavedUserThirdId(userId);
            internationalSurveyEntity.setSavedUserThird(userName);
            internationalSurveyEntity.setComment(internationalSurveyStep3DTO.getComment());
            internationalSurveyEntity.setFabula(internationalSurveyStep3DTO.getFabula());
            /**100-First step**/ /**200-Second step**/ /**300-Third step**/
            internationalSurveyEntity.setStatus("300");
            internationalSurveyService.savingValue(internationalSurveyEntity);
            return ResponseEntity.status(201).body(internationalSurveyEntity);
        }
    }

    @PostMapping(value = INTERNATIONALSURVEYSAVESUMAPPROVEDADD)
    public ResponseEntity<Object> addSummApprovedPlus(@RequestBody InternationalSurveyAddNewSumApproved internationalSurveyAddNewSumApproved, HttpServletRequest request) {
        String userId = (String) request.getSession().getAttribute("userId");
        String userName = (String) request.getSession().getAttribute("userName");
        Integer userRole = (Integer) request.getSession().getAttribute("userRole");
        String userRoleName = (String) request.getSession().getAttribute("userRoleName");
        String userLocation = (String) request.getSession().getAttribute("userLocation");
        String userLocationName = (String) request.getSession().getAttribute("userLocationName");
        String userPost = (String) request.getSession().getAttribute("userPost");

        Map<String, String> errors = new HashMap<>();
        try {
            InternationalSurveyEntity internationalSurveyEntity = internationalSurveyService.getById(internationalSurveyAddNewSumApproved.getIsId());
            BigDecimal newSumApproved;
            if (!Objects.equals(internationalSurveyAddNewSumApproved.getSumApprovedAdd(), "")) {
                newSumApproved = internationalSurveyEntity.getSumАpproved().add(internationalSurveyAddNewSumApproved.getSumApprovedAdd());
            } else newSumApproved = BigDecimal.valueOf(0.00);

            internationalSurveyEntity.setSumАpproved(newSumApproved);
            BigDecimal newSumOnControl;
            newSumOnControl = internationalSurveyEntity.getSum().subtract(newSumApproved);
            internationalSurveyEntity.setSumOnControl(newSumOnControl);

            String newComment = "";
            if (internationalSurveyAddNewSumApproved.getCommentAdd() != "") {
                newComment = internationalSurveyAddNewSumApproved.getCommentAdd() + ";" + "<br>" + internationalSurveyEntity.getComment();
                internationalSurveyEntity.setComment(newComment);
            }
            internationalSurveyEntity.setFabula(internationalSurveyAddNewSumApproved.getFabulaAdd());
            internationalSurveyService.savingValue(internationalSurveyEntity);
            return ResponseEntity.status(201).body(internationalSurveyEntity);
        } catch (Exception e) {
            return new ResponseEntity<Object>("error", HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping(value = GET_REPORT_IN_SUR)
    public ResponseEntity<InputStreamResource> getFile(@PathVariable String formats, @PathVariable String FromStart, @PathVariable String ToEnd) {
        System.out.println(formats);
        String filename = "tutorials.xlsx";
        InputStreamResource file = new InputStreamResource(fileService.load());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .body(file);
    }

}
