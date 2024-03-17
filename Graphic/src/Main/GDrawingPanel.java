package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList; // 수정된 부분
import java.util.List;

public class GDrawingPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private String selectedShape = null;
    private GShape selectedShapeObject = null;
    private int startX, startY, endX, endY;
    private List<Point> polygonPoints = new ArrayList<>();


    public GDrawingPanel(){
        this.setBackground(Color.gray);
        MouseEventHandler mouseEventHandler = new MouseEventHandler();
        this.addMouseListener(mouseEventHandler);
        this.addMouseMotionListener(mouseEventHandler);
    }

    public void paint(Graphics graphics){

    }
    private void draw(int x, int y, int x2, int y2){
        Graphics graphics = this.getGraphics();
        Graphics2D g2d = (Graphics2D) graphics;

        if (selectedShape != null) {
            switch (selectedShape){
                case "Rectangle":
                    graphics.drawRect(x, y, x2 - x, y2 - y);
                    break;
                case "Oval":
                    graphics.drawOval(x, y, x2 - x, y2 - y);
                    break;
                case "Line":
                    graphics.drawLine(x, y, x2, y2);
                    break;
                case "Polygon":
                    // 다각형 그리기
                    int[] xPoints = new int[polygonPoints.size()];
                    int[] yPoints = new int[polygonPoints.size()];
                    for (int i = 0; i < polygonPoints.size(); i++) {
                        Point point = polygonPoints.get(i);
                        xPoints[i] = (int) point.getX();
                        yPoints[i] = (int) point.getY();
                    }
                    int nPoints = polygonPoints.size();
                    g2d.drawPolygon(xPoints, yPoints, nPoints);
                    break;
                default:
                    break;
            }
        }
    }

    public void setSelectedShape(String shape) {
        this.selectedShape = shape;
    }


        private class MouseEventHandler implements MouseListener, MouseMotionListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            printMethodName();
        }

        @Override
        public void mousePressed(MouseEvent e) {
            printMethodName();
            startX = e.getX();
            startY = e.getY();

            if ("Polygon".equals(selectedShape)) {
                polygonPoints.add(new Point(startX, startY));
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            printMethodName();
            endX = e.getX();
            endY = e.getY();
            draw(startX,startY,endX,endY);
        }
        @Override
        public void mouseDragged(MouseEvent e) {
            printMethodName();


        }

        @Override
        public void mouseMoved(MouseEvent e) {
            printMethodName();
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
        private void printMethodName() {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace.length > 2) {
                String methodName = stackTrace[2].getMethodName();
                System.out.println(methodName);
            }
        }
    }
}

