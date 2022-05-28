package uz.customs.customsprice.entity.InitialDecision;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class CurrencyEntityPK implements Serializable {
    @Column(name = "CODE")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String code;
    @Column(name = "LNGA_TPCD")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String lngaTpcd;
    @Column(name = "CD_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String cdId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrencyEntityPK that = (CurrencyEntityPK) o;
        return Objects.equals(code, that.code) && Objects.equals(lngaTpcd, that.lngaTpcd) && Objects.equals(cdId, that.cdId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, lngaTpcd, cdId);
    }
}
