package uz.customs.customsprice.entity.InitialDecision;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import uz.customs.customsprice.entity.entityConfig.AbstractAuditingEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ROLLBACK_SP")
public class RollbackSp extends AbstractAuditingEntity {
    @Id
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(50)")
    private String id;

    @Column(name = "NAME", columnDefinition = "VARCHAR(300) CCSID 1208")
    private String rollbackName;

    public RollbackSp() {
    }

    public RollbackSp(String insUser, String updUser, Date insTime, Date updTime, int isDeleted, String id, String rollbackName) {
        super(insUser, updUser, insTime, updTime, isDeleted);
        this.id = id;
        this.rollbackName = rollbackName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRollbackName() {
        return rollbackName;
    }

    public void setRollbackName(String rollbackName) {
        this.rollbackName = rollbackName;
    }
}
