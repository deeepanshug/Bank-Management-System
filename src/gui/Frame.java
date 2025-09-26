package gui;

import javax.swing.*;

public class Frame extends JFrame {

    public Frame(String title) {

        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,480);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);

    }
}
