package uz.customs.customsprice.repository.ExchangeRate;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.customs.customsprice.entity.InitialDecision.Exchangerate;

import java.util.Date;

public interface ExchangeRateRepo extends JpaRepository<Exchangerate, String> {
    Exchangerate findTop1ByIdOrderByDateSetDesc(String id);
}
