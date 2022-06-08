package uz.customs.customsprice.controllers.CostMonitoring;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class CostMonitoringData {
    /* 0 */ private String id;  /* 0 */
    /* 1 */ private String decl_id;  /* 1 */
    /* 2 */ private String cmdt_id;  /* 2 */
    /* 3 */ private String g7a;  /* 3 */
    /* 4 */ private String g7b;  /* 4 */
    /* 5 */ private String g7c;  /* 5 */
    /* 5 */ private String g7abc;  /* 5 */
    /* 6 */ private String g1a;  /* 6 */
    /* 7 */ private String g1b;  /* 7 */
    /* 8 */ private String g2name;  /* 8 */
    /* 9 */ private String g2code2;  /* 9 */
    /* 10 */ private String g8name;  /* 10 */
    /* 11 */ private String g8code2;  /* 11 */
    /* 12 */ private String g9name;  /* 12 */
    /* 13 */ private String g9code2;  /* 13 */
    /* 14 */ private String g11;  /* 14 */
    /* 15 */ private String g12;  /* 15 */
    /* 16 */ private String g13;  /* 16 */
    /* 17 */ private String g15;  /* 17 */
    /* 18 */ private String g17;  /* 18 */
    /* 19 */ private String g20b;  /* 19 */
    /* 20 */ private String g20name;  /* 20 */
    /* 21 */ private String g22a;  /* 21 */
    /* 22 */ private String g22b;  /* 22 */
    /* 23 */ private String g23;  /* 23 */
    /* 24 */ private String g23scale;  /* 24 */
    /* 25 */ private String g25;  /* 25 */
    /* 26 */ private String g26;  /* 26 */
    /* 27 */ private String g20fr;  /* 27 */
    /* 28 */ private String g24a;  /* 28 */
    /* 29 */ private String g24b;  /* 29 */
    /* 30 */ private String idn;  /* 30 */
    /* 31 */ private String g31name;  /* 31 */
    /* 32 */ private String g31marka;  /* 32 */
    /* 33 */ private String g31amount;  /* 33 */
    /* 34 */ private String g32;  /* 34 */
    /* 35 */ private String g33;  /* 35 */
    /* 36 */ private String g34;  /* 36 */
    /* 37 */ private String g35;  /* 37 */
    /* 38 */ private String g37b;  /* 38 */
    /* 39 */ private String g37c;  /* 39 */
    /* 40 */ private String g38;  /* 40 */
    /* 41 */ private String g41;  /* 41 */
    /* 42 */ private String g42;  /* 42 */
    /* 43 */ private String g43;  /* 43 */
    /* 44 */ private String g45;  /* 44 */
    /* 45 */ private String g46;  /* 45 */
    /* 46 */ private String g31edizm;  /* 46 */
    /* 47 */ private String g45usd;  /* 47 */
    /* 48 */ private String unitname;  /* 48 */
    /* 49 */ private String ves_edizm;  /* 49 */
    /* 50 */ private String metod_otc;  /* 50 */
    /* 51 */ private String g45_usd;  /* 51 */
    /* 52 */ private String g45usd_edizm;  /* 52 */
    /* 53 */ private String g45sum_edizm;  /* 53 */
    /* 54 */ private String g45_index;  /* 54 */
    /* 55 */ private String g45_edizm_valkont;  /* 55 */
    /* 56 */ private String g45_index_valkont;  /* 56 */
    /* 57 */ private String g42_usd;  /* 57 */
    /* 58 */ private String g42usd_edizm;  /* 58 */
    /* 59 */ private String g42sum_edizm;  /* 59 */
    /* 60 */ private String g42_index;  /* 60 */
    /* 61 */ private String g42_edizm_valkont;  /* 61 */
    /* 62 */ private String g42_index_valkont;  /* 62 */
    /* 63 */ private String gc3date;  /* 63 */
    /* 64 */ private String vid_tulov;  /* 64 */
    /* 65 */ private String doc_type;  /* 65 */
    /* 66 */ private String gdvipdate;  /* 66 */
    /* 67 */ private String status;  /* 67 */
    /* 68 */ private String instime;  /* 68 */
    /* 69 */ private String updtime;  /* 69 */
    /* 70 */ private String curtime;  /* 70 */
    /* 71 */ private String mtcid;  /* 71 */
    /* 72 */ private String id_mtc;  /* 72 */
    /* 73 */ private String g11name;  /* 73 */
    /* 74 */ private String g15name;  /* 74 */
    /* 75 */ private String g17name;  /* 75 */
    /* 76 */ private String g34name;  /* 76 */
    /* 77 */ private String g41name;  /* 77 */

    public CostMonitoringData() {
    }

    public CostMonitoringData(String id, String decl_id, String cmdt_id, String g7a, String g7b, String g7c, String g7abc, String g1a, String g1b, String g2name, String g2code2, String g8name, String g8code2, String g9name, String g9code2, String g11, String g12, String g13, String g15, String g17, String g20b, String g20name, String g22a, String g22b, String g23, String g23scale, String g25, String g26, String g20fr, String g24a, String g24b, String idn, String g31name, String g31marka, String g31amount, String g32, String g33, String g34, String g35, String g37b, String g37c, String g38, String g41, String g42, String g43, String g45, String g46, String g31edizm, String g45usd, String unitname, String ves_edizm, String metod_otc, String g45_usd, String g45usd_edizm, String g45sum_edizm, String g45_index, String g45_edizm_valkont, String g45_index_valkont, String g42_usd, String g42usd_edizm, String g42sum_edizm, String g42_index, String g42_edizm_valkont, String g42_index_valkont, String gc3date, String vid_tulov, String doc_type, String gdvipdate, String status, String instime, String updtime, String curtime, String mtcid, String id_mtc, String g11name, String g15name, String g17name, String g34name, String g41name) {
        this.id = id;
        this.decl_id = decl_id;
        this.cmdt_id = cmdt_id;
        this.g7a = g7a;
        this.g7b = g7b;
        this.g7c = g7c;
        this.g7abc = g7abc;
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

    public String getG7b() {
        return g7b;
    }

    public void setG7b(String g7b) {
        this.g7b = g7b;
    }

    public String getG7c() {
        return g7c;
    }

    public void setG7c(String g7c) {
        this.g7c = g7c;
    }

    public String getG7abc() {
        return g7abc;
    }

    public void setG7abc(String g7abc) {
        this.g7abc = g7abc;
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

    public String getG12() {
        return g12;
    }

    public void setG12(String g12) {
        this.g12 = g12;
    }

    public String getG13() {
        return g13;
    }

    public void setG13(String g13) {
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

    public String getG22b() {
        return g22b;
    }

    public void setG22b(String g22b) {
        this.g22b = g22b;
    }

    public String getG23() {
        return g23;
    }

    public void setG23(String g23) {
        this.g23 = g23;
    }

    public String getG23scale() {
        return g23scale;
    }

    public void setG23scale(String g23scale) {
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

    public String getG31amount() {
        return g31amount;
    }

    public void setG31amount(String g31amount) {
        this.g31amount = g31amount;
    }

    public String getG32() {
        return g32;
    }

    public void setG32(String g32) {
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

    public String getG35() {
        return g35;
    }

    public void setG35(String g35) {
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

    public String getG38() {
        return g38;
    }

    public void setG38(String g38) {
        this.g38 = g38;
    }

    public String getG41() {
        return g41;
    }

    public void setG41(String g41) {
        this.g41 = g41;
    }

    public String getG42() {
        return g42;
    }

    public void setG42(String g42) {
        this.g42 = g42;
    }

    public String getG43() {
        return g43;
    }

    public void setG43(String g43) {
        this.g43 = g43;
    }

    public String getG45() {
        return g45;
    }

    public void setG45(String g45) {
        this.g45 = g45;
    }

    public String getG46() {
        return g46;
    }

    public void setG46(String g46) {
        this.g46 = g46;
    }

    public String getG31edizm() {
        return g31edizm;
    }

    public void setG31edizm(String g31edizm) {
        this.g31edizm = g31edizm;
    }

    public String getG45usd() {
        return g45usd;
    }

    public void setG45usd(String g45usd) {
        this.g45usd = g45usd;
    }

    public String getUnitname() {
        return unitname;
    }

    public void setUnitname(String unitname) {
        this.unitname = unitname;
    }

    public String getVes_edizm() {
        return ves_edizm;
    }

    public void setVes_edizm(String ves_edizm) {
        this.ves_edizm = ves_edizm;
    }

    public String getMetod_otc() {
        return metod_otc;
    }

    public void setMetod_otc(String metod_otc) {
        this.metod_otc = metod_otc;
    }

    public String getG45_usd() {
        return g45_usd;
    }

    public void setG45_usd(String g45_usd) {
        this.g45_usd = g45_usd;
    }

    public String getG45usd_edizm() {
        return g45usd_edizm;
    }

    public void setG45usd_edizm(String g45usd_edizm) {
        this.g45usd_edizm = g45usd_edizm;
    }

    public String getG45sum_edizm() {
        return g45sum_edizm;
    }

    public void setG45sum_edizm(String g45sum_edizm) {
        this.g45sum_edizm = g45sum_edizm;
    }

    public String getG45_index() {
        return g45_index;
    }

    public void setG45_index(String g45_index) {
        this.g45_index = g45_index;
    }

    public String getG45_edizm_valkont() {
        return g45_edizm_valkont;
    }

    public void setG45_edizm_valkont(String g45_edizm_valkont) {
        this.g45_edizm_valkont = g45_edizm_valkont;
    }

    public String getG45_index_valkont() {
        return g45_index_valkont;
    }

    public void setG45_index_valkont(String g45_index_valkont) {
        this.g45_index_valkont = g45_index_valkont;
    }

    public String getG42_usd() {
        return g42_usd;
    }

    public void setG42_usd(String g42_usd) {
        this.g42_usd = g42_usd;
    }

    public String getG42usd_edizm() {
        return g42usd_edizm;
    }

    public void setG42usd_edizm(String g42usd_edizm) {
        this.g42usd_edizm = g42usd_edizm;
    }

    public String getG42sum_edizm() {
        return g42sum_edizm;
    }

    public void setG42sum_edizm(String g42sum_edizm) {
        this.g42sum_edizm = g42sum_edizm;
    }

    public String getG42_index() {
        return g42_index;
    }

    public void setG42_index(String g42_index) {
        this.g42_index = g42_index;
    }

    public String getG42_edizm_valkont() {
        return g42_edizm_valkont;
    }

    public void setG42_edizm_valkont(String g42_edizm_valkont) {
        this.g42_edizm_valkont = g42_edizm_valkont;
    }

    public String getG42_index_valkont() {
        return g42_index_valkont;
    }

    public void setG42_index_valkont(String g42_index_valkont) {
        this.g42_index_valkont = g42_index_valkont;
    }

    public String getGc3date() {
        return gc3date;
    }

    public void setGc3date(String gc3date) {
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

    @Override
    public String toString() {
        return "CostMonitoringData{" +
                "id='" + id + '\'' +
                ", decl_id='" + decl_id + '\'' +
                ", cmdt_id='" + cmdt_id + '\'' +
                ", g7a='" + g7a + '\'' +
                ", g7b='" + g7b + '\'' +
                ", g7c='" + g7c + '\'' +
                ", g7abc='" + g7abc + '\'' +
                ", g1a='" + g1a + '\'' +
                ", g1b='" + g1b + '\'' +
                ", g2name='" + g2name + '\'' +
                ", g2code2='" + g2code2 + '\'' +
                ", g8name='" + g8name + '\'' +
                ", g8code2='" + g8code2 + '\'' +
                ", g9name='" + g9name + '\'' +
                ", g9code2='" + g9code2 + '\'' +
                ", g11='" + g11 + '\'' +
                ", g12='" + g12 + '\'' +
                ", g13='" + g13 + '\'' +
                ", g15='" + g15 + '\'' +
                ", g17='" + g17 + '\'' +
                ", g20b='" + g20b + '\'' +
                ", g20name='" + g20name + '\'' +
                ", g22a='" + g22a + '\'' +
                ", g22b='" + g22b + '\'' +
                ", g23='" + g23 + '\'' +
                ", g23scale='" + g23scale + '\'' +
                ", g25='" + g25 + '\'' +
                ", g26='" + g26 + '\'' +
                ", g20fr='" + g20fr + '\'' +
                ", g24a='" + g24a + '\'' +
                ", g24b='" + g24b + '\'' +
                ", idn='" + idn + '\'' +
                ", g31name='" + g31name + '\'' +
                ", g31marka='" + g31marka + '\'' +
                ", g31amount='" + g31amount + '\'' +
                ", g32='" + g32 + '\'' +
                ", g33='" + g33 + '\'' +
                ", g34='" + g34 + '\'' +
                ", g35='" + g35 + '\'' +
                ", g37b='" + g37b + '\'' +
                ", g37c='" + g37c + '\'' +
                ", g38='" + g38 + '\'' +
                ", g41='" + g41 + '\'' +
                ", g42='" + g42 + '\'' +
                ", g43='" + g43 + '\'' +
                ", g45='" + g45 + '\'' +
                ", g46='" + g46 + '\'' +
                ", g31edizm='" + g31edizm + '\'' +
                ", g45usd='" + g45usd + '\'' +
                ", unitname='" + unitname + '\'' +
                ", ves_edizm='" + ves_edizm + '\'' +
                ", metod_otc='" + metod_otc + '\'' +
                ", g45_usd='" + g45_usd + '\'' +
                ", g45usd_edizm='" + g45usd_edizm + '\'' +
                ", g45sum_edizm='" + g45sum_edizm + '\'' +
                ", g45_index='" + g45_index + '\'' +
                ", g45_edizm_valkont='" + g45_edizm_valkont + '\'' +
                ", g45_index_valkont='" + g45_index_valkont + '\'' +
                ", g42_usd='" + g42_usd + '\'' +
                ", g42usd_edizm='" + g42usd_edizm + '\'' +
                ", g42sum_edizm='" + g42sum_edizm + '\'' +
                ", g42_index='" + g42_index + '\'' +
                ", g42_edizm_valkont='" + g42_edizm_valkont + '\'' +
                ", g42_index_valkont='" + g42_index_valkont + '\'' +
                ", gc3date='" + gc3date + '\'' +
                ", vid_tulov='" + vid_tulov + '\'' +
                ", doc_type='" + doc_type + '\'' +
                ", gdvipdate='" + gdvipdate + '\'' +
                ", status='" + status + '\'' +
                ", instime='" + instime + '\'' +
                ", updtime='" + updtime + '\'' +
                ", curtime='" + curtime + '\'' +
                ", mtcid='" + mtcid + '\'' +
                ", id_mtc='" + id_mtc + '\'' +
                ", g11name='" + g11name + '\'' +
                ", g15name='" + g15name + '\'' +
                ", g17name='" + g17name + '\'' +
                ", g34name='" + g34name + '\'' +
                ", g41name='" + g41name + '\'' +
                '}';
    }
}
