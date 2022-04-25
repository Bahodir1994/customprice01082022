package uz.customs.customsprice.service.pcabinet;

import org.springframework.stereotype.Service;
import uz.customs.customsprice.entity.Digests.FreedocEntity;
import uz.customs.customsprice.entity.Digests.FreehashEntity;
import uz.customs.customsprice.repository.pcabinet.FreeDocRepo;

@Service
public class FreeDocService {
    private final FreeDocRepo freeDocRepo;

    public FreeDocService(FreeDocRepo freeDocRepo) {
        this.freeDocRepo = freeDocRepo;
    }

    public FreedocEntity getByDeclIdAndAndDocType(String declId, String docType) {
        return freeDocRepo.findByDeclIdAndAndDocType(declId, docType);
    }
}
