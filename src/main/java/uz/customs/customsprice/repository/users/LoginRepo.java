package uz.customs.customsprice.repository.users;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.customs.customsprice.entity.InitialDecision.Users;

public interface LoginRepo extends JpaRepository<Users, String> {
    Users findByLogin(String login);
}
