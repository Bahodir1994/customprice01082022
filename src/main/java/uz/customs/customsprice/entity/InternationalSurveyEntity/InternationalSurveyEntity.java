package uz.customs.customsprice.entity.InternationalSurveyEntity;

import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.Where;

import org.springframework.format.annotation.DateTimeFormat;
import uz.customs.customsprice.entity.entityConfig.AbstractAuditingEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "INTERNATIONAL_SURVEY", indexes = {@Index(columnList = "id", unique = true), @Index(columnList = "insuser", unique = false), @Index(columnList = "isdeleted", unique = false)})
@TypeDef(name = "jsonb", typeClass = JsonStringType.class)
@SQLDelete(sql = "update INTERNATIONAL_SURVEY set isdeleted = 1 where id = ?")
@Where(clause = "isdeleted = 0")
@AllArgsConstructor
@Getter
@Setter
public class InternationalSurveyEntity extends AbstractAuditingEntity {
    /*****************ҲББ томонидан юбоирлган хат рақами**********************/
    @Id
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id",  columnDefinition = "VARCHAR(50)")
    private String id;

    /****************ҲББ томонидан юбоирлган хат санаси***********************/
    @Column(name = "XBB_MAIL_NUM",  length = 50)
    private String xbbMailNum;

    /*****************Ташкилот номи**********************/
    @Column(name = "XBB_MAIL_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date xbbMailDate;

    /****************ТИФ ТН код***********************/
    @Column(name = "ORG_NAME",  columnDefinition = "VARCHAR(600) CCSID 1208")
    private String orgName;

    /***************Товар номи************************/
    @Column(name = "HS_CODE",  length = 250)
    private String hsCode;

    /***************************************/
    @Column(name = "PRODUCT_NAME",  columnDefinition = "VARCHAR(600) CCSID 1208")
    private String productName;

    /************Bitta ustun********************/
    /***************************************/
    @Column(name = "SEND_REQ_COUNTRY_CODE", nullable = true, length = 3)
    private String sendReqCountryCode;

    /***************************************/
    @Column(name = "SEND_REQ_COUNTRY_NM", nullable = true,  columnDefinition = "VARCHAR(120) CCSID 1208")
    private String sendReqCountryNm;

    @Column(name = "USER_LOCATION_CODE", nullable = true,  columnDefinition = "VARCHAR(90) CCSID 1208")
    private String userLocationCode;

    @Column(name = "USER_LOCATION_NAME", nullable = true,  columnDefinition = "VARCHAR(90) CCSID 1208")
    private String userLocationName;

    @Column(name = "DIRECTION_TYPE_CODE", nullable = true,  columnDefinition = "VARCHAR(50) CCSID 1208")
    private String directionTypeCode;

    @Column(name = "DIRECTION_TYPE_NAME", nullable = true,  columnDefinition = "VARCHAR(120) CCSID 1208")
    private String directionTypeName;

    @Column(name = "SUM_PROBABILITY")
    private BigDecimal sumProbability;

    /*******************************/
/***********************************************************************************************************************/

    /***************************************/
    @Column(name = "SEND_REQ_NUM",  length = 50)
    private String sendReqNum;

    /***************************************/
    @Column(name = "REQ_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date reqDate;

    /***************************************/
    @Column(name = "RESPONSE_NUM", nullable = true,  length = 50)
    private String responseNum;

    /***************************************/
    @Column(name = "RESPONSE_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date responseDate;

    /***************************************/
    @Column(name = "RESPONSE_NUM_SEND_XBB_NUM", nullable = true,  length = 50)
    private String responseNumSendXbbNum;

    /***************************************/
    @Column(name = "RESPONSE_NUM_SEND_XBB_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date responseNumSendXbbDate;

    @Column(name = "EXECUTIVE_TERRITORY_CODE", columnDefinition = "VARCHAR(9) CCSID 1208")
    private String executiveTerritoryCode;

    @Column(name = "EXECUTIVE_TERRITORY_NAME", columnDefinition = "VARCHAR(120) CCSID 1208")
    private String executiveTerritoryName;

    @Column(name = "DISTRIBUTED", columnDefinition = "VARCHAR(15) CCSID 1208")
    private String distributed;

/***********************************************************************************************************************/

    /***************************************/
    @Column(name = "RESULT_ANSWER_MAIL_NUM", length = 50)
    private String resultAnswerMailNum;

    /***************************************/
    @Column(name = "RESULT_ANSWER_MAIL_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date resultAnswerMailDate;

    /***************************************/
    @Column(name = "XBB_VERDICT_NUM", length = 50)
    private String xbbVerdictNum;

    /***************************************/
    @Column(name = "XBB_VERDICT_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date xbbVerdictDate;

    /***************************************/
    @Column(name = "SUM")
    private BigDecimal sum;

    @Column(name = "SUM_APPROVED")
    private BigDecimal sumАpproved;

    @Column(name = "SUM_ON_CONTROL")
    private BigDecimal sumOnControl;

    /***************************************/
    @Column(name = "COMMENT",  columnDefinition = "VARCHAR(800) CCSID 1208")
    private String comment;

    @Column(name = "STATUS",  columnDefinition = "VARCHAR(10) CCSID 1208")
    private String status = "100";

    @Column(name = "SAVED_USER_FIRST_Id", nullable = true,  columnDefinition = "VARCHAR(90) CCSID 1208")
    private String savedUserFirstId;

    @Column(name = "SAVED_USER_FIRST", nullable = true,  columnDefinition = "VARCHAR(120) CCSID 1208")
    private String savedUserFirst;

    @Column(name = "SAVED_USER_SECOND_ID", nullable = true,  columnDefinition = "VARCHAR(90) CCSID 1208")
    private String savedUserSecondId;

    @Column(name = "SAVED_USER_SECOND", nullable = true,  columnDefinition = "VARCHAR(120) CCSID 1208")
    private String savedUserSecond;

    @Column(name = "SAVED_USER_THIRD_ID", nullable = true,  columnDefinition = "VARCHAR(90) CCSID 1208")
    private String savedUserThirdId;

    @Column(name = "SAVED_USER_THIRD", nullable = true,  columnDefinition = "VARCHAR(120) CCSID 1208")
    private String savedUserThird;

    @Column(name = "FABULA", nullable = true,  columnDefinition = "VARCHAR(600) CCSID 1208")
    private String fabula;

    public InternationalSurveyEntity() {
    }
}
