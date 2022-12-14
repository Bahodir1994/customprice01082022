package uz.customs.customsprice.service.apps;

import org.springframework.stereotype.Service;
import uz.customs.customsprice.entity.InitialDecision.Apps;
import uz.customs.customsprice.entity.InitialDecision.Commodity;
import uz.customs.customsprice.entity.InDec;
import uz.customs.customsprice.entity.files.Docs;
import uz.customs.customsprice.repository.AppsRepo;
import uz.customs.customsprice.utils.Utils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class AppsService {

    private final AppsRepo appsRepo;
    public AppsService(AppsRepo appsRepo) {
        this.appsRepo = appsRepo;
    }

    @PersistenceContext
    private EntityManager entityManager;

    /* 1) Барча статуси "Янги" бўлган аризалар */
    public List<Apps> getListNotSorted(HttpServletRequest request, String userLocation, String userPost, String userId, Integer userRole) {

        userRole = (Integer) request.getSession().getAttribute("userRole");
        userLocation = (String) request.getSession().getAttribute("userLocation");
        userPost = (String) request.getSession().getAttribute("userPost");
        String userIdS = (String) request.getSession().getAttribute("userIdS");

        String sqlWhere = "", sqlJoin = "", sqlJoinVal = "";
        if (userRole <= 5 && userLocation.equals("1701")) {
            sqlWhere = " and a.status=100 \n ";
        }
        if (userRole == 7) {
            sqlWhere = " and a.status=100 \n " +
                    " and a.location_id='" + userLocation + "' ";
        }
        if (userRole == 8) {
            sqlJoinVal = ",\n" +
                    "    ar.inspector_id   inspector_id,\n" +
                    "    ar.inspector_name inspector_name\n";
            sqlJoin = "left join\n" +
                    "    cpid.apps_rasp ar\n" +
                    "on\n" +
                    "    a.id=ar.app_id";
            sqlWhere = " and a.status in (110, 135) \n " +
                    " and ar.inspector_id='" + userIdS + "' ";
        }
        if (userRole == 6) {
            sqlWhere = " and a.status=160 \n ";
        }

        String queryForList = "select\n" +
                "    a.id,\n" +
                "    a.instime,\n" +
                "    a.insuser,\n" +
                "    a.isdeleted,\n" +
                "    a.updtime,\n" +
                "    a.upduser,\n" +
                "    a.app_num,\n" +
                "    a.app_date,\n" +
                "    a.customer_country_nm,\n" +
                "    a.customer_country,\n" +
                "    a.location_id,\n" +
                "    a.location_nm,\n" +
                "    a.org_name,\n" +
                "    a.person_addr,\n" +
                "    a.person_fio,\n" +
                "    a.person_mail,\n" +
                "    a.person_phone,\n" +
                "    a.person_pin,\n" +
                "    a.person_position,\n" +
                "    a.person_tin,\n" +
                "    a.seller_org,\n" +
                "    a.sender_country,\n" +
                "    a.sender_country_nm,\n" +
                "    a.sender_org,\n" +
                "    a.status,\n" +
                "    a.status_nm,\n" +
                "    a.terms,\n" +
                "    a.terms_nm,\n" +
                "    a.terms_addr,\n" +
                "    a.trans_exp,\n" +
                "    a.person_id,\n" +
                "    a.comment, \n" +
                "    a.importer_nm, \n" +
                "    a.importer_tin, \n" +
                "    a.app_nums \n" +
                "    " + sqlJoinVal + "\n" +
                "from\n" +
                "    apps a\n" +
                "    " + sqlJoin + "\n" +
                "where\n" +
                "    a.isdeleted=0\n" +
                "" + sqlWhere + "\n " +
                "order by\n" +
                "    a.instime desc";
        return (List<Apps>) entityManager.createNativeQuery(queryForList, Apps.class).getResultList();
    }

    /* 2)Барча статуси "Янги"+"Имзоланган"+"Бекор қилинган" дан ташқари бўлган аризалар*/
    public List getListAppReturned(HttpServletRequest request, String status) {

        Integer userRole = (Integer) request.getSession().getAttribute("userRole");
        String userLocation = (String) request.getSession().getAttribute("userLocation");
        String userPost = (String) request.getSession().getAttribute("userPost");
        String userId = (String) request.getSession().getAttribute("userId");
        String userIdS = (String) request.getSession().getAttribute("userIdS");

        String sqlWhere = "", sqlJoin = "", sqlJoinVal = "";
        if (userRole == 1 || userRole == 2) {
            sqlWhere = " and a.status in (120, 125) \n ";
        }
        if (userRole == 6) {
            sqlWhere = " and a.status in (120, 125) \n and ar.location = '" + userLocation + "' ";
        }
        if (userRole == 7) {
            sqlWhere = " and a.status in (120, 125) \n and ar.location = '" + userLocation + "' and ar.post = '" + userPost + "' ";
        }
        if (userRole == 8) {
            sqlWhere = " and a.status in (120, 125) \n and ar.inspector_id = '" + userIdS + "' and ar.location = '" + userLocation + "' and ar.post = '" + userPost + "' ";
        }

        String queryForList = "select\n" +
                "    a.id,\n" +
                "    a.instime,\n" +
                "    a.insuser,\n" +
                "    a.isdeleted,\n" +
                "    a.updtime,\n" +
                "    a.upduser,\n" +
                "    a.app_num,\n" +
                "    a.app_date,\n" +
                "    a.customer_country_nm,\n" +
                "    a.customer_country,\n" +
                "    a.location_id,\n" +
                "    a.location_nm,\n" +
                "    a.org_name,\n" +
                "    a.person_addr,\n" +
                "    a.person_fio,\n" +
                "    a.person_mail,\n" +
                "    a.person_phone,\n" +
                "    a.person_pin,\n" +
                "    a.person_position,\n" +
                "    a.person_tin,\n" +
                "    a.seller_org,\n" +
                "    a.sender_country,\n" +
                "    a.sender_country_nm,\n" +
                "    a.sender_org,\n" +
                "    a.status,\n" +
                "    a.status_nm,\n" +
                "    a.terms,\n" +
                "    a.terms_nm,\n" +
                "    a.terms_addr,\n" +
                "    a.trans_exp,\n" +
                "    ar.inspector_id   inspector_id,\n" +
                "    ar.inspector_name inspector_name,\n" +
                "    a.comment, \n" +
                "    a.importer_nm, \n" +
                "    a.importer_tin, \n" +
                "    a.app_nums \n" +
                "from\n" +
                "    cpid.apps a\n" +
                "left join\n" +
                "    cpid.apps_rasp ar\n" +
                "on\n" +
                "    a.id=ar.app_id\n" +
                "where\n" +
                " a.isdeleted=0\n" +
                "and ar.id is not null\n" +
                "" + sqlWhere + "\n " +
                "order by\n" +
                "    a.instime desc";
        return entityManager.createNativeQuery(queryForList).getResultList();
    }

    /* 2)Барча статуси "Янги"+"Имзоланган"+"Бекор қилинган" дан ташқари бўлган аризалар*/
    public List getListProcessApp(HttpServletRequest request, String status) {

        Integer userRole = (Integer) request.getSession().getAttribute("userRole");
        String userLocation = (String) request.getSession().getAttribute("userLocation");
        String userPost = (String) request.getSession().getAttribute("userPost");
        String userId = (String) request.getSession().getAttribute("userId");
        String userIdS = (String) request.getSession().getAttribute("userIdS");

        String sqlWhere = "", sqlJoin = "", sqlJoinVal = "";
        if (userRole == 1 || userRole == 2) {
            sqlWhere = " and a.status = " + status + " \n ";
        }
        if (userRole == 6) {
            sqlWhere = " and a.status = " + status + " \n and ar.location = '" + userLocation + "' ";
        }
        if (userRole == 7) {
            sqlWhere = " and a.status = " + status + " \n and ar.location = '" + userLocation + "' and ar.post = '" + userPost + "' ";
        }
        if (userRole == 8) {
            sqlWhere = " and a.status = " + status + " \n and ar.inspector_id = '" + userIdS + "' and ar.location = '" + userLocation + "' and ar.post = '" + userPost + "' ";
        }

        String queryForList = "select\n" +
                "    a.id,\n" +
                "    a.instime,\n" +
                "    a.insuser,\n" +
                "    a.isdeleted,\n" +
                "    a.updtime,\n" +
                "    a.upduser,\n" +
                "    a.app_num,\n" +
                "    a.app_date,\n" +
                "    a.customer_country_nm,\n" +
                "    a.customer_country,\n" +
                "    a.location_id,\n" +
                "    a.location_nm,\n" +
                "    a.org_name,\n" +
                "    a.person_addr,\n" +
                "    a.person_fio,\n" +
                "    a.person_mail,\n" +
                "    a.person_phone,\n" +
                "    a.person_pin,\n" +
                "    a.person_position,\n" +
                "    a.person_tin,\n" +
                "    a.seller_org,\n" +
                "    a.sender_country,\n" +
                "    a.sender_country_nm,\n" +
                "    a.sender_org,\n" +
                "    a.status,\n" +
                "    a.status_nm,\n" +
                "    a.terms,\n" +
                "    a.terms_nm,\n" +
                "    a.terms_addr,\n" +
                "    a.trans_exp,\n" +
                "    ar.inspector_id   inspector_id,\n" +
                "    ar.inspector_name inspector_name,\n" +
                "    a.comment, \n" +
                "    a.importer_nm, \n" +
                "    a.importer_tin, \n" +
                "    a.app_nums \n" +
                "from\n" +
                "    cpid.apps a\n" +
                "left join\n" +
                "    cpid.apps_rasp ar\n" +
                "on\n" +
                "    a.id=ar.app_id\n" +
                "where\n" +
                " a.isdeleted=0\n" +
                "and ar.id is not null\n" +
                "" + sqlWhere + "\n " +
                "order by\n" +
                "    a.instime desc";
        return entityManager.createNativeQuery(queryForList).getResultList();
    }

    /* 4) <<app_num>> га ариза рақамини киритади */
    public Apps saveApps(Apps apps) {
        LocalDateTime now = LocalDateTime.now();
        String appsNum = getMaxNumberApp();
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
        currentDateFormat = currentDateFormat + appsNum;
        apps.setAppNum(currentDateFormat);
        return appsRepo.save(apps);
    }

    /*todo 4.1) <<app_num>> га ариза рақамини генерация қилиш (1726/01.08.2022/000001) */
    public Apps saveAppsS(Apps apps) {
        String appNum = getMaxNumberAppS(apps.getLocationId(), apps.getAppDate());
        String appNumS = "";
        appNumS = apps.getLocationId() + "/" + Utils.toDate(apps.getAppDate()) + "/" + appNum;
        apps.setAppNum(appNumS);
        apps.setAppNumS(appNum);
        return appsRepo.save(apps);
    }

    /* 5) <<app_num>> учун рақам генерация қилади */
    public String getMaxNumberApp() {
        String queryForList = "select\n" +
                "    a.APP_NUM as maxno\n" +
                "from\n" +
                "    CPID.Apps as a\n" +
                "order by\n" +
                "    a.instime desc\n" +
                "fetch\n" +
                "    first 1 rows only";
        List resultList = entityManager.createNativeQuery(queryForList).getResultList();
        String lastNumber = "000001";
        if (resultList.size() > 0) {
            lastNumber = String.valueOf(resultList.get(0));
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

    /*todo 5.1) <<app_num>> га ариза рақамини генерация қилиш (1726/01.08.2022/000001) */
    public String getMaxNumberAppS(String locationId, Date appDate) {
        String queryForList = "select\n" +
                "    right('000000'||((\n" +
                "    case\n" +
                "        when(\n" +
                "                max(cast(substring(t.app_num, 18, 6) as int)))\n" +
                "            is not null\n" +
                "        then(max(cast(substring(t.app_num, 18, 6) as int)))\n" +
                "        else 0\n" +
                "    end) +1), 6) maxno\n" +
                "from\n" +
                "    (   select\n" +
                "            p.*\n" +
                "        from\n" +
                "            cpid.apps p\n" +
                "        where\n" +
                "            p.location_id = '" + locationId + "') t\n" +
                "where\n" +
                "    t.location_id = '" + locationId + "'\n" +
                "and t.app_nums||year(t.app_date) = t.app_nums||year(current_date) \n" +
                "and year('" + Utils.toDate00(appDate) + "') = year(current_date)";
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

    public Apps saveAppsOne(Apps apps) {
        return appsRepo.save(apps);
    }

    /* 6) <<Мурожаатлар, Тақсимланган мурожаатларб Даст.қарор.реестри>> учун битта "id" бўйича тўлиқ малумот */
    public List<Apps> getInitialDecisionView(String app_id) {
        String queryForList = "";
        queryForList = "select\n" +
                /*0 - */"    a.id,\n" +
                /*1- */"    a.app_num,\n" +
                /*2- */"    a.app_date,\n" +
                /*3- */"    a.customer_country_nm,\n" +
                /*4- */"    a.customer_country,\n" +
                /*5- */"    a.location_id,\n" +
                /*6- */"    a.location_nm,\n" +
                /*7- */"    a.org_name,\n" +
                /*8- */"    a.person_addr,\n" +
                /*9- */"    a.person_fio,\n" +
                /*10 - */"    a.person_mail,\n" +
                /*11 - */"    a.person_phone,\n" +
                /*12 - */"    a.person_pin,\n" +
                /*13 - */"    a.person_position,\n" +
                /*14 - */"    a.person_tin,\n" +
                /*15 - */"    a.seller_org,\n" +
                /*16 - */"    a.sender_country,\n" +
                /*17 - */"    a.sender_country_nm,\n" +
                /*18 - */"    a.sender_org,\n" +
                /*19 - */"    a.status,\n" +
                /*20 - */"    a.status_nm,\n" +
                /*21 - */"    a.terms,\n" +
                /*22 - */"    a.terms_nm,\n" +
                /*23 - */"    a.terms_addr,\n" +
                /*24 - */"    a.trans_exp,\n" +
                /*25 - */"    a.person_id,\n" +
                /*26 - */"    a.instime,\n" +
                /*27 - */"    sum(cm.netto)  allnetto,\n" +
                /*28 - */"    sum(cm.brutto) allbrutto,\n" +
                /*29 - */"    sum(cm.price)  allprice,\n" +
                /*30 - */"    sum(cm.customs_price)  allcustoms_price,\n" +
                /*31 - */"    count(cm.id)   cntcmdt,\n" +
                /*32 - */"    cm.currency_nm,\n" +
                /*33 - */"    a.comment, \n" +
                /*34 - */"    a.importer_nm, \n" +
                /*35 - */"    a.importer_tin, \n" +
                /*36 - */"    a.version_Num, \n" +
                /*37 - */"    a.authorized_person_pin, \n" +
                /*38 - */"    a.authorized_person_doc, \n" +
                /*39 - */"    a.state_number, \n" +
                /*40 - */"    a.state_number_date, \n" +
                /*41 - */"    a.app_nums \n" +
                "from\n" +
                "    apps a\n" +
                "left join\n" +
                "    cpid.commodity cm\n" +
                "on\n" +
                "    a.id = cm.app_id\n" +
                "and cm.isdeleted=0\n" +
                "where\n" +
                "    a.id = '" + app_id + "' \n" +
                "and a.isdeleted=0\n" +
                "group by\n" +
                "    a.id,\n" +
                "    a.app_num,\n" +
                "    a.app_date,\n" +
                "    a.customer_country_nm,\n" +
                "    a.customer_country,\n" +
                "    a.location_id,\n" +
                "    a.location_nm,\n" +
                "    a.org_name,    \n" +
                "    a.person_addr,\n" +
                "    a.person_fio,\n" +
                "    a.person_mail,\n" +
                "    a.person_phone,\n" +
                "    a.person_pin,\n" +
                "    a.person_position,\n" +
                "    a.person_tin,\n" +
                "    a.seller_org,\n" +
                "    a.sender_country,\n" +
                "    a.sender_country_nm,\n" +
                "    a.sender_org,\n" +
                "    a.status,    \n" +
                "    a.status_nm,    \n" +
                "    a.terms,\n" +
                "    a.terms_nm,\n" +
                "    a.terms_addr,\n" +
                "    a.trans_exp,\n" +
                "    a.person_id, \n" +
                "    a.instime,\n" +
       /*32 - */"    cm.currency_nm,\n" +
                "    a.comment, \n" +
                "    a.importer_nm, \n" +
                "    a.importer_tin, \n" +
                "    a.version_Num, \n" +
                "    a.authorized_person_pin, \n" +
                "    a.authorized_person_doc, \n" +
                "    a.state_number, \n" +
                "    a.state_number_date, \n" +
                "    a.app_nums \n" +
                "order by\n" +
                "    a.instime desc";
        return (List<Apps>) entityManager.createNativeQuery(queryForList).getResultList();
//        return (List<Apps>) entityManager.createNativeQuery(queryForList, Apps.class).getResultList();
    }

    /* 7) Битта Ариза "id" бўйича барча товарлар */
    public List<Commodity> getInitialDecisionViewCommodity(String app_id) {
        String queryForList = "select\n" +
                /*0 - */"    c.id,\n" +
                /*1 - */"    c.instime,\n" +
                /*2 - */"    c.insuser,\n" +
                /*3 - */"    c.isdeleted,\n" +
                /*4 - */"    c.updtime,\n" +
                /*5 - */"    c.upduser,\n" +
                /*6 - */"    c.app_id,\n" +
                /*7 - */"    c.article,\n" +
                /*8 - */"    c.basic_qty,\n" +
                /*9 - */"    c.brutto,\n" +
                /*10 - */"    c.cargo_space,\n" +
                /*11 - */"    c.cmdt_num,\n" +
                /*12 - */"    c.com_prop,\n" +
                /*13 - */"    c.currency_type,\n" +
                /*14 - */"    c.extra_info,\n" +
                /*15 - */"    c.extra_qty,\n" +
                /*16 - */"    c.extra_units,\n" +
                /*17 - */"    c.functions,\n" +
                /*18 - */"    c.hs_code,\n" +
                /*19 - */"    c.hs_dec_date,\n" +
                /*20 - */"    c.hs_dec_num,\n" +
                /*21 - */"    c.in_dec_date,\n" +
                /*22 - */"    c.in_dec_num,\n" +
                /*23 - */"    c.HS_NAME, \n" +
                /*24 - */"    c.mark,\n" +
                /*25 - */"    c.method,\n" +
                /*26 - */"    c.method_nm,\n" +
                /*27 - */"    c.model,\n" +
                /*28 - */"    c.netto,\n" +
                /*29 - */"    c.origin_country,\n" +
                /*30 - */"    c.origin_org,\n" +
                /*31 - */"    c.origin_country_nm,\n" +
                /*32 - */"    c.pack_qty,\n" +
                /*33 - */"    c.pack_type,\n" +
                /*34 - */"    c.pack_type_nm,\n" +
                /*35 - */"    c.price,\n" +
                /*36 - */"    c.product_goal,\n" +
                /*37 - */"    c.sort,\n" +
                /*38 - */"    c.standarts,\n" +
                /*39 - */"    c.tech_char,\n" +
                /*40 - */"    c.trade_mark,\n" +
                /*41 - */"    c.trade_name,\n" +
                /*42 - */"    c.payment_yn,\n" +
                /*43 - */"    c.method_description,\n" +
                /*44 - */"    c.currency_nm, \n" +
                /*45 - */"    c.currency_nmsymbol, \n" +
                /*46 - */"    c.customs_price, \n" +
                /*47 - */"    c.method_url, \n" +
                /*48 - */"    c.method_url_discription \n" +
                "from\n" +
                "    cpid.commodity c\n" +
                "left join\n" +
                "    cpid.apps a\n" +
                "on\n" +
                "    c.app_id = a.id\n" +
                "and a.isdeleted = 0\n" +
                "where\n" +
                "    c.app_id = '" + app_id + "'\n" +
                "and c.isdeleted = 0";
        return (List<Commodity>) entityManager.createNativeQuery(queryForList, Commodity.class).getResultList();
    }

    /* 8) Битта товар "id" бўйича барча товар маълумотлари */
    public List<Commodity> getCommodityList(String app_id) {
        String queryForList = "select\n" +
                /*0 - */"    c.id, \n" +
                /*1 - */"    c.instime, \n" +
                /*2 - */"    c.insuser, \n" +
                /*3 - */"    c.isdeleted, \n" +
                /*4 - */"    c.updtime, \n" +
                /*5 - */"    c.upduser, \n" +
                /*6 - */"    c.app_id, \n" +
                /*7 - */"    c.article, \n" +
                /*8 - */"    c.basic_qty, \n" +
                /*9 - */"    c.brutto, \n" +
                /*10 - */"    c.cargo_space, \n" +
                /*11 - */"    c.cmdt_num, \n" +
                /*12 - */"    c.com_prop, \n" +
                /*13 - */"    c.currency_type, \n" +
                /*14 - */"    c.extra_info, \n" +
                /*15 - */"    c.extra_qty, \n" +
                /*16 - */"    c.extra_units, \n" +
                /*17 - */"    c.functions, \n" +
                /*18 - */"    c.hs_code, \n" +
                /*19 - */"    c.hs_dec_date, \n" +
                /*20 - */"    c.hs_dec_num, \n" +
                /*21 - */"    c.in_dec_date,\n" +
                /*22 - */"    c.in_dec_num,\n" +
                /*23 - */"    c.HS_NAME, \n" +
                /*24 - */"    c.mark, \n" +
                /*25 - */"    c.method, \n" +
                /*26 - */"    c.method_nm, \n" +
                /*27 - */"    c.model, \n" +
                /*28 - */"    c.netto, \n" +
                /*29 - */"    c.origin_country, \n" +
                /*30 - */"    c.origin_org, \n" +
                /*31 - */"    c.origin_country_nm, \n" +
                /*32 - */"    c.pack_qty, \n" +
                /*33 - */"    c.pack_type, \n" +
                /*34 - */"    c.pack_type_nm, \n" +
                /*35 - */"    c.price, \n" +
                /*36 - */"    c.product_goal, \n" +
                /*37 - */"    c.sort, \n" +
                /*38 - */"    c.standarts, \n" +
                /*39 - */"    c.tech_char, \n" +
                /*40 - */"    c.trade_mark, \n" +
                /*41 - */"    c.trade_name,\n" +
                /*42 - */"    c.method_description,\n" +
                /*42 - */"    c.customs_price,\n" +
                /*43 - */"    c.method_url, \n" +
                /*44 - */"    c.method_url_discription \n" +

                "from\n" +
                "    cpid.commodity c\n" +
                "left join\n" +
                "    cpid.apps a\n" +
                "on\n" +
                "    c.app_id = a.id\n" +
                "and a.isdeleted = 0\n" +
                "where\n" +
                "    c.app_id = '" + app_id + "'\n" +
                "and c.isdeleted = 0";
        return (List<Commodity>) entityManager.createNativeQuery(queryForList, Commodity.class).getResultList();
    }

    /* 3) Статуси фақат "Имзоланган"+"Бекор қилинган" бўлган аризалар*/
    public List<Apps> getlistAllIsp(String inspectorId) {
        String queryForList = "select\n" +
                "    a.id,\n" + /*0-id*/
                "    a.instime,\n" + /*1-instime*/
                "    a.insuser,\n" + /*2-insuser*/
                "    a.isdeleted,\n" + /*3-isdeleted*/
                "    a.updtime,\n" + /*4-updtime*/
                "    a.upduser,\n" + /*5-upduser*/
                "    a.app_num,\n" + /*6-app_num*/
                "    a.app_date,\n" + /*7-app_date*/
                "    a.customer_country_nm,\n" + /*8-customer_country_nm*/
                "    a.customer_country,\n" + /*9-customer_country*/
                "    a.location_id,\n" + /*10-location_id*/
                "    a.location_nm,\n" + /*11-location_nm*/
                "    a.org_name, \n" + /*12-org_name*/
                "    a.person_addr,\n" + /*13-person_addr*/
                "    a.person_fio,\n" + /*14-person_fio*/
                "    a.person_mail,\n" + /*15-person_mail*/
                "    a.person_phone,\n" + /*16-person_phone*/
                "    a.person_pin,\n" + /*17-person_pin*/
                "    a.person_position,\n" + /*18-person_position*/
                "    a.person_tin,\n" + /*19-person_tin*/
                "    a.seller_org,\n" + /*20-seller_org*/
                "    a.sender_country,\n" + /*21-sender_country*/
                "    a.sender_country_nm,\n" + /*22-sender_country_nm*/
                "    a.sender_org,\n" + /*23-sender_org*/
                "    a.status,\n" + /*24-status*/
                "    a.terms_nm,\n" + /*25-terms_nm*/
                "    a.terms_addr,\n" + /*26-terms_addr*/
                "    a.trans_exp,\n" + /*27-trans_exp*/
                "    a.status_nm,\n" + /*28-status_nm*/
                "    ar.inspector_id inspector_id,\n" + /*29-inspector_id*/
                "    ar.inspector_name inspector_name,\n" + /*30-inspector_name*/
                "    a.comment, \n" +
                "    a.importer_nm, \n" +
                "    a.importer_tin, \n" +
                "    a.app_nums \n" +
                "from\n" +
                "    cpid.apps a\n" +
                "left join\n" +
                "    cpid.apps_rasp ar\n" +
                "on\n" +
                "    a.id=ar.app_id\n" +
                "where\n" +
                "    a.isdeleted=0\n" +
                "    and ar.inspector_id='" + inspectorId + "'\n" +
                "and a.status = 110\n" +
                "order by\n" +
                "    a.instime desc";
        return (List<Apps>) entityManager.createNativeQuery(queryForList).getResultList();
    }

    public Apps findById(String id) {
        if (appsRepo.findById(id).isPresent())
            return appsRepo.findById(id).get();
        else return null;
    }

    public Apps saveAppsStatus(Apps apps) {
        return appsRepo.save(apps);
    }

    /* 8) Битта товар "id" бўйича барча товар маълумотлари */
    public List<Docs> getDocsListAppId(String appId) {
        String queryForList = "select\n" +
                "    d.id, \n" +
                "    d.instime, \n" +
                "    d.insuser, \n" +
                "    d.isdeleted, \n" +
                "    d.updtime, \n" +
                "    d.upduser, \n" +
                "    d.app_id, \n" +
                "    d.doc_date, \n" +
                "    d.doc_format, \n" +
                "    d.doc_name, \n" +
                "    d.doc_name_ex, \n" +
                "    d.doc_number, \n" +
                "    d.doc_path, \n" +
                "    d.doc_size, \n" +
                "    d.doc_srno, \n" +
                "    d.doc_type, \n" +
                "    d.hash256\n" +
                "from\n" +
                "    cpid.docs d\n" +
                "where\n" +
                "    d.app_id = '" + appId + "'\n" +
                "and d.isdeleted = 0";
        return (List<Docs>) entityManager.createNativeQuery(queryForList, Docs.class).getResultList();
    }

    /* 9) Статуси фақат "Имзоланган" бўлган аризалар*/
    public List<InDec> getListInDec(HttpServletRequest request) {
        Integer userRole = (Integer) request.getSession().getAttribute("userRole");
        String userLocation = (String) request.getSession().getAttribute("userLocation");
        String userPost = (String) request.getSession().getAttribute("userPost");

        String sql_os = "";
        if (userRole >= 6) sql_os = " and i.in_dec_location = '" + userLocation + "' ";

        String queryForList = "select\n" +
                "    a.id,\n" +
                "    a.instime,\n" +
                "    a.insuser,\n" +
                "    a.isdeleted,\n" +
                "    a.updtime,\n" +
                "    a.upduser,\n" +
                "    a.app_num,\n" +
                "    a.app_date,\n" +
                "    a.customer_country_nm,\n" +
                "    a.customer_country,\n" +
                "    a.location_id,\n" +
                "    a.location_nm,\n" +
                "    a.org_name,\n" +
                "    a.person_addr,\n" +
                "    a.person_fio,\n" +
                "    a.person_mail,\n" +
                "    a.person_phone,\n" +
                "    a.person_pin,\n" +
                "    a.person_position,\n" +
                "    a.person_tin,\n" +
                "    a.seller_org,\n" +
                "    a.sender_country,\n" +
                "    a.sender_country_nm,\n" +
                "    a.sender_org,\n" +
                "    a.status,\n" +
                "    a.terms_nm,\n" +
                "    a.terms_addr,\n" +
                "    a.trans_exp,\n" +
                "    a.status_nm,\n" +
                "    ar.inspector_id   inspector_id,\n" +
                "    ar.inspector_name inspector_name,\n" +
                "    a.comment,\n" +
                "    cmdt.id cmdt_id,\n" +
                "    i.id indec_id,\n" +
                "    i.instime indec_instime,\n" +
                "    i.insuser indec_insuser,\n" + //35
                "    i.isdeleted indec_isdeleted,\n" +
                "    i.updtime indec_updtime,\n" +
                "    i.upduser indec_upduser,\n" +
                "    i.comment_marks,\n" +
                "    i.customs_payments,\n" +
                "    i.customs_preference,\n" +
                "    i.hs_code,\n" +
                "    i.hs_name,\n" +
                "    i.in_dec_basis,\n" +
                "    i.in_dec_date,\n" +
                "    i.in_dec_location,\n" +
                "    i.in_dec_location_nm,\n" +
                "    i.in_dec_num,\n" +
                "    i.method,\n" +
                "    i.method_nm,\n" +
                "    i.origin_country,\n" +
                "    i.origin_country_nm,\n" +
                "    i.person_id,\n" +
                "    i.status indec_status,\n" +  //54
                "    i.status_nm indec_status_nm,\n" +
                "    i.in_dec_end_date,\n" +
                "    i.IN_DEC_USR_ENDED_DATE,\n" +
                "    i.COMMENT_ENDED,\n" +
                "    i.END_ACTIV,\n" +
                "    i.g3a,\n" +
                "    char(i.g3b, eur) g3b,\n" +
                "    i.g3c g3c,\n" +
                "    a.importer_nm, \n" +
                "    a.importer_tin, \n" +
                "    a.app_nums, \n" +
                "    i.in_dec_nums \n" +
                "from\n" +
                "    cpid.in_dec i\n" +
                "left join\n" +
                "    cpid.commodity cmdt\n" +
                "on\n" +
                "    cmdt.id=i.cmdt_id\n" +
                "and cmdt.isdeleted=0\n" +
                "left join\n" +
                "    cpid.apps a\n" +
                "on\n" +
                "    a.id=cmdt.app_id\n" +
                "and a.isdeleted=0\n" +
                "left join\n" +
                "    cpid.apps_rasp ar\n" +
                "on\n" +
                "    a.id=ar.app_id\n" +
                "where\n" +
                "    i.isdeleted=0\n" +
                "and a.status = 170\n" +
                "and i.end_activ = 100\n" +
                "" + sql_os + "\n " +
                "order by\n" +
                "    a.instime desc";
        return (List<InDec>) entityManager.createNativeQuery(queryForList).getResultList();
    }

    /* 10) Статуси фақат "Бекор қилинган" бўлган аризалар*/
    public List<InDec> getListInDecRollBack(HttpServletRequest request) {

        Integer userRole = (Integer) request.getSession().getAttribute("userRole");
        String userLocation = (String) request.getSession().getAttribute("userLocation");
        String userPost = (String) request.getSession().getAttribute("userPost");

        String sql_os = "";
        if (userRole >= 6) sql_os = " and i.in_dec_location = '" + userLocation + "' ";

        String queryForList = "select\n" +
                "    a.id,\n" +
                "    a.instime,\n" +
                "    a.insuser,\n" +
                "    a.isdeleted,\n" +
                "    a.updtime,\n" +
                "    a.upduser,\n" +
                "    a.app_num,\n" +
                "    a.app_date,\n" +
                "    a.customer_country_nm,\n" +
                "    a.customer_country,\n" +
                /*10*/"    a.location_id,\n" +
                "    a.location_nm,\n" +
                "    a.org_name,\n" +
                "    a.person_addr,\n" +
                "    a.person_fio,\n" +
                "    a.person_mail,\n" +
                "    a.person_phone,\n" +
                "    a.person_pin,\n" +
                "    a.person_position,\n" +
                "    a.person_tin,\n" +
                /*20*/"    a.seller_org,\n" +
                "    a.sender_country,\n" +
                "    a.sender_country_nm,\n" +
                "    a.sender_org,\n" +
                "    a.status,\n" +
                "    a.terms_nm,\n" +
                "    a.terms_addr,\n" +
                "    a.trans_exp,\n" +
                "    a.status_nm,\n" +
                "    ar.inspector_id   inspector_id,\n" +
                "    ar.inspector_name inspector_name,\n" +
                "    a.comment,\n" +
                /*32*/"    cmdt.id cmdt_id,\n" +
                "    i.id indec_id,\n" +
                "    i.instime indec_instime,\n" +
                "    i.insuser indec_insuser,\n" +
                "    i.isdeleted indec_isdeleted,\n" +
                "    i.updtime indec_updtime,\n" +
                "    i.upduser indec_upduser,\n" +
                "    i.comment_marks,\n" +
                /*40*/"    i.customs_payments,\n" +
                "    i.customs_preference,\n" +
                "    i.hs_code,\n" +
                "    i.hs_name,\n" +
                "    i.in_dec_basis,\n" +
                "    i.in_dec_date,\n" +
                "    i.in_dec_location,\n" +
                "    i.in_dec_location_nm,\n" +
                "    i.in_dec_num,\n" +
                "    i.method,\n" +
                /*50*/"    i.method_nm,\n" +
                "    i.origin_country,\n" +
                "    i.origin_country_nm,\n" +
                "    i.person_id,\n" +
                "    i.status indec_status,\n" +
                "    i.status_nm indec_status_nm,\n" +
                "    i.in_dec_end_date,\n" +
                "    i.IN_DEC_USR_ENDED_DATE,\n" +
                "    i.COMMENT_ENDED,\n" +
                "    i.END_ACTIV, \n" +
                "    a.importer_nm, \n" +
                "    a.importer_tin, \n" +
                "    a.app_nums, \n" +
                "    i.in_dec_nums \n" +
                "from\n" +
                "    cpid.in_dec i\n" +
                "left join\n" +
                "    cpid.commodity cmdt\n" +
                "on\n" +
                "    cmdt.id=i.cmdt_id\n" +
                "and cmdt.isdeleted=0\n" +
                "left join\n" +
                "    cpid.apps a\n" +
                "on\n" +
                "    a.id=cmdt.app_id\n" +
                "and a.isdeleted=0\n" +
                "left join\n" +
                "    cpid.apps_rasp ar\n" +
                "on\n" +
                "    a.id=ar.app_id\n" +
                "where\n" +
                "    i.isdeleted=0\n" +
                "and a.status = 170\n" +
                "and i.end_activ = 200\n" +
                "" + sql_os + "\n " +
                "order by\n" +
                "    a.instime desc";
        return (List<InDec>) entityManager.createNativeQuery(queryForList).getResultList();
    }

    /* 2)Барча статуси "Янги"+"Имзоланган"+"Бекор қилинган" дан ташқари бўлган аризалар*/
    public List getListSorted(HttpServletRequest request) {

        Integer userRole = (Integer) request.getSession().getAttribute("userRole");
        String userLocation = (String) request.getSession().getAttribute("userLocation");
        String userPost = (String) request.getSession().getAttribute("userPost");
        String userId = (String) request.getSession().getAttribute("userId");
        String userIdS = (String) request.getSession().getAttribute("userIdS");

        String sqlWhere = "", sqlJoin = "", sqlJoinVal = "";
        if (userRole == 1 || userRole == 2) {
            sqlWhere = " and a.status not in (100, 115, 170, 175) \n ";
        }
        if (userRole == 7) {
            sqlWhere = " and a.status not in (100, 115, 170, 175, 135) \n and ar.location = '" + userLocation + "' and ar.post = '" + userPost + "' ";
        }
        if (userRole == 8) {
            sqlWhere = " and a.status in (110, 135) \n and ar.inspector_id = '" + userIdS + "' and ar.location = '" + userLocation + "' and ar.post = '" + userPost + "' ";
        }

        String queryForList = "select\n" +
                "    a.id,\n" +
                "    a.instime,\n" +
                "    a.insuser,\n" +
                "    a.isdeleted,\n" +
                "    a.updtime,\n" +
                "    a.upduser,\n" +
                "    a.app_num,\n" +
                "    a.app_date,\n" +
                "    a.customer_country_nm,\n" +
                "    a.customer_country,\n" +
                "    a.location_id,\n" +
                "    a.location_nm,\n" +
                "    a.org_name,\n" +
                "    a.person_addr,\n" +
                "    a.person_fio,\n" +
                "    a.person_mail,\n" +
                "    a.person_phone,\n" +
                "    a.person_pin,\n" +
                "    a.person_position,\n" +
                "    a.person_tin,\n" +
                "    a.seller_org,\n" +
                "    a.sender_country,\n" +
                "    a.sender_country_nm,\n" +
                "    a.sender_org,\n" +
                "    a.status,\n" +
                "    a.status_nm,\n" +
                "    a.terms,\n" +
                "    a.terms_nm,\n" +
                "    a.terms_addr,\n" +
                "    a.trans_exp,\n" +
                "    ar.inspector_id   inspector_id,\n" +
                "    ar.inspector_name inspector_name,\n" +
                "    a.comment, \n" +
                "    a.importer_nm, \n" +
                "    a.importer_tin, \n" +
                "    a.app_nums \n" +
                "from\n" +
                "    cpid.apps a\n" +
                "left join\n" +
                "    cpid.apps_rasp ar\n" +
                "on\n" +
                "    a.id=ar.app_id\n" +
                "where\n" +
                " a.isdeleted=0\n" +
                "and ar.id is not null\n" +
                "" + sqlWhere + "\n " +
                "order by\n" +
                "    a.instime desc";
        return entityManager.createNativeQuery(queryForList).getResultList();
    }

    /* ApiРеестр учун барча Д-Қарорлар */
    public List<InDec> getInDecForApi() {
        String queryForList = "select\n" +
                "    a.id,\n" +
                "    a.instime,\n" +
                "    a.insuser,\n" +
                "    a.isdeleted,\n" +
                "    a.updtime,\n" +
                "    a.upduser,\n" +
                "    a.app_num,\n" +
                "    a.app_date,\n" +
                "    a.customer_country_nm,\n" +
                "    a.customer_country,\n" +
                /*10*/"    a.location_id,\n" +
                "    a.location_nm,\n" +
                "    a.org_name,\n" +
                "    a.person_addr,\n" +
                "    a.person_fio,\n" +
                "    a.person_mail,\n" +
                "    a.person_phone,\n" +
                "    a.person_pin,\n" +
                "    a.person_position,\n" +
                "    a.person_tin,\n" +
                /*20*/"    a.seller_org,\n" +
                "    a.sender_country,\n" +
                "    a.sender_country_nm,\n" +
                "    a.sender_org,\n" +
                "    a.status,\n" +
                "    a.terms_nm,\n" +
                "    a.terms_addr,\n" +
                "    a.trans_exp,\n" +
                "    a.status_nm,\n" +
                "    ar.inspector_id   inspector_id,\n" +
                "    ar.inspector_name inspector_name,\n" +
                "    a.comment,\n" +
                /*32*/"    cmdt.id cmdt_id,\n" +
                "    i.id indec_id,\n" +
                "    i.instime indec_instime,\n" +
                "    i.insuser indec_insuser,\n" +
                "    i.isdeleted indec_isdeleted,\n" +
                "    i.updtime indec_updtime,\n" +
                "    i.upduser indec_upduser,\n" +
                "    i.comment_marks,\n" +
                /*40*/"    i.customs_payments,\n" +
                "    i.customs_preference,\n" +
                "    i.hs_code,\n" +
                "    i.hs_name,\n" +
                "    i.in_dec_basis,\n" +
                "    i.in_dec_date,\n" +
                "    i.in_dec_location,\n" +
                "    i.in_dec_location_nm,\n" +
                "    i.in_dec_num,\n" +
                "    i.method,\n" +
                /*50*/"    i.method_nm,\n" +
                "    i.origin_country,\n" +
                "    i.origin_country_nm,\n" +
                "    i.person_id,\n" +
                "    i.status indec_status,\n" +
                "    i.status_nm indec_status_nm,\n" +
                "    i.in_dec_end_date,\n" +
                "    i.IN_DEC_USR_ENDED_DATE,\n" +
                "    i.COMMENT_ENDED,\n" +
                "    i.END_ACTIV, \n" +
                "    a.importer_nm, \n" +
                "    a.importer_tin, \n" +
                "    a.app_nums, \n" +
                "    i.in_dec_nums \n" +
                "from\n" +
                "    cpid.in_dec i\n" +
                "left join\n" +
                "    cpid.commodity cmdt\n" +
                "on\n" +
                "    cmdt.id=i.cmdt_id\n" +
                "and cmdt.isdeleted=0\n" +
                "left join\n" +
                "    cpid.apps a\n" +
                "on\n" +
                "    a.id=cmdt.app_id\n" +
                "and a.isdeleted=0\n" +
                "left join\n" +
                "    cpid.apps_rasp ar\n" +
                "on\n" +
                "    a.id=ar.app_id\n" +
                "where\n" +
                "    i.isdeleted=0\n" +
                "and a.status = 170\n" +
                "and i.end_activ in (200, 100)\n" +
                "order by\n" +
                "    a.instime desc";
        return (List<InDec>) entityManager.createNativeQuery(queryForList).getResultList();
    }

    public List<Apps> getByAppNum(String appNum) {
        if (appsRepo.findByAppNum(appNum) != null){
            return appsRepo.findByAppNum(appNum);
        }else return null;
    }

    public Apps getTop1ByAppNumOrderByInsTimeAsc(String appNum) {
        if (appsRepo.findTop1ByAppNumOrderByInsTimeAsc(appNum) != null){
            return appsRepo.findTop1ByAppNumOrderByInsTimeAsc(appNum);
        }else return null;
    }

    public Apps getByAppNumAndStatus(String appNum, int status) {
        if (appsRepo.findByAppNumAndStatus(appNum, status) != null){
            return appsRepo.findByAppNumAndStatus(appNum, status);
        }else return null;
    }

    public List<Apps> getAllApps() {
        if (appsRepo.findAll() != null){
            return appsRepo.findAll();
        }else return null;
    }

//    public Apps getByCmdtId(String cmdtId) {
//        return appsRepo.findByCmdtId(cmdtId);
//    }

//    public Apps getByLocationIdAndStatus(String locationForStatisticBar, List<Integer> statusForStatisticsBar) {
//        if (appsRepo.tewtgftryrt(locationForStatisticBar, statusForStatisticsBar) != null){
//            return appsRepo.tewtgftryrt(locationForStatisticBar, statusForStatisticsBar);
//        }else {return null;}
//    }
}

