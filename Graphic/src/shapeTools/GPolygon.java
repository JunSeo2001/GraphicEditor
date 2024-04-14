package shapeTools;

import java.awt.*;

public class GPolygon extends GNPShapeTool {


    public GPolygon() {
        super(EDrawingStyly.eNPStyle);
    }

    @Override
    public void draw(Graphics graphics) {
//        if (points.size() > 1) {
//            int[] xPoints = new int[points.size()];
//            int[] yPoints = new int[points.size()];
//            for (int i = 0; i < points.size(); i++) {
//                Point point = points.get(i);
//                xPoints[i] = point.x;
//                yPoints[i] = point.y;
//            }
//            graphics.drawPolyline(xPoints, yPoints, points.size());
//        }
//        Graphics2D graphics2D = (Graphics2D) graphics;
//        graphics2D.setXORMode(graphics2D.getBackground());
//        //erase old shape
//        graphics2D.drawPolygon(aX, aY, pointIndex);
        //draw new shape
        graphics.drawPolyline(aX, aY, pointIndex);
    }

    @Override
    public void redraw(Graphics graphics) {
        graphics.drawPolyline(aX, aY, pointIndex);
    }

    public GShapeTool clone() {
        return new GPolygon();
    }
}
