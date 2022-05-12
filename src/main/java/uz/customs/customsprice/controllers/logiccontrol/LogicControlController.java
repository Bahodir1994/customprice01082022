package uz.customs.customsprice.controllers.logiccontrol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import uz.customs.customsprice.repository.QiymatconsultRepo;
import uz.customs.customsprice.service.QiymatconsultService;
import uz.customs.customsprice.service.pcabinet.FreeDocService;
import uz.customs.customsprice.service.pcabinet.FreeHashService;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/logicalcontrolss")
public class LogicControlController {
    private final String FILTERLC = "/resources/pages/LogicalControl/FilterLC";
    private final String RESULTLC = "/resources/pages/LogicalControl/ResultLC";


    @PostMapping(value = FILTERLC)
    @ResponseBody
    public ModelAndView FilterLC(HttpSession session) {
        ModelAndView mav = new ModelAndView("resources/pages/LogicControl/FilterLC");

        return mav;
    }


    @PostMapping(value = RESULTLC)
    @ResponseBody
    public ModelAndView ResultLC(HttpSession session) {
        ModelAndView mav = new ModelAndView("resources/pages/LogicControl/ResultLC");

        return mav;
    }


}