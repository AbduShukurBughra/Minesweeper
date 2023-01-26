package com.bughra;

import javax.swing.*;
import java.awt.*;

public class GameWin extends JFrame {
    int width = 2*GameUtil.OFFSET+GameUtil.MAP_W*GameUtil.SQUARE_LENGTH;
    int height = 4*GameUtil.OFFSET+GameUtil.MAP_H*GameUtil.SQUARE_LENGTH;

    MapBottom mapBottom = new MapBottom();
    void launch(){
        this.setVisible(true);
        this.setSize(width, height);
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
