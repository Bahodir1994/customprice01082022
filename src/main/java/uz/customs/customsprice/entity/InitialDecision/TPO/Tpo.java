package uz.customs.customsprice.entity.InitialDecision.TPO;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Tpo {
    private String id;
    private String ugtkId;
    private String blank;
    private String g3A;
    private Date g3B;
    private String g3C;
    private Integer num;
    private String punkt;
    private String g1A;
    private String g1B;
    private String g1C;
    private String g2;
    private String g4Name;
    private String g4Adres;
    private String g4Docum;
    private String inn;
    private String mfo;
    private String bank;
    private String rs;
    private BigDecimal g5;
    private BigDecimal g6;
    private String g14;
    private String g15;
    private String g20;
    private String g21;
    private String g22;
    private String tip;
    private Short status;
    private Short flag;
    private Date dataOplat;
    private BigDecimal sumOplat;
    private String kvit;
    private Timestamp annulData;
    private String annulId;
    private String prichina;
    private Timestamp editData;
    private String editId;
    private String editDoc;
    private String oldTpo;
    private Timestamp regtime;
    private String userId;
    private String lastuserid;
    private Timestamp instime;
    private Timestamp updtime;
    private String dop;
    private Short oplat;
    private short kkdg;
    private String g6Kod;
    private BigDecimal g6Val;
    private String pinfl;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "UGTK_ID")
    public String getUgtkId() {
        return ugtkId;
    }

    public void setUgtkId(String ugtkId) {
        this.ugtkId = ugtkId;
    }

    @Basic
    @Column(name = "BLANK")
    public String getBlank() {
        return blank;
    }

    public void setBlank(String blank) {
        this.blank = blank;
    }

    @Basic
    @Column(name = "G3A")
    public String getG3A() {
        return g3A;
    }

    public void setG3A(String g3A) {
        this.g3A = g3A;
    }

    @Basic
    @Column(name = "G3B")
    public Date getG3B() {
        return g3B;
    }

    public void setG3B(Date g3B) {
        this.g3B = g3B;
    }

    @Basic
    @Column(name = "G3C")
    public String getG3C() {
        return g3C;
    }

    public void setG3C(String g3C) {
        this.g3C = g3C;
    }

    @Basic
    @Column(name = "NUM")
    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Basic
    @Column(name = "PUNKT")
    public String getPunkt() {
        return punkt;
    }

    public void setPunkt(String punkt) {
        this.punkt = punkt;
    }

    @Basic
    @Column(name = "G1A")
    public String getG1A() {
        return g1A;
    }

    public void setG1A(String g1A) {
        this.g1A = g1A;
    }

    @Basic
    @Column(name = "G1B")
    public String getG1B() {
        return g1B;
    }

    public void setG1B(String g1B) {
        this.g1B = g1B;
    }

    @Basic
    @Column(name = "G1C")
    public String getG1C() {
        return g1C;
    }

    public void setG1C(String g1C) {
        this.g1C = g1C;
    }

    @Basic
    @Column(name = "G2")
    public String getG2() {
        return g2;
    }

    public void setG2(String g2) {
        this.g2 = g2;
    }

    @Basic
    @Column(name = "G4NAME")
    public String getG4Name() {
        return g4Name;
    }

    public void setG4Name(String g4Name) {
        this.g4Name = g4Name;
    }

    @Basic
    @Column(name = "G4ADRES")
    public String getG4Adres() {
        return g4Adres;
    }

    public void setG4Adres(String g4Adres) {
        this.g4Adres = g4Adres;
    }

    @Basic
    @Column(name = "G4DOCUM")
    public String getG4Docum() {
        return g4Docum;
    }

    public void setG4Docum(String g4Docum) {
        this.g4Docum = g4Docum;
    }

    @Basic
    @Column(name = "INN")
    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    @Basic
    @Column(name = "MFO")
    public String getMfo() {
        return mfo;
    }

    public void setMfo(String mfo) {
        this.mfo = mfo;
    }

    @Basic
    @Column(name = "BANK")
    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    @Basic
    @Column(name = "RS")
    public String getRs() {
        return rs;
    }

    public void setRs(String rs) {
        this.rs = rs;
    }

    @Basic
    @Column(name = "G5")
    public BigDecimal getG5() {
        return g5;
    }

    public void setG5(BigDecimal g5) {
        this.g5 = g5;
    }

    @Basic
    @Column(name = "G6")
    public BigDecimal getG6() {
        return g6;
    }

    public void setG6(BigDecimal g6) {
        this.g6 = g6;
    }

    @Basic
    @Column(name = "G14")
    public String getG14() {
        return g14;
    }

    public void setG14(String g14) {
        this.g14 = g14;
    }

    @Basic
    @Column(name = "G15")
    public String getG15() {
        return g15;
    }

    public void setG15(String g15) {
        this.g15 = g15;
    }

    @Basic
    @Column(name = "G20")
    public String getG20() {
        return g20;
    }

    public void setG20(String g20) {
        this.g20 = g20;
    }

    @Basic
    @Column(name = "G21")
    public String getG21() {
        return g21;
    }

    public void setG21(String g21) {
        this.g21 = g21;
    }

    @Basic
    @Column(name = "G22")
    public String getG22() {
        return g22;
    }

    public void setG22(String g22) {
        this.g22 = g22;
    }

    @Basic
    @Column(name = "TIP")
    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    @Basic
    @Column(name = "STATUS")
    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    @Basic
    @Column(name = "FLAG")
    public Short getFlag() {
        return flag;
    }

    public void setFlag(Short flag) {
        this.flag = flag;
    }

    @Basic
    @Column(name = "DATA_OPLAT")
    public Date getDataOplat() {
        return dataOplat;
    }

    public void setDataOplat(Date dataOplat) {
        this.dataOplat = dataOplat;
    }

    @Basic
    @Column(name = "SUM_OPLAT")
    public BigDecimal getSumOplat() {
        return sumOplat;
    }

    public void setSumOplat(BigDecimal sumOplat) {
        this.sumOplat = sumOplat;
    }

    @Basic
    @Column(name = "KVIT")
    public String getKvit() {
        return kvit;
    }

    public void setKvit(String kvit) {
        this.kvit = kvit;
    }

    @Basic
    @Column(name = "ANNUL_DATA")
    public Timestamp getAnnulData() {
        return annulData;
    }

    public void setAnnulData(Timestamp annulData) {
        this.annulData = annulData;
    }

    @Basic
    @Column(name = "ANNUL_ID")
    public String getAnnulId() {
        return annulId;
    }

    public void setAnnulId(String annulId) {
        this.annulId = annulId;
    }

    @Basic
    @Column(name = "PRICHINA")
    public String getPrichina() {
        return prichina;
    }

    public void setPrichina(String prichina) {
        this.prichina = prichina;
    }

    @Basic
    @Column(name = "EDIT_DATA")
    public Timestamp getEditData() {
        return editData;
    }

    public void setEditData(Timestamp editData) {
        this.editData = editData;
    }

    @Basic
    @Column(name = "EDIT_ID")
    public String getEditId() {
        return editId;
    }

    public void setEditId(String editId) {
        this.editId = editId;
    }

    @Basic
    @Column(name = "EDIT_DOC")
    public String getEditDoc() {
        return editDoc;
    }

    public void setEditDoc(String editDoc) {
        this.editDoc = editDoc;
    }

    @Basic
    @Column(name = "OLD_TPO")
    public String getOldTpo() {
        return oldTpo;
    }

    public void setOldTpo(String oldTpo) {
        this.oldTpo = oldTpo;
    }

    @Basic
    @Column(name = "REGTIME")
    public Timestamp getRegtime() {
        return regtime;
    }

    public void setRegtime(Timestamp regtime) {
        this.regtime = regtime;
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

    @Basic
    @Column(name = "DOP")
    public String getDop() {
        return dop;
    }

    public void setDop(String dop) {
        this.dop = dop;
    }

    @Basic
    @Column(name = "OPLAT")
    public Short getOplat() {
        return oplat;
    }

    public void setOplat(Short oplat) {
        this.oplat = oplat;
    }

    @Basic
    @Column(name = "KKDG")
    public short getKkdg() {
        return kkdg;
    }

    public void setKkdg(short kkdg) {
        this.kkdg = kkdg;
    }

    @Basic
    @Column(name = "G6_KOD")
    public String getG6Kod() {
        return g6Kod;
    }

    public void setG6Kod(String g6Kod) {
        this.g6Kod = g6Kod;
    }

    @Basic
    @Column(name = "G6_VAL")
    public BigDecimal getG6Val() {
        return g6Val;
    }

    public void setG6Val(BigDecimal g6Val) {
        this.g6Val = g6Val;
    }

    @Basic
    @Column(name = "PINFL")
    public String getPinfl() {
        return pinfl;
    }

    public void setPinfl(String pinfl) {
        this.pinfl = pinfl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tpo tpo = (Tpo) o;
        return kkdg == tpo.kkdg && Objects.equals(id, tpo.id) && Objects.equals(ugtkId, tpo.ugtkId) && Objects.equals(blank, tpo.blank) && Objects.equals(g3A, tpo.g3A) && Objects.equals(g3B, tpo.g3B) && Objects.equals(g3C, tpo.g3C) && Objects.equals(num, tpo.num) && Objects.equals(punkt, tpo.punkt) && Objects.equals(g1A, tpo.g1A) && Objects.equals(g1B, tpo.g1B) && Objects.equals(g1C, tpo.g1C) && Objects.equals(g2, tpo.g2) && Objects.equals(g4Name, tpo.g4Name) && Objects.equals(g4Adres, tpo.g4Adres) && Objects.equals(g4Docum, tpo.g4Docum) && Objects.equals(inn, tpo.inn) && Objects.equals(mfo, tpo.mfo) && Objects.equals(bank, tpo.bank) && Objects.equals(rs, tpo.rs) && Objects.equals(g5, tpo.g5) && Objects.equals(g6, tpo.g6) && Objects.equals(g14, tpo.g14) && Objects.equals(g15, tpo.g15) && Objects.equals(g20, tpo.g20) && Objects.equals(g21, tpo.g21) && Objects.equals(g22, tpo.g22) && Objects.equals(tip, tpo.tip) && Objects.equals(status, tpo.status) && Objects.equals(flag, tpo.flag) && Objects.equals(dataOplat, tpo.dataOplat) && Objects.equals(sumOplat, tpo.sumOplat) && Objects.equals(kvit, tpo.kvit) && Objects.equals(annulData, tpo.annulData) && Objects.equals(annulId, tpo.annulId) && Objects.equals(prichina, tpo.prichina) && Objects.equals(editData, tpo.editData) && Objects.equals(editId, tpo.editId) && Objects.equals(editDoc, tpo.editDoc) && Objects.equals(oldTpo, tpo.oldTpo) && Objects.equals(regtime, tpo.regtime) && Objects.equals(userId, tpo.userId) && Objects.equals(lastuserid, tpo.lastuserid) && Objects.equals(instime, tpo.instime) && Objects.equals(updtime, tpo.updtime) && Objects.equals(dop, tpo.dop) && Objects.equals(oplat, tpo.oplat) && Objects.equals(g6Kod, tpo.g6Kod) && Objects.equals(g6Val, tpo.g6Val) && Objects.equals(pinfl, tpo.pinfl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ugtkId, blank, g3A, g3B, g3C, num, punkt, g1A, g1B, g1C, g2, g4Name, g4Adres, g4Docum, inn, mfo, bank, rs, g5, g6, g14, g15, g20, g21, g22, tip, status, flag, dataOplat, sumOplat, kvit, annulData, annulId, prichina, editData, editId, editDoc, oldTpo, regtime, userId, lastuserid, instime, updtime, dop, oplat, kkdg, g6Kod, g6Val, pinfl);
    }
}
