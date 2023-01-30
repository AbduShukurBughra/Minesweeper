package com.bughra;

import java.awt.*;

public class MapTop {

    int temp_x;
    int temp_y;

    //judgment logic
    void logic() {

        temp_x = 0;
        temp_y = 0;
        if (GameUtil.MOUSE_X > GameUtil.OFFSET && GameUtil.MOUSE_Y > 3 * GameUtil.OFFSET) {
            temp_x = (GameUtil.MOUSE_X - GameUtil.OFFSET) / GameUtil.SQUARE_LENGTH + 1;
            temp_y = (GameUtil.MOUSE_Y - GameUtil.OFFSET * 3) / GameUtil.SQUARE_LENGTH + 1;
        }
        if (temp_x >= 1 && temp_x <= GameUtil.MAP_W
                && temp_y >= 1 && temp_y <= GameUtil.MAP_H) {
            if (GameUtil.LEFT_BUTTON) {
                //覆盖，则翻开
                if (GameUtil.DATA_TOP[temp_x][temp_y] == 0) {
                    GameUtil.DATA_TOP[temp_x][temp_y] = -1;
                }
                spaceOpen(temp_x, temp_y);
                GameUtil.LEFT_BUTTON = false;
            }
            if (GameUtil.RIGHT_BUTTON) {
                //覆盖则插旗
                if (GameUtil.DATA_TOP[temp_x][temp_y] == 0) {
                    GameUtil.DATA_TOP[temp_x][temp_y] = 1;
                }
                //插旗则取消
                else if (GameUtil.DATA_TOP[temp_x][temp_y] == 1) {
                    GameUtil.DATA_TOP[temp_x][temp_y] = 0;
                }
                else if (GameUtil.DATA_TOP[temp_x][temp_y] ==-1){
                    numOpen(temp_x, temp_y);
                }
                GameUtil.RIGHT_BUTTON = false;
            }
        }
        boom();
    }

    void numOpen(int x, int y) {
        int count = 0;
        if (GameUtil.DATA_BOTTOM[x][y] > 0) {
            for (int i = x - 1; i <= x + 1; i++) {
                for (int j = y - 1; j <= y + 1; j++) {
                    if (GameUtil.DATA_TOP[i][j]==1) {
                        count++;
                    }
                }
            }
            if (count == GameUtil.DATA_BOTTOM[x][y]) {
                for (int i = x - 1; i <= x + 1; i++) {
                    for (int j = y - 1; j <= y + 1; j++) {
                        if (GameUtil.DATA_TOP[i][j]!=1){
                            GameUtil.DATA_TOP[i][j] =-1;
                        }
                        //必须在雷区当中
                        if (i >= 1 && j >= 1 && i <= GameUtil.MAP_W && j <= GameUtil.MAP_H) {
                            spaceOpen(i, j);
                        }

                    }
                }
            }

        }
    }

    //失败判定 ture - 失败  false - 未失败
    boolean boom() {
        for (int i = 1; i <=GameUtil.MAP_W; i++) {
            for (int j = 1; j <= GameUtil.MAP_H; j++) {
                if (GameUtil.DATA_BOTTOM[i][j]==-1 && GameUtil.DATA_TOP[i][j]==-1) {
                    System.out.println("Game Over!");
                    return true;
                }
            }
        }
        return false;
    }

    void spaceOpen(int x, int y) {
        if (GameUtil.DATA_BOTTOM[x][y] == 0) {
            for (int i = x - 1; i <= x + 1; i++) {
                for (int j = y - 1; j <= y + 1; j++) {
                    //覆盖，才递归
                    if (GameUtil.DATA_TOP[i][j] != -1) {
                        GameUtil.DATA_TOP[i][j] = -1;
                        //必须在雷区当中
                        if (i >= 1 && j >= 1 && i <= GameUtil.MAP_W && j <= GameUtil.MAP_H) {
                            spaceOpen(i, j);
                        }
                    }
                }
            }
        }
    }

    //drawing method
    void paintSelf(Graphics g) {
        logic();
        for (int i = 1; i <= GameUtil.MAP_W; i++) {
            for (int j = 1; j <= GameUtil.MAP_H; j++) {
                //覆盖
                if (GameUtil.DATA_TOP[i][j] == 0) {
                    g.drawImage(GameUtil.top,
                            GameUtil.OFFSET + (i - 1) * GameUtil.SQUARE_LENGTH + 1,
                            GameUtil.OFFSET * 3 + (j - 1) * GameUtil.SQUARE_LENGTH + 1,
                            GameUtil.SQUARE_LENGTH - 2,
                            GameUtil.SQUARE_LENGTH - 2,
                            null);
                }
                //flag
                if (GameUtil.DATA_TOP[i][j] == 1) {
                    g.drawImage(GameUtil.flag,
                            GameUtil.OFFSET + (i - 1) * GameUtil.SQUARE_LENGTH + 1,
                            GameUtil.OFFSET * 3 + (j - 1) * GameUtil.SQUARE_LENGTH + 1,
                            GameUtil.SQUARE_LENGTH - 2,
                            GameUtil.SQUARE_LENGTH - 2,
                            null);
                }
                //noflag
                if (GameUtil.DATA_TOP[i][j] == 2) {
                    g.drawImage(GameUtil.noflag,
                            GameUtil.OFFSET + (i - 1) * GameUtil.SQUARE_LENGTH + 1,
                            GameUtil.OFFSET * 3 + (j - 1) * GameUtil.SQUARE_LENGTH + 1,
                            GameUtil.SQUARE_LENGTH - 2,
                            GameUtil.SQUARE_LENGTH - 2,
                            null);
                }
            }
        }
    }
}
