package uz.customs.customsprice.service.earxiv;

import org.springframework.stereotype.Service;
import uz.customs.customsprice.entity.earxiv.Earxiv;
import uz.customs.customsprice.repository.EarxivRepo;

import java.util.List;

@Service
public class EarxivServiceFrom {
    private final EarxivRepo earxivRepo;

    public EarxivServiceFrom(EarxivRepo earxivRepo) {
        this.earxivRepo = earxivRepo;
    }

    public List<Earxiv> getAllByAppIdForPdf2(String appId){
        return earxivRepo.findByAppId(appId);
    }
}
