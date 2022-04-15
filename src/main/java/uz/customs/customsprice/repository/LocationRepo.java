package uz.customs.customsprice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.customs.customsprice.entity.InitialDecision.Location;

import java.util.Optional;

public interface LocationRepo extends JpaRepository<Location, String> {
    Optional<Location> findById(String id);
}
