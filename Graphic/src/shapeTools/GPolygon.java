package shapeTools;

import java.awt.*;

public class GPolygon extends GNPShapeTool {

//    private List<Point> points = new ArrayList<>(); // 다각형의 꼭지점 좌표를 저장할 리스트
//    private int aX[];
//    private int aY[];
//    private int pointIndex;


    public GPolygon() {
        super(EDrawingStyly.eNPStyle);
//        this.aX = new int[Constants.NUM_POINTS];
//        this.aY = new int[Constants.NUM_POINTS];
//        this.pointIndex = 0;
    }

    @Override
    public void draw(Graphics graphics) {
//        graphics.drawPolygon(aX, aY, pointIndex);
//
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
        graphics.drawPolyline(aX, aY, pointIndex);
    }

//    public void setPoints(List<Point> points) {
//        this.points = points;
//        System.out.println(points);
//    }
    public GShapeTool clone() {
        return new GPolygon();
    }


//    public void setOrigin(int x, int y){
//        this.aX[pointIndex] = x;
//        this.aY[pointIndex] = y;
//
//        this.pointIndex++;
//
//        this.aX[pointIndex] = x;
//        this.aY[pointIndex] = y;
//    }
//
//    public void movePoint(int x2, int y2){
//        this.aX[pointIndex] = x1;
//        this.aY[pointIndex] = y1;
//    }
//
//    public void addPoint(int x2, int y2) {
//        this.pointIndex++;
//        this.aX[pointIndex] = x2;
//        this.aY[pointIndex] = y2;
//    }
}
