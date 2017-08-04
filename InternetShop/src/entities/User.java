package entities;

import enums.Role;

import javax.persistence.*;
import java.security.MessageDigest;
import java.util.Arrays;

/**
 * Created by Julia on 24.07.2017.
 */
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @Column(name = "USERID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userID;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "SALT")
    private String salt;

    @Column(name = "ROLE")
    private Role role;

    @OneToOne
    private Employee employee;

    public User(){}

    public User(String login, String password, String salt, Role role, Employee employee) {
        this.login = login;
        this.password = password;
        this.salt = salt;
        this.role = role;
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public String getSalt() {
        return salt;
    }

    public Role getRole() {
        return role;
    }
}


