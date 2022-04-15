package uz.customs.customsprice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.customs.customsprice.entity.InitialDecision.TransportType;
import java.util.Date;
import java.util.Optional;

public interface TransportTypeRepo extends JpaRepository<TransportType, String> {
    TransportType findByAppId(String app_id);
}
