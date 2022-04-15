//package uz.customs.customsprice.entity.InitialDecision;
//
//import org.springframework.data.annotation.CreatedDate;
//import org.springframework.data.annotation.LastModifiedDate;
//
//import javax.persistence.*;
//import java.util.Date;
//
//@Entity
//@Table(name = "LOG")
//public class LogS {
//    @Id
//    @Column(name = "id", columnDefinition = "VARCHAR(50)")
//    private String id;
//
//    @Column(name = "USER_ID", length = 50)
//    private String userId;
//
//    @Column(name = "USER_NAME", columnDefinition = "VARCHAR(150) CCSID 1208")
//    private String userName;
//
//    @Column(name = "IP", length = 15)
//    private String ip;
//
//    @CreatedDate
//    @Column(name = "ENTER", columnDefinition = " timestamp default current_timestamp")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date enter = new Date(System.currentTimeMillis());
//
//    @LastModifiedDate
//    @Column(name = "LAST")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date last;
//
//    @LastModifiedDate
//    @Column(name = "EXIT")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date exit;
//
//    public LogS() {
//    }
//
//    public LogS(String id, String userId, String userName, String ip, Date enter, Date last, Date exit) {
//        this.id = id;
//        this.userId = userId;
//        this.userName = userName;
//        this.ip = ip;
//        this.enter = enter;
//        this.last = last;
//        this.exit = exit;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getUserId() {
//        return userId;
//    }
//
//    public void setUserId(String userId) {
//        this.userId = userId;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public String getIp() {
//        return ip;
//    }
//
//    public void setIp(String ip) {
//        this.ip = ip;
//    }
//
//    public Date getEnter() {
//        return enter;
//    }
//
//    public void setEnter(Date enter) {
//        this.enter = enter;
//    }
//
//    public Date getLast() {
//        return last;
//    }
//
//    public void setLast(Date last) {
//        this.last = last;
//    }
//
//    public Date getExit() {
//        return exit;
//    }
//
//    public void setExit(Date exit) {
//        this.exit = exit;
//    }
//}
