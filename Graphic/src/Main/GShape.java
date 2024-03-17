package Main;

import java.awt.*;


public class GShape {
    private String shapeType;
    private int startX, startY, endX, endY;
    private Color color;

    public GShape(String shapeType, int startX, int startY, int endX, int endY, Color color) {
        this.shapeType = shapeType;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.color = color;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        switch (shapeType) {
            case "Rectangle":
                g.drawRect(startX, startY, endX - startX, endY - startY);
                break;
            case "Oval":
                g.drawOval(startX, startY, endX - startX, endY - startY);
                break;
            case "Line":
                g.drawLine(startX, startY, endX, endY);
                break;
            // Add more shapes if needed
            default:
                break;
        }
    }

    public void move(int dx, int dy) {
        startX += dx;
        endX += dx;
        startY += dy;
        endY += dy;
    }

    public boolean contains(int x, int y) {
        Rectangle boundingBox = new Rectangle(startX, startY, endX - startX, endY - startY);
        return boundingBox.contains(x, y);
    }
}
