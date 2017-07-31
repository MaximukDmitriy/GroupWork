package models;

import entities.Employee;
import entities.User;
import enums.Role;
import services.UserFunctions;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class Authentication {

    private Employee employee;

    public boolean IsAdmin(){
        return employee.getUser().getRole() == Role.ADMIN;
    }

    public boolean IsAuthenticate(){
        return employee != null;
    }

    public Authentication(String login, String password) throws NoSuchAlgorithmException {
        employee = UserFunctions.getAuthentificatedUser(login, password);
    }
}
