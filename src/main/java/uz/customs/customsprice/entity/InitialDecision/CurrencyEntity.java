package uz.customs.customsprice.entity.InitialDecision;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CURRENCY", schema = "CPID", catalog = "")
@IdClass(CurrencyEntityPK.class)
public class CurrencyEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CODE")
    private String code;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "LNGA_TPCD")
    private String lngaTpcd;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CD_ID")
    private String cdId;
    @Basic
    @Column(name = "CD_NM")
    private String cdNm;
    @Basic
    @Column(name = "CD_DESC")
    private String cdDesc;
    @Basic
    @Column(name = "CD_ORDR")
    private String cdOrdr;
    @Basic
    @Column(name = "USE_YN")
    private String useYn;
    @Basic
    @Column(name = "CD_ID_L")
    private String cdIdL;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrencyEntity that = (CurrencyEntity) o;
        return Objects.equals(code, that.code) && Objects.equals(lngaTpcd, that.lngaTpcd) && Objects.equals(cdId, that.cdId) && Objects.equals(cdNm, that.cdNm) && Objects.equals(cdDesc, that.cdDesc) && Objects.equals(cdOrdr, that.cdOrdr) && Objects.equals(useYn, that.useYn) && Objects.equals(cdIdL, that.cdIdL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, lngaTpcd, cdId, cdNm, cdDesc, cdOrdr, useYn, cdIdL);
    }
}
