package uz.customs.customsprice.service.payment;

import org.springframework.stereotype.Service;
import uz.customs.customsprice.entity.InitialDecision.PaymtypeEntity;
import uz.customs.customsprice.repository.PaymTypeRepo;
import uz.customs.customsprice.repository.PaymentRepo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class PaymTypeService {
    private final PaymTypeRepo paymTypeRepo;
    private final PaymentRepo paymentRepo;

    public PaymTypeService(PaymTypeRepo paymTypeRepo, PaymentRepo paymentRepo) {
        this.paymTypeRepo = paymTypeRepo;
        this.paymentRepo = paymentRepo;
    }

    @PersistenceContext
    private EntityManager entityManager;

    public List<PaymtypeEntity> getListPaymType() {
        return paymTypeRepo.findAll();
    }
}
