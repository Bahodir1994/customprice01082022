package uz.customs.customsprice.entity.Rate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "RATE_29", schema = "NEW_EINFO", catalog = "")
public class Rate29 {
    @Basic
    @Column(name = "ID")
    private int id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "TNVED")
    private String tnved;
    @Basic
    @Column(name = "UNIT")
    private String unit;
    @Basic
    @Column(name = "VAT_RATE")
    private BigDecimal vatRate;
    @Basic
    @Column(name = "START_DATE")
    private Date startDate;
    @Basic
    @Column(name = "FINISH_DATE")
    private Date finishDate;
    @Basic
    @Column(name = "NOTE")
    private String note;
    @Basic
    @Column(name = "DOC_NO_DATE")
    private String docNoDate;
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

    public BigDecimal getVatRate() {
        return vatRate;
    }

    public void setVatRate(BigDecimal vatRate) {
        this.vatRate = vatRate;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDocNoDate() {
        return docNoDate;
    }

    public void setDocNoDate(String docNoDate) {
        this.docNoDate = docNoDate;
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
        Rate29 rate29 = (Rate29) o;
        return id == rate29.id && isdeleted == rate29.isdeleted && Objects.equals(tnved, rate29.tnved) && Objects.equals(unit, rate29.unit) && Objects.equals(vatRate, rate29.vatRate) && Objects.equals(startDate, rate29.startDate) && Objects.equals(finishDate, rate29.finishDate) && Objects.equals(note, rate29.note) && Objects.equals(docNoDate, rate29.docNoDate) && Objects.equals(insTime, rate29.insTime) && Objects.equals(updTime, rate29.updTime) && Objects.equals(userId, rate29.userId) && Objects.equals(lexuz, rate29.lexuz) && Objects.equals(updUser, rate29.updUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tnved, unit, vatRate, startDate, finishDate, note, docNoDate, insTime, updTime, userId, lexuz, updUser, isdeleted);
    }
}
