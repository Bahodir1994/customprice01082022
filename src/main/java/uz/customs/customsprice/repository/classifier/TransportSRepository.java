package uz.customs.customsprice.repository.classifier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.customs.customsprice.entity.classifier.TransportS;

import java.util.List;

public interface TransportSRepository extends JpaRepository<TransportS, String> {
    @Query("SELECT t FROM TransportS t WHERE" +
            "(t.code not in ('71', '72') ) and "+
            "(t.lngaTpcd = :lngaTpcd )")
    List<TransportS> findByLngaTpcd(@Param("lngaTpcd") String lngaTpcd);

    List<TransportS> findByCodeAndLngaTpcd(@Param("code") String code, @Param("lngaTpcd") String lngaTpcd);
}
