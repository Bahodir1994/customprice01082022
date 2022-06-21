package uz.customs.customsprice.controllers.api.apps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.customs.customsprice.entity.InitialDecision.*;
import uz.customs.customsprice.entity.earxiv.Earxiv;
import uz.customs.customsprice.repository.*;
import uz.customs.customsprice.service.AppsService;

import java.util.*;

@RestController
@RequestMapping("/api")
public class OutProgram {

    @Autowired
    AppsRepo appsRepo;

    @Autowired
    CommodityRepo commodityRepo;

    @Autowired
    TransportTypeRepo transportTypeRepo;

    @Autowired
    EarxivRepo earxivRepo;

    @Autowired
    StatusHRepo statusHRepo;

    @Autowired
    PersonsRepo personsRepo;

    @Autowired
    LocationRepo locationRepo;

    @Autowired
    RollBackAppRepo rollBackAppRepo;

    @Autowired
    AppsService appsService;

    /************************(PersonId бўйча App ларни беради)****************************/
    @GetMapping("/tutorials/published")
    public ResponseEntity<Map<String, Object>> findByPersonIdToApp(
            @RequestParam(required = false) String personPin,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "50") int size
    ) {
        try {
            List<Apps> tutorials = new ArrayList<Apps>();
            Pageable paging = PageRequest.of(page, size);
            Map<String, Object> response = new HashMap<>();
            if (personPin.equals("31502891781221") || personPin.equals("31909943330055") || personPin.equals("31103927250012") || personPin.equals("30303986590066")) {
                Page<Apps> pageTuts = appsRepo.findAll(paging);
                tutorials = pageTuts.getContent();
                response.put("appsList", tutorials);
                response.put("currentPage", pageTuts.getNumber());
                response.put("totalItems", pageTuts.getTotalElements());
                response.put("totalPages", pageTuts.getTotalPages());
            } else {
                Page<Apps> pageTuts = appsRepo.findByPersonPin(personPin, paging);
                tutorials = pageTuts.getContent();
                response.put("appsList", tutorials);
                response.put("currentPage", pageTuts.getNumber());
                response.put("totalItems", pageTuts.getTotalElements());
                response.put("totalPages", pageTuts.getTotalPages());
            }




            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /************************(AppId бўйча Commodity ларни беради)****************************/
    @GetMapping("/tutorials/commoditys")
    public ResponseEntity<Map<String, Object>> findByAppIdToCmdt(
            @RequestParam(required = false) String appId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "50") int size
    ) {
        try {
            List<Commodity> tutorials = new ArrayList<Commodity>();
            Pageable paging = PageRequest.of(page, size);

            Page<Commodity> pageTuts = commodityRepo.findByAppId(appId, paging);
            Optional<Apps> apps = appsRepo.findById(appId);

            tutorials = pageTuts.getContent();
            Map<String, Object> response = new HashMap<>();

            response.put("commodityList", tutorials);
            response.put("apps", apps);

            response.put("currentPage", pageTuts.getNumber());
            response.put("totalItems", pageTuts.getTotalElements());
            response.put("totalPages", pageTuts.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /************************(AppId бўйча TransportType ларни беради)****************************/
    @GetMapping("/tutorials/transporttype")
    public ResponseEntity<Map<String, Object>> findByAppIdToTransportType(
            @RequestParam(required = false) String appId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "50") int size
    ) {
        try {
            List<TransportType> tutorials = new ArrayList<TransportType>();
            Pageable paging = PageRequest.of(page, size);

            Page<TransportType> pageTuts = transportTypeRepo.findByAppId(appId, paging);
            tutorials = pageTuts.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("transportTypeList", tutorials);
            response.put("currentPage", pageTuts.getNumber());
            response.put("totalItems", pageTuts.getTotalElements());
            response.put("totalPages", pageTuts.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /************************(AppId бўйча Docs ларни беради)****************************/
    @GetMapping("/tutorials/earxivdocs")
    public ResponseEntity<Map<String, Object>> findByAppIdToDocsEarxiv(
            @RequestParam(required = false) String appId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "50") int size
    ) {
        try {
            List<Earxiv> tutorials = new ArrayList<Earxiv>();
            Pageable paging = PageRequest.of(page, size);

            Page<Earxiv> pageTuts = earxivRepo.findByAppId(appId, paging);
            tutorials = pageTuts.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("docsList", tutorials);
            response.put("currentPage", pageTuts.getNumber());
            response.put("totalItems", pageTuts.getTotalElements());
            response.put("totalPages", pageTuts.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /************************(AppId бўйча Aриза StatusHistory ларни беради)****************************/
    @GetMapping("/tutorials/historystatus")
    public ResponseEntity<Map<String, Object>> findByAppIdToAppByStatusHistory(
            @RequestParam(required = false) String appId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "50") int size
    ) {
        try {

            String sortBy = "insTime";
            String sortDir = "desc";

            Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                    Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();

            List<StatusH> tutorials = new ArrayList<StatusH>();
            Pageable paging = PageRequest.of(page, size, sort);

            Page<StatusH> pageTuts = statusHRepo.findByAppId(appId, paging);
            tutorials = pageTuts.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("statusAppHistoryList", tutorials);
            response.put("currentPage", pageTuts.getNumber());
            response.put("totalItems", pageTuts.getTotalElements());
            response.put("totalPages", pageTuts.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /************************(AppId бўйча Aриза StatusHistory ларни беради)****************************/
    @GetMapping("/tutorials/historyrollback")
    public ResponseEntity<Map<String, Object>> findByAppIdToAppByStatusHistoryRollBack(
            @RequestParam(required = false) String appId,
            @RequestParam(required = false) String statusHId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "50") int size
    ) {
        try {
            List<RollBackApp> tutorials = new ArrayList<>();
            Optional<Apps> apps = appsRepo.findById(appId);
            Pageable paging = PageRequest.of(page, size);
            Page<RollBackApp> pageTuts = rollBackAppRepo.findByAppIdAndStatusHId(appId, statusHId, paging);
            tutorials = pageTuts.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("rollBackAppList", tutorials);
            response.put("rollBackComment", apps.get().getComment());
            response.put("currentPage", pageTuts.getNumber());
            response.put("totalItems", pageTuts.getTotalElements());
            response.put("totalPages", pageTuts.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    /******************************************************************************************************************/
    @GetMapping("/custom/locations")
    public ResponseEntity<Map<String, Object>> findAllLocations(
    ) {
        try {

            List<Location> location = new ArrayList<>();
            location = locationRepo.findAll();

            Map<String, Object> response = new HashMap<>();
            response.put("locations", location);
            response.put("message", "succes");
            response.put("status", 200);

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /******************************************************************************************************************/
    @GetMapping("/custom/reestor")
    public ResponseEntity<Map<String, Object>> findByInDec() {
        try {
            Map<String, Object> response = new HashMap<>();
            response.put("inDecReestr", appsService.getInDecForApi());
            response.put("message", "succes");
            response.put("status", 200);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, Object> response = new HashMap<>();
            response.put("inDecReestr", "Маълумотлар топилмади");
            response.put("message", "error");
            response.put("status", 400);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}