package uz.customs.customsprice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.customs.customsprice.entity.InitialDecision.Apps;
import uz.customs.customsprice.entity.InitialDecision.InDec;
import uz.customs.customsprice.entity.InitialDecision.StatusH;

import java.sql.Date;
import java.util.List;
import java.util.Optional;


public interface AppsRepo extends JpaRepository<Apps, String> {
    Optional<Apps> findById(String id);

    List<Apps> findByAppNum(String appNum);

//    Apps findByCmdtId(String cmdtId);

    Apps findTop1ByAppNumOrderByInsTimeAsc(String appNum);

    @Query(value = "SELECT distinct a FROM Apps a LEFT JOIN Commodity c ON a.id = c.appId" +
            " where c.appId is not null and a.personPin = :personPin")
    Page<Apps> findByPersonPin(String personPin, Pageable pageable);

    @Query("SELECT c FROM Apps c WHERE" +
            "(:starts is null or c.insTime >= :starts) and"+
            "(:ends is null or c.insTime <= :ends) and"+
            "(:appNum='' or :appNum is null or lower(c.appNum) like lower(CONCAT('%',:appNum,'%')) ) and"+
            "(:locationId='' or :locationId is null or c.locationId = :locationId) and"+
            "(:personFio='' or :personFio is null or lower(c.personFio) like lower(CONCAT('%',:personFio,'%'))) and"+
            "(:sellerOrg='' or :sellerOrg is null or c.sellerOrg = :sellerOrg) and"+
            "(:orignOrg='' or :orignOrg is null or c.customerCountry = :orignOrg) and"+
            "(:senderOrg='' or :senderOrg is null or c.senderCountry = :senderOrg) and"+
            "(c.status in (:statusGet))")
    Page<Apps> gfhfgthfgt(
            @Param("starts") Date starts,
            @Param("ends")Date ends,
            @Param("appNum")String appNum,
            @Param("locationId")String locationId,
            @Param("personFio")String personFio,
            @Param("sellerOrg")String sellerOrg,
            @Param("orignOrg")String opringOrg,
            @Param("senderOrg")String senderOrg,
            @Param("statusGet")java.util.List<Integer> statusGet,
            Pageable paging);

    @Query("SELECT " +
            "c.id,"+
            "c.personId,"+
            "c.appNum,"+
            "c.appDate,"+
            "c.customerCountry,"+
            "c.customerCountryNm,"+
            "c.senderCountry,"+
            "c.senderCountryNm,"+
            "c.senderOrg,"+
            "c.sellerOrg,"+
            "c.terms,"+
            "c.termsNm,"+
            "c.termsAddr,"+
            "c.personFio,"+
            "c.orgName,"+
            "c.personPosition,"+
            "c.personAddr,"+
            "c.personTin,"+
            "c.personPin,"+
            "c.personMail,"+
            "c.personPhone,"+
            "c.locationId,"+
            "c.locationNm,"+
            "c.transExp,"+
            "c.status,"+
            "c.statusNm,"+
            "c.comment,"+
            "c.importerNm,"+
            "c.importerTin,"+
            "c.insTime,"+
            "d.inspectorName, "+
            "c.versionNum"+
            " FROM Apps c LEFT JOIN AppsRasp d ON c.id=d.appId" +
            " WHERE" +
            "(:starts is null or c.insTime >= :starts) and"+
            "(:ends is null or c.insTime <= :ends) and"+
            "(:appNum='' or :appNum is null or lower(c.appNum) like lower(CONCAT('%',:appNum,'%')) ) and"+
            "(:locationId='' or :locationId is null or c.locationId = :locationId) and"+
            "(:personFio='' or :personFio is null or lower(c.personFio) like lower(CONCAT('%',:personFio,'%'))) and"+
            "(:sellerOrg='' or :sellerOrg is null or c.sellerOrg = :sellerOrg) and"+
            "(:orignOrg='' or :orignOrg is null or c.customerCountry = :orignOrg) and"+
            "(:senderOrg='' or :senderOrg is null or c.senderCountry = :senderOrg) and"+
            "(:inspectorId='' or :inspectorId is null or d.inspectorId = :inspectorId) and"+
            "(c.status in (:statusGet)) and"+
            "(:sortedInspector='' or :sortedInspector is null or lower(d.inspectorName) like lower(CONCAT('%',:sortedInspector,'%')) )"
    )
    Page<Apps> asdasdsad(
            @Param("starts") Date starts,
            @Param("ends")Date ends,
            @Param("appNum")String appNum,
            @Param("locationId")String locationId,
            @Param("personFio")String personFio,
            @Param("sellerOrg")String sellerOrg,
            @Param("orignOrg")String opringOrg,
            @Param("senderOrg")String senderOrg,
            @Param("inspectorId")String inspectorId,
            @Param("statusGet")java.util.List<Integer> statusGet,
            @Param("sortedInspector")String sortedInspector,
            Pageable paging);

    @Query("SELECT " +
            "c.id,"+
            "c.personId,"+
            "c.appNum,"+
            "c.appDate,"+
            "c.customerCountry,"+
            "c.customerCountryNm,"+
            "c.senderCountry,"+
            "c.senderCountryNm,"+
            "c.senderOrg,"+
            "c.sellerOrg,"+
            "c.terms,"+
            "c.termsNm,"+  //11
            "c.termsAddr,"+
            "c.personFio,"+
            "c.orgName,"+
            "c.personPosition,"+
            "c.personAddr,"+
            "c.personTin,"+
            "c.personPin,"+
            "c.personMail,"+ //19
            "c.personPhone,"+
            "c.locationId,"+
            "c.locationNm,"+
            "c.transExp,"+
            "c.status,"+
            "c.statusNm,"+
            "c.comment,"+
            "c.importerNm,"+
            "c.importerTin,"+
            "c.insTime,"+  //29
            "ar.inspectorName,"+
            "i.id,"+
            "i.insTime,"+
            "i.insUser,"+
            "i.isDeleted,"+
            "i.updTime,"+
            "i.updUser,"+
            "i.commentMarks,"+
            "i.customsPayments,"+
            "i.customsPreference,"+
            "i.hsCode,"+
            "i.hsName,"+
            "i.inDecBasis,"+   //42
            "i.inDecDate,"+
            "i.inDecLocationNm,"+
            "i.inDecLocationNm,"+
            "i.inDecNum,"+
            "i.method,"+
            "i.methodNm,"+
            "i.originCountry,"+
            "i.orignCountrNm,"+
            "i.personId,"+
            "i.status,"+  //52
            "i.statusNm,"+
            "i.inDecEndDate,"+
            "i.inDecUserEndedDate, "+
            "i.commentEnded, "+
            "i.endActiv, " +
            "i.g3a, "+
            "i.g3b, "+
            "i.g3c, "+   //60
            "c.importerNm, "+
            "c.importerTin, "+
            "cmdt.id, "+
            "c.versionNum,"+
            "i.versionNum"+
            " FROM InDec i" +
            " LEFT JOIN Commodity cmdt ON i.cmdtId = cmdt.id" +
            " LEFT JOIN Apps c ON c.id=cmdt.appId" +
            " LEFT JOIN AppsRasp ar ON c.id=ar.appId" +
            " WHERE" +
//            "(i.endActiv = :endActivValue) and"+
            "(:starts is null or c.insTime >= :starts) and"+
            "(:ends is null or c.insTime <= :ends) and"+
            "(:appNum='' or :appNum is null or lower(c.appNum) like lower(CONCAT('%',:appNum,'%')) ) and"+
            "(:locationId='' or :locationId is null or c.locationId = :locationId) and"+
            "(:personFio='' or :personFio is null or lower(c.personFio) like lower(CONCAT('%',:personFio,'%'))) and"+
            "(:statusPay is null or i.status = :statusPay) and"+
            "(:inDecNum='' or :inDecNum is null or lower(i.inDecNum) like lower(CONCAT('%',:inDecNum,'%')) ) and"+
            "(:inDecStarts is null or i.inDecDate >= :inDecStarts) and"+
            "(:inDecEnds is null or i.inDecDate <= :inDecEnds) and"+
            "(:termsNm='' or :termsNm is null or lower(c.termsNm) like lower(CONCAT('%',:termsNm,'%')) ) and"+
            "(:inDecEndDateStarts is null or i.inDecEndDate >= :inDecEndDateStarts) and"+
            "(:inDecEndDateEnds is null or i.inDecEndDate <= :inDecEndDateEnds) and"+
            "(c.status in (:statusGet)) and"+
            "(:sortedInspector='' or :sortedInspector is null or lower(ar.inspectorName) like lower(CONCAT('%',:sortedInspector,'%')) )"
    )
    Page<Apps> qwefrads(
            @Param("starts") Date starts,
            @Param("ends")Date ends,
            @Param("appNum")String appNum,
            @Param("locationId")String locationId,
            @Param("personFio")String personFio,
            @Param("statusPay")Integer statusPay,
            @Param("inDecNum")String inDecNum,
            @Param("inDecStarts") Date inDecStarts,
            @Param("inDecEnds")Date inDecEnds,
            @Param("termsNm")String termsNm,
            @Param("inDecEndDateStarts") Date inDecEndDateStarts,
            @Param("inDecEndDateEnds")Date inDecEndDateEnds,
            @Param("statusGet")java.util.List<Integer> statusGet,
            @Param("sortedInspector")String sortedInspector,
//            @Param("endActivValue")Integer endActivValue,
            Pageable paging);

    String countByStatusAndLocationId(String status, String locationId);

    Page<Apps> findByAppNum(String appNum,Pageable pageable);

    @Query("SELECT cc FROM Apps cc WHERE" +
            "(:locationForStatisticBar='' or :locationForStatisticBar is null or cc.locationId = :locationForStatisticBar) and"+
            "(cc.status in (:statusForStatisticsBarFirst))")
    List<Apps> first(
            @Param("locationForStatisticBar")String locationForStatisticBar,
            @Param("statusForStatisticsBarFirst")java.util.List<Integer> statusForStatisticsBarFirst);

    @Query("SELECT cc FROM Apps cc left join AppsRasp apr on cc.id = apr.appId WHERE" +
            "(:locationForStatisticBar='' or :locationForStatisticBar is null or cc.locationId = :locationForStatisticBar) and"+
            "(:inspectorIdRasp='' or :inspectorIdRasp is null or apr.inspectorId = :inspectorIdRasp) and"+
            "(cc.status in (:statusForStatisticsBarFirst))")
    List<Apps> second(
            @Param("locationForStatisticBar")String locationForStatisticBar,
            @Param("inspectorIdRasp")String inspectorIdRasp,
            @Param("statusForStatisticsBarFirst")java.util.List<Integer> statusForStatisticsBarFirst);

    @Query("SELECT cc FROM Apps cc left join AppsRasp apr on cc.id = apr.appId WHERE" +
            "(:locationForStatisticBar='' or :locationForStatisticBar is null or cc.locationId = :locationForStatisticBar) and"+
            "(:inspectorIdRasp='' or :inspectorIdRasp is null or apr.inspectorId = :inspectorIdRasp) and"+
            "(cc.status in (:statusForStatisticsBarFirst))")
    List<Apps> thirt(
            @Param("locationForStatisticBar")String locationForStatisticBar,
            @Param("inspectorIdRasp")String inspectorIdRasp,
            @Param("statusForStatisticsBarFirst")java.util.List<Integer> statusForStatisticsBarFirst);

    @Query("SELECT cc FROM Apps cc left join AppsRasp apr on cc.id = apr.appId WHERE" +
            "(:locationForStatisticBar='' or :locationForStatisticBar is null or cc.locationId = :locationForStatisticBar) and"+
            "(:inspectorIdRasp='' or :inspectorIdRasp is null or apr.inspectorId = :inspectorIdRasp) and"+
            "(cc.status in (:statusForStatisticsBarFirst))")
    List<Apps> fourth(
            @Param("locationForStatisticBar")String locationForStatisticBar,
            @Param("inspectorIdRasp")String inspectorIdRasp,
            @Param("statusForStatisticsBarFirst")java.util.List<Integer> statusForStatisticsBarFirst);


    @Query("select aps.id, aps.statusNm, sh.statusComment from Apps aps left join StatusH sh on aps.id = sh.appId left join RollBackApp ra on sh.id = ra.statusHId where aps.id = :appId")
    List<Apps> fsdfsdfad(@Param("appId") String appId);

    Apps findByAppNumAndStatus(String appNum, int status);
}
