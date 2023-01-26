package com.bughra;

import java.awt.*;

public class GameUtil {
    static int RAY_MAX = 5;
    static int MAP_W = 11;
    static int MAP_H = 11;
    static int OFFSET = 45;
    static int SQUARE_LENGTH = 50;

    //mouse coordinates
    static int MOUSE_X ;
    static int MOUSE_Y ;
    //
    static boolean LEFT_BUTTON=false;
    static boolean RIGHT_BUTTON=false;


    //底层元素 -1 雷 0 空 1~8 表示对应数字
    static int[][] DATA_BOTTOM = new int[MAP_W + 2][MAP_H + 2];
    //顶层元素 -1 无覆盖 0 覆盖 1 插旗 2 差错旗
    static int[][] DATA_TOP = new int[MAP_W + 2][MAP_H + 2];

    //载入图片
    static Image mine = Toolkit.getDefaultToolkit().getImage("images/mine.png");
    static Image top = Toolkit.getDefaultToolkit().getImage("images/top.png");
    static Image flag = Toolkit.getDefaultToolkit().getImage("images/flag.png");
    static Image noflag = Toolkit.getDefaultToolkit().getImage("images/noflag.png");

    static Image[] images = new Image[9];

    static {
        for (int i = 1; i < 9; i++) {
            images[i] = Toolkit.getDefaultToolkit()
                    .getImage("images/num/" + i + ".png");
        }
    }

}
