package org.theoffice.duckish.ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class StartUI extends JFrame {

    public StartUI() {
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(400, 450);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        this.setTitle("Duckish");

        JLabel title = new JLabel("Duckish");
        title.setBounds(105, 70, 200, 50);
        title.setFont(new Font("Roboto", Font.BOLD, 50));
        add(title);

        final JButton signIn = new JButton("Sign In");
        signIn.setBounds(100, 180, 200, 40);
        signIn.setFocusPainted(false);
        signIn.addActionListener(e -> {
            new LoginUI();
            dispose();
        });
        add(signIn);

        final JButton signUp = new JButton("Sign Up");
        signUp.setBounds(100, 240,200, 40);
        signUp.setFocusPainted(false);
        signUp.addActionListener(e -> {
            new SignUpUI();
            dispose();
        });
        add(signUp);

        try {
            BufferedImage img = ImageIO.read(new File("src/main/java/org/theoffice/duckish/ui/images/logo_nobg.png")); // wtf?
            JLabel bgLogo = new JLabel(new ImageIcon(img));
            bgLogo.setBounds(220, 250, 200, 200);
            add(bgLogo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
