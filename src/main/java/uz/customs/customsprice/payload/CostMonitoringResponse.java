package uz.customs.customsprice.payload;

import java.math.BigDecimal;
import java.util.Date;

public class CostMonitoringResponse {
    private String id;
    private String decl_id;
    private String cmdt_id;
    private String g7a;
    private Date g7b;
    private String g7c;
    private String g1a;
    private String g1b;
    private String g2name;
    private String g2code2;
    private String g8name;
    private String g8code2;
    private String g9name;
    private String g9code2;
    private String g11;
    private BigDecimal g12;
    private BigDecimal g13;
    private String g15;
    private String g17;
    private String g20b;
    private String g20name;
    private String g22a;
    private BigDecimal g22b;
    private BigDecimal g23;
    private BigDecimal g23scale;
    private String g25;
    private String g26;
    private String g20fr;
    private String g24a;
    private String g24b;
    private String idn;
    private String g31name;
    private String g31marka;
    private BigDecimal g31amount;
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
    private String g31edizm;
    private BigDecimal g45usd;
    private String unitname;
    private BigDecimal ves_edizm;
    private BigDecimal metod_otc;
    private BigDecimal g45_usd;
    private BigDecimal g45usd_edizm;
    private BigDecimal g45sum_edizm;
    private BigDecimal g45_index;
    private BigDecimal g45_edizm_valkont;
    private BigDecimal g45_index_valkont;
    private BigDecimal g42_usd;
    private BigDecimal g42usd_edizm;
    private BigDecimal g42sum_edizm;
    private BigDecimal g42_index;
    private BigDecimal g42_edizm_valkont;
    private BigDecimal g42_index_valkont;
    private Date gc3date;
    private String vid_tulov;
    private String doc_type;
    private String gdvipdate;
    private String status;
    private String instime;
    private String updtime;
    private String curtime;
    private String mtcid;
    private String id_mtc;
    private String g11name;
    private String g15name;
    private String g17name;
    private String g34name;
    private String g41name;

    public CostMonitoringResponse() {
    }

    public CostMonitoringResponse(String id, String decl_id, String cmdt_id, String g7a, Date g7b, String g7c, String g1a, String g1b, String g2name, String g2code2, String g8name, String g8code2, String g9name, String g9code2, String g11, BigDecimal g12, BigDecimal g13, String g15, String g17, String g20b, String g20name, String g22a, BigDecimal g22b, BigDecimal g23, BigDecimal g23scale, String g25, String g26, String g20fr, String g24a, String g24b, String idn, String g31name, String g31marka, BigDecimal g31amount, short g32, String g33, String g34, BigDecimal g35, String g37b, String g37c, BigDecimal g38, String g41, BigDecimal g42, String g43, BigDecimal g45, BigDecimal g46, String g31edizm, BigDecimal g45usd, String unitname, BigDecimal ves_edizm, BigDecimal metod_otc, BigDecimal g45_usd, BigDecimal g45usd_edizm, BigDecimal g45sum_edizm, BigDecimal g45_index, BigDecimal g45_edizm_valkont, BigDecimal g45_index_valkont, BigDecimal g42_usd, BigDecimal g42usd_edizm, BigDecimal g42sum_edizm, BigDecimal g42_index, BigDecimal g42_edizm_valkont, BigDecimal g42_index_valkont, Date gc3date, String vid_tulov, String doc_type, String gdvipdate, String status, String instime, String updtime, String curtime, String mtcid, String id_mtc, String g11name, String g15name, String g17name, String g34name, String g41name) {
        this.id = id;
        this.decl_id = decl_id;
        this.cmdt_id = cmdt_id;
        this.g7a = g7a;
        this.g7b = g7b;
        this.g7c = g7c;
        this.g1a = g1a;
        this.g1b = g1b;
        this.g2name = g2name;
        this.g2code2 = g2code2;
        this.g8name = g8name;
        this.g8code2 = g8code2;
        this.g9name = g9name;
        this.g9code2 = g9code2;
        this.g11 = g11;
        this.g12 = g12;
        this.g13 = g13;
        this.g15 = g15;
        this.g17 = g17;
        this.g20b = g20b;
        this.g20name = g20name;
        this.g22a = g22a;
        this.g22b = g22b;
        this.g23 = g23;
        this.g23scale = g23scale;
        this.g25 = g25;
        this.g26 = g26;
        this.g20fr = g20fr;
        this.g24a = g24a;
        this.g24b = g24b;
        this.idn = idn;
        this.g31name = g31name;
        this.g31marka = g31marka;
        this.g31amount = g31amount;
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
        this.g31edizm = g31edizm;
        this.g45usd = g45usd;
        this.unitname = unitname;
        this.ves_edizm = ves_edizm;
        this.metod_otc = metod_otc;
        this.g45_usd = g45_usd;
        this.g45usd_edizm = g45usd_edizm;
        this.g45sum_edizm = g45sum_edizm;
        this.g45_index = g45_index;
        this.g45_edizm_valkont = g45_edizm_valkont;
        this.g45_index_valkont = g45_index_valkont;
        this.g42_usd = g42_usd;
        this.g42usd_edizm = g42usd_edizm;
        this.g42sum_edizm = g42sum_edizm;
        this.g42_index = g42_index;
        this.g42_edizm_valkont = g42_edizm_valkont;
        this.g42_index_valkont = g42_index_valkont;
        this.gc3date = gc3date;
        this.vid_tulov = vid_tulov;
        this.doc_type = doc_type;
        this.gdvipdate = gdvipdate;
        this.status = status;
        this.instime = instime;
        this.updtime = updtime;
        this.curtime = curtime;
        this.mtcid = mtcid;
        this.id_mtc = id_mtc;
        this.g11name = g11name;
        this.g15name = g15name;
        this.g17name = g17name;
        this.g34name = g34name;
        this.g41name = g41name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDecl_id() {
        return decl_id;
    }

    public void setDecl_id(String decl_id) {
        this.decl_id = decl_id;
    }

    public String getCmdt_id() {
        return cmdt_id;
    }

    public void setCmdt_id(String cmdt_id) {
        this.cmdt_id = cmdt_id;
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

    public String getG2name() {
        return g2name;
    }

    public void setG2name(String g2name) {
        this.g2name = g2name;
    }

    public String getG2code2() {
        return g2code2;
    }

    public void setG2code2(String g2code2) {
        this.g2code2 = g2code2;
    }

    public String getG8name() {
        return g8name;
    }

    public void setG8name(String g8name) {
        this.g8name = g8name;
    }

    public String getG8code2() {
        return g8code2;
    }

    public void setG8code2(String g8code2) {
        this.g8code2 = g8code2;
    }

    public String getG9name() {
        return g9name;
    }

    public void setG9name(String g9name) {
        this.g9name = g9name;
    }

    public String getG9code2() {
        return g9code2;
    }

    public void setG9code2(String g9code2) {
        this.g9code2 = g9code2;
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

    public String getG20name() {
        return g20name;
    }

    public void setG20name(String g20name) {
        this.g20name = g20name;
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

    public BigDecimal getG23scale() {
        return g23scale;
    }

    public void setG23scale(BigDecimal g23scale) {
        this.g23scale = g23scale;
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

    public String getG31name() {
        return g31name;
    }

    public void setG31name(String g31name) {
        this.g31name = g31name;
    }

    public String getG31marka() {
        return g31marka;
    }

    public void setG31marka(String g31marka) {
        this.g31marka = g31marka;
    }

    public BigDecimal getG31amount() {
        return g31amount;
    }

    public void setG31amount(BigDecimal g31amount) {
        this.g31amount = g31amount;
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

    public String getG31edizm() {
        return g31edizm;
    }

    public void setG31edizm(String g31edizm) {
        this.g31edizm = g31edizm;
    }

    public BigDecimal getG45usd() {
        return g45usd;
    }

    public void setG45usd(BigDecimal g45usd) {
        this.g45usd = g45usd;
    }

    public String getUnitname() {
        return unitname;
    }

    public void setUnitname(String unitname) {
        this.unitname = unitname;
    }

    public BigDecimal getVes_edizm() {
        return ves_edizm;
    }

    public void setVes_edizm(BigDecimal ves_edizm) {
        this.ves_edizm = ves_edizm;
    }

    public BigDecimal getMetod_otc() {
        return metod_otc;
    }

    public void setMetod_otc(BigDecimal metod_otc) {
        this.metod_otc = metod_otc;
    }

    public BigDecimal getG45_usd() {
        return g45_usd;
    }

    public void setG45_usd(BigDecimal g45_usd) {
        this.g45_usd = g45_usd;
    }

    public BigDecimal getG45usd_edizm() {
        return g45usd_edizm;
    }

    public void setG45usd_edizm(BigDecimal g45usd_edizm) {
        this.g45usd_edizm = g45usd_edizm;
    }

    public BigDecimal getG45sum_edizm() {
        return g45sum_edizm;
    }

    public void setG45sum_edizm(BigDecimal g45sum_edizm) {
        this.g45sum_edizm = g45sum_edizm;
    }

    public BigDecimal getG45_index() {
        return g45_index;
    }

    public void setG45_index(BigDecimal g45_index) {
        this.g45_index = g45_index;
    }

    public BigDecimal getG45_edizm_valkont() {
        return g45_edizm_valkont;
    }

    public void setG45_edizm_valkont(BigDecimal g45_edizm_valkont) {
        this.g45_edizm_valkont = g45_edizm_valkont;
    }

    public BigDecimal getG45_index_valkont() {
        return g45_index_valkont;
    }

    public void setG45_index_valkont(BigDecimal g45_index_valkont) {
        this.g45_index_valkont = g45_index_valkont;
    }

    public BigDecimal getG42_usd() {
        return g42_usd;
    }

    public void setG42_usd(BigDecimal g42_usd) {
        this.g42_usd = g42_usd;
    }

    public BigDecimal getG42usd_edizm() {
        return g42usd_edizm;
    }

    public void setG42usd_edizm(BigDecimal g42usd_edizm) {
        this.g42usd_edizm = g42usd_edizm;
    }

    public BigDecimal getG42sum_edizm() {
        return g42sum_edizm;
    }

    public void setG42sum_edizm(BigDecimal g42sum_edizm) {
        this.g42sum_edizm = g42sum_edizm;
    }

    public BigDecimal getG42_index() {
        return g42_index;
    }

    public void setG42_index(BigDecimal g42_index) {
        this.g42_index = g42_index;
    }

    public BigDecimal getG42_edizm_valkont() {
        return g42_edizm_valkont;
    }

    public void setG42_edizm_valkont(BigDecimal g42_edizm_valkont) {
        this.g42_edizm_valkont = g42_edizm_valkont;
    }

    public BigDecimal getG42_index_valkont() {
        return g42_index_valkont;
    }

    public void setG42_index_valkont(BigDecimal g42_index_valkont) {
        this.g42_index_valkont = g42_index_valkont;
    }

    public Date getGc3date() {
        return gc3date;
    }

    public void setGc3date(Date gc3date) {
        this.gc3date = gc3date;
    }

    public String getVid_tulov() {
        return vid_tulov;
    }

    public void setVid_tulov(String vid_tulov) {
        this.vid_tulov = vid_tulov;
    }

    public String getDoc_type() {
        return doc_type;
    }

    public void setDoc_type(String doc_type) {
        this.doc_type = doc_type;
    }

    public String getGdvipdate() {
        return gdvipdate;
    }

    public void setGdvipdate(String gdvipdate) {
        this.gdvipdate = gdvipdate;
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

    public String getMtcid() {
        return mtcid;
    }

    public void setMtcid(String mtcid) {
        this.mtcid = mtcid;
    }

    public String getId_mtc() {
        return id_mtc;
    }

    public void setId_mtc(String id_mtc) {
        this.id_mtc = id_mtc;
    }

    public String getG11name() {
        return g11name;
    }

    public void setG11name(String g11name) {
        this.g11name = g11name;
    }

    public String getG15name() {
        return g15name;
    }

    public void setG15name(String g15name) {
        this.g15name = g15name;
    }

    public String getG17name() {
        return g17name;
    }

    public void setG17name(String g17name) {
        this.g17name = g17name;
    }

    public String getG34name() {
        return g34name;
    }

    public void setG34name(String g34name) {
        this.g34name = g34name;
    }

    public String getG41name() {
        return g41name;
    }

    public void setG41name(String g41name) {
        this.g41name = g41name;
    }

}
