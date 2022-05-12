package uz.customs.customsprice.service.CostMonitoring;

import org.springframework.stereotype.Service;
import uz.customs.customsprice.payload.CostMonitoringResponse;
import uz.customs.customsprice.payload.EarxivSearchResponse;
import uz.customs.customsprice.repository.CostMonitoring.CostMonitoringRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class CostMonitoringService {
    private final CostMonitoringRepository costMonitoringRepository;

    @PersistenceContext(unitName = "costmonitoring")
    private EntityManager entityManager;

    public CostMonitoringService(CostMonitoringRepository costMonitoringRepository) {
        this.costMonitoringRepository = costMonitoringRepository;
    }

    public List<CostMonitoringResponse> getListCostMonitoring() {
        String queryForList = " select\n" +
                "    d.id,\n" +
                "    d.decl_id,\n" +
                "    d.cmdt_id,\n" +
                "    d.g7a,\n" +
                "    d.g7b,\n" +
                "    d.g7c,\n" +
                "    d.g1a,\n" +
                "    d.g1b,\n" +
                "    d.g2name,\n" +
                "    d.g2code2,\n" +
                "    d.g8name,\n" +
                "    d.g8code2,\n" +
                "    d.g9name,\n" +
                "    d.g9code2,\n" +
                "    d.g11,\n" +
                "    d.g12,\n" +
                "    d.g13,\n" +
                "    d.g15,\n" +
                "    d.g17,\n" +
                "    d.g20b,\n" +
                "    d.g20name,\n" +
                "    d.g22a,\n" +
                "    d.g22b,\n" +
                "    d.g23,\n" +
                "    d.g23scale,\n" +
                "    d.g25,\n" +
                "    d.g26,\n" +
                "    d.g20fr,\n" +
                "    d.g24a,\n" +
                "    d.g24b,\n" +
                "    d.idn,\n" +
                "    d.g31name,\n" +
                "    d.g31marka,\n" +
                "    d.g31amount,\n" +
                "    d.g32,\n" +
                "    d.g33,\n" +
                "    d.g34,\n" +
                "    d.g35,\n" +
                "    d.g37b,\n" +
                "    d.g37c,\n" +
                "    d.g38,\n" +
                "    d.g41,\n" +
                "    d.g42,\n" +
                "    d.g43,\n" +
                "    d.g45,\n" +
                "    d.g46,\n" +
                "    d.g31edizm,\n" +
                "    d.g45usd,\n" +
                "    d.unitname,\n" +
                "    d.ves_edizm,\n" +
                "    d.metod_otc,\n" +
                "    d.g45_usd,\n" +
                "    d.g45usd_edizm,\n" +
                "    d.g45sum_edizm,\n" +
                "    d.g45_index,\n" +
                "    d.g45_edizm_valkont,\n" +
                "    d.g45_index_valkont,\n" +
                "    d.g42_usd,\n" +
                "    d.g42usd_edizm,\n" +
                "    d.g42sum_edizm,\n" +
                "    d.g42_index,\n" +
                "    d.g42_edizm_valkont,\n" +
                "    d.g42_index_valkont,\n" +
                "    d.gc3date,\n" +
                "    d.vid_tulov,\n" +
                "    d.doc_type,\n" +
                "    d.gdvipdate,\n" +
                "    d.status,\n" +
                "    d.instime,\n" +
                "    d.updtime,\n" +
                "    d.curtime,\n" +
                "    d.mtcid,\n" +
                "    d.id_mtc,\n" +
                "    c11.name      g11name,\n" +
                "    c15.name      g15name,\n" +
                "    c17.name      g17name,\n" +
                "    c34.name      g34name,\n" +
                "    c41.shortname g41name\n" +
                "from\n" +
                "    ebr.mtc_repl d\n" +
                "left join\n" +
                "    asod.country c11\n" +
                "on\n" +
                "    d.g11=c11.id\n" +
                "left join\n" +
                "    asod.country c15\n" +
                "on\n" +
                "    d.g15=c15.id\n" +
                "left join\n" +
                "    asod.country c17\n" +
                "on\n" +
                "    d.g17=c17.id\n" +
                "left join\n" +
                "    asod.country c34\n" +
                "on\n" +
                "    d.g34=c34.id\n" +
                "left join\n" +
                "    asod.unit c41\n" +
                "on\n" +
                "    d.g41=c41.id\n" +
                "where\n" +
                "    d.status=1\n" +
                "and d.gdvipdate >= '11.05.2022'\n" +
                "and d.gdvipdate <= current_date\n" +
                "and d.g1a='ИМ'\n" +
                "and d.g1b='40'\n" +
                "and d.metod_otc in ('1',\n" +
                "                    '4',\n" +
                "                    '5',\n" +
                "                    '6.1')\n" +
                "and d.vid_tulov = 1\n" +
                "--and d.G33 like '8407%'\n" +
                "fetch\n" +
                "    first 10 rows only ";
        return (List<CostMonitoringResponse>) entityManager.createNativeQuery(queryForList).getResultList();
    }

}
