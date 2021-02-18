package com.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.im.InputContext;
import java.util.Arrays;

public class WebCommunicateApp {
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("web-communicate");
        mainFrame.setSize(600, 600);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel();
        placeComponents(mainPanel);
        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);
    }

    private static void placeComponents(JPanel panel){
        panel.setLayout(null);
        JLabel userLabel = new JLabel("User:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);
        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);
        JLabel passwordLaBel = new JLabel("Password:");
        passwordLaBel.setBounds(10,50,80,25);
        panel.add(passwordLaBel);
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);
        JButton loginButton = new JButton("login");
        loginButton.setBounds(10, 80, 80, 25);
        loginButton.addMouseListener(mouseListener(userText, passwordText));
        panel.add(loginButton);
    }

    private static MouseListener mouseListener(JTextField username, JPasswordField password){
        MouseListener mouseListen = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                System.out.println("username:"+username.getText()+"  "+"password:"+ Arrays.toString(password.getPassword()).replaceAll("[\\[\\]\\s,]+", ""));
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        };
    return mouseListen;
    }
}