package uz.customs.customsprice.entity.InitialDecision;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;
import uz.customs.customsprice.controllers.api.helper.EnsureNumber;
import uz.customs.customsprice.entity.entityConfig.AbstractAuditingEntity;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Apps extends AbstractAuditingEntity {
    @Id
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(50)")
    private String id;

    @Column(name = "PERSON_ID", length = 50)
    private String personId;

    @Column(name = "APP_NUM", length = 50)
    private String appNum;

    @CreatedDate
    @Column(name = "APP_DATE", columnDefinition = " date default current_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date appDate = new Date(new Date().getTime());

    @Column(name = "CUSTOMER_COUNTRY", length = 3)
//    @EnsureNumber(decimal = true, message = "Устун фақат сонлардан иборат бўлиши лозим")
//    @Pattern(regexp = "^[0-1]+$", message = "Устун фақат сонлардан иборат бўлиши лозим!!!")
    @Size(min = 3, max = 3, message = "Устун 3 та сондан иборат бўлиши лозим")
    @Digits(message = "Устун фақат сонлардан иборат бўлиши лозим", integer = 3, fraction = 0)
    private String customerCountry;

    @Column(name = "CUSTOMER_COUNTRY_NM", columnDefinition = "VARCHAR(120) CCSID 1208")
    private String customerCountryNm;

    @Column(name = "SENDER_COUNTRY", length = 3)
//    @NotBlank(message =  "Устун тўлдирилмаган")
    @Size(min = 3, max = 3, message = "Устун хато тўлдирилган")
    @Digits(message = "Устун фақат сонлардан иборат бўлиши лозим", integer = 3, fraction = 0)
    private String senderCountry;

    @Column(name = "SENDER_COUNTRY_NM", columnDefinition = "VARCHAR(120) CCSID 1208")
    private String senderCountryNm;

    @Column(name = "SENDER_ORG", columnDefinition = "VARCHAR(900) CCSID 1208")
    @NotBlank(message =  "Устун тўлдирилмаган")
    @Size(max = 50, message = "Устун маълумоти катталиги чекланган")
    private String senderOrg;

    @Column(name = "SELLER_ORG", columnDefinition = "VARCHAR(900) CCSID 1208")
    @NotBlank(message =  "Устун тўлдирилмаган")
    private String sellerOrg;

    @Column(name = "TERMS", length = 3)
//    @NotBlank(message =  "Устун тўлдирилмаган")
    @Digits(message = "Устун фақат сонлардан иборат бўлиши лозим", integer = 2, fraction = 0)
    private String terms;

    @Column(name = "TERMS_NM", columnDefinition = "VARCHAR(450) CCSID 1208")
    private String termsNm;

    @Column(name = "TERMS_ADDR", length = 50)
    @NotBlank(message =  "Устун тўлдирилмаган")
    @Size(max = 50, message = "Устун маълумоти катталиги чекланган")
    private String termsAddr;

    @Column(name = "PERSON_FIO", columnDefinition = "VARCHAR(180) CCSID 1208")
    @NotBlank(message =  "Устун тўлдирилмаган")
    @Size(max = 50, message = "Устун маълумоти катталиги чекланган")
    private String personFio;

    @Column(name = "ORG_NAME", columnDefinition = "VARCHAR(900) CCSID 1208")
    @NotBlank(message =  "Устун тўлдирилмаган")
    @Size(max = 50, message = "Устун маълумоти катталиги чекланган")
    private String orgName;

    @Column(name = "PERSON_POSITION", length = 2)
    @NotBlank(message =  "Устун тўлдирилмаган")
    @Size(min = 2, max = 2, message = "Устун хато тўлдирилган")
    private String personPosition;

    @Column(name = "PERSON_ADDR", columnDefinition = "VARCHAR(900) CCSID 1208")
    @NotBlank(message =  "Устун тўлдирилмаган")
    @Size(max = 50, message = "Устун маълумоти катталиги чекланган")
    private String personAddr;

    @Column(name = "PERSON_TIN", length = 9)
    @NotBlank(message =  "Устун тўлдирилмаган")
    @Size(min = 9, max = 9, message = "Устун 9 та сондан иборат бўлиши лозим")
    private String personTin;

    @Column(name = "PERSON_PIN", length = 14)
    @NotBlank(message =  "Устун тўлдирилмаган")
    @Size(min = 14, max = 14, message = "Устун 14 та сондан иборат бўлиши лозим")
    private String personPin;

    @Column(name = "PERSON_MAIL", length = 100)
    @NotBlank(message =  "Устун тўлдирилмаган")
    @Email(message = "Устун хато тўлдирилган")
    @Size(max = 100, message = "Устун маълумоти катталиги чекланган")
    private String personMail;

    @Column(name = "PERSON_PHONE", length = 20)
    @NotBlank(message =  "Устун тўлдирилмаган")
    @Size(max = 20, message = "Устун маълумоти катталиги чекланган")
//    @ValidPhoneNumber(message="Телефон рақами устуни нотўғри тўлдирилган")
//    @EnsureNumber(decimal = true, message = "Телефон рақами устуни нотўғри тўлдирилган")
    private String personPhone;

    @Column(name = "LOCATION_ID", length = 4)
//    @NotBlank(message =  "Устун тўлдирилмаган")
    @Digits(message = "Устун фақат сонлардан иборат бўлиши лозим", integer = 4, fraction = 0)
    private String locationId;

    @Column(name = "LOCATION_NM", columnDefinition = "VARCHAR(180) CCSID 1208")
    private String locationNm;

    @Column(name = "TRANS_EXP", length = 4)
    @Digits(message = "Устун фақат ҳақиқий сонлардан иборат бўлиши лозим", integer = 15, fraction = 3)
    private BigDecimal transExp;

    @Column(name = "STATUS", columnDefinition = "SMALLINT DEFAULT 100")
    private int status = 100;

    @Column(name = "STATUS_NM", columnDefinition = "VARCHAR(450) CCSID 1208")
    private String statusNm;

    @Column(name = "COMMENT", columnDefinition = "VARCHAR(600) CCSID 1208")
    private String comment;

    public Apps() {
    }

    public Apps(String insUser, String updUser, Date insTime, Date updTime, int isDeleted, String id, String personId, String appNum, Date appDate, String customerCountry, String customerCountryNm, String senderCountry, String senderCountryNm, String senderOrg, String sellerOrg, String terms, String termsNm, String termsAddr, String personFio, String orgName, String personPosition, String personAddr, String personTin, String personPin, String personMail, String personPhone, String locationId, String locationNm, BigDecimal transExp, int status, String statusNm, String comment) {
        super(insUser, updUser, insTime, updTime, isDeleted);
        this.id = id;
        this.personId = personId;
        this.appNum = appNum;
        this.appDate = appDate;
        this.customerCountry = customerCountry;
        this.customerCountryNm = customerCountryNm;
        this.senderCountry = senderCountry;
        this.senderCountryNm = senderCountryNm;
        this.senderOrg = senderOrg;
        this.sellerOrg = sellerOrg;
        this.terms = terms;
        this.termsNm = termsNm;
        this.termsAddr = termsAddr;
        this.personFio = personFio;
        this.orgName = orgName;
        this.personPosition = personPosition;
        this.personAddr = personAddr;
        this.personTin = personTin;
        this.personPin = personPin;
        this.personMail = personMail;
        this.personPhone = personPhone;
        this.locationId = locationId;
        this.locationNm = locationNm;
        this.transExp = transExp;
        this.status = status;
        this.statusNm = statusNm;
        this.comment = comment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getAppNum() {
        return appNum;
    }

    public void setAppNum(String appNum) {
        this.appNum = appNum;
    }

    public Date getAppDate() {
        return appDate;
    }

    public void setAppDate(Date appDate) {
        this.appDate = appDate;
    }

    public String getCustomerCountry() {
        return customerCountry;
    }

    public void setCustomerCountry(String customerCountry) {
        this.customerCountry = customerCountry;
    }

    public String getCustomerCountryNm() {
        return customerCountryNm;
    }

    public void setCustomerCountryNm(String customerCountryNm) {
        this.customerCountryNm = customerCountryNm;
    }

    public String getSenderCountry() {
        return senderCountry;
    }

    public void setSenderCountry(String senderCountry) {
        this.senderCountry = senderCountry;
    }

    public String getSenderCountryNm() {
        return senderCountryNm;
    }

    public void setSenderCountryNm(String senderCountryNm) {
        this.senderCountryNm = senderCountryNm;
    }

    public String getSenderOrg() {
        return senderOrg;
    }

    public void setSenderOrg(String senderOrg) {
        this.senderOrg = senderOrg;
    }

    public String getSellerOrg() {
        return sellerOrg;
    }

    public void setSellerOrg(String sellerOrg) {
        this.sellerOrg = sellerOrg;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public String getTermsNm() {
        return termsNm;
    }

    public void setTermsNm(String termsNm) {
        this.termsNm = termsNm;
    }

    public String getTermsAddr() {
        return termsAddr;
    }

    public void setTermsAddr(String termsAddr) {
        this.termsAddr = termsAddr;
    }

    public String getPersonFio() {
        return personFio;
    }

    public void setPersonFio(String personFio) {
        this.personFio = personFio;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getPersonPosition() {
        return personPosition;
    }

    public void setPersonPosition(String personPosition) {
        this.personPosition = personPosition;
    }

    public String getPersonAddr() {
        return personAddr;
    }

    public void setPersonAddr(String personAddr) {
        this.personAddr = personAddr;
    }

    public String getPersonTin() {
        return personTin;
    }

    public void setPersonTin(String personTin) {
        this.personTin = personTin;
    }

    public String getPersonPin() {
        return personPin;
    }

    public void setPersonPin(String personPin) {
        this.personPin = personPin;
    }

    public String getPersonMail() {
        return personMail;
    }

    public void setPersonMail(String personMail) {
        this.personMail = personMail;
    }

    public String getPersonPhone() {
        return personPhone;
    }

    public void setPersonPhone(String personPhone) {
        this.personPhone = personPhone;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getLocationNm() {
        return locationNm;
    }

    public void setLocationNm(String locationNm) {
        this.locationNm = locationNm;
    }

    public BigDecimal getTransExp() {
        return transExp;
    }

    public void setTransExp(BigDecimal transExp) {
        this.transExp = transExp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusNm() {
        return statusNm;
    }

    public void setStatusNm(String statusNm) {
        this.statusNm = statusNm;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

