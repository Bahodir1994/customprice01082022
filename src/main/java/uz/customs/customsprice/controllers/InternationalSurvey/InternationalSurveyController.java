package uz.customs.customsprice.controllers.InternationalSurvey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uz.customs.customsprice.entity.InitialDecision.Country;
import uz.customs.customsprice.entity.InternationalSurveyEntity.InternationalSurveyEntity;
import uz.customs.customsprice.repository.CountyRepo;
import uz.customs.customsprice.repository.InternationalSurveyRepo.InternationalSurveyRepo;
import uz.customs.customsprice.service.ConturyService;
import uz.customs.customsprice.service.InternationalSurveyS.InternationalSurveyService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.*;

@Controller
@RequestMapping("/inrenationalsurvaey")
public class InternationalSurveyController {
    private final String INTERNATIONALSURVEYPAGE = "/resources/pages/InternationalSurvay/FilterIS";
    private final String INTERNATIONALSURVEYRESULTPAGE = "/resources/pages/InternationalSurvay/ResultIS";
    private final String INTERNATIONALSURVEYSAVEIS = "/resources/pages/InternationalSurvay/SaveIS";

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
    public ModelAndView ResultIS(HttpSession session,
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
        ModelAndView viewModel = new ModelAndView("resources/pages/InternationalSurvey/ResultIS");
        java.sql.Date xbbMailDateS = null;
        java.sql.Date reqDateS = null;
        java.sql.Date responseDateS = null;
        java.sql.Date responseNumSendXbbDateS = null;
        java.sql.Date resultAnswerMailDateS = null;
        java.sql.Date xbbVerdictDateS = null;
        if (!Objects.equals(xbbMailDate, "")){
            xbbMailDateS = java.sql.Date.valueOf(xbbMailDate);
        }
        if (!Objects.equals(reqDate, "")){
            reqDateS = java.sql.Date.valueOf(reqDate);
        }
        if (!Objects.equals(responseDate, "")){
            responseDateS = java.sql.Date.valueOf(responseDate);
        }
        if (!Objects.equals(responseNumSendXbbDate, "")){
            responseNumSendXbbDateS = java.sql.Date.valueOf(responseNumSendXbbDate);
        }
        if (!Objects.equals(resultAnswerMailDate, "")){
            resultAnswerMailDateS = java.sql.Date.valueOf(resultAnswerMailDate);
        }
        if (!Objects.equals(xbbVerdictDate, "")){
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

            viewModel.addObject("next", paging.next());
            viewModel.addObject("hasPrevious", paging.hasPrevious());
            viewModel.addObject("getOffset", paging.getOffset());
            viewModel.addObject("getPageSize", paging.getPageSize());
            viewModel.addObject("first", paging.first());
            viewModel.addObject("getPageNumber", paging.getPageNumber());
            viewModel.addObject("getSort", paging.getSort());
            viewModel.addObject("isPaged", paging.isPaged());
            viewModel.addObject("toOptional", paging.toOptional());
            viewModel.addObject("previousOrFirst", paging.previousOrFirst());
            viewModel.addObject("withPage", paging.withPage(0));
            viewModel.addObject("isUnpaged", paging.isUnpaged());


        } catch (Exception e) {
            e.printStackTrace();
        }
        return viewModel;

    }


    @PostMapping(value = INTERNATIONALSURVEYSAVEIS)
    @ResponseBody
    public ResponseEntity SaveIS(HttpSession session, HttpServletRequest request, HttpServletResponse response,
                                 /***********************************************/
                                 @RequestParam(required = false) String xbbMailNum,
                                 @RequestParam(required = false) String xbbMailDate,
                                 @RequestParam(required = false) String orgName,
                                 @RequestParam(required = false) String hsCode,
                                 @RequestParam(required = false) String productName,
                                 /***********************************************/
                                 @RequestParam(required = false) String sendReqCountryCode,
                                 @RequestParam(required = false) String sendReqNum,
                                 @RequestParam(required = false) String reqDate,
                                 @RequestParam(required = false) String responseNum,
                                 @RequestParam(required = false) String responseDate,
                                 @RequestParam(required = false) String responseNumSendXbbNum,
                                 /***********************************************/
                                 @RequestParam(required = false) String responseNumSendXbbDate,
                                 @RequestParam(required = false) String resultAnswerMailNum,
                                 @RequestParam(required = false) String resultAnswerMailDate,
                                 @RequestParam(required = false) String xbbVerdictNum,
                                 @RequestParam(required = false) String xbbVerdictDate,
                                 @RequestParam(required = false) String sum,
                                 /***********************************************/
                                 @RequestParam(required = false) String comment,
                                 /***********************************************/
                                 @RequestParam(required = false) String id,
                                 @RequestParam(required = false) String status
    ) {

        if (Objects.equals(id, "") || id == null){
            try {
                InternationalSurveyEntity internationalSurveyEntity = new InternationalSurveyEntity();
                internationalSurveyEntity.setXbbMailNum(xbbMailNum);
                if (!Objects.equals(xbbMailDate, "")){
                    internationalSurveyEntity.setXbbMailDate(Date.valueOf(xbbMailDate));
                }
                internationalSurveyEntity.setOrgName(orgName);
                internationalSurveyEntity.setHsCode(hsCode);
                internationalSurveyEntity.setProductName(productName);
                /**100-First step**/ /**200-Second step**/ /**300-Third step**/
                internationalSurveyEntity.setStatus("100");
                internationalSurveyService.savingValue(internationalSurveyEntity);
                return new ResponseEntity(HttpStatus.OK);
            }catch (Exception e) {return new ResponseEntity(HttpStatus.BAD_REQUEST);}
        }
        else {
            try {
                InternationalSurveyEntity internationalSurveyEntity = internationalSurveyService.getByIdAndStatus(id, status);
                if (Objects.equals(internationalSurveyEntity.getStatus(), "100")){
                    internationalSurveyEntity.setSendReqCountryCode(sendReqCountryCode);
                    Country country = conturyService.getByCodeAndLngaTpcd(sendReqCountryCode, "UZ");
                    internationalSurveyEntity.setSendReqCountryNm(country.getCdNm());
                    internationalSurveyEntity.setSendReqNum(sendReqNum);
                    if (!Objects.equals(reqDate, "")){
                        internationalSurveyEntity.setReqDate(Date.valueOf(reqDate));
                    }
                    internationalSurveyEntity.setResponseNum(responseNum);
                    if (!Objects.equals(responseDate, "")){
                        internationalSurveyEntity.setResponseDate(Date.valueOf(responseDate));
                    }
                    internationalSurveyEntity.setResponseNumSendXbbNum(responseNumSendXbbNum);
                    /**100-First step**/ /**200-Second step**/ /**300-Third step**/
                    internationalSurveyEntity.setStatus("200");
                    internationalSurveyService.savingValue(internationalSurveyEntity);
                    return new ResponseEntity(HttpStatus.OK);
                }
                if (Objects.equals(internationalSurveyEntity.getStatus(), "200")){
                    if (!Objects.equals(responseNumSendXbbDate, "")){
                        internationalSurveyEntity.setResponseNumSendXbbDate(Date.valueOf(responseNumSendXbbDate));
                    }
                    internationalSurveyEntity.setResultAnswerMailNum(resultAnswerMailNum);
                    if (!Objects.equals(resultAnswerMailDate, "")){
                        internationalSurveyEntity.setResultAnswerMailDate(Date.valueOf(resultAnswerMailDate));
                    }
                    internationalSurveyEntity.setXbbVerdictNum(xbbVerdictNum);
                    if (!Objects.equals(xbbVerdictDate, "")){
                        internationalSurveyEntity.setXbbVerdictDate(Date.valueOf(xbbVerdictDate));
                    }
                    if (!Objects.equals(sum, "")){
                        internationalSurveyEntity.setSum(BigDecimal.valueOf(Long.parseLong(sum)));
                    }
                    /**100-First step**/ /**200-Second step**/ /**300-Third step**/
                    internationalSurveyEntity.setStatus("300");
                    internationalSurveyService.savingValue(internationalSurveyEntity);
                    return new ResponseEntity(HttpStatus.OK);
                }

            }catch (Exception e) {return new ResponseEntity(HttpStatus.BAD_REQUEST);}
        }return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }


}