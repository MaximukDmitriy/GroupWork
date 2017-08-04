import entities.User;
import enums.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.sql.ordering.antlr.Factory;
import utilities.HibernateUtil;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

/**
 * Created by Julia on 24.07.2017.
 */
public class FirmaTest {

    public static void main(String[] args) throws NoSuchProviderException, NoSuchAlgorithmException {

        String passToHash = "admin";
        byte [] salt = getSalt();

        String securePassword = getSecurePassword(passToHash, salt);

        //String regeneratedPassowrdToVerify = getSecurePassword(passToHash, salt);

        SessionFactory factory = HibernateUtil.getFactory();
        Session session = factory.openSession();
        User user = new User();
        user.setLogin("ADMIN");
        user.setPassword(securePassword);
        user.setRole(Role.ADMIN);
        user.setSalt(salt.toString());
        session.save(user);
        session.getTransaction().commit();
        session.close();

    }

    public static byte[] getSalt() throws NoSuchProviderException, NoSuchAlgorithmException {
        // SecureRandom генератор
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");
        //масив для солі
        byte[] salt = new byte[16];
        //отримуємо сіль
        sr.nextBytes(salt);

        return salt;

    }
    private static String getSecurePassword(String passwordToHash, byte[] salt)
    {

        String generatedPassword = null;
        try {
            // Створюємо MessageDigest для MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            // додаємо пароль до digest
            byte[] cryptedSalt = md.digest(salt);
            //отримуємо hash байти
            StringBuilder sb = new StringBuilder();
            sb.append(passwordToHash);
            sb.append(cryptedSalt);

            byte[] bytes = md.digest(sb.toString().getBytes());
            sb = new StringBuilder();
            sb.append(md.digest(bytes));
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

}
