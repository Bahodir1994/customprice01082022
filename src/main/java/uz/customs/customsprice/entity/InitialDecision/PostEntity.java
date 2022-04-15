package uz.customs.customsprice.entity.InitialDecision;

import javax.persistence.*;
import java.util.Objects;

//@Entity
//@Table(name = "POST", schema = "CPID", catalog = "")
//@IdClass(PostEntityPK.class)
//public class PostEntity {
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Id
//    @Column(name = "CODE")
//    private String code;
//    @Basic
//    @Column(name = "CD_DESC")
//    private String cdDesc;
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Id
//    @Column(name = "CD_ID")
//    private String cdId;
//    @Basic
//    @Column(name = "CD_ID_L")
//    private String cdIdL;
//    @Basic
//    @Column(name = "CD_NM")
//    private String cdNm;
//    @Basic
//    @Column(name = "CD_ORDR")
//    private String cdOrdr;
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Id
//    @Column(name = "LNGA_TPCD")
//    private String lngaTpcd;
//    @Basic
//    @Column(name = "USE_YN")
//    private String useYn;
//    @Basic
//    @Column(name = "LAT")
//    private String lat;
//    @Basic
//    @Column(name = "LONG")
//    private java.lang.String String;
//    @Basic
//    @Column(name = "ADRESS")
//    private String adress;
//    @Basic
//    @Column(name = "TELEPHONE")
//    private String telephone;
//    @Basic
//    @Column(name = "HOURS")
//    private String hours;
//    @Basic
//    @Column(name = "DIRECTION")
//    private String direction;
//
//    public String getCode() {
//        return code;
//    }
//
//    public void setCode(String code) {
//        this.code = code;
//    }
//
//    public String getCdDesc() {
//        return cdDesc;
//    }
//
//    public void setCdDesc(String cdDesc) {
//        this.cdDesc = cdDesc;
//    }
//
//    public String getCdId() {
//        return cdId;
//    }
//
//    public void setCdId(String cdId) {
//        this.cdId = cdId;
//    }
//
//    public String getCdIdL() {
//        return cdIdL;
//    }
//
//    public void setCdIdL(String cdIdL) {
//        this.cdIdL = cdIdL;
//    }
//
//    public String getCdNm() {
//        return cdNm;
//    }
//
//    public void setCdNm(String cdNm) {
//        this.cdNm = cdNm;
//    }
//
//    public String getCdOrdr() {
//        return cdOrdr;
//    }
//
//    public void setCdOrdr(String cdOrdr) {
//        this.cdOrdr = cdOrdr;
//    }
//
//    public String getLngaTpcd() {
//        return lngaTpcd;
//    }
//
//    public void setLngaTpcd(String lngaTpcd) {
//        this.lngaTpcd = lngaTpcd;
//    }
//
//    public String getUseYn() {
//        return useYn;
//    }
//
//    public void setUseYn(String useYn) {
//        this.useYn = useYn;
//    }
//
//    public String getLat() {
//        return lat;
//    }
//
//    public void setLat(String lat) {
//        this.lat = lat;
//    }
//
//    public java.lang.String getString() {
//        return String;
//    }
//
//    public void setString(java.lang.String string) {
//        String = string;
//    }
//
//    public java.lang.String getAdress() {
//        return adress;
//    }
//
//    public void setAdress(java.lang.String adress) {
//        this.adress = adress;
//    }
//
//    public java.lang.String getTelephone() {
//        return telephone;
//    }
//
//    public void setTelephone(java.lang.String telephone) {
//        this.telephone = telephone;
//    }
//
//    public java.lang.String getHours() {
//        return hours;
//    }
//
//    public void setHours(java.lang.String hours) {
//        this.hours = hours;
//    }
//
//    public java.lang.String getDirection() {
//        return direction;
//    }
//
//    public void setDirection(java.lang.String direction) {
//        this.direction = direction;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        PostEntity that = (PostEntity) o;
//        return Objects.equals(code, that.code) && Objects.equals(cdDesc, that.cdDesc) && Objects.equals(cdId, that.cdId) && Objects.equals(cdIdL, that.cdIdL) && Objects.equals(cdNm, that.cdNm) && Objects.equals(cdOrdr, that.cdOrdr) && Objects.equals(lngaTpcd, that.lngaTpcd) && Objects.equals(useYn, that.useYn) && Objects.equals(lat, that.lat) && Objects.equals(String, that.String) && Objects.equals(adress, that.adress) && Objects.equals(telephone, that.telephone) && Objects.equals(hours, that.hours) && Objects.equals(direction, that.direction);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(code, cdDesc, cdId, cdIdL, cdNm, cdOrdr, lngaTpcd, useYn, lat, String, adress, telephone, hours, direction);
//    }
//}
