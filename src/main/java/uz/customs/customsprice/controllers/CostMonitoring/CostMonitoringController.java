package uz.customs.customsprice.controllers.CostMonitoring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import uz.customs.customsprice.entity.Digests.FreedocEntity;
import uz.customs.customsprice.entity.Digests.FreehashEntity;
import uz.customs.customsprice.entity.Digests.QiymatconsultEntity;
import uz.customs.customsprice.repository.QiymatconsultRepo;
import uz.customs.customsprice.service.QiymatconsultService;
import uz.customs.customsprice.service.pcabinet.FreeDocService;
import uz.customs.customsprice.service.pcabinet.FreeHashService;

import javax.servlet.http.HttpSession;
import java.io.FileNotFoundException;
import java.util.Base64;
import java.util.List;

@Controller
@RequestMapping("/costmonitoring")
public class CostMonitoringController {
    private final String COSTMONITORINGPAGE = "/resources/pages/CostMonitoring/FiltrCM";
    private final QiymatconsultService qiymatconsultService;
    private final FreeDocService freeDocService;
    private final FreeHashService freeHashService;
//    resources/pages/CostMonitoring/FiltrCM
    @Autowired
    private final QiymatconsultRepo qiymatconsultRepo;

    public CostMonitoringController(QiymatconsultService qiymatconsultService, FreeDocService freeDocService, FreeHashService freeHashService, QiymatconsultRepo qiymatconsultRepo) {
        this.qiymatconsultService = qiymatconsultService;
        this.freeDocService = freeDocService;
        this.freeHashService = freeHashService;
        this.qiymatconsultRepo = qiymatconsultRepo;
    }


    @PostMapping(value = COSTMONITORINGPAGE)
    @ResponseBody
    public ModelAndView DigestsFirst(HttpSession session) {
        ModelAndView mav = new ModelAndView("resources/pages/CostMonitoring/FiltrCM");

        List<QiymatconsultEntity> qiymatconsultEntityList = qiymatconsultService.getListQiymatconsulting();
        mav.addObject("qiymatconsult", qiymatconsultEntityList);

        List<QiymatconsultEntity> qiymatRejectEntityList = qiymatconsultService.getListQiymatReject();
        mav.addObject("qiymatReject", qiymatRejectEntityList);

        List<QiymatconsultEntity> qiymatShartliEntityList = qiymatconsultService.getListQiymatshartli();
        mav.addObject("qiymatshartli", qiymatShartliEntityList);

        return mav;
    }


}