package uz.customs.customsprice.controllers.indec;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import uz.customs.customsprice.service.CostMonitoringService;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/sent")
public class ModalsController {

    private final String LOGICALCONTROL = "/resources/pages/Modals/LogicalControlModal";
    private final String COSTMONITORING = "/resources/pages/CostMonitoring/CostMonitoring";
//    private final String INITIALDECISIONVIEW = "/resources/pages/InitialDecision/InitialDecisionView";
    private final CostMonitoringService costMonitoringService;

    public ModalsController(CostMonitoringService costMonitoringService) {
        this.costMonitoringService = costMonitoringService;
    }

    @PostMapping(value = LOGICALCONTROL)
    @ResponseBody
    public ModelAndView LogicalControl(HttpSession session) {
        ModelAndView mav = new ModelAndView("/resources/pages/Modals/LogicalControlModal");
        return mav;
    }

    @PostMapping(value = COSTMONITORING)
    @ResponseBody
    public ModelAndView CostMonitoring(HttpSession session, @RequestParam String id) {
        ModelAndView mav = new ModelAndView("/resources/pages/CostMonitoring/CostMonitoring");
        mav.addObject("country", costMonitoringService.getCostMonitoring("1"));
        return mav;
    }


//    @PostMapping(value = INITIALDECISIONVIEW)
//    @ResponseBody
//    public ModelAndView InitialDecisionView(HttpSession session, @RequestParam int app_id) {
//        ModelAndView mav = new ModelAndView("InitialDecisionView2");
//        mav.addObject("applicationId", costMonitoringService.getInitialDecisionView(app_id));
//        return mav;
//    }

}