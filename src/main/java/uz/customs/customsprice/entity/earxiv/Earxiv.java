package uz.customs.customsprice.entity.earxiv;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import org.hibernate.annotations.*;
import uz.customs.customsprice.entity.InitialDecision.Apps;
import uz.customs.customsprice.entity.entityConfig.AbstractAuditingEntity;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "EARXIV", indexes = {@Index(columnList = "id", unique = true), @Index(columnList = "insuser", unique = false), @Index(columnList = "isdeleted", unique = false)})
@TypeDef(name = "jsonb", typeClass = JsonStringType.class)
@SQLDelete(sql = "update EARXIV set isdeleted = 1 where id = ?")
@Where(clause = "isdeleted = '0'")
public class Earxiv extends AbstractAuditingEntity {
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

    @Column(name = "APP_ID", length = 50)
    private String appId;

    @Column(name = "FOLDER_ID")
    @Size(max = 15, message = "1")
    @NotBlank(message = "2")
    private String folderId;

    @Column(name = "NAME", columnDefinition = "VARCHAR(200) CCSID 1208")
    @Size(max = 100, message = "1")
    @NotBlank(message = "2")
    private String name;

    @Column(name = "USER_INN")
    @Size(max = 15, message = "1")
    @NotBlank(message = "2")
    private String userInn;

    @Column(name = "USER_PNFL")
    @Size(max = 20, message = "1")
    @NotBlank(message = "2")
    private String userPnfl;

    @Column(name = "DOCNAME", columnDefinition = "VARCHAR(200) CCSID 1208")
    @Size(max = 100, message = "1")
    @NotBlank(message = "2")
    private String docname;

    @Column(name = "DOC_TYPE")
    @Size(max = 10, message = "1")
    @NotBlank(message = "2")
    private String docType;

    @Column(name = "FILE_ID")
    @Size(max = 20, message = "1")
    @NotBlank(message = "2")
    private String fileId;

    @Column(name = "STATUS")
    @Size(max = 2, message = "1")
    @NotBlank(message = "2")
    private String status;

    @Column(name = "DOC_TYPE_NAME", columnDefinition = "VARCHAR(200) CCSID 1208")
    @Size(max = 100, message = "1")
    @NotBlank(message = "2")
    private String docTypeName;

    @Column(name = "SET_FOLDER_ID")
    @Size(max = 20, message = "1")
    @NotBlank(message = "2")
    private String setFolderId;

    @Column(name = "PART_NO", columnDefinition = "SMALLINT DEFAULT 1")
    private String partyNo;

    @Column(name = "DOC_ID", length = 50)
    private String docId;

    public Earxiv() {
    }

    public Earxiv(String id, Apps apps, String appId, String folderId, String name, String userInn, String userPnfl, String docname, String docType, String fileId, String status, String docTypeName, String setFolderId, String partyNo, String docId) {
        this.id = id;
        this.apps = apps;
        this.appId = appId;
        this.folderId = folderId;
        this.name = name;
        this.userInn = userInn;
        this.userPnfl = userPnfl;
        this.docname = docname;
        this.docType = docType;
        this.fileId = fileId;
        this.status = status;
        this.docTypeName = docTypeName;
        this.setFolderId = setFolderId;
        this.partyNo = partyNo;
        this.docId = docId;
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

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getFolderId() {
        return folderId;
    }

    public void setFolderId(String folderId) {
        this.folderId = folderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserInn() {
        return userInn;
    }

    public void setUserInn(String userInn) {
        this.userInn = userInn;
    }

    public String getUserPnfl() {
        return userPnfl;
    }

    public void setUserPnfl(String userPnfl) {
        this.userPnfl = userPnfl;
    }

    public String getDocname() {
        return docname;
    }

    public void setDocname(String docname) {
        this.docname = docname;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDocTypeName() {
        return docTypeName;
    }

    public void setDocTypeName(String docTypeName) {
        this.docTypeName = docTypeName;
    }

    public String getSetFolderId() {
        return setFolderId;
    }

    public void setSetFolderId(String setFolderId) {
        this.setFolderId = setFolderId;
    }

    public String getPartyNo() {
        return partyNo;
    }

    public void setPartyNo(String partyNo) {
        this.partyNo = partyNo;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }
}