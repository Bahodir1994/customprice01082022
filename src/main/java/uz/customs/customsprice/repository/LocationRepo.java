package uz.customs.customsprice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.customs.customsprice.entity.InitialDecision.Location;

import java.util.List;
import java.util.Optional;

public interface LocationRepo extends JpaRepository<Location, String> {
    Optional<Location> findById(String id);

    List<Location> findAllByIdIsNot(String id);
}
