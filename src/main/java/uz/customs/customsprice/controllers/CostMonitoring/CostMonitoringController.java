package uz.customs.customsprice.controllers.CostMonitoring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/costmonitoring")
public class CostMonitoringController {
    private final String COSTMONITORINGPAGE = "/resources/pages/CostMonitoring/FiltrCM";
    private final String COSTMONITORINGRESULTPAGE = "/resources/pages/CostMonitoring/ResultCM";

    @PostMapping(value = COSTMONITORINGPAGE)
    @ResponseBody
    public ModelAndView FilterCM(HttpSession session) {
        ModelAndView mav = new ModelAndView("resources/pages/CostMonitoring/FiltrCM");

        return mav;
    }

    @PostMapping(value = COSTMONITORINGRESULTPAGE)
    @ResponseBody
    public ModelAndView ResultCM(HttpSession session) {
        ModelAndView mav = new ModelAndView("resources/pages/CostMonitoring/ResultCM");

        return mav;
    }


}