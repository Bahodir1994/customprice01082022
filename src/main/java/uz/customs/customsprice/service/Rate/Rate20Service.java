package uz.customs.customsprice.service.Rate;

import org.springframework.stereotype.Service;
import uz.customs.customsprice.entity.Rate.Rate20;
import uz.customs.customsprice.repository.Rate.Rate20Repo;

@Service
public class Rate20Service {
    private final Rate20Repo rate20Repo;

    public Rate20Service(Rate20Repo rate20Repo) {
        this.rate20Repo = rate20Repo;
    }

    public Rate20 getdByTnved(String tnved) {
        return rate20Repo.findByTnvedAndFinishDateIsNull(tnved);
    }
}
