package uz.customs.customsprice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.customs.customsprice.entity.files.DecisionPdfRollback;

import javax.transaction.Transactional;
import java.util.Optional;

public interface DecisionPdfRollbackRepo extends JpaRepository<DecisionPdfRollback, String> {
    Optional<DecisionPdfRollback> findById(String id);

    DecisionPdfRollback findByHash256(String hash256);

    DecisionPdfRollback findByAppId(String appId);

    @Transactional
    void deleteDecisionPdfById(String id);
}
