package uz.customs.customsprice.entity.InternationalSurveyEntity;

import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.Where;
import uz.customs.customsprice.entity.entityConfig.AbstractAuditingEntity;

import javax.persistence.*;

@Entity
@Table(name = "DIRECTION_TYPE", indexes = {@Index(columnList = "id", unique = true), @Index(columnList = "insuser", unique = false), @Index(columnList = "isdeleted", unique = false)})
@TypeDef(name = "jsonb", typeClass = JsonStringType.class)
@SQLDelete(sql = "update DIRECTIONTYPE set isdeleted = 1 where id = ?")
@Where(clause = "isdeleted = 0")
@AllArgsConstructor
@Getter
@Setter
public class DirectionType extends AbstractAuditingEntity {
    @Id
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id",  columnDefinition = "VARCHAR(50)")
    private String id;

    @Column(name = "CODE",  length = 50)
    private String code;

    @Column(name = "Name",  length = 50)
    private String name;

    public DirectionType() {
    }
}
