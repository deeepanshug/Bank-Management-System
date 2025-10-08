import gui.LoginForm;
import gui.Withdrawl;

import javax.swing.*;

public class Launch {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

//                new LoginForm().setVisible(true);
                new Withdrawl("123","13").setVisible(true);
            }
        });
    }
}
