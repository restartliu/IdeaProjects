package com.gui.ui;

import javax.swing.*;

public class InitUI {
    private JFrame frame;

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public void aggregationAll(){
        this.frame.setVisible(true);
    }
}
