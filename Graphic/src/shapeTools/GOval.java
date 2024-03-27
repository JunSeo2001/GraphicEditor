package shapeTools;

import java.awt.*;

public class GOval extends GShape {

    @Override
    public void draw(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setXORMode(graphics2D.getBackground());
        //erase old shape
        graphics.drawOval(x1, y1, ox2 - x1, oy2 - y1);
        //draw new shape
        graphics.drawOval(x1, y1, x2 - x1, y2 - y1);
    }
    @Override
    public void redraw(Graphics graphics) {
        graphics.drawOval(x1, y1, x2 - x1, y2 - y1);
        System.out.println("그림");
    }

}
