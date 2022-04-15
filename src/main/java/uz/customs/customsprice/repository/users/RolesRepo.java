package uz.customs.customsprice.repository.users;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.customs.customsprice.entity.InitialDecision.Roles;

import java.util.Optional;

public interface RolesRepo extends JpaRepository<Roles, Integer> {
    Optional<Roles> findById(Integer id);

}
