package uz.customs.customsprice.entity.files;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import uz.customs.customsprice.entity.InitialDecision.Apps;
import uz.customs.customsprice.entity.InitialDecision.Commodity;
import uz.customs.customsprice.entity.InitialDecision.InDec;
import uz.customs.customsprice.entity.entityConfig.AbstractAuditingEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "DECISION_PDF")
public class DecisionPdf extends AbstractAuditingEntity {
    @Id
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(50)")
    private String id;

    @Column(name = "HASH256", columnDefinition = "VARCHAR(255)")
    private String hash256;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CMDT_ID", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Commodity commodity;

    @Column(name = "CMDT_ID", columnDefinition = "VARCHAR(50)")
    private String cmdtId;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IN_DEC_ID", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private InDec inDec;

    @Column(name = "IN_DEC_ID", columnDefinition = "VARCHAR(50)")
    private String inDecId;

    @Column(name = "pdf_name", columnDefinition = "VARCHAR(100)")
    private String pdfName;

    @Column(name = "pdf_path", length = 100)
    private String pdfPath;

    @Column(name = "pdf_format", length = 50)
    private String pdfFormat;

    @Column(name = "pdf_size", length = 50)
    private String pdfSize;

    public DecisionPdf() {
    }

    public DecisionPdf(String insUser, String updUser, Date insTime, Date updTime, int isDeleted, String id, String hash256, Commodity commodity, String cmdtId, InDec inDec, String inDecId, String pdfName, String pdfPath, String pdfFormat, String pdfSize) {
        super(insUser, updUser, insTime, updTime, isDeleted);
        this.id = id;
        this.hash256 = hash256;
        this.commodity = commodity;
        this.cmdtId = cmdtId;
        this.inDec = inDec;
        this.inDecId = inDecId;
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

    public InDec getInDec() {
        return inDec;
    }

    public void setInDec(InDec inDec) {
        this.inDec = inDec;
    }

    public String getInDecId() {
        return inDecId;
    }

    public void setInDecId(String inDecId) {
        this.inDecId = inDecId;
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
