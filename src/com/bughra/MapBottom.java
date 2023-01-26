package com.bughra;

import java.awt.*;

public class MapBottom {
    void paintSelf(Graphics g) {
        g.setColor(Color.red);
        //
        for (int i = 0; i <= GameUtil.MAP_W; i++) {
            g.drawLine(GameUtil.OFFSET + i * GameUtil.SQUARE_LENGTH,
                    3 * GameUtil.OFFSET,
                    GameUtil.OFFSET + i * GameUtil.SQUARE_LENGTH,
                    3 * GameUtil.OFFSET + GameUtil.MAP_H * GameUtil.SQUARE_LENGTH);
        }

        //
        for (int i = 0; i <= GameUtil.MAP_H; i++) {
            g.drawLine(GameUtil.OFFSET,
                    3 * GameUtil.OFFSET + i * GameUtil.SQUARE_LENGTH,
                    GameUtil.OFFSET + GameUtil.MAP_H * GameUtil.SQUARE_LENGTH,
                    3 * GameUtil.OFFSET + i * GameUtil.SQUARE_LENGTH);
        }

        for (int i = 1; i <= GameUtil.MAP_W; i++) {
            for (int j = 1; j <= GameUtil.MAP_H; j++) {
                g.drawImage(GameUtil.mine,
                        GameUtil.OFFSET + (i - 1) * GameUtil.SQUARE_LENGTH + 1,
                        GameUtil.OFFSET * 3 + (j - 1) * GameUtil.SQUARE_LENGTH + 1,
                        GameUtil.SQUARE_LENGTH - 2,
                        GameUtil.SQUARE_LENGTH - 2,
                        null);
            }
        }
    }
}
