package gui;

import javax.swing.*;
import java.awt.*;

public class RegisterFormTwo extends Frame{

    public RegisterFormTwo() {
        super("AUTOMATED TELLER MACHINE");
        setSize(850,800);
        setLocationRelativeTo(null);
        addGuiComponents();
    }

    private void addGuiComponents() {

        getContentPane().setBackground(Color.WHITE);

        //Form label
        JLabel formNo = new JLabel("Application Form No : " );
        formNo.setBounds(140,20,600,40);
        formNo.setFont(new Font("Raleway",Font.BOLD,38));
        add(formNo);

        //Personal details label
        JLabel personalDetails = new JLabel("Page Two : Personal Details");
        personalDetails.setBounds(250,80,400,30);
        personalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        add(personalDetails);
    }
}
