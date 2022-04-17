package uz.customs.customsprice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.customs.customsprice.entity.InitialDecision.Apps;
import uz.customs.customsprice.entity.InitialDecision.InDec;

import java.util.Date;

public interface InDecRepo extends JpaRepository<InDec, String> {
    InDec findByCmdtId(String cmdtId);

    Page<InDec> findByInDecLocationAndInDecDateBetween(String indecLocation, Date startDate, Date endDate, Pageable pageable);

}
