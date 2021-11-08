package org.theoffice.duckish.ui;

import org.theoffice.duckish.obj.Employee;
import org.theoffice.duckish.proc.Login;

import javax.swing.*;
import java.awt.*;

public class LoginUI extends JFrame {

    public LoginUI() {
        this.setLayout(null);
        this.setSize(400, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setTitle("Duckish - Log In");

        JLabel title = new JLabel("Duckish");
        title.setBounds(105, 70, 200, 50);
        title.setFont(new Font("Roboto", Font.BOLD, 50));
        add(title);

        JLabel usernameLB = new JLabel("Username");
        usernameLB.setBounds(100, 175, 63, 16);
        add(usernameLB);

        JTextField usernameTF = new JTextField();
        usernameTF.setBounds(100, 200, 250, 30);
        add(usernameTF);

        JLabel passwordLB = new JLabel("Password");
        passwordLB.setBounds(100, 250, 70, 16);
        add(passwordLB);

        JTextField passwordTF = new JTextField();
        passwordTF.setBounds(100, 275, 250, 30);
        add((passwordTF));

        final JButton logIn = new JButton("Log In");
        logIn.setFocusPainted(false);
        logIn.setBounds(100, 350, 200, 40);
        logIn.addActionListener(e -> {
            // meh
            Employee employee = new Employee();
            employee.setUsername(usernameTF.getText());

            new Login().login(employee);
        });
        add(logIn);
    }
}
