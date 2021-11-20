/*
We use this class to quit the special characters and chage everything
to uppercase making more simple the mangement of the database
*/
package org.theoffice.duckish.proc;
import java.text.Normalizer;
public class NormalizeText {
    public static String NormalizeText(String input){
        String normalizedString = null;
        input = Normalizer.normalize(input, Normalizer.Form.NFD);
        input = input.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        normalizedString = input.toUpperCase();
        return normalizedString;
    }
}
