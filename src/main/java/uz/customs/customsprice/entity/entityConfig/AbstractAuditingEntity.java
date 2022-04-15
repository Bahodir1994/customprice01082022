package uz.customs.customsprice.entity.entityConfig;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractAuditingEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @CreatedBy
    @Column(name = "insuser", length = 50, updatable = false)
    private String insUser;

    @LastModifiedBy
    @Column(name = "upduser", length = 50)
    private String updUser;

    @CreatedDate
    @Column(name = "instime", columnDefinition = " timestamp default current_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insTime = new Date(System.currentTimeMillis());

    @LastModifiedDate
    @Column(name = "updtime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updTime;

    @Column(name = "isdeleted", columnDefinition = " SMALLINT DEFAULT 0")
    private int isDeleted;

    public AbstractAuditingEntity() {
    }

    public AbstractAuditingEntity(String insUser, String updUser, Date insTime, Date updTime, int isDeleted) {
        this.insUser = insUser;
        this.updUser = updUser;
        this.insTime = insTime;
        this.updTime = updTime;
        this.isDeleted = isDeleted;
    }

    public String getInsUser() {
        return insUser;
    }

    public void setInsUser(String insUser) {
        this.insUser = insUser;
    }

    public String getUpdUser() {
        return updUser;
    }

    public void setUpdUser(String updUser) {
        this.updUser = updUser;
    }

    public Date getInsTime() {
        return insTime;
    }

    public void setInsTime(Date insTime) {
        this.insTime = insTime;
    }

    public Date getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }
}
