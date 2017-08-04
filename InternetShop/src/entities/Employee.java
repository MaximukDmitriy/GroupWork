package entities;

import javax.persistence.*;

/**
 * Created by Julia on 24.07.2017.
 */
@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    @Id
    @Column(name = "EMPLOYEEID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long employeeId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "AGE")
    private String age;

    @Column(name = "DATEBEGIN")
    private String dateBegin;

    @Column(name = "POSITION")
    private String position;

    @OneToOne
    private User user;

    public Employee (){}

    public Employee(String name, String surname, String age, String dateBegin, String position, User user) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.dateBegin = dateBegin;
        this.position = position;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long userNum) {
        this.employeeId = userNum;
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
}
