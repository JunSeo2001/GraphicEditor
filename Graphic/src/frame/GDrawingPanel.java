package frame;

import shapeTools.GShape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class GDrawingPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private GShape shapeTool;
    private String shapeText;
    private GShape currentShape;
    private Vector<GShape> shapes;
    private boolean bDrawing;
    private List<Point> points = new ArrayList<>();

//    private ArrayList<GShape> shapes; // 그려진 도형 저장



    public GDrawingPanel() {
        this.setBackground(Color.gray);
//        this.shapes = new ArrayList<>(); // 리스트 초기화
        this.shapes = new Vector<GShape>();
        this.bDrawing = false;

        MouseEventHandler mouseEventHandler = new MouseEventHandler();
        this.addMouseListener(mouseEventHandler);
        this.addMouseMotionListener(mouseEventHandler);
    }

    public void setShapeTool(GShape shapeTool) {
        this.shapeTool = shapeTool;
        System.out.println(shapeTool); //로그 확인
    }

    public void textShapeTool(String shapeText) {
        this.shapeText = shapeText;
        System.out.println(shapeText);
    }



    @Override
    public void paint(Graphics graphics) {
        if (shapes != null) {
            for (GShape shape : shapes)
                shape.redraw(graphics);
        }
    }

    private class MouseEventHandler implements MouseListener, MouseMotionListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("click");

            if ("Polygon".equals(shapeText)) {/** N Point Drawing**/
                if (!bDrawing) {
                    points.clear(); // 새 다각형을 그릴 때마다 이전의 점들을 초기화합니다.
                    currentShape = shapeTool.clone();
                    points.add(new Point(e.getX(), e.getY())); // 클릭한 점을 추가합니다.
                    bDrawing = true;
                } else if (e.getClickCount() == 2) {
                    shapes.add(currentShape); // 다각형을 shapes 리스트에 추가합니다.
                    bDrawing = false;
                } else {
                    points.add(new Point(e.getX(), e.getY())); // 클릭한 점을 추가합니다.
                    currentShape.setPoints(points);
                    currentShape.draw(getGraphics());
                }

            } else {        /**2 Point Drawing**/
                if (!bDrawing) {
                    currentShape = shapeTool.clone();
                    currentShape.setP1(e.getX(), e.getY());
                    bDrawing = true;
                } else {
                    shapes.add(currentShape);
                    bDrawing = false;
                }
            }
        }
        @Override
        public void mouseMoved(MouseEvent e) {
            if (!"Polygon".equals(shapeText)) {
                if (bDrawing) {
                    currentShape.setP2(e.getX(), e.getY());
                    currentShape.draw(getGraphics());
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseDragged(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

    }
}

