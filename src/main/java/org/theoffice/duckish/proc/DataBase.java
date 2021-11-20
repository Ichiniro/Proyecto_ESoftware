package org.theoffice.duckish.proc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import org.theoffice.duckish.obj.*;
import java.util.ArrayList;

public class DataBase {

    private static Connection connection;
    private static Statement statment;
    private static ResultSet result;
    private final String db;
    private final String user;
    private final String password;

    public DataBase(String db, String user, String password) {
        connection = null;
        statment = null;
        result = null;
        this.db = db;
        this.user = user;
        this.password = password;
    }

    public boolean connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306", user, password);
            return connection != null;
        } catch (Exception e) {
            return false;
        }
    }

    public void disconnect() {
        try {
            this.connection.close();
        } catch (Exception e) {
        }
    }

    public boolean creatDB() {
        try {
            statment = connection.createStatement();
            statment.execute("CREATE DATABASE DUCKISH;");
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean creatTables() {
        try {
            statment = connection.createStatement();
            statment.execute("CREATE TABLE EMPLOYEES("
                    + "EMPLOYEE_ID INT PRIMARY KEY auto_increment,"
                    + "FIRST_NAME VARCHAR(50) NOT NULL,"
                    + "LAST_NAME VARCHAR(50),"
                    + "USER_NAME VARCHAR(50) NOT NULL,"
                    + "JOB_TITTLE VARCHAR(50) NOT NULL,"
                    + "PASSWORD_USER VARCHAR(65) NOT NULL"
                    + ")");
            statment.execute("CREATE TABLE DISHES("
                    + "DISH_ID INT PRIMARY KEY auto_increment,"
                    + "DISH_NAME VARCHAR(75) NOT NULL,"
                    + "PRICE FLOAT NOT NULL"
                    + ")");
            statment.execute("CREATE TABLE COMMAND(\n"
                    + "COMMAND_ID INT PRIMARY KEY NOT NULL,\n"
                    + "DATE_COMMAND DATE,\n"
                    + "TOTAL FLOAT NOT NULL\n"
                    + ")");
            statment.execute("CREATE TABLE COMMAND_DETAILS(\n"
                    + "COMMAND_ID INT, FOREIGN KEY (COMMAND_ID) REFERENCES COMMAND(COMMAND_ID),\n"
                    + "QUANTITY INT NOT NULL,\n"
                    + "DISH_ID INT NOT NULL, FOREIGN KEY (DISH_ID) REFERENCES DISHES(DISH_ID),\n"
                    + "TABLE_NUM INT NOT NULL,\n"
                    + "EMPLOYEE_ID INT NOT NULL, FOREIGN KEY (EMPLOYEE_ID) REFERENCES EMPLOYEES(EMPLOYEE_ID)\n"
                    + ")");
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean addDish(Dish myDish) {
        try {
            statment = connection.createStatement();
            statment.execute("INSERT INTO DISHES (DISH_NAME,PRICE) VALUES ('"
                    + myDish.getName() + "','"
                    + myDish.getPrice() + "')");
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean addEmployee(Employee myEmployee) {
        try {
            statment = connection.createStatement();
            statment.execute("INSERT INTO EMPLOYEES (FIRST_NAME,LAST_NAME,USER_NAME,JOB_TITTLE,PASSWORD_USER) VALUES ('"
                    + myEmployee.getFirstName() + "'," + myEmployee.getLastName()
                    + ",'" + myEmployee.getUsername() + "'," + myEmployee.getJobTitle()
                    + ",'" + myEmployee.getPassword() + "')");
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean addCommand(Command myCommand) {
        try {
            statment = connection.createStatement();
            statment.execute("INSERT INTO COMMAND (COOMAND_ID,DATE_COMMAND,TOTAL)VALUES ('"
                    + myCommand.getOrderID() + "','"
                    + myCommand.getDateCommand() + "','"
                    + myCommand.getTotal() + "')");
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean addCommandDetails(CommandDetails myCommandDetails) {
        try {
            statment = connection.createStatement();
            statment.execute("INSERT INTO COMMAND_DETAILS(COMMAND_ID,QUANTITY,DISH_ID,TABLE_NUM,EMPLOYEE_ID) VALUES ('"
                    + myCommandDetails.getCommandID() + "','"
                    + myCommandDetails.getQuantity() + "','"
                    + myCommandDetails.getDishID() + "','"
                    + myCommandDetails.getTableNum() + "','"
                    + myCommandDetails.getEmployeeID() + "')");
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    public ArrayList getEmployees(){
        ArrayList Employees = new ArrayList();
        try {
            statment = connection.createStatement();
            result = statment.executeQuery("SELECT * FROM EMPLOYEES");
            while (result.next()) {
                Employee myEmployee = new Employee();
                myEmployee.setEmployeeID(result.getInt("EMPLOYEE_ID"));
                myEmployee.setFirstName(result.getString("FIRST_NAME"));
                myEmployee.setLastName(result.getString("LAST_NAME"));
                myEmployee.setUsername(result.getString("USER_NAME"));
                myEmployee.setJobTitle(result.getString("JOB_TITTLE"));
                Employees.add(myEmployee);
            }
        } catch (SQLException e) {
            return null;
        }
        return Employees;
    }
    
    public ArrayList getDishes(){
        ArrayList Dishes = new ArrayList();
        try {
            statment = connection.createStatement();
            result = statment.executeQuery("SELECT * FROM DISHES");
            while (result.next()) {
                Dish myDish = new Dish();
                myDish.setName(result.getString("DISH_NAME"));
                myDish.setPrice(result.getFloat("PRICE"));
                Dishes.add(myDish);
            }
        } catch (SQLException e) {
            return null;
        }
        return Dishes;
    }
    
    public ArrayList getCommands(){
        ArrayList Commands = new ArrayList();
        try {
            statment = connection.createStatement();
            result = statment.executeQuery("SELECT * FROM DISHES");
            while (result.next()) {
                Command myCommand = new Command();
                myCommand.setOrderID(result.getInt("COMMAND_ID"));
                myCommand.setDateCommand(result.getString("DISH_NAME"));
                myCommand.setTotal(result.getFloat("TOTAL"));
                Commands.add(myCommand);
            }
        } catch (SQLException e) {
            return null;
        }
        return Commands;
    }
    
    public ArrayList getCommandDetails(){
        ArrayList CommandsDetails = new ArrayList();
        try {
            statment = connection.createStatement();
            result = statment.executeQuery("SELECT * FROM COMMAND_DETAILS");
            while (result.next()) {                
                CommandDetails myCommandDetails = new CommandDetails();
                myCommandDetails.setCommandID(result.getInt("COMMAND_ID"));
                myCommandDetails.setQuantity(result.getInt("QUANTITY"));
                myCommandDetails.setDishID(result.getInt("DISH_ID"));
                myCommandDetails.setTableNum(result.getInt("TABLE_NUM"));
                myCommandDetails.setEmployeeID(result.getInt("EMPLOYEE_ID"));
            }
        } catch (SQLException e) {
            return null;
        }
        return CommandsDetails;
    }
}
