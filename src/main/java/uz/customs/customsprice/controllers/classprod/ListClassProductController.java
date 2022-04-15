package uz.customs.customsprice.controllers.classprod;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import uz.customs.customsprice.entity.InitialDecision.Apps;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/main")
public class ListClassProductController {
    private final String LISTCLASSPRODUCT = "/resources/pages/ClassProduct/ListClassProduct";


    @PostMapping(value = LISTCLASSPRODUCT)
    @ResponseBody
    public ModelAndView InitialDecision(HttpSession session, @RequestParam(name = "id") String status) {
        ModelAndView mav = new ModelAndView("resources/pages/ClassProduct/ListClassProduct");
//        Iterable<Apps> arizalar = appsservice.listAll();
//        mav.addObject("apps", arizalar);
        return mav;
    }
}
