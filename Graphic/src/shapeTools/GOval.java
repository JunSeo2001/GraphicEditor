package shapeTools;

import java.awt.*;

public class GOval extends G2PShapeTool {

    public GOval() {
        super(EDrawingStyly.e2PStyle);
    }

    @Override
    public void draw(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setXORMode(graphics2D.getBackground());
        //erase old shape
        graphics2D.drawOval(x1, y1, ox2 - x1, oy2 - y1);
        //draw new shape
        graphics2D.drawOval(x1, y1, x2 - x1, y2 - y1);
    }
    @Override
    public void redraw(Graphics graphics) {
        graphics.drawOval(x1, y1, x2 - x1, y2 - y1);
    }

    public GShapeTool clone() {
        return new GOval();
    }
}
