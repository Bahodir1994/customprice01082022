package uz.customs.customsprice.service.InternationalSurveyS;

import org.springframework.stereotype.Service;
import uz.customs.customsprice.entity.InitialDecision.Commodity;
import uz.customs.customsprice.entity.InternationalSurveyEntity.InternationalSurveyEntity;
import uz.customs.customsprice.repository.InternationalSurveyRepo.InternationalSurveyRepo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Date;
import java.util.List;

@Service
public class InternationalSurveyService {
    private final InternationalSurveyRepo internationalSurveyRepo;

    @PersistenceContext
    private EntityManager entityManager;

    public InternationalSurveyService(InternationalSurveyRepo internationalSurveyRepo) {
        this.internationalSurveyRepo = internationalSurveyRepo;
    }

    public InternationalSurveyEntity savingValue(InternationalSurveyEntity internationalSurveyEntity) {
        return internationalSurveyRepo.save(internationalSurveyEntity);
    }

    public InternationalSurveyEntity getById(String id) {
        if (internationalSurveyRepo.findById(id).isPresent()) {
            return internationalSurveyRepo.findById(id).get();
        } else return null;
    }

    public InternationalSurveyEntity getByIdAndStatus(String id, String status) {
        if (internationalSurveyRepo.findByIdAndStatus(id, status) != null) {
            return internationalSurveyRepo.findByIdAndStatus(id, status);
        } else return null;
    }

    public List<InternationalSurveyEntity> getInternationalSurveyReport(String executiveTerritoryCode, Date fromStart, Date toEnd) {
        String queryForList = "SELECT\n" +
                "    i.direction_type_code directionTypeCode,\n" +
                "    i.direction_type_name directionTypeName,\n" +
                "    i.send_req_country_code sendReqCountryCode,\n" +
                "    i.send_req_country_nm sendReqCountryNm,    \n" +
                "    count(i.send_req_country_code) sendReqCountryCode,\n" +
                "    sum( case when i.sum is null then 0.00 else i.sum end) sum,\n" +
                "    sum( case when i.sum_approved is null then 0.00 else i.sum_approved end) sumApproved,\n" +
                "    sum( case when i.sum_on_control is null then 0.00 else i.sum_on_control end) sumOnControl\n" +
                "FROM\n" +
                "    cpid.international_survey i\n" +
                "where i.executive_territory_code = '" + executiveTerritoryCode + "'\n" +
                "and (\n" +
                "      (i.xbb_mail_date >= '" + fromStart + "' and i.xbb_mail_date <= '" + toEnd + "') or\n" +
                "      (date(i.instime) >= '" + fromStart + "' and date(i.instime) <= '" + toEnd + "')\n" +
                "    )\n" +
                "group by\n" +
                "    i.direction_type_code,\n" +
                "    i.direction_type_name,\n" +
                "    i.send_req_country_code,\n" +
                "    i.send_req_country_nm\n" +
                "    order by i.direction_type_code asc";
        return (List<InternationalSurveyEntity>) entityManager.createNativeQuery(queryForList, InternationalSurveyEntity.class).getResultList();
    }
}
