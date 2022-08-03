package uz.customs.customsprice.service.status;

import org.springframework.stereotype.Service;
import uz.customs.customsprice.entity.InitialDecision.StatusH;
import uz.customs.customsprice.repository.StatusHRepo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
public class StatusHService {
    private final StatusHRepo statusHRepo;

    @PersistenceContext
    private EntityManager entityManager;

    public StatusHService(StatusHRepo statusHRepo) {
        this.statusHRepo = statusHRepo;
    }

    public StatusH saveStatusH(StatusH statusH) {
        return statusHRepo.save(statusH);
    }

    public List<StatusH> getByAppId(String appId) {
        if (statusHRepo.findByAppId(appId) != null)
        {return statusHRepo.findByAppId(appId);}
        else return null;
    }

    public List<StatusH> sfsdgtbgjk(String appIdForHistory) {
        String query = "select" +
                " sh.id," +
                " sh.status_comment," +
                " sh.instime," +
                " sh.sorted_ins_id," +
                " sh.sorted_ins_nm," +
                " sh.app_id," +
                " per.fullname," +
                " sh.comment," +
                " sh.status" +
                " from cpid.STATUS_H sh" +
                " left join cpid.USER_E per on per.USERID = sh.INSUSER" +
                " left join cpid.APPS aps on aps.ID = sh.APP_ID" +
                " where" +
                "  sh.APP_ID = '"+appIdForHistory+"'";
        return entityManager.createNativeQuery(query).getResultList();
    }

    public List<StatusH> getAllByIdAndAppId(String status, String appId) {
        return statusHRepo.findByStatusAndAppId(status, appId);
    }

    public StatusH getTop1ByAppIdAndStatus(String appId, String status) {
        return statusHRepo.findTop1ByAppIdAndStatusOrderByInsTimeDesc(appId, status);
    }

    public Optional<StatusH> getById(String stId) {
        return statusHRepo.findById(stId);
    }
}
