package uz.customs.customsprice.service.Rate;

import org.springframework.stereotype.Service;
import uz.customs.customsprice.entity.Rate.Rate20;
import uz.customs.customsprice.entity.Rate.Rate29;
import uz.customs.customsprice.repository.Rate.Rate20Repo;
import uz.customs.customsprice.repository.Rate.Rate29Repo;

@Service
public class Rate29Service {
    private final Rate29Repo rate29Repo;

    public Rate29Service(Rate29Repo rate29Repo) {
        this.rate29Repo = rate29Repo;
    }

    public Rate29 getdByTnved(String tnved) {
        return rate29Repo.findByTnved(tnved);
    }
}
