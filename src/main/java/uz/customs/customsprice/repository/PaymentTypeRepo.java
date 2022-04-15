package uz.customs.customsprice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.customs.customsprice.entity.InitialDecision.PaymenttypeEntity;

import java.util.List;


public interface PaymentTypeRepo extends JpaRepository<PaymenttypeEntity, String> {
}
