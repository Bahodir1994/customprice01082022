package uz.customs.customsprice.entity.InitialDecision;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(PackagingPK.class)
public class Packaging {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CODE")
    private String code;
    @Basic
    @Column(name = "CD_DESC")
    private String cdDesc;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CD_ID")
    private String cdId;
    @Basic
    @Column(name = "CD_ID_L")
    private String cdIdL;
    @Basic
    @Column(name = "CD_NM")
    private String cdNm;
    @Basic
    @Column(name = "CD_ORDR")
    private String cdOrdr;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "LNGA_TPCD")
    private String lngaTpcd;
    @Basic
    @Column(name = "USE_YN")
    private String useYn;

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

    public String getUseYn() {
        return useYn;
    }

    public void setUseYn(String useYn) {
        this.useYn = useYn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Packaging packaging = (Packaging) o;
        return Objects.equals(code, packaging.code) && Objects.equals(cdDesc, packaging.cdDesc) && Objects.equals(cdId, packaging.cdId) && Objects.equals(cdIdL, packaging.cdIdL) && Objects.equals(cdNm, packaging.cdNm) && Objects.equals(cdOrdr, packaging.cdOrdr) && Objects.equals(lngaTpcd, packaging.lngaTpcd) && Objects.equals(useYn, packaging.useYn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, cdDesc, cdId, cdIdL, cdNm, cdOrdr, lngaTpcd, useYn);
    }
}
