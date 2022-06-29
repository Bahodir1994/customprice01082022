package uz.customs.customsprice.repository.Tpo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.customs.customsprice.entity.InitialDecision.TPO.Pay;
import uz.customs.customsprice.entity.classifier.TransportS;

import java.util.List;

public interface PayRepository extends JpaRepository<Pay, String> {
    Pay findByIdTpoAndG19Type(String idTpo, String g19Type);

    @Query("SELECT p FROM Pay p WHERE" +
            "(p.idTpo = :idTpo ) and "+
            "(p.g19Type in ('50', '51') )")
    Pay findByIdTpo(@Param("idTpo") String idTpo);
}
