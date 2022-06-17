package uz.customs.customsprice.entity.CostMonitoring;

import com.vladmihalcea.hibernate.type.json.JsonStringType;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "MTC_REPL", schema = "CP", indexes = {@Index(columnList = "id_mtc", unique = true)})
@TypeDef(name = "jsonb", typeClass = JsonStringType.class)
//@SQLDelete(sql = "update MTC_REPL set isdeleted = 1 where id_mtc = ?")
//@Where(clause = "isdeleted = 0")
public class MtcReplEntity {
    @Basic
    @Column(name = "ID")
    private String id;
    @Basic
    @Column(name = "DECL_ID")
    private String declId;
    @Basic
    @Column(name = "CMDT_ID")
    private String cmdtId;
    @Basic
    @Column(name = "G7A")
    private String g7A;
    @Basic
    @Column(name = "G7B")
    private Date g7B;
    @Basic
    @Column(name = "G7C")
    private String g7C;
    @Basic
    @Column(name = "G1A")
    private String g1A;
    @Basic
    @Column(name = "G1B")
    private String g1B;
    @Basic
    @Column(name = "G2NAME")
    private String g2Name;
    @Basic
    @Column(name = "G2CODE2")
    private String g2Code2;
    @Basic
    @Column(name = "G8NAME")
    private String g8Name;
    @Basic
    @Column(name = "G8CODE2")
    private String g8Code2;
    @Basic
    @Column(name = "G9NAME")
    private String g9Name;
    @Basic
    @Column(name = "G9CODE2")
    private String g9Code2;
    @Basic
    @Column(name = "G11")
    private String g11;
    @Basic
    @Column(name = "G11_NM")
    private String g11Nm;
    @Basic
    @Column(name = "G12")
    private BigDecimal g12;
    @Basic
    @Column(name = "G13")
    private BigDecimal g13;
    @Basic
    @Column(name = "G15")
    private String g15;
    @Basic
    @Column(name = "G15_NM")
    private String g15Nm;
    @Basic
    @Column(name = "G17")
    private String g17;
    @Basic
    @Column(name = "G17_NM")
    private String g17Nm;
    @Basic
    @Column(name = "G20B")
    private String g20B;
    @Basic
    @Column(name = "G20NAME")
    private String g20Name;
    @Basic
    @Column(name = "G22A")
    private String g22A;
    @Basic
    @Column(name = "G22B")
    private BigDecimal g22B;
    @Basic
    @Column(name = "G23")
    private BigDecimal g23;
    @Basic
    @Column(name = "G23SCALE")
    private BigDecimal g23Scale;
    @Basic
    @Column(name = "G25")
    private String g25;
    @Basic
    @Column(name = "G26")
    private String g26;
    @Basic
    @Column(name = "G20FR")
    private String g20Fr;
    @Basic
    @Column(name = "G24A")
    private String g24A;
    @Basic
    @Column(name = "G24B")
    private String g24B;
    @Basic
    @Column(name = "IDN")
    private String idn;
    @Basic
    @Column(name = "G31NAME")
    private String g31Name;
    @Basic
    @Column(name = "G31MARKA")
    private String g31Marka;
    @Basic
    @Column(name = "G31AMOUNT")
    private BigDecimal g31Amount;
    @Basic
    @Column(name = "G32")
    private Short g32;
    @Basic
    @Column(name = "G33")
    private String g33;
    @Basic
    @Column(name = "G34")
    private String g34;
    @Basic
    @Column(name = "G34_NM")
    private String g34Nm;
    @Basic
    @Column(name = "G35")
    private BigDecimal g35;
    @Basic
    @Column(name = "G37B")
    private String g37B;
    @Basic
    @Column(name = "G37C")
    private String g37C;
    @Basic
    @Column(name = "G38")
    private BigDecimal g38;
    @Basic
    @Column(name = "G41")
    private String g41;
    @Basic
    @Column(name = "G41_NM")
    private String g41Nm;
    @Basic
    @Column(name = "G42")
    private BigDecimal g42;
    @Basic
    @Column(name = "G43")
    private String g43;
    @Basic
    @Column(name = "G45")
    private BigDecimal g45;
    @Basic
    @Column(name = "G46")
    private BigDecimal g46;
    @Basic
    @Column(name = "G31EDIZM")
    private String g31Edizm;
    @Basic
    @Column(name = "G45USD")
    private BigDecimal g45Usd2;
    @Basic
    @Column(name = "UNITNAME")
    private String unitname;
    @Basic
    @Column(name = "VES_EDIZM")
    private BigDecimal vesEdizm;
    @Basic
    @Column(name = "METOD_OTC")
    private String metodOtc;
    @Basic
    @Column(name = "G45_USD")
    private BigDecimal g45Usd;
    @Basic
    @Column(name = "G45USD_EDIZM")
    private BigDecimal g45UsdEdizm;
    @Basic
    @Column(name = "G45SUM_EDIZM")
    private BigDecimal g45SumEdizm;
    @Basic
    @Column(name = "G45_INDEX")
    private BigDecimal g45Index;
    @Basic
    @Column(name = "G45_EDIZM_VALKONT")
    private BigDecimal g45EdizmValkont;
    @Basic
    @Column(name = "G45_INDEX_VALKONT")
    private BigDecimal g45IndexValkont;
    @Basic
    @Column(name = "G42_USD")
    private BigDecimal g42Usd;
    @Basic
    @Column(name = "G42USD_EDIZM")
    private BigDecimal g42UsdEdizm;
    @Basic
    @Column(name = "G42SUM_EDIZM")
    private BigDecimal g42SumEdizm;
    @Basic
    @Column(name = "G42_INDEX")
    private BigDecimal g42Index;
    @Basic
    @Column(name = "G42_EDIZM_VALKONT")
    private BigDecimal g42EdizmValkont;
    @Basic
    @Column(name = "G42_INDEX_VALKONT")
    private BigDecimal g42IndexValkont;
    @Basic
    @Column(name = "GC3DATE")
    private Date gc3Date;
    @Basic
    @Column(name = "VID_TULOV")
    private Short vidTulov;
    @Basic
    @Column(name = "DOC_TYPE")
    private Short docType;
    @Basic
    @Column(name = "GDVIPDATE")
    private Date gdvipdate;
    @Basic
    @Column(name = "STATUS")
    private Short status;
    @Basic
    @Column(name = "INSTIME")
    private Timestamp instime;
    @Basic
    @Column(name = "UPDTIME")
    private Timestamp updtime;
    @Basic
    @Column(name = "CURTIME")
    private Timestamp curtime;
    @Basic
    @Column(name = "MTCID")
    private Integer mtcid;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_MTC")
    private Integer idMtc;

    public MtcReplEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeclId() {
        return declId;
    }

    public void setDeclId(String declId) {
        this.declId = declId;
    }

    public String getCmdtId() {
        return cmdtId;
    }

    public void setCmdtId(String cmdtId) {
        this.cmdtId = cmdtId;
    }

    public String getG7A() {
        return g7A;
    }

    public void setG7A(String g7A) {
        this.g7A = g7A;
    }

    public Date getG7B() {
        return g7B;
    }

    public void setG7B(Date g7B) {
        this.g7B = g7B;
    }

    public String getG7C() {
        return g7C;
    }

    public void setG7C(String g7C) {
        this.g7C = g7C;
    }

    public String getG1A() {
        return g1A;
    }

    public void setG1A(String g1A) {
        this.g1A = g1A;
    }

    public String getG1B() {
        return g1B;
    }

    public void setG1B(String g1B) {
        this.g1B = g1B;
    }

    public String getG2Name() {
        return g2Name;
    }

    public void setG2Name(String g2Name) {
        this.g2Name = g2Name;
    }

    public String getG2Code2() {
        return g2Code2;
    }

    public void setG2Code2(String g2Code2) {
        this.g2Code2 = g2Code2;
    }

    public String getG8Name() {
        return g8Name;
    }

    public void setG8Name(String g8Name) {
        this.g8Name = g8Name;
    }

    public String getG8Code2() {
        return g8Code2;
    }

    public void setG8Code2(String g8Code2) {
        this.g8Code2 = g8Code2;
    }

    public String getG9Name() {
        return g9Name;
    }

    public void setG9Name(String g9Name) {
        this.g9Name = g9Name;
    }

    public String getG9Code2() {
        return g9Code2;
    }

    public void setG9Code2(String g9Code2) {
        this.g9Code2 = g9Code2;
    }

    public String getG11() {
        return g11;
    }

    public void setG11(String g11) {
        this.g11 = g11;
    }

    public String getG11Nm() {
        return g11Nm;
    }

    public void setG11Nm(String g11Nm) {
        this.g11Nm = g11Nm;
    }

    public BigDecimal getG12() {
        return g12;
    }

    public void setG12(BigDecimal g12) {
        this.g12 = g12;
    }

    public BigDecimal getG13() {
        return g13;
    }

    public void setG13(BigDecimal g13) {
        this.g13 = g13;
    }

    public String getG15() {
        return g15;
    }

    public void setG15(String g15) {
        this.g15 = g15;
    }

    public String getG15Nm() {
        return g15Nm;
    }

    public void setG15Nm(String g15Nm) {
        this.g15Nm = g15Nm;
    }

    public String getG17() {
        return g17;
    }

    public void setG17(String g17) {
        this.g17 = g17;
    }

    public String getG17Nm() {
        return g17Nm;
    }

    public void setG17Nm(String g17Nm) {
        this.g17Nm = g17Nm;
    }

    public String getG20B() {
        return g20B;
    }

    public void setG20B(String g20B) {
        this.g20B = g20B;
    }

    public String getG20Name() {
        return g20Name;
    }

    public void setG20Name(String g20Name) {
        this.g20Name = g20Name;
    }

    public String getG22A() {
        return g22A;
    }

    public void setG22A(String g22A) {
        this.g22A = g22A;
    }

    public BigDecimal getG22B() {
        return g22B;
    }

    public void setG22B(BigDecimal g22B) {
        this.g22B = g22B;
    }

    public BigDecimal getG23() {
        return g23;
    }

    public void setG23(BigDecimal g23) {
        this.g23 = g23;
    }

    public BigDecimal getG23Scale() {
        return g23Scale;
    }

    public void setG23Scale(BigDecimal g23Scale) {
        this.g23Scale = g23Scale;
    }

    public String getG25() {
        return g25;
    }

    public void setG25(String g25) {
        this.g25 = g25;
    }

    public String getG26() {
        return g26;
    }

    public void setG26(String g26) {
        this.g26 = g26;
    }

    public String getG20Fr() {
        return g20Fr;
    }

    public void setG20Fr(String g20Fr) {
        this.g20Fr = g20Fr;
    }

    public String getG24A() {
        return g24A;
    }

    public void setG24A(String g24A) {
        this.g24A = g24A;
    }

    public String getG24B() {
        return g24B;
    }

    public void setG24B(String g24B) {
        this.g24B = g24B;
    }

    public String getIdn() {
        return idn;
    }

    public void setIdn(String idn) {
        this.idn = idn;
    }

    public String getG31Name() {
        return g31Name;
    }

    public void setG31Name(String g31Name) {
        this.g31Name = g31Name;
    }

    public String getG31Marka() {
        return g31Marka;
    }

    public void setG31Marka(String g31Marka) {
        this.g31Marka = g31Marka;
    }

    public BigDecimal getG31Amount() {
        return g31Amount;
    }

    public void setG31Amount(BigDecimal g31Amount) {
        this.g31Amount = g31Amount;
    }

    public Short getG32() {
        return g32;
    }

    public void setG32(Short g32) {
        this.g32 = g32;
    }

    public String getG33() {
        return g33;
    }

    public void setG33(String g33) {
        this.g33 = g33;
    }

    public String getG34() {
        return g34;
    }

    public void setG34(String g34) {
        this.g34 = g34;
    }

    public String getG34Nm() {
        return g34Nm;
    }

    public void setG34Nm(String g34Nm) {
        this.g34Nm = g34Nm;
    }

    public BigDecimal getG35() {
        return g35;
    }

    public void setG35(BigDecimal g35) {
        this.g35 = g35;
    }

    public String getG37B() {
        return g37B;
    }

    public void setG37B(String g37B) {
        this.g37B = g37B;
    }

    public String getG37C() {
        return g37C;
    }

    public void setG37C(String g37C) {
        this.g37C = g37C;
    }

    public BigDecimal getG38() {
        return g38;
    }

    public void setG38(BigDecimal g38) {
        this.g38 = g38;
    }

    public String getG41() {
        return g41;
    }

    public void setG41(String g41) {
        this.g41 = g41;
    }

    public String getG41Nm() {
        return g41Nm;
    }

    public void setG41Nm(String g41Nm) {
        this.g41Nm = g41Nm;
    }

    public BigDecimal getG42() {
        return g42;
    }

    public void setG42(BigDecimal g42) {
        this.g42 = g42;
    }

    public String getG43() {
        return g43;
    }

    public void setG43(String g43) {
        this.g43 = g43;
    }

    public BigDecimal getG45() {
        return g45;
    }

    public void setG45(BigDecimal g45) {
        this.g45 = g45;
    }

    public BigDecimal getG46() {
        return g46;
    }

    public void setG46(BigDecimal g46) {
        this.g46 = g46;
    }

    public String getG31Edizm() {
        return g31Edizm;
    }

    public void setG31Edizm(String g31Edizm) {
        this.g31Edizm = g31Edizm;
    }

    public BigDecimal getG45Usd2() {
        return g45Usd2;
    }

    public void setG45Usd2(BigDecimal g45Usd2) {
        this.g45Usd2 = g45Usd2;
    }

    public String getUnitname() {
        return unitname;
    }

    public void setUnitname(String unitname) {
        this.unitname = unitname;
    }

    public BigDecimal getVesEdizm() {
        return vesEdizm;
    }

    public void setVesEdizm(BigDecimal vesEdizm) {
        this.vesEdizm = vesEdizm;
    }

    public String getMetodOtc() {
        return metodOtc;
    }

    public void setMetodOtc(String metodOtc) {
        this.metodOtc = metodOtc;
    }

    public BigDecimal getG45Usd() {
        return g45Usd;
    }

    public void setG45Usd(BigDecimal g45Usd) {
        this.g45Usd = g45Usd;
    }

    public BigDecimal getG45UsdEdizm() {
        return g45UsdEdizm;
    }

    public void setG45UsdEdizm(BigDecimal g45UsdEdizm) {
        this.g45UsdEdizm = g45UsdEdizm;
    }

    public BigDecimal getG45SumEdizm() {
        return g45SumEdizm;
    }

    public void setG45SumEdizm(BigDecimal g45SumEdizm) {
        this.g45SumEdizm = g45SumEdizm;
    }

    public BigDecimal getG45Index() {
        return g45Index;
    }

    public void setG45Index(BigDecimal g45Index) {
        this.g45Index = g45Index;
    }

    public BigDecimal getG45EdizmValkont() {
        return g45EdizmValkont;
    }

    public void setG45EdizmValkont(BigDecimal g45EdizmValkont) {
        this.g45EdizmValkont = g45EdizmValkont;
    }

    public BigDecimal getG45IndexValkont() {
        return g45IndexValkont;
    }

    public void setG45IndexValkont(BigDecimal g45IndexValkont) {
        this.g45IndexValkont = g45IndexValkont;
    }

    public BigDecimal getG42Usd() {
        return g42Usd;
    }

    public void setG42Usd(BigDecimal g42Usd) {
        this.g42Usd = g42Usd;
    }

    public BigDecimal getG42UsdEdizm() {
        return g42UsdEdizm;
    }

    public void setG42UsdEdizm(BigDecimal g42UsdEdizm) {
        this.g42UsdEdizm = g42UsdEdizm;
    }

    public BigDecimal getG42SumEdizm() {
        return g42SumEdizm;
    }

    public void setG42SumEdizm(BigDecimal g42SumEdizm) {
        this.g42SumEdizm = g42SumEdizm;
    }

    public BigDecimal getG42Index() {
        return g42Index;
    }

    public void setG42Index(BigDecimal g42Index) {
        this.g42Index = g42Index;
    }

    public BigDecimal getG42EdizmValkont() {
        return g42EdizmValkont;
    }

    public void setG42EdizmValkont(BigDecimal g42EdizmValkont) {
        this.g42EdizmValkont = g42EdizmValkont;
    }

    public BigDecimal getG42IndexValkont() {
        return g42IndexValkont;
    }

    public void setG42IndexValkont(BigDecimal g42IndexValkont) {
        this.g42IndexValkont = g42IndexValkont;
    }

    public Date getGc3Date() {
        return gc3Date;
    }

    public void setGc3Date(Date gc3Date) {
        this.gc3Date = gc3Date;
    }

    public Short getVidTulov() {
        return vidTulov;
    }

    public void setVidTulov(Short vidTulov) {
        this.vidTulov = vidTulov;
    }

    public Short getDocType() {
        return docType;
    }

    public void setDocType(Short docType) {
        this.docType = docType;
    }

    public Date getGdvipdate() {
        return gdvipdate;
    }

    public void setGdvipdate(Date gdvipdate) {
        this.gdvipdate = gdvipdate;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Timestamp getInstime() {
        return instime;
    }

    public void setInstime(Timestamp instime) {
        this.instime = instime;
    }

    public Timestamp getUpdtime() {
        return updtime;
    }

    public void setUpdtime(Timestamp updtime) {
        this.updtime = updtime;
    }

    public Timestamp getCurtime() {
        return curtime;
    }

    public void setCurtime(Timestamp curtime) {
        this.curtime = curtime;
    }

    public Integer getMtcid() {
        return mtcid;
    }

    public void setMtcid(Integer mtcid) {
        this.mtcid = mtcid;
    }

    public Integer getIdMtc() {
        return idMtc;
    }

    public void setIdMtc(Integer idMtc) {
        this.idMtc = idMtc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MtcReplEntity that = (MtcReplEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(declId, that.declId) && Objects.equals(cmdtId, that.cmdtId) && Objects.equals(g7A, that.g7A) && Objects.equals(g7B, that.g7B) && Objects.equals(g7C, that.g7C) && Objects.equals(g1A, that.g1A) && Objects.equals(g1B, that.g1B) && Objects.equals(g2Name, that.g2Name) && Objects.equals(g2Code2, that.g2Code2) && Objects.equals(g8Name, that.g8Name) && Objects.equals(g8Code2, that.g8Code2) && Objects.equals(g9Name, that.g9Name) && Objects.equals(g9Code2, that.g9Code2) && Objects.equals(g11, that.g11) && Objects.equals(g11Nm, that.g11Nm) && Objects.equals(g12, that.g12) && Objects.equals(g13, that.g13) && Objects.equals(g15, that.g15) && Objects.equals(g15Nm, that.g15Nm) && Objects.equals(g17, that.g17) && Objects.equals(g17Nm, that.g17Nm) && Objects.equals(g20B, that.g20B) && Objects.equals(g20Name, that.g20Name) && Objects.equals(g22A, that.g22A) && Objects.equals(g22B, that.g22B) && Objects.equals(g23, that.g23) && Objects.equals(g23Scale, that.g23Scale) && Objects.equals(g25, that.g25) && Objects.equals(g26, that.g26) && Objects.equals(g20Fr, that.g20Fr) && Objects.equals(g24A, that.g24A) && Objects.equals(g24B, that.g24B) && Objects.equals(idn, that.idn) && Objects.equals(g31Name, that.g31Name) && Objects.equals(g31Marka, that.g31Marka) && Objects.equals(g31Amount, that.g31Amount) && Objects.equals(g32, that.g32) && Objects.equals(g33, that.g33) && Objects.equals(g34, that.g34) && Objects.equals(g34Nm, that.g34Nm) && Objects.equals(g35, that.g35) && Objects.equals(g37B, that.g37B) && Objects.equals(g37C, that.g37C) && Objects.equals(g38, that.g38) && Objects.equals(g41, that.g41) && Objects.equals(g41Nm, that.g41Nm) && Objects.equals(g42, that.g42) && Objects.equals(g43, that.g43) && Objects.equals(g45, that.g45) && Objects.equals(g46, that.g46) && Objects.equals(g31Edizm, that.g31Edizm) && Objects.equals(g45Usd2, that.g45Usd2) && Objects.equals(unitname, that.unitname) && Objects.equals(vesEdizm, that.vesEdizm) && Objects.equals(metodOtc, that.metodOtc) && Objects.equals(g45Usd, that.g45Usd) && Objects.equals(g45UsdEdizm, that.g45UsdEdizm) && Objects.equals(g45SumEdizm, that.g45SumEdizm) && Objects.equals(g45Index, that.g45Index) && Objects.equals(g45EdizmValkont, that.g45EdizmValkont) && Objects.equals(g45IndexValkont, that.g45IndexValkont) && Objects.equals(g42Usd, that.g42Usd) && Objects.equals(g42UsdEdizm, that.g42UsdEdizm) && Objects.equals(g42SumEdizm, that.g42SumEdizm) && Objects.equals(g42Index, that.g42Index) && Objects.equals(g42EdizmValkont, that.g42EdizmValkont) && Objects.equals(g42IndexValkont, that.g42IndexValkont) && Objects.equals(gc3Date, that.gc3Date) && Objects.equals(vidTulov, that.vidTulov) && Objects.equals(docType, that.docType) && Objects.equals(gdvipdate, that.gdvipdate) && Objects.equals(status, that.status) && Objects.equals(instime, that.instime) && Objects.equals(updtime, that.updtime) && Objects.equals(curtime, that.curtime) && Objects.equals(mtcid, that.mtcid) && Objects.equals(idMtc, that.idMtc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, declId, cmdtId, g7A, g7B, g7C, g1A, g1B, g2Name, g2Code2, g8Name, g8Code2, g9Name, g9Code2, g11, g11Nm, g12, g13, g15, g15Nm, g17, g17Nm, g20B, g20Name, g22A, g22B, g23, g23Scale, g25, g26, g20Fr, g24A, g24B, idn, g31Name, g31Marka, g31Amount, g32, g33, g34, g34Nm, g35, g37B, g37C, g38, g41, g41Nm, g42, g43, g45, g46, g31Edizm, g45Usd2, unitname, vesEdizm, metodOtc, g45Usd, g45UsdEdizm, g45SumEdizm, g45Index, g45EdizmValkont, g45IndexValkont, g42Usd, g42UsdEdizm, g42SumEdizm, g42Index, g42EdizmValkont, g42IndexValkont, gc3Date, vidTulov, docType, gdvipdate, status, instime, updtime, curtime, mtcid, idMtc);
    }
}
