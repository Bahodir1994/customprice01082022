package uz.customs.customsprice.entity.InitialDecision;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Country {
    @Id
    @Column(name = "code")
    private String id;

    @Column(name = "CODE", columnDefinition = "VARCHAR(3) CCSID 1025")
    private String code;

    @Column(name = "LNGA_TPCD", columnDefinition = "VARCHAR(2) CCSID 1025")
    private String lngaTpcd;

    @Column(name = "CD_ID", columnDefinition = "VARCHAR(2) CCSID 1025")
    private String cdId;

    @Column(name = "CD_NM", columnDefinition = "VARCHAR(600) CCSID 1208")
    private String cdNm;

    @Column(name = "CD_DESC", columnDefinition = "VARCHAR(600) CCSID 1208")
    private String cdDesc;

    @Column(name = "cd_ordr", columnDefinition = "VARCHAR(4) CCSID 1025")
    private String cdOrdr;

    @Column(name = "USE_YN", columnDefinition = "VARCHAR(2) CCSID 1025")
    private String useYn;

    @Column(name = "CD_ID_L", columnDefinition = "VARCHAR(2) CCSID 1025")
    private String cdIdL;

    public Country() {
    }

    public Country(String id, String code, String lngaTpcd, String cdId, String cdNm, String cdDesc, String cdOrdr, String useYn, String cdIdL) {
        this.id = id;
        this.code = code;
        this.lngaTpcd = lngaTpcd;
        this.cdId = cdId;
        this.cdNm = cdNm;
        this.cdDesc = cdDesc;
        this.cdOrdr = cdOrdr;
        this.useYn = useYn;
        this.cdIdL = cdIdL;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLngaTpcd() {
        return lngaTpcd;
    }

    public void setLngaTpcd(String lngaTpcd) {
        this.lngaTpcd = lngaTpcd;
    }

    public String getCdId() {
        return cdId;
    }

    public void setCdId(String cdId) {
        this.cdId = cdId;
    }

    public String getCdNm() {
        return cdNm;
    }

    public void setCdNm(String cdNm) {
        this.cdNm = cdNm;
    }

    public String getCdDesc() {
        return cdDesc;
    }

    public void setCdDesc(String cdDesc) {
        this.cdDesc = cdDesc;
    }

    public String getCdOrdr() {
        return cdOrdr;
    }

    public void setCdOrdr(String cdOrdr) {
        this.cdOrdr = cdOrdr;
    }

    public String getUseYn() {
        return useYn;
    }

    public void setUseYn(String useYn) {
        this.useYn = useYn;
    }

    public String getCdIdL() {
        return cdIdL;
    }

    public void setCdIdL(String cdIdL) {
        this.cdIdL = cdIdL;
    }
}