/*This class is used to Creat Read Update and Delete in a mysql database*/
package org.theoffice.duckish.proc;

import java.sql.*;
import org.theoffice.duckish.obj.*;
import java.util.ArrayList;

public class CRUD {

    private static Connection connection;
    private static Statement statment;
    private static ResultSet result;
    private static final String url = "jdbc:mariadb://localhost:3306";
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
            Class.forName("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
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
            statment.executeUpdate("CREATE DATABASE IF NOT EXISTS DUCKISH");
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean useDataBase() {
        try {
            statment = connection.createStatement();
            statment.executeQuery("use DUCKISH");
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean creatTables() {
        try {
            statment = connection.createStatement();
            statment.executeUpdate("create table if not exists EMPLOYEES("
                    + "EMPLOYEE_ID int auto_increment,"
                    + "FIRST_NAME varchar(50),"
                    + "LAST_NAME varchar(50),"
                    + "USER_NAME varchar(50) not null ,"
                    + "JOB_TITLE varchar(50) not null ,"
                    + "PASSWORD_USER varchar(65) not null ,"
                    + "primary key (EMPLOYEE_ID)"
                    + ")");

            statment.executeUpdate("CREATE TABLE IF NOT EXISTS DISHES("
                    + "DISH_ID INT auto_increment,"
                    + "DISH_NAME VARCHAR(75) NOT NULL,"
                    + "PRICE FLOAT NOT NULL,"
                    + "DESCRIPTION TEXT NOT NULL,"
                    + "primary key (DISH_ID)"
                    + ");");

            statment.executeUpdate("CREATE TABLE IF NOT EXISTS COMMAND("
                    + "COMMAND_ID INT NOT NULL,"
                    + "DATE_COMMAND DATE,"
                    + "TOTAL FLOAT NOT NULL,"
                    + "primary key (COMMAND_ID)"
                    + ");");
            statment.executeUpdate("CREATE TABLE IF NOT EXISTS RESTAURANT_TABLE("
                    + "TABLE_NUM INT auto_increment,"
                    + "primary key (TABLE_NUM)"
                    + ");");
            statment.executeUpdate("CREATE TABLE IF NOT EXISTS COMMAND_DETAILS("
                    + "COMMAND_DETAILS_ID INT auto_increment,"
                    + "COMMAND_ID INT,"
                    + "QUANTITY INT NOT NULL,"
                    + "DISH_ID INT NOT NULL,"
                    + "TABLE_NUM INT NOT NULL,"
                    + "EMPLOYEE_ID INT NOT NULL,"
                    + "primary key (COMMAND_DETAILS_ID),"
                    + "foreign key (DISH_ID) references DISHES(DISH_ID),"
                    + "foreign key (EMPLOYEE_ID) references EMPLOYEES(EMPLOYEE_ID)"
                    + "foreign key (TABLE_NUM) references RESTAURANT_TABLE(TABLE_NUM)"
                    + ");");
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean addDish(Dish myDish) {
        try {
            statment = connection.createStatement();
            statment.executeUpdate("INSERT INTO DISHES (DISH_NAME,DESCRIPTION,PRICE) VALUES ('"
                    + myDish.getName() + "','"
                    + myDish.getDescription() + "','"
                    + myDish.getPrice() + "')");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean addEmployee(Employee myEmployee) {
        try {
            statment = connection.createStatement();
            statment.executeUpdate("INSERT INTO EMPLOYEES (FIRST_NAME,LAST_NAME,USER_NAME,JOB_TITLE,PASSWORD_USER) VALUES ('"
                    + myEmployee.getFirstName() + "','" + myEmployee.getLastName()
                    + "','" + myEmployee.getUsername() + "','" + myEmployee.getJobTitle()
                    + "','" + myEmployee.getPassword() + "')");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean addCommand(Command myCommand) {
        try {
            statment = connection.createStatement();
            statment.executeUpdate("INSERT INTO COMMAND (COOMAND_ID,DATE_COMMAND,TOTAL)VALUES ('"
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
            statment.executeUpdate("INSERT INTO COMMAND_DETAILS(COMMAND_ID,QUANTITY,DISH_ID,TABLE_NUM,EMPLOYEE_ID) VALUES ('"
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

    public boolean addRestaurantTable(RestaurantTable myTable) {
        try {
            statment = connection.createStatement();
            result = statment.executeQuery("select count(TABLE_NUM) AS total from RESTAURANT_TABLE");
            if(result.next()){
            myTable.setRestauran_table_add(result.getInt("total"));
            statment.executeUpdate("INSERT INTO RESTAURANT_TABLE SET TABLE_NUM = '"
                    + myTable.getRestauran_table()
                    + "'");
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
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
                myEmployee.setJobTitle(result.getString("JOB_TITLE"));
                Employees.add(myEmployee);
            }
        } catch (SQLException e) {
            return null;
        }
        return Employees;
    }

    public ArrayList getDishesDish() {
        ArrayList Dishes = new ArrayList();
        try {
            statment = connection.createStatement();
            result = statment.executeQuery("SELECT * FROM DISHES WHERE DESCRIPTION LIKE '%Dish%'");
            while (result.next()) {
                Dish myDish = new Dish();
                myDish.setDishID(result.getInt("DISH_ID"));
                myDish.setName(result.getString("DISH_NAME"));
                myDish.setPrice(result.getFloat("PRICE"));
                myDish.setDescription(result.getString("DESCRIPTION"));
                Dishes.add(myDish);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return Dishes;
    }
    
    public ArrayList getDishesDrink() {
        ArrayList Dishes = new ArrayList();
        try {
            statment = connection.createStatement();
            result = statment.executeQuery("SELECT * FROM DISHES WHERE DESCRIPTION LIKE '%Drink%'");
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
    
    public ArrayList getDishesDesserts() {
        ArrayList Dishes = new ArrayList();
        try {
            statment = connection.createStatement();
            result = statment.executeQuery("SELECT * FROM DISHES WHERE DESCRIPTION LIKE '%Dessert%'");
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
                CommandsDetails.add(myCommandDetails);
            }
        } catch (SQLException e) {
            return null;
        }
        return CommandsDetails;
    }

    public ArrayList getRestaurantTable() {
        ArrayList RestaurantTables = new ArrayList();
        try {
            statment = connection.createStatement();
            result = statment.executeQuery("SELECT * FROM RESTAURANT_TABLE");
            while (result.next()) {
                RestaurantTable myTable = new RestaurantTable();
                myTable.setRestauran_table(result.getInt("TABLE_NUM"));
                RestaurantTables.add(myTable);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return RestaurantTables;
    }

    public Employee searchEmployee(String search) {

        Employee myEmployee = new Employee();
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

                myEmployee.setEmployeeID(result.getInt("EMPLOYEE_ID"));
                myEmployee.setFirstName(result.getString("FIRST_NAME"));
                myEmployee.setLastName(result.getString("LAST_NAME"));
                myEmployee.setUsername(result.getString("USER_NAME"));
                myEmployee.setJobTitle(result.getString("JOB_TITLE"));
                myEmployee.setPassword(result.getString("PASSWORD_USER"));//could be this is a problem

            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return myEmployee;
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

    public ArrayList searchRestaurantTable(String search) {
        ArrayList RestaurantTable = new ArrayList();
        try {
            statment = connection.createStatement();
            result = statment.executeQuery("SELECT * FROM RESTAURANT_TABLE WHERE TABLE_NUM LIKE "
                    + "'%" + search + "%' or TABLE_NUM "
            );
            while (result.next()) {
                RestaurantTable myTable = new RestaurantTable();
                myTable.setRestauran_table(result.getInt("TABLE_NUM"));

            }
        } catch (SQLException e) {
            return null;
        }
        return RestaurantTable;
    }

    public void deleteEmployee(int id) {
        try {
            statment = connection.createStatement();
            statment.executeUpdate("DELETE FROM EMPLOYEE WHERE EMPLOYEE_ID = " + id);
        } catch (SQLException e) {
        }
    }

    public void deleteDish(int id) {
        try {
            statment = connection.createStatement();
            statment.executeUpdate("DELETE FROM DISHES WHERE DISH_ID = " + id);
        } catch (SQLException e) {
        }
    }

    public void deleteCommand(int id) {
        try {
            statment = connection.createStatement();
            statment.executeUpdate("DELETE FROM COMMAND WHERE COMMAND_ID = " + id);
        } catch (SQLException e) {
        }
    }

    public void deleteCommandDetails(int id) {
        try {
            statment = connection.createStatement();
            statment.executeUpdate("DELETE FROM COMMAND_DETAILS WHERE COMMAND_DETAILS_ID = " + id);
        } catch (SQLException e) {
        }
    }

    public void deleteRestaurantTable(int id) {
        try {
            statment = connection.createStatement();
            statment.executeUpdate("DELETE FROM RESTAURANT_TABLE WHERE TABLE_NUM = " + id);
        } catch (SQLException e) {

        }
    }

    public boolean updateEmployee(Employee myEmployee) {
        try {
            statment = connection.createStatement();
            statment.executeUpdate("UPDATE EMPLOYEE SET FIRST_NAME = '" + myEmployee.getFirstName() + "',"
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
            statment.executeUpdate("UPDATE DISH SET DISH_NAME = '" + myDish.getName() + "',"
                    + "PRICE = '" + myDish.getPrice() + "'"
                    + "DESCRIPTION = '" + myDish.getDescription() + "'"
                    + "WHERE DISH_ID = " + myDish.getDishID());
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean updateCommand(Command myCommand) {
        try {
            statment = connection.createStatement();
            statment.executeUpdate("UPDATE EMPLOYEE SET DATE_COMMAND = '" + myCommand.getDateCommand() + "',"
                    + "TOTAL = '" + myCommand.getTotal() + "'"
                    + "WHERE COMMAND_ID = " + myCommand.getOrderID());
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean updateCommandDetails(CommandDetails myCommandDetails) {
        try {
            statment = connection.createStatement();
            statment.executeUpdate("UPDATE COMMAND_DETAILS SET COMMAND_ID = '" + myCommandDetails.getCommandID() + "',"
                    + "QUANTITY = '" + myCommandDetails.getQuantity() + "',"
                    + "DISH_ID = '" + myCommandDetails.getDishID() + "',"
                    + "TABLE_NUM = '" + myCommandDetails.getTableNum() + "',"
                    + "EMPLOYEE_ID = '" + myCommandDetails.getEmployeeID() + "'"
                    + "WHERE COMMAND_DETAILS_ID = " + myCommandDetails.getCommandDetailsID());
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean updateRestaurantTable(RestaurantTable myTable) {
        try {
            statment = connection.createStatement();
            statment.executeUpdate("UPDATE RESTAURANT_TABLE SET TABLE_NUM = '"
                    + myTable.getRestauran_table()+ "',"
                    + "TABLE_NUM = = '" + myTable.getRestauran_table()+ "',"
            );
            return true;
        } catch (SQLException e) {
            return false;
        }

    }

}
