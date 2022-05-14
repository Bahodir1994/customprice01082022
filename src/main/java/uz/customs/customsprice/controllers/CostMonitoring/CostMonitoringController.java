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
import uz.customs.customsprice.payload.CostMonitoringResponse;
import uz.customs.customsprice.payload.PostResponse;
import uz.customs.customsprice.repository.CountyRepo;
import uz.customs.customsprice.repository.LocationRepo;
import uz.customs.customsprice.repository.classifier.PostRepository;
import uz.customs.customsprice.service.ConturyService;
import uz.customs.customsprice.service.CostMonitoring.CostMonitoringService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
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
        List<Location> locationList = locationRepo.findAll();
        mav.addObject("countryList", countryList);
        mav.addObject("locationList", locationList);
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
    public ModelAndView ResultCM(HttpSession session, @RequestParam String locationId, @RequestParam String postId) {
        ModelAndView mav = new ModelAndView("resources/pages/CostMonitoring/ResultCM");
        List<Object[]> mtcReplList = costMonitoringService.getListCostMonitoring(locationId, postId);
        List<CostMonitoringResponse> list = new ArrayList<>();
        for (int i = 0; i < mtcReplList.size(); i++) {
            CostMonitoringResponse response = new CostMonitoringResponse(
                    (String) mtcReplList.get(i)[1],
                    (String) mtcReplList.get(i)[2],
                    (String) mtcReplList.get(i)[3],
                    (String) mtcReplList.get(i)[4],
                    (Date) (mtcReplList.get(i)[5]),
                    (String) mtcReplList.get(i)[6],
                    (String) mtcReplList.get(i)[7],
                    (String) mtcReplList.get(i)[8],
                    (String) mtcReplList.get(i)[9],
                    (String) mtcReplList.get(i)[10],
                    (String) mtcReplList.get(i)[11],
                    (String) mtcReplList.get(i)[12],
                    (String) mtcReplList.get(i)[13],
                    (String) mtcReplList.get(i)[14],
                    (String) mtcReplList.get(i)[15],
                    new BigDecimal((String) mtcReplList.get(i)[16]),
                    new BigDecimal((String) mtcReplList.get(i)[17]),
                    (String) mtcReplList.get(i)[18],
                    (String) mtcReplList.get(i)[19],
                    (String) mtcReplList.get(i)[20],
                    (String) mtcReplList.get(i)[21],
                    (String) mtcReplList.get(i)[22],
                    new BigDecimal((String) mtcReplList.get(i)[23]),
                    new BigDecimal((String) mtcReplList.get(i)[24]),
                    new BigDecimal((String) mtcReplList.get(i)[25]),
                    (String) mtcReplList.get(i)[26],
                    (String) mtcReplList.get(i)[27],
                    (String) mtcReplList.get(i)[28],
                    (String) mtcReplList.get(i)[29],
                    (String) mtcReplList.get(i)[30],
                    (String) mtcReplList.get(i)[31],
                    (String) mtcReplList.get(i)[32],
                    (String) mtcReplList.get(i)[33],
                    new BigDecimal((String) mtcReplList.get(i)[34]),
                    (short) mtcReplList.get(i)[35],
                    (String) mtcReplList.get(i)[36],
                    (String) mtcReplList.get(i)[37],
                    new BigDecimal((String) mtcReplList.get(i)[38]),
                    (String) mtcReplList.get(i)[39],
                    (String) mtcReplList.get(i)[40],
                    new BigDecimal((String) mtcReplList.get(i)[41]),
                    (String) mtcReplList.get(i)[42],
                    new BigDecimal((String) mtcReplList.get(i)[43]),
                    (String) mtcReplList.get(i)[44],
                    new BigDecimal((String) mtcReplList.get(i)[45]),
                    new BigDecimal((String) mtcReplList.get(i)[46]),
                    (String) mtcReplList.get(i)[47],
                    new BigDecimal((String) mtcReplList.get(i)[48]),
                    (String) mtcReplList.get(i)[49],
                    new BigDecimal((String) mtcReplList.get(i)[50]),
                    new BigDecimal((String) mtcReplList.get(i)[51]),
                    new BigDecimal((String) mtcReplList.get(i)[52]),
                    new BigDecimal((String) mtcReplList.get(i)[53]),
                    new BigDecimal((String) mtcReplList.get(i)[54]),
                    new BigDecimal((String) mtcReplList.get(i)[55]),
                    new BigDecimal((String) mtcReplList.get(i)[56]),
                    new BigDecimal((String) mtcReplList.get(i)[57]),
                    new BigDecimal((String) mtcReplList.get(i)[58]),
                    new BigDecimal((String) mtcReplList.get(i)[59]),
                    new BigDecimal((String) mtcReplList.get(i)[60]),
                    new BigDecimal((String) mtcReplList.get(i)[61]),
                    new BigDecimal((String) mtcReplList.get(i)[62]),
                    new BigDecimal((String) mtcReplList.get(i)[63]),
                    (Date) mtcReplList.get(i)[64],
                    (String) mtcReplList.get(i)[65],
                    (String) mtcReplList.get(i)[66],
                    (String) mtcReplList.get(i)[67],
                    (String) mtcReplList.get(i)[68],
                    (String) mtcReplList.get(i)[69],
                    (String) mtcReplList.get(i)[70],
                    (String) mtcReplList.get(i)[71],
                    (String) mtcReplList.get(i)[72],
                    (String) mtcReplList.get(i)[73],
                    (String) mtcReplList.get(i)[74],
                    (String) mtcReplList.get(i)[75],
                    (String) mtcReplList.get(i)[76],
                    (String) mtcReplList.get(i)[77],
                    (String) mtcReplList.get(i)[78]
            );
            list.add(response);
        }
        mav.addObject("mtcReplList", list);
        return mav;
    }


}