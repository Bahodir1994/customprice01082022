package uz.customs.customsprice.service;

import org.springframework.stereotype.Service;
import uz.customs.customsprice.entity.InitialDecision.StatusM;
import uz.customs.customsprice.repository.StatusMRepo;

@Service
public class StatusMService {
    private final StatusMRepo statusMRepo;

    public StatusMService(StatusMRepo statusMRepo) {
        this.statusMRepo = statusMRepo;
    }

    public StatusM saveStatusM(StatusM statusM) {
        return statusMRepo.save(statusM);
    }
}
