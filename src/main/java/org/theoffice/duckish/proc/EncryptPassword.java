package org.theoffice.duckish.proc;
import java.math.BigInteger;
import java.security.MessageDigest;

public class EncryptPassword {
    public static String getSHA256(String input){

	String encryptedString = null;
	try {
	    MessageDigest digest = MessageDigest.getInstance("SHA-256");
	    digest.reset();
	    digest.update(input.getBytes("utf8"));
	    encryptedString = String.format("%064x", new BigInteger(1, digest.digest()));
	} catch (Exception e) {
	    e.printStackTrace();
	}
	
	return encryptedString;
    }
}