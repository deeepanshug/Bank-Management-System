package gui;

import database.JDBC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RegisterFormThree extends Frame implements ActionListener {

    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton cancelButton,submitButton;
    long formNum;

    public RegisterFormThree(long formNum) {

        super("NEW ACCOUNT APPLICATION FORM - PAGE 3");
        setSize(850,820);
        setLocationRelativeTo(null);
        this.formNum = formNum;
        addGuiComponents();
    }

    private void addGuiComponents() {

        //Additional details label
        JLabel accountDetailsLabel = new JLabel("Page Three : Account Details");
        accountDetailsLabel.setBounds(280,40,400,40);
        accountDetailsLabel.setFont(new Font("Raleway",Font.BOLD,22));
        add(accountDetailsLabel);

        //Account Type label
        JLabel accountTypeLabel = new JLabel("Account Type");
        accountTypeLabel.setBounds(100,140,200,30);
        accountTypeLabel.setFont(new Font("Raleway",Font.BOLD,22));
        add(accountTypeLabel);

        //Radio button of Account type
        r1 = new JRadioButton("Savings Account");
        r1.setBounds(100,180,250,20);
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBackground(Color.white);
        add(r1);

        r2 = new JRadioButton("Current Account");
        r2.setBounds(100,220,250,20);
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBackground(Color.white);
        add(r2);

        r3 = new JRadioButton("Fixed Deposit Account");
        r3.setBounds(350,180,250,20);
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBackground(Color.white);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setBounds(350,220,250,20);
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBackground(Color.white);
        add(r4);

        ButtonGroup accountTypeGrouping = new ButtonGroup();
        accountTypeGrouping.add(r1);
        accountTypeGrouping.add(r2);
        accountTypeGrouping.add(r3);
        accountTypeGrouping.add(r4);

        //Card Num label
        JLabel cardNumLabel = new JLabel("Card Number : ");
        cardNumLabel.setBounds(100,300,200,30);
        cardNumLabel.setFont(new Font("Raleway",Font.BOLD,22));
        add(cardNumLabel);

        //Card Detail label
        JLabel cardDetailLabel = new JLabel("Your 16 Digit Card Number");
        cardDetailLabel.setBounds(100,330,300,20);
        cardDetailLabel.setFont(new Font("Raleway",Font.BOLD,12));
        add(cardDetailLabel);

        //Card Num XXX label
        JLabel cardNumXXX = new JLabel("XXXX-XXXX-XXXX-4036");
        cardNumXXX.setBounds(330,300,300,30);
        cardNumXXX.setFont(new Font("Raleway",Font.BOLD,22));
        add(cardNumXXX);

        //Pin label
        JLabel pinLabel = new JLabel("Pin Number : ");
        pinLabel.setBounds(100,370,200,30);
        pinLabel.setFont(new Font("Raleway",Font.BOLD,22));
        add(pinLabel);

        //Pin Detail label
        JLabel pinDetailLabel = new JLabel("Your 4 Digit Pin");
        pinDetailLabel.setBounds(100,400,300,20);
        pinDetailLabel.setFont(new Font("Raleway",Font.BOLD,12));
        add(pinDetailLabel);

        //Pin XXX label
        JLabel PinXXXLabel = new JLabel("XXXX");
        PinXXXLabel.setBounds(330,370,200,30);
        PinXXXLabel.setFont(new Font("Raleway",Font.BOLD,22));
        add(PinXXXLabel);

        //Services Required label
        JLabel servicesRequiredLabel = new JLabel("Services Required");
        servicesRequiredLabel.setBounds(100,450,400,30);
        servicesRequiredLabel.setFont(new Font("Raleway",Font.BOLD,22));
        add(servicesRequiredLabel);

        //CheckBox
        c1 = new JCheckBox("ATM Card");
        c1.setBounds(100,500,200,30);
        c1.setBackground(Color.white);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBounds(350,500,200,30);
        c2.setBackground(Color.white);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBounds(100,550,200,30);
        c3.setBackground(Color.white);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        add(c3);

        c4 = new JCheckBox("Email & Sms Alerts");
        c4.setBounds(350,550,200,30);
        c4.setBackground(Color.white);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBounds(100,600,200,30);
        c5.setBackground(Color.white);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        add(c5);

        c6 = new JCheckBox("E-Statements");
        c6.setBounds(350,600,200,30);
        c6.setBackground(Color.white);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        add(c6);

        c7 = new JCheckBox("I hearby declare that above entered details are correct to the best of my knowledge");
        c7.setBounds(70,680,650,30);
        c7.setBackground(Color.white);
        c7.setFont(new Font("Raleway",Font.BOLD,16));
        add(c7);

        //cancel button
        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(230,725,100,40);
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFont(new Font("Raleway",Font.BOLD,18));
        cancelButton.addActionListener(this);
        add(cancelButton);

        //submit button
        submitButton = new JButton("Submit");
        submitButton.setBounds(400,725,100,40);
        submitButton.setBackground(Color.BLACK);
        submitButton.setForeground(Color.WHITE);
        submitButton.setFont(new Font("Raleway",Font.BOLD,18));
        submitButton.addActionListener(this);
        add(submitButton);

        getContentPane().setBackground(Color.white);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        String command = ae.getActionCommand();

        if(command.equals("Cancel")) {
            JOptionPane.showMessageDialog(RegisterFormThree.this,"Application process is Cancelled");
            RegisterFormThree.this.dispose();
            new LoginForm().setVisible(true);
        }
        else {
            String accountType = null;
            if(r1.isSelected()) accountType = "Saving Account";
            else if(r2.isSelected()) accountType = "Current Account";
            else if(r3.isSelected()) accountType = "Fixed Deposit Account";
            else accountType = "Recurring Deposit Account";

            Random random = new Random();
            long cardNum = Math.abs((random.nextLong() % 90000000L) + 5040904600000000L);
            long pinNum = Math.abs((random.nextLong() % 9000L) + 1000L);

            String servicesRequiredString = "";
            if(c1.isSelected()) servicesRequiredString = servicesRequiredString + " ATM Card";
            if(c2.isSelected()) servicesRequiredString = servicesRequiredString + " Internet Banking";
            if(c3.isSelected()) servicesRequiredString = servicesRequiredString + " Mobile Banking";
            if(c4.isSelected()) servicesRequiredString = servicesRequiredString + " Email & Sms Alert";
            if(c5.isSelected()) servicesRequiredString = servicesRequiredString + " Cheque Book";
            if(c6.isSelected()) servicesRequiredString = servicesRequiredString + " E-Statements";



            //Validations
            try{
                if(servicesRequiredString.equals("")) JOptionPane.showMessageDialog(RegisterFormThree.this,"Account Type is required");
                else if(!c7.isSelected()) JOptionPane.showMessageDialog(RegisterFormThree.this,"Please accept the T&C.");
                else{
                    JDBC.registerFormThreeDetails(accountType,cardNum,pinNum,servicesRequiredString,formNum);
                    JOptionPane.showMessageDialog(RegisterFormThree.this,"Details submitted successfully\n" +
                            "Please Login");
                    RegisterFormThree.this.dispose();
                    new LoginForm().setVisible(true);
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
