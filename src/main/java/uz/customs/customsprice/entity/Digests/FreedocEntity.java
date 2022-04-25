package uz.customs.customsprice.entity.Digests;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "FREEDOC", schema = "PCABINET", catalog = "")
public class FreedocEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private String id;
    @Basic
    @Column(name = "DECL_ID")
    private String declId;
    @Basic
    @Column(name = "DOCNAME")
    private String docname;
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
    @Column(name = "HASH")
    private String hash;
    @Basic
    @Column(name = "DOC_TYPE")
    private String docType;

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

    public String getDocname() {
        return docname;
    }

    public void setDocname(String docname) {
        this.docname = docname;
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

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FreedocEntity that = (FreedocEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(declId, that.declId) && Objects.equals(docname, that.docname) && Objects.equals(userId, that.userId) && Objects.equals(instime, that.instime) && Objects.equals(updtime, that.updtime) && Objects.equals(hash, that.hash) && Objects.equals(docType, that.docType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, declId, docname, userId, instime, updtime, hash, docType);
    }
}
