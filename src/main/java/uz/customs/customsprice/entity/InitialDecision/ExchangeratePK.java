package uz.customs.customsprice.entity.InitialDecision;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class ExchangeratePK implements Serializable {
    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column(name = "DATE_SET")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Date dateSet;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDateSet() {
        return dateSet;
    }

    public void setDateSet(Date dateSet) {
        this.dateSet = dateSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExchangeratePK that = (ExchangeratePK) o;
        return Objects.equals(id, that.id) && Objects.equals(dateSet, that.dateSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateSet);
    }
}
