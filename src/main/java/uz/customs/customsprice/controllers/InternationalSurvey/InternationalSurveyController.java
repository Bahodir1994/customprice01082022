package uz.customs.customsprice.controllers.InternationalSurvey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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
import uz.customs.customsprice.service.InternationalSurveyS.InternationalSurveyService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.sql.Date;
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

    private final InternationalSurveyService internationalSurveyService;
    private final InternationalSurveyRepo internationalSurveyRepo;
    private final ConturyService conturyService;
    private final DirectionTypeService directionTypeService;
    private final DirectionTypeRepo directionTypeRepo;
    private final LocationRepo locationRepo;

    public InternationalSurveyController(InternationalSurveyService internationalSurveyService, InternationalSurveyRepo internationalSurveyRepo, ConturyService conturyService, DirectionTypeRepo directionTypeRepo, DirectionTypeService directionTypeService, DirectionTypeRepo directionTypeRepo1, LocationRepo locationRepo) {
        this.internationalSurveyService = internationalSurveyService;
        this.internationalSurveyRepo = internationalSurveyRepo;
        this.conturyService = conturyService;
        this.directionTypeService = directionTypeService;
        this.directionTypeRepo = directionTypeRepo1;
        this.locationRepo = locationRepo;
    }
    @Autowired
    CountyRepo countyRepo;

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
        mav.addObject("directionType", directionType);
        mav.addObject("location", location);
        return mav;
    }

    @GetMapping(value = INTERNATIONALSURVEYRESULTPAGE)
    @ResponseBody
    public ModelAndView ResultIS(
            HttpSession session,
            HttpServletRequest request,
            @RequestParam(required = false) String userLocationCode,
            @RequestParam(required = false) String directionTypeCode,
            @RequestParam(required = false) String xbbMailDate,
            @RequestParam(required = false) String xbbMailNum,
            @RequestParam(required = false) String hsCode,
            @RequestParam(required = false) String productName,
            @RequestParam(required = false) String sendReqCountryCode,
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
            @RequestParam(required = false) String status,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "0") int size
    ) {
        String userId = (String) request.getSession().getAttribute("userId");
        String userLocation = (String) request.getSession().getAttribute("userLocation");
        Integer userRole = (Integer) request.getSession().getAttribute("userRole");
        List<Location> location = locationRepo.findAll();

        ModelAndView viewModel = new ModelAndView("resources/pages/InternationalSurvey/ResultIS");
        java.sql.Date xbbMailDateS = null;
        java.sql.Date reqDateS = null;
        java.sql.Date responseDateS = null;
        java.sql.Date responseNumSendXbbDateS = null;
        java.sql.Date resultAnswerMailDateS = null;
        java.sql.Date xbbVerdictDateS = null;
        if (!Objects.equals(xbbMailDate, "")) {
            xbbMailDateS = java.sql.Date.valueOf(xbbMailDate);
        }
        if (!Objects.equals(reqDate, "")) {
            reqDateS = java.sql.Date.valueOf(reqDate);
        }
        if (!Objects.equals(responseDate, "")) {
            responseDateS = java.sql.Date.valueOf(responseDate);
        }
        if (!Objects.equals(responseNumSendXbbDate, "")) {
            responseNumSendXbbDateS = java.sql.Date.valueOf(responseNumSendXbbDate);
        }
        if (!Objects.equals(resultAnswerMailDate, "")) {
            resultAnswerMailDateS = java.sql.Date.valueOf(resultAnswerMailDate);
        }
        if (!Objects.equals(xbbVerdictDate, "")) {
            resultAnswerMailDateS = java.sql.Date.valueOf(xbbVerdictDate);
        }
        try {
            List<InternationalSurveyEntity> tutorials = new ArrayList<InternationalSurveyEntity>();
            Pageable paging = PageRequest.of(page, size);
            Page<InternationalSurveyEntity> pageTuts =
                    internationalSurveyRepo.findAllByOrgNameAndHsCode(
                            userLocationCode,
                            directionTypeCode,
                            xbbMailNum,
                            xbbMailDateS,
                            hsCode,
                            productName,
                            sendReqCountryCode,
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
                            status,
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
            System.out.println(userId);
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
            if(!Objects.equals(internationalSurveyStep1DTO.getXbbMailNum(), "1701")){
                internationalSurveyEntity.setXbbMailNum(internationalSurveyStep1DTO.getXbbMailNum());
            }
            if (!Objects.equals(internationalSurveyStep1DTO.getXbbMailDate(), "")) {
                if(userLocation != "1701" && internationalSurveyStep1DTO.getXbbMailDate() != "1111-11-11"){
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
            if (Objects.equals(internationalSurveyStep2DTO.getExecutiveTerritoryCode(), "1701")){
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
            if (Objects.equals(internationalSurveyStep2DTO.getExecutiveTerritoryCode(), "1701")){
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
            if ((internationalSurveyEntity.getResponseNum() == null) || (Objects.equals(internationalSurveyEntity.getResponseNum(), ""))){
                notAllowedInputs.put("responseNum", "responseNum");
            }
            if ((internationalSurveyEntity.getResponseDate() == null)){
                notAllowedInputs.put("responseDate", "responseDate");
            }
            if (internationalSurveyEntity.getResponseNumSendXbbNum() == null || Objects.equals(internationalSurveyEntity.getResponseNumSendXbbNum(), "")){
                notAllowedInputs.put("responseNumSendXbbNum", "responseNumSendXbbNum");
            }
            if (internationalSurveyEntity.getResponseNumSendXbbDate() == null){
                notAllowedInputs.put("responseNumSendXbbDate", "responseNumSendXbbDate");
            }
            /**100-First step**/ /**200-Second step**/ /**300-Third step**/
            if(notAllowedInputs.size() == 0){
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
            if (!Objects.equals(internationalSurveyStep3DTO.getSumАpproved(), "")){
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
            if (!Objects.equals(internationalSurveyAddNewSumApproved.getSumApprovedAdd(), "")){
                newSumApproved = internationalSurveyEntity.getSumАpproved().add(internationalSurveyAddNewSumApproved.getSumApprovedAdd());
            } else newSumApproved = BigDecimal.valueOf(0.00);

            internationalSurveyEntity.setSumАpproved(newSumApproved);
            BigDecimal newSumOnControl;
            newSumOnControl = internationalSurveyEntity.getSum().subtract(newSumApproved);
            internationalSurveyEntity.setSumOnControl(newSumOnControl);

            String newComment = "";
            if (internationalSurveyAddNewSumApproved.getCommentAdd() != ""){
                newComment = internationalSurveyAddNewSumApproved.getCommentAdd() + ";" + "<br>" + internationalSurveyEntity.getComment();
                internationalSurveyEntity.setComment(newComment);
            }
            internationalSurveyEntity.setFabula(internationalSurveyAddNewSumApproved.getFabulaAdd());
            internationalSurveyService.savingValue(internationalSurveyEntity);
            return ResponseEntity.status(201).body(internationalSurveyEntity);
        } catch (Exception e){
            return new ResponseEntity<Object>("error", HttpStatus.BAD_REQUEST);
        }
    }
}
