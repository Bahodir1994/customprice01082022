package uz.customs.customsprice.service;

import org.springframework.stereotype.Service;
import uz.customs.customsprice.entity.InitialDecision.Status;
import uz.customs.customsprice.repository.StatusRepo;

@Service
public class StatusService {
    private final StatusRepo statusRepo;

    public StatusService(StatusRepo statusRepo) {
        this.statusRepo = statusRepo;
    }

    public Status getById(Integer id) {
        if (statusRepo.findById(id).isPresent())
            return statusRepo.findById(id).get();
        else return null;
    }

}
