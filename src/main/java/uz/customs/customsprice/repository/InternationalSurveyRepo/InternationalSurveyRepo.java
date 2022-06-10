package uz.customs.customsprice.repository.InternationalSurveyRepo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.customs.customsprice.entity.InternationalSurveyEntity.InternationalSurveyEntity;

import java.math.BigDecimal;
import java.sql.Date;

@Repository
public interface InternationalSurveyRepo extends JpaRepository<InternationalSurveyEntity, String> {

    @Query("SELECT c FROM InternationalSurveyEntity c WHERE" +
            "(:userLocationCode='' or :userLocationCode is null or c.userLocationCode = :userLocationCode) and"+
            "(:directionTypeCode='' or :directionTypeCode is null or c.directionTypeCode = :directionTypeCode) and"+
            "(:xbbMailNum='' or :xbbMailNum is null or lower(c.xbbMailNum) like lower(CONCAT('%',:xbbMailNum,'%')) ) and"+
            "(:xbbMailDate is null or c.xbbMailDate = :xbbMailDate) and"+
            "(:hsCode='' or :hsCode is null or lower(c.hsCode) like lower(CONCAT('%',:hsCode,'%'))) and"+
            "(:productName='' or :productName is null or lower(c.productName) like lower(CONCAT('%',:productName,'%'))) and"+
            "(:sendReqCountryCode='' or :sendReqCountryCode is null or c.sendReqCountryCode = :sendReqCountryCode) and"+
            "(:sendReqNum='' or :sendReqNum is null or lower(c.sendReqNum) like lower(CONCAT('%',:sendReqNum,'%'))) and"+
            "(:reqDate is null or c.reqDate = :reqDate) and"+
            "(:responseNum='' or :responseNum is null or lower(c.responseNum) like lower(CONCAT('%',:responseNum,'%'))) and"+
            "(:responseDate is null or c.responseDate = :responseDate) and"+
            "(:responseNumSendXbbNum='' or :responseNumSendXbbNum is null or lower(c.responseNumSendXbbNum) like lower(CONCAT('%',:responseNumSendXbbNum,'%'))) and"+
            "(:responseNumSendXbbDate is null or c.responseNumSendXbbDate = :responseNumSendXbbDate) and"+
            "(:resultAnswerMailNum='' or :resultAnswerMailNum is null or lower(c.resultAnswerMailNum) like lower(CONCAT('%',:resultAnswerMailNum,'%'))) and"+
            "(:resultAnswerMailDate is null or c.resultAnswerMailDate = :resultAnswerMailDate) and"+
            "(:xbbVerdictNum='' or :xbbVerdictNum is null or lower(c.xbbVerdictNum) like lower(CONCAT('%',:xbbVerdictNum,'%'))) and"+
            "(:xbbVerdictDate is null or c.xbbVerdictDate = :xbbVerdictDate) and"+
            "(:executiveTerritoryCode is null or :executiveTerritoryCode='' or c.executiveTerritoryCode = :executiveTerritoryCode) and"+
            "(:status='' or :status is null or c.status = :status)")
//                "(:status='' or c.status = :status)")
    Page<InternationalSurveyEntity>
    findAllByOrgNameAndHsCode(
            @Param("userLocationCode") String userLocationCode,
            @Param("directionTypeCode") String directionTypeCode,
            @Param("xbbMailNum") String xbbMailNum,
            @Param("xbbMailDate") Date xbbMailDate,
            @Param("hsCode") String hsCode,
            @Param("productName") String productName,
            @Param("sendReqCountryCode") String sendReqCountryCode,
            @Param("sendReqNum") String sendReqNum,
            @Param("reqDate") Date reqDate,
            @Param("responseNum") String responseNum,
            @Param("responseDate") Date responseDate,
            @Param("responseNumSendXbbNum") String responseNumSendXbbNum,
            @Param("responseNumSendXbbDate") Date responseNumSendXbbDate,
            @Param("resultAnswerMailNum") String resultAnswerMailNum,
            @Param("resultAnswerMailDate") Date resultAnswerMailDate,
            @Param("xbbVerdictNum") String xbbVerdictNum,
            @Param("xbbVerdictDate") Date xbbVerdictDate,
            @Param("executiveTerritoryCode") String executiveTerritoryCode,
            @Param("status") String status,
            Pageable paging);

    Page<InternationalSurveyEntity> findAllByOrgName(String orgName, Pageable paging);

    Page<InternationalSurveyEntity> findByOrgNameAndHsCode(String orgName, String hsCode, Pageable paging);

    InternationalSurveyEntity findByIdAndStatus(String id, String status);

    InternationalSurveyEntity findByExecutiveTerritoryCode(String executiveTerritoryCode);
}
