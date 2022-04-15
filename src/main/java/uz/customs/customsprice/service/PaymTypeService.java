package uz.customs.customsprice.service;

import org.springframework.stereotype.Service;
import uz.customs.customsprice.entity.InitialDecision.PaymenttypeEntity;
import uz.customs.customsprice.entity.InitialDecision.PaymtypeEntity;
import uz.customs.customsprice.repository.PaymTypeRepo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class PaymTypeService {
    private final PaymTypeRepo paymTypeRepo;

    public PaymTypeService(PaymTypeRepo paymTypeRepo) {
        this.paymTypeRepo = paymTypeRepo;
    }

    @PersistenceContext
    private EntityManager entityManager;

    public List<PaymtypeEntity> getListPaymType() {
        return paymTypeRepo.findAll();
    }
}
