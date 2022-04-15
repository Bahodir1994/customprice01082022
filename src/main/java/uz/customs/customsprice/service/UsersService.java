package uz.customs.customsprice.service;

import org.springframework.stereotype.Service;
import uz.customs.customsprice.entity.InitialDecision.Roles;
import uz.customs.customsprice.entity.InitialDecision.Users;
import uz.customs.customsprice.repository.users.RolesRepo;
import uz.customs.customsprice.repository.users.UsersRepo;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    private final RolesRepo rolesRepo;
    private final UsersRepo usersRepo;

    public UsersService(RolesRepo rolesRepo, UsersRepo usersRepo) {
        this.rolesRepo = rolesRepo;
        this.usersRepo = usersRepo;
    }


    public Roles saveRoles(Roles roles) {
        return rolesRepo.save(roles);
    }

    public List<Users> getByLocationAndPostAndRole(String userLocation, String userPost, Integer userRole) {
        return usersRepo.findByLocationAndPostAndRole(userLocation, userPost, userRole);
    }

    public Optional<Users> getById(String id){
        return  usersRepo.findById(id);
    }
}

