package uz.customs.customsprice.service;

import org.springframework.stereotype.Service;
import uz.customs.customsprice.entity.InitialDecision.Commodity;
import uz.customs.customsprice.entity.InitialDecision.InDec;
import uz.customs.customsprice.entity.InitialDecision.Payment;
import uz.customs.customsprice.repository.CommodityRepo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Service
public class CommodityService {
    private final CommodityRepo commodityRepo;

    public CommodityService(CommodityRepo commodityRepo) {
        this.commodityRepo = commodityRepo;
    }

    public Commodity getByAppId(String appId) {
        return commodityRepo.findAllByAppId(appId);
    }

    public List<Commodity> getListAppId(String appId) {
        return commodityRepo.findByAppId(appId);
    }

    @PersistenceContext
    private EntityManager entityManager;

    /* 4) <<Commodity>> га тартиб рафамини киритади */
    public Commodity saveCommodity(Commodity commodity) {
        if (commodity != null) {
            String cmdtNumber = getMaxCmdtNumber(commodity.getAppId());
            commodity.setCmdtNum(Integer.valueOf(cmdtNumber));
        }
        return commodityRepo.save(commodity);
    }

    public Commodity saveYN(Commodity commodity) {
        return commodityRepo.save(commodity);
    }

    /* 5) <<Commodity>> учун тартиб рақамини генерация қилади */
    public String getMaxCmdtNumber(String appId) {
        String queryForList = "select\n" +
                "    cm.CMDT_NUM MAXNO\n" +
                "from\n" +
                "    CPID.COMMODITY cm\n" +
                "where cm.APP_ID = '" + appId + " ' \n" +
                "order by\n" +
                "    cm.instime desc\n" +
                "fetch\n" +
                "    first 1 rows only";
        List resultList = entityManager.createNativeQuery(queryForList).getResultList();
        String lastNumber = "1";
        int resultLastNumber = 1;
        if (resultList.size() > 0) {
            lastNumber = String.valueOf(resultList.get(0));
            if (lastNumber == null || lastNumber.equals("null") || lastNumber.equals("")) {
                lastNumber = "1";
            } else {
                resultLastNumber = Integer.parseInt(lastNumber) + 1;
            }
        }
        String result = "";
        result = Integer.toString(resultLastNumber);
        return result;
    }

    public Optional<Commodity> getById(String id) {
        return commodityRepo.findById(id);
    }

    public Commodity findById(String id) {
        if (commodityRepo.findById(id).isPresent())
            return commodityRepo.findById(id).get();
        else return null;
    }

    public List<Commodity> getListCommdityPayment(String appId) {
        String queryForList = " select\n" +
                "    cmdt.id     cmdt_id,\n" +
                "    count(p.id) payment_count\n" +
                "from\n" +
                "    cpid.commodity cmdt\n" +
                "left join\n" +
                "    cpid.payment p\n" +
                "on\n" +
                "    cmdt.id = p.cmdt_id\n" +
                "where\n" +
                "    app_id='" + appId + "'\n" +
                "    and p.CMDT_ID is null \n" +
                "group by\n" +
                "    cmdt.id,\n" +
                "    p.cmdt_id ";
        return (List<Commodity>) entityManager.createNativeQuery(queryForList).getResultList();
    }

    public List<Payment> getListPaymentCount(String cmdtId) {
        String queryForList = " select\n" +
                "    count(p.id) payment_count\n" +
                "from\n" +
                "    cpid.commodity cmdt\n" +
                "left join\n" +
                "    cpid.payment p\n" +
                "on\n" +
                "    cmdt.id = p.cmdt_id\n" +
                "where\n" +
                "    p.cmdt_id = '" + cmdtId + "' ";
        return (List<Payment>) entityManager.createNativeQuery(queryForList).getResultList();
    }

}
