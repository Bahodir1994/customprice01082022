package uz.customs.customsprice.entity.InitialDecision;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;
import uz.customs.customsprice.entity.entityConfig.AbstractAuditingEntity;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "IN_DEC")
public class InDec extends AbstractAuditingEntity {
    @Id
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(50)")
    private String id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CMDT_ID", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Commodity commodity;

    @Column(name = "CMDT_ID", columnDefinition = "VARCHAR(50)")
    private String cmdtId;

    @Column(name = "IN_DEC_NUM", length = 30)
    private String inDecNum;

    @Column(name = "IN_DEC_NUMS", length = 30)
    private String inDecNumS;

    @Column(name = "IN_DEC_DATE", columnDefinition = " date default current_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date inDecDate = new Date(new Date().getTime());

    @Column(name = "IN_DEC_LOCATION", length = 4)
    private String inDecLocation;

    @Column(name = "IN_DEC_LOCATION_NM", columnDefinition = "VARCHAR(180) CCSID 1208")
    private String inDecLocationNm;

    @Column(name = "PERSON_ID", length = 50)
    private String personId;

    @Column(name = "HS_CODE", length = 10)
    private String hsCode;

    @Column(name = "HS_NAME", columnDefinition = "VARCHAR(2000) CCSID 1208")
    private String hsName;

    @Column(name = "METHOD", length = 3)
    private String method;

    @Column(name = "METHOD_NM", columnDefinition = "VARCHAR(180) CCSID 1208")
    private String methodNm;

    @Column(name = "ORIGIN_COUNTRY", length = 3)
    private String originCountry;

    @Column(name = "ORIGIN_COUNTRY_NM", columnDefinition = "VARCHAR(120) CCSID 1208")
    private String orignCountrNm;

    @Column(name = "IN_DEC_BASIS", columnDefinition = "VARCHAR(60) CCSID 1208")
    private String inDecBasis;

    @Column(name = "COMMENT_MARKS", columnDefinition = "VARCHAR(60) CCSID 1208")
    private String commentMarks;

    @Column(name = "CUSTOMS_PREFERENCE", length = 4)
    private BigDecimal customsPreference;

    @Column(name = "CUSTOMS_PAYMENTS", length = 4)
    private BigDecimal customsPayments;

    @Column(name = "STATUS", columnDefinition = "SMALLINT DEFAULT 100")
    private int status = 100;

    @Column(name = "STATUS_NM", columnDefinition = "VARCHAR(450) CCSID 1208")
    private String statusNm;

    @Column(name = "IN_DEC_END_DATE", columnDefinition = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date inDecEndDate;

    @Column(name = "IN_DEC_USR_ENDED_DATE", columnDefinition = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date inDecUserEndedDate;

    @Column(name = "COMMENT_ENDED", columnDefinition = "VARCHAR(600) CCSID 1208")
    private String commentEnded;

    /*if endActiv == 100 its activ else ended inDec*/
    @Column(name = "END_ACTIV", columnDefinition = "SMALLINT DEFAULT 100")
    private int endActiv = 100;


    @Column(name = "TPO_ID", length = 50)
    private String tpoId;

    @Column(name = "PAY_ID", length = 50)
    private String payId;

    @Column(name = "G3A", columnDefinition = "VARCHAR(5)")
    private String g3a;

    @Column(name = "G3B", columnDefinition = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date g3b;

    @Column(name = "G3C", columnDefinition = "VARCHAR(10)")
    private String g3c;

    @Column(name = "G19BASE")
    @Digits(integer = 15, fraction = 3)
    private BigDecimal g19Base;

    @Column(name = "STAVKA", columnDefinition = "VARCHAR(50)")
    private String stavka;

    @Column(name = "G19SUM")
    @Digits(integer = 15, fraction = 3)
    private BigDecimal g19Sum;

    @Column(name = "VERSION_NUM", columnDefinition = "VARCHAR(50) DEFAULT 1")
    private String versionNum = "1";


    public InDec() {
    }

    public InDec(String insUser, String updUser, Date insTime, Date updTime, int isDeleted, String id, Commodity commodity, String cmdtId, String inDecNum, String inDecNumS, Date inDecDate, String inDecLocation, String inDecLocationNm, String personId, String hsCode, String hsName, String method, String methodNm, String originCountry, String orignCountrNm, String inDecBasis, String commentMarks, BigDecimal customsPreference, BigDecimal customsPayments, int status, String statusNm, Date inDecEndDate, Date inDecUserEndedDate, String commentEnded, int endActiv, String tpoId, String payId, String g3a, Date g3b, String g3c, BigDecimal g19Base, String stavka, BigDecimal g19Sum, String versionNum) {
        super(insUser, updUser, insTime, updTime, isDeleted);
        this.id = id;
        this.commodity = commodity;
        this.cmdtId = cmdtId;
        this.inDecNum = inDecNum;
        this.inDecNumS = inDecNumS;
        this.inDecDate = inDecDate;
        this.inDecLocation = inDecLocation;
        this.inDecLocationNm = inDecLocationNm;
        this.personId = personId;
        this.hsCode = hsCode;
        this.hsName = hsName;
        this.method = method;
        this.methodNm = methodNm;
        this.originCountry = originCountry;
        this.orignCountrNm = orignCountrNm;
        this.inDecBasis = inDecBasis;
        this.commentMarks = commentMarks;
        this.customsPreference = customsPreference;
        this.customsPayments = customsPayments;
        this.status = status;
        this.statusNm = statusNm;
        this.inDecEndDate = inDecEndDate;
        this.inDecUserEndedDate = inDecUserEndedDate;
        this.commentEnded = commentEnded;
        this.endActiv = endActiv;
        this.tpoId = tpoId;
        this.payId = payId;
        this.g3a = g3a;
        this.g3b = g3b;
        this.g3c = g3c;
        this.g19Base = g19Base;
        this.stavka = stavka;
        this.g19Sum = g19Sum;
        this.versionNum = versionNum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public String getCmdtId() {
        return cmdtId;
    }

    public void setCmdtId(String cmdtId) {
        this.cmdtId = cmdtId;
    }

    public String getInDecNum() {
        return inDecNum;
    }

    public void setInDecNum(String inDecNum) {
        this.inDecNum = inDecNum;
    }

    public String getInDecNumS() {
        return inDecNumS;
    }

    public void setInDecNumS(String inDecNumS) {
        this.inDecNumS = inDecNumS;
    }

    public Date getInDecDate() {
        return inDecDate;
    }

    public void setInDecDate(Date inDecDate) {
        this.inDecDate = inDecDate;
    }

    public String getInDecLocation() {
        return inDecLocation;
    }

    public void setInDecLocation(String inDecLocation) {
        this.inDecLocation = inDecLocation;
    }

    public String getInDecLocationNm() {
        return inDecLocationNm;
    }

    public void setInDecLocationNm(String inDecLocationNm) {
        this.inDecLocationNm = inDecLocationNm;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getHsCode() {
        return hsCode;
    }

    public void setHsCode(String hsCode) {
        this.hsCode = hsCode;
    }

    public String getHsName() {
        return hsName;
    }

    public void setHsName(String hsName) {
        this.hsName = hsName;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getMethodNm() {
        return methodNm;
    }

    public void setMethodNm(String methodNm) {
        this.methodNm = methodNm;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public String getOrignCountrNm() {
        return orignCountrNm;
    }

    public void setOrignCountrNm(String orignCountrNm) {
        this.orignCountrNm = orignCountrNm;
    }

    public String getInDecBasis() {
        return inDecBasis;
    }

    public void setInDecBasis(String inDecBasis) {
        this.inDecBasis = inDecBasis;
    }

    public String getCommentMarks() {
        return commentMarks;
    }

    public void setCommentMarks(String commentMarks) {
        this.commentMarks = commentMarks;
    }

    public BigDecimal getCustomsPreference() {
        return customsPreference;
    }

    public void setCustomsPreference(BigDecimal customsPreference) {
        this.customsPreference = customsPreference;
    }

    public BigDecimal getCustomsPayments() {
        return customsPayments;
    }

    public void setCustomsPayments(BigDecimal customsPayments) {
        this.customsPayments = customsPayments;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusNm() {
        return statusNm;
    }

    public void setStatusNm(String statusNm) {
        this.statusNm = statusNm;
    }

    public Date getInDecEndDate() {
        return inDecEndDate;
    }

    public void setInDecEndDate(Date inDecEndDate) {
        this.inDecEndDate = inDecEndDate;
    }

    public Date getInDecUserEndedDate() {
        return inDecUserEndedDate;
    }

    public void setInDecUserEndedDate(Date inDecUserEndedDate) {
        this.inDecUserEndedDate = inDecUserEndedDate;
    }

    public String getCommentEnded() {
        return commentEnded;
    }

    public void setCommentEnded(String commentEnded) {
        this.commentEnded = commentEnded;
    }

    public int getEndActiv() {
        return endActiv;
    }

    public void setEndActiv(int endActiv) {
        this.endActiv = endActiv;
    }

    public String getTpoId() {
        return tpoId;
    }

    public void setTpoId(String tpoId) {
        this.tpoId = tpoId;
    }

    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId;
    }

    public String getG3a() {
        return g3a;
    }

    public void setG3a(String g3a) {
        this.g3a = g3a;
    }

    public Date getG3b() {
        return g3b;
    }

    public void setG3b(Date g3b) {
        this.g3b = g3b;
    }

    public String getG3c() {
        return g3c;
    }

    public void setG3c(String g3c) {
        this.g3c = g3c;
    }

    public BigDecimal getG19Base() {
        return g19Base;
    }

    public void setG19Base(BigDecimal g19Base) {
        this.g19Base = g19Base;
    }

    public String getStavka() {
        return stavka;
    }

    public void setStavka(String stavka) {
        this.stavka = stavka;
    }

    public BigDecimal getG19Sum() {
        return g19Sum;
    }

    public void setG19Sum(BigDecimal g19Sum) {
        this.g19Sum = g19Sum;
    }

    public String getVersionNum() {
        return versionNum;
    }

    public void setVersionNum(String versionNum) {
        this.versionNum = versionNum;
    }
}
