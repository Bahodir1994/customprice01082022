package uz.customs.customsprice.service;

import org.springframework.stereotype.Service;
import uz.customs.customsprice.entity.InitialDecision.Payment;
import uz.customs.customsprice.repository.PaymentRepo;

import java.util.List;

@Service
public class PaymentServise {
    private final PaymentRepo paymentRepo;

    public PaymentServise(PaymentRepo paymentRepo) {
        this.paymentRepo = paymentRepo;
    }

    public List<Payment> getByCmdtId(String cmdtId) {
        return paymentRepo.findByCmdtId(cmdtId);
    }

//    public List<Payment> getAllByCmdtId(String cmdtId) {
//        return paymentRepo.findAllByCmdtId(cmdtId);
//    }

    public Payment savePayment(Payment payment) {
        return paymentRepo.save(payment);
    }

}
