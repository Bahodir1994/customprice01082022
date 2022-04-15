package uz.customs.customsprice.entity.InitialDecision;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import uz.customs.customsprice.entity.entityConfig.AbstractAuditingEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "log", indexes = {@Index(columnList = "ses_id")})
public class Log {

    @Id
    @Column(name = "SES_ID", length = 100)
    private String sesId = "";

    @Column(name = "NAME")
    private String name = "";

    @Column(name = "IP")
    private String ip = "";

    @CreatedDate
    @Column(name = "ENTER", columnDefinition = " timestamp default current_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date enter = new Date(System.currentTimeMillis());

    @LastModifiedDate
    @Column(name = "LAST")
    @Temporal(TemporalType.TIMESTAMP)
    private Date last;

    @LastModifiedDate
    @Column(name = "EXIT", columnDefinition = " timestamp default null")
    @Temporal(TemporalType.TIMESTAMP)
    private Date exit = null;

    @Column(name = "USER_ID")
    private String userId = "";

    public Log() {
    }

    public Log(String sesId, String name, String ip, Date enter, Date last, Date exit, String userId) {
        this.sesId = sesId;
        this.name = name;
        this.ip = ip;
        this.enter = enter;
        this.last = last;
        this.exit = exit;
        this.userId = userId;
    }

    public String getSesId() {
        return sesId;
    }

    public void setSesId(String sesId) {
        this.sesId = sesId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getEnter() {
        return enter;
    }

    public void setEnter(Date enter) {
        this.enter = enter;
    }

    public Date getLast() {
        return last;
    }

    public void setLast(Date last) {
        this.last = last;
    }

    public Date getExit() {
        return exit;
    }

    public void setExit(Date exit) {
        this.exit = exit;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
