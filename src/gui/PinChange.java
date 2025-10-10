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
    JButton cancelButton,submitButton;
    JTextField newPinTextField, reEnterNewPinTextField;

    public PinChange(long cardNum, long pinNum) {

        super("HDFC");
        setSize(900,980);
        setLocationRelativeTo(null);
        this.cardNum = cardNum;
        this.pinNum = pinNum;
        addGuiComponents();
//        setUndecorated(true);
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
        newPinTextField = new JTextField();
        newPinTextField.setBounds(330,370,180,25);
        newPinTextField.setFont(new Font("Raleway",Font.BOLD,16));
        newPinTextField.setDocument(new PlainDocument() {
            public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
                if (str == null || getLength() + str.length() <= 4) {
                    super.insertString(offset, str, attr);
                }
            }
        });
        atmImgIcon.add(newPinTextField);

        //Re-enter pin Label
        JLabel reEnterLabel = new JLabel("Re-Enter New Pin :");
        reEnterLabel.setBounds(165,410,180,25);
        reEnterLabel.setForeground(Color.white);
        reEnterLabel.setFont(new Font("Raleway",Font.BOLD,16));
        atmImgIcon.add(reEnterLabel);

        //Re Enter New pin Text Field
        reEnterNewPinTextField = new JTextField();
        reEnterNewPinTextField.setBounds(330,410,180,25);
        reEnterNewPinTextField.setFont(new Font("Raleway",Font.BOLD,16));
        reEnterNewPinTextField.setDocument(new PlainDocument() {
            public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
                if (str == null || getLength() + str.length() <= 4) {
                    super.insertString(offset, str, attr);
                }
            }
        });
        atmImgIcon.add(reEnterNewPinTextField);

        //cancel button
        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(230,525,100,40);
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFont(new Font("Raleway",Font.BOLD,18));
        cancelButton.addActionListener(this);
        atmImgIcon.add(cancelButton);

        //submit button
        submitButton = new JButton("Submit");
        submitButton.setBounds(400,525,100,40);
        submitButton.setBackground(Color.BLACK);
        submitButton.setForeground(Color.WHITE);
        submitButton.setFont(new Font("Raleway",Font.BOLD,18));
        submitButton.addActionListener(this);
        atmImgIcon.add(submitButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String pin = newPinTextField.getText();
        String rePin = reEnterNewPinTextField.getText();

        if(pin.equals(rePin)) {
            String command = e.getActionCommand();
            long newPin = Long.parseLong(pin);

            if(command.equals("Submit")) {
                JDBC.pinChange(cardNum,newPin);
                JOptionPane.showMessageDialog(null,"Your Pin is now Changed");
                PinChange.this.dispose();
                new LoginForm().setVisible(true);
            }
            else {
                PinChange.this.dispose();
                new TransactionsPage(cardNum,pinNum).setVisible(true);
            }
        }
        else {
            JOptionPane.showMessageDialog(null,"Your Entered Wrong Pin.\n" +
                    "Try Again");
            newPinTextField.setText("");
            reEnterNewPinTextField.setText("");
        }
    }
}
