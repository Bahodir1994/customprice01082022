package uz.customs.customsprice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.customs.customsprice.entity.InitialDecision.Apps;

import java.util.Optional;


public interface AppsRepo extends JpaRepository<Apps, String> {
    Optional<Apps> findById(String id);

    @Query(value = "SELECT distinct a FROM Apps a LEFT JOIN Commodity c ON a.id = c.appId" +
            " where c.appId is not null and a.personPin = :personPin")
    Page<Apps> findByPersonPin(String personPin, Pageable pageable);

    String countByStatusAndLocationId(String status, String locationId);

}
