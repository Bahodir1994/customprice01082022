package uz.customs.customsprice.entity.InitialDecision;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import uz.customs.customsprice.entity.entityConfig.AbstractAuditingEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "METHOD_CAUSE")
public class MethodCause extends AbstractAuditingEntity {
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

    @Column(name = "method_number", length = 2)
    private String methodNumber;

    @Column(name = "method_description", columnDefinition = "VARCHAR(768) CCSID 1208")
    private String methodDescription;

    public MethodCause() {
    }

    public MethodCause(String insUser, String updUser, Date insTime, Date updTime, int isDeleted, String id, Commodity commodity, String methodNumber, String methodDescription) {
        super(insUser, updUser, insTime, updTime, isDeleted);
        this.id = id;
        this.commodity = commodity;
        this.methodNumber = methodNumber;
        this.methodDescription = methodDescription;
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

    public String getMethodNumber() {
        return methodNumber;
    }

    public void setMethodNumber(String methodNumber) {
        this.methodNumber = methodNumber;
    }

    public String getMethodDescription() {
        return methodDescription;
    }

    public void setMethodDescription(String methodDescription) {
        this.methodDescription = methodDescription;
    }
}
