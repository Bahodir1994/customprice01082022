package uz.customs.customsprice.entity.InitialDecision;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import uz.customs.customsprice.entity.entityConfig.AbstractAuditingEntity;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class TransportType extends AbstractAuditingEntity {
    @Id
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(50)")
    private String id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "APP_ID", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Apps apps;

    @Column(name = "APP_ID", columnDefinition = "VARCHAR(50)")
    private String appId;

    @Column(name = "finish_country", length = 3)
    private String finishCountry;

    @Column(name = "finish_country_NM", columnDefinition = "VARCHAR(120) CCSID 1208")
    private String finishCountryNm;

    @Column(name = "end_country", length = 3)
    private String endCountry;

    @Column(name = "end_country_NM", columnDefinition = "VARCHAR(120) CCSID 1208")
    private String endCountryNm;

    @Column(name = "tarnsport_type", length = 2)
    private String tarnsportType;

    @Column(name = "tarnsport_type_NM", columnDefinition = "VARCHAR(120) CCSID 1208")
    private String tarnsportTypeNm;

    @Column(name = "transport_price")
    @Digits(integer = 15, fraction = 3)
    private BigDecimal transportPrice;

    public TransportType() {
    }

    public TransportType(String insUser, String updUser, Date insTime, Date updTime, int isDeleted, String id, Apps apps, String appId, String finishCountry, String finishCountryNm, String endCountry, String endCountryNm, String tarnsportType, String tarnsportTypeNm, BigDecimal transportPrice) {
        super(insUser, updUser, insTime, updTime, isDeleted);
        this.id = id;
        this.apps = apps;
        this.appId = appId;
        this.finishCountry = finishCountry;
        this.finishCountryNm = finishCountryNm;
        this.endCountry = endCountry;
        this.endCountryNm = endCountryNm;
        this.tarnsportType = tarnsportType;
        this.tarnsportTypeNm = tarnsportTypeNm;
        this.transportPrice = transportPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Apps getApps() {
        return apps;
    }

    public void setApps(Apps apps) {
        this.apps = apps;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getFinishCountry() {
        return finishCountry;
    }

    public void setFinishCountry(String finishCountry) {
        this.finishCountry = finishCountry;
    }

    public String getFinishCountryNm() {
        return finishCountryNm;
    }

    public void setFinishCountryNm(String finishCountryNm) {
        this.finishCountryNm = finishCountryNm;
    }

    public String getEndCountry() {
        return endCountry;
    }

    public void setEndCountry(String endCountry) {
        this.endCountry = endCountry;
    }

    public String getEndCountryNm() {
        return endCountryNm;
    }

    public void setEndCountryNm(String endCountryNm) {
        this.endCountryNm = endCountryNm;
    }

    public String getTarnsportType() {
        return tarnsportType;
    }

    public void setTarnsportType(String tarnsportType) {
        this.tarnsportType = tarnsportType;
    }

    public String getTarnsportTypeNm() {
        return tarnsportTypeNm;
    }

    public void setTarnsportTypeNm(String tarnsportTypeNm) {
        this.tarnsportTypeNm = tarnsportTypeNm;
    }

    public BigDecimal getTransportPrice() {
        return transportPrice;
    }

    public void setTransportPrice(BigDecimal transportPrice) {
        this.transportPrice = transportPrice;
    }
}








