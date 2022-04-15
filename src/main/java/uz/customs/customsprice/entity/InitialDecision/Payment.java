package uz.customs.customsprice.entity.InitialDecision;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import uz.customs.customsprice.entity.entityConfig.AbstractAuditingEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
public class Payment extends AbstractAuditingEntity {
    @Id
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(50)")
    private String id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CMDT_ID", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Commodity commodity;

    @Column(name = "CMDT_ID", columnDefinition = "VARCHAR(50)")
    private String cmdtId;

    @Column(name = "G47BASE", precision = 19, scale = 3)
    private BigDecimal g47Base;

    @Column(name = "G47ALTBASE", precision = 19, scale = 3)
    private BigDecimal g47AltBase;

    @Column(name = "G47RATE", precision = 19, scale = 3)
    private BigDecimal g47Rate;

    @Column(name = "G47ALTRATE", precision = 19, scale = 3)
    private BigDecimal g47AltRate;

    @Column(name = "G47CURRKOD", columnDefinition = "VARCHAR(3)")
    private String g47Currkod;

    @Column(name = "G47SUM", precision = 19, scale = 3)
    private BigDecimal g47Sum;

    @Column(name = "G47SP", columnDefinition = "VARCHAR(4)")
    private String g47Sp;

    @Column(name = "G47CLCTYPE")
    private int g47ClcType;

    @Column(name = "G47TYPE", columnDefinition = "VARCHAR(4)")
    private String g47Type;

    @Column(name = "G47ALTBASECURRKOD", columnDefinition = "VARCHAR(3)")
    private String g47AltBaseCurrkod;

    @Column(name = "CURRRATE", precision = 10, scale = 2)
    private BigDecimal currRate;

    @Column(name = "G47ALTBASEEDIZM", columnDefinition = "VARCHAR(20)")
    private String g47AltBaseEdIzm;

    @Column(name = "G47SUMCURRKOD", columnDefinition = "VARCHAR(3)")
    private String g47SumCurrkod;

    public Payment() {
    }

    public Payment(String insUser, String updUser, Date insTime, Date updTime, int isDeleted, String id, Commodity commodity, String cmdtId, BigDecimal g47Base, BigDecimal g47AltBase, BigDecimal g47Rate, BigDecimal g47AltRate, String g47Currkod, BigDecimal g47Sum, String g47Sp, int g47ClcType, String g47Type, String g47AltBaseCurrkod, BigDecimal currRate, String g47AltBaseEdIzm, String g47SumCurrkod) {
        super(insUser, updUser, insTime, updTime, isDeleted);
        this.id = id;
        this.commodity = commodity;
        this.cmdtId = cmdtId;
        this.g47Base = g47Base;
        this.g47AltBase = g47AltBase;
        this.g47Rate = g47Rate;
        this.g47AltRate = g47AltRate;
        this.g47Currkod = g47Currkod;
        this.g47Sum = g47Sum;
        this.g47Sp = g47Sp;
        this.g47ClcType = g47ClcType;
        this.g47Type = g47Type;
        this.g47AltBaseCurrkod = g47AltBaseCurrkod;
        this.currRate = currRate;
        this.g47AltBaseEdIzm = g47AltBaseEdIzm;
        this.g47SumCurrkod = g47SumCurrkod;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public String getCmdtId() {
        return cmdtId;
    }

    public void setCmdtId(String cmdtId) {
        this.cmdtId = cmdtId;
    }

    public BigDecimal getG47Base() {
        return g47Base;
    }

    public void setG47Base(BigDecimal g47Base) {
        this.g47Base = g47Base;
    }

    public BigDecimal getG47AltBase() {
        return g47AltBase;
    }

    public void setG47AltBase(BigDecimal g47AltBase) {
        this.g47AltBase = g47AltBase;
    }

    public BigDecimal getG47Rate() {
        return g47Rate;
    }

    public void setG47Rate(BigDecimal g47Rate) {
        this.g47Rate = g47Rate;
    }

    public BigDecimal getG47AltRate() {
        return g47AltRate;
    }

    public void setG47AltRate(BigDecimal g47AltRate) {
        this.g47AltRate = g47AltRate;
    }

    public String getG47Currkod() {
        return g47Currkod;
    }

    public void setG47Currkod(String g47Currkod) {
        this.g47Currkod = g47Currkod;
    }

    public BigDecimal getG47Sum() {
        return g47Sum;
    }

    public void setG47Sum(BigDecimal g47Sum) {
        this.g47Sum = g47Sum;
    }

    public String getG47Sp() {
        return g47Sp;
    }

    public void setG47Sp(String g47Sp) {
        this.g47Sp = g47Sp;
    }

    public int getG47ClcType() {
        return g47ClcType;
    }

    public void setG47ClcType(int g47ClcType) {
        this.g47ClcType = g47ClcType;
    }

    public String getG47Type() {
        return g47Type;
    }

    public void setG47Type(String g47Type) {
        this.g47Type = g47Type;
    }

    public String getG47AltBaseCurrkod() {
        return g47AltBaseCurrkod;
    }

    public void setG47AltBaseCurrkod(String g47AltBaseCurrkod) {
        this.g47AltBaseCurrkod = g47AltBaseCurrkod;
    }

    public BigDecimal getCurrRate() {
        return currRate;
    }

    public void setCurrRate(BigDecimal currRate) {
        this.currRate = currRate;
    }

    public String getG47AltBaseEdIzm() {
        return g47AltBaseEdIzm;
    }

    public void setG47AltBaseEdIzm(String g47AltBaseEdIzm) {
        this.g47AltBaseEdIzm = g47AltBaseEdIzm;
    }

    public String getG47SumCurrkod() {
        return g47SumCurrkod;
    }

    public void setG47SumCurrkod(String g47SumCurrkod) {
        this.g47SumCurrkod = g47SumCurrkod;
    }
}
