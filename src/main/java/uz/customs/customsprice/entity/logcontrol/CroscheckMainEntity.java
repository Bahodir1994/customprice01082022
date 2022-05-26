package uz.customs.customsprice.entity.logcontrol;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "CROSCHECK_MAIN", schema = "XBT", catalog = "")
public class CroscheckMainEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private String id;
    @Basic
    @Column(name = "FLK_DEP")
    private String flkDep;
    @Basic
    @Column(name = "FLK_DOCTYPE")
    private String flkDoctype;
    @Basic
    @Column(name = "FLK_DATE")
    private Date flkDate;
    @Basic
    @Column(name = "FLK_NUM")
    private String flkNum;
    @Basic
    @Column(name = "FLK_NAME")
    private String flkName;
    @Basic
    @Column(name = "FLK_TYPE")
    private String flkType;
    @Basic
    @Column(name = "FLK_RULS")
    private String flkRuls;
    @Basic
    @Column(name = "FLK_FROM")
    private Date flkFrom;
    @Basic
    @Column(name = "FLK_TO")
    private Date flkTo;
    @Basic
    @Column(name = "FLK_BASE")
    private String flkBase;
    @Basic
    @Column(name = "FLK_MSG")
    private String flkMsg;
    @Basic
    @Column(name = "FLK_SQL")
    private String flkSql;
    @Basic
    @Column(name = "STATUS")
    private String status;
    @Basic
    @Column(name = "OWNER_ID")
    private String ownerId;
    @Basic
    @Column(name = "INSTIME")
    private Timestamp instime;
    @Basic
    @Column(name = "ADMIN_ID")
    private String adminId;
    @Basic
    @Column(name = "CHECKINTIME")
    private Timestamp checkintime;
    @Basic
    @Column(name = "UPDTIME")
    private Timestamp updtime;
    @Basic
    @Column(name = "SQL_BEGIN")
    private String sqlBegin;
    @Basic
    @Column(name = "STEP_ALL")
    private Short stepAll;
    @Basic
    @Column(name = "STEP_GET")
    private Short stepGet;
    @Basic
    @Column(name = "STEP_REG")
    private Short stepReg;
    @Basic
    @Column(name = "STEP_VIP")
    private Short stepVip;
    @Basic
    @Column(name = "AUTOVIP")
    private Short autovip;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFlkDep() {
        return flkDep;
    }

    public void setFlkDep(String flkDep) {
        this.flkDep = flkDep;
    }

    public String getFlkDoctype() {
        return flkDoctype;
    }

    public void setFlkDoctype(String flkDoctype) {
        this.flkDoctype = flkDoctype;
    }

    public Date getFlkDate() {
        return flkDate;
    }

    public void setFlkDate(Date flkDate) {
        this.flkDate = flkDate;
    }

    public String getFlkNum() {
        return flkNum;
    }

    public void setFlkNum(String flkNum) {
        this.flkNum = flkNum;
    }

    public String getFlkName() {
        return flkName;
    }

    public void setFlkName(String flkName) {
        this.flkName = flkName;
    }

    public String getFlkType() {
        return flkType;
    }

    public void setFlkType(String flkType) {
        this.flkType = flkType;
    }

    public String getFlkRuls() {
        return flkRuls;
    }

    public void setFlkRuls(String flkRuls) {
        this.flkRuls = flkRuls;
    }

    public Date getFlkFrom() {
        return flkFrom;
    }

    public void setFlkFrom(Date flkFrom) {
        this.flkFrom = flkFrom;
    }

    public Date getFlkTo() {
        return flkTo;
    }

    public void setFlkTo(Date flkTo) {
        this.flkTo = flkTo;
    }

    public String getFlkBase() {
        return flkBase;
    }

    public void setFlkBase(String flkBase) {
        this.flkBase = flkBase;
    }

    public String getFlkMsg() {
        return flkMsg;
    }

    public void setFlkMsg(String flkMsg) {
        this.flkMsg = flkMsg;
    }

    public String getFlkSql() {
        return flkSql;
    }

    public void setFlkSql(String flkSql) {
        this.flkSql = flkSql;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public Timestamp getInstime() {
        return instime;
    }

    public void setInstime(Timestamp instime) {
        this.instime = instime;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public Timestamp getCheckintime() {
        return checkintime;
    }

    public void setCheckintime(Timestamp checkintime) {
        this.checkintime = checkintime;
    }

    public Timestamp getUpdtime() {
        return updtime;
    }

    public void setUpdtime(Timestamp updtime) {
        this.updtime = updtime;
    }

    public String getSqlBegin() {
        return sqlBegin;
    }

    public void setSqlBegin(String sqlBegin) {
        this.sqlBegin = sqlBegin;
    }

    public Short getStepAll() {
        return stepAll;
    }

    public void setStepAll(Short stepAll) {
        this.stepAll = stepAll;
    }

    public Short getStepGet() {
        return stepGet;
    }

    public void setStepGet(Short stepGet) {
        this.stepGet = stepGet;
    }

    public Short getStepReg() {
        return stepReg;
    }

    public void setStepReg(Short stepReg) {
        this.stepReg = stepReg;
    }

    public Short getStepVip() {
        return stepVip;
    }

    public void setStepVip(Short stepVip) {
        this.stepVip = stepVip;
    }

    public Short getAutovip() {
        return autovip;
    }

    public void setAutovip(Short autovip) {
        this.autovip = autovip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CroscheckMainEntity that = (CroscheckMainEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(flkDep, that.flkDep) && Objects.equals(flkDoctype, that.flkDoctype) && Objects.equals(flkDate, that.flkDate) && Objects.equals(flkNum, that.flkNum) && Objects.equals(flkName, that.flkName) && Objects.equals(flkType, that.flkType) && Objects.equals(flkRuls, that.flkRuls) && Objects.equals(flkFrom, that.flkFrom) && Objects.equals(flkTo, that.flkTo) && Objects.equals(flkBase, that.flkBase) && Objects.equals(flkMsg, that.flkMsg) && Objects.equals(flkSql, that.flkSql) && Objects.equals(status, that.status) && Objects.equals(ownerId, that.ownerId) && Objects.equals(instime, that.instime) && Objects.equals(adminId, that.adminId) && Objects.equals(checkintime, that.checkintime) && Objects.equals(updtime, that.updtime) && Objects.equals(sqlBegin, that.sqlBegin) && Objects.equals(stepAll, that.stepAll) && Objects.equals(stepGet, that.stepGet) && Objects.equals(stepReg, that.stepReg) && Objects.equals(stepVip, that.stepVip) && Objects.equals(autovip, that.autovip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, flkDep, flkDoctype, flkDate, flkNum, flkName, flkType, flkRuls, flkFrom, flkTo, flkBase, flkMsg, flkSql, status, ownerId, instime, adminId, checkintime, updtime, sqlBegin, stepAll, stepGet, stepReg, stepVip, autovip);
    }
}
