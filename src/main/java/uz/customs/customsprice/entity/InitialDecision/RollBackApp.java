package uz.customs.customsprice.entity.InitialDecision;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import uz.customs.customsprice.entity.entityConfig.AbstractAuditingEntity;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "ROLLBACK_APP")
public class RollBackApp extends AbstractAuditingEntity {

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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "STATUS_H_ID", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private StatusH statusH;

    @Column(name = "STATUS_H_ID", columnDefinition = "VARCHAR(50)")
    private String statusHId;

    @Column(name = "ROLLBACK_ID", columnDefinition = "VARCHAR(50)")
    private String rollbackId;

    @Column(name = "ROLLBACK_NAME", columnDefinition = "VARCHAR(600) CCSID 1208")
    private String rollbackName;

    public RollBackApp() {
    }

    public RollBackApp(String insUser, String updUser, Date insTime, Date updTime, int isDeleted, String id, Apps apps, String appId, StatusH statusH, String statusHId, String rollbackId, String rollbackName) {
        super(insUser, updUser, insTime, updTime, isDeleted);
        this.id = id;
        this.apps = apps;
        this.appId = appId;
        this.statusH = statusH;
        this.statusHId = statusHId;
        this.rollbackId = rollbackId;
        this.rollbackName = rollbackName;
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

    public StatusH getStatusH() {
        return statusH;
    }

    public void setStatusH(StatusH statusH) {
        this.statusH = statusH;
    }

    public String getStatusHId() {
        return statusHId;
    }

    public void setStatusHId(String statusHId) {
        this.statusHId = statusHId;
    }

    public String getRollbackId() {
        return rollbackId;
    }

    public void setRollbackId(String rollbackId) {
        this.rollbackId = rollbackId;
    }

    public String getRollbackName() {
        return rollbackName;
    }

    public void setRollbackName(String rollbackName) {
        this.rollbackName = rollbackName;
    }
}
