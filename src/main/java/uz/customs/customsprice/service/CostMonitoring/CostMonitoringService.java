package uz.customs.customsprice.service.CostMonitoring;

import org.springframework.stereotype.Service;
import uz.customs.customsprice.payload.CostMonitoringResponse;
import uz.customs.customsprice.payload.EarxivSearchResponse;
import uz.customs.customsprice.repository.CostMonitoring.CostMonitoringRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
public class CostMonitoringService {
    private final CostMonitoringRepository costMonitoringRepository;

    @PersistenceContext(unitName = "costmonitoring")
    private EntityManager entityManager;

    public CostMonitoringService(CostMonitoringRepository costMonitoringRepository) {
        this.costMonitoringRepository = costMonitoringRepository;
    }

    public List getListCostMonitoring(String locationId, String postId, String gdvipdate1, String gdvipdate2) {
        String sql_os = "";
//        sql_os = (locationId != null && !locationId.equals("") ? sql_os + " and d.g7a = '" + locationId + "' " : sql_os);
        sql_os = (postId != null && !postId.equals("") ? sql_os + " and d.g7a = '" + postId + "' " : sql_os);
        sql_os = (gdvipdate1 != null && !gdvipdate1.equals("") ? sql_os + " and d.gdvipdate >= '" + gdvipdate1 + "' " : sql_os);
        sql_os = (gdvipdate2 != null && !gdvipdate2.equals("") ? sql_os + " and d.gdvipdate <= '" + gdvipdate2 + "' " : sql_os);

        String queryForList = " select\n" +
                "    d.id id,\n" +
                "    d.decl_id decl_id,\n" +
                "    d.cmdt_id cmdt_id,\n" +
                "    d.g7a g7a,\n" +
                "    char(d.g7b, eur) g7b,\n" +
                "    d.g7c g7c,\n" +
                "    d.g1a g1a,\n" +
                "    d.g1b g1b,\n" +
                "    d.g2name g2name,\n" +
                "    d.g2code2 g2code2,\n" +
                "    d.g8name g8name,\n" +
                "    d.g8code2 g8code2,\n" +
                "    d.g9name g9name,\n" +
                "    d.g9code2 g9code2,\n" +
                "    d.g11 g11,\n" +
                "    d.g12 g12,\n" +
                "    d.g13 g13,\n" +
                "    d.g15 g15,\n" +
                "    d.g17 g17,\n" +
                "    d.g20b g20b,\n" +
                "    d.g20name g20name,\n" +
                "    d.g22a g22a,\n" +
                "    d.g22b g22b,\n" +
                "    d.g23 g23,\n" +
                "    d.g23scale g23scale,\n" +
                "    d.g25 g25,\n" +
                "    d.g26 g26,\n" +
                "    d.g20fr g20fr,\n" +
                "    d.g24a g24a,\n" +
                "    d.g24b g24b,\n" +
                "    d.idn idn,\n" +
                "    d.g31name g31name,\n" +
                "    d.g31marka g31marka,\n" +
                "    d.g31amount g31amount,\n" +
                "    d.g32 g32,\n" +
                "    d.g33 g33,\n" +
                "    d.g34 g34,\n" +
                "    d.g35 g35,\n" +
                "    d.g37b g37b,\n" +
                "    d.g37c g37c,\n" +
                "    d.g38 g38,\n" +
                "    d.g41 g41,\n" +
                "    d.g42 g42,\n" +
                "    d.g43 g43,\n" +
                "    d.g45 g45,\n" +
                "    d.g46 g46,\n" +
                "    d.g31edizm g31edizm,\n" +
                "    d.g45usd g45usd,\n" +
                "    d.unitname unitname,\n" +
                "    d.ves_edizm ves_edizm,\n" +
                "    d.metod_otc metod_otc,\n" +
                "    d.g45_usd g45_usd,\n" +
                "    d.g45usd_edizm g45usd_edizm,\n" +
                "    d.g45sum_edizm g45sum_edizm,\n" +
                "    d.g45_index g45_index,\n" +
                "    d.g45_edizm_valkont g45_edizm_valkont,\n" +
                "    d.g45_index_valkont g45_index_valkont,\n" +
                "    d.g42_usd g42_usd,\n" +
                "    d.g42usd_edizm g42usd_edizm,\n" +
                "    d.g42sum_edizm g42sum_edizm,\n" +
                "    d.g42_index g42_index,\n" +
                "    d.g42_edizm_valkont g42_edizm_valkont,\n" +
                "    d.g42_index_valkont g42_index_valkont,\n" +
                "    char(d.gc3date, eur) gc3date,\n" +
                "    d.vid_tulov vid_tulov,\n" +
                "    d.doc_type doc_type,\n" +
                "    char(d.gdvipdate, eur) gdvipdate,\n" +
                "    d.status status,\n" +
                "    d.instime instime,\n" +
                "    d.updtime updtime,\n" +
                "    d.curtime curtime,\n" +
                "    d.mtcid mtcid,\n" +
                "    d.id_mtc id_mtc,\n" +
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
                "and d.g1a='ИМ'\n" +
                "and d.g1b='40'\n" +
//                "and d.metod_otc in ('1',\n" +
//                "                    '4',\n" +
//                "                    '5',\n" +
//                "                    '6.1')\n" +
                "and d.vid_tulov = 1\n" +
                "--and d.G33 like '8407%'\n" +
                "" + sql_os + "\n" +
                "fetch\n" +
                "    first 10 rows only ";
        List<Object[]> list = entityManager.createNativeQuery(queryForList).getResultList();
        return list;
    }

}
