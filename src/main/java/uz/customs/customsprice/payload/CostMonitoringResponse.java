package uz.customs.customsprice.payload;

import java.math.BigDecimal;
import java.util.Date;

public class CostMonitoringResponse {
    private String id;
    private String declId;
    private String cmdtId;
    private String g7a;
    private Date g7b;
    private String g7c;
    private String g1a;
    private String g1b;
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
    private String g20b;
    private String g20Name;
    private String g22a;
    private BigDecimal g22b;
    private BigDecimal g23;
    private BigDecimal g23Scale;
    private String g25;
    private String g26;
    private String g20fr;
    private String g24a;
    private String g24b;
    private String idn;
    private String g31Name;
    private String g31Marka;
    private BigDecimal g31Amount;
    private short g32;
    private String g33;
    private String g34;
    private BigDecimal g35;
    private String g37b;
    private String g37c;
    private BigDecimal g38;
    private String g41;
    private BigDecimal g42;
    private String g43;
    private BigDecimal g45;
    private BigDecimal g46;
    private String g31EdIzm;
    private BigDecimal g45Usd;
    private String unitName;
    private BigDecimal vesEdIzm;
    private BigDecimal metodOtc;
    private BigDecimal g45Usd2;
    private BigDecimal g45UsdEdIzm;
    private BigDecimal g45sumEdIzm;
    private BigDecimal g45Index;
    private BigDecimal g45EdIzmValkont;
    private BigDecimal g45IndexValkont;
    private BigDecimal g42Usd;
    private BigDecimal g42UsdEdIzm;
    private BigDecimal g42sumEdIzm;
    private BigDecimal g42Index;
    private BigDecimal g42EdIzmValkont;
    private BigDecimal g42IndexValkont;
    private Date gc3Date;
    private String vidTulov;
    private String docType;
    private String gdvipDate;
    private String status;
    private String instime;
    private String updtime;
    private String curtime;
    private String mtcId;
    private String idMtc;
    private String g11Name;
    private String g15Name;
    private String g17Name;
    private String g34Name;
    private String g41Name;

    public CostMonitoringResponse() {
    }

    public CostMonitoringResponse(String id, String declId, String cmdtId, String g7a, Date g7b, String g7c, String g1a, String g1b, String g2Name, String g2Code2, String g8Name, String g8Code2, String g9Name, String g9Code2, String g11, BigDecimal g12, BigDecimal g13, String g15, String g17, String g20b, String g20Name, String g22a, BigDecimal g22b, BigDecimal g23, BigDecimal g23Scale, String g25, String g26, String g20fr, String g24a, String g24b, String idn, String g31Name, String g31Marka, BigDecimal g31Amount, short g32, String g33, String g34, BigDecimal g35, String g37b, String g37c, BigDecimal g38, String g41, BigDecimal g42, String g43, BigDecimal g45, BigDecimal g46, String g31EdIzm, BigDecimal g45Usd, String unitName, BigDecimal vesEdIzm, BigDecimal metodOtc, BigDecimal g45Usd2, BigDecimal g45UsdEdIzm, BigDecimal g45sumEdIzm, BigDecimal g45Index, BigDecimal g45EdIzmValkont, BigDecimal g45IndexValkont, BigDecimal g42Usd, BigDecimal g42UsdEdIzm, BigDecimal g42sumEdIzm, BigDecimal g42Index, BigDecimal g42EdIzmValkont, BigDecimal g42IndexValkont, Date gc3Date, String vidTulov, String docType, String gdvipDate, String status, String instime, String updtime, String curtime, String mtcId, String idMtc, String g11Name, String g15Name, String g17Name, String g34Name, String g41Name) {
        this.id = id;
        this.declId = declId;
        this.cmdtId = cmdtId;
        this.g7a = g7a;
        this.g7b = g7b;
        this.g7c = g7c;
        this.g1a = g1a;
        this.g1b = g1b;
        this.g2Name = g2Name;
        this.g2Code2 = g2Code2;
        this.g8Name = g8Name;
        this.g8Code2 = g8Code2;
        this.g9Name = g9Name;
        this.g9Code2 = g9Code2;
        this.g11 = g11;
        this.g12 = g12;
        this.g13 = g13;
        this.g15 = g15;
        this.g17 = g17;
        this.g20b = g20b;
        this.g20Name = g20Name;
        this.g22a = g22a;
        this.g22b = g22b;
        this.g23 = g23;
        this.g23Scale = g23Scale;
        this.g25 = g25;
        this.g26 = g26;
        this.g20fr = g20fr;
        this.g24a = g24a;
        this.g24b = g24b;
        this.idn = idn;
        this.g31Name = g31Name;
        this.g31Marka = g31Marka;
        this.g31Amount = g31Amount;
        this.g32 = g32;
        this.g33 = g33;
        this.g34 = g34;
        this.g35 = g35;
        this.g37b = g37b;
        this.g37c = g37c;
        this.g38 = g38;
        this.g41 = g41;
        this.g42 = g42;
        this.g43 = g43;
        this.g45 = g45;
        this.g46 = g46;
        this.g31EdIzm = g31EdIzm;
        this.g45Usd = g45Usd;
        this.unitName = unitName;
        this.vesEdIzm = vesEdIzm;
        this.metodOtc = metodOtc;
        this.g45Usd2 = g45Usd2;
        this.g45UsdEdIzm = g45UsdEdIzm;
        this.g45sumEdIzm = g45sumEdIzm;
        this.g45Index = g45Index;
        this.g45EdIzmValkont = g45EdIzmValkont;
        this.g45IndexValkont = g45IndexValkont;
        this.g42Usd = g42Usd;
        this.g42UsdEdIzm = g42UsdEdIzm;
        this.g42sumEdIzm = g42sumEdIzm;
        this.g42Index = g42Index;
        this.g42EdIzmValkont = g42EdIzmValkont;
        this.g42IndexValkont = g42IndexValkont;
        this.gc3Date = gc3Date;
        this.vidTulov = vidTulov;
        this.docType = docType;
        this.gdvipDate = gdvipDate;
        this.status = status;
        this.instime = instime;
        this.updtime = updtime;
        this.curtime = curtime;
        this.mtcId = mtcId;
        this.idMtc = idMtc;
        this.g11Name = g11Name;
        this.g15Name = g15Name;
        this.g17Name = g17Name;
        this.g34Name = g34Name;
        this.g41Name = g41Name;
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

    public String getG7a() {
        return g7a;
    }

    public void setG7a(String g7a) {
        this.g7a = g7a;
    }

    public Date getG7b() {
        return g7b;
    }

    public void setG7b(Date g7b) {
        this.g7b = g7b;
    }

    public String getG7c() {
        return g7c;
    }

    public void setG7c(String g7c) {
        this.g7c = g7c;
    }

    public String getG1a() {
        return g1a;
    }

    public void setG1a(String g1a) {
        this.g1a = g1a;
    }

    public String getG1b() {
        return g1b;
    }

    public void setG1b(String g1b) {
        this.g1b = g1b;
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

    public String getG17() {
        return g17;
    }

    public void setG17(String g17) {
        this.g17 = g17;
    }

    public String getG20b() {
        return g20b;
    }

    public void setG20b(String g20b) {
        this.g20b = g20b;
    }

    public String getG20Name() {
        return g20Name;
    }

    public void setG20Name(String g20Name) {
        this.g20Name = g20Name;
    }

    public String getG22a() {
        return g22a;
    }

    public void setG22a(String g22a) {
        this.g22a = g22a;
    }

    public BigDecimal getG22b() {
        return g22b;
    }

    public void setG22b(BigDecimal g22b) {
        this.g22b = g22b;
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

    public String getG20fr() {
        return g20fr;
    }

    public void setG20fr(String g20fr) {
        this.g20fr = g20fr;
    }

    public String getG24a() {
        return g24a;
    }

    public void setG24a(String g24a) {
        this.g24a = g24a;
    }

    public String getG24b() {
        return g24b;
    }

    public void setG24b(String g24b) {
        this.g24b = g24b;
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

    public short getG32() {
        return g32;
    }

    public void setG32(short g32) {
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

    public BigDecimal getG35() {
        return g35;
    }

    public void setG35(BigDecimal g35) {
        this.g35 = g35;
    }

    public String getG37b() {
        return g37b;
    }

    public void setG37b(String g37b) {
        this.g37b = g37b;
    }

    public String getG37c() {
        return g37c;
    }

    public void setG37c(String g37c) {
        this.g37c = g37c;
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

    public String getG31EdIzm() {
        return g31EdIzm;
    }

    public void setG31EdIzm(String g31EdIzm) {
        this.g31EdIzm = g31EdIzm;
    }

    public BigDecimal getG45Usd() {
        return g45Usd;
    }

    public void setG45Usd(BigDecimal g45Usd) {
        this.g45Usd = g45Usd;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public BigDecimal getVesEdIzm() {
        return vesEdIzm;
    }

    public void setVesEdIzm(BigDecimal vesEdIzm) {
        this.vesEdIzm = vesEdIzm;
    }

    public BigDecimal getMetodOtc() {
        return metodOtc;
    }

    public void setMetodOtc(BigDecimal metodOtc) {
        this.metodOtc = metodOtc;
    }

    public BigDecimal getG45Usd2() {
        return g45Usd2;
    }

    public void setG45Usd2(BigDecimal g45Usd2) {
        this.g45Usd2 = g45Usd2;
    }

    public BigDecimal getG45UsdEdIzm() {
        return g45UsdEdIzm;
    }

    public void setG45UsdEdIzm(BigDecimal g45UsdEdIzm) {
        this.g45UsdEdIzm = g45UsdEdIzm;
    }

    public BigDecimal getG45sumEdIzm() {
        return g45sumEdIzm;
    }

    public void setG45sumEdIzm(BigDecimal g45sumEdIzm) {
        this.g45sumEdIzm = g45sumEdIzm;
    }

    public BigDecimal getG45Index() {
        return g45Index;
    }

    public void setG45Index(BigDecimal g45Index) {
        this.g45Index = g45Index;
    }

    public BigDecimal getG45EdIzmValkont() {
        return g45EdIzmValkont;
    }

    public void setG45EdIzmValkont(BigDecimal g45EdIzmValkont) {
        this.g45EdIzmValkont = g45EdIzmValkont;
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

    public BigDecimal getG42UsdEdIzm() {
        return g42UsdEdIzm;
    }

    public void setG42UsdEdIzm(BigDecimal g42UsdEdIzm) {
        this.g42UsdEdIzm = g42UsdEdIzm;
    }

    public BigDecimal getG42sumEdIzm() {
        return g42sumEdIzm;
    }

    public void setG42sumEdIzm(BigDecimal g42sumEdIzm) {
        this.g42sumEdIzm = g42sumEdIzm;
    }

    public BigDecimal getG42Index() {
        return g42Index;
    }

    public void setG42Index(BigDecimal g42Index) {
        this.g42Index = g42Index;
    }

    public BigDecimal getG42EdIzmValkont() {
        return g42EdIzmValkont;
    }

    public void setG42EdIzmValkont(BigDecimal g42EdIzmValkont) {
        this.g42EdIzmValkont = g42EdIzmValkont;
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

    public String getVidTulov() {
        return vidTulov;
    }

    public void setVidTulov(String vidTulov) {
        this.vidTulov = vidTulov;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getGdvipDate() {
        return gdvipDate;
    }

    public void setGdvipDate(String gdvipDate) {
        this.gdvipDate = gdvipDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInstime() {
        return instime;
    }

    public void setInstime(String instime) {
        this.instime = instime;
    }

    public String getUpdtime() {
        return updtime;
    }

    public void setUpdtime(String updtime) {
        this.updtime = updtime;
    }

    public String getCurtime() {
        return curtime;
    }

    public void setCurtime(String curtime) {
        this.curtime = curtime;
    }

    public String getMtcId() {
        return mtcId;
    }

    public void setMtcId(String mtcId) {
        this.mtcId = mtcId;
    }

    public String getIdMtc() {
        return idMtc;
    }

    public void setIdMtc(String idMtc) {
        this.idMtc = idMtc;
    }

    public String getG11Name() {
        return g11Name;
    }

    public void setG11Name(String g11Name) {
        this.g11Name = g11Name;
    }

    public String getG15Name() {
        return g15Name;
    }

    public void setG15Name(String g15Name) {
        this.g15Name = g15Name;
    }

    public String getG17Name() {
        return g17Name;
    }

    public void setG17Name(String g17Name) {
        this.g17Name = g17Name;
    }

    public String getG34Name() {
        return g34Name;
    }

    public void setG34Name(String g34Name) {
        this.g34Name = g34Name;
    }

    public String getG41Name() {
        return g41Name;
    }

    public void setG41Name(String g41Name) {
        this.g41Name = g41Name;
    }

    @Override
    public String toString() {
        return "CostMonitoringResponse{" +
                "id='" + id + '\'' +
                ", declId='" + declId + '\'' +
                ", cmdtId='" + cmdtId + '\'' +
                ", g7a='" + g7a + '\'' +
                ", g7b=" + g7b +
                ", g7c='" + g7c + '\'' +
                ", g1a='" + g1a + '\'' +
                ", g1b='" + g1b + '\'' +
                ", g2Name='" + g2Name + '\'' +
                ", g2Code2='" + g2Code2 + '\'' +
                ", g8Name='" + g8Name + '\'' +
                ", g8Code2='" + g8Code2 + '\'' +
                ", g9Name='" + g9Name + '\'' +
                ", g9Code2='" + g9Code2 + '\'' +
                ", g11='" + g11 + '\'' +
                ", g12=" + g12 +
                ", g13=" + g13 +
                ", g15='" + g15 + '\'' +
                ", g17='" + g17 + '\'' +
                ", g20b='" + g20b + '\'' +
                ", g20Name='" + g20Name + '\'' +
                ", g22a='" + g22a + '\'' +
                ", g22b=" + g22b +
                ", g23=" + g23 +
                ", g23Scale=" + g23Scale +
                ", g25='" + g25 + '\'' +
                ", g26='" + g26 + '\'' +
                ", g20fr='" + g20fr + '\'' +
                ", g24a='" + g24a + '\'' +
                ", g24b='" + g24b + '\'' +
                ", idn='" + idn + '\'' +
                ", g31Name='" + g31Name + '\'' +
                ", g31Marka='" + g31Marka + '\'' +
                ", g31Amount=" + g31Amount +
                ", g32=" + g32 +
                ", g33='" + g33 + '\'' +
                ", g34='" + g34 + '\'' +
                ", g35=" + g35 +
                ", g37b='" + g37b + '\'' +
                ", g37c='" + g37c + '\'' +
                ", g38=" + g38 +
                ", g41='" + g41 + '\'' +
                ", g42=" + g42 +
                ", g43='" + g43 + '\'' +
                ", g45=" + g45 +
                ", g46=" + g46 +
                ", g31EdIzm='" + g31EdIzm + '\'' +
                ", g45Usd=" + g45Usd +
                ", unitName='" + unitName + '\'' +
                ", vesEdIzm=" + vesEdIzm +
                ", metodOtc=" + metodOtc +
                ", g45Usd2=" + g45Usd2 +
                ", g45UsdEdIzm=" + g45UsdEdIzm +
                ", g45sumEdIzm=" + g45sumEdIzm +
                ", g45Index=" + g45Index +
                ", g45EdIzmValkont=" + g45EdIzmValkont +
                ", g45IndexValkont=" + g45IndexValkont +
                ", g42Usd=" + g42Usd +
                ", g42UsdEdIzm=" + g42UsdEdIzm +
                ", g42sumEdIzm=" + g42sumEdIzm +
                ", g42Index=" + g42Index +
                ", g42EdIzmValkont=" + g42EdIzmValkont +
                ", g42IndexValkont=" + g42IndexValkont +
                ", gc3Date=" + gc3Date +
                ", vidTulov='" + vidTulov + '\'' +
                ", docType='" + docType + '\'' +
                ", gdvipDate='" + gdvipDate + '\'' +
                ", status='" + status + '\'' +
                ", instime='" + instime + '\'' +
                ", updtime='" + updtime + '\'' +
                ", curtime='" + curtime + '\'' +
                ", mtcId='" + mtcId + '\'' +
                ", idMtc='" + idMtc + '\'' +
                ", g11Name='" + g11Name + '\'' +
                ", g15Name='" + g15Name + '\'' +
                ", g17Name='" + g17Name + '\'' +
                ", g34Name='" + g34Name + '\'' +
                ", g41Name='" + g41Name + '\'' +
                '}';
    }
}
