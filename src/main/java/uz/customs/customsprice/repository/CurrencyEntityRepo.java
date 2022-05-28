package uz.customs.customsprice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.customs.customsprice.entity.InitialDecision.CurrencyEntity;

public interface CurrencyEntityRepo extends JpaRepository<CurrencyEntity, String> {
    CurrencyEntity findByCodeAndLngaTpcd(String code, String lngaTpcd);
}
