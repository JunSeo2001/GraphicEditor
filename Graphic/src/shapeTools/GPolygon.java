package shapeTools;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GPolygon extends GShape {

    private List<Point> points = new ArrayList<>(); // 다각형의 꼭지점 좌표를 저장할 리스트

    public GPolygon() {
        super(EDrawingStyly.eNPStyle);
    }

    @Override
    public void draw(Graphics graphics) {
        if (points.size() > 1) {
            int[] xPoints = new int[points.size()];
            int[] yPoints = new int[points.size()];
            for (int i = 0; i < points.size(); i++) {
                Point point = points.get(i);
                xPoints[i] = point.x;
                yPoints[i] = point.y;
            }
            graphics.drawPolyline(xPoints, yPoints, points.size());
        }

    }

    @Override
    public void redraw(Graphics graphics) {
        if (points.size() > 1) {
            int[] xPoints = new int[points.size()];
            int[] yPoints = new int[points.size()];
            for (int i = 0; i < points.size(); i++) {
                Point point = points.get(i);
                xPoints[i] = point.x;
                yPoints[i] = point.y;
            }
            graphics.drawPolyline(xPoints, yPoints, points.size());
        }
    }

    public void setPoints(List<Point> points) {
        this.points = points;
        System.out.println(points);
    }
    public GShape clone() {
        return new GPolygon();
    }
}
