package uz.customs.customsprice.controllers.indec;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.customs.customsprice.entity.InitialDecision.Roles;
import uz.customs.customsprice.service.RolesService;

@Controller
@RequestMapping("/roles")
public class RolesController {
    private final RolesService rolesService;

    public RolesController(RolesService rolesService) {
        this.rolesService = rolesService;
    }

    @PostMapping
    public ResponseEntity valuesave(@RequestBody Roles roles) {
        try {
            rolesService.saveRoles(roles);
            return ResponseEntity.ok(" <<--- Roles --->> ок ! ");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(" <<--- Roles --->> хатолик юз берди ! ");
        }
    }
}
