package shapeTools;

import java.awt.*;

public class GRectangle extends GShape {

    public GRectangle() {
        super(EDrawingStyly.e2PStyle);
    }
    @Override
    public void draw(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setXORMode(graphics2D.getBackground());
        graphics2D.drawRect(x1, y1, ox2 - x1, oy2 - y1);
        graphics2D.drawRect(x1, y1, x2 - x1, y2 - y1);
    }
    @Override
    public void redraw(Graphics graphics) {
        graphics.drawRect(x1, y1, x2 - x1, y2 - y1);
    }

    public GShape clone() {
        return new GRectangle();

    }


}
