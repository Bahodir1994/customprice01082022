package uz.customs.customsprice.service.pdfGenerating;

import org.springframework.stereotype.Service;
import uz.customs.customsprice.entity.files.DecisionPdfRollback;
import uz.customs.customsprice.repository.DecisionPdfRollbackRepo;

import java.util.Optional;

@Service
public class DecisionPdfRollbackService {

    private final DecisionPdfRollbackRepo decisionPdfRollbackRepo;

    public DecisionPdfRollbackService(DecisionPdfRollbackRepo decisionPdfRollbackRepo) {
        this.decisionPdfRollbackRepo = decisionPdfRollbackRepo;
    }


    public Optional<DecisionPdfRollback> getById(String id) {
        return decisionPdfRollbackRepo.findById(id);
    }

    public DecisionPdfRollback getByAppId(String appId) {
        return decisionPdfRollbackRepo.findByAppId(appId);
    }

    public DecisionPdfRollback getByHash256(String hash256) {
        return decisionPdfRollbackRepo.findByHash256(hash256);
    }

    public void saveDecisionPdf(DecisionPdfRollback decisionPdfRollback) {
        decisionPdfRollbackRepo.save(decisionPdfRollback);
    }

}
