import gui.LoginForm;
import gui.TransactionsPage;

import javax.swing.*;

public class Launch {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                new LoginForm().setVisible(true);
//                new TransactionsPage().setVisible(true);
            }
        });
    }
}
