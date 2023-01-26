package com.bughra;

import java.awt.*;

public class GameUtil {
    static int MAP_W=11;
    static int MAP_H=11;
    static int OFFSET=45;
    static int SQUARE_LENGTH=50;

    //底层元素 -1 雷 0 空 1~8 表示对应数字
    static int[][] MAP_BOTTOM = new int[MAP_W+2][MAP_H+2];

    //载入图片
    static Image mine = Toolkit.getDefaultToolkit().getImage("images/mine.png");

}
