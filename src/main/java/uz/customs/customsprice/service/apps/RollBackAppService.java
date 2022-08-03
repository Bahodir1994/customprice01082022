package uz.customs.customsprice.service.apps;

import org.springframework.stereotype.Service;
import uz.customs.customsprice.entity.InitialDecision.RollBackApp;
import uz.customs.customsprice.repository.RollBackAppRepo;

import java.util.List;


@Service
public class RollBackAppService {
    private final RollBackAppRepo rollBackAppRepo;

    public RollBackAppService(RollBackAppRepo rollBackAppRepo) {
        this.rollBackAppRepo = rollBackAppRepo;
    }

    public RollBackApp saveRollBack(RollBackApp rollBackApp){
        return rollBackAppRepo.save(rollBackApp);
    }

    public List<RollBackApp> getByStatusHId(String stId) {
        if (rollBackAppRepo.findByStatusHId(stId) != null){
            return rollBackAppRepo.findByStatusHId(stId);
        }else return null;
    }
}
