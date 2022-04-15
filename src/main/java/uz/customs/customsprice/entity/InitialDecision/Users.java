package uz.customs.customsprice.entity.InitialDecision;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class Users {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "USERNAME")
    private String userName;

    @Column(name = "isdeleted", columnDefinition = " SMALLINT DEFAULT 0")
    private int isDeleted;

    @Column(name = "LOCATION")
    private String location;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "POST")
    private String post;

    @Column(name = "ROLE")
    private Integer role;

    @Column(name = "NAME")
    private String name;

    public Users() {
    }

    public Users(String id, String email, String password, String userName, int isDeleted, String location, String login, String post, Integer role, String name) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.userName = userName;
        this.isDeleted = isDeleted;
        this.location = location;
        this.login = login;
        this.post = post;
        this.role = role;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
