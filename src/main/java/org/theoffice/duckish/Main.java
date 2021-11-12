package org.theoffice.duckish;

import org.theoffice.duckish.ext.SetUI;
import org.theoffice.duckish.ext.SetUIFont;
import org.theoffice.duckish.proc.Start;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) throws Exception {

        // Config UI
        new SetUI();
        new SetUIFont(new javax.swing.plaf.FontUIResource("Roboto", Font.PLAIN, 14));

        JFrame.setDefaultLookAndFeelDecorated(false); // Doesn't work IDK why
        new Start();
    }
}
