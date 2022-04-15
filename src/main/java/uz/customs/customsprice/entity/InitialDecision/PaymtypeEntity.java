package uz.customs.customsprice.entity.InitialDecision;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PAYMTYPE", schema = "CPID", catalog = "")
public class PaymtypeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private String id;
    @Basic
    @Column(name = "SPNAME")
    private String spname;
    @Basic
    @Column(name = "ISDELETED")
    private Short isdeleted;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSpname() {
        return spname;
    }

    public void setSpname(String spname) {
        this.spname = spname;
    }

    public Short getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Short isdeleted) {
        this.isdeleted = isdeleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymtypeEntity that = (PaymtypeEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(spname, that.spname) && Objects.equals(isdeleted, that.isdeleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, spname, isdeleted);
    }
}
