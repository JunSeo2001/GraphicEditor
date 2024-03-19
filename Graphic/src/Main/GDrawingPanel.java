package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class GDrawingPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private String selectedShape = null;
    private GRectangleTool gRectangleTool = null;
    private GOvalTool gOvalTool = null;
    private int startX, startY, endX, endY;
    private List<Point> polygonPoints = new ArrayList<>();
    private String shapetext;


    public GDrawingPanel(){
        this.setBackground(Color.gray);
        MouseEventHandler mouseEventHandler = new MouseEventHandler();
        this.addMouseListener(mouseEventHandler);
        this.addMouseMotionListener(mouseEventHandler);
    }

    public void setShapeText(String shapeText){
        this.shapetext = shapeText;
        System.out.println(shapeText);


    }

    public void paint(Graphics graphics){
        super.paint(graphics);

        if (gRectangleTool != null) {
            gRectangleTool.draw(graphics);
        }
        if (gOvalTool != null) {
            gOvalTool.draw(graphics);
        }

    }
    private void draw(int x, int y, int x2, int y2){
        switch (shapetext) {
            case "Rectangle":
                gRectangleTool = new GRectangleTool(x, y, x2 - x, y2 - y);
                break;
            case "Oval":
                gOvalTool = new GOvalTool(x, y, x2 - x, y2 - y);
                break;
            default:
                break;
        }
        repaint();
    }

    public void setSelectedShape(String shape) {

        this.selectedShape = shape;
    }


        private class MouseEventHandler implements MouseListener, MouseMotionListener {

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
            startX = e.getX();
            startY = e.getY();

            if ("Polygon".equals(selectedShape)) {
                polygonPoints.add(new Point(startX, startY));
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            endX = e.getX();
            endY = e.getY();
            draw(startX,startY,endX,endY);
        }
        @Override
        public void mouseDragged(MouseEvent e) {


        }

        @Override
        public void mouseMoved(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
//        private void printMethodName() {
//            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
//            if (stackTrace.length > 2) {
//                String methodName = stackTrace[2].getMethodName();
//                System.out.println(methodName);
//            }
//        }
    }
}

