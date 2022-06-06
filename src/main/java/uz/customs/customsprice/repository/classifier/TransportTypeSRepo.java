package uz.customs.customsprice.repository.classifier;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.customs.customsprice.entity.classifier.TransportTypeS;

public interface TransportTypeSRepo extends JpaRepository<TransportTypeS, String> {
    TransportTypeS findByCodeAndLngaTpcd(String app_id, String lngaTpcd);
}
