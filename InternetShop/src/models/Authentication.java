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
    private byte[] password;

    public Authentication(String login, String password) throws NoSuchAlgorithmException {
        this.md = MessageDigest.getInstance("MD5");
        this.login = login;
        this.password = this.md.digest(password.getBytes());
    }

    public boolean Authenticate(){
        List<User> users = UserFunctions.getUsersByLogin(login);
        if (users.isEmpty()){
            return false;
        }
        for (User user: users) {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< password.length ;i++)
            {
                sb.append(password[i]);
            }
            byte[] salt = md.digest(user.getSalt().getBytes());
            for(int i=0; i< salt.length ;i++)
            {
                sb.append(salt[i]);
            }
            if (sb.toString() == user.getPassword()){
                employee = user.getEmployee();
                return true;
            }
        }
        return false;
    }
}
