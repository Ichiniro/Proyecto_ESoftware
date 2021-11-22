package org.theoffice.duckish.obj;

import org.theoffice.duckish.proc.DButilities;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Employee {

    private String firstName;
    private String lastName;
    private String username;
    private String jobTitle; // position?
    private String password;
    private int employeeID = 0;
    

    public void setFirstName(String firstName) {
        this.firstName = DButilities.normalizeText(firstName);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = DButilities.normalizeText(lastName);
    }

    public String getLastName() {
        return lastName;
    }

    public boolean setUsername(String username) {
        String regex = "^(?=.*[a-zA-Z])(?=\\S+$).{4,20}$";
        Pattern p = Pattern.compile(regex);

        Matcher m = p.matcher(username);
        System.out.println("setUN " + m.matches());
        if (m.matches()) {
            this.username = username;
        }

        return m.matches();
    }

    public String getUsername() {
        return username;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public boolean setPassword(char[] pass, char[] confirmPass) {
        if (Arrays.equals(pass, confirmPass)) {
            String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(String.valueOf(pass));
            if (m.matches()) {
                this.password = DButilities.encriptPWD(String.valueOf(pass));
            }
            return m.matches();
        }
        return false;
    }

    public void setPassword(String password) {
        this.password = password; //could be this funtion is a problem
    }

    public String getPassword() {
        return password;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    /*
     * Check if all the fields had been filled
     */
    public boolean isValid() throws IllegalAccessException {
        // Check everything is filled
        for (Field f : getClass().getDeclaredFields()) {
            if (f.get(this).toString().isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
