package uz.customs.customsprice.entity.InitialDecision;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import uz.customs.customsprice.entity.entityConfig.AbstractAuditingEntity;

import javax.persistence.*;

@Entity
@Table(name = "IDAPPNUMBER", indexes = {@Index(columnList = "id", unique = true), @Index(columnList = "insuser", unique = false), @Index(columnList = "isdeleted", unique = false)})
//@TypeDef(name = "jsonb", typeClass = JsonStringType.class)
@SQLDelete(sql = "update IDAPPNUMBER set isdeleted = '1' where id = ?")
@Where(clause = "isdeleted = '0'")

public class IdNumber extends AbstractAuditingEntity {
    @Id
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(50)")
    private String id;

    @Column(name = "TYPE", columnDefinition = "VARCHAR(2)")
    private String type;

    @Column(name = "YEARS")
    private Integer years;

    @Column(name = "NUMBERS", columnDefinition = "VARCHAR(10)")
    private String numbers;

    @Column(name = "IDNUMBERS", columnDefinition = "VARCHAR(20)")
    private String idnumbers;

    public IdNumber() {
    }

    public IdNumber(String id, String type, Integer years, String numbers, String idnumbers) {
        this.id = id;
        this.type = type;
        this.years = years;
        this.numbers = numbers;
        this.idnumbers = idnumbers;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public String getIdnumbers() {
        return idnumbers;
    }

    public void setIdnumbers(String idnumbers) {
        this.idnumbers = idnumbers;
    }
}
