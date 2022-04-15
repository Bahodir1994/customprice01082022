package uz.customs.customsprice.service;

import org.springframework.stereotype.Service;
import uz.customs.customsprice.entity.InitialDecision.Method;
import uz.customs.customsprice.repository.MethodRepo;

@Service
public class MethodService {
    private final MethodRepo methodRepo;

    public MethodService(MethodRepo methodRepo) {
        this.methodRepo = methodRepo;
    }

    public Method getById(String id) {
        if (methodRepo.findById(id).isPresent())
            return methodRepo.findById(id).get();
        else return null;
    }
}
