package uz.customs.customsprice.controllers.indec;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.customs.customsprice.entity.InitialDecision.TransportType;
import uz.customs.customsprice.service.TransportTypeService;


@Controller
@RequestMapping("/transporttype")
public class TransportTypeController {
    private final TransportTypeService transportTypeService;

    public TransportTypeController(TransportTypeService transportTypeService) {
        this.transportTypeService = transportTypeService;
    }


    @PostMapping
    public ResponseEntity valuesave(@RequestBody TransportType transportType) {
        try {
            transportTypeService.savetrtype(transportType);
            return ResponseEntity.ok("TransportType маълумотлари сақланди");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(" <<--- TransportType --->> хатолик юз берди ! ");
        }

    }
}



