import database.JDBC;
import gui.LoginForm;

import javax.swing.*;

public class Launch {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

//                new LoginForm().setVisible(true);
//                String religion, category, income, education, occupation, panNum, aadhaar, senior, existingAccount;String religion, category, income, education, occupation, panNum, aadhaar, senior, existingAccount;

                if(JDBC.register("1","test","defghi","dob", "email","address","new delhi", "delhi","110030", "male","Unmarried",
                        "Sanatan","General","67567","Degree", "Job","1234567890","987654321012", "Yes", "Yes")) {

                    System.out.println("Insertion successfully");
                }
            }
        });
    }
}
