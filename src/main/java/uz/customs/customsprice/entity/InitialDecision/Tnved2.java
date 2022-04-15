package uz.customs.customsprice.entity.InitialDecision;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Tnved2 {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private String id;
    @Basic
    @Column(name = "NAME")
    private String name;
    @Basic
    @Column(name = "UNIT1")
    private String unit1;
    @Basic
    @Column(name = "UNIT2")
    private String unit2;
    @Basic
    @Column(name = "LICENSE")
    private Short license;
    @Basic
    @Column(name = "ISDELETED")
    private short isdeleted;
    @Basic
    @Column(name = "STARTDATE")
    private Date startdate;
    @Basic
    @Column(name = "FINISHDATE")
    private Date finishdate;

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

    public String getUnit1() {
        return unit1;
    }

    public void setUnit1(String unit1) {
        this.unit1 = unit1;
    }

    public String getUnit2() {
        return unit2;
    }

    public void setUnit2(String unit2) {
        this.unit2 = unit2;
    }

    public Short getLicense() {
        return license;
    }

    public void setLicense(Short license) {
        this.license = license;
    }

    public short getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(short isdeleted) {
        this.isdeleted = isdeleted;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getFinishdate() {
        return finishdate;
    }

    public void setFinishdate(Date finishdate) {
        this.finishdate = finishdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tnved2 tnved2 = (Tnved2) o;
        return isdeleted == tnved2.isdeleted && Objects.equals(id, tnved2.id) && Objects.equals(name, tnved2.name) && Objects.equals(unit1, tnved2.unit1) && Objects.equals(unit2, tnved2.unit2) && Objects.equals(license, tnved2.license) && Objects.equals(startdate, tnved2.startdate) && Objects.equals(finishdate, tnved2.finishdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, unit1, unit2, license, isdeleted, startdate, finishdate);
    }
}
