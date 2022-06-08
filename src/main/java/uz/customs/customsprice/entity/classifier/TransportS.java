package uz.customs.customsprice.entity.classifier;

import org.hibernate.annotations.Where;
import uz.customs.customsprice.entity.entityConfig.AbstractAuditingEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "TRANSPORTS")
@Where(clause = "USE_YN = 'Y'")
public class TransportS {
    @Id
    @Column(name = "CODE", columnDefinition = "VARCHAR(3) CCSID 1025")
    String code;

    @Column(name = "CD_DESC", columnDefinition = "VARCHAR(600) CCSID 1208")
    String cdDesc;

    @Column(name = "CD_ID", columnDefinition = "VARCHAR(20) CCSID 1025")
    String cdId;

    @Column(name = "CD_ID_L", columnDefinition = "VARCHAR(2) CCSID 1025")
    String cdIdL;

    @Column(name = "CD_NM", columnDefinition = "VARCHAR(600) CCSID 1208")
    String cdNm;

    @Column(name = "CD_SHORT_NM", columnDefinition = "VARCHAR(600) CCSID 1208")
    String cdShortNm;

    @Column(name = "CD_ORDR", columnDefinition = "VARCHAR(4) CCSID 1025")
    String cdOrdr;

    @Column(name = "LNGA_TPCD", columnDefinition = "VARCHAR(2) CCSID 1025")
    String lngaTpcd;

    @Column(name = "USE_YN", columnDefinition = "VARCHAR(2) CCSID 1025")
    String useYN;

    public TransportS() {
    }

    public TransportS(String code, String cdDesc, String cdId, String cdIdL, String cdNm, String cdShortNm, String cdOrdr, String lngaTpcd, String useYN) {
        this.code = code;
        this.cdDesc = cdDesc;
        this.cdId = cdId;
        this.cdIdL = cdIdL;
        this.cdNm = cdNm;
        this.cdShortNm = cdShortNm;
        this.cdOrdr = cdOrdr;
        this.lngaTpcd = lngaTpcd;
        this.useYN = useYN;
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

    public String getCdShortNm() {
        return cdShortNm;
    }

    public void setCdShortNm(String cdShortNm) {
        this.cdShortNm = cdShortNm;
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
}