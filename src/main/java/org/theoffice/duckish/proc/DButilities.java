package org.theoffice.duckish.proc;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.Normalizer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.theoffice.duckish.obj.CommandDetails;
import java.util.Random;
import org.theoffice.duckish.obj.Employee;

public class DButilities {

    /* This method encript a string using sha256 algorithm */
    public static String encriptPWD(String input) {

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

    /* We use this method to quit the special characters and chage everything
    to uppercase making more simple the mangement of the database */
    public static String normalizeText(String input) {
        String normalizedString = null;
        input = Normalizer.normalize(input, Normalizer.Form.NFD);
        input = input.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        normalizedString = input.toUpperCase();
        return normalizedString;
    }
    
    public static String commandDetailsIDgenerator(CommandDetails myCommandDetails){
        String id = null;
        // Generate random Number
        int random = (int)(Math.random()*(99999-10000+1)+10000);
        //Take date of the computer
         DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        //Random + Date + Table + EmployeeID
        id = Integer.toString(random) 
                + date.format(LocalDateTime.now()) 
                + myCommandDetails.getTableNum() 
                + myCommandDetails.getEmployeeID();
        return id;
    }
}
