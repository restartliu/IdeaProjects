package com.test.base.gui;

import javax.swing.*;

public class MyGui {
    public static void main(String[] args) {
        JFrame login_example = new JFrame("Login Example");
        login_example.setSize(600, 600);
        login_example.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        login_example.add(panel);
        login_example.setVisible(true);
    }
}
