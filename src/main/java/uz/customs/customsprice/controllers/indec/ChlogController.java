package uz.customs.customsprice.controllers.indec;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.customs.customsprice.entity.InitialDecision.Chlog;
import uz.customs.customsprice.service.ChlogService;

@Controller
@RequestMapping("/saveChlog")
public class ChlogController {
    private final ChlogService chlogService;

    public ChlogController(ChlogService chlogService) {
        this.chlogService = chlogService;
    }

    @PostMapping
    public ResponseEntity saveChlog(@RequestBody Chlog chlog) {
        try {
            chlogService.saveChlog(chlog);
            return ResponseEntity.ok(" <<-- CHLOG -->> маълумотлари сақланди ! ");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(" <<-- CHLOG -->> Маълумотлар сақлашда хатолик ! ");
        }

    }
}
