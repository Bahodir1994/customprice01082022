package uz.customs.customsprice.entity.Rate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "RATE_20", schema = "NEW_EINFO", catalog = "")
public class Rate20 {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "TNVED")
    private String tnved;
    @Basic
    @Column(name = "UNIT")
    private String unit;
    @Basic
    @Column(name = "TYPE_RATE")
    private short typeRate;
    @Basic
    @Column(name = "ADV_RATE")
    private BigDecimal advRate;
    @Basic
    @Column(name = "ALT_RATE")
    private BigDecimal altRate;
    @Basic
    @Column(name = "UNIT_RATE_CODE")
    private String unitRateCode;
    @Basic
    @Column(name = "DOC_NO_DATE")
    private String docNoDate;
    @Basic
    @Column(name = "NOTE")
    private String note;
    @Basic
    @Column(name = "START_DATE")
    private Date startDate;
    @Basic
    @Column(name = "FINISH_DATE")
    private Date finishDate;
    @Basic
    @Column(name = "INS_TIME")
    private Timestamp insTime;
    @Basic
    @Column(name = "UPD_TIME")
    private Timestamp updTime;
    @Basic
    @Column(name = "USER_ID")
    private String userId;
    @Basic
    @Column(name = "LEXUZ")
    private String lexuz;
    @Basic
    @Column(name = "UPD_USER")
    private String updUser;
    @Basic
    @Column(name = "ISDELETED")
    private short isdeleted;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTnved() {
        return tnved;
    }

    public void setTnved(String tnved) {
        this.tnved = tnved;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public short getTypeRate() {
        return typeRate;
    }

    public void setTypeRate(short typeRate) {
        this.typeRate = typeRate;
    }

    public BigDecimal getAdvRate() {
        return advRate;
    }

    public void setAdvRate(BigDecimal advRate) {
        this.advRate = advRate;
    }

    public BigDecimal getAltRate() {
        return altRate;
    }

    public void setAltRate(BigDecimal altRate) {
        this.altRate = altRate;
    }

    public String getUnitRateCode() {
        return unitRateCode;
    }

    public void setUnitRateCode(String unitRateCode) {
        this.unitRateCode = unitRateCode;
    }

    public String getDocNoDate() {
        return docNoDate;
    }

    public void setDocNoDate(String docNoDate) {
        this.docNoDate = docNoDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public Timestamp getInsTime() {
        return insTime;
    }

    public void setInsTime(Timestamp insTime) {
        this.insTime = insTime;
    }

    public Timestamp getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Timestamp updTime) {
        this.updTime = updTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLexuz() {
        return lexuz;
    }

    public void setLexuz(String lexuz) {
        this.lexuz = lexuz;
    }

    public String getUpdUser() {
        return updUser;
    }

    public void setUpdUser(String updUser) {
        this.updUser = updUser;
    }

    public short getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(short isdeleted) {
        this.isdeleted = isdeleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rate20 rate20 = (Rate20) o;
        return id == rate20.id && typeRate == rate20.typeRate && isdeleted == rate20.isdeleted && Objects.equals(tnved, rate20.tnved) && Objects.equals(unit, rate20.unit) && Objects.equals(advRate, rate20.advRate) && Objects.equals(altRate, rate20.altRate) && Objects.equals(unitRateCode, rate20.unitRateCode) && Objects.equals(docNoDate, rate20.docNoDate) && Objects.equals(note, rate20.note) && Objects.equals(startDate, rate20.startDate) && Objects.equals(finishDate, rate20.finishDate) && Objects.equals(insTime, rate20.insTime) && Objects.equals(updTime, rate20.updTime) && Objects.equals(userId, rate20.userId) && Objects.equals(lexuz, rate20.lexuz) && Objects.equals(updUser, rate20.updUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tnved, unit, typeRate, advRate, altRate, unitRateCode, docNoDate, note, startDate, finishDate, insTime, updTime, userId, lexuz, updUser, isdeleted);
    }
}
