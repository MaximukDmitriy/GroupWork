package services;

import entities.Employee;
import entities.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class UserFunctions {

    public static List<User> getUsersByLogin(String login){
        return null;
    }

    public static Employee getAuthentificatedUser(String password, List<User> users) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] pass = md.digest(password.getBytes());
        if (users.isEmpty()){
            return null;
        }
        for (User user: users) {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< pass.length ;i++)
            {
                sb.append(pass[i]);
            }
            byte[] salt = md.digest(user.getSalt().getBytes());
            for(int i=0; i< salt.length ;i++)
            {
                sb.append(salt[i]);
            }
            if (sb.toString() == user.getPassword()){
                return user.getEmployee();
            }
        }
        return null;
    }


}
