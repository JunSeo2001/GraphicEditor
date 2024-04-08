package shapeTools;

import java.awt.*;

public class GLine extends G2PShapeTool {

    public GLine() {
        super(EDrawingStyly.e2PStyle);
    }
    @Override

    public void draw(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setXORMode(graphics2D.getBackground());
        //erase old shape
        graphics2D.drawLine(x1, y1, ox2, oy2);
        //draw new shape
        graphics2D.drawLine(x1, y1, x2, y2);
    }

    @Override
    public void redraw(Graphics graphics) {
        graphics.drawLine(x1, y1, x2, y2);
    }

    public GShapeTool clone() {
        return new GLine();
    }
}
