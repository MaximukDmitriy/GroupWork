import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

/**
 * Created by Julia on 24.07.2017.
 */
public class FirmaTest {

    public static void main(String[] args) throws NoSuchProviderException, NoSuchAlgorithmException {

        String passToHash = "qwerty";
        byte [] salt = getSalt();

        String securePassword = getSecurePassword(passToHash, salt);

        String regeneratedPassowrdToVerify = getSecurePassword(passToHash, salt);

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
            md.update(salt);
            //отримуємо hash байти
            byte[] bytes = md.digest(passwordToHash.getBytes());
            // вони в десятковому формтаі, перетворюємо до 16
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            // Отримуємо пароь в 16-му форматі
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

}
