package org.theoffice.duckish.obj;

import javax.swing.*;
import java.lang.reflect.Field;

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
    public String getLastName() {
        return lastName;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public void setPassword(String password, String confirmPassword) {
        // encrypt here?
        if (password.length() >= 8) {
            if (password.equals(confirmPassword)) this.password = password;
            else JOptionPane.showMessageDialog(null, "Passwords are not the same");
        } else JOptionPane.showMessageDialog(null, "Password must be at least 8 character long");
    }
    private String getPassword() {
        return password;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
    public int getEmployeeID() {
        return employeeID;
    }

    public void setRestaurantID(int restaurantID) {
        this.restaurantID = restaurantID;
    }
    public int getRestaurantID() {
        return restaurantID;
    }

    /*
     * Check if all the fields had been filled
    */
    public boolean isValid() throws IllegalAccessException {
        for (Field f : getClass().getDeclaredFields()) {
            if (f.get(this).toString().isBlank()) {
                JOptionPane.showMessageDialog(null, "Please, fill all the fields");
                return false;
            }
        }
        return true;
    }
}
