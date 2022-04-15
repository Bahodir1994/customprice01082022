package uz.customs.customsprice.service.serviceImpl;

import org.springframework.stereotype.Service;
import uz.customs.customsprice.service.CostMonitoringService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class CostMonitoringServiceImpl implements CostMonitoringService {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List getCostMonitoring(String id) {
        String queryForList = "select\n" +
                "    p.*\n" +
                "from\n" +
                "    CP.COUNTRY p\n" +
                "order by\n" +
                "    p.id";
        return entityManager.createNativeQuery(queryForList).getResultList();
    }

    @Override
    public List getInitialDecision(String status) {
        String queryForList = "SELECT\n" +
                "    a.*\n" +
                "FROM\n" +
                "    BQDQ.APPLICATIONS a\n" +
                "LEFT JOIN\n" +
                "    BQDQ.PERSONS p\n" +
                "ON\n" +
                "    a.PERSON_ID = p.ID";
        return entityManager.createNativeQuery(queryForList).getResultList();
    }

    @Override
    public List getInitialDecisionView(int app_id) {
        String queryForList = "SELECT\n" +
                "    a.*\n" +
                "FROM\n" +
                "    BQDQ.APPLICATIONS a\n" +
                "LEFT JOIN\n" +
                "    BQDQ.PERSONS p\n" +
                "ON\n" +
                "    a.PERSON_ID = p.ID" +
                " where a.id = " + app_id;
        return entityManager.createNativeQuery(queryForList).getResultList();
    }
}
