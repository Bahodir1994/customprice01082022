package uz.customs.customsprice.service.Rate;

import org.springframework.stereotype.Service;
import uz.customs.customsprice.entity.Rate.Rate27New;
import uz.customs.customsprice.repository.Rate.Rate27NewRepo;

@Service
public class Rate27NewService {
    private final Rate27NewRepo rate27NewRepo;

    public Rate27NewService(Rate27NewRepo rate27NewRepo) {
        this.rate27NewRepo = rate27NewRepo;
    }

    public Rate27New getdByTnved(String tnved) {
        return rate27NewRepo.findByTnved(tnved);
    }
}
