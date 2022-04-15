package uz.customs.customsprice.entity.InitialDecision;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Location {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "NAME", columnDefinition = "VARCHAR(120) CCSID 1025")
    private String name;

    @Column(name = "IDN", columnDefinition = "VARCHAR(2) CCSID 1208")
    private String idn;

    @Column(name = "NAME1", columnDefinition = "VARCHAR(120) CCSID 1208")
    private String name1;

    @Column(name = "BRANCHID")
    private Integer branchId;

    @Column(name = "ADDRESS", columnDefinition = "VARCHAR(500) CCSID 1025")
    private String address;

    @Column(name = "PHONE", columnDefinition = "VARCHAR(30) CCSID 1208")
    private String phone;

    public Location() {
    }

    public Location(String id, String name, String idn, String name1, Integer branchId, String address, String phone) {
        this.id = id;
        this.name = name;
        this.idn = idn;
        this.name1 = name1;
        this.branchId = branchId;
        this.address = address;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdn() {
        return idn;
    }

    public void setIdn(String idn) {
        this.idn = idn;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
