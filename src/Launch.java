import gui.LoginFrame;

import javax.swing.*;

public class Launch {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                new LoginFrame().setVisible(true);
                System.out.println("print");
            }
        });
    }
}
