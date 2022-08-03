package uz.customs.customsprice.service.apps;

import org.springframework.stereotype.Service;
import uz.customs.customsprice.entity.InitialDecision.AppsRasp;
import uz.customs.customsprice.repository.AppsRaspRepo;

import java.util.List;

@Service
public class AppsRaspService {
    private final AppsRaspRepo appsRaspRepo;

    public AppsRaspService(AppsRaspRepo appsRaspRepo) {
        this.appsRaspRepo = appsRaspRepo;
    }

    public AppsRasp saveRasp(AppsRasp appsRasp){
        return appsRaspRepo.save(appsRasp);
    }

    public AppsRasp findByAppsId(String appId) {
        if (appsRaspRepo.findByAppId(appId).isPresent())
            return (AppsRasp) appsRaspRepo.findByAppId(appId).get();
        else return null;
    }

    public List<AppsRasp> findByInspectorId(String inspectorId) {
        if (appsRaspRepo.findByInspectorId(inspectorId) != null){
            return appsRaspRepo.findByInspectorId(inspectorId);
        }else return null;
    }
}