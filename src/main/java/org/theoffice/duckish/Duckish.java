package org.theoffice.duckish;

import javax.swing.*;

public class Duckish extends JFrame {
    public Duckish() {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 1000);
        setVisible(true);

        JButton bt = new JButton("Test");
        bt.setBounds(20, 20, 100, 30);
        bt.setFocusPainted(false);
        add(bt);
    }
}
