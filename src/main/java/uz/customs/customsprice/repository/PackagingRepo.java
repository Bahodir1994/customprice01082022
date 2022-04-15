package uz.customs.customsprice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.customs.customsprice.entity.InitialDecision.Packaging;

public interface PackagingRepo extends JpaRepository<Packaging, String> {
    Packaging findByCodeAndLngaTpcd(String code, String lngaTpcd);
}
