package sbs.beans.common;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class bnUserParam implements Serializable {
    private String uUser_Id;
    private String uId;
    private String uName;
    private Timestamp uTstamp;
    private String uLogin;
    private String uPNumber;
    private int uRole;
    private String uRoleName;
    private String uLocation;
    private String uLocationName;
    private String uPost;
    private String uPostName;
    private String uDepartment;
    private String uDepartmentName;
    private ArrayList uActionType;
    private HashMap uActionTypem;
    private TreeMap uRoleSets;

    public TreeMap getURoleSets() {
        return uRoleSets;
    }

    public void setURoleSets(TreeMap uRoleSets) {
        this.uRoleSets = uRoleSets;
    }

    public String getUUser_Id() {
        return uUser_Id;
    }

    public void setUUser_Id(String uUser_Id) {
        this.uUser_Id = uUser_Id;
    }

    public String getUId() {
        return uId;
    }

    public void setUId(String uId) {
        this.uId = uId;
    }

    public String getUName() {
        return uName;
    }

    public void setUName(String uName) {
        this.uName = uName;
    }

    public Timestamp getUTstamp() {
        return uTstamp;
    }

    public void setUTstamp(Timestamp uTstamp) {
        this.uTstamp = uTstamp;
    }

    public String getULogin() {
        return uLogin;
    }

    public void setULogin(String uLogin) {
        this.uLogin = uLogin;
    }

    public String getUPNumber() {
        return uPNumber;
    }

    public void setUPNumber(String uPNumber) {
        this.uPNumber = uPNumber;
    }

    public int getURole() {
        return uRole;
    }

    public void setURole(int uRole) {
        this.uRole = uRole;
    }

    public String getURoleName() {
        return uRoleName;
    }

    public void setURoleName(String uRoleName) {
        this.uRoleName = uRoleName;
    }

    public String getULocation() {
        return uLocation;
    }

    public void setULocation(String uLocation) {
        this.uLocation = uLocation;
    }

    public String getULocationName() {
        return uLocationName;
    }

    public void setULocationName(String uLocationName) {
        this.uLocationName = uLocationName;
    }

    public String getUPost() {
        return uPost;
    }

    public void setUPost(String uPost) {
        this.uPost = uPost;
    }

    public String getUPostName() {
        return uPostName;
    }

    public void setUPostName(String uPostName) {
        this.uPostName = uPostName;
    }

    public String getUDepartment() {
        return uDepartment;
    }

    public void setUDepartment(String uDepartment) {
        this.uDepartment = uDepartment;
    }

    public String getUDepartmentName() {
        return uDepartmentName;
    }

    public void setUDepartmentName(String uDepartmentName) {
        this.uDepartmentName = uDepartmentName;
    }

    public ArrayList getUActionType() {
        return uActionType;
    }

    public void setUActionType(ArrayList uActionType) {
        this.uActionType = uActionType;
    }

    public HashMap getUActionTypem() {
        return uActionTypem;
    }

    public void setUActionTypem(HashMap uActionTypem) {
        this.uActionTypem = uActionTypem;
    }


    public void bnUserParam() {
    }
}
