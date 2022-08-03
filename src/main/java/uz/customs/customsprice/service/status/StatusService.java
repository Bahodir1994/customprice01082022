package uz.customs.customsprice.service.status;

import org.springframework.stereotype.Service;
import uz.customs.customsprice.entity.InitialDecision.Status;
import uz.customs.customsprice.repository.StatusRepo;

import java.util.List;

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


    public List<Status> findByIdIn(List<Integer> id) {
        if (statusRepo.findByIdIn(id) != null)
            return statusRepo.findByIdIn(id);
        else return null;
    }

}
