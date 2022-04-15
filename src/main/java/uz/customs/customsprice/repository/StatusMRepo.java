package uz.customs.customsprice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.customs.customsprice.entity.InitialDecision.StatusM;

public interface StatusMRepo extends JpaRepository<StatusM, String> {
}
