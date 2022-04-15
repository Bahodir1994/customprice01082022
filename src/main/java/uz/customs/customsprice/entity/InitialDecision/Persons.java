package uz.customs.customsprice.entity.InitialDecision;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import uz.customs.customsprice.entity.entityConfig.AbstractAuditingEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
//@TypeDef(name = "jsonb", typeClass = JsonStringType.class)
@SQLDelete(sql = "update PERSONS set ISDELETED = 1 where id = ?")
@Where(clause = "isdeleted = 0")
public class Persons extends AbstractAuditingEntity {
    @Id
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(50)")
    private String id;

    @Column(name = "firstName", columnDefinition = "VARCHAR(180) CCSID 1208")
    @NotBlank(message =  "Исм майдони бўш бўлиши мумкин эмас")
    @Size(max = 60, message = "Устун маълумоти катталиги чекланган")
    private String firstName;

    @Column(name = "surName", columnDefinition = "VARCHAR(180) CCSID 1208")
    @NotBlank(message =  "Отасининг исми майдони бўш бўлиши мумкин эмас")
    @Size(max = 60, message = "Устун маълумоти катталиги чекланган")
    private String surName;

    @Column(name = "lastName", columnDefinition = "VARCHAR(180) CCSID 1208")
    @NotBlank(message =  "Фамилия бўш бўлиши мумкин эмас")
    @Size(max = 60, message = "Фамилия маълумоти катталиги чекланган")
    private String lastName;

    @Column(name = "email", length = 30)
    @NotBlank(message =  "Электрон почта майдони тўлдирилиши лозим")
    @Email(message = "Электрон почта хато киритилди")
    private String email;

    @Column(name = "pin", length = 14, unique = true)
    @NotBlank(message =  "Фойдаланувчи ЖШШИР рақами тўлдирилиши лозим")
    @Size(min = 14, max = 14, message = "Фойдаланувчи ЖШШИР рақами 14 белгидан иборат бўлиши керак")
//    @Digits(message = "Устун фақат 14 хонали сонлардан иборат бўлиши лозим", integer = 14, fraction = 0)
    private String pin;

    @Column(name = "tin", length = 9, unique = true)
    @NotBlank(message =  "Фойдаланувчи СТИР рақами тўлдирилиши лозим")
    @Size(min = 9, max = 9, message = "Фойдаланувчи СТИР рақами 9 белгидан иборат бўлиши керак")
//    @Digits(message = "Устун фақат 9 хонали сонлардан иборат бўлиши лозим", integer = 9, fraction = 0)
    private String tin;

    @Column(name = "per_adr", columnDefinition = "VARCHAR(765) CCSID 1208")
    @NotBlank(message =  "lastName - исми майдони бўш бўлиши мумкин эмас")
    @Size(max = 255, message = "Устун маълумоти катталиги чекланган")
    private String perAdr;

    @Column(name = "phone", length = 20)
    @NotBlank(message =  "Устун тўлдирилмаган")
    @Size(max = 20, message = "Устун маълумоти катталиги чекланган")
    private String phone;

    public Persons() {
    }

    public Persons(String insUser, String updUser, Date insTime, Date updTime, int isDeleted, String id, String firstName, String surName, String lastName, String eMail, String pin, String tin, String perAdr, String phone) {
        super(insUser, updUser, insTime, updTime, isDeleted);
        this.id = id;
        this.firstName = firstName;
        this.surName = surName;
        this.lastName = lastName;
        this.email = eMail;
        this.pin = pin;
        this.tin = tin;
        this.perAdr = perAdr;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public String getPerAdr() {
        return perAdr;
    }

    public void setPerAdr(String perAdr) {
        this.perAdr = perAdr;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}