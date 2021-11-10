package org.theoffice.duckish.ui;

import org.theoffice.duckish.obj.Employee;
import org.theoffice.duckish.proc.SignUp;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class SignUpUI extends JFrame {

    public SignUpUI() {
        this.setLayout(null);
        this.setSize(660, 550);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setTitle("Duckish - Sign Up");

        final JButton back = new JButton(" \uF80C ");
        back.setBounds(0, 0, 50, 30);
        back.setFont(new Font("VictorMono Nerd Font", Font.PLAIN, 16));
        back.setBorderPainted(false);
        back.addActionListener(e -> {
            new StartUI();
            this.dispose();
        });
        add(back);

        JLabel title = new JLabel("Duckish");
        title.setBounds(100, 50, 200, 50);
        title.setFont(new Font("Roboto", Font.BOLD, 50));
        add(title);

        JLabel nameLB = new JLabel("Name");
        nameLB.setBounds(100, 170, 51, 16);
        add(nameLB);

        JTextField nameTF = new JTextField();
        nameTF.setBounds(100, 203, 200, 30);
        add(nameTF);

        JLabel passwordLB = new JLabel("Password");
        passwordLB.setBounds(100, 256, 70, 16);
        add(passwordLB);

        JPasswordField passwordTF = new JPasswordField();
        passwordTF.setBounds(100, 289, 200, 30);
        add(passwordTF);

        JLabel positionLB = new JLabel("Position");
        positionLB.setBounds(100, 336, 51, 16);
        add(positionLB);

        JComboBox<String> positionCB = new JComboBox<>();
        positionCB.setBounds(100, 369, 200, 30);
        add(positionCB);
        positionCB.addItem("");
        positionCB.addItem("Waiter");
        positionCB.addItem("Cashier");
        positionCB.addItem("Manager");

        JLabel lastNameLB = new JLabel("Last name");
        lastNameLB.setBounds(411,170, 70, 16);
        add(lastNameLB);

        JTextField lastNameTF = new JTextField();
        lastNameTF.setBounds(411, 203, 200, 30);
        add(lastNameTF);

        JLabel confirmPasswordLB = new JLabel("Confirm password");
        confirmPasswordLB.setBounds(411, 256, 130, 16);
        add(confirmPasswordLB);

        JPasswordField confirmPasswordTF = new JPasswordField();
        confirmPasswordTF.setBounds(411, 289, 200, 30);
        add(confirmPasswordTF);

        JLabel usernameLB = new JLabel("Username");
        usernameLB.setBounds(411, 337, 200, 16);
        add(usernameLB);

        JTextField usernameTF = new JTextField();
        usernameTF.setBounds(411, 371, 200, 30);
        add(usernameTF);

        final JButton signUp = new JButton("Sign Up");
        signUp.setBounds(157, 452, 300, 40);
        signUp.addActionListener(e -> {
            Employee employee = new Employee();
            employee.setFirstName(nameTF.getText());
            employee.setLastName(lastNameTF.getText());
            boolean pwdFlag = employee.setPassword(passwordTF.getPassword(), confirmPasswordTF.getPassword());
            employee.setEmployeeID(1);
            employee.setRestaurantID(1);
            employee.setJobTitle(Objects.requireNonNull(positionCB.getSelectedItem()).toString());
            boolean usrFlag = employee.setUsername(usernameTF.getText());

            String warning = "";
            if (!pwdFlag) {
                warning = """
                        Invalid password. Make sure both fields match.
                        All paswords must:
                        - At lest 8 charachters long, maximum 20
                        - Include a lowercase and an uppercase character
                        - Include a number
                        - Include a special character""";
            }

            if (!usrFlag) {
                warning = warning + "Invalid username. All usernames must at least:\n" +
                        "- Be 4 characters long\n- Only contain uppercase and lowercase characters";
            }

            if (pwdFlag && usrFlag) {
                try {
                    if (employee.isValid()) {
                        new SignUp(employee);
                        JOptionPane.showMessageDialog(null,
                                "Account created succesfully. Press ok to cotinue.");
                        this.dispose();
                        new Menu();
                    } else {
                        JOptionPane.showMessageDialog(null, "Please, fill all the fields");
                    }
                } catch (IllegalAccessException ex) {
                    System.out.println("no se puede logear");
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, warning);
            }
        });
        add(signUp);

        try {
            BufferedImage img = ImageIO.read(
                    new File("src/main/resources/images/logo_nobg.png")); // wtf?
            JLabel bgLogo = new JLabel(new ImageIcon(img));
            bgLogo.setBounds(480, 350, 200, 200);
            add(bgLogo);

            BufferedImage icon = ImageIO.read(
                    new File("src/main/resources/images/logo.png"));
            this.setIconImage(icon);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
