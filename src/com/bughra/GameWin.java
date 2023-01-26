package com.bughra;

import javax.swing.*;
import java.awt.*;

public class GameWin extends JFrame {

    void launch(){
        this.setVisible(true);
        this.setSize(500, 500);
        this.setLocale(null);
        this.setTitle("مىنا تازلاش ئويۇنى");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.red);
        g.drawLine(100,100,100,400);
        g.drawLine(100,100,400,100);
    }

    public static void main(String[] args) {
        GameWin gameWin = new GameWin();
        gameWin.launch();
    }
}
