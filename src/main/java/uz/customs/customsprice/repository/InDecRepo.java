package uz.customs.customsprice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.customs.customsprice.entity.InDec;

import java.util.Date;
import java.util.List;

public interface InDecRepo extends JpaRepository<InDec, String> {
    List<InDec> findByEndActiv(int endActive);

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
            " a.terms,"+
            " a.termsNm,"+
            " d.hsCode," +
            " c.hsName," +
            " c.tradeName," +
            " c.method," +
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
            " (:appNum='' or :appNum is null or lower(a.appNum) like lower(concat('%',:appNum,'%')) )and" +
            " (:hsCode='' or :hsCode is null or lower(d.hsCode) like lower(concat('%',:hsCode,'%')) ) and" +
            " (:tradeName='' or :tradeName is null or lower(c.tradeName) like lower(concat('%',:tradeName,'%')) ) and" +
            " (:terms='' or :terms is null or a.terms = :terms) and" +
            " (:method='' or :method is null or c.method = :method) and" +
            " (:inDecNum='' or :inDecNum is null or lower(d.inDecNum) like lower(concat('%',:inDecNum,'%')) ) and" +
            " (:insTimeStart is null or d.inDecDate >= :insTimeStart) and" +
            " (:insTimeEnd is null or d.inDecDate <= :insTimeEnd)")
    Page<InDec> findAllByCmdtId(@Param("appNum")String appNum,
                                @Param("hsCode")String hsCode,
                                @Param("tradeName")String tradeName,
                                @Param("terms")String terms,
                                @Param("method") String method,
                                @Param("inDecNum")String inDecNum,
                                @Param("insTimeStart")Date insTimeStart,
                                @Param("insTimeEnd")Date insTimeEnd,
                                Pageable paging);

    @Query("SELECT cc FROM InDec cc left join Commodity cm on cc.cmdtId = cm.id left join Apps aps on cm.appId = aps.id  WHERE" +
            "(:locationForStatisticBar='' or :locationForStatisticBar is null or aps.locationId = :locationForStatisticBar) and"+
            "(cc.endActiv = :endActiveCode) and"+
            "(aps.status in (:statusForStatisticsBarFirst))"
    )
    List<InDec> fifth(
            @Param("locationForStatisticBar")String locationForStatisticBar,
            @Param("endActiveCode")Integer endActiveCode,
            @Param("statusForStatisticsBarFirst")java.util.List<Integer> statusForStatisticsBarFirst);

    @Query("SELECT cc FROM InDec cc left join Commodity cm on cc.cmdtId = cm.id left join Apps aps on cm.appId = aps.id  WHERE" +
            "(:locationForStatisticBar='' or :locationForStatisticBar is null or aps.locationId = :locationForStatisticBar) and"+
//            "(cc.endActiv = :endActiveCode) and"+
            "(aps.status in (:statusForStatisticsBarFirst))"
    )
    List<InDec> sixth(
            @Param("locationForStatisticBar")String locationForStatisticBar,
//            @Param("endActiveCode")Integer endActiveCode,
            @Param("statusForStatisticsBarFirst")java.util.List<Integer> statusForStatisticsBarFirst);
}
