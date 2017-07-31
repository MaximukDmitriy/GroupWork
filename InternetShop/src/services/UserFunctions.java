package services;

import dao.DAO;
import dao.MySqlDAO;
import dao.Parameters;
import entities.Employee;
import entities.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class UserFunctions {

    private static DAO dao;

    public UserFunctions() {
        dao = new MySqlDAO<User>();
    }

    private static User getUsersByLogin(String login){
        Parameters params = new Parameters();
        params.addParam("LOGIN", login);
        List<User> values = dao.readByQuery("from USERS where LOGIN = :LOGIN", params);
        if (values.isEmpty()){
            return null;
        }
        return values.get(0);
    }

    public static Employee getAuthentificatedUser(String password, String userNsme) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] pass = md.digest(password.getBytes());
        User user = getUsersByLogin(userNsme);
        if (user == null){
            return null;
        }
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
        return null;
    }


}
