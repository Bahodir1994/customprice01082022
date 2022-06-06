package uz.customs.customsprice.service;

import org.springframework.stereotype.Service;
import uz.customs.customsprice.entity.gtdHistory.DeclarationEntity;
import uz.customs.customsprice.repository.history.GTDHistoryRepo;
import uz.customs.customsprice.utils.Utils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class BYDHistoryService {
    @PersistenceContext(unitName = "historys")
    private EntityManager entityManagerGTDHistory;
    private final GTDHistoryRepo gtdHistoryRepo;


    public BYDHistoryService(GTDHistoryRepo gtdHistoryRepo, EntityManager entityManagerGTDHistory) {
        this.gtdHistoryRepo = gtdHistoryRepo;
        this.entityManagerGTDHistory = entityManagerGTDHistory;
    }

    public List getListGTDHistory(String g7a, String g7b, String g7c) {
        String queryForList = "select distinct " +
                "d.G7A," +
                " char(d.G7B, eur) g7b," +
                " d.G7C," +
                " d.G1A," +
                " d.G1B," +
                " d.G8CODE2," +
                " d.INSTIME," +
                " g.G7A p7a," +
                " char(g.G7B, eur) p7b," +
                " g.G7C p7c," +
                " d.id \n" +
                "from ASOD.DECLARATION d\n" +
                "join ASOD.COMMODITY c on d.ID=c.DECL_ID\n" +
                "join ASOD.g40details g on d.id=g.decl_id and c.ID=g.CMDT_ID\n" +
                "where d.status = 1 \n";
        if (!Utils.nullClear(g7a).equals(""))
            queryForList = queryForList + " and d.g7a = '" + g7a + "'";
        if (!Utils.nullClear(g7b).equals(""))
            queryForList = queryForList + " and d.g7b = '" + g7b + "'";
        if (!Utils.nullClear(g7c).equals(""))
            queryForList = queryForList + " and d.g7c = '" + g7c + "'";
        List<Object[]> listCount = entityManagerGTDHistory.createNativeQuery(queryForList).getResultList();
        return listCount;
    }

    public List getListGTDHistoryDetails(String p7a, String p7b, String p7c, String declId) {
        String queryForList = "select\n" +
                "    d.id                   decl_id,\n" +
                "    d.g7a                  g7a,\n" +
                "    char(d.g7b, eur)       g7b,\n" +
                "    d.g7c                  g7c,\n" +
                "    d.g1a                  g1a,\n" +
                "    d.g1b                  g1b,\n" +
                "    d.g8code2              g8code2,\n" +
                "    d.status               status,\n" +
                "    char(d.gdvipdate, eur) gdvipdate,\n" +
                "    d.instime              instime\n" +
                "from\n" +
                "    asod.declaration d\n" +
                "join\n" +
                "    asod.g40details g\n" +
                "on\n" +
                "    d.id=g.decl_id\n" +
                "where\n" +
                "    g.g7a = '" + p7a + "'\n" +
                "and g.g7b = '" + p7b + "'\n" +
                "and g.g7c = '" + p7c + "'\n" +
                "and d.id != '" + declId + "' \n";
        return entityManagerGTDHistory.createNativeQuery(queryForList).getResultList();
    }

}
