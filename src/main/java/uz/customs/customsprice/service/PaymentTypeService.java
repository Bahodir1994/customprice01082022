package uz.customs.customsprice.service;

import org.springframework.stereotype.Service;
import uz.customs.customsprice.entity.InitialDecision.PaymenttypeEntity;
import uz.customs.customsprice.repository.PaymentTypeRepo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class PaymentTypeService {
    private final PaymentTypeRepo paymentTypeRepo;

    public PaymentTypeService(PaymentTypeRepo paymentTypeRepo) {
        this.paymentTypeRepo = paymentTypeRepo;
    }

    @PersistenceContext
    private EntityManager entityManager;

    public List<PaymenttypeEntity> getListPaymentType() {
       return paymentTypeRepo.findAll();
    }
}
