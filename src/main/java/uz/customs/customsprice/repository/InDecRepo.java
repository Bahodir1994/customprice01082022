package uz.customs.customsprice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.customs.customsprice.entity.InitialDecision.Apps;
import uz.customs.customsprice.entity.InitialDecision.InDec;

import java.util.Date;
import java.util.Optional;

public interface InDecRepo extends JpaRepository<InDec, String> {
    InDec findByCmdtId(String cmdtId);

    Page<InDec> findByInDecLocationAndInDecDateBetween(String indecLocation, Date startDate, Date endDate, Pageable pageable);

    InDec findByInDecNum(String inDecNum);

    InDec findByInDecDate(Date inDecDate);

    InDec findByInDecNumAndInDecDate(String inDecNum, Date inDecDate);

    InDec findByInDecNumAndInDecDateAndPersonId(String inDecNum, Date inDecDate, String personId);

    InDec findByG3aAndG3bAndG3c(String g3a, Date g3b, String g3c);

    @Query("SELECT" +
            " a.appNum, "+
            " a.appDate,"+
            " a.personFio,"+
            " d.hsCode," +
            " c.hsName," +
            " d.inDecNum," +
            " d.inDecDate," +
            " d.inDecEndDate," +
            " d.inDecLocationNm," +
            " d.methodNm," +
            " d.statusNm," +
            " d.commentEnded" +
            " FROM InDec d" +
            " LEFT JOIN Commodity c" +
            " ON d.cmdtId = c.id"+
            " LEFT JOIN Apps a" +
            " ON c.appId=a.id" +
            " WHERE" +
            " (:hsCode='' or :hsCode is null or lower(d.hsCode) like lower(concat('%',:hsCode,'%')) )" +
            " and" +
            " (:appNum='' or :appNum is null or lower(a.appNum) like lower(concat('%',:appNum,'%')) )and" +
            " (:inDecNum='' or :inDecNum is null or lower(d.inDecNum) like lower(concat('%',:inDecNum,'%')) ) and" +
            " (:insTimeStart is null or :insTimeStart <= d.inDecDate) and" +
            " (:insTimeEnd is null or :insTimeEnd >= d.inDecDate)")
    Page<InDec> findAllByCmdtId(@Param("hsCode")String hsCode, @Param("appNum")String appNum, @Param("inDecNum")String inDecNum, @Param("insTimeStart")Date insTimeStart, @Param("insTimeEnd")Date insTimeEnd, Pageable paging);

}
