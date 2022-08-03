package uz.customs.customsprice.entity.files;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import uz.customs.customsprice.entity.InitialDecision.Apps;
import uz.customs.customsprice.entity.InitialDecision.StatusH;
import uz.customs.customsprice.entity.entityConfig.AbstractAuditingEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "DECISION_PDF_ROLLBACK")
public class DecisionPdfRollback extends AbstractAuditingEntity {
    @Id
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(50)")
    private String id;

    @Column(name = "HASH256", columnDefinition = "VARCHAR(255)")
    private String hash256;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "APP_ID", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Apps apps;

    @Column(name = "APP_ID", columnDefinition = "VARCHAR(50)")
    private String appId;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ST_ID", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private StatusH statusH;

    @Column(name = "ST_ID", columnDefinition = "VARCHAR(50)")
    private String stId;

    @Column(name = "pdf_name", columnDefinition = "VARCHAR(100)")
    private String pdfName;

    @Column(name = "pdf_path", length = 100)
    private String pdfPath;

    @Column(name = "pdf_format", length = 50)
    private String pdfFormat;

    @Column(name = "pdf_size", length = 50)
    private String pdfSize;

    public DecisionPdfRollback() {
    }

    public DecisionPdfRollback(String insUser, String updUser, Date insTime, Date updTime, int isDeleted, String id, String hash256, Apps apps, String appId, StatusH statusH, String stId, String pdfName, String pdfPath, String pdfFormat, String pdfSize) {
        super(insUser, updUser, insTime, updTime, isDeleted);
        this.id = id;
        this.hash256 = hash256;
        this.apps = apps;
        this.appId = appId;
        this.statusH = statusH;
        this.stId = stId;
        this.pdfName = pdfName;
        this.pdfPath = pdfPath;
        this.pdfFormat = pdfFormat;
        this.pdfSize = pdfSize;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHash256() {
        return hash256;
    }

    public void setHash256(String hash256) {
        this.hash256 = hash256;
    }

    public Apps getApps() {
        return apps;
    }

    public void setApps(Apps apps) {
        this.apps = apps;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public StatusH getStatusH() {
        return statusH;
    }

    public void setStatusH(StatusH statusH) {
        this.statusH = statusH;
    }

    public String getStId() {
        return stId;
    }

    public void setStId(String stId) {
        this.stId = stId;
    }

    public String getPdfName() {
        return pdfName;
    }

    public void setPdfName(String pdfName) {
        this.pdfName = pdfName;
    }

    public String getPdfPath() {
        return pdfPath;
    }

    public void setPdfPath(String pdfPath) {
        this.pdfPath = pdfPath;
    }

    public String getPdfFormat() {
        return pdfFormat;
    }

    public void setPdfFormat(String pdfFormat) {
        this.pdfFormat = pdfFormat;
    }

    public String getPdfSize() {
        return pdfSize;
    }

    public void setPdfSize(String pdfSize) {
        this.pdfSize = pdfSize;
    }
}
