import database.JDBC;
import gui.RegisterFormOne;

import javax.swing.*;

public class Launch {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

//                new LoginFrame().setVisible(true);
                new RegisterFormOne().setVisible(true);

//                if(JDBC.register("1","test","defghi","dob", "email","address","new delhi", "delhi","110030", "male","Unmarried")) {
//
//                    System.out.println("Insertion successfully");
//                }
            }
        });
    }
}
