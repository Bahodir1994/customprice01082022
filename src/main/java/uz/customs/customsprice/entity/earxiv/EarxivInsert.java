package uz.customs.customsprice.entity.earxiv;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "LOG")
public class EarxivInsert {
    @Id
    private String SESID;

    private String USERINN;

    private String NAME;

    private String IP;

    @CreatedDate
    @Column(name = "ENTER", columnDefinition = " timestamp default current_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ENTER = new Date(System.currentTimeMillis());

    @CreatedDate
    @Column(name = "LAST", columnDefinition = " timestamp default current_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date LAST = new Date(System.currentTimeMillis());

    @Column(name = "EXIT", columnDefinition = " timestamp default null")
    @Temporal(TemporalType.TIMESTAMP)
    private Date EXIT = null;

    private Integer TYPE;
    private String INN2;
    private String SERIALNUMBER;

    public EarxivInsert() {
    }

    public EarxivInsert(String SESID, String USERINN, String NAME, String IP, Date ENTER, Date LAST, Date EXIT, Integer TYPE, String INN2, String SERIALNUMBER) {
        this.SESID = SESID;
        this.USERINN = USERINN;
        this.NAME = NAME;
        this.IP = IP;
        this.ENTER = ENTER;
        this.LAST = LAST;
        this.EXIT = EXIT;
        this.TYPE = TYPE;
        this.INN2 = INN2;
        this.SERIALNUMBER = SERIALNUMBER;
    }

    public String getSESID() {
        return SESID;
    }

    public void setSESID(String SESID) {
        this.SESID = SESID;
    }

    public String getUSERINN() {
        return USERINN;
    }

    public void setUSERINN(String USERINN) {
        this.USERINN = USERINN;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public Date getENTER() {
        return ENTER;
    }

    public void setENTER(Date ENTER) {
        this.ENTER = ENTER;
    }

    public Date getLAST() {
        return LAST;
    }

    public void setLAST(Date LAST) {
        this.LAST = LAST;
    }

    public Date getEXIT() {
        return EXIT;
    }

    public void setEXIT(Date EXIT) {
        this.EXIT = EXIT;
    }

    public Integer getTYPE() {
        return TYPE;
    }

    public void setTYPE(Integer TYPE) {
        this.TYPE = TYPE;
    }

    public String getINN2() {
        return INN2;
    }

    public void setINN2(String INN2) {
        this.INN2 = INN2;
    }

    public String getSERIALNUMBER() {
        return SERIALNUMBER;
    }

    public void setSERIALNUMBER(String SERIALNUMBER) {
        this.SERIALNUMBER = SERIALNUMBER;
    }
}
