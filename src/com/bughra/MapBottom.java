package com.bughra;

import java.awt.*;

public class MapBottom {
    void paintSelf(Graphics g) {
        for (int i = 0; i < 500; i = i + 50) {
            g.setColor(Color.red);
            g.drawLine(0, i, 500, i);
            g.drawLine(i, 0, i, 500);
        }
    }
}
