package uz.customs.customsprice.controllers.api.apps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.customs.customsprice.entity.InitialDecision.Apps;
import uz.customs.customsprice.entity.InitialDecision.Commodity;
import uz.customs.customsprice.repository.AppsRepo;
import uz.customs.customsprice.repository.CommodityRepo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class OutProgram {

    @Autowired
    AppsRepo appsRepo;

    @Autowired
    CommodityRepo commodityRepo;

//    @GetMapping("/tutorials")
//    public ResponseEntity<Map<String, Object>> getAllTutorials(
//            @RequestParam(required = false) String personId,
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "3") int size
//    ) {
//        try {
//            List<Apps> tutorials = new ArrayList<Apps>();
//            Pageable paging = PageRequest.of(page, size);
//
//            Page<Apps> pageTuts;
//            if (personId == null)
//                pageTuts = appsRepo.findAll(paging);
//            else
//                pageTuts = appsRepo.findByPersonId(personId, paging);
//            tutorials = pageTuts.getContent();
//            Map<String, Object> response = new HashMap<>();
//            response.put("tutorials", tutorials);
//            response.put("currentPage", pageTuts.getNumber());
//            response.put("totalItems", pageTuts.getTotalElements());
//            response.put("totalPages", pageTuts.getTotalPages());
//            return new ResponseEntity<>(response, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @GetMapping("/tutorials/published")
    public ResponseEntity<Map<String, Object>> findByPublished(
            @RequestParam(required = false) String personId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        try {
            List<Apps> tutorials = new ArrayList<Apps>();
            Pageable paging = PageRequest.of(page, size);

            Page<Apps> pageTuts = appsRepo.findByPersonId(personId, paging);
            tutorials = pageTuts.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("tutorials", tutorials);
            response.put("currentPage", pageTuts.getNumber());
            response.put("totalItems", pageTuts.getTotalElements());
            response.put("totalPages", pageTuts.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/tutorials/commoditys")
    public ResponseEntity<Map<String, Object>> findByPublishedCmdt(
            @RequestParam(required = false) String appId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        try {
            List<Commodity> tutorials = new ArrayList<Commodity>();
            Pageable paging = PageRequest.of(page, size);

            Page<Commodity> pageTuts = commodityRepo.findByAppId(appId, paging);
            tutorials = pageTuts.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("tutorials", tutorials);
            response.put("currentPage", pageTuts.getNumber());
            response.put("totalItems", pageTuts.getTotalElements());
            response.put("totalPages", pageTuts.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}