package uz.customs.customsprice.entity.CostMonitoring;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "MTC_REPL", schema = "EBR", catalog = "")
public class MtcRepl {
    private String id;
    private String declId;
    private String cmdtId;
    private String g7A;
    private Date g7B;
    private String g7C;
    private String g1A;
    private String g1B;
    private String g2Name;
    private String g2Code2;
    private String g8Name;
    private String g8Code2;
    private String g9Name;
    private String g9Code2;
    private String g11;
    private BigDecimal g12;
    private BigDecimal g13;
    private String g15;
    private String g17;
    private String g20B;
    private String g20Name;
    private String g22A;
    private BigDecimal g22B;
    private BigDecimal g23;
    private BigDecimal g23Scale;
    private String g25;
    private String g26;
    private String g20Fr;
    private String g24A;
    private String g24B;
    private String idn;
    private String g31Name;
    private String g31Marka;
    private BigDecimal g31Amount;
    private Short g32;
    private String g33;
    private String g34;
    private BigDecimal g35;
    private String g37B;
    private String g37C;
    private BigDecimal g38;
    private String g41;
    private BigDecimal g42;
    private String g43;
    private BigDecimal g45;
    private BigDecimal g46;
    private String g31Edizm;
    private BigDecimal g45Usd2;
    private String unitname;
    private BigDecimal vesEdizm;
    private String metodOtc;
    private BigDecimal g45Usd;
    private BigDecimal g45UsdEdizm;
    private BigDecimal g45SumEdizm;
    private BigDecimal g45Index;
    private BigDecimal g45EdizmValkont;
    private BigDecimal g45IndexValkont;
    private BigDecimal g42Usd;
    private BigDecimal g42UsdEdizm;
    private BigDecimal g42SumEdizm;
    private BigDecimal g42Index;
    private BigDecimal g42EdizmValkont;
    private BigDecimal g42IndexValkont;
    private Date gc3Date;
    private Short vidTulov;
    private Short docType;
    private Date gdvipdate;
    private Short status;
    private Timestamp instime;
    private Timestamp updtime;
    private Timestamp curtime;
    private Integer mtcid;
    private int idMtc;

    @Basic
    @Column(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "DECL_ID")
    public String getDeclId() {
        return declId;
    }

    public void setDeclId(String declId) {
        this.declId = declId;
    }

    @Basic
    @Column(name = "CMDT_ID")
    public String getCmdtId() {
        return cmdtId;
    }

    public void setCmdtId(String cmdtId) {
        this.cmdtId = cmdtId;
    }

    @Basic
    @Column(name = "G7A")
    public String getG7A() {
        return g7A;
    }

    public void setG7A(String g7A) {
        this.g7A = g7A;
    }

    @Basic
    @Column(name = "G7B")
    public Date getG7B() {
        return g7B;
    }

    public void setG7B(Date g7B) {
        this.g7B = g7B;
    }

    @Basic
    @Column(name = "G7C")
    public String getG7C() {
        return g7C;
    }

    public void setG7C(String g7C) {
        this.g7C = g7C;
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
    @Column(name = "G2NAME")
    public String getG2Name() {
        return g2Name;
    }

    public void setG2Name(String g2Name) {
        this.g2Name = g2Name;
    }

    @Basic
    @Column(name = "G2CODE2")
    public String getG2Code2() {
        return g2Code2;
    }

    public void setG2Code2(String g2Code2) {
        this.g2Code2 = g2Code2;
    }

    @Basic
    @Column(name = "G8NAME")
    public String getG8Name() {
        return g8Name;
    }

    public void setG8Name(String g8Name) {
        this.g8Name = g8Name;
    }

    @Basic
    @Column(name = "G8CODE2")
    public String getG8Code2() {
        return g8Code2;
    }

    public void setG8Code2(String g8Code2) {
        this.g8Code2 = g8Code2;
    }

    @Basic
    @Column(name = "G9NAME")
    public String getG9Name() {
        return g9Name;
    }

    public void setG9Name(String g9Name) {
        this.g9Name = g9Name;
    }

    @Basic
    @Column(name = "G9CODE2")
    public String getG9Code2() {
        return g9Code2;
    }

    public void setG9Code2(String g9Code2) {
        this.g9Code2 = g9Code2;
    }

    @Basic
    @Column(name = "G11")
    public String getG11() {
        return g11;
    }

    public void setG11(String g11) {
        this.g11 = g11;
    }

    @Basic
    @Column(name = "G12")
    public BigDecimal getG12() {
        return g12;
    }

    public void setG12(BigDecimal g12) {
        this.g12 = g12;
    }

    @Basic
    @Column(name = "G13")
    public BigDecimal getG13() {
        return g13;
    }

    public void setG13(BigDecimal g13) {
        this.g13 = g13;
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
    @Column(name = "G17")
    public String getG17() {
        return g17;
    }

    public void setG17(String g17) {
        this.g17 = g17;
    }

    @Basic
    @Column(name = "G20B")
    public String getG20B() {
        return g20B;
    }

    public void setG20B(String g20B) {
        this.g20B = g20B;
    }

    @Basic
    @Column(name = "G20NAME")
    public String getG20Name() {
        return g20Name;
    }

    public void setG20Name(String g20Name) {
        this.g20Name = g20Name;
    }

    @Basic
    @Column(name = "G22A")
    public String getG22A() {
        return g22A;
    }

    public void setG22A(String g22A) {
        this.g22A = g22A;
    }

    @Basic
    @Column(name = "G22B")
    public BigDecimal getG22B() {
        return g22B;
    }

    public void setG22B(BigDecimal g22B) {
        this.g22B = g22B;
    }

    @Basic
    @Column(name = "G23")
    public BigDecimal getG23() {
        return g23;
    }

    public void setG23(BigDecimal g23) {
        this.g23 = g23;
    }

    @Basic
    @Column(name = "G23SCALE")
    public BigDecimal getG23Scale() {
        return g23Scale;
    }

    public void setG23Scale(BigDecimal g23Scale) {
        this.g23Scale = g23Scale;
    }

    @Basic
    @Column(name = "G25")
    public String getG25() {
        return g25;
    }

    public void setG25(String g25) {
        this.g25 = g25;
    }

    @Basic
    @Column(name = "G26")
    public String getG26() {
        return g26;
    }

    public void setG26(String g26) {
        this.g26 = g26;
    }

    @Basic
    @Column(name = "G20FR")
    public String getG20Fr() {
        return g20Fr;
    }

    public void setG20Fr(String g20Fr) {
        this.g20Fr = g20Fr;
    }

    @Basic
    @Column(name = "G24A")
    public String getG24A() {
        return g24A;
    }

    public void setG24A(String g24A) {
        this.g24A = g24A;
    }

    @Basic
    @Column(name = "G24B")
    public String getG24B() {
        return g24B;
    }

    public void setG24B(String g24B) {
        this.g24B = g24B;
    }

    @Basic
    @Column(name = "IDN")
    public String getIdn() {
        return idn;
    }

    public void setIdn(String idn) {
        this.idn = idn;
    }

    @Basic
    @Column(name = "G31NAME")
    public String getG31Name() {
        return g31Name;
    }

    public void setG31Name(String g31Name) {
        this.g31Name = g31Name;
    }

    @Basic
    @Column(name = "G31MARKA")
    public String getG31Marka() {
        return g31Marka;
    }

    public void setG31Marka(String g31Marka) {
        this.g31Marka = g31Marka;
    }

    @Basic
    @Column(name = "G31AMOUNT")
    public BigDecimal getG31Amount() {
        return g31Amount;
    }

    public void setG31Amount(BigDecimal g31Amount) {
        this.g31Amount = g31Amount;
    }

    @Basic
    @Column(name = "G32")
    public Short getG32() {
        return g32;
    }

    public void setG32(Short g32) {
        this.g32 = g32;
    }

    @Basic
    @Column(name = "G33")
    public String getG33() {
        return g33;
    }

    public void setG33(String g33) {
        this.g33 = g33;
    }

    @Basic
    @Column(name = "G34")
    public String getG34() {
        return g34;
    }

    public void setG34(String g34) {
        this.g34 = g34;
    }

    @Basic
    @Column(name = "G35")
    public BigDecimal getG35() {
        return g35;
    }

    public void setG35(BigDecimal g35) {
        this.g35 = g35;
    }

    @Basic
    @Column(name = "G37B")
    public String getG37B() {
        return g37B;
    }

    public void setG37B(String g37B) {
        this.g37B = g37B;
    }

    @Basic
    @Column(name = "G37C")
    public String getG37C() {
        return g37C;
    }

    public void setG37C(String g37C) {
        this.g37C = g37C;
    }

    @Basic
    @Column(name = "G38")
    public BigDecimal getG38() {
        return g38;
    }

    public void setG38(BigDecimal g38) {
        this.g38 = g38;
    }

    @Basic
    @Column(name = "G41")
    public String getG41() {
        return g41;
    }

    public void setG41(String g41) {
        this.g41 = g41;
    }

    @Basic
    @Column(name = "G42")
    public BigDecimal getG42() {
        return g42;
    }

    public void setG42(BigDecimal g42) {
        this.g42 = g42;
    }

    @Basic
    @Column(name = "G43")
    public String getG43() {
        return g43;
    }

    public void setG43(String g43) {
        this.g43 = g43;
    }

    @Basic
    @Column(name = "G45")
    public BigDecimal getG45() {
        return g45;
    }

    public void setG45(BigDecimal g45) {
        this.g45 = g45;
    }

    @Basic
    @Column(name = "G46")
    public BigDecimal getG46() {
        return g46;
    }

    public void setG46(BigDecimal g46) {
        this.g46 = g46;
    }

    @Basic
    @Column(name = "G31EDIZM")
    public String getG31Edizm() {
        return g31Edizm;
    }

    public void setG31Edizm(String g31Edizm) {
        this.g31Edizm = g31Edizm;
    }

    @Basic
    @Column(name = "G45USD")
    public BigDecimal getG45Usd2() {
        return g45Usd2;
    }

    public void setG45Usd2(BigDecimal g45Usd2) {
        this.g45Usd2 = g45Usd2;
    }

    @Basic
    @Column(name = "UNITNAME")
    public String getUnitname() {
        return unitname;
    }

    public void setUnitname(String unitname) {
        this.unitname = unitname;
    }

    @Basic
    @Column(name = "VES_EDIZM")
    public BigDecimal getVesEdizm() {
        return vesEdizm;
    }

    public void setVesEdizm(BigDecimal vesEdizm) {
        this.vesEdizm = vesEdizm;
    }

    @Basic
    @Column(name = "METOD_OTC")
    public String getMetodOtc() {
        return metodOtc;
    }

    public void setMetodOtc(String metodOtc) {
        this.metodOtc = metodOtc;
    }

    @Basic
    @Column(name = "G45_USD")
    public BigDecimal getG45Usd() {
        return g45Usd;
    }

    public void setG45Usd(BigDecimal g45Usd) {
        this.g45Usd = g45Usd;
    }

    @Basic
    @Column(name = "G45USD_EDIZM")
    public BigDecimal getG45UsdEdizm() {
        return g45UsdEdizm;
    }

    public void setG45UsdEdizm(BigDecimal g45UsdEdizm) {
        this.g45UsdEdizm = g45UsdEdizm;
    }

    @Basic
    @Column(name = "G45SUM_EDIZM")
    public BigDecimal getG45SumEdizm() {
        return g45SumEdizm;
    }

    public void setG45SumEdizm(BigDecimal g45SumEdizm) {
        this.g45SumEdizm = g45SumEdizm;
    }

    @Basic
    @Column(name = "G45_INDEX")
    public BigDecimal getG45Index() {
        return g45Index;
    }

    public void setG45Index(BigDecimal g45Index) {
        this.g45Index = g45Index;
    }

    @Basic
    @Column(name = "G45_EDIZM_VALKONT")
    public BigDecimal getG45EdizmValkont() {
        return g45EdizmValkont;
    }

    public void setG45EdizmValkont(BigDecimal g45EdizmValkont) {
        this.g45EdizmValkont = g45EdizmValkont;
    }

    @Basic
    @Column(name = "G45_INDEX_VALKONT")
    public BigDecimal getG45IndexValkont() {
        return g45IndexValkont;
    }

    public void setG45IndexValkont(BigDecimal g45IndexValkont) {
        this.g45IndexValkont = g45IndexValkont;
    }

    @Basic
    @Column(name = "G42_USD")
    public BigDecimal getG42Usd() {
        return g42Usd;
    }

    public void setG42Usd(BigDecimal g42Usd) {
        this.g42Usd = g42Usd;
    }

    @Basic
    @Column(name = "G42USD_EDIZM")
    public BigDecimal getG42UsdEdizm() {
        return g42UsdEdizm;
    }

    public void setG42UsdEdizm(BigDecimal g42UsdEdizm) {
        this.g42UsdEdizm = g42UsdEdizm;
    }

    @Basic
    @Column(name = "G42SUM_EDIZM")
    public BigDecimal getG42SumEdizm() {
        return g42SumEdizm;
    }

    public void setG42SumEdizm(BigDecimal g42SumEdizm) {
        this.g42SumEdizm = g42SumEdizm;
    }

    @Basic
    @Column(name = "G42_INDEX")
    public BigDecimal getG42Index() {
        return g42Index;
    }

    public void setG42Index(BigDecimal g42Index) {
        this.g42Index = g42Index;
    }

    @Basic
    @Column(name = "G42_EDIZM_VALKONT")
    public BigDecimal getG42EdizmValkont() {
        return g42EdizmValkont;
    }

    public void setG42EdizmValkont(BigDecimal g42EdizmValkont) {
        this.g42EdizmValkont = g42EdizmValkont;
    }

    @Basic
    @Column(name = "G42_INDEX_VALKONT")
    public BigDecimal getG42IndexValkont() {
        return g42IndexValkont;
    }

    public void setG42IndexValkont(BigDecimal g42IndexValkont) {
        this.g42IndexValkont = g42IndexValkont;
    }

    @Basic
    @Column(name = "GC3DATE")
    public Date getGc3Date() {
        return gc3Date;
    }

    public void setGc3Date(Date gc3Date) {
        this.gc3Date = gc3Date;
    }

    @Basic
    @Column(name = "VID_TULOV")
    public Short getVidTulov() {
        return vidTulov;
    }

    public void setVidTulov(Short vidTulov) {
        this.vidTulov = vidTulov;
    }

    @Basic
    @Column(name = "DOC_TYPE")
    public Short getDocType() {
        return docType;
    }

    public void setDocType(Short docType) {
        this.docType = docType;
    }

    @Basic
    @Column(name = "GDVIPDATE")
    public Date getGdvipdate() {
        return gdvipdate;
    }

    public void setGdvipdate(Date gdvipdate) {
        this.gdvipdate = gdvipdate;
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
    @Column(name = "CURTIME")
    public Timestamp getCurtime() {
        return curtime;
    }

    public void setCurtime(Timestamp curtime) {
        this.curtime = curtime;
    }

    @Basic
    @Column(name = "MTCID")
    public Integer getMtcid() {
        return mtcid;
    }

    public void setMtcid(Integer mtcid) {
        this.mtcid = mtcid;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_MTC")
    public int getIdMtc() {
        return idMtc;
    }

    public void setIdMtc(int idMtc) {
        this.idMtc = idMtc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MtcRepl mtcRepl = (MtcRepl) o;
        return idMtc == mtcRepl.idMtc && Objects.equals(id, mtcRepl.id) && Objects.equals(declId, mtcRepl.declId) && Objects.equals(cmdtId, mtcRepl.cmdtId) && Objects.equals(g7A, mtcRepl.g7A) && Objects.equals(g7B, mtcRepl.g7B) && Objects.equals(g7C, mtcRepl.g7C) && Objects.equals(g1A, mtcRepl.g1A) && Objects.equals(g1B, mtcRepl.g1B) && Objects.equals(g2Name, mtcRepl.g2Name) && Objects.equals(g2Code2, mtcRepl.g2Code2) && Objects.equals(g8Name, mtcRepl.g8Name) && Objects.equals(g8Code2, mtcRepl.g8Code2) && Objects.equals(g9Name, mtcRepl.g9Name) && Objects.equals(g9Code2, mtcRepl.g9Code2) && Objects.equals(g11, mtcRepl.g11) && Objects.equals(g12, mtcRepl.g12) && Objects.equals(g13, mtcRepl.g13) && Objects.equals(g15, mtcRepl.g15) && Objects.equals(g17, mtcRepl.g17) && Objects.equals(g20B, mtcRepl.g20B) && Objects.equals(g20Name, mtcRepl.g20Name) && Objects.equals(g22A, mtcRepl.g22A) && Objects.equals(g22B, mtcRepl.g22B) && Objects.equals(g23, mtcRepl.g23) && Objects.equals(g23Scale, mtcRepl.g23Scale) && Objects.equals(g25, mtcRepl.g25) && Objects.equals(g26, mtcRepl.g26) && Objects.equals(g20Fr, mtcRepl.g20Fr) && Objects.equals(g24A, mtcRepl.g24A) && Objects.equals(g24B, mtcRepl.g24B) && Objects.equals(idn, mtcRepl.idn) && Objects.equals(g31Name, mtcRepl.g31Name) && Objects.equals(g31Marka, mtcRepl.g31Marka) && Objects.equals(g31Amount, mtcRepl.g31Amount) && Objects.equals(g32, mtcRepl.g32) && Objects.equals(g33, mtcRepl.g33) && Objects.equals(g34, mtcRepl.g34) && Objects.equals(g35, mtcRepl.g35) && Objects.equals(g37B, mtcRepl.g37B) && Objects.equals(g37C, mtcRepl.g37C) && Objects.equals(g38, mtcRepl.g38) && Objects.equals(g41, mtcRepl.g41) && Objects.equals(g42, mtcRepl.g42) && Objects.equals(g43, mtcRepl.g43) && Objects.equals(g45, mtcRepl.g45) && Objects.equals(g46, mtcRepl.g46) && Objects.equals(g31Edizm, mtcRepl.g31Edizm) && Objects.equals(g45Usd2, mtcRepl.g45Usd2) && Objects.equals(unitname, mtcRepl.unitname) && Objects.equals(vesEdizm, mtcRepl.vesEdizm) && Objects.equals(metodOtc, mtcRepl.metodOtc) && Objects.equals(g45Usd, mtcRepl.g45Usd) && Objects.equals(g45UsdEdizm, mtcRepl.g45UsdEdizm) && Objects.equals(g45SumEdizm, mtcRepl.g45SumEdizm) && Objects.equals(g45Index, mtcRepl.g45Index) && Objects.equals(g45EdizmValkont, mtcRepl.g45EdizmValkont) && Objects.equals(g45IndexValkont, mtcRepl.g45IndexValkont) && Objects.equals(g42Usd, mtcRepl.g42Usd) && Objects.equals(g42UsdEdizm, mtcRepl.g42UsdEdizm) && Objects.equals(g42SumEdizm, mtcRepl.g42SumEdizm) && Objects.equals(g42Index, mtcRepl.g42Index) && Objects.equals(g42EdizmValkont, mtcRepl.g42EdizmValkont) && Objects.equals(g42IndexValkont, mtcRepl.g42IndexValkont) && Objects.equals(gc3Date, mtcRepl.gc3Date) && Objects.equals(vidTulov, mtcRepl.vidTulov) && Objects.equals(docType, mtcRepl.docType) && Objects.equals(gdvipdate, mtcRepl.gdvipdate) && Objects.equals(status, mtcRepl.status) && Objects.equals(instime, mtcRepl.instime) && Objects.equals(updtime, mtcRepl.updtime) && Objects.equals(curtime, mtcRepl.curtime) && Objects.equals(mtcid, mtcRepl.mtcid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, declId, cmdtId, g7A, g7B, g7C, g1A, g1B, g2Name, g2Code2, g8Name, g8Code2, g9Name, g9Code2, g11, g12, g13, g15, g17, g20B, g20Name, g22A, g22B, g23, g23Scale, g25, g26, g20Fr, g24A, g24B, idn, g31Name, g31Marka, g31Amount, g32, g33, g34, g35, g37B, g37C, g38, g41, g42, g43, g45, g46, g31Edizm, g45Usd2, unitname, vesEdizm, metodOtc, g45Usd, g45UsdEdizm, g45SumEdizm, g45Index, g45EdizmValkont, g45IndexValkont, g42Usd, g42UsdEdizm, g42SumEdizm, g42Index, g42EdizmValkont, g42IndexValkont, gc3Date, vidTulov, docType, gdvipdate, status, instime, updtime, curtime, mtcid, idMtc);
    }
}
