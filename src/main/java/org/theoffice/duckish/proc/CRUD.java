/*This class is used to Creat Read Update and Delete in a mysql database*/
package org.theoffice.duckish.proc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import org.theoffice.duckish.obj.*;
import java.util.ArrayList;
import org.theoffice.duckish.proc.DButilities;

public class CRUD {

    private static Connection connection;
    private static Statement statment;
    private static ResultSet result;
    private static final String url = "jdbc:mysql://localhost:3306/duckish";
    private final String user;
    private final String password;

    public CRUD(String user, String password) {
        connection = null;
        statment = null;
        result = null;
        this.user = user;
        this.password = password;
    }

    public boolean connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,user,password);
            System.out.println("Connection Successful");
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
            statment.executeQuery("CREATE DATABASE DUCKISH IF NOT EXISTS");
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean creatTables() {
        try {
            statment = connection.createStatement();
            statment.executeQuery("CREATE TABLE EMPLOYEES IF NOT EXISTS(\n"
                    + "EMPLOYEE_ID INT PRIMARY KEY auto_increment,\n"
                    + "FIRST_NAME VARCHAR(50) NOT NULL,\n"
                    + "LAST_NAME VARCHAR(50),\n"
                    + "USER_NAME VARCHAR(50) NOT NULL,\n"
                    + "JOB_TITTLE VARCHAR(50) NOT NULL,\n"
                    + "PASSWORD_USER VARCHAR(65) NOT NULL\n"
                    + ")");
            statment.executeQuery("CREATE TABLE DISHES IF NOT EXISTS(\n"
                    + "DISH_ID INT PRIMARY KEY auto_increment,\n"
                    + "DISH_NAME VARCHAR(75) NOT NULL,\n"
                    + "PRICE FLOAT NOT NULL\n"
                    + "DESCRIPTION TEXT NOT NULL\n"
                    + ")");
            statment.executeQuery("CREATE TABLE COMMAND IF NOT EXISTS(\n"
                    + "COMMAND_ID INT PRIMARY KEY NOT NULL,\n"
                    + "DATE_COMMAND DATE,\n"
                    + "TOTAL FLOAT NOT NULL\n"
                    + ")");
            statment.executeQuery("CREATE TABLE COMMAND_DETAILS IF NOT EXISTS(\n"
                    + "COMMAND_DETAILS_ID INT PRIMARY KEY auto_increment,\n"
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
            statment.executeQuery("INSERT INTO DISHES (DISH_NAME,PRICE) VALUES ('"
                    + myDish.getName() + "','"
                    + myDish.getDescription() + "','"
                    + myDish.getPrice() + "')");
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean addEmployee(Employee myEmployee) {
        try {
            statment = connection.createStatement();
            statment.executeQuery("INSERT INTO EMPLOYEES (FIRST_NAME,LAST_NAME,USER_NAME,JOB_TITTLE,PASSWORD_USER) VALUES ('"
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
            statment.executeQuery("INSERT INTO COMMAND (COOMAND_ID,DATE_COMMAND,TOTAL)VALUES ('"
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
            statment.executeQuery("INSERT INTO COMMAND_DETAILS(COMMAND_ID,QUANTITY,DISH_ID,TABLE_NUM,EMPLOYEE_ID) VALUES ('"
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

    public ArrayList getEmployees() {
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

    public ArrayList getDishes() {
        ArrayList Dishes = new ArrayList();
        try {
            statment = connection.createStatement();
            result = statment.executeQuery("SELECT * FROM DISHES");
            while (result.next()) {
                Dish myDish = new Dish();
                myDish.setDishID(result.getInt("DISH_ID"));
                myDish.setName(result.getString("DISH_NAME"));
                myDish.setPrice(result.getFloat("PRICE"));
                myDish.setDescription(result.getString("DESCRIPTION"));
                Dishes.add(myDish);
            }
        } catch (SQLException e) {
            return null;
        }
        return Dishes;
    }

    public ArrayList getCommands() {
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

    public ArrayList getCommandDetails() {
        ArrayList CommandsDetails = new ArrayList();
        try {
            statment = connection.createStatement();
            result = statment.executeQuery("SELECT * FROM COMMAND_DETAILS");
            while (result.next()) {
                CommandDetails myCommandDetails = new CommandDetails();
                myCommandDetails.setCommandID(result.getInt("COMMAND_DETAILS_ID"));
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

    public ArrayList searchEmployee(String search) {
        ArrayList Employees = new ArrayList();

        try {
            statment = connection.createStatement();
            result = statment.executeQuery("SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID LIKE "
                    + "'%" + search + "%' or FIRST_NAME LIKE "
                    + "'%" + search + "%' " + " or LAST_NAME LIKE "
                    + "'%" + search + "%' " + " or USER_NAME LIKE "
                    + "'%" + search + "%' " + " or JOB_TITLE LIKE "
                    + "'%" + search + "%' " + " or PASSWORD_USER LIKE "
                    + "'%" + search + "%' ");
            while (result.next()) {
                Employee myEmployee = new Employee();
                myEmployee.setEmployeeID(result.getInt("EMPLOYEE_ID"));
                myEmployee.setFirstName(result.getString("FIRST_NAME"));
                myEmployee.setLastName(result.getString("LAST_NAME"));
                myEmployee.setUsername(result.getString("USER_NAME"));
                myEmployee.setJobTitle(result.getString("JOB_TITTLE"));
                myEmployee.setPassword(result.getString("PASSWORD_USER"));//could be this is a problem
                Employees.add(myEmployee);
            }

        } catch (SQLException e) {
            return null;
        }

        return Employees;
    }

    public ArrayList searchDish(String search) {
        ArrayList Dishes = new ArrayList();

        try {
            statment = connection.createStatement();
            result = statment.executeQuery("SELECT * FROM DISH WHERE DISH_ID LIKE "
                    + "'%" + search + "%' or DISH_NAME "
                    + "'%" + search + "%' or PRICE LIKE "
                    + "'%" + search + "%' or DESCRIPTION LIKE "
                    + "'%" + search + "%' ");
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

    public ArrayList searchCommand(String search) {
        ArrayList Commands = new ArrayList();

        try {
            statment = connection.createStatement();
            result = statment.executeQuery("SELECT * FROM COMMAND WHERE ORDER_ID LIKE "
                    + "'%" + search + "%' or DATE_COMMAND LIKE "
                    + "'%" + search + "%' " + " or TOTAL LIKE " + "'%"
                    + search + "%'");
            while (result.next()) {
                Command myCommand = new Command();
                myCommand.setOrderID(result.getInt("ORDER_ID"));
                myCommand.setDateCommand(result.getString("DATE_COMMAND"));
                myCommand.setTotal(result.getFloat("TOTAL"));
                Commands.add(myCommand);
            }

        } catch (SQLException e) {
            return null;
        }

        return Commands;
    }

    public ArrayList searchCommandDetails(String search) {
        ArrayList CommandsDetails = new ArrayList();

        try {
            statment = connection.createStatement();
            result = statment.executeQuery("SELECT * FROM COMMAND_DETAILS WHERE COMMAND_DETAILS_ID LIKE "
                    + "'%" + search + "%' or COMMAND_ID "
                    + "'%" + search + "%' or QUANTITY LIKE "
                    + "'%" + search + "%' or DISH_ID LIKE "
                    + "'%" + search + "%' or TABLE_NUM LIKE "
                    + "'%" + search + "%' or EMPLOYEE_ID LIKE "
                    + "'%" + search + "%' ");
            while (result.next()) {
                CommandDetails myCommandDetails = new CommandDetails();
                myCommandDetails.setCommandID(result.getInt("COMMAND_ID"));
                myCommandDetails.setQuantity(result.getInt("QUANTITY"));
                myCommandDetails.setDishID(result.getInt("DISH_ID"));
                myCommandDetails.setTableNum(result.getInt("TABLE_NUM"));
                myCommandDetails.setEmployeeID(result.getInt("EMPLOYEE_ID"));
                CommandsDetails.add(myCommandDetails);
            }

        } catch (SQLException e) {
            return null;
        }

        return CommandsDetails;
    }

    public void deleteEmployee(int id) {
        try {
            statment = connection.createStatement();
            statment.executeQuery("DELETE FROM EMPLOYEE WHERE EMPLOYEE_ID = " + id);
        } catch (SQLException e) {
        }
    }

    public void deleteDish(int id) {
        try {
            statment = connection.createStatement();
            statment.executeQuery("DELETE FROM DISHES WHERE DISH_ID = " + id);
        } catch (SQLException e) {
        }
    }

    public void deleteCommand(int id) {
        try {
            statment = connection.createStatement();
            statment.executeQuery("DELETE FROM COMMAND WHERE COMMAND_ID = " + id);
        } catch (SQLException e) {
        }
    }

    public void deleteCommandDetails(int id) {
        try {
            statment = connection.createStatement();
            statment.executeQuery("DELETE FROM COMMAND_DETAILS WHERE COMMAND_DETAILS_ID = " + id);
        } catch (SQLException e) {
        }
    }

    public boolean updateEmployee(Employee myEmployee) {
        try {
            statment = connection.createStatement();
            statment.executeQuery("UPDATE EMPLOYEE SET FIRST_NAME = '" + myEmployee.getFirstName() + "',"
                    + "LAST_NAME = '" + myEmployee.getLastName() + "',"
                    + "USER_NAME = '" + myEmployee.getUsername() + "',"
                    + "JOB_TITLE = '" + myEmployee.getJobTitle() + "',"
                    + "PASSWORD = '" + myEmployee.getPassword() + "'"
                    + "WHERE EMPLOYEE_ID = " + myEmployee.getEmployeeID());
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    public boolean updateDishes(Dish myDish) {
        try {
            statment = connection.createStatement();
            statment.executeQuery("UPDATE DISH SET DISH_NAME = '" + myDish.getName()+ "',"
                    + "PRICE = '" + myDish.getPrice() + "'"
                    + "DESCRIPTION = '" +myDish.getDescription() + "'"
                    + "WHERE DISH_ID = " + myDish.getDishID());
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    public boolean updateCommand(Command myCommand) {
        try {
            statment = connection.createStatement();
            statment.executeQuery("UPDATE EMPLOYEE SET DATE_COMMAND = '" + myCommand.getDateCommand()+ "',"
                    + "TOTAL = '" + myCommand.getTotal()+ "'"
                    + "WHERE COMMAND_ID = " + myCommand.getOrderID());
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    public boolean updateCommandDetails(CommandDetails myCommandDetails) {
        try {
            statment = connection.createStatement();
            statment.executeQuery("UPDATE COMMAND_DETAILS SET COMMAND_ID = '" + myCommandDetails.getCommandID()+ "',"
                    + "QUANTITY = '" + myCommandDetails.getQuantity()+ "',"
                    + "DISH_ID = '" + myCommandDetails.getDishID()+ "',"
                    + "TABLE_NUM = '" + myCommandDetails.getTableNum()+ "',"
                    + "EMPLOYEE_ID = '" + myCommandDetails.getEmployeeID()+ "'"
                    + "WHERE COMMAND_DETAILS_ID = " + myCommandDetails.getCommandDetailsID());
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}
