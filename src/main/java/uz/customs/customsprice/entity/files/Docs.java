package uz.customs.customsprice.entity.files;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import uz.customs.customsprice.entity.InitialDecision.Apps;
import uz.customs.customsprice.entity.entityConfig.AbstractAuditingEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "DOCS")
public class Docs extends AbstractAuditingEntity {
    @Id
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(50)")
    private String id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "APP_ID", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Apps apps;

    @Column(name = "HASH256", columnDefinition = "VARCHAR(255)")
    private String hash256;

    @Column(name = "APP_ID", columnDefinition = "VARCHAR(50)")
    private String appId;

    @Column(name = "doc_number")
    private String docNumber;

    @Column(name = "doc_date")
    private Date docDate;

    @Column(name = "doc_type", length = 3)
    private String docType;

    @Column(name = "doc_srno", length = 10)
    private String docSrNo;

    @Column(name = "doc_name", columnDefinition = "VARCHAR(150) CCSID 1208")
    private String docName;

    @Column(name = "doc_name_ex", length = 50)
    private String docNameEx;

    @Column(name = "doc_path", length = 100)
    private String docPath;

    @Column(name = "doc_format", length = 50)
    private String docFormat;

    @Column(name = "doc_size", length = 50)
    private String docSize;

    public Docs() {
    }

    public Docs(String insUser, String updUser, Date insTime, Date updTime, int isDeleted, String id, Apps apps, String hash256, String appId, String docNumber, Date docDate, String docType, String docSrNo, String docName, String docNameEx, String docPath, String docFormat, String docSize) {
        super(insUser, updUser, insTime, updTime, isDeleted);
        this.id = id;
        this.apps = apps;
        this.hash256 = hash256;
        this.appId = appId;
        this.docNumber = docNumber;
        this.docDate = docDate;
        this.docType = docType;
        this.docSrNo = docSrNo;
        this.docName = docName;
        this.docNameEx = docNameEx;
        this.docPath = docPath;
        this.docFormat = docFormat;
        this.docSize = docSize;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Apps getApps() {
        return apps;
    }

    public void setApps(Apps apps) {
        this.apps = apps;
    }

    public String getHash256() {
        return hash256;
    }

    public void setHash256(String hash256) {
        this.hash256 = hash256;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public Date getDocDate() {
        return docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getDocSrNo() {
        return docSrNo;
    }

    public void setDocSrNo(String docSrNo) {
        this.docSrNo = docSrNo;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDocNameEx() {
        return docNameEx;
    }

    public void setDocNameEx(String docNameEx) {
        this.docNameEx = docNameEx;
    }

    public String getDocPath() {
        return docPath;
    }

    public void setDocPath(String docPath) {
        this.docPath = docPath;
    }

    public String getDocFormat() {
        return docFormat;
    }

    public void setDocFormat(String docFormat) {
        this.docFormat = docFormat;
    }

    public String getDocSize() {
        return docSize;
    }

    public void setDocSize(String docSize) {
        this.docSize = docSize;
    }
}
