package uz.customs.customsprice.service;

import org.springframework.stereotype.Service;
import uz.customs.customsprice.entity.files.DecisionPdf;
import uz.customs.customsprice.repository.DecisionPdfRepo;

import java.util.Optional;

@Service
public class DecisionPdfService {
    private final DecisionPdfRepo decisionPdfRepo;

    public DecisionPdfService(DecisionPdfRepo decisionPdfRepo) {
        this.decisionPdfRepo = decisionPdfRepo;
    }

    public Optional<DecisionPdf> getById(String id) {
        return decisionPdfRepo.findById(id);
    }

    public DecisionPdf getByCmdtId(String cmdtId) {
        return decisionPdfRepo.findByCmdtId(cmdtId);
    }

    public DecisionPdf getByHash256(String hash256) {
        return decisionPdfRepo.findByHash256(hash256);
    }

    public DecisionPdf saveDecisionPdf(DecisionPdf decisionPdf) {
        return decisionPdfRepo.save(decisionPdf);
    }

}
