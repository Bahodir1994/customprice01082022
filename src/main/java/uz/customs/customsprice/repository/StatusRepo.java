package uz.customs.customsprice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.customs.customsprice.entity.InitialDecision.Status;

import java.util.List;
import java.util.Optional;

public interface StatusRepo extends JpaRepository<Status, Integer> {
    Optional<Status> findById(Integer id);

    List<Status> findAll();
}
