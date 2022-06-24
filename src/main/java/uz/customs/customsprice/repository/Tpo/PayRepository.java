package uz.customs.customsprice.repository.Tpo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.customs.customsprice.entity.InitialDecision.TPO.Pay;

public interface PayRepository extends JpaRepository<Pay, String> {
    Pay findByIdTpoAndG19Type(String idTpo, String g19Type);
}
