package gui;

import database.JDBC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends Frame implements ActionListener {

    private JTextField amountTextField;
    private JButton depositButton,backButton;
    private long cardNum, pinNum;

    public Deposit(long cardNum, long pinNum) {

        super("HDFC Deposit");
        setSize(900,980);
        this.cardNum = cardNum;
        this.pinNum = pinNum;
        setLocationRelativeTo(null);
        addGuiComponents();
        setUndecorated(true);
    }

    private void addGuiComponents() {

        ImageIcon imgIcon = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        JLabel atmImgIcon = new JLabel(imgIcon);
        atmImgIcon.setSize(900,980);
        add(atmImgIcon);

        //Enter amount Label
        JLabel depositLabel = new JLabel("Enter the amount you want to Deposit");
        depositLabel.setBounds(150,310,420,35);
        depositLabel.setForeground(Color.white);
        depositLabel.setFont(new Font("System",Font.BOLD,20));
        atmImgIcon.add(depositLabel);

        //Amount Text field
        amountTextField = new JTextField();
        amountTextField.setBounds(170,370,320,35);
        amountTextField.setFont(new Font("Raleway",Font.BOLD,25));
        atmImgIcon.add(amountTextField);

        //Deposit Button
        depositButton = new JButton("Deposit");
        depositButton.setBounds(360,535,150,35);
        depositButton.setFont(new Font("Raleway",Font.PLAIN,20));
        depositButton.addActionListener(this);
        atmImgIcon.add(depositButton);

        //Back Button
        backButton = new JButton("Back");
        backButton.setBounds(360,578,150,30);
        backButton.setFont(new Font("Raleway",Font.PLAIN,20));
        backButton.addActionListener(this);
        atmImgIcon.add(backButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();
        if(command.equals("Deposit")) {
            String amountString = amountTextField.getText();
            long amount = Long.parseLong(amountString);
            Date time = new Date();
            String currentTime = String.valueOf(time);


            if(amountString.equals("")) JOptionPane.showMessageDialog(Deposit.this,"Please fill the amount");
            else {
                JDBC.depositAmount(amount,currentTime,cardNum,"Deposit");
                JOptionPane.showMessageDialog(null,"Deposit of Rs "+amount +" Successfully");
                Deposit.this.dispose();
                new TransactionsPage(cardNum,pinNum).setVisible(true);
            }
        }
        else {
            Deposit.this.dispose();
            new TransactionsPage(cardNum,pinNum).setVisible(true);
        }
    }
}
