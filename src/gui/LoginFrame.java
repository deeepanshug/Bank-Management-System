package gui;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends Frame {

    public LoginFrame() {
        super("AUTOMATED TELLER MACHINE");
        addGuiComponents();
    }

    private void addGuiComponents() {

        ImageIcon imgIcon = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        JLabel logoImgIcon = new JLabel(imgIcon);
        logoImgIcon.setBounds(70,10,100,100);
        add(logoImgIcon);

        getContentPane().setBackground(Color.white);

    }
}