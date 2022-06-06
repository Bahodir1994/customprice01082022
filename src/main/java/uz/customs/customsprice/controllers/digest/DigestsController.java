package uz.customs.customsprice.controllers.digest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uz.customs.customsprice.entity.Digests.FreedocEntity;
import uz.customs.customsprice.entity.Digests.FreehashEntity;
import uz.customs.customsprice.entity.Digests.QiymatconsultEntity;
import uz.customs.customsprice.entity.InitialDecision.Location;
import uz.customs.customsprice.entity.gtdHistory.DeclarationEntity;
import uz.customs.customsprice.repository.LocationRepo;
//import uz.customs.customsprice.repository.QiymatconsultRepo;
import uz.customs.customsprice.repository.digests.QiymatconsultRepo;
import uz.customs.customsprice.service.BYDHistoryService;
import uz.customs.customsprice.service.QiymatconsultService;
import uz.customs.customsprice.service.pcabinet.FreeDocService;
import uz.customs.customsprice.service.pcabinet.FreeHashService;
import uz.customs.customsprice.utils.Utils;


import javax.servlet.http.HttpSession;
import java.io.FileNotFoundException;
import java.util.Base64;
import java.util.List;

@Controller
@RequestMapping("/digests")
public class DigestsController {
    private final String DIGESTSPAGE = "/resources/pages/Digests/DigestsPage";
    /**
     * ШАРТЛИ БЕЛГИЛАНГАН ТОВАРЛАР
     **/
    private final String DIGESTSFIRST = "/resources/pages/Digests/DigestsFirst";
    private final String QIYMATREJECTMODAL = "/resources/pages/Digests/QiymatRejectModal";
    private final String QIYMATCONSULTMODAL = "/resources/pages/Digests/QiymatConsultModal";
    private final String QIYMATSHARTLITMODAL = "/resources/pages/Digests/QiymatShartliModal";
    private final String PCABINET = "/resources/pages/Digests/Pcabinet";
    /**ШАРТЛИ БЕЛГИЛАНГАН ТОВАРЛАР **/

    /**
     * БОЖХОНА ЮК ДЕКЛАРАЦИЯЛАРИ ТАРИХИ
     **/
    private final String FILTERBYDHISTORY = "/resources/pages/Digests/FilterBYDHistory";
    private final String RESULTBYDHISTORY = "/resources/pages/Digests/ResultBYDHistory";
    /**
     * БОЖХОНА ЮК ДЕКЛАРАЦИЯЛАРИ ТАРИХИ
     **/

    private final QiymatconsultService qiymatconsultService;
    private final FreeDocService freeDocService;
    private final FreeHashService freeHashService;
    private final BYDHistoryService bydHistoryService;

    @Autowired
    private final QiymatconsultRepo qiymatconsultRepo;

    @Autowired
    LocationRepo locationRepo;

    public DigestsController(QiymatconsultService qiymatconsultService, FreeDocService freeDocService, FreeHashService freeHashService, BYDHistoryService bydHistoryService, QiymatconsultRepo qiymatconsultRepo) {
        this.qiymatconsultService = qiymatconsultService;
        this.freeDocService = freeDocService;
        this.freeHashService = freeHashService;
        this.bydHistoryService = bydHistoryService;
        this.qiymatconsultRepo = qiymatconsultRepo;
    }

    @PostMapping(value = DIGESTSPAGE)
    @ResponseBody
    public ModelAndView DigestsPage(HttpSession session) {
        ModelAndView mav = new ModelAndView("resources/pages/Digests/DigestsPage");
        return mav;
    }

    /***********ШАРТЛИ БЕЛГИЛАНГАН ТОВАРЛАР **********************************************/
    @PostMapping(value = DIGESTSFIRST)
    @ResponseBody
    public ModelAndView DigestsFirst(HttpSession session) {
        ModelAndView mav = new ModelAndView("resources/pages/Digests/ShartliBelgilanganTovarlar/DigestsFirst");

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
        ModelAndView mav = new ModelAndView("resources/pages/Digests/ShartliBelgilanganTovarlar/QiymatRejectModal");

        List<QiymatconsultEntity> qiymattovarEntityList = qiymatconsultService.getListQiymattovarModal(tov_id);
        mav.addObject("qiymatTovar", qiymattovarEntityList);
        return mav;
    }

    @PostMapping(value = QIYMATCONSULTMODAL)
    @ResponseBody
    public ModelAndView QiymatConsultModal(HttpSession session, @RequestParam String tov_id) {
        ModelAndView mav = new ModelAndView("resources/pages/Digests/ShartliBelgilanganTovarlar/QiymatConsultModal");

        List<QiymatconsultEntity> qiymatconsultEntityList = qiymatconsultService.getListQiymatConsultModal(tov_id);
        mav.addObject("qiymatConsult", qiymatconsultEntityList);
        return mav;
    }

    @PostMapping(value = QIYMATSHARTLITMODAL)
    @ResponseBody
    public ModelAndView QiymatShartliModal(HttpSession session, @RequestParam String tov_id) {
        ModelAndView mav = new ModelAndView("resources/pages/Digests/ShartliBelgilanganTovarlar/QiymatShartliModal");

        List<QiymatconsultEntity> qiymatShartliEntityList = qiymatconsultService.getListQiymatShartliModal(tov_id);
        mav.addObject("qiymatShartli", qiymatShartliEntityList);
        return mav;
    }

    @PostMapping(value = PCABINET, produces = MediaType.APPLICATION_PDF_VALUE)
    @ResponseBody
    public ModelAndView Pcabinet(HttpSession session, @RequestParam String declId, String docType) throws FileNotFoundException {
        ModelAndView mav = new ModelAndView("resources/pages/Digests/ShartliBelgilanganTovarlar/QiymatPdf");

        FreedocEntity freedocEntity = freeDocService.getByDeclIdAndAndDocType(declId, docType);
        if (freedocEntity == null || freedocEntity.equals("")) {
            mav.addObject("pdfFile", null);
            return mav;
        } else {
            String hashPdf = freedocEntity.getHash();
            FreehashEntity freehashEntity = freeHashService.getByHash(hashPdf);
            String imageBase64 = "";
            imageBase64 = new String(Base64.getEncoder().encode(freehashEntity.getFiledata()));
            mav.addObject("pdfFile", imageBase64);
            return mav;
        }
    }
    /***********ШАРТЛИ БЕЛГИЛАНГАН ТОВАРЛАР **********************************************/

    /***********БОЖХОНА ЮК ДЕКЛАРАЦИЯЛАРИ ТАРИХИ **********************************************/
    @PostMapping(value = FILTERBYDHISTORY)
    @ResponseBody
    public ModelAndView FilterBYDHistory(HttpSession session) {
        ModelAndView mav = new ModelAndView("resources/pages/Digests/BojxonaYukDeklaratsiyalariTarixi/FiltrBYDHistory");
        String lngaTpcd = "UZ";
        List<Location> locationList = locationRepo.findAll();
        mav.addObject("locationList", locationList);
        return mav;
    }

    @GetMapping(value = RESULTBYDHISTORY)
    @ResponseBody
    public ModelAndView ResultBYDHistory(HttpSession session, @RequestParam String g7a, @RequestParam String g7b, @RequestParam String g7c) {
        ModelAndView mav = new ModelAndView("resources/pages/Digests/BojxonaYukDeklaratsiyalariTarixi/ResultBYDHistory");

        List<Object[]> declList = bydHistoryService.getListGTDHistory(g7a, g7b, g7c);

        String p7a = "", p7b = "", p7c = "", declId = "";

        if (declList.size() > 0) {
            p7a = Utils.nullClear(declList.get(0)[7]).toString();
            p7b = Utils.nullClear(declList.get(0)[8]).toString();
            p7c = Utils.nullClear(declList.get(0)[9]).toString();
            declId = Utils.nullClear(declList.get(0)[10]).toString();
            mav.addObject("declList", declList);

            List<DeclarationEntity> declDetailsList = bydHistoryService.getListGTDHistoryDetails(p7a, p7b, p7c, declId);
            mav.addObject("declDetailsList", declDetailsList);
        }




        return mav;
    }
    /***********БОЖХОНА ЮК ДЕКЛАРАЦИЯЛАРИ ТАРИХИ **********************************************/


}
