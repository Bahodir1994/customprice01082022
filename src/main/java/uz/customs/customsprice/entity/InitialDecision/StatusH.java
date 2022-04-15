package uz.customs.customsprice.entity.InitialDecision;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import uz.customs.customsprice.entity.entityConfig.AbstractAuditingEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "STATUS_H")
public class StatusH extends AbstractAuditingEntity {
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
    @JoinColumn(name = "STMAIN_ID", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private StatusM statusM;

    @Column(name = "STMAIN_ID", columnDefinition = "VARCHAR(50)")
    private String stmainID;

    @Column(name = "HISTORY_NUM")
    private Integer historyNum;

    @Column(name = "STATUS", length = 3)
    private String status;

    @Column(name = "STATUS_COMMENT", columnDefinition = "VARCHAR(1500) CCSID 1208")
    private String statusComment;

    public StatusH() {
    }

    public StatusH(String insUser, String updUser, Date insTime, Date updTime, int isDeleted, String id, Apps apps, String appId, StatusM statusM, String stmainID, Integer historyNum, String status, String statusComment) {
        super(insUser, updUser, insTime, updTime, isDeleted);
        this.id = id;
        this.apps = apps;
        this.appId = appId;
        this.statusM = statusM;
        this.stmainID = stmainID;
        this.historyNum = historyNum;
        this.status = status;
        this.statusComment = statusComment;
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

    public StatusM getStatusM() {
        return statusM;
    }

    public void setStatusM(StatusM statusM) {
        this.statusM = statusM;
    }

    public String getStmainID() {
        return stmainID;
    }

    public void setStmainID(String stmainID) {
        this.stmainID = stmainID;
    }

    public Integer getHistoryNum() {
        return historyNum;
    }

    public void setHistoryNum(Integer historyNum) {
        this.historyNum = historyNum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusComment() {
        return statusComment;
    }

    public void setStatusComment(String statusComment) {
        this.statusComment = statusComment;
    }
}
