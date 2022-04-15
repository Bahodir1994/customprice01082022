package uz.customs.customsprice.entity.InitialDecision;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "STATUS_TYPE")
public class Status {
    @Id
    @Column(name = "id", columnDefinition = "SMALLINT")
    private Integer id;

    @Column(name = "NAME", columnDefinition = "VARCHAR(120) CCSID 1208")
    private String name;

    @Column(name = "COMMENT", columnDefinition = "VARCHAR(300) CCSID 1208")
    private String comment;

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

    public Status() {
    }

    public Status(Integer id, String name, String comment, String insUser, String updUser, Date insTime, Date updTime, int isDeleted) {
        this.id = id;
        this.name = name;
        this.comment = comment;
        this.insUser = insUser;
        this.updUser = updUser;
        this.insTime = insTime;
        this.updTime = updTime;
        this.isDeleted = isDeleted;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
