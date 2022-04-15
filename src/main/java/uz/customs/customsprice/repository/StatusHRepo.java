package uz.customs.customsprice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.customs.customsprice.entity.InitialDecision.StatusH;

public interface StatusHRepo extends JpaRepository<StatusH, String> {
}
