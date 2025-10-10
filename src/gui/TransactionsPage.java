package gui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TransactionsPage extends Frame{

    long cardNum,pinNum;

    public TransactionsPage(long cardNum,long pinNum) {

        super("HDFC");
        setSize(900,980);
        setLocationRelativeTo(null);
        this.cardNum = cardNum;
        this.pinNum = pinNum;
        addGuiComponents();
        setUndecorated(true);
    }

    private void addGuiComponents() {

        ImageIcon imgIcon = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        JLabel atmImgIcon = new JLabel(imgIcon);
        atmImgIcon.setSize(900,980);
        add(atmImgIcon);

        //Select transaction Label
        JLabel selectTransactionLabel = new JLabel("Please Select your Transaction");
        selectTransactionLabel.setBounds(210,300,700,35);
        selectTransactionLabel.setForeground(Color.white);
        selectTransactionLabel.setFont(new Font("Raleway",Font.BOLD,16));
        atmImgIcon.add(selectTransactionLabel);

        //Deposit label
        JLabel depositLabel = new JLabel("Deposit");
        depositLabel.setBounds(160,455,75,25);
        depositLabel.setForeground(Color.yellow);
        depositLabel.setFont(new Font("Raleway",Font.BOLD,18));
        depositLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        depositLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                TransactionsPage.this.dispose();
                new Deposit(cardNum,pinNum).setVisible(true);
            }
        });
        atmImgIcon.add(depositLabel);

        //Cash Withdrawl label
        JLabel cashWithdrawlLabel = new JLabel("Cash Withdrawl");
        cashWithdrawlLabel.setBounds(355,455,140,25);
        cashWithdrawlLabel.setForeground(Color.yellow);
        cashWithdrawlLabel.setFont(new Font("Raleway",Font.BOLD,18));
        cashWithdrawlLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        cashWithdrawlLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                TransactionsPage.this.dispose();
                new Withdrawl(cardNum,pinNum).setVisible(true);
            }
        });
        atmImgIcon.add(cashWithdrawlLabel);

        //Fast Cash label
        JLabel fastCashLabel = new JLabel("Fast Cash");
        fastCashLabel.setBounds(160,495,90,25);
        fastCashLabel.setForeground(Color.yellow);
        fastCashLabel.setFont(new Font("Raleway",Font.BOLD,18));
        fastCashLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        atmImgIcon.add(fastCashLabel);

        //Mini statement label
        JLabel miniStatementLabel = new JLabel("Mini Statement");
        miniStatementLabel.setBounds(355,495,140,25);
        miniStatementLabel.setForeground(Color.yellow);
        miniStatementLabel.setFont(new Font("Raleway",Font.BOLD,18));
        miniStatementLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        atmImgIcon.add(miniStatementLabel);

        //Pin Change label
        JLabel pinChangeLabel = new JLabel("Pin Change");
        pinChangeLabel.setBounds(160,535,105,25);
        pinChangeLabel.setForeground(Color.yellow);
        pinChangeLabel.setFont(new Font("Raleway",Font.BOLD,18));
        pinChangeLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        atmImgIcon.add(pinChangeLabel);

        //Balance Inquiry label
        JLabel balanceInquiryLabel = new JLabel("Balance Inquiry");
        balanceInquiryLabel.setBounds(355,535,145,25);
        balanceInquiryLabel.setForeground(Color.yellow);
        balanceInquiryLabel.setFont(new Font("Raleway",Font.BOLD,18));
        balanceInquiryLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        atmImgIcon.add(balanceInquiryLabel);

        //Log Out label
        JLabel logOutLabel = new JLabel("Log Out");
        logOutLabel.setBounds(355,575,80,25);
        logOutLabel.setForeground(Color.yellow);
        logOutLabel.setFont(new Font("Raleway",Font.BOLD,18));
        logOutLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        logOutLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                TransactionsPage.this.dispose();
                new LoginForm().setVisible(true);
            }
        });
        atmImgIcon.add(logOutLabel);
    }
}
