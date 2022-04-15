package uz.customs.customsprice.service;

import org.springframework.stereotype.Service;
import uz.customs.customsprice.entity.InitialDecision.StatusH;
import uz.customs.customsprice.repository.StatusHRepo;

@Service
public class StatusHService {
    private final StatusHRepo statusHRepo;

    public StatusHService(StatusHRepo statusHRepo) {
        this.statusHRepo = statusHRepo;
    }

    public StatusH saveStatusH(StatusH statusH) {
        return statusHRepo.save(statusH);
    }
}
