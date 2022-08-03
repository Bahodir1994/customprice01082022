package uz.customs.customsprice.service.pdfGenerating;

import org.springframework.stereotype.Service;
import uz.customs.customsprice.entity.files.forHtml;
import uz.customs.customsprice.repository.forHtmlRepo;

import java.util.Optional;


@Service
public class forHtmlService {

    private final forHtmlRepo htmlRepo;

    public forHtmlService(forHtmlRepo htmlRepo) {
        this.htmlRepo = htmlRepo;
    }

    public Optional<forHtml> getforHtmlById(String id) {
        return htmlRepo.findById(id);
    }
}
