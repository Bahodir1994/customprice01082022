package uz.customs.customsprice.service;

import org.springframework.stereotype.Service;
import uz.customs.customsprice.entity.InitialDecision.Chlog;
import uz.customs.customsprice.repository.ChlogRepo;

@Service
public class ChlogService {
    private final ChlogRepo chlogRepo;

    public ChlogService(ChlogRepo chlogRepo) {
        this.chlogRepo = chlogRepo;
    }

    public Chlog saveChlog(Chlog chlog) {
        return chlogRepo.save(chlog);
    }
}
