package uz.customs.customsprice.entity.statistics.tst;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;
import uz.customs.customsprice.entity.entityConfig.AbstractAuditingEntity;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class ForeignTradeStatistics {

        @Id
        @GeneratedValue(generator = "uuid4")
        @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
        @Column(name = "id", columnDefinition = "VARCHAR(50)")
        private String id;

        private String cmdt_id;
        private String g01a;
        private String decl_id;
        private String g01b;
        private String g01c;
        private String g07a;
        private String g07b;
        private String g07c;
        private String s15_17;
        private String g15_17;
        private String g24a;
        private String g31b;
        private String g32;
        private String g33a;
        private String g34;
        private String g41;
        private String g38;
        private String g42;
        private String g43;
        private String g46;
        private String g54d;
        private String g22a;
        private String g02a;
        private String g13;
        private String g37;
        private String g37b;
        private String g37c;
        private String g25;
        private String g20;
        private String g23;
        private String g23scale;
        private String g11;
        private String g31code;
        private String kb;
        private String g15;
        private String inn;

    }
