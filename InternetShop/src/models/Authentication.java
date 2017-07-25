package models;

import entities.Employee;
import entities.User;
import enums.Role;
import services.UserFunctions;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class Authentication {

    private final MessageDigest md;
    private Employee employee;

    public boolean IsAdmin(){
        return employee.getUser().getRole() == Role.ADMIN;
    }

    public boolean IsAuthenticate(){
        return employee != null;
    }

    private String login;

    public Authentication(String login, String password) throws NoSuchAlgorithmException {
        this.md = MessageDigest.getInstance("MD5");
        this.login = login;
        List<User> users = UserFunctions.getUsersByLogin(login);
        employee = UserFunctions.getAuthentificatedUser(password, users);
    }
}
