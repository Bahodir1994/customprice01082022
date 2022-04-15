package uz.customs.customsprice.repository.users;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.customs.customsprice.entity.InitialDecision.Users;

import java.util.List;
import java.util.Optional;

public interface UsersRepo extends JpaRepository<Users, String> {
    List<Users> findByLocationAndPostAndRole(String userLocation, String userPost, Integer userRole);
    Optional<Users> findById(String id);
}
