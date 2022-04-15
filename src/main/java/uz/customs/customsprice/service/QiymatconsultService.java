package uz.customs.customsprice.service;

import org.springframework.stereotype.Service;
import uz.customs.customsprice.entity.Digests.QiymatconsultEntity;
import uz.customs.customsprice.repository.QiymatconsultRepo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class QiymatconsultService {
    private final QiymatconsultRepo qiymatconsultRepo;

    @PersistenceContext(unitName = "digests")
    private EntityManager entityManagerDigests;

    public QiymatconsultService(QiymatconsultRepo qiymatconsultRepo) {
        this.qiymatconsultRepo = qiymatconsultRepo;
    }

    public List<QiymatconsultEntity> getListQiymatReject(){
        String queryForList = "select\n" +
        "    qm.g7a||'/'||char(date(qm.g7b),eur)||'/'||qm.g7c gtd,\n" +
                "    qm.regnum,\n" +
                "    qm.msg,\n" +
                "    qm.instime,\n" +
                "    qm.user_id,\n" +
                "    qr.sabab1,\n" +
                "    qr.sabab2,\n" +
                "    qr.sabab3,\n" +
                "    qr.sabab4,\n" +
                "    qr.shartli,\n" +
                "    qt.g22a,\n" +
                "    qt.g22b,\n" +
                "    sum(qt.g38),\n" +
                "    sum(qt.g35),\n" +
                "    count(qt.id),\n" +
                "    qm.decl_id \n"+
                "from\n" +
                "    epigued.qiymatmsg qm\n" +
                "left join\n" +
                "    epigued.qiymattovar qt\n" +
                "on\n" +
                "    qt.decl_id = qm.decl_id\n" +
                "left join\n" +
                "    epigued.qiymatreject qr\n" +
                "on\n" +
                "    qr.decl_id = qt.decl_id\n" +
                "where\n" +
                "    qt.status=1\n" +
                "and qm.msg_type = 1\n" +
                "group by\n" +
                "    qm.g7a||'/'||char(date(qm.g7b),eur)||'/'||qm.g7c,\n" +
                "    qm.regnum,\n" +
                "    qm.msg,\n" +
                "    qm.instime,\n" +
                "    qm.user_id,\n" +
                "    qr.sabab1,\n" +
                "    qr.sabab2,\n" +
                "    qr.sabab3,\n" +
                "    qr.sabab4,\n" +
                "    qr.shartli,\n" +
                "    qt.g22a,\n" +
                "    qt.g22b,\n"+
                "    qm.decl_id";
        return (List<QiymatconsultEntity>) entityManagerDigests.createNativeQuery(queryForList).getResultList();
    }

    public List<QiymatconsultEntity> getListQiymatconsulting(){
        String queryForList = "select\n" +
                "    qm.g7a||'/'||char(date(qm.g7b),eur)||'/'||qm.g7c gtd,\n" +
                "    qm.regnum,\n" +
                "    qm.msg,\n" +
                "    qm.instime,\n" +
                "    qm.user_id,\n" +
                "    sum(distinct(qc.jami)),\n" +
                "    sum(distinct(qc.dastlabki)),\n" +
                "    sum(distinct(qt.g35))  netto,\n" +
                "    sum(distinct(qt.g38))  brutto,\n" +
                "    count(distinct(qt.id)) tovar_soni,\n" +
                "    qm.decl_id \n" +
                "from\n" +
                "    epigued.qiymatmsg qm\n" +
                "left join\n" +
                "    epigued.qiymattovar qt\n" +
                "on\n" +
                "    qt.decl_id = qm.decl_id\n" +
                "     \n" +
                "\n" +
                "left join\n" +
                "    epigued.qiymatconsult qc\n" +
                "on\n" +
                "    qc.decl_id = qm.decl_id\n" +
                "where\n" +
                "    qm.msg_type = 2\n" +
                "group by\n" +
                "    qm.g7a||'/'||char(date(qm.g7b),eur)||'/'||qm.g7c,\n" +
                "    qm.regnum,\n" +
                "    qm.msg,\n" +
                "    qm.instime,\n" +
                "    qm.user_id,\n"+
                "    qm.decl_id";
        return (List<QiymatconsultEntity>) entityManagerDigests.createNativeQuery(queryForList).getResultList();
    }

    public List<QiymatconsultEntity> getListQiymatshartli(){
        String queryForList = "select\n" +
                "    qm.g7a||'/'||char(date(qm.g7b),eur)||'/'||qm.g7c gtd,\n" +
                "    qm.regnum,\n" +
                "    qm.msg,\n" +
                "    qm.instime,\n" +
                "    qm.user_id,\n" +
                "    sum(distinct(qc.jami)),\n" +
                "    sum(distinct(qc.dastlabki)),\n" +
                "    sum(distinct(qt.g35))  netto,\n" +
                "    sum(distinct(qt.g38))  brutto,\n" +
                "    count(distinct(qt.id)) tovar_soni,\n" +
                "    qm.INSTIME +(2 month),\n" +
                "    days(qm.INSTIME +(2 month)) - days(current_date),\n"+
                "    qm.decl_id \n"+
                "from\n" +
                "    epigued.qiymatmsg qm\n" +
                "left join\n" +
                "    epigued.qiymattovar qt\n" +
                "on\n" +
                "    qt.decl_id = qm.decl_id\n" +
                "     \n" +
                "\n" +
                "left join\n" +
                "    epigued.qiymatconsult qc\n" +
                "on\n" +
                "    qc.decl_id = qm.decl_id\n" +
                "where\n" +
                "    qm.msg_type = 3\n" +
                "group by\n" +
                "    qm.g7a||'/'||char(date(qm.g7b),eur)||'/'||qm.g7c,\n" +
                "    qm.regnum,\n" +
                "    qm.msg,\n" +
                "    qm.instime,\n" +
                "    qm.user_id,\n"+
                "    qm.decl_id";
        return (List<QiymatconsultEntity>) entityManagerDigests.createNativeQuery(queryForList).getResultList();
    }

    public List<QiymatconsultEntity> getListQiymattovarModal(String tov_id){
        String queryForList = "select\n" +
                "    qt.g33,\n" +
                "    qt.g32,\n" +
                "    qt.G45_ED,\n" +
                "    qt.g22a,\n" +
                "    qt.g22b,\n" +
                "    qt.metod,\n" +
                "    qt.g38,\n" +
                "    qr.sabab1,\n" +
                "    qr.sabab2,\n" +
                "    qr.sabab3,\n" +
                "    qr.sabab4,\n" +
                "    qr.shartli,\n" +
                "    qt.G31NAME,\n" +
                "    qm.MSG,\n" +
                "    qt.g7a||'/'||char(date(qt.g7b),eur)||'/'||qt.g7c,\n" +
                "    qm.regnum,\n" +
                "    qm.instime,\n" +
                "    qm.user_id\n" +
                "from\n" +
                "    epigued.qiymatmsg qm\n" +
                "left join\n" +
                "    epigued.qiymattovar qt\n" +
                "on\n" +
                "    qt.decl_id = qm.decl_id\n" +
                "left join\n" +
                "    epigued.qiymatreject qr\n" +
                "on\n" +
                "    qr.decl_id = qm.decl_id\n" +
                "where\n" +
                "    qt.status=1\n" +
                "and qm.decl_id='"+ tov_id +"'\n" +
                "and qm.msg_type = 1\n" +
                "group by\n" +
                "    qt.g33,\n" +
                "    qt.g32,\n" +
                "    qt.G45_ED,\n" +
                "    qt.g22a,\n" +
                "    qt.g22b,\n" +
                "    qt.metod,\n" +
                "    qt.g38,\n" +
                "    qr.sabab1,\n" +
                "    qr.sabab2,\n" +
                "    qr.sabab3,\n" +
                "    qr.sabab4,\n" +
                "    qr.shartli,\n" +
                "    qt.G31NAME,\n" +
                "    qm.MSG,\n" +
                "    qt.g7a||'/'||char(date(qt.g7b),eur)||'/'||qt.g7c,\n" +
                "    qm.regnum,\n" +
                "    qm.instime,\n" +
                "    qm.user_id";
        return (List<QiymatconsultEntity>) entityManagerDigests.createNativeQuery(queryForList).getResultList();
    }

    public List<QiymatconsultEntity> getListQiymatConsultModal(String tov_id){
        String queryForList = "select\n" +
                "    qt.g33,\n" +
                "    qt.g32,\n" +
                "    qt.G45_ED,\n" +
                "    qt.g22a,\n" +
                "    qt.g22b,\n" +
                "    qt.metod,\n" +
                "    qt.g38,\n" +
                "    qr.sabab1,\n" +
                "    qr.sabab2,\n" +
                "    qr.sabab3,\n" +
                "    qr.sabab4,\n" +
                "    qr.shartli,\n" +
                "    qt.G31NAME,\n" +
                "    qm.MSG,\n" +
                "    qt.g7a||'/'||char(date(qt.g7b),eur)||'/'||qt.g7c,\n" +
                "    qm.regnum,\n" +
                "    qm.instime,\n" +
                "    qm.user_id\n" +
                "from\n" +
                "    epigued.qiymatmsg qm\n" +
                "left join\n" +
                "    epigued.qiymattovar qt\n" +
                "on\n" +
                "    qt.decl_id = qm.decl_id\n" +
                "left join\n" +
                "    epigued.qiymatreject qr\n" +
                "on\n" +
                "    qr.decl_id = qm.decl_id\n" +
                "where\n" +
                "    qt.status=1\n" +
                "and qm.decl_id='"+ tov_id +"'\n" +
                "and qm.msg_type = 1\n" +
                "group by\n" +
                "    qt.g33,\n" +
                "    qt.g32,\n" +
                "    qt.G45_ED,\n" +
                "    qt.g22a,\n" +
                "    qt.g22b,\n" +
                "    qt.metod,\n" +
                "    qt.g38,\n" +
                "    qr.sabab1,\n" +
                "    qr.sabab2,\n" +
                "    qr.sabab3,\n" +
                "    qr.sabab4,\n" +
                "    qr.shartli,\n" +
                "    qt.G31NAME,\n" +
                "    qm.MSG,\n" +
                "    qt.g7a||'/'||char(date(qt.g7b),eur)||'/'||qt.g7c,\n" +
                "    qm.regnum,\n" +
                "    qm.instime,\n" +
                "    qm.user_id";
        return (List<QiymatconsultEntity>) entityManagerDigests.createNativeQuery(queryForList).getResultList();
    }

    public List<QiymatconsultEntity> getListQiymatShartliModal(String tov_id){
        String queryForList = "select\n" +
                "    qt.g33,\n" +
                "    qt.g32,\n" +
                "    qt.G45_ED,\n" +
                "    qt.g22a,\n" +
                "    qt.g22b,\n" +
                "    qt.metod,\n" +
                "    qt.g38,\n" +
                "    qr.sabab1,\n" +
                "    qr.sabab2,\n" +
                "    qr.sabab3,\n" +
                "    qr.sabab4,\n" +
                "    qr.shartli,\n" +
                "    qt.G31NAME,\n" +
                "    qm.MSG,\n" +
                "    qt.g7a||'/'||char(date(qt.g7b),eur)||'/'||qt.g7c,\n" +
                "    qm.regnum,\n" +
                "    qm.instime,\n" +
                "    qm.user_id\n" +
                "from\n" +
                "    epigued.qiymatmsg qm\n" +
                "left join\n" +
                "    epigued.qiymattovar qt\n" +
                "on\n" +
                "    qt.decl_id = qm.decl_id\n" +
                "left join\n" +
                "    epigued.qiymatreject qr\n" +
                "on\n" +
                "    qr.decl_id = qm.decl_id\n" +
                "where\n" +
                "    qt.status=1\n" +
                "and qm.decl_id='"+ tov_id +"'\n" +
                "and qm.msg_type = 1\n" +
                "group by\n" +
                "    qt.g33,\n" +
                "    qt.g32,\n" +
                "    qt.G45_ED,\n" +
                "    qt.g22a,\n" +
                "    qt.g22b,\n" +
                "    qt.metod,\n" +
                "    qt.g38,\n" +
                "    qr.sabab1,\n" +
                "    qr.sabab2,\n" +
                "    qr.sabab3,\n" +
                "    qr.sabab4,\n" +
                "    qr.shartli,\n" +
                "    qt.G31NAME,\n" +
                "    qm.MSG,\n" +
                "    qt.g7a||'/'||char(date(qt.g7b),eur)||'/'||qt.g7c,\n" +
                "    qm.regnum,\n" +
                "    qm.instime,\n" +
                "    qm.user_id";
        return (List<QiymatconsultEntity>) entityManagerDigests.createNativeQuery(queryForList).getResultList();
    }

}

























