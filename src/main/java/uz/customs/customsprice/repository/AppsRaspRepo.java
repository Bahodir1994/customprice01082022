package uz.customs.customsprice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.customs.customsprice.entity.InitialDecision.AppsRasp;

import java.util.Optional;

public interface AppsRaspRepo extends JpaRepository<AppsRasp, String> {
    AppsRasp findByAppIdAndInspectorId(String appId, String inspectorId);

    Optional<Object> findByAppId(String appId);
}
