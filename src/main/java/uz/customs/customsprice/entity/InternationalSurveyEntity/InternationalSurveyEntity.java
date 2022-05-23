package uz.customs.customsprice.entity.InternationalSurveyEntity;

import com.vladmihalcea.hibernate.type.json.JsonStringType;
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
@SQLDelete(sql = "update INTERATIONALSURVEY set isdeleted = 1 where id = ?")
@Where(clause = "isdeleted = 0")
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
    @Column(name = "HS_CODE",  length = 10)
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

    /***************************************/
    @Column(name = "COMMENT",  columnDefinition = "VARCHAR(800) CCSID 1208")
    private String comment;

    @Column(name = "STATUS",  columnDefinition = "VARCHAR(10) CCSID 1208")
    private String status = "100";

    public InternationalSurveyEntity() {
    }

    public InternationalSurveyEntity(String insUser, String updUser, Date insTime, Date updTime, int isDeleted, String id, String xbbMailNum, Date xbbMailDate, String orgName, String hsCode, String productName, String sendReqCountryCode, String sendReqCountryNm, String sendReqNum, Date reqDate, String responseNum, Date responseDate, String responseNumSendXbbNum, Date responseNumSendXbbDate, String resultAnswerMailNum, Date resultAnswerMailDate, String xbbVerdictNum, Date xbbVerdictDate, BigDecimal sum, String comment, String status) {
        super(insUser, updUser, insTime, updTime, isDeleted);
        this.id = id;
        this.xbbMailNum = xbbMailNum;
        this.xbbMailDate = xbbMailDate;
        this.orgName = orgName;
        this.hsCode = hsCode;
        this.productName = productName;
        this.sendReqCountryCode = sendReqCountryCode;
        this.sendReqCountryNm = sendReqCountryNm;
        this.sendReqNum = sendReqNum;
        this.reqDate = reqDate;
        this.responseNum = responseNum;
        this.responseDate = responseDate;
        this.responseNumSendXbbNum = responseNumSendXbbNum;
        this.responseNumSendXbbDate = responseNumSendXbbDate;
        this.resultAnswerMailNum = resultAnswerMailNum;
        this.resultAnswerMailDate = resultAnswerMailDate;
        this.xbbVerdictNum = xbbVerdictNum;
        this.xbbVerdictDate = xbbVerdictDate;
        this.sum = sum;
        this.comment = comment;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getXbbMailNum() {
        return xbbMailNum;
    }

    public void setXbbMailNum(String xbbMailNum) {
        this.xbbMailNum = xbbMailNum;
    }

    public Date getXbbMailDate() {
        return xbbMailDate;
    }

    public void setXbbMailDate(Date xbbMailDate) {
        this.xbbMailDate = xbbMailDate;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getHsCode() {
        return hsCode;
    }

    public void setHsCode(String hsCode) {
        this.hsCode = hsCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSendReqCountryCode() {
        return sendReqCountryCode;
    }

    public void setSendReqCountryCode(String sendReqCountryCode) {
        this.sendReqCountryCode = sendReqCountryCode;
    }

    public String getSendReqCountryNm() {
        return sendReqCountryNm;
    }

    public void setSendReqCountryNm(String sendReqCountryNm) {
        this.sendReqCountryNm = sendReqCountryNm;
    }

    public String getSendReqNum() {
        return sendReqNum;
    }

    public void setSendReqNum(String sendReqNum) {
        this.sendReqNum = sendReqNum;
    }

    public Date getReqDate() {
        return reqDate;
    }

    public void setReqDate(Date reqDate) {
        this.reqDate = reqDate;
    }

    public String getResponseNum() {
        return responseNum;
    }

    public void setResponseNum(String responseNum) {
        this.responseNum = responseNum;
    }

    public Date getResponseDate() {
        return responseDate;
    }

    public void setResponseDate(Date responseDate) {
        this.responseDate = responseDate;
    }

    public String getResponseNumSendXbbNum() {
        return responseNumSendXbbNum;
    }

    public void setResponseNumSendXbbNum(String responseNumSendXbbNum) {
        this.responseNumSendXbbNum = responseNumSendXbbNum;
    }

    public Date getResponseNumSendXbbDate() {
        return responseNumSendXbbDate;
    }

    public void setResponseNumSendXbbDate(Date responseNumSendXbbDate) {
        this.responseNumSendXbbDate = responseNumSendXbbDate;
    }

    public String getResultAnswerMailNum() {
        return resultAnswerMailNum;
    }

    public void setResultAnswerMailNum(String resultAnswerMailNum) {
        this.resultAnswerMailNum = resultAnswerMailNum;
    }

    public Date getResultAnswerMailDate() {
        return resultAnswerMailDate;
    }

    public void setResultAnswerMailDate(Date resultAnswerMailDate) {
        this.resultAnswerMailDate = resultAnswerMailDate;
    }

    public String getXbbVerdictNum() {
        return xbbVerdictNum;
    }

    public void setXbbVerdictNum(String xbbVerdictNum) {
        this.xbbVerdictNum = xbbVerdictNum;
    }

    public Date getXbbVerdictDate() {
        return xbbVerdictDate;
    }

    public void setXbbVerdictDate(Date xbbVerdictDate) {
        this.xbbVerdictDate = xbbVerdictDate;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
