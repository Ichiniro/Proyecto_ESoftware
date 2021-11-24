package org.theoffice.duckish;

import org.theoffice.duckish.ext.SetUI;
import org.theoffice.duckish.ext.SetUIFont;
import org.theoffice.duckish.ui.StartUI;

import javax.swing.*;
import java.awt.*;
import org.theoffice.duckish.ui.SystemUI;

public class Main {

    public static void main(String[] args) throws Exception {

        // Config UI
        new SetUI();
        new SetUIFont(new javax.swing.plaf.FontUIResource("Roboto", Font.PLAIN, 14));
        
        //Initialize Principal Frame xd aiudaa
        //SystemUI inc = new SystemUI();
        //inc.setVisible(true);
        
        new StartUI();
    }
}
