package uz.customs.customsprice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.customs.customsprice.entity.InitialDecision.RollbackSp;

public interface RollBackSpRepo extends JpaRepository<RollbackSp, String> {
    Iterable<RollbackSp> findAllByOrderByInsTimeDesc();
}
