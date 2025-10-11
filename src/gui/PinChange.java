package gui;

import database.JDBC;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends Frame implements ActionListener {

    long cardNum,pinNum;
    JButton cancelButton,changeButton;
    JPasswordField newPinPasswordField, reEnterNewPinPasswordField;

    public PinChange(long cardNum, long pinNum) {

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

        //pin change Label
        JLabel selectTransactionLabel = new JLabel("CHANGE YOUR PIN");
        selectTransactionLabel.setBounds(250,300,500,35);
        selectTransactionLabel.setForeground(Color.white);
        selectTransactionLabel.setFont(new Font("Raleway",Font.BOLD,16));
        atmImgIcon.add(selectTransactionLabel);

        //New pin Label
        JLabel pinLabel = new JLabel("New Pin :");
        pinLabel.setBounds(165,370,180,25);
        pinLabel.setForeground(Color.white);
        pinLabel.setFont(new Font("Raleway",Font.BOLD,16));
        atmImgIcon.add(pinLabel);

        //New pin Text Field
        newPinPasswordField = new JPasswordField();
        newPinPasswordField.setBounds(330,370,180,25);
        newPinPasswordField.setFont(new Font("Raleway",Font.BOLD,16));
        newPinPasswordField.setDocument(new PlainDocument() {
            public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
                if (str == null || getLength() + str.length() <= 4) {
                    super.insertString(offset, str, attr);
                }
            }
        });
        atmImgIcon.add(newPinPasswordField);

        //Re-enter pin Label
        JLabel reEnterLabel = new JLabel("Re-Enter New Pin :");
        reEnterLabel.setBounds(165,410,180,25);
        reEnterLabel.setForeground(Color.white);
        reEnterLabel.setFont(new Font("Raleway",Font.BOLD,16));
        atmImgIcon.add(reEnterLabel);

        //Re Enter New pin Text Field
        reEnterNewPinPasswordField = new JPasswordField();
        reEnterNewPinPasswordField.setBounds(330,410,180,25);
        reEnterNewPinPasswordField.setFont(new Font("Raleway",Font.BOLD,16));
        reEnterNewPinPasswordField.setDocument(new PlainDocument() {
            public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
                if (str == null || getLength() + str.length() <= 4) {
                    super.insertString(offset, str, attr);
                }
            }
        });
        atmImgIcon.add(reEnterNewPinPasswordField);

        //cancel button
        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(230,525,100,40);
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFont(new Font("Raleway",Font.BOLD,18));
        cancelButton.addActionListener(this);
        atmImgIcon.add(cancelButton);

        //Change button
        changeButton = new JButton("Change");
        changeButton.setBounds(350,525,120,40);
        changeButton.setBackground(Color.BLACK);
        changeButton.setForeground(Color.WHITE);
        changeButton.setFont(new Font("Raleway",Font.BOLD,18));
        changeButton.addActionListener(this);
        atmImgIcon.add(changeButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String pin = new String(newPinPasswordField.getPassword());
        String rePin = new String(reEnterNewPinPasswordField.getPassword());
        String command = e.getActionCommand();

        if(command.equals("Cancel")) {
            PinChange.this.dispose();
            new TransactionsPage(cardNum,pinNum).setVisible(true);
        }
        else if(pin.equals(rePin) && command.equals("Change")) {
            long newPin = Long.parseLong(pin);

            JDBC.pinChange(cardNum,newPin);
            JOptionPane.showMessageDialog(null,"Your Pin is now Changed");
            PinChange.this.dispose();
            new LoginForm().setVisible(true);
        }
        else {
            JOptionPane.showMessageDialog(null,"Your Entered Wrong Pin.\n" +
                    "Try Again");
            newPinPasswordField.setText("");
            reEnterNewPinPasswordField.setText("");
        }
    }
}
