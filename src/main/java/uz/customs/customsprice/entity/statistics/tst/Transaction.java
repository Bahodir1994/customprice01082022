package uz.customs.customsprice.entity.statistics.tst;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @Column(name = "DECL_ID", columnDefinition = "VARCHAR(50)")
    private String declId;

    @Column(name = "CMDT_ID", columnDefinition = "VARCHAR(50)")
    private String cmdtId;

    @Column(name = "G01A", length = 3)
    private String g01a;

    @Column(name = "G01B", length = 3)
    private String g01b;

    @Column(name = "G01C", columnDefinition = "VARCHAR(50) DEFAULT NULL ")
    private String g01c;

    @Column(name = "G07A", length = 10)
    private String g07a;

    @Column(name = "G07B")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date g07b;

    @Column(name = "G07C", length = 10)
    private String g07c;

    @Column(name = "S15_17", length = 4)
    private String s1517;

    @Column(name = "G15_17", length = 4)
    private String g1517;

    @Column(name = "G24A", length = 3)
    private String g24a;

    @Column(name = "G31B", columnDefinition = "VARCHAR(1000) DEFAULT NULL ")
    private String g31b;

    @Column(name = "G32", length = 3)
    private String g32;

    @Column(name = "G33A", columnDefinition = "VARCHAR(33) DEFAULT NULL " )
    private String g33a;

    @Column(name = "G34", length = 3)
    private String g34;

    @Column(name = "G41", length = 3)
    private String g41;

    @Column(name = "G38")
    private BigDecimal g38;

    @Column(name = "G42")
    private String g42;

    @Column(name = "G43")
    private String g43;

    @Column(name = "G46")
    private String g46;

    @Column(name = "G54D")
    private String g54d;

    @Column(name = "G22A")
    private String g22a;

    @Column(name = "G02A")
    private String g02a;

    @Column(name = "G13")
    private String g13;

    @Column(name = "G37")
    private String g37;

    @Column(name = "G37B")
    private String g37b;

    @Column(name = "G37C")
    private String g37c;

    @Column(name = "G25")
    private String g25;

    @Column(name = "G20")
    private String g20;

    @Column(name = "G23")
    private String g23;

    @Column(name = "G23_SCALE")
    private String g23Scale;

    @Column(name = "G11")
    private String g11;

    @Column(name = "G31_CODE")
    private String g31Code;

    @Column(name = "KB")
    private String kb;

    @Column(name = "G15")
    private String g15;

    @Column(name = "INN")
    private String inn;
}