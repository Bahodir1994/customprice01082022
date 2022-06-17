package uz.customs.customsprice.controllers.CostMonitoring;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uz.customs.customsprice.entity.CostMonitoring.MtcReplEntity;
import uz.customs.customsprice.entity.InitialDecision.*;
import uz.customs.customsprice.entity.classifier.TransportS;
import uz.customs.customsprice.payload.PostResponse;
import uz.customs.customsprice.repository.CostMonitoring.MtcReplRepository;
import uz.customs.customsprice.repository.CountyRepo;
import uz.customs.customsprice.repository.LocationRepo;
import uz.customs.customsprice.repository.MethodRepo;
import uz.customs.customsprice.repository.TermsRepo;
import uz.customs.customsprice.repository.classifier.PostRepository;
import uz.customs.customsprice.repository.classifier.TransportSRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/costmonitoring")
public class MtcReplController {
    private final String JSP = "/resultCM";
    private final String COSTMONITORING_PAGE = "/resources/pages/CostMonitoring/MtcRepl/FiltrCM";
    private final String COSTMONITORING_POST = "/resources/pages/CostMonitoring/MtcRepl/FiltrCMPost";
    private final String MTC_REPL_RESULT_PAGE = "/resources/pages/CostMonitoring/MtcRepl/ResultCM";
    private final String DATA_PAGINATION = "/server_side/pagination";

    private final MtcReplRepository mtcReplRepository;

    @Autowired
    CountyRepo countyRepo;

    @Autowired
    LocationRepo locationRepo;

    @Autowired
    PostRepository postRepository;

    @Autowired
    MethodRepo methodRepo;

    @Autowired
    TransportSRepository transportSRepository;

    @Autowired
    TermsRepo termsRepo;

    public MtcReplController(MtcReplRepository mtcReplRepository) {
        this.mtcReplRepository = mtcReplRepository;
    }


    @PostMapping(value = COSTMONITORING_PAGE)
    @ResponseBody
    public ModelAndView FilterCM(HttpSession session) {
        ModelAndView mav = new ModelAndView("resources/pages/CostMonitoring/MtcRepl/FiltrCM");
        String lngaTpcd = "UZ";
        String code = "10,";
        List<Country> countryList = countyRepo.findAllByLngaTpcdOrderByCodeAsc(lngaTpcd);
        List<Terms> termsList = termsRepo.findAllByLngaTpcdOrderByRaqamAsc(lngaTpcd);
        List<Location> locationList = locationRepo.findAll();
        List<Method> methodList = methodRepo.findAll();
//        List<TransportTypeS> transportTypeSList = transportTypeSRepo.findAll();
        List<TransportS> transportSList = transportSRepository.findByLngaTpcd(lngaTpcd);
        mav.addObject("countryList", countryList);
        mav.addObject("locationList", locationList);
        mav.addObject("methodList", methodList);
        mav.addObject("transportSList", transportSList);
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


    @GetMapping(value = MTC_REPL_RESULT_PAGE)
    @ResponseBody
    public ModelAndView ResultIS(
            HttpSession session,
            HttpServletRequest request,
            @RequestParam(required = false) String locationId,
            @RequestParam(required = false) String g7a,
            @RequestParam(required = false) String gdvipdate1S,
            @RequestParam(required = false) String gdvipdate2S,
            @RequestParam(required = false) String g11,
            @RequestParam(required = false) String g15,
            @RequestParam(required = false) String g34,
            @RequestParam(required = false) String g33,
            @RequestParam(required = false) String g31name,
            @RequestParam(required = false) String g25,
            @RequestParam(required = false) String g8code2,
            @RequestParam(required = false) String metod_otc,
            @RequestParam(required = false) String g20b,
            @RequestParam(required = false) String g20name,
            @RequestParam(required = false) String g7c,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "0") int size
    ) {
        String userId = (String) request.getSession().getAttribute("userId");
        String userLocation = (String) request.getSession().getAttribute("userLocation");
        Integer userRole = (Integer) request.getSession().getAttribute("userRole");
        List<Location> location = locationRepo.findAll();
        ModelAndView viewModel = new ModelAndView("/resources/pages/CostMonitoring/MtcRepl/ResultCM");
        java.sql.Date gdvipdate1 = null;
        java.sql.Date gdvipdate2 = null;
        if (gdvipdate1S != null && gdvipdate1S.equals("")) {
            gdvipdate1 = java.sql.Date.valueOf(gdvipdate1S);
        }
        if (gdvipdate2S != null && gdvipdate2S.equals("")) {
            gdvipdate2 = java.sql.Date.valueOf(gdvipdate2S);
        }
        try {
            String lngaTpcd = "UZ";
//            List<Country> countryList = countyRepo.findAllByLngaTpcdOrderByCodeAsc(lngaTpcd);
//            List<DirectionType> directionType = directionTypeRepo.findAll();

            List<MtcReplEntity> tutorials = new ArrayList<>();
            Pageable paging = PageRequest.of(page, size);
            Page<MtcReplEntity> pageTuts =
                    mtcReplRepository.findAllByCmdtIdAndDeclId(
                            g7a,
                            gdvipdate1,
                            gdvipdate2,
                            g11,
                            g15,
                            g34,
                            g33,
                            g31name,
                            g25,
                            g8code2,
                            metod_otc,
                            g20b,
                            g20name,
                            g7c,
                            paging
                    );
            tutorials = pageTuts.getContent();
            viewModel.addObject("mtcReplList", tutorials);
            viewModel.addObject("currentPage", pageTuts.getNumber());
            viewModel.addObject("totalItems", pageTuts.getTotalElements());
            viewModel.addObject("totalPages", pageTuts.getTotalPages());
            viewModel.addObject("getPageSize", pageTuts.getSize());

            viewModel.addObject("locationDirectory", location);
            viewModel.addObject("userId", userId);
            viewModel.addObject("userLocation", userLocation);
            viewModel.addObject("userRole", userRole);

//            viewModel.addObject("countryList", countryList);
//            viewModel.addObject("directionType", directionType);
            viewModel.addObject("location", location);


        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return viewModel;

    }

}
