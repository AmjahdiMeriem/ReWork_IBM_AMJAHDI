package ma.ibm.DAO;
import org.apache.commons.codec.binary.Hex;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class LoginCrypt {
//--------------------------------------------------------------------------------------------------------------------------//
	    public static String passHash(String userpassword) throws UnsupportedEncodingException {
	        String password = userpassword;
	        String salt = "1412";
	        int iterations = 1000;
	        int keyLength = 32;
	        char[] passwordChars = password.toCharArray();
	        byte[] saltBytes = salt.getBytes();
	        byte[] hashedBytes = hashContent(passwordChars, saltBytes, iterations, keyLength);
	        return Hex.encodeHexString(hashedBytes);
	    }
//--------------------------------------------------------------------------------------------------------------------------//	    
	    public static String loginHash(String username) throws UnsupportedEncodingException {
	        String login = username;
	        String salt = "1412";
	        int iterations = 1000;
	        int keyLength = 32;
	        char[] loginChars = login.toCharArray();
	        byte[] saltBytes = salt.getBytes();
	        byte[] hashedBytes = hashContent(loginChars, saltBytes, iterations, keyLength);
	        return Hex.encodeHexString(hashedBytes);
	    }
//--------------------------------------------------------------------------------------------------------------------------//
	    public static byte[] hashContent( final char[] password, final byte[] salt, final int iterations, final int keyLength ){
	        try {
	            SecretKeyFactory skf = SecretKeyFactory.getInstance( "PBKDF2WithHmacSHA512" );
	            PBEKeySpec spec = new PBEKeySpec( password, salt, iterations, keyLength );
	            SecretKey key = skf.generateSecret( spec );
	            return key.getEncoded( );
	        } catch ( NoSuchAlgorithmException | InvalidKeySpecException e ) {
	            throw new RuntimeException( e );}
	    }
//--------------------------------------------------------------------------------------------------------------------------//
}
