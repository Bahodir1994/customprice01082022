package uz.customs.customsprice.service;

import org.springframework.stereotype.Service;
import uz.customs.customsprice.entity.InitialDecision.RollBackApp;
import uz.customs.customsprice.repository.RollBackAppRepo;


@Service
public class RollBackAppService {
    private final RollBackAppRepo rollBackAppRepo;

    public RollBackAppService(RollBackAppRepo rollBackAppRepo) {
        this.rollBackAppRepo = rollBackAppRepo;
    }

    public RollBackApp saveRollBack(RollBackApp rollBackApp){
        return rollBackAppRepo.save(rollBackApp);
    }
}
