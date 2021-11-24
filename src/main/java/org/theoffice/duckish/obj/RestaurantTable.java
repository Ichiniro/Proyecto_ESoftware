/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
package org.theoffice.duckish.obj;

public class RestaurantTable {
   

    private int restauran_table ;

    public int getRestauran_table() {
        return restauran_table;
    }

    public void setRestauran_table_add(int restauran_table) {
        this.restauran_table = restauran_table+1;
    }
    
    public void setRestauran_table(int restaurant_table) {
        this.restauran_table = restaurant_table;
    }
    
}

