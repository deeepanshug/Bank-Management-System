package gui;

import database.JDBC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterFormTwo extends Frame{

    JRadioButton yes, no, seniorYes, seniorNo, existingYes, existingNo;
    JTextField aadhaarTextField, panNumTextField;
    JComboBox religionCombo, categoryCombo, incomeCombo, educationalCombo, occupationalCombo;
    JButton submitButton;
    public static String religion, category, income, education, occupation, panNum, aadhaar, senior, existingAccount;
    long formNum = 0;

    public RegisterFormTwo(long formNum) {
        super("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        setSize(850,800);
        setLocationRelativeTo(null);
        this.formNum = formNum;
        addGuiComponents();
    }

    private void addGuiComponents() {

        getContentPane().setBackground(Color.WHITE);

        //Form label
        JLabel formNo = new JLabel("Application Form No : " + formNum);
        formNo.setBounds(140,20,600,40);
        formNo.setFont(new Font("Raleway",Font.BOLD,38));
        add(formNo);

        //Additional details label
        JLabel additionalDetails = new JLabel("Page Two : Additional Details");
        additionalDetails.setBounds(250,80,400,30);
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        add(additionalDetails);

        //Religion label
        JLabel religionLabel = new JLabel("Religion : ");
        religionLabel.setBounds(100,140,100,30);
        religionLabel.setFont(new Font("Raleway",Font.BOLD,20));
        add(religionLabel);

        String[] religionsArray = {"-","Sanatan", "Sikhism", "Jainism", "Budhism", "Judaism", "Christianity"};
        religionCombo = new JComboBox(religionsArray);
        religionCombo.setBounds(300,140,400,30);
        religionCombo.setBackground(Color.WHITE);
        add(religionCombo);


        //Category label
        JLabel categoryLabel = new JLabel("Category : ");
        categoryLabel.setBounds(100,190,200,30);
        categoryLabel.setFont(new Font("Raleway",Font.BOLD,20));
        add(categoryLabel);

        String[] categoryArray = {"-","General", "OBC", "SC", "ST", "Other"};
        categoryCombo = new JComboBox(categoryArray);
        categoryCombo.setBounds(300,190,400,30);
        categoryCombo.setBackground(Color.WHITE);
        add(categoryCombo);


        //income label
        JLabel incomeLabel = new JLabel("Income : ");
        incomeLabel.setBounds(100,240,200,30);
        incomeLabel.setFont(new Font("Raleway",Font.BOLD,20));
        add(incomeLabel);

        String[] incomeCategoryArray = {"-", "< 1,50,000", "< 2,50,000", "< 5,00,000", "upto 10,00,000"};
        incomeCombo = new JComboBox(incomeCategoryArray);
        incomeCombo.setBounds(300,240,400,30);
        incomeCombo.setBackground(Color.WHITE);
        add(incomeCombo);

        //Education label
        JLabel educationLabel = new JLabel("Educational ");
        educationLabel.setBounds(100,300,200,30);
        educationLabel.setFont(new Font("Raleway",Font.BOLD,20));
        add(educationLabel);

        //Qualification label
        JLabel qualificationLabel = new JLabel("Qualification : ");
        qualificationLabel.setBounds(100,325,200,30);
        qualificationLabel.setFont(new Font("Raleway",Font.BOLD,20));
        add(qualificationLabel);

        String[] educationCategoryArray = {"-", "Non-Graduate", "Graduate", "Post-Graduation", "Doctorate","Others"};
        educationalCombo = new JComboBox(educationCategoryArray);
        educationalCombo.setBounds(300,312,400,30);
        educationalCombo.setBackground(Color.WHITE);
        add(educationalCombo);

        //Occupation label
        JLabel occupationLabel = new JLabel("Occupation : ");
        occupationLabel.setBounds(100,390,200,30);
        occupationLabel.setFont(new Font("Raleway",Font.BOLD,20));
        add(occupationLabel);

        String[] occupationalCategoryArray = {"-", "Salaried", "Self-Employed", "Business", "Retired","Others"};
        occupationalCombo = new JComboBox(occupationalCategoryArray);
        occupationalCombo.setBounds(300,390,400,30);
        occupationalCombo.setBackground(Color.WHITE);
        add(occupationalCombo);


        //Pan number label
        JLabel panNumLabel = new JLabel("Pan Number : ");
        panNumLabel.setBounds(100,440,200,30);
        panNumLabel.setFont(new Font("Raleway",Font.BOLD,20));
        add(panNumLabel);

        //Pan Num Text field
        panNumTextField = new JTextField();
        panNumTextField.setBounds(300,440,400,30);
        panNumTextField.setFont(new Font("Raleway",Font.BOLD,20));
        add(panNumTextField);

        //Aadhaar label
        JLabel aadhaarLabel = new JLabel("Aadhaar Number : ");
        aadhaarLabel.setBounds(100,490,200,30);
        aadhaarLabel.setFont(new Font("Raleway",Font.BOLD,20));
        add(aadhaarLabel);

        //Aadhaar Text field
        aadhaarTextField = new JTextField();
        aadhaarTextField.setBounds(300,490,400,30);
        aadhaarTextField.setFont(new Font("Raleway",Font.BOLD,20));
        add(aadhaarTextField);

        //Senior label
        JLabel seniorLabel = new JLabel("Senior Citizen : ");
        seniorLabel.setBounds(100,540,200,30);
        seniorLabel.setFont(new Font("Raleway",Font.BOLD,20));
        add(seniorLabel);

        //Senior radio button
        seniorYes = new JRadioButton("Yes");
        seniorYes.setBounds(300,540,100,30);
        seniorYes.setFont(new Font("Raleway",Font.BOLD,20));
        seniorYes.setBackground(Color.WHITE);
        add(seniorYes);

        seniorNo = new JRadioButton("No");
        seniorNo.setBounds(430,540,100,30);
        seniorNo.setFont(new Font("Raleway",Font.BOLD,20));
        seniorNo.setBackground(Color.WHITE);
        add(seniorNo);

        //Senior Button group
        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(seniorYes);
        seniorGroup.add(seniorNo);


        //Existing account label
        JLabel existingAccountLabel = new JLabel("Existing Account : ");
        existingAccountLabel.setBounds(100,590,200,30);
        existingAccountLabel.setFont(new Font("Raleway",Font.BOLD,20));
        add(existingAccountLabel);

        //Existing account radio button
        existingYes = new JRadioButton("Yes");
        existingYes.setBounds(300,590,100,30);
        existingYes.setFont(new Font("Raleway",Font.BOLD,20));
        existingYes.setBackground(Color.WHITE);
        add(existingYes);

        existingNo = new JRadioButton("No");
        existingNo.setBounds(430,590,100,30);
        existingNo.setFont(new Font("Raleway",Font.BOLD,20));
        existingNo.setBackground(Color.WHITE);
        add(existingNo);

        //Button group
        ButtonGroup ExistingAccountGroup = new ButtonGroup();
        ExistingAccountGroup.add(yes);
        ExistingAccountGroup.add(no);

        //Submit button
        submitButton = new JButton("Submit");
        submitButton.setBounds(435,660,160,50);
        submitButton.setBackground(Color.BLACK);
        submitButton.setForeground(Color.WHITE);
        submitButton.setFont(new Font("Raleway",Font.BOLD,30));
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                religion = (String) religionCombo.getSelectedItem();
                category = (String) categoryCombo.getSelectedItem();
                income = (String) incomeCombo.getSelectedItem();
                education = (String) educationalCombo.getSelectedItem();
                occupation = (String) educationalCombo.getSelectedItem();
                panNum = panNumTextField.getText();
                aadhaar = "" + aadhaarTextField.getText();

                if(seniorYes.isSelected()) senior = "Yes";
                else senior = "No";
                if(existingYes.isSelected()) existingAccount = "Yes";
                else existingAccount = "No";


                try{
                    if(religion.equals("-")) JOptionPane.showMessageDialog(RegisterFormTwo.this, "Religion Field cannot be empty.");
                    else if(category.equals("-")) JOptionPane.showMessageDialog(RegisterFormTwo.this, "Category Field cannot be empty.");
                    else if(income.equals("-")) JOptionPane.showMessageDialog(RegisterFormTwo.this, "Income Field cannot be empty.");
                    else if(education.equals("-")) JOptionPane.showMessageDialog(RegisterFormTwo.this, "Education Field cannot be empty.");
                    else if(occupation.equals("-")) JOptionPane.showMessageDialog(RegisterFormTwo.this, "Occupation Field cannot be empty.");
                    else if(panNum.isEmpty()) JOptionPane.showMessageDialog(RegisterFormTwo.this, "Pan Number Field cannot be empty.");
                    else if(aadhaar.isEmpty()) JOptionPane.showMessageDialog(RegisterFormTwo.this, "Aadhaar Number Field cannot be empty.");
                    else {

                        JDBC.registerFormTwoDetails(religion, category, income, education, occupation, panNum, aadhaar, senior, existingAccount,formNum);

                        JOptionPane.showMessageDialog(RegisterFormTwo.this, "User Detail registered Successfully");
                        RegisterFormTwo.this.dispose();
                        new RegisterFormThree(formNum).setVisible(true);
                    }
                }
                catch(Exception se) {
                    se.printStackTrace();
                }
            }
        });
        add(submitButton);
    }
}
