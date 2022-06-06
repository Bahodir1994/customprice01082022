package uz.customs.customsprice.controllers.internationalSurvey;

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
import uz.customs.customsprice.entity.InternationalSurveyEntity.InternationalSurveyEntity;
import uz.customs.customsprice.repository.CountyRepo;
import uz.customs.customsprice.repository.InternationalSurveyRepo.InternationalSurveyRepo;
import uz.customs.customsprice.service.ConturyService;
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

    private final InternationalSurveyService internationalSurveyService;
    private final InternationalSurveyRepo internationalSurveyRepo;
    private final ConturyService conturyService;

    public InternationalSurveyController(InternationalSurveyService internationalSurveyService, InternationalSurveyRepo internationalSurveyRepo, ConturyService conturyService) {
        this.internationalSurveyService = internationalSurveyService;
        this.internationalSurveyRepo = internationalSurveyRepo;
        this.conturyService = conturyService;
    }

    @Autowired
    CountyRepo countyRepo;

    @PostMapping(value = INTERNATIONALSURVEYPAGE)
    @ResponseBody
    public ModelAndView FilterIS(HttpSession session) {
        ModelAndView mav = new ModelAndView("resources/pages/InternationalSurvey/FiltrIS");
        String lngaTpcd = "UZ";
        List<Country> countryList = countyRepo.findAllByLngaTpcdOrderByCodeAsc(lngaTpcd);
        mav.addObject("countryList", countryList);
        return mav;
    }

    @GetMapping(value = INTERNATIONALSURVEYRESULTPAGE)
    @ResponseBody
    public ModelAndView ResultIS(
            HttpSession session,
            HttpServletRequest request,
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

            viewModel.addObject("userId", userId);
            viewModel.addObject("userLocation", userLocation);
            viewModel.addObject("userRole", userRole);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return viewModel;

    }

    @PostMapping(value = INTERNATIONALSURVEYSAVEIS1)
    public ResponseEntity<Object> addFirst(@RequestBody @Valid InternationalSurveyStep1DTO internationalSurveyStep1DTO, BindingResult result) {
        Map<String, String> errors = new HashMap<>();
        if (result.hasErrors()) {
            errors = result.getFieldErrors().stream().collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
            System.out.println(" errors :=== " + errors);
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        } else {
            InternationalSurveyEntity internationalSurveyEntity = new InternationalSurveyEntity();
            /*1*/
            internationalSurveyEntity.setXbbMailNum(internationalSurveyStep1DTO.getXbbMailNum());
            if (!Objects.equals(internationalSurveyStep1DTO.getXbbMailDate(), "")) {
                /*2*/
                internationalSurveyEntity.setXbbMailDate(Date.valueOf(internationalSurveyStep1DTO.getXbbMailDate()));
            }
            /*3*/
            internationalSurveyEntity.setOrgName(internationalSurveyStep1DTO.getOrgName());
            /*4*/
            internationalSurveyEntity.setHsCode(internationalSurveyStep1DTO.getHsCode());
            /*5*/
            internationalSurveyEntity.setProductName(internationalSurveyStep1DTO.getProductName());
            Country country = conturyService.getByCodeAndLngaTpcd(internationalSurveyStep1DTO.getSendReqCountryCode(), "UZ");
            /*6.1*/
            internationalSurveyEntity.setSendReqCountryCode(internationalSurveyStep1DTO.getSendReqCountryCode());
            /*6.2*/
            internationalSurveyEntity.setSendReqCountryNm(country.getCdNm());
            /**100-First step**/ /**200-Second step**/ /**300-Third step**/
            internationalSurveyEntity.setStatus("100");
            /*finish*/
            internationalSurveyService.savingValue(internationalSurveyEntity);
//            return new ResponseEntity<>("success", HttpStatus.OK);
            return ResponseEntity.status(201).body(internationalSurveyEntity);
        }
    }

    @PostMapping(value = INTERNATIONALSURVEYSAVEIS2)
    public ResponseEntity<Object> addSecond(@RequestBody @Valid InternationalSurveyStep2DTO internationalSurveyStep2DTO, BindingResult result) {
        Map<String, String> errors = new HashMap<>();
        if (result.hasErrors()) {
            errors = result.getFieldErrors().stream().collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
            return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
        } else {
            InternationalSurveyEntity internationalSurveyEntity = internationalSurveyService.getByIdAndStatus(internationalSurveyStep2DTO.getId(), internationalSurveyStep2DTO.getStatus());
            /*7*/
            internationalSurveyEntity.setSendReqNum(internationalSurveyStep2DTO.getSendReqNum());
            if (!Objects.equals(internationalSurveyStep2DTO.getReqDate(), "")) {
                /*8*/
                internationalSurveyEntity.setReqDate(Date.valueOf(internationalSurveyStep2DTO.getReqDate()));
            }
            /*9*/
            internationalSurveyEntity.setResponseNum(internationalSurveyStep2DTO.getResponseNum());
            if (!Objects.equals(internationalSurveyStep2DTO.getResponseDate(), "")) {
                /*10*/
                internationalSurveyEntity.setResponseDate(Date.valueOf(internationalSurveyStep2DTO.getResponseDate()));
            }
            /*11*/
            internationalSurveyEntity.setResponseNumSendXbbNum(internationalSurveyStep2DTO.getResponseNumSendXbbNum());
            if (!Objects.equals(internationalSurveyStep2DTO.getResponseNumSendXbbDate(), "")) {
                /*12*/
                internationalSurveyEntity.setResponseNumSendXbbDate(Date.valueOf(internationalSurveyStep2DTO.getResponseNumSendXbbDate()));
            }
            /**100-First step**/ /**200-Second step**/ /**300-Third step**/
            internationalSurveyEntity.setStatus("200");
            internationalSurveyService.savingValue(internationalSurveyEntity);
            return ResponseEntity.status(201).body(internationalSurveyEntity);
        }
    }

    @PostMapping(value = INTERNATIONALSURVEYSAVEIS3)
    public ResponseEntity<Object> addSecond(@RequestBody @Valid InternationalSurveyStep3DTO internationalSurveyStep3DTO, BindingResult result) {
        Map<String, String> errors = new HashMap<>();
        if (result.hasErrors()) {
            errors = result.getFieldErrors().stream().collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
            return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
        } else {
            InternationalSurveyEntity internationalSurveyEntity = internationalSurveyService.getByIdAndStatus(internationalSurveyStep3DTO.getId(), internationalSurveyStep3DTO.getStatus());
            /*13*/
            internationalSurveyEntity.setResultAnswerMailNum(internationalSurveyStep3DTO.getResultAnswerMailNum());
            if (!Objects.equals(internationalSurveyStep3DTO.getResultAnswerMailDate(), "")) {
                /*14*/
                internationalSurveyEntity.setResultAnswerMailDate(Date.valueOf(internationalSurveyStep3DTO.getResultAnswerMailDate()));
            }
            /*15*/
            internationalSurveyEntity.setXbbVerdictNum(internationalSurveyStep3DTO.getXbbVerdictNum());
            if (!Objects.equals(internationalSurveyStep3DTO.getXbbVerdictDate(), "")) {
                /*16*/
                internationalSurveyEntity.setXbbVerdictDate(Date.valueOf(internationalSurveyStep3DTO.getXbbVerdictDate()));
            }
            if (!Objects.equals(internationalSurveyStep3DTO.getSum(), "")) {
                /*17*/
                internationalSurveyEntity.setSum(BigDecimal.valueOf(Long.parseLong(internationalSurveyStep3DTO.getSum())));
            }
            /*18*/
            internationalSurveyEntity.setComment(internationalSurveyStep3DTO.getComment());
            /**100-First step**/ /**200-Second step**/ /**300-Third step**/
            internationalSurveyEntity.setStatus("300");
            internationalSurveyService.savingValue(internationalSurveyEntity);
            return ResponseEntity.status(201).body(internationalSurveyEntity);
        }
    }
}
