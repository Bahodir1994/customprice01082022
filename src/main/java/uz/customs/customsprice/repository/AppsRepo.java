package uz.customs.customsprice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import uz.customs.customsprice.entity.InitialDecision.Apps;

import java.util.Optional;


public interface AppsRepo extends JpaRepository<Apps, String> {
    Optional<Apps> findById(String id);

    Page<Apps> findByPersonPin(String personPin, Pageable pageable);

    String countByStatusAndLocationId(String status, String locationId);

}
