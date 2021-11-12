package org.theoffice.duckish.obj;

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
    private int employeeID;
    private int restaurantID;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean setUsername(String username) {
        //this.username = username;
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

    public boolean setPassword(char[] pass, char[] confirmPass) {
        // encrypt here?
        if (Arrays.equals(pass, confirmPass)) {
            this.password = String.valueOf(pass);

            String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$";
            Pattern p = Pattern.compile(regex);

            Matcher m = p.matcher(password);
            System.out.println("checkPW + " + m.matches());

            return m.matches();
        }
        return false;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public void setRestaurantID(int restaurantID) {
        this.restaurantID = restaurantID;
    }

    /*
     * Check if all the fields had been filled
    */
    public boolean isValid() throws IllegalAccessException {

        /* TODO: Test code, remove before pushing and uncomment the rest
        return true;*/

        // Check everything is filled
        for (Field f : getClass().getDeclaredFields()) {
            if (f.get(this).toString().isBlank()) {
                return false;
            }
        }

        return true;
    }

}
