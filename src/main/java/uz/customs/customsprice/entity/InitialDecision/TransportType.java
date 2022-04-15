package uz.customs.customsprice.entity.InitialDecision;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import uz.customs.customsprice.entity.entityConfig.AbstractAuditingEntity;

import javax.persistence.*;
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

    @Column(name = "end_country", length = 3)
    private String endCountry;

    @Column(name = "tarnsport_type", length = 2)
    private String tarnsportType;

    @Column(name = "transport_price", length = 4)
    private BigDecimal transportPrice;

    public TransportType() {
    }

    public TransportType(String insUser, String updUser, Date insTime, Date updTime, int isDeleted, String id, Apps apps, String appId, String finishCountry, String endCountry, String tarnsportType, BigDecimal transportPrice) {
        super(insUser, updUser, insTime, updTime, isDeleted);
        this.id = id;
        this.apps = apps;
        this.appId = appId;
        this.finishCountry = finishCountry;
        this.endCountry = endCountry;
        this.tarnsportType = tarnsportType;
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

    public String getEndCountry() {
        return endCountry;
    }

    public void setEndCountry(String endCountry) {
        this.endCountry = endCountry;
    }

    public String getTarnsportType() {
        return tarnsportType;
    }

    public void setTarnsportType(String tarnsportType) {
        this.tarnsportType = tarnsportType;
    }

    public BigDecimal getTransportPrice() {
        return transportPrice;
    }

    public void setTransportPrice(BigDecimal transportPrice) {
        this.transportPrice = transportPrice;
    }
}








