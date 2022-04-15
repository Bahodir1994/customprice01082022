package uz.customs.customsprice.controllers.digest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import uz.customs.customsprice.entity.Digests.QiymatconsultEntity;
import uz.customs.customsprice.repository.QiymatconsultRepo;
import uz.customs.customsprice.service.QiymatconsultService;



import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/digests")
public class DigestsController {
    private final String DIGESTSPAGE = "/resources/pages/Digests/DigestsPage";
    private final String DIGESTSFIRST = "/resources/pages/Digests/DigestsFirst";
    private final String QIYMATREJECTMODAL = "/resources/pages/Digests/QiymatRejectModal";
    private final String QIYMATCONSULTMODAL = "/resources/pages/Digests/QiymatConsultModal";
    private final String QIYMATSHARTLITMODAL = "/resources/pages/Digests/QiymatShartliModal";
    private final QiymatconsultService qiymatconsultService;

    @Autowired
    private final QiymatconsultRepo qiymatconsultRepo;

    public DigestsController(QiymatconsultService qiymatconsultService, QiymatconsultRepo qiymatconsultRepo) {
        this.qiymatconsultService = qiymatconsultService;
        this.qiymatconsultRepo = qiymatconsultRepo;
    }

    @PostMapping(value = DIGESTSPAGE)
    @ResponseBody
    public ModelAndView DigestsPage(HttpSession session) {
        ModelAndView mav = new ModelAndView("resources/pages/Digests/DigestsPage");
//        Iterable<Apps> arizalar = appsservice.listAll();
//        mav.addObject("apps", arizalar);
        return mav;
    }

    @PostMapping(value = DIGESTSFIRST)
    @ResponseBody
    public ModelAndView DigestsFirst(HttpSession session) {
        ModelAndView mav = new ModelAndView("resources/pages/Digests/DigestsFirst");

        List<QiymatconsultEntity> qiymatconsultEntityList = qiymatconsultService.getListQiymatconsulting();
        mav.addObject("qiymatconsult", qiymatconsultEntityList);

        List<QiymatconsultEntity> qiymatRejectEntityList = qiymatconsultService.getListQiymatReject();
        mav.addObject("qiymatReject", qiymatRejectEntityList);

        List<QiymatconsultEntity> qiymatShartliEntityList = qiymatconsultService.getListQiymatshartli();
        mav.addObject("qiymatshartli", qiymatShartliEntityList);

        return mav;
    }


    @PostMapping(value = QIYMATREJECTMODAL)
    @ResponseBody
    public ModelAndView QiymatRejectModal(HttpSession session, @RequestParam String tov_id) {
        ModelAndView mav = new ModelAndView("resources/pages/Digests/QiymatRejectModal");

        List<QiymatconsultEntity> qiymattovarEntityList = qiymatconsultService.getListQiymattovarModal(tov_id);
        mav.addObject("qiymatTovar", qiymattovarEntityList);
        return mav;
    }


    @PostMapping(value = QIYMATCONSULTMODAL)
    @ResponseBody
    public ModelAndView QiymatConsultModal(HttpSession session, @RequestParam String tov_id) {
        ModelAndView mav = new ModelAndView("resources/pages/Digests/QiymatConsultModal");

        List<QiymatconsultEntity> qiymatconsultEntityList = qiymatconsultService.getListQiymatConsultModal(tov_id);
        mav.addObject("qiymatConsult", qiymatconsultEntityList);
        return mav;
    }

    @PostMapping(value = QIYMATSHARTLITMODAL)
    @ResponseBody
    public ModelAndView QiymatShartliModal(HttpSession session, @RequestParam String tov_id) {
        ModelAndView mav = new ModelAndView("resources/pages/Digests/QiymatShartliModal");

        List<QiymatconsultEntity> qiymatShartliEntityList = qiymatconsultService.getListQiymatShartliModal(tov_id);
        mav.addObject("qiymatShartli", qiymatShartliEntityList);
        return mav;
    }


}
