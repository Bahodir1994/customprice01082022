package uz.customs.customsprice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import uz.customs.customsprice.entity.InitialDecision.RollBackApp;

import java.util.List;

public interface RollBackAppRepo extends JpaRepository<RollBackApp, String> {
//    RollBackApp getByAppId(String appId);
    List<RollBackApp> getByAppId(String appId);
}
