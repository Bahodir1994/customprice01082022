package uz.customs.customsprice.service;


import org.springframework.stereotype.Service;
import uz.customs.customsprice.entity.InitialDecision.RollbackSp;
import uz.customs.customsprice.repository.RollBackSpRepo;

import java.util.List;


@Service
public class RollbackSpService {
    private final RollBackSpRepo rollBackSpRepo;

    public RollbackSpService(RollBackSpRepo rollBackSpRepo) {
        this.rollBackSpRepo = rollBackSpRepo;
    }

    public RollbackSp saveRollback(RollbackSp rollbackSp){
        return rollBackSpRepo.save(rollbackSp);
    }

    public List<RollbackSp> getlistRollbackSp() {
        return rollBackSpRepo.findAll();
    }
}
