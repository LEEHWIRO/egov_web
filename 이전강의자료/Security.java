package egov.lib.util;

import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;//POM.XML의해당하는 코드추가필요.


public class Security {

	private static Log logger = LogFactory.getLog(Security.class);

    //단방향 암호화
    public static String convertencodepw(String pi_userpw)
    {
	    BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder(10);
	    String rtnstr = bcryptPasswordEncoder.encode(pi_userpw);
    	return rtnstr;
    }

    //섞기
    public static String matchalgoritm(String pi_userpw)
    {
	    String prefixpw = pi_userpw.substring(0,2);
	    String afterpw = pi_userpw.substring(3,4);
	    String completepw = prefixpw+pi_userpw+afterpw;
    	return completepw;
    }

    //양방향 암호화
    /*
    public static String encryptAES256(String msg,String key) throws Exception {
    	String key2="71ec9bf956b98037"+key.substring(0,16);
    	byte[] key_Array = org.apache.commons.codec.binary.Base64.decodeBase64(key2);
        Cipher _Cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");        

        byte[] iv = { 1, 2, 3, 4, 5, 6, 6, 5, 4, 3, 2, 1, 7, 7, 7, 7 };
        IvParameterSpec ivspec = new IvParameterSpec(iv);

        Key SecretKey = new SecretKeySpec(key_Array, "AES");    
        _Cipher.init(Cipher.ENCRYPT_MODE, SecretKey, ivspec);       

        return org.apache.commons.codec.binary.Base64.encodeBase64String(_Cipher.doFinal(msg.getBytes()));
    }
    
    
    public static String decryptAES256(String msg,String key) throws Exception {
    	String key2="71ec9bf956b98037"+key.substring(0,16);
    	byte[] key_Array = org.apache.commons.codec.binary.Base64.decodeBase64(key2);
        Cipher _Cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");            

        byte[] iv = { 1, 2, 3, 4, 5, 6, 6, 5, 4, 3, 2, 1, 7, 7, 7, 7 };
        IvParameterSpec ivspec = new IvParameterSpec(iv);

        Key SecretKey = new SecretKeySpec(key_Array, "AES");
        _Cipher.init(Cipher.DECRYPT_MODE, SecretKey, ivspec);           

        byte DecodedMessage[] = org.apache.commons.codec.binary.Base64.decodeBase64(msg);
        return new String(_Cipher.doFinal(DecodedMessage));
    }


    public static String getEncrypt(String source, String salt) {
        return getEncrypt(source, salt.getBytes());
    }

    public static String getEncrypt(String source, byte[] salt) {
         
        String result = "";
         
        byte[] a = source.getBytes();
        byte[] bytes = new byte[a.length + salt.length];
         
        System.arraycopy(a, 0, bytes, 0, a.length);
        System.arraycopy(salt, 0, bytes, a.length, salt.length);
         
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(bytes);
             
            byte[] byteData = md.digest();
             
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xFF) + 256, 16).substring(1));
            }
             
            result = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
         
        return result;
    }

    public static String generateNum() {
        Random random = new Random();
         
        byte[] salt = new byte[8];
        random.nextBytes(salt);
         
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < salt.length; i++) {
            sb.append(String.format("%02x",salt[i]));
        }
        
        return sb.toString();
    }
    */
}
