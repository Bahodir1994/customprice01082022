package uz.customs.customsprice.entity.InitialDecision;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Post {
    @Id
    @Column(name = "CODE") private String code;

    @Column(name = "CD_DESC", columnDefinition = "VARCHAR(600) CCSID 1208")
    private String cdDesc;

    @Column(name = "CD_ID", columnDefinition = "VARCHAR(20) CCSID 1025")
    private String cdId;

    @Column(name = "CD_ID_L", columnDefinition = "VARCHAR(2) CCSID 1025")
    private String cdIdL;

    @Column(name = "CD_NM", columnDefinition = "VARCHAR(600) CCSID 1208")
    private String cdNm;

    @Column(name = "CD_ORDR", columnDefinition = "VARCHAR(4) CCSID 1025")
    private String cdOrdr;

    @Column(name = "LNGA_TPCD", columnDefinition = "VARCHAR(2) CCSID 1025")
    private String lngaTpcd;

    @Column(name = "USE_YN", columnDefinition = "VARCHAR(2) CCSID 1025")
    private String useYN;

    @Column(name = "LAT", columnDefinition = "VARCHAR(25) CCSID 1025")
    private String lat;

    @Column(name = "LONG", columnDefinition = "VARCHAR(25) CCSID 1025")
    private String longs;

    @Column(name = "ADRESS", columnDefinition = "VARCHAR(1200) CCSID 1208")
    private String adress;

    @Column(name = "TELEPHONE", columnDefinition = "VARCHAR(100) CCSID 1025")
    private String telephone;

    @Column(name = "HOURS", columnDefinition = "VARCHAR(600) CCSID 1208")
    private String hours;

    @Column(name = "DIRECTION", columnDefinition = "VARCHAR(300) CCSID 1208")
    private String direction;

    public Post() {
    }

    public Post(String code, String cdDesc, String cdId, String cdIdL, String cdNm, String cdOrdr, String lngaTpcd, String useYN, String lat, String longs, String adress, String telephone, String hours, String direction) {
        this.code = code;
        this.cdDesc = cdDesc;
        this.cdId = cdId;
        this.cdIdL = cdIdL;
        this.cdNm = cdNm;
        this.cdOrdr = cdOrdr;
        this.lngaTpcd = lngaTpcd;
        this.useYN = useYN;
        this.lat = lat;
        this.longs = longs;
        this.adress = adress;
        this.telephone = telephone;
        this.hours = hours;
        this.direction = direction;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCdDesc() {
        return cdDesc;
    }

    public void setCdDesc(String cdDesc) {
        this.cdDesc = cdDesc;
    }

    public String getCdId() {
        return cdId;
    }

    public void setCdId(String cdId) {
        this.cdId = cdId;
    }

    public String getCdIdL() {
        return cdIdL;
    }

    public void setCdIdL(String cdIdL) {
        this.cdIdL = cdIdL;
    }

    public String getCdNm() {
        return cdNm;
    }

    public void setCdNm(String cdNm) {
        this.cdNm = cdNm;
    }

    public String getCdOrdr() {
        return cdOrdr;
    }

    public void setCdOrdr(String cdOrdr) {
        this.cdOrdr = cdOrdr;
    }

    public String getLngaTpcd() {
        return lngaTpcd;
    }

    public void setLngaTpcd(String lngaTpcd) {
        this.lngaTpcd = lngaTpcd;
    }

    public String getUseYN() {
        return useYN;
    }

    public void setUseYN(String useYN) {
        this.useYN = useYN;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLongs() {
        return longs;
    }

    public void setLongs(String longs) {
        this.longs = longs;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
