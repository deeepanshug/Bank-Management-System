package gui;

import com.toedter.calendar.JDateChooser;
import database.JDBC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterFormOne extends Frame{

    String accountNo;
    JTextField nameTextField, fathersNameTextField, emailTextField, addressTextField, cityTextField, stateTextField, pincodeTextField;
    JRadioButton male,female,married,unmarried;
    JDateChooser dateChooser;
    JButton nextButton;
    public static int num = 1001;

    public RegisterFormOne() {

        super("NEW ACCOUNT APPLICATION FORM - PAGE 1");
        setSize(850,800);
        setLocationRelativeTo(null);
        addGuiComponents();
    }

    private void addGuiComponents() {

        getContentPane().setBackground(Color.WHITE);

        //Form label
        JLabel accountNum = new JLabel("Application Account No : " + num);
        accountNum.setBounds(140,20,600,40);
        accountNum.setFont(new Font("Raleway",Font.BOLD,38));
        add(accountNum);

        //Personal details label
        JLabel personalDetails = new JLabel("Page one : Personal Details");
        personalDetails.setBounds(250,80,400,30);
        personalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        add(personalDetails);

        //Name label
        JLabel name = new JLabel("Name : ");
        name.setBounds(100,140,100,30);
        name.setFont(new Font("Raleway",Font.BOLD,20));
        add(name);

        //Name Text field
        nameTextField = new JTextField();
        nameTextField.setBounds(300,140,400,30);
        nameTextField.setFont(new Font("Raleway",Font.BOLD,20));
        add(nameTextField);

        //Father's Name label
        JLabel fName = new JLabel("Father's Name : ");
        fName.setBounds(100,190,200,30);
        fName.setFont(new Font("Raleway",Font.BOLD,20));
        add(fName);

        //Father's Name Text field
        fathersNameTextField = new JTextField();
        fathersNameTextField.setBounds(300,190,400,30);
        fathersNameTextField.setFont(new Font("Raleway",Font.BOLD,20));
        add(fathersNameTextField);

        //D.O.B label
        JLabel dob = new JLabel("D.O.B : ");
        dob.setBounds(100,240,200,30);
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        add(dob);

        //Dob selection
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,240,400,30);
        dateChooser.setFont(new Font("Raleway",Font.BOLD,20));
        add(dateChooser);

        //gender label
        JLabel gender = new JLabel("Gender : ");
        gender.setBounds(100,290,200,30);
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        add(gender);

        //male radio button
        male = new JRadioButton("Male");
        male.setBounds(300,290,100,30);
        male.setFont(new Font("Raleway",Font.BOLD,20));
        male.setBackground(Color.WHITE);
        add(male);

        //female radio button
        female = new JRadioButton("Female");
        female.setBounds(410,290,100,30);
        female.setFont(new Font("Raleway",Font.BOLD,20));
        female.setBackground(Color.WHITE);
        add(female);

        //Button group
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        //email label
        JLabel email = new JLabel("Email : ");
        email.setBounds(100,340,200,30);
        email.setFont(new Font("Raleway",Font.BOLD,20));
        add(email);

        //Email Text field
        emailTextField = new JTextField();
        emailTextField.setBounds(300,340,400,30);
        emailTextField.setFont(new Font("Raleway",Font.BOLD,20));
        add(emailTextField);

        //marital label
        JLabel marital = new JLabel("Marital : ");
        marital.setBounds(100,390,200,30);
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        add(marital);

        //married radio button
        married = new JRadioButton("Married");
        married.setBounds(300,390,120,30);
        married.setFont(new Font("Raleway",Font.BOLD,20));
        married.setBackground(Color.WHITE);
        add(married);

        //unmarried radio button
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(430,390,150,30);
        unmarried.setFont(new Font("Raleway",Font.BOLD,20));
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        //Button group
        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);

        //address label
        JLabel address = new JLabel("Address : ");
        address.setBounds(100,440,200,30);
        address.setFont(new Font("Raleway",Font.BOLD,20));
        add(address);

        //address Text field
        addressTextField = new JTextField();
        addressTextField.setBounds(300,440,400,30);
        addressTextField.setFont(new Font("Raleway",Font.BOLD,20));
        add(addressTextField);

        //city label
        JLabel city = new JLabel("City : ");
        city.setBounds(100,490,200,30);
        city.setFont(new Font("Raleway",Font.BOLD,20));
        add(city);

        //city Text field
        cityTextField = new JTextField();
        cityTextField.setBounds(300,490,400,30);
        cityTextField.setFont(new Font("Raleway",Font.BOLD,20));
        add(cityTextField);

        //state label
        JLabel state = new JLabel("State : ");
        state.setBounds(100,540,200,30);
        state.setFont(new Font("Raleway",Font.BOLD,20));
        add(state);

        //state Text field
        stateTextField = new JTextField();
        stateTextField.setBounds(300,540,400,30);
        stateTextField.setFont(new Font("Raleway",Font.BOLD,20));
        add(stateTextField);

        //pincode label
        JLabel pincode = new JLabel("Pincode : ");
        pincode.setBounds(100,590,200,30);
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        add(pincode);

        //pincode Text field
        pincodeTextField = new JTextField();
        pincodeTextField.setBounds(300,590,400,30);
        pincodeTextField.setFont(new Font("Raleway",Font.BOLD,20));
        add(pincodeTextField);

        //Next button
        nextButton = new JButton("Next");
        nextButton.setBounds(435,660,120,50);
        nextButton.setBackground(Color.BLACK);
        nextButton.setForeground(Color.WHITE);
        nextButton.setFont(new Font("Raleway",Font.BOLD,30));
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                accountNo = "" + num;
                String name = nameTextField.getText();
                String fatherName = fathersNameTextField.getText();
                String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
                String email = emailTextField.getText();
                String address = addressTextField.getText();
                String city = cityTextField.getText();
                String state = stateTextField.getText();
                String pincode = pincodeTextField.getText();

                String gender = null;
                if(male.isSelected()) gender = "Male";
                else gender = "Female";
                String marital = null;
                if(married.isSelected()) marital = "Married";
                else marital = "Unmarried";

                try{
                    if(name.isEmpty()) JOptionPane.showMessageDialog(RegisterFormOne.this, "Name Field cannot be empty.");
                    else if(fatherName.isEmpty()) JOptionPane.showMessageDialog(RegisterFormOne.this, "Father's Name Field cannot be empty.");
                    else if(dob.isEmpty()) JOptionPane.showMessageDialog(RegisterFormOne.this, "D.O.B Field cannot be empty.");
                    else if(email.isEmpty()) JOptionPane.showMessageDialog(RegisterFormOne.this, "Email Field cannot be empty.");
                    else if(address.isEmpty()) JOptionPane.showMessageDialog(RegisterFormOne.this, "Address Field cannot be empty.");
                    else if(city.isEmpty()) JOptionPane.showMessageDialog(RegisterFormOne.this, "City Field cannot be empty.");
                    else if(state.isEmpty()) JOptionPane.showMessageDialog(RegisterFormOne.this, "State Field cannot be empty.");
                    else if(pincode.isEmpty()) JOptionPane.showMessageDialog(RegisterFormOne.this, "Pin code Field cannot be empty.");
                    else {

                        if(JDBC.checkIfUserExists(name, fatherName, email, pincode, gender)) {

                            //If user Exists then no need to continue Just login your existing account.
                            JOptionPane.showMessageDialog(RegisterFormOne.this, "Error: User Already Exists! \n" +
                                    "Please Login");
                            RegisterFormOne.this.dispose();
                            new LoginForm().setVisible(true);
                        }
                        else {
                            JDBC.registerFormOneDetails(accountNo,name,fatherName,dob,email,address,city,state,pincode,gender,marital);
                            num++;
                            //Register form one filling is done now user will move to form two
                            RegisterFormOne.this.dispose();
                            new RegisterFormTwo(accountNo).setVisible(true);
                        }
                    }
                }
                catch(Exception se) {
                    se.printStackTrace();
                }
            }
        });
        add(nextButton);
    }
}
