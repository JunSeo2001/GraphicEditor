package shapeTools;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RectangularShape;

import shapeTools.GShape.EDrawingStyle;

public class GOval extends GShape {
    public GOval() {
        super(EDrawingStyle.e2PStyle, new Ellipse2D.Float());
    }
    public GOval clone() {
        return new GOval();
    }
    @Override
    public void drag(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setXORMode(graphics2D.getBackground());

        RectangularShape shape = (RectangularShape)this.shape;
        shape.setFrame(x1, y1, ox2-x1, oy2-y1);
        graphics2D.draw(shape);
        shape.setFrame(x1, y1, x2-x1, y2-y1);
        graphics2D.draw(shape);
    }

    @Override
    public void updateShape() {
        RectangularShape shape = (RectangularShape) this.shape;
        shape.setFrame(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
        updateAnchors();
    }
}
