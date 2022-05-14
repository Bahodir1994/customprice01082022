package uz.customs.customsprice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.customs.customsprice.entity.InitialDecision.Country;

import java.util.List;

public interface CountyRepo extends JpaRepository<Country, String> {
    Country findByCodeAndLngaTpcd(String code, String lngaTpcd);

    Country findByLngaTpcd(String lngaTpcd);

    List<Country> findAllByLngaTpcdOrderByCodeAsc(String lngaTpcd);
}
