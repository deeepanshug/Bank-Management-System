package gui;

import database.JDBC;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginForm extends Frame implements ActionListener {

    private JTextField cardNoTextField;
    private JPasswordField pinTextField;

    public LoginForm() {
        super("HDFC Bank");
        addGuiComponents();
    }

    private void addGuiComponents() {

        ImageIcon imgIcon = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        JLabel logoImgIcon = new JLabel(imgIcon);
        logoImgIcon.setBounds(80,10,100,100);
        add(logoImgIcon);

        getContentPane().setBackground(Color.white);

        //Welcome Label
        JLabel welcomeLabel = new JLabel("Welcome to ATM");
        welcomeLabel.setBounds(220,40,370,40);
        welcomeLabel.setFont(new Font("Osward",Font.BOLD,38));
        add(welcomeLabel);

        //Card Num Label
        JLabel cardNoLabel = new JLabel("Card No :");
        cardNoLabel.setBounds(120,160,250,30);
        cardNoLabel.setFont(new Font("Dialog",Font.BOLD,28));
        add(cardNoLabel);

        //Pin Num Label
        JLabel pinNoLabel = new JLabel("Pin :");
        pinNoLabel.setBounds(120,230,250,30);
        pinNoLabel.setFont(new Font("Dialog",Font.BOLD,28));
        add(pinNoLabel);

        //Card Num text field
        cardNoTextField = new JTextField();
        cardNoTextField.setBounds(300,160,280,30);
        cardNoTextField.setBorder(new LineBorder(Color.BLACK,2));
        cardNoTextField.setFont(new Font("Dialog",Font.PLAIN,28));
        add(cardNoTextField);

        //Pin Text Field
        pinTextField = new JPasswordField();
        pinTextField.setBounds(300,230,280,30);
        pinTextField.setBorder(new LineBorder(Color.BLACK,2));
        pinTextField.setFont(new Font("Dialog",Font.PLAIN,28));
        add(pinTextField);

        //Clear button
        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(300,290,120,50);
        clearButton.setBackground(Color.BLACK);
        clearButton.setForeground(Color.WHITE);
        clearButton.setFont(new Font("Dialog", Font.BOLD,20));
        clearButton.addActionListener(this);
        add(clearButton);

        //Sign in button
        JButton signInButton = new JButton("Sign-In");
        signInButton.setBounds(450,290,120,50);
        signInButton.setBackground(Color.RED);
        signInButton.setForeground(Color.WHITE);
        signInButton.setFont(new Font("Dialog", Font.BOLD,20));
        signInButton.addActionListener(this);
        add(signInButton);

        JLabel registerLabel = new JLabel("Not a User? Register Here!");
        registerLabel.setBounds(300,370,400,25);
        registerLabel.setFont(new Font("Osward",Font.BOLD,23));
        registerLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                LoginForm.this.dispose();
                new RegisterFormOne().setVisible(true);
            }
        });
        add(registerLabel);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();

        if(command.equals("Clear")) {
            cardNoTextField.setText("");
            pinTextField.setText("");
        }
        else if(command.equals("Sign-In")) {

            String cardNum = cardNoTextField.getText();
            String pinNum = new String(pinTextField.getPassword());

            if(JDBC.validateLogin(cardNum,pinNum)) {
                LoginForm.this.dispose();
                new TransactionsPage(cardNum, pinNum).setVisible(true);
            }
            else JOptionPane.showMessageDialog(LoginForm.this,"Incorrect Card No or Pin");
        }
    }
}