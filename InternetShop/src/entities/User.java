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
    @Column(name = "LOGIN")
    private StringBuffer userID;

    @Column(name = "PASSWORD")
    private MessageDigest password;

    @Column(name = "SALT_TO_PASS")
    private byte[] salt;

    @Column(name = "ROLE")
    private Role role;

    @OneToOne
    private Employee employee;

    public User(){}

    public User(StringBuffer userID, MessageDigest password, byte[] salt, Role role, Employee employee) {
        userID = new StringBuffer(25);
        this.password = password;
        this.salt = salt;
        this.role = role;
        this.employee= employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setUserID(StringBuffer userID) {
        this.userID = userID;
    }

    public void setPassword(MessageDigest password) {
        this.password = password;
    }

    public void setSalt(byte[] salt) {
        this.salt = salt;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public StringBuffer getUserID() {
        return userID;
    }

    public MessageDigest getPassword() {
        return password;
    }

    public byte[] getSalt() {
        return salt;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (getPassword() != null ? !getPassword().equals(user.getPassword()) : user.getPassword() != null)
            return false;
        return Arrays.equals(getSalt(), user.getSalt());
    }

    @Override
    public int hashCode() {
        int result = getPassword() != null ? getPassword().hashCode() : 0;
        result = 31 * result + Arrays.hashCode(getSalt());
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", password=" + password +
                ", salt=" + Arrays.toString(salt) +
                ", role=" + role +
                '}';
    }
}


