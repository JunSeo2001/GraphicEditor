package Main;

import java.awt.*;


public class GShape {
    private int startX, startY, endX, endY;

    public GShape(int startX, int startY, int endX, int endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    public void draw(Graphics g) {
        int width = Math.abs(endX - startX);
        int height = Math.abs(endY - startY);
        int x = Math.min(startX, endX);
        int y = Math.min(startY, endY);
        g.drawRect(x, y, width, height);
    }

    public boolean contains(int x, int y) {
        return x >= startX && x <= endX && y >= startY && y <= endY;
    }

    public void move(int deltaX, int deltaY) {
        startX += deltaX;
        endX += deltaX;
        startY += deltaY;
        endY += deltaY;
    }
}
