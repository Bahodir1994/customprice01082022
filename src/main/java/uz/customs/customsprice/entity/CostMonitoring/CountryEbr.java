package uz.customs.customsprice.entity.CostMonitoring;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class CountryEbr {
    private String id;
    private Integer continent;
    private String name;
    private String smallName;
    private short isdeleted;
    private String code;

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
    @Column(name = "CONTINENT")
    public Integer getContinent() {
        return continent;
    }

    public void setContinent(Integer continent) {
        this.continent = continent;
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
    @Column(name = "SMALL_NAME")
    public String getSmallName() {
        return smallName;
    }

    public void setSmallName(String smallName) {
        this.smallName = smallName;
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
    @Column(name = "CODE")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryEbr country = (CountryEbr) o;
        return isdeleted == country.isdeleted && Objects.equals(id, country.id) && Objects.equals(continent, country.continent) && Objects.equals(name, country.name) && Objects.equals(smallName, country.smallName) && Objects.equals(code, country.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, continent, name, smallName, isdeleted, code);
    }
}
