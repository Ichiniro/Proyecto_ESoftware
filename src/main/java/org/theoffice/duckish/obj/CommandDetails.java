package org.theoffice.duckish.obj;

public class CommandDetails {
    private int commandDetailsID;
    private int commandID;
    private int quantity;
    private int dishID;
    private int tableID;
    private int tableNum;
    private int employeeID;

    public int getCommandDetailsID() {
        return commandDetailsID;
    }

    public void setCommandDetailsID(int commandDetailsID) {
        this.commandDetailsID = commandDetailsID;
    }

    public int getCommandID() {
        return commandID;
    }

    public void setCommandID(int privateID) {
        this.commandID = privateID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getDishID() {
        return dishID;
    }

    public void setDishID(int dishID) {
        this.dishID = dishID;
    }

    public int getTableID() {
        return tableID;
    }

    public void setTableID(int tableID) {
        this.tableID = tableID;
    }

    public int getTableNum() {
        return tableNum;
    }

    public void setTableNum(int tableNum) {
        this.tableNum = tableNum;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
    
}
