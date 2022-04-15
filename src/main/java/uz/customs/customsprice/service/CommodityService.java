package uz.customs.customsprice.service;

import org.springframework.stereotype.Service;
import uz.customs.customsprice.entity.InitialDecision.Commodity;
import uz.customs.customsprice.repository.CommodityRepo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
public class CommodityService {
    private final CommodityRepo commodityRepo;

    public CommodityService(CommodityRepo commodityRepo) {
        this.commodityRepo = commodityRepo;
    }

    public Commodity getByAppId(String appId){
        return commodityRepo.findAllByAppId(appId);
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

    public Optional<Commodity> getById(String id){
        return commodityRepo.findById(id);
    }
}
