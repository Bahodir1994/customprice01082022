package uz.customs.customsprice.service.pdfGenerating;

import org.springframework.stereotype.Service;
import uz.customs.customsprice.entity.files.ForHtmlCancelled;
import uz.customs.customsprice.repository.ForHtmlCancelledRepo;

import java.util.Optional;

@Service
public class ForHtmlCancelledService {
    private final ForHtmlCancelledRepo forHtmlCancelledRepo;

    public ForHtmlCancelledService(ForHtmlCancelledRepo forHtmlCancelledRepo) {
        this.forHtmlCancelledRepo = forHtmlCancelledRepo;
    }

    public Optional<ForHtmlCancelled> getforHtmlById(String id) {
        return forHtmlCancelledRepo.findById(id);
    }

}
