package uz.customs.customsprice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.customs.customsprice.entity.InitialDecision.Terms;

import java.util.List;
import java.util.Optional;

public interface TermsRepo extends JpaRepository<Terms, String> {
    Optional<Terms> findByRaqamAndLngaTpcd(String raqam, String lngaTpcd);

    List<Terms> findAllByLngaTpcdOrderByRaqamAsc(String lngaTpcd);
}
