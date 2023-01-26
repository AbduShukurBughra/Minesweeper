package com.bughra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameWin extends JFrame {
    int width = 2*GameUtil.OFFSET+GameUtil.MAP_W*GameUtil.SQUARE_LENGTH;
    int height = 4*GameUtil.OFFSET+GameUtil.MAP_H*GameUtil.SQUARE_LENGTH;
    Image offScreenImage = null;

    MapBottom mapBottom = new MapBottom();
    MapTop mapTop = new MapTop();
    void launch(){
        this.setVisible(true);
        this.setSize(width, height);
        this.setLocale(null);
        this.setTitle("مىنا تازلاش ئويۇنى");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //mouse event
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getButton() ==1){
                    GameUtil.MOUSE_X=e.getX();
                    GameUtil.MOUSE_Y=e.getY();
                    GameUtil.LEFT_BUTTON=true;
                }if (e.getButton() ==3){
                    GameUtil.MOUSE_X=e.getX();
                    GameUtil.MOUSE_Y=e.getY();
                    GameUtil.RIGHT_BUTTON=true;
                }
            }
        });


        while (true) {
            repaint();
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        offScreenImage = this.createImage(width, height);
        Graphics gImage = offScreenImage.getGraphics();
        // Draw background
        gImage.setColor(Color.BLUE);
        gImage.fillRect(0, 0, width, height);

        mapBottom.paintSelf(gImage);
        mapTop.paintSelf(gImage);
        g.drawImage(offScreenImage,0,0,null);
    }

    public static void main(String[] args) {
        GameWin gameWin = new GameWin();
        gameWin.launch();
    }
}
