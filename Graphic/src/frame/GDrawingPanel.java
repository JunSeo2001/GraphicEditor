package frame;

import shapeTools.GOval;
import shapeTools.GRectangle;
import shapeTools.GShape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class GDrawingPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private String selectedShape = null;
    private GShape shapeTool;

    private ArrayList<GShape> shapes; // 그려진 도형 저장



    public GDrawingPanel(){
        this.setBackground(Color.gray);
        this.shapes = new ArrayList<>(); // 리스트 초기화
        MouseEventHandler mouseEventHandler = new MouseEventHandler();
        this.addMouseListener(mouseEventHandler);
        this.addMouseMotionListener(mouseEventHandler);
    }

    public void setShapeTool(GShape shapeTool){
        this.shapeTool = shapeTool;
        System.out.println(shapeTool); //로그 확인
    }
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);

        if(shapes != null)
        {
            for(GShape shape : shapes)
                shape.redraw(getComponentGraphics(g));
        }
    }

    private void draw(Graphics graphics){
        this.shapeTool.draw(getGraphics());
    }

    public void setSelectedShape(String shape) {
        this.selectedShape = shape;
    }

    public void addShape(GShape shape) {
        shapes.add(shape);
        System.out.println(shapes);
    }


    private class MouseEventHandler implements MouseListener, MouseMotionListener {

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
            if (shapeTool instanceof GRectangle) {
                shapeTool = new GRectangle();
            } else if (shapeTool instanceof GOval) {
                shapeTool = new GOval();
            }


            shapeTool.setP1(e.getX(), e.getY());
        }

        @Override
        public void mouseReleased(MouseEvent e) {
//            GShape clonedShape = shapeTool.clone();
            shapes.add(shapeTool);
        }
        @Override
        public void mouseDragged(MouseEvent e) {
            shapeTool.setP2(e.getX(), e.getY());
            shapeTool.draw(getGraphics());
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

