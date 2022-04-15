package uz.customs.customsprice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.customs.customsprice.entity.InitialDecision.Payment;

import java.util.List;

public interface PaymentRepo extends JpaRepository<Payment, String> {
    List<Payment> findByCmdtId(String cmdtId);

    List<Payment> findAllByCmdtId(String cmdtId);
}
