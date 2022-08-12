package uz.customs.customsprice.service;

import org.springframework.stereotype.Service;
import uz.customs.customsprice.entity.InDec;
import uz.customs.customsprice.repository.InDecRepo;
import uz.customs.customsprice.utils.Utils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class InDecService {
    private final InDecRepo inDecRepo;

    public InDecService(InDecRepo inDecRepo) {
        this.inDecRepo = inDecRepo;
    }

    public InDec getByCmtdId(String cmtdId) {
        return inDecRepo.findByCmdtId(cmtdId);
    }

    public InDec getById(String id) {
        if (inDecRepo.findById(id).isPresent())
            return inDecRepo.findById(id).get();
        else return null;
    }

    public InDec getByInDecNumAndInDecDateAndPersonId(String inDecNum, Date inDecDate, String personId) {
        if (inDecRepo.findByInDecNumAndInDecDateAndPersonId(inDecNum, inDecDate, personId) != null)
            return inDecRepo.findByInDecNumAndInDecDateAndPersonId(inDecNum, inDecDate, personId);
        else return null;
    }


    public InDec getByInDecDate(Date inDecDate) {
        if (inDecRepo.findByInDecDate(inDecDate) != null)
            return inDecRepo.findByInDecDate(inDecDate);
        else return null;
    }

    @PersistenceContext
    private EntityManager entityManager;

    /* 4) <<app_num>> га ариза рафамини киритади */
    public InDec saveInDec(InDec inDec, String userLocation) {
        LocalDateTime now = LocalDateTime.now();
        String inDecNum = getMaxNumberInDec();
        String currentDateFormat = "";
        currentDateFormat = currentDateFormat + now.getYear() % 100;
        if (now.getMonthValue() < 10)
            currentDateFormat += "0" + now.getMonthValue();
        else
            currentDateFormat += now.getMonthValue();
        if (now.getDayOfMonth() < 10)
            currentDateFormat += "0" + now.getDayOfMonth();
        else
            currentDateFormat += now.getDayOfMonth();
        currentDateFormat = currentDateFormat + inDecNum;
        inDec.setInDecNum(userLocation + currentDateFormat);
        return inDecRepo.save(inDec);
    }

    /*todo 4.1) <<InDec>> га ариза рақамини генерация қилиш (1726/01.08.2022/000001) */
    public InDec saveInDecS(InDec inDec, String userLocation) {
        String inDecNum = getMaxNumberInDecS(inDec.getInDecLocation(), inDec.getInDecDate());
        String inDecNumS = "";
        inDecNumS = inDec.getInDecLocation() + "/" + Utils.toDate(inDec.getInDecDate()) + "/" + inDecNum;
        inDec.setInDecNum(inDecNumS);
        inDec.setInDecNumS(inDecNum);
        return inDecRepo.save(inDec);
    }

    public InDec saveInDecOne(InDec inDec) {
        return inDecRepo.save(inDec);
    }

    /* 5) <<InDec>> учун рақам генерация қилади */
    public String getMaxNumberInDec() {
        String queryForList = "select\n" +
                "    a.IN_DEC_NUM as maxno\n" +
                "from\n" +
                "    CPID.IN_DEC as a\n" +
                "order by\n" +
                "    a.instime desc\n" +
                "fetch\n" +
                "    first 1 rows only";
        List resultList = entityManager.createNativeQuery(queryForList).getResultList();
        String lastNumber = "000001";
        if (resultList.size() > 0) {
            lastNumber = String.valueOf(resultList.get(0));
//            if (lastNumber == "null") {
            if (lastNumber == null || lastNumber.equals("null") || lastNumber.equals("")) {
                lastNumber = "000001";
            }
        }
        LocalDateTime now = LocalDateTime.now();
        String currentDateFormat = "";
        String result = "";
        currentDateFormat = currentDateFormat + now.getYear() % 100;
        if (now.getMonthValue() < 10)
            currentDateFormat += "0" + now.getMonthValue();
        else
            currentDateFormat += now.getMonthValue();
        if (now.getDayOfMonth() < 10)
            currentDateFormat += "0" + now.getDayOfMonth();
        else
            currentDateFormat += now.getDayOfMonth();
        String lastDay = lastNumber.substring(0, 6);
        if (!lastDay.equals(currentDateFormat)) {
            result = "000001";
        } else {
            int resultLastNumber = Integer.parseInt(lastNumber.substring(6)) + 1;
            if (resultLastNumber < 10) {
                result = "00000" + resultLastNumber;
            } else if (resultLastNumber < 100) {
                result = "0000" + resultLastNumber;
            } else if (resultLastNumber < 1000) {
                result = "000" + resultLastNumber;
            } else if (resultLastNumber < 10000) {
                result = "00" + resultLastNumber;
            } else if (resultLastNumber < 100000) {
                result = "0" + resultLastNumber;
            } else if (resultLastNumber < 1000000) {
                result = Integer.toString(resultLastNumber);
            }
        }
        return result;
    }


    /*todo 5.1) <<InDec>> га ариза рақамини генерация қилиш (1726/01.08.2022/000001) */
    public String getMaxNumberInDecS(String inDecLocation, Date inDecDate) {
        String queryForList = "select\n" +
                "    right('000000'||((\n" +
                "    case\n" +
                "        when(\n" +
                "                max(cast(substring(t.in_dec_num, 18, 6) as int)))\n" +
                "            is not null\n" +
                "        then(max(cast(substring(t.in_dec_num, 18, 6) as int)))\n" +
                "        else 0\n" +
                "    end) +1), 6) maxno\n" +
                "from\n" +
                "    (   select\n" +
                "            p.*\n" +
                "        from\n" +
                "            cpid.in_dec p\n" +
                "        where\n" +
                "            p.in_dec_location = '" + inDecLocation + "') t\n" +
                "where\n" +
                "    t.in_dec_location = '" + inDecLocation + "'\n" +
                "and t.in_dec_nums||year(t.in_dec_date) = t.in_dec_nums||year(current_date) \n" +
                "and year('" + Utils.toDate00(inDecDate) + "') = year(current_date)";
        List resultList = entityManager.createNativeQuery(queryForList).getResultList();
        String lastNumber = "000001";
        String result = "";
        if (resultList.size() > 0) {
            lastNumber = String.valueOf(resultList.get(0));
            if (lastNumber == null || lastNumber.equals("null") || lastNumber.equals("")) {
                lastNumber = "000001";
            }
        }
        result = lastNumber;
        return result;
    }

//    public void saveInDec(Optional<InDec> inDec1) {
//    }

//
//    public List<IndecAPIDto> getDeptEmployeesLeftJoin(String cmdtId) {
//        List<IndecAPIDto> list = inDecRepo.query(cmdtId);
//        list.forEach(l -> System.out.println(l));
//        return list;
//    }


}
