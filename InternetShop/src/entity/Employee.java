package entity;

import javax.persistence.*;

/**
 * Created by Julia on 24.07.2017.
 */
@Entity
@Table(name = "INFORMATION ABOUT EMPLOYEE")
public class Employee {

    @Id
    @Column(name = "HUMAN_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long userNum;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "AGE")
    private String age;

    @Column(name = "DateBegin")
    private String dateBegin;

    @Column(name = "POSITION")
    private String position;

    @Column(name = "User_id")
    private User userId;

    @OneToOne
    private User user;

    public Employee (){}

    public Employee(String name, String surname, String age, String dateBegin, String position, User userId,User user) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.dateBegin = dateBegin;
        this.position = position;
        this.userId = userId;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getUserNum() {
        return userNum;
    }

    public void setUserNum(Long userNum) {
        this.userNum = userNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(String dateBegin) {
        this.dateBegin = dateBegin;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }
}
