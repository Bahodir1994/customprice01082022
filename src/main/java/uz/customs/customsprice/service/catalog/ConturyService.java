package uz.customs.customsprice.service.catalog;

import org.springframework.stereotype.Service;
import uz.customs.customsprice.entity.InitialDecision.Country;
import uz.customs.customsprice.repository.CountyRepo;

import java.util.List;

@Service
public class ConturyService {
    private final CountyRepo countyRepo;

    public ConturyService(CountyRepo countyRepo) {
        this.countyRepo = countyRepo;
    }

    public Country getByCodeAndLngaTpcd(String code, String lngaTpcd) {
        return countyRepo.findByCodeAndLngaTpcd(code, lngaTpcd);
    }

    public Country getByLngaTpcd(String lngaTpcd) {
        return countyRepo.findByLngaTpcd(lngaTpcd);
    }

    public List<Country> getAllByLngaTpcd(String lngaTpcd) {
        if (countyRepo.findAllByLngaTpcdOrderByCodeAsc(lngaTpcd) != null) {
            return countyRepo.findAllByLngaTpcdOrderByCodeAsc(lngaTpcd);
        } else return null;
    }
}
