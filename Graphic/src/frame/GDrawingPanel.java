package frame;

import shapeTools.GShapeTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

public class GDrawingPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private String selectedShape = null;
    private int startX, startY, endX, endY;
    private List<Point> polygonPoints = new ArrayList<>();
    private GShapeTool shapeTool;


    public GDrawingPanel(){
        this.setBackground(Color.gray);
        MouseEventHandler mouseEventHandler = new MouseEventHandler();
        this.addMouseListener(mouseEventHandler);
        this.addMouseMotionListener(mouseEventHandler);
    }

    public void setShapeTool(GShapeTool shapeTool){
        this.shapeTool = shapeTool;
        System.out.println(shapeTool); //로그 확인
    }

    public void paint(Graphics graphics){
        super.paint(graphics);

//        if (gRectangleTool != null) {
//            gRectangleTool.draw(graphics, x, y, x2 - x, y2 - y);
//        }
//        if (gOvalTool != null) {
//            gOvalTool.draw(graphics, x, y, x2 - x, y2 - y);
//        }

    }
    private void draw(int x, int y, int x2, int y2){

        this.shapeTool.draw(getGraphics(), x, y, x2-x, y2-y);
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

