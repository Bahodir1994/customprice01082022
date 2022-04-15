package uz.customs.customsprice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.customs.customsprice.entity.InitialDecision.Country;

public interface CountyRepo extends JpaRepository<Country, String> {
    Country findByCodeAndLngaTpcd(String code, String lngaTpcd);
}
