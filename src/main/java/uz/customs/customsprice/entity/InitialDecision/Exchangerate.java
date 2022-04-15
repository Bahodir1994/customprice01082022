package uz.customs.customsprice.entity.InitialDecision;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@IdClass(ExchangeratePK.class)
public class Exchangerate {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private String id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "DATE_SET")
    private Date dateSet;
    @Basic
    @Column(name = "AMOUNT")
    private Double amount;
    @Basic
    @Column(name = "RATE")
    private Double rate;
    @Basic
    @Column(name = "ISDELETED")
    private short isdeleted;

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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public short getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(short isdeleted) {
        this.isdeleted = isdeleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exchangerate that = (Exchangerate) o;
        return isdeleted == that.isdeleted && Objects.equals(id, that.id) && Objects.equals(dateSet, that.dateSet) && Objects.equals(amount, that.amount) && Objects.equals(rate, that.rate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateSet, amount, rate, isdeleted);
    }
}
