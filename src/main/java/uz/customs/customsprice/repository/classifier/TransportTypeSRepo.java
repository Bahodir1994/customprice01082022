package uz.customs.customsprice.repository.classifier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.customs.customsprice.entity.classifier.TransportTypeS;

import java.sql.Date;
import java.util.List;

public interface TransportTypeSRepo extends JpaRepository<TransportTypeS, String> {
//    @Query("SELECT t FROM TransportTypeS t WHERE" +
//            "(t.code in (:code) ) and "+
//            "(t.lngaTpcd = :lngaTpcd )")
//    List<TransportTypeS> findByCodeAndLngaTpcd(@Param("code") String code, @Param("lngaTpcd") String lngaTpcd);

    TransportTypeS findByCodeAndLngaTpcd(String app_id, String lngaTpcd);

    //    TransportTypeS findByCodeAndLngaTpcd(String app_id, String lngaTpcd);
}
