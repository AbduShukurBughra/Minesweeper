package com.bughra;

import javax.swing.*;
import java.awt.*;

public class GameWin extends JFrame {

    MapBottom mapBottom = new MapBottom();
    void launch(){
        this.setVisible(true);
        this.setSize(500, 500);
        this.setLocale(null);
        this.setTitle("مىنا تازلاش ئويۇنى");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g) {
        mapBottom.paintSelf(g);
    }

    public static void main(String[] args) {
        GameWin gameWin = new GameWin();
        gameWin.launch();
    }
}
