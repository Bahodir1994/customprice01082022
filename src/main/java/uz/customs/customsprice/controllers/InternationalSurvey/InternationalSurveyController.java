package uz.customs.customsprice.controllers.InternationalSurvey;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uz.customs.customsprice.entity.InternationalSurveyEntity.InternationalSurveyEntity;
import uz.customs.customsprice.service.InternationalSurveyS.InternationalSurveyService;
import uz.customs.customsprice.utils.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/inrenationalsurvaey")
public class InternationalSurveyController {
    private final String INTERNATIONALSURVEYPAGE = "/resources/pages/InternationalSurvay/FilterIS";
    private final String INTERNATIONALSURVEYRESULTPAGE = "/resources/pages/InternationalSurvay/ResultIS";
    private final String INTERNATIONALSURVEYSAVEIS = "/resources/pages/InternationalSurvay/SaveIS";

    private final InternationalSurveyService internationalSurveyService;

    public InternationalSurveyController(InternationalSurveyService internationalSurveyService) {
        this.internationalSurveyService = internationalSurveyService;
    }

    @PostMapping(value = INTERNATIONALSURVEYPAGE)
    @ResponseBody
    public ModelAndView FilterIS(HttpSession session) {
        ModelAndView mav = new ModelAndView("resources/pages/InternationalSurvey/FiltrIS");


        return mav;
    }


    @PostMapping(value = INTERNATIONALSURVEYRESULTPAGE)
    @ResponseBody
    public ModelAndView ResultIS(HttpSession session, @RequestParam String IsId) {
        ModelAndView mav = new ModelAndView("resources/pages/InternationalSurvey/ResultIS");
        mav.addObject("IntSur", internationalSurveyService.getById(IsId));
        return mav;
    }

    @PostMapping(value = INTERNATIONALSURVEYSAVEIS)
    @ResponseBody
    public ModelAndView SaveIS(HttpSession session, HttpServletRequest request, HttpServletResponse response,
        @RequestParam  String xbbMailNum,
        @RequestParam  String xbbMailDate,
        @RequestParam  String orgName,
        @RequestParam  String hsCode,
        @RequestParam  String productName,
        @RequestParam  String sendReqCountryCode,
        @RequestParam  String sendReqNum,
        @RequestParam  String reqDate,
        @RequestParam  String responseNum,
        @RequestParam  String responseDate,
        @RequestParam  String responseNumSendXbbNum,
        @RequestParam  String responseNumSendXbbDate,
        @RequestParam  String resultAnswerMailNum,
        @RequestParam  String resultAnswerMailDate,
        @RequestParam  String xbbVerdictNum,
        @RequestParam  String xbbVerdictDate,
        @RequestParam  String sum,
        @RequestParam  String comment
    ) {
        ModelAndView mav = new ModelAndView("resources/pages/InternationalSurvey/FiltrIS");
        InternationalSurveyEntity internationalSurveyEntity = new InternationalSurveyEntity();
        internationalSurveyEntity.setXbbMailNum(xbbMailNum);
        if (!Objects.equals(xbbMailDate, "")){
            internationalSurveyEntity.setXbbMailDate(Date.valueOf(xbbMailDate));
        }
        internationalSurveyEntity.setOrgName(orgName);
        internationalSurveyEntity.setHsCode(hsCode);
        internationalSurveyEntity.setProductName(productName);
        internationalSurveyEntity.setSendReqCountryCode(sendReqCountryCode);
        internationalSurveyEntity.setSendReqNum(sendReqNum);
        if (!Objects.equals(reqDate, "")){
            internationalSurveyEntity.setReqDate(Date.valueOf(reqDate));
        }

        internationalSurveyEntity.setResponseNum(responseNum);
        if (!Objects.equals(responseDate, "")){
            internationalSurveyEntity.setResponseDate(Date.valueOf(responseDate));
        }
        internationalSurveyEntity.setResponseNumSendXbbNum(responseNumSendXbbNum);
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

//        internationalSurveyEntity.setSum(sum);
        internationalSurveyEntity.setComment(comment);

        /**100-First step**/ /**200-Second step**/ /**300-Third step**/
        internationalSurveyEntity.setStatus(100);

        internationalSurveyService.savingValue(internationalSurveyEntity);

        return mav;
    }


}