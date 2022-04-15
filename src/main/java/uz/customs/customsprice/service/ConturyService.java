package uz.customs.customsprice.service;

import org.springframework.stereotype.Service;
import uz.customs.customsprice.entity.InitialDecision.Country;
import uz.customs.customsprice.repository.CountyRepo;

@Service
public class ConturyService {
    private final CountyRepo countyRepo;

    public ConturyService(CountyRepo countyRepo) {
        this.countyRepo = countyRepo;
    }

    public Country getByCodeAndLngaTpcd(String code, String lngaTpcd) {
        return countyRepo.findByCodeAndLngaTpcd(code, lngaTpcd);
    }
}
