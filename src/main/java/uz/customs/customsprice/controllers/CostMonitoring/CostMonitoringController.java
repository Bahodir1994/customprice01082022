package uz.customs.customsprice.controllers.CostMonitoring;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import uz.customs.customsprice.entity.InitialDecision.*;
import uz.customs.customsprice.entity.classifier.TransportTypeS;
import uz.customs.customsprice.payload.CostMonitoringResponse;
import uz.customs.customsprice.payload.PostResponse;
import uz.customs.customsprice.repository.*;
import uz.customs.customsprice.repository.classifier.PostRepository;
import uz.customs.customsprice.repository.classifier.TransportTypeSRepo;
import uz.customs.customsprice.service.ConturyService;
import uz.customs.customsprice.service.CostMonitoring.CostMonitoringService;
import uz.customs.customsprice.utils.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/costmonitoring")
public class CostMonitoringController {
    private final String COSTMONITORINGPAGE = "/resources/pages/CostMonitoring/FiltrCM";
    private final String COSTMONITORING_POST = "/resources/pages/CostMonitoring/FiltrCMPost";
    private final String COSTMONITORINGRESULTPAGE = "/resources/pages/CostMonitoring/ResultCM";

    private final ConturyService conturyService;
    private final CostMonitoringService costMonitoringService;

    @Autowired
    CountyRepo countyRepo;

    @Autowired
    LocationRepo locationRepo;

    @Autowired
    PostRepository postRepository;

    @Autowired
    MethodRepo methodRepo;

    @Autowired
    TransportTypeSRepo transportTypeSRepo;

    @Autowired
    TermsRepo termsRepo;

    public CostMonitoringController(ConturyService conturyService, CostMonitoringService costMonitoringService) {
        this.conturyService = conturyService;
        this.costMonitoringService = costMonitoringService;
    }

    @PostMapping(value = COSTMONITORINGPAGE)
    @ResponseBody
    public ModelAndView FilterCM(HttpSession session) {
        ModelAndView mav = new ModelAndView("resources/pages/CostMonitoring/FiltrCM");
        String lngaTpcd = "UZ";
        List<Country> countryList = countyRepo.findAllByLngaTpcdOrderByCodeAsc(lngaTpcd);
        List<Terms> termsList = termsRepo.findAllByLngaTpcdOrderByRaqamAsc(lngaTpcd);
        List<Location> locationList = locationRepo.findAll();
        List<Method> methodList = methodRepo.findAll();
        List<TransportTypeS> transportTypeSList = transportTypeSRepo.findAll();
        mav.addObject("countryList", countryList);
        mav.addObject("locationList", locationList);
        mav.addObject("methodList", methodList);
        mav.addObject("transportTypeSList", transportTypeSList);
        mav.addObject("termsList", termsList);
        return mav;
    }

    @PostMapping(value = COSTMONITORING_POST)
    public ResponseEntity<List<PostResponse>> FilterCM_POST(HttpSession session, HttpServletRequest request, @RequestParam String locationId) {
        String lngaTpcd = "";
        lngaTpcd = "UZ";
        List<Post> postList = postRepository.findAllByCodeStartingWithAndLngaTpcd(locationId, lngaTpcd);
        ObjectMapper objectMapper = new ObjectMapper();
        Post post = null;
        List<PostResponse> postResponseList = new ArrayList<>();
        for (int i = 0; i < postList.size(); i++) {
            PostResponse postResponse = new PostResponse();
            post = postList.get(i);
            postResponse.setCode(post.getCode());
            postResponse.setCdNm(post.getCdNm());
            postResponseList.add(postResponse);
        }
        return ResponseEntity.ok(postResponseList);
    }

    @PostMapping(value = COSTMONITORINGRESULTPAGE)
    @ResponseBody
    public ModelAndView ResultCM(HttpSession session, @RequestParam String locationId, @RequestParam String postId, @RequestParam String gdvipdate1,
                                 @RequestParam String gdvipdate2) {
        ModelAndView mav = new ModelAndView("resources/pages/CostMonitoring/ResultCM");
        List<Object[]> mtcReplList = costMonitoringService.getListCostMonitoring(locationId, postId, gdvipdate1, gdvipdate2);
        List<CostMonitoringResponse> list = new ArrayList<>();
        for (int i = 0; i < mtcReplList.size(); i++) {
            CostMonitoringResponse response = new CostMonitoringResponse(
                    (String) mtcReplList.get(i)[0],
                    (String) mtcReplList.get(i)[1],
                    (String) mtcReplList.get(i)[2],
                    (String) mtcReplList.get(i)[3],
                    (String) (mtcReplList.get(i)[4]),
                    (String) mtcReplList.get(i)[5],
                    (String) mtcReplList.get(i)[6],
                    (String) mtcReplList.get(i)[7],
                    (String) mtcReplList.get(i)[8],
                    (String) mtcReplList.get(i)[9],
                    (String) mtcReplList.get(i)[10],
                    (String) mtcReplList.get(i)[11],
                    (String) mtcReplList.get(i)[12],
                    (String) mtcReplList.get(i)[13],
                    (String) mtcReplList.get(i)[14],
//                    new BigDecimal((String) mtcReplList.get(i)[15]),
                    (BigDecimal) mtcReplList.get(i)[15],
                    (BigDecimal) mtcReplList.get(i)[16],
                    (String) mtcReplList.get(i)[17],
                    (String) mtcReplList.get(i)[18],
                    (String) mtcReplList.get(i)[19],
                    (String) mtcReplList.get(i)[20],
                    (String) mtcReplList.get(i)[21],
                    (BigDecimal) mtcReplList.get(i)[22],
                    (BigDecimal) mtcReplList.get(i)[23],
                    (BigDecimal) mtcReplList.get(i)[24],
                    (String) mtcReplList.get(i)[25],
                    (String) mtcReplList.get(i)[26],
                    (String) mtcReplList.get(i)[27],
                    (String) mtcReplList.get(i)[28],
                    (String) mtcReplList.get(i)[39],
                    (String) mtcReplList.get(i)[30],
                    (String) mtcReplList.get(i)[31],
                    (String) mtcReplList.get(i)[32],
                    (BigDecimal) mtcReplList.get(i)[33],
                    (short) mtcReplList.get(i)[34],
                    (String) mtcReplList.get(i)[35],
                    (String) mtcReplList.get(i)[36],
                    (BigDecimal) mtcReplList.get(i)[37],
                    (String) mtcReplList.get(i)[38],
                    (String) mtcReplList.get(i)[39],
                    (BigDecimal) mtcReplList.get(i)[40],
                    (String) mtcReplList.get(i)[41],
                    (BigDecimal) mtcReplList.get(i)[42],
                    (String) mtcReplList.get(i)[43],
                    (BigDecimal) mtcReplList.get(i)[44],
                    (BigDecimal) mtcReplList.get(i)[45],
                    (String) mtcReplList.get(i)[46],
                    (BigDecimal) mtcReplList.get(i)[47],
                    (String) mtcReplList.get(i)[48],
                    (BigDecimal) mtcReplList.get(i)[49],
                    (String) mtcReplList.get(i)[50],
                    (BigDecimal) mtcReplList.get(i)[51],
                    (BigDecimal) mtcReplList.get(i)[52],
                    (BigDecimal) mtcReplList.get(i)[53],
                    (BigDecimal) mtcReplList.get(i)[54],
                    (BigDecimal) mtcReplList.get(i)[55],
                    (BigDecimal) mtcReplList.get(i)[56],
                    (BigDecimal) mtcReplList.get(i)[57],
                    (BigDecimal) mtcReplList.get(i)[58],
                    (BigDecimal) mtcReplList.get(i)[59],
                    (BigDecimal) mtcReplList.get(i)[60],
                    (BigDecimal) mtcReplList.get(i)[61],
                    (BigDecimal) mtcReplList.get(i)[62],
                    (String) mtcReplList.get(i)[63],
                    (short) mtcReplList.get(i)[64],
                    (short) mtcReplList.get(i)[65],
                    (String) mtcReplList.get(i)[66],
                    (short) mtcReplList.get(i)[67],
                    (Timestamp) mtcReplList.get(i)[68],
                    (Timestamp) mtcReplList.get(i)[69],
                    (Timestamp) mtcReplList.get(i)[70],
                    (Integer) mtcReplList.get(i)[71],
                    (Integer) mtcReplList.get(i)[72],
                    (String) mtcReplList.get(i)[73],
                    (String) mtcReplList.get(i)[74],
                    (String) mtcReplList.get(i)[75],
                    (String) mtcReplList.get(i)[76],
                    (String) mtcReplList.get(i)[77]
            );
            list.add(response);
        }
        mav.addObject("mtcReplList", list);
        return mav;
    }


}