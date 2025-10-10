package gui;

import database.JDBC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

public class FastCash extends Frame{

    long cardNum,pinNum;
    Date time;
    String currentTime = null;
    long currBalance;

    public FastCash(long cardNum,long pinNum) {

        super("HDFC Fast-Cash");
        setSize(900,980);
        setLocationRelativeTo(null);
        this.cardNum = cardNum;
        this.pinNum = pinNum;
        currBalance = JDBC.currBalance(cardNum);
        addGuiComponents();
        setUndecorated(true);
    }

    private void addGuiComponents() {


        ImageIcon imgIcon = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        JLabel atmImgIcon = new JLabel(imgIcon);
        atmImgIcon.setSize(900,980);
        add(atmImgIcon);

        //Select Amount Label
        JLabel selectAmountLabel = new JLabel("Select Withdrawl Amount");
        selectAmountLabel.setBounds(210,300,700,35);
        selectAmountLabel.setForeground(Color.white);
        selectAmountLabel.setFont(new Font("Raleway",Font.BOLD,16));
        atmImgIcon.add(selectAmountLabel);

        //Rupee labels
        JLabel hundredLabel = new JLabel("Rs 100");
        hundredLabel.setBounds(160,455,75,25);
        hundredLabel.setForeground(Color.yellow);
        hundredLabel.setFont(new Font("Raleway",Font.BOLD,18));
        hundredLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        hundredLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                time = new Date();
                currentTime = String.valueOf(time);

                JDBC.withdrawAmount(100,currentTime,cardNum,"Withdraw",currBalance);
                JOptionPane.showMessageDialog(null,"Withdrawl of Rs 100 Successfull");
                FastCash.this.dispose();
                new TransactionsPage(cardNum,pinNum).setVisible(true);
            }
        });
        atmImgIcon.add(hundredLabel);


        JLabel fiveHundredLabel = new JLabel("Rs 500");
        fiveHundredLabel.setBounds(355,455,140,25);
        fiveHundredLabel.setForeground(Color.yellow);
        fiveHundredLabel.setFont(new Font("Raleway",Font.BOLD,18));
        fiveHundredLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        fiveHundredLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                time = new Date();
                currentTime = String.valueOf(time);

                JDBC.withdrawAmount(500,currentTime,cardNum,"Withdraw",currBalance);
                JOptionPane.showMessageDialog(null,"Withdrawl of Rs 500 Successfull");
                FastCash.this.dispose();
                new TransactionsPage(cardNum,pinNum).setVisible(true);
            }
        });
        atmImgIcon.add(fiveHundredLabel);


        JLabel oneThousandLabel = new JLabel("Rs 1000");
        oneThousandLabel.setBounds(160,495,90,25);
        oneThousandLabel.setForeground(Color.yellow);
        oneThousandLabel.setFont(new Font("Raleway",Font.BOLD,18));
        oneThousandLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        oneThousandLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                time = new Date();
                currentTime = String.valueOf(time);

                JDBC.withdrawAmount(1000,currentTime,cardNum,"Withdraw",currBalance);
                JOptionPane.showMessageDialog(null,"Withdrawl of Rs 1000 Successfull");
                FastCash.this.dispose();
                new TransactionsPage(cardNum,pinNum).setVisible(true);
            }
        });
        atmImgIcon.add(oneThousandLabel);


        JLabel fiveThousandLabel = new JLabel("Rs 5000");
        fiveThousandLabel.setBounds(355,495,140,25);
        fiveThousandLabel.setForeground(Color.yellow);
        fiveThousandLabel.setFont(new Font("Raleway",Font.BOLD,18));
        fiveThousandLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        fiveThousandLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                time = new Date();
                currentTime = String.valueOf(time);

                JDBC.withdrawAmount(5000,currentTime,cardNum,"Withdraw",currBalance);
                JOptionPane.showMessageDialog(null,"Withdrawl of Rs 5000 Successfull");
                FastCash.this.dispose();
                new TransactionsPage(cardNum,pinNum).setVisible(true);
            }
        });
        atmImgIcon.add(fiveThousandLabel);


        JLabel tenThousandLabel = new JLabel("Rs 10,000");
        tenThousandLabel.setBounds(160,535,105,25);
        tenThousandLabel.setForeground(Color.yellow);
        tenThousandLabel.setFont(new Font("Raleway",Font.BOLD,18));
        tenThousandLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        tenThousandLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                time = new Date();
                currentTime = String.valueOf(time);

                JDBC.withdrawAmount(10000,currentTime,cardNum,"Withdraw",currBalance);
                JOptionPane.showMessageDialog(null,"Withdrawl of Rs 10,000 Successfull");
                FastCash.this.dispose();
                new TransactionsPage(cardNum,pinNum).setVisible(true);
            }
        });
        atmImgIcon.add(tenThousandLabel);

        //Back Inquiry label
        JLabel backLabel = new JLabel("Back");
        backLabel.setBounds(355,535,145,25);
        backLabel.setForeground(Color.yellow);
        backLabel.setFont(new Font("Raleway",Font.BOLD,18));
        backLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        backLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                FastCash.this.dispose();
                new TransactionsPage(cardNum,pinNum).setVisible(true);
            }
        });
        atmImgIcon.add(backLabel);

        //Log Out label
        JLabel logOutLabel = new JLabel("Log Out");
        logOutLabel.setBounds(355,575,80,25);
        logOutLabel.setForeground(Color.yellow);
        logOutLabel.setFont(new Font("Raleway",Font.BOLD,18));
        logOutLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        logOutLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                FastCash.this.dispose();
                new LoginForm().setVisible(true);
            }
        });
        atmImgIcon.add(logOutLabel);
    }
}
