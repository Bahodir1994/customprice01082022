package uz.customs.customsprice.service.apps;


import org.springframework.stereotype.Service;
import uz.customs.customsprice.entity.InitialDecision.RollbackSp;
import uz.customs.customsprice.repository.RollBackSpRepo;

import java.util.List;
import java.util.Optional;


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

    public List<RollbackSp> getlistRollbackSpFirstSecond(List<String> id) {
        return rollBackSpRepo.findByIdIn(id);
    }

    public Optional<RollbackSp> getById(String id) {
        if (rollBackSpRepo.findById(id).isPresent()){
            return rollBackSpRepo.findById(id);
        }else return Optional.empty();
    }
}
