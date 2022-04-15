package uz.customs.customsprice.entity.InitialDecision;

import javax.persistence.*;

@Entity
@Table(name = "ROLE")
public class Roles {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "isdeleted", columnDefinition = " SMALLINT DEFAULT 0")
    private int isDeleted;

    @Column(name = "ROLE_ID")
    private String roleId;

    @Column(name = "NAME")
    private String roleName;

    public Roles() {
    }

    public Roles(Integer id, int isDeleted, String roleId, String roleName) {
        this.id = id;
        this.isDeleted = isDeleted;
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
