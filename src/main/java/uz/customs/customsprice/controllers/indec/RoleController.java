//package uz.customs.customsprice.controllers;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import uz.customs.customsprice.entity.InitialDecision.Role;
//import uz.customs.customsprice.service.RoleService;
//
//@Controller
//@RequestMapping("/role")
//public class RoleController {
//    private final RoleService roleService;
//
//    public RoleController(RoleService roleService) {
//        this.roleService = roleService;
//    }
//
//    @PostMapping
//    public ResponseEntity saveRole(@RequestBody Role role) {
//        try {
//            roleService.saveRole(role);
//            return ResponseEntity.ok(" <<-- ROLE -->> маълумотлари сақланди ! ");
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body(" <<-- ROLE -->> Маълумотлар сақлашда хатолик ! ");
//        }
//    }
//}
