package gui;

import database.JDBC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Withdrawl extends Frame implements ActionListener {

    private JTextField amountTextField;
    private JButton withdrawButton, backButton;
    private long cardNum, pinNum;

    public Withdrawl(long cardNum, long pinNum) {

        super("HDFC Cash Withdrawl");
        setSize(900,980);
        setLocationRelativeTo(null);
        this.cardNum = cardNum;
        this.pinNum = pinNum;
        addGuiComponents();
    }

    private void addGuiComponents() {

        ImageIcon imgIcon = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        JLabel atmImgIcon = new JLabel(imgIcon);
        atmImgIcon.setSize(900,980);
        add(atmImgIcon);

        //Enter amount Label
        JLabel EnterAmountLabel = new JLabel("Enter the amount you want to Withdraw");
        EnterAmountLabel.setBounds(180,300,700,35);
        EnterAmountLabel.setForeground(Color.white);
        EnterAmountLabel.setFont(new Font("Raleway",Font.BOLD,16));
        atmImgIcon.add(EnterAmountLabel);

        //Amount Text field
        amountTextField = new JTextField();
        amountTextField.setBounds(170,370,320,35);
        amountTextField.setFont(new Font("Raleway",Font.BOLD,25));
        atmImgIcon.add(amountTextField);

        //Withdraw Button
        withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(360,535,150,35);
        withdrawButton.setFont(new Font("Raleway",Font.PLAIN,20));
        withdrawButton.addActionListener(this);
        atmImgIcon.add(withdrawButton);

        //Back Button
        backButton = new JButton("Back");
        backButton.setBounds(360,578,150,30);
        backButton.setFont(new Font("Raleway",Font.PLAIN,20));
        backButton.addActionListener(this);
        atmImgIcon.add(backButton);
    }

    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();

        if(command.equals("Withdraw")) {
            String amountString = amountTextField.getText();
            long amount = Long.parseLong(amountString);
            Date time = new Date();
            String currentTime = String.valueOf(time);

            if(amountString.equals("")) JOptionPane.showMessageDialog(Withdrawl.this,"Please fill the amount");
            else {
                long currBalance = JDBC.currBalance(cardNum);

                if(currBalance >= amount){
                    JDBC.withdrawAmount(amount,currentTime,cardNum,"Withdrawl",currBalance);
                    JOptionPane.showMessageDialog(null,"Withdraw of Rs "+amount +"Successfully");
                }
                else JOptionPane.showMessageDialog(null,"Not Enough Balance");

                Withdrawl.this.dispose();
                new TransactionsPage(cardNum,pinNum).setVisible(true);
            }
        }
        else {
            Withdrawl.this.dispose();
            new TransactionsPage(cardNum,pinNum).setVisible(true);
        }
    }
}
