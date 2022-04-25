package uz.customs.customsprice.service.pcabinet;

import org.springframework.stereotype.Service;
import uz.customs.customsprice.entity.Digests.FreehashEntity;
import uz.customs.customsprice.entity.InitialDecision.Commodity;
import uz.customs.customsprice.repository.pcabinet.FreeHashRepo;

@Service
public class FreeHashService {
    private final FreeHashRepo freeHashRepo;

    public FreeHashService(FreeHashRepo freeHashRepo) {
        this.freeHashRepo = freeHashRepo;
    }

    public FreehashEntity getByHash(String hash) {
        if (freeHashRepo.findByHash(hash) != null)
            return freeHashRepo.findByHash(hash);
        else return null;
    }
}
