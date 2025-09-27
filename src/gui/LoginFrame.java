package gui;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginFrame extends Frame implements ActionListener {

    private JTextField cardNoField;
    private JPasswordField pinField;

    public LoginFrame() {
        super("AUTOMATED TELLER MACHINE");
        addGuiComponents();
    }

    private void addGuiComponents() {

        ImageIcon imgIcon = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        JLabel logoImgIcon = new JLabel(imgIcon);
        logoImgIcon.setBounds(80,10,100,100);
        add(logoImgIcon);

        getContentPane().setBackground(Color.white);

        JLabel welcomeLabel = new JLabel("Welcome to ATM");
        welcomeLabel.setBounds(220,40,370,40);
        welcomeLabel.setFont(new Font("Osward",Font.BOLD,38));
        add(welcomeLabel);

        JLabel cardNoLabel = new JLabel("Card No :");
        cardNoLabel.setBounds(120,160,250,30);
        cardNoLabel.setFont(new Font("Dialog",Font.BOLD,28));
        add(cardNoLabel);

        JLabel pinNoLabel = new JLabel("Pin :");
        pinNoLabel.setBounds(120,230,250,30);
        pinNoLabel.setFont(new Font("Dialog",Font.BOLD,28));
        add(pinNoLabel);

        cardNoField = new JTextField();
        cardNoField.setBounds(300,160,250,30);
        cardNoField.setBorder(new LineBorder(Color.BLACK,2));
        cardNoLabel.setFont(new Font("Dialog",Font.PLAIN,28));
        add(cardNoField);

        pinField = new JPasswordField();
        pinField.setBounds(300,230,250,30);
        pinField.setBorder(new LineBorder(Color.BLACK,2));
        pinField.setFont(new Font("Dialog",Font.PLAIN,28));
        add(pinField);

        //Clear button
        JButton signInButton = new JButton("Clear");
        signInButton.setBounds(300,290,120,50);
        signInButton.setBackground(Color.BLACK);
        signInButton.setForeground(Color.WHITE);
        signInButton.setFont(new Font("Dialog", Font.BOLD,20));
        signInButton.addActionListener(this);
        add(signInButton);

        //Sign in button
        JButton clearButton = new JButton("Sign-In");
        clearButton.setBounds(450,290,120,50);
        clearButton.setBackground(Color.RED);
        clearButton.setForeground(Color.WHITE);
        clearButton.setFont(new Font("Dialog", Font.BOLD,20));
        signInButton.addActionListener(this);
        add(clearButton);

        JLabel registerLabel = new JLabel("Not a User? Register Here!");
        registerLabel.setBounds(300,370,400,20);
        registerLabel.setFont(new Font("Osward",Font.BOLD,18));
        registerLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                LoginFrame.this.dispose();
                new RegisterFrame().setVisible(true);
            }
        });
        add(registerLabel);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();

        if(command.equals("Clear")) {
            cardNoField.setText("");
            pinField.setText("");
        }
        else if(command.equals("Sign-In")) {

        }
    }
}