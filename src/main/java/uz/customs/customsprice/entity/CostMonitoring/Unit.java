package uz.customs.customsprice.entity.CostMonitoring;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Unit {
    private String id;
    private String name;
    private String shortname;
    private short isdeleted;
    private Short flag;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "SHORTNAME")
    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    @Basic
    @Column(name = "ISDELETED")
    public short getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(short isdeleted) {
        this.isdeleted = isdeleted;
    }

    @Basic
    @Column(name = "FLAG")
    public Short getFlag() {
        return flag;
    }

    public void setFlag(Short flag) {
        this.flag = flag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Unit unit = (Unit) o;
        return isdeleted == unit.isdeleted && Objects.equals(id, unit.id) && Objects.equals(name, unit.name) && Objects.equals(shortname, unit.shortname) && Objects.equals(flag, unit.flag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, shortname, isdeleted, flag);
    }
}
