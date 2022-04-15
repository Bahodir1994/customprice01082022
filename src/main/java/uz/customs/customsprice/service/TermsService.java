package uz.customs.customsprice.service;

import org.springframework.stereotype.Service;
import uz.customs.customsprice.entity.InitialDecision.Terms;
import uz.customs.customsprice.repository.TermsRepo;

@Service
public class TermsService {
    private final TermsRepo termsRepo;

    public TermsService(TermsRepo termsRepo) {
        this.termsRepo = termsRepo;
    }

    public Terms findByIdAndLngaTpcd(String raqam, String lngaTpcd) {
        if (termsRepo.findByRaqamAndLngaTpcd(raqam, lngaTpcd).isPresent())
            return termsRepo.findByRaqamAndLngaTpcd(raqam, lngaTpcd).get();
        else return null;
    }
}
