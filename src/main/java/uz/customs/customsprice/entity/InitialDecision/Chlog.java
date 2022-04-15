package uz.customs.customsprice.entity.InitialDecision;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "CHLOG", schema = "CPID")
public class Chlog {
    @Id
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(50)")
    private String id;



    @Basic
    @Column(name = "TABLE_NAME")
    private String tableName;
    @Basic
    @Column(name = "COLUMN")
    private String column;
    @Basic
    @Column(name = "NEW_VALUE")
    private String newValue;
    @Basic
    @Column(name = "OLD_VALUE")
    private String oldValue;
    @Basic
    @Column(name = "USER_ID")
    private String userId;
    @Basic
    @Column(name = "USER_NAME")
    private String userName;
    @Basic
    @Column(name = "IP")
    private String ip;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE_CHANGE")
    private Date dateChange;

    @Basic
    @Column(name = "REASON")
    private String reason;
    @Basic
    @Column(name = "RECORD_ID")
    private String recordId;

    public Chlog() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getDateChange() {
        return dateChange;
    }

    public void setDateChange(Timestamp dateChange) {
        this.dateChange = dateChange;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chlog that = (Chlog) o;
        return Objects.equals(id, that.id) && Objects.equals(tableName, that.tableName) && Objects.equals(column, that.column) && Objects.equals(newValue, that.newValue) && Objects.equals(oldValue, that.oldValue) && Objects.equals(userId, that.userId) && Objects.equals(userName, that.userName) && Objects.equals(ip, that.ip) && Objects.equals(dateChange, that.dateChange) && Objects.equals(reason, that.reason) && Objects.equals(recordId, that.recordId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tableName, column, newValue, oldValue, userId, userName, ip, dateChange, reason, recordId);
    }
}
