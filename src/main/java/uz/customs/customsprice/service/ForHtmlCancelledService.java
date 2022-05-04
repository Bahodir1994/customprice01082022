package uz.customs.customsprice.service;

import org.springframework.stereotype.Service;
import uz.customs.customsprice.entity.files.forHtmlCancelled;
import uz.customs.customsprice.repository.ForHtmlCancelledRepo;

import java.util.Optional;

@Service
public class ForHtmlCancelledService {
    private final ForHtmlCancelledRepo forHtmlCancelledRepo;

    public ForHtmlCancelledService(ForHtmlCancelledRepo forHtmlCancelledRepo) {
        this.forHtmlCancelledRepo = forHtmlCancelledRepo;
    }

    public Optional<forHtmlCancelled> getforHtmlById(String id) {
        return forHtmlCancelledRepo.findById(id);
    }

}
