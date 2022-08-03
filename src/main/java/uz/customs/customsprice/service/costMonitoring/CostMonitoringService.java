package uz.customs.customsprice.service.costMonitoring;

import org.springframework.stereotype.Service;
import uz.customs.customsprice.controllers.CostMonitoring.CostMonitoringData;
import uz.customs.customsprice.controllers.CostMonitoring.CostMonitoringResponse1;
import uz.customs.customsprice.repository.CostMonitoring.CostMonitoringRepository;
import uz.customs.customsprice.utils.Utils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Service
public class CostMonitoringService {
    private final CostMonitoringRepository costMonitoringRepository;

    @PersistenceContext(unitName = "costmonitoring")
    private EntityManager entityManager;

    public CostMonitoringService(CostMonitoringRepository costMonitoringRepository) {
        this.costMonitoringRepository = costMonitoringRepository;
    }

    public List getListCostMonitoring(
            String locationId,
            String postId,
            String gdvipdate1,
            String gdvipdate2,
            String g11,
            String g15,
            String g34,
            String g33,
            String g31name,
            String g25,
            String g8code2,
            String metod_otc,
            String g20b,
            String g20name,
            String g7c
    ) {
        String sql_os = "";
//        sql_os = (locationId != null && !locationId.equals("") ? sql_os + " and d.g7a = '" + locationId + "' " : sql_os);
        sql_os = (postId != null && !postId.equals("") ? sql_os + " and d.g7a = '" + postId + "' " : sql_os);
        sql_os = (gdvipdate1 != null && !gdvipdate1.equals("") ? sql_os + " and d.gdvipdate >= '" + gdvipdate1 + "' " : sql_os);
        sql_os = (gdvipdate2 != null && !gdvipdate2.equals("") ? sql_os + " and d.gdvipdate <= '" + gdvipdate2 + "' " : sql_os);
        sql_os = (g11 != null && !g11.equals("") ? sql_os + " and d.g11 = '" + g11 + "' " : sql_os);
        sql_os = (g15 != null && !g15.equals("") ? sql_os + " and d.g15 = '" + g15 + "' " : sql_os);
        sql_os = (g34 != null && !g34.equals("") ? sql_os + " and d.g34 = '" + g34 + "' " : sql_os);
        sql_os = (g33 != null && !g33.equals("") ? g33.length() < 10 ? sql_os + " and d.g33 like '" + g33 + "%'" : sql_os + " and d.g33 = '" + g33 + "'" : sql_os);
        sql_os = (g31name != null && !g31name.equals("") ? sql_os + " and lower(d.g31name) like lower ('%" + g31name + "%')" : sql_os);
        sql_os = (g25 != null && !g25.equals("") ? sql_os + " and d.g25 = '" + g25 + "' " : sql_os);
        sql_os = (g8code2 != null && !g8code2.equals("") ? sql_os + " and d.g8code2 = '" + g8code2 + "' " : sql_os);
        sql_os = (metod_otc != null && !metod_otc.equals("") ? sql_os + " and d.metod_otc = '" + metod_otc + "' " : sql_os);
        sql_os = (g20b != null && !g20b.equals("") ? sql_os + " and d.g20b = '" + g20b + "' " : sql_os);
        sql_os = (g20name != null && !g20name.equals("") ? sql_os + " and lower(d.g20name) like lower ('%" + g20name + "%')" : sql_os);
        sql_os = (g7c != null && !g7c.equals("") ? sql_os + " and d.g7c = '" + g7c + "' " : sql_os);

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
                "and d.metod_otc in ('1',\n" +
                "                    '4',\n" +
                "                    '5',\n" +
                "                    '6.1',\n" +
                "                    '6.4',\n" +
                "                    '6.5')\n" +
                "and d.vid_tulov = 1\n" +
                "--and d.G33 like '8407%'\n" +
                "" + sql_os + "\n" +
                "fetch\n" +
                "    first 10 rows only ";
        List<Object[]> list = entityManager.createNativeQuery(queryForList).getResultList();
        return list;
    }

    public CostMonitoringResponse1 getListCostMonitoring1(
            String filter,
            String limit,
            String order,
            String start,
            String dir,
            String LocationId,
            String PostId,
            String Gdvipdate1,
            String Gdvipdate2,
            String G11,
            String G15,
            String G34,
            String G33,
            String G31name,
            String G25,
            String G8code2,
            String Metod_otc,
            String G20b,
            String G20name,
            String G7c
    ) {
        String sql_os = "", sql_osF = "";
//        sql_os = (LocationId != null && !LocationId.equals("") ? sql_os + " and d.g7a = '" + LocationId + "' " : sql_os);
        sql_os = (PostId != null && !PostId.equals("") ? sql_os + " and d.g7a = '" + PostId + "' " : sql_os);
        sql_os = (G7c != null && !G7c.equals("") ? sql_os + " and d.g7c = '" + G7c + "' " : sql_os);
        sql_os = (Gdvipdate1 != null && !Gdvipdate1.equals("") ? sql_os + " and d.gdvipdate >= '" + Gdvipdate1 + "' " : sql_os);
        sql_os = (Gdvipdate2 != null && !Gdvipdate2.equals("") ? sql_os + " and d.gdvipdate <= '" + Gdvipdate2 + "' " : sql_os);
        sql_os = (G11 != null && !G11.equals("") ? sql_os + " and d.g11 = '" + G11 + "' " : sql_os);
        sql_os = (G15 != null && !G15.equals("") ? sql_os + " and d.g15 = '" + G15 + "' " : sql_os);
        sql_os = (G34 != null && !G34.equals("") ? sql_os + " and d.g34 = '" + G34 + "' " : sql_os);
        sql_os = (G33 != null && !G33.equals("") ? G33.length() < 10 ? sql_os + " and d.g33 like '" + G33 + "%'" : sql_os + " and d.g33 = '" + G33 + "'" : sql_os);
        sql_os = (G31name != null && !G31name.equals("") ? sql_os + " and lower(d.g31name) like lower ('%" + G31name + "%')" : sql_os);
        sql_os = (G25 != null && !G25.equals("") ? sql_os + " and d.g25 = '" + G25 + "' " : sql_os);
        sql_os = (G8code2 != null && !G8code2.equals("") ? sql_os + " and d.g8code2 = '" + G8code2 + "' " : sql_os);
        sql_os = (Metod_otc != null && !Metod_otc.equals("") ? sql_os + " and d.metod_otc = '" + Metod_otc + "' " : sql_os);
        sql_os = (G20b != null && !G20b.equals("") ? sql_os + " and d.g20b = '" + G20b + "' " : sql_os);
        sql_os = (G20name != null && !G20name.equals("") ? sql_os + " and lower(d.g20name) like lower ('%" + G20name + "%')" : sql_os);
        sql_os = (G7c != null && !G7c.equals("") ? sql_os + " and d.g7c = '" + G7c + "' " : sql_os);

        if (filter != null && !filter.equals("")) {
            sql_osF = sql_osF + " and ( d.g33 like '" + filter + "%'" + " or lower(d.g31name) like lower ('%" + filter + "%') \n " +
                    " or d.g7a||'/'||char(d.g7b, eur)||'/'||d.g7c like '" + filter + "%' \n " +
                    " \n " +
                    " ) ";
        }
//        if (order.equals("0")) {
//            sql_osF = sql_osF + " order by d.g7a  " + sql_osF + " " + dir;
//        }
//        if (order.equals("1")) {
//            sql_osF = sql_osF + " order by d.g15 " + sql_osF + " " + dir;
//        }
//        if (order.equals("2")) {
//            sql_osF = sql_osF + " order by d.g34 " + sql_osF + " " + dir;
//        }
//        if (order.equals("3")) {
//            sql_osF = sql_osF + " order by d.g11 " + sql_osF + " " + dir;
//        }
//        if (order.equals("4")) {
//            sql_osF = sql_osF + " order by d.g11 " + sql_osF + " " + dir;
//        }


        String countRows = "";
        String queryForList = "";
        queryForList = " select\n" +
                "    count(*) countRows \n" +
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
                "and d.metod_otc in ('1',\n" +
                "                    '4',\n" +
                "                    '5',\n" +
                "                    '6.1')\n" +
                "and d.vid_tulov = 1 " +
                " " + sql_os + " ";
        List<Object> listCount = entityManager.createNativeQuery(queryForList).getResultList();

        countRows = listCount.get(0).toString();


        queryForList = " select\n" +
                "    *\n" +
                "from\n" +
                "    (   select\n" +
                "            d.id                   id,\n" +
                "            d.decl_id              decl_id,\n" +
                "            d.cmdt_id              cmdt_id,\n" +
                "            d.g7a                  g7a,\n" +
                "            char(d.g7b, eur)       g7b,\n" +
                "            d.g7c                  g7c,\n" +
                "            d.g1a                  g1a,\n" +
                "            d.g1b                  g1b,\n" +
                "            d.g2name               g2name,\n" +
                "            d.g2code2              g2code2,\n" +
                "            d.g8name               g8name,\n" +
                "            d.g8code2              g8code2,\n" +
                "            d.g9name               g9name,\n" +
                "            d.g9code2              g9code2,\n" +
                "            d.g11                  g11,\n" +
                "            d.g12                  g12,\n" +
                "            d.g13                  g13,\n" +
                "            d.g15                  g15,\n" +
                "            d.g17                  g17,\n" +
                "            d.g20b                 g20b,\n" +
                "            d.g20name              g20name,\n" +
                "            d.g22a                 g22a,\n" +
                "            d.g22b                 g22b,\n" +
                "            d.g23                  g23,\n" +
                "            d.g23scale             g23scale,\n" +
                "            d.g25                  g25,\n" +
                "            d.g26                  g26,\n" +
                "            d.g20fr                g20fr,\n" +
                "            d.g24a                 g24a,\n" +
                "            d.g24b                 g24b,\n" +
                "            d.idn                  idn,\n" +
                "            d.g31name              g31name,\n" +
                "            d.g31marka             g31marka,\n" +
                "            d.g31amount            g31amount,\n" +
                "            d.g32                  g32,\n" +
                "            d.g33                  g33,\n" +
                "            d.g34                  g34,\n" +
                "            d.g35                  g35,\n" +
                "            d.g37b                 g37b,\n" +
                "            d.g37c                 g37c,\n" +
                "            d.g38                  g38,\n" +
                "            d.g41                  g41,\n" +
                "            d.g42                  g42,\n" +
                "            d.g43                  g43,\n" +
                "            d.g45                  g45,\n" +
                "            d.g46                  g46,\n" +
                "            d.g31edizm             g31edizm,\n" +
                "            d.g45usd               g45usd,\n" +
                "            d.unitname             unitname,\n" +
                "            d.ves_edizm            ves_edizm,\n" +
                "            d.metod_otc            metod_otc,\n" +
                "            d.g45_usd              g45_usd,\n" +
                "            d.g45usd_edizm         g45usd_edizm,\n" +
                "            d.g45sum_edizm         g45sum_edizm,\n" +
                "            d.g45_index            g45_index,\n" +
                "            d.g45_edizm_valkont    g45_edizm_valkont,\n" +
                "            d.g45_index_valkont    g45_index_valkont,\n" +
                "            d.g42_usd              g42_usd,\n" +
                "            d.g42usd_edizm         g42usd_edizm,\n" +
                "            d.g42sum_edizm         g42sum_edizm,\n" +
                "            d.g42_index            g42_index,\n" +
                "            d.g42_edizm_valkont    g42_edizm_valkont,\n" +
                "            d.g42_index_valkont    g42_index_valkont,\n" +
                "            char(d.gc3date, eur)   gc3date,\n" +
                "            d.vid_tulov            vid_tulov,\n" +
                "            d.doc_type             doc_type,\n" +
                "            char(d.gdvipdate, eur) gdvipdate,\n" +
                "            d.status               status,\n" +
                "            d.instime              instime,\n" +
                "            d.updtime              updtime,\n" +
                "            d.curtime              curtime,\n" +
                "            d.mtcid                mtcid,\n" +
                "            d.id_mtc               id_mtc,\n" +
                "            c11.name               g11name,\n" +
                "            c15.name               g15name,\n" +
                "            c17.name               g17name,\n" +
                "            c34.name               g34name,\n" +
                "            c41.shortname          g41name\n" +
                "        from\n" +
                "            ebr.mtc_repl d\n" +
                "        left join\n" +
                "            asod.country c11\n" +
                "        on\n" +
                "            d.g11=c11.id\n" +
                "        left join\n" +
                "            asod.country c15\n" +
                "        on\n" +
                "            d.g15=c15.id\n" +
                "        left join\n" +
                "            asod.country c17\n" +
                "        on\n" +
                "            d.g17=c17.id\n" +
                "        left join\n" +
                "            asod.country c34\n" +
                "        on\n" +
                "            d.g34=c34.id\n" +
                "        left join\n" +
                "            asod.unit c41\n" +
                "        on\n" +
                "            d.g41=c41.id\n" +
                "        where\n" +
                "            d.status=1\n" +
                "        and d.g1a='ИМ'\n" +
                "        and d.g1b='40'\n" +
                "        and d.metod_otc in ('1',\n" +
                "                            '4',\n" +
                "                            '5',\n" +
                "                            '6.1')\n" +
                "        and d.vid_tulov = 1\n" +
                "        " + sql_os + "\n" +
                "        " + sql_osF + "\n" +
//                "        order by\n" +
//                "            d.instime asc,\n" +
//                "            d.g7a desc\n" +
                "        fetch\n" +
                "            first " + (10 + Integer.parseInt(start)) + " rows only) dd\n" +
                "order by\n" +
                "    instime desc,\n" +
                "    g7a asc\n" +
                "fetch\n" +
                "    first " + limit + " rows only ";
        List<Object[]> list = entityManager.createNativeQuery(queryForList).getResultList();

        String id = "", decl_id = "", cmdt_id = "", g7a = "", g7b = "", g7c = "", g1a = "", g1b = "", g2name = "", g2code2 = "", g8name = "", g8code2 = "", g9name = "", g9code2 = "", g11 = "",
                g12 = "", g13 = "", g15 = "", g17 = "", g20b = "", g20name = "", g22a = "", g22b = "", g23 = "", g23scale = "", g25 = "", g26 = "", g20fr = "", g24a = "", g24b = "", idn = "",
                g31name = "", g31marka = "", g31amount = "", g32 = "", g33 = "", g34 = "", g35 = "", g37b = "", g37c = "", g38 = "", g41 = "", g42 = "", g43 = "", g45 = "", g46 = "", g31edizm = "",
                g45usd = "", unitname = "", ves_edizm = "", metod_otc = "", g45_usd = "", g45usd_edizm = "", g45sum_edizm = "", g45_index = "", g45_edizm_valkont = "", g45_index_valkont = "",
                g42_usd = "", g42usd_edizm = "", g42sum_edizm = "", g42_index = "", g42_edizm_valkont = "", g42_index_valkont = "", gc3date = "", vid_tulov = "", doc_type = "", gdvipdate = "",
                status = "", instime = "", updtime = "", curtime = "", mtcid = "", id_mtc = "", g11name = "", g15name = "", g17name = "", g34name = "", g41name = "";
        String g7abc = "";
        List<CostMonitoringData> costMonitoringDataList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            id = list.get(i)[0].toString();
            decl_id = Utils.nullClear(list.get(i)[1]).toString();
            cmdt_id = Utils.nullClear(list.get(i)[2]).toString();
            g7a = Utils.nullClear(list.get(i)[3]).toString();
            g7b = Utils.nullClear(list.get(i)[4]).toString();
            g7c = Utils.nullClear(list.get(i)[5]).toString();
            g7abc = Utils.nullClear(list.get(i)[3]).toString() + "/" + Utils.nullClear(list.get(i)[4]).toString() + "/" + Utils.nullClear(list.get(i)[5]).toString();
            g1a = Utils.nullClear(list.get(i)[6]).toString();
            g1b = Utils.nullClear(list.get(i)[7]).toString();
            g2name = Utils.nullClear(list.get(i)[8]).toString();
            g2code2 = Utils.nullClear(list.get(i)[9]).toString();
            g8name = Utils.nullClear(list.get(i)[10]).toString();
            g8code2 = Utils.nullClear(list.get(i)[11]).toString();
            g9name = Utils.nullClear(list.get(i)[12]).toString();
            g9code2 = Utils.nullClear(list.get(i)[13]).toString();
            g11 = Utils.nullClear(list.get(i)[14]).toString();
            g12 = Utils.nullClear(list.get(i)[15]).toString();
            g13 = Utils.nullClear(list.get(i)[16]).toString();
            g15 = Utils.nullClear(list.get(i)[17]).toString();
            g17 = Utils.nullClear(list.get(i)[18]).toString();
            g20b = Utils.nullClear(list.get(i)[19]).toString();
            g20name = Utils.nullClear(list.get(i)[20]).toString();
            g22a = Utils.nullClear(list.get(i)[21]).toString();
            g22b = Utils.nullClear(list.get(i)[22]).toString();
            g23 = Utils.nullClear(list.get(i)[23]).toString();
            g23scale = Utils.nullClear(list.get(i)[24]).toString();
            g25 = Utils.nullClear(list.get(i)[25]).toString();
            g26 = Utils.nullClear(list.get(i)[26]).toString();
            g20fr = Utils.nullClear(list.get(i)[27]).toString();
            g24a = Utils.nullClear(list.get(i)[28]).toString();
            g24b = Utils.nullClear(list.get(i)[29]).toString();
            idn = Utils.nullClear(list.get(i)[30]).toString();
            g31name = Utils.nullClear(list.get(i)[31]).toString();
            g31marka = Utils.nullClear(list.get(i)[32]).toString();
            g31amount = Utils.nullClear(list.get(i)[33]).toString();
            g32 = Utils.nullClear(list.get(i)[34]).toString();
            g33 = Utils.nullClear(list.get(i)[35]).toString();
            g34 = Utils.nullClear(list.get(i)[36]).toString();
            g35 = Utils.nullClear(list.get(i)[37]).toString();
            g37b = Utils.nullClear(list.get(i)[38]).toString();
            g37c = Utils.nullClear(list.get(i)[39]).toString();
            g38 = Utils.nullClear(list.get(i)[40]).toString();
            g41 = Utils.nullClear(list.get(i)[41]).toString();
            g42 = Utils.nullClear(list.get(i)[42]).toString();
            g43 = Utils.nullClear(list.get(i)[43]).toString();
            g45 = Utils.nullClear(list.get(i)[44]).toString();
            g46 = Utils.nullClear(list.get(i)[45]).toString();
            g31edizm = Utils.nullClear(list.get(i)[46]).toString();
            g45usd = Utils.nullClear(list.get(i)[47]).toString();
            unitname = Utils.nullClear(list.get(i)[48]).toString();
            ves_edizm = Utils.nullClear(list.get(i)[49]).toString();
            metod_otc = Utils.nullClear(list.get(i)[50]).toString();
            g45_usd = Utils.nullClear(list.get(i)[51]).toString();
            g45usd_edizm = Utils.nullClear(list.get(i)[52]).toString();
            g45sum_edizm = Utils.nullClear(list.get(i)[53]).toString();
            g45_index = Utils.nullClear(list.get(i)[54]).toString();
            g45_edizm_valkont = Utils.nullClear(list.get(i)[55]).toString();
            g45_index_valkont = Utils.nullClear(list.get(i)[56]).toString();
            g42_usd = Utils.nullClear(list.get(i)[57]).toString();
            g42usd_edizm = Utils.nullClear(list.get(i)[58]).toString();
            g42sum_edizm = Utils.nullClear(list.get(i)[59]).toString();
            g42_index = Utils.nullClear(list.get(i)[60]).toString();
            g42_edizm_valkont = Utils.nullClear(list.get(i)[61]).toString();
            g42_index_valkont = Utils.nullClear(list.get(i)[62]).toString();
            gc3date = Utils.nullClear(list.get(i)[63]).toString();
            vid_tulov = Utils.nullClear(list.get(i)[64]).toString();
            doc_type = Utils.nullClear(list.get(i)[65]).toString();
            gdvipdate = Utils.nullClear(list.get(i)[66]).toString();
            status = Utils.nullClear(list.get(i)[67]).toString();
            instime = Utils.nullClear(list.get(i)[68]).toString();
            updtime = Utils.nullClear(list.get(i)[69]).toString();
            curtime = Utils.nullClear(list.get(i)[70]).toString();
            mtcid = Utils.nullClear(list.get(i)[71]).toString();
            id_mtc = Utils.nullClear(list.get(i)[72]).toString();
            g11name = Utils.nullClear(list.get(i)[73]).toString();
            g15name = Utils.nullClear(list.get(i)[74]).toString();
            g17name = Utils.nullClear(list.get(i)[75]).toString();
            g34name = Utils.nullClear(list.get(i)[76]).toString();
            CostMonitoringData costMonitoringData = new CostMonitoringData(id, decl_id, cmdt_id, g7a, g7b, g7c, g7abc, g1a, g1b, g2name, g2code2, g8name, g8code2, g9name, g9code2, g11, g12, g13, g15, g17,
                    g20b, g20name, g22a, g22b, g23, g23scale, g25, g26, g20fr, g24a, g24b, idn, g31name, g31marka, g31amount, g32, g33, g34, g35, g37b, g37c, g38, g41, g42, g43, g45, g46, g31edizm,
                    g45usd, unitname, ves_edizm, metod_otc, g45_usd, g45usd_edizm, g45sum_edizm, g45_index, g45_edizm_valkont, g45_index_valkont, g42_usd, g42usd_edizm, g42sum_edizm, g42_index,
                    g42_edizm_valkont, g42_index_valkont, gc3date, vid_tulov, doc_type, gdvipdate, status, instime, updtime, curtime, mtcid, id_mtc, g11name, g15name, g17name, g34name, g41name);
            costMonitoringDataList.add(costMonitoringData);
        }

        CostMonitoringResponse1 costMonitoringResponse1 = new CostMonitoringResponse1();
        costMonitoringResponse1.setData(costMonitoringDataList);
        costMonitoringResponse1.setDraw((int) System.currentTimeMillis());
        costMonitoringResponse1.setRecordsFiltered(Integer.parseInt(countRows));
        costMonitoringResponse1.setRecordsTotal(Integer.parseInt(countRows));
        return costMonitoringResponse1;
    }

}
