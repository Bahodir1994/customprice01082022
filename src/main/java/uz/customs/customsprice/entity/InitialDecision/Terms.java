package uz.customs.customsprice.entity.InitialDecision;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "DELIVERY_TERMS", schema = "CPID")
public class Terms {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private String id;
    @Basic
    @Column(name = "NAME")
    private String name;
    @Basic
    @Column(name = "SIGN")
    private String sign;
    @Basic
    @Column(name = "RAQAM")
    private String raqam;
    @Basic
    @Column(name = "LNGA_TPCD")
    private String lngaTpcd;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getRaqam() {
        return raqam;
    }

    public void setRaqam(String raqam) {
        this.raqam = raqam;
    }

    public String getLngaTpcd() {
        return lngaTpcd;
    }

    public void setLngaTpcd(String lngaTpcd) {
        this.lngaTpcd = lngaTpcd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Terms that = (Terms) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(sign, that.sign) && Objects.equals(raqam, that.raqam) && Objects.equals(lngaTpcd, that.lngaTpcd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, sign, raqam, lngaTpcd);
    }
}
