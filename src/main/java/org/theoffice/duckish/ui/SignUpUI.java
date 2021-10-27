package org.theoffice.duckish.ui;

import org.theoffice.duckish.obj.Employee;
import org.theoffice.duckish.proc.SignUp;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class SignUpUI extends JFrame {

    public SignUpUI() {
        this.setLayout(null);
        this.setSize(630, 540);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setTitle("Duckish - Sign Up");

        JLabel title = new JLabel("Duckish");
        title.setBounds(55, 50, 200, 50);
        title.setFont(new Font("Roboto", Font.BOLD, 50));
        add(title);

        JLabel nameLB = new JLabel("Nombre");
        nameLB.setBounds(55, 170, 51, 16);
        add(nameLB);

        JTextField nameTF = new JTextField();
        nameTF.setBounds(55, 203, 200, 30);
        add(nameTF);

        JLabel passwordLB = new JLabel("Password");
        passwordLB.setBounds(55, 256, 70, 16);
        add(passwordLB);

        JTextField passwordTF = new JTextField();
        passwordTF.setBounds(55, 289, 200, 30);
        add(passwordTF);

        JLabel positionLB = new JLabel("Position");
        positionLB.setBounds(55, 336, 51, 16);
        add(positionLB);

        JComboBox<String> positionCB = new JComboBox<>();
        positionCB.setBounds(55, 369, 200, 30);
        add(positionCB);
        positionCB.addItem("");
        positionCB.addItem("Mesero");
        positionCB.addItem("Cocinero");
        positionCB.addItem("Gerente");

        JLabel lastNameLB = new JLabel("Last name");
        lastNameLB.setBounds(366,170, 70, 16);
        add(lastNameLB);

        JTextField lastNameTF = new JTextField();
        lastNameTF.setBounds(366, 203, 200, 30);
        add(lastNameTF);

        JLabel confirmPasswordLB = new JLabel("Confirm password");
        confirmPasswordLB.setBounds(366, 256, 130, 16);
        add(confirmPasswordLB);

        JTextField confirmPasswordTF = new JTextField();
        confirmPasswordTF.setBounds(366, 289, 200, 30);
        add(confirmPasswordTF);

        JLabel usernameLB = new JLabel("Username");
        usernameLB.setBounds(366, 337, 63, 16);
        add(usernameLB);

        JTextField usernameTF = new JTextField();
        usernameTF.setBounds(366, 371, 200, 30);
        add(usernameTF);

        final JButton signUp = new JButton("Sign Up");
        signUp.setBounds(157, 452, 300, 40);
        signUp.addActionListener(e -> {
            // This shit wasn't meant to be read, refactor later. /j
            Employee employee = new Employee();
            employee.setFirstName(nameTF.getText());
            employee.setLastName(lastNameTF.getText());
            employee.setJobTitle(Objects.requireNonNull(positionCB.getSelectedItem()).toString());
            employee.setEmployeeID(1);
            employee.setPassword(passwordTF.getText(), confirmPasswordTF.getText());
            employee.setUsername(usernameTF.getText());
            employee.setRestaurantID(1);

            try {
                if (employee.isValid()) {
                    new SignUp(employee);
                }
            } catch (IllegalAccessException ex) {
                ex.printStackTrace();
            }
        });
        add(signUp);
    }
}
