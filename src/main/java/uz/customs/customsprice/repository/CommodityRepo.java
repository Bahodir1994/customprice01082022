package uz.customs.customsprice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.customs.customsprice.entity.InitialDecision.Commodity;

import java.util.Optional;


public interface CommodityRepo extends JpaRepository<Commodity, String> {
    Optional<Commodity> findById(String id);
    Commodity findAllByAppId(String appId);
}
