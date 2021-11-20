package org.theoffice.duckish.obj;

public class Command {
    private int orderID;
    private String dateCommand;
    private float total;

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getDateCommand() {
        return dateCommand;
    }

    public void setDateCommand(String dateCommand) {
        this.dateCommand = dateCommand;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    
}
