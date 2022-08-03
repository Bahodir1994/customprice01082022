package uz.customs.customsprice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.customs.customsprice.entity.InitialDecision.RollbackSp;

import java.util.List;
import java.util.Optional;

public interface RollBackSpRepo extends JpaRepository<RollbackSp, String> {
    Iterable<RollbackSp> findAllByOrderByInsTimeDesc();

    List<RollbackSp> findByIdIn(List<String> id);

    Optional<RollbackSp> findById(String id);
}
