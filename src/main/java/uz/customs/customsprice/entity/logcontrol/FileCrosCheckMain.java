package uz.customs.customsprice.entity.logcontrol;

import com.vladmihalcea.hibernate.type.json.JsonStringType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.Where;
import uz.customs.customsprice.entity.entityConfig.AbstractAuditingEntity;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "FILE_CROSCHECKMAIN")
public class FileCrosCheckMain extends AbstractAuditingEntity {
    @Id
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(50)")
    private String id;

    @Column(name = "FLK_ID", columnDefinition = "VARCHAR(150) CCSID 1208")
    private String flkId;


    @Column(name = "FLK_NUM", columnDefinition = "VARCHAR(150) CCSID 1208")
    private String flkNum;

    @Column(name = "HASH", columnDefinition = "VARCHAR(255)")
    private String hash;

    @Lob
    @Column(name = "DATA", columnDefinition="BLOB")
    private byte[] data;

    public FileCrosCheckMain() {
    }

    public FileCrosCheckMain(String insUser, String updUser, Date insTime, Date updTime, int isDeleted, String id, String flkId, String flkNum, String hash, byte[] data) {
        super(insUser, updUser, insTime, updTime, isDeleted);
        this.id = id;
        this.flkId = flkId;
        this.flkNum = flkNum;
        this.hash = hash;
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFlkId() {
        return flkId;
    }

    public void setFlkId(String flkId) {
        this.flkId = flkId;
    }

    public String getFlkNum() {
        return flkNum;
    }

    public void setFlkNum(String flkNum) {
        this.flkNum = flkNum;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
