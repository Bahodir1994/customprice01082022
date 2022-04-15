package uz.customs.customsprice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.customs.customsprice.entity.InitialDecision.PaymtypeEntity;

import java.util.List;

public interface PaymTypeRepo extends JpaRepository<PaymtypeEntity, String> {
}
