package uz.customs.customsprice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import uz.customs.customsprice.entity.InitialDecision.Commodity;
import uz.customs.customsprice.entity.InitialDecision.TransportType;
import java.util.Date;
import java.util.Optional;

@Repository
public interface TransportTypeRepo extends JpaRepository<TransportType, String> {
    TransportType findByAppId(String app_id);

    Page<TransportType> findByAppId(String appId, Pageable pageable);

    @Transactional
    void deleteAllByAppId(String appId);
}
