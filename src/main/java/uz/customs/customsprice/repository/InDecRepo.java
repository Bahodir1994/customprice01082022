package uz.customs.customsprice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.customs.customsprice.entity.InitialDecision.InDec;

public interface InDecRepo extends JpaRepository<InDec, String> {
    InDec findByCmdtId(String cmdtId);

}
