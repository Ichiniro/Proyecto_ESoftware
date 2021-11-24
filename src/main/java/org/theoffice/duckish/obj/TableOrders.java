/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.theoffice.duckish.obj;

/**
 *
 * @author ichiniro
 */
public class TableOrders {
    int table;
    String food;
    String price;
    
    public TableOrders(int table, String food, String price) {
        this.table = table;
        this.food = food;
        this.price = price;
    }
    public int getTable() {return table;}
    public String getFood() {return food;}
    public String getPrice() {return price;}
}
