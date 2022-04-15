package uz.customs.customsprice.service;

import org.springframework.stereotype.Service;
import uz.customs.customsprice.entity.InitialDecision.Location;
import uz.customs.customsprice.entity.InitialDecision.Roles;
import uz.customs.customsprice.repository.users.RolesRepo;

import java.util.Optional;

@Service
public class RolesService {
    private final RolesRepo rolesRepo;

    public RolesService(RolesRepo rolesRepo) {
        this.rolesRepo = rolesRepo;
    }

    public Roles saveRoles(Roles roles) {
        return rolesRepo.save(roles);
    }

    public Roles getById(Integer id) {
        if (rolesRepo.findById(id).isPresent())
            return rolesRepo.findById(id).get();
        else return null;
    }
}
