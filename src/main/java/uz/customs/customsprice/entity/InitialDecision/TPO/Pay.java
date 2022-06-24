package uz.customs.customsprice.entity.InitialDecision.TPO;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Pay {
    private String idPay;
    private String idTov;
    private String idTpo;
    private String g19Type;
    private BigDecimal g19Base;
    private String stavka;
    private BigDecimal g19Altbase;
    private BigDecimal g19Rate;
    private BigDecimal g19Altrate;
    private String g19Currkod;
    private BigDecimal g19Sum;
    private String g19Sp;
    private Integer g19Clctype;
    private String dop;
    private String userId;
    private String lastuserid;
    private Timestamp instime;
    private Timestamp updtime;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_PAY")
    public String getIdPay() {
        return idPay;
    }

    public void setIdPay(String idPay) {
        this.idPay = idPay;
    }

    @Basic
    @Column(name = "ID_TOV")
    public String getIdTov() {
        return idTov;
    }

    public void setIdTov(String idTov) {
        this.idTov = idTov;
    }

    @Basic
    @Column(name = "ID_TPO")
    public String getIdTpo() {
        return idTpo;
    }

    public void setIdTpo(String idTpo) {
        this.idTpo = idTpo;
    }

    @Basic
    @Column(name = "G19TYPE")
    public String getG19Type() {
        return g19Type;
    }

    public void setG19Type(String g19Type) {
        this.g19Type = g19Type;
    }

    @Basic
    @Column(name = "G19BASE")
    public BigDecimal getG19Base() {
        return g19Base;
    }

    public void setG19Base(BigDecimal g19Base) {
        this.g19Base = g19Base;
    }

    @Basic
    @Column(name = "STAVKA")
    public String getStavka() {
        return stavka;
    }

    public void setStavka(String stavka) {
        this.stavka = stavka;
    }

    @Basic
    @Column(name = "G19ALTBASE")
    public BigDecimal getG19Altbase() {
        return g19Altbase;
    }

    public void setG19Altbase(BigDecimal g19Altbase) {
        this.g19Altbase = g19Altbase;
    }

    @Basic
    @Column(name = "G19RATE")
    public BigDecimal getG19Rate() {
        return g19Rate;
    }

    public void setG19Rate(BigDecimal g19Rate) {
        this.g19Rate = g19Rate;
    }

    @Basic
    @Column(name = "G19ALTRATE")
    public BigDecimal getG19Altrate() {
        return g19Altrate;
    }

    public void setG19Altrate(BigDecimal g19Altrate) {
        this.g19Altrate = g19Altrate;
    }

    @Basic
    @Column(name = "G19CURRKOD")
    public String getG19Currkod() {
        return g19Currkod;
    }

    public void setG19Currkod(String g19Currkod) {
        this.g19Currkod = g19Currkod;
    }

    @Basic
    @Column(name = "G19SUM")
    public BigDecimal getG19Sum() {
        return g19Sum;
    }

    public void setG19Sum(BigDecimal g19Sum) {
        this.g19Sum = g19Sum;
    }

    @Basic
    @Column(name = "G19SP")
    public String getG19Sp() {
        return g19Sp;
    }

    public void setG19Sp(String g19Sp) {
        this.g19Sp = g19Sp;
    }

    @Basic
    @Column(name = "G19CLCTYPE")
    public Integer getG19Clctype() {
        return g19Clctype;
    }

    public void setG19Clctype(Integer g19Clctype) {
        this.g19Clctype = g19Clctype;
    }

    @Basic
    @Column(name = "DOP")
    public String getDop() {
        return dop;
    }

    public void setDop(String dop) {
        this.dop = dop;
    }

    @Basic
    @Column(name = "USER_ID")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "LASTUSERID")
    public String getLastuserid() {
        return lastuserid;
    }

    public void setLastuserid(String lastuserid) {
        this.lastuserid = lastuserid;
    }

    @Basic
    @Column(name = "INSTIME")
    public Timestamp getInstime() {
        return instime;
    }

    public void setInstime(Timestamp instime) {
        this.instime = instime;
    }

    @Basic
    @Column(name = "UPDTIME")
    public Timestamp getUpdtime() {
        return updtime;
    }

    public void setUpdtime(Timestamp updtime) {
        this.updtime = updtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pay pay = (Pay) o;
        return Objects.equals(idPay, pay.idPay) && Objects.equals(idTov, pay.idTov) && Objects.equals(idTpo, pay.idTpo) && Objects.equals(g19Type, pay.g19Type) && Objects.equals(g19Base, pay.g19Base) && Objects.equals(stavka, pay.stavka) && Objects.equals(g19Altbase, pay.g19Altbase) && Objects.equals(g19Rate, pay.g19Rate) && Objects.equals(g19Altrate, pay.g19Altrate) && Objects.equals(g19Currkod, pay.g19Currkod) && Objects.equals(g19Sum, pay.g19Sum) && Objects.equals(g19Sp, pay.g19Sp) && Objects.equals(g19Clctype, pay.g19Clctype) && Objects.equals(dop, pay.dop) && Objects.equals(userId, pay.userId) && Objects.equals(lastuserid, pay.lastuserid) && Objects.equals(instime, pay.instime) && Objects.equals(updtime, pay.updtime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPay, idTov, idTpo, g19Type, g19Base, stavka, g19Altbase, g19Rate, g19Altrate, g19Currkod, g19Sum, g19Sp, g19Clctype, dop, userId, lastuserid, instime, updtime);
    }
}
