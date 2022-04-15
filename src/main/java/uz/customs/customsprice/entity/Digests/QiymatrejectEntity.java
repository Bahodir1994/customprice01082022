package uz.customs.customsprice.entity.Digests;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "QIYMATREJECT", schema = "EPIGUED", catalog = "")
public class QiymatrejectEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private String id;
    @Basic
    @Column(name = "DECL_ID")
    private String declId;
    @Basic
    @Column(name = "G7A")
    private String g7A;
    @Basic
    @Column(name = "G7B")
    private Date g7B;
    @Basic
    @Column(name = "G7C")
    private String g7C;
    @Basic
    @Column(name = "SABAB1")
    private Short sabab1;
    @Basic
    @Column(name = "SABAB2")
    private Short sabab2;
    @Basic
    @Column(name = "SABAB3")
    private Short sabab3;
    @Basic
    @Column(name = "SABAB4")
    private Short sabab4;
    @Basic
    @Column(name = "SHARTLI")
    private Short shartli;
    @Basic
    @Column(name = "USER_ID")
    private String userId;
    @Basic
    @Column(name = "INSTIME")
    private Timestamp instime;
    @Basic
    @Column(name = "UPDTIME")
    private Timestamp updtime;
    @Basic
    @Column(name = "STATUS")
    private Short status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeclId() {
        return declId;
    }

    public void setDeclId(String declId) {
        this.declId = declId;
    }

    public String getG7A() {
        return g7A;
    }

    public void setG7A(String g7A) {
        this.g7A = g7A;
    }

    public Date getG7B() {
        return g7B;
    }

    public void setG7B(Date g7B) {
        this.g7B = g7B;
    }

    public String getG7C() {
        return g7C;
    }

    public void setG7C(String g7C) {
        this.g7C = g7C;
    }

    public Short getSabab1() {
        return sabab1;
    }

    public void setSabab1(Short sabab1) {
        this.sabab1 = sabab1;
    }

    public Short getSabab2() {
        return sabab2;
    }

    public void setSabab2(Short sabab2) {
        this.sabab2 = sabab2;
    }

    public Short getSabab3() {
        return sabab3;
    }

    public void setSabab3(Short sabab3) {
        this.sabab3 = sabab3;
    }

    public Short getSabab4() {
        return sabab4;
    }

    public void setSabab4(Short sabab4) {
        this.sabab4 = sabab4;
    }

    public Short getShartli() {
        return shartli;
    }

    public void setShartli(Short shartli) {
        this.shartli = shartli;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Timestamp getInstime() {
        return instime;
    }

    public void setInstime(Timestamp instime) {
        this.instime = instime;
    }

    public Timestamp getUpdtime() {
        return updtime;
    }

    public void setUpdtime(Timestamp updtime) {
        this.updtime = updtime;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QiymatrejectEntity that = (QiymatrejectEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(declId, that.declId) && Objects.equals(g7A, that.g7A) && Objects.equals(g7B, that.g7B) && Objects.equals(g7C, that.g7C) && Objects.equals(sabab1, that.sabab1) && Objects.equals(sabab2, that.sabab2) && Objects.equals(sabab3, that.sabab3) && Objects.equals(sabab4, that.sabab4) && Objects.equals(shartli, that.shartli) && Objects.equals(userId, that.userId) && Objects.equals(instime, that.instime) && Objects.equals(updtime, that.updtime) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, declId, g7A, g7B, g7C, sabab1, sabab2, sabab3, sabab4, shartli, userId, instime, updtime, status);
    }
}
