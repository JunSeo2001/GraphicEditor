package shapeTools;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class GAnchor {
    private static final int SIZE = 6; // 앵커 크기
    private Rectangle bounds; // 앵커 경계

    public GAnchor(Point point) {
        int x = point.x - SIZE / 2;
        int y = point.y - SIZE / 2;
        bounds = new Rectangle(x, y, SIZE, SIZE);
    }

    public boolean contains(Point point) {
        return bounds.contains(point);
    }

    public void draw(Graphics g) {
        g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
    }

    public void setLocation(Point point) {
        int x = point.x - SIZE / 2;
        int y = point.y - SIZE / 2;
        bounds.setLocation(x, y);
    }

    public Point getLocation() {
        return new Point(bounds.x + SIZE / 2, bounds.y + SIZE / 2);
    }
}
