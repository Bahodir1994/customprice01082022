package sbs.projects.beans;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

public class userParam
        implements Serializable {
    private String proUserLogin;
    private String proUserPassword;
    private String proPechatno;
    private String proUserFirstname;
    private String proUserSurname;
    private String proUserPatronymicname;
    private String proPostid;
    private String proPostName;
    private String proDepartment;
    private String proDepartmentid;
    private String proLocation;
    private String proLocationid;
    private int proUserRoleid;
    private String proUserRolename;
    private String userID;
    private ArrayList userRights;
    private String userRole;
    private ArrayList userActions;
    private Date DU;

    public Date getDU() {
        return this.DU;
    }

    public void setDU(Date DU) {
        this.DU = DU;
    }

    public ArrayList getUserRights() {
        return this.userRights;
    }

    public void setUserRights(ArrayList userRights) {
        this.userRights = userRights;
    }

    public String getUserID() {
        return this.userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getProUserFirstname() {
        return this.proUserFirstname;
    }

    public void setProUserFirstname(String proUserFirstname) {
        this.proUserFirstname = proUserFirstname;
    }

    public String getProUserSurname() {
        return this.proUserSurname;
    }

    public void setProUserSurname(String proUserSurname) {
        this.proUserSurname = proUserSurname;
    }

    public String getProUserPatronymicname() {
        return this.proUserPatronymicname;
    }

    public void setProUserPatronymicname(String proUserPatronymicname) {
        this.proUserPatronymicname = proUserPatronymicname;
    }

    public String getProDepartment() {
        return this.proDepartment;
    }

    public void setProDepartment(String proDepartment) {
        this.proDepartment = proDepartment;
    }

    public String getProLocation() {
        return this.proLocation;
    }

    public void setProLocation(String proLocation) {
        this.proLocation = proLocation;
    }

    public String getProPechatno() {
        return this.proPechatno;
    }

    public void setProPechatno(String proPechatno) {
        this.proPechatno = proPechatno;
    }

    public int getProUserRoleid() {
        return this.proUserRoleid;
    }

    public void setProUserRoleid(int proUserRoleid) {
        this.proUserRoleid = proUserRoleid;
    }

    public String getProUserRolename() {
        return this.proUserRolename;
    }

    public void setProUserRolename(String proUserRolename) {
        this.proUserRolename = proUserRolename;
    }

    public String getProPostid() {
        return this.proPostid;
    }

    public void setProPostid(String proPostid) {
        this.proPostid = proPostid;
    }

    public String getProUserLogin() {
        return this.proUserLogin;
    }

    public void setProUserLogin(String proUserLogin) {
        this.proUserLogin = proUserLogin;
    }

    public String getProUserPassword() {
        return this.proUserPassword;
    }

    public void setProUserPassword(String proUserPassword) {
        this.proUserPassword = proUserPassword;
    }

    public String getProLocationid() {
        return this.proLocationid;
    }

    public void setProLocationid(String proLocationid) {
        this.proLocationid = proLocationid;
    }

    public String getProDepartmentid() {
        return this.proDepartmentid;
    }

    public void setProDepartmentid(String proDepartmentid) {
        this.proDepartmentid = proDepartmentid;
    }

    public String getUserRole() {
        return this.userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public ArrayList getUserActions() {
        return this.userActions;
    }

    public void setUserActions(ArrayList userActions) {
        this.userActions = userActions;
    }

    public String getProPostName() {
        return this.proPostName;
    }

    public void setProPostName(String proPostName) {
        this.proPostName = proPostName;
    }
}