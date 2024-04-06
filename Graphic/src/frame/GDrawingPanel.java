package frame;

import shapeTools.GShape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;
import java.util.List;
import java.util.ArrayList;

public class GDrawingPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private GShape shapeTool;
    private String shapeText;
    private GShape currentShape;
    private Vector<GShape> shapes;
    private boolean bDrawing;
    private List<Point> points = new ArrayList<>();



    private enum EDrawingState {
        eIdle,
        e2PState,
        eNPState
    }
    private EDrawingState eDrawingState;

    public GDrawingPanel() {
        this.setBackground(Color.gray);
//        this.shapes = new ArrayList<>(); // 리스트 초기화
        this.shapes = new Vector<GShape>();
        this.bDrawing = false;
        this.eDrawingState = EDrawingState.eIdle;

        MouseEventHandler mouseEventHandler = new MouseEventHandler();
        this.addMouseListener(mouseEventHandler);
        this.addMouseMotionListener(mouseEventHandler);
    }

    public void setShapeTool(GShape shapeTool) {
        this.shapeTool = shapeTool;
        System.out.println(shapeTool); //로그 확인
    }


    @Override
    public void paint(Graphics graphics) {
        if (shapes != null) {
            for (GShape shape : shapes)
                shape.redraw(graphics);
        }
    }

    private void startDrawing(int x, int y) {
        currentShape = shapeTool.clone();
        currentShape.setP1(x, y);
    }

    private void keepDrawing(int x, int y) {
        if (shapeTool.getEDrawingStyle() == GShape.EDrawingStyly.e2PStyle) {
            currentShape.setP2(x, y);
            currentShape.draw(getGraphics());
        } else if (shapeTool.getEDrawingStyle() == GShape.EDrawingStyly.eNPStyle) {
            points.add(new Point(x, y); // 클릭한 점을 추가합니다.
            currentShape.setPoints(points);
            currentShape.draw(getGraphics());
        }

    }

    private void stopDrawing(int x, int y) {

        shapes.add(currentShape);
    }


    private class MouseEventHandler implements MouseListener, MouseMotionListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (eDrawingState == EDrawingState.eIdle) {
                if (shapeTool.getEDrawingStyle() == GShape.EDrawingStyly.e2PStyle) {
                    startDrawing(e.getX(), e.getY());
                    eDrawingState = EDrawingState.e2PState;

                } else if (shapeTool.getEDrawingStyle() == GShape.EDrawingStyly.eNPStyle) {
                    points.clear(); // 새로운 다각형 클리어
                    currentShape = shapeTool.clone();
                    points.add(new Point(e.getX(), e.getY()));
                    eDrawingState = EDrawingState.eNPState;
                }
            } else if (e.getClickCount() == 2) {
                stopDrawing(e.getX(), e.getY());
                eDrawingState = EDrawingState.eIdle;

            } else {
                if (shapeTool.getEDrawingStyle() == GShape.EDrawingStyly.e2PStyle) {
                    stopDrawing(e.getX(), e.getY());
                    eDrawingState = EDrawingState.eIdle;
                } else if (shapeTool.getEDrawingStyle() == GShape.EDrawingStyly.eNPStyle) {
                    keepDrawing(e.getX(), e.getY());
                }
            }

        }

        @Override
        public void mouseMoved(MouseEvent e) {
            if (eDrawingState == EDrawingState.e2PState) {
                keepDrawing(e.getX(), e.getY());
            }

        }


        @Override
        public void mousePressed(MouseEvent e) {
            if (eDrawingState == EDrawingState.eIdle) {
                if (shapeTool.getEDrawingStyle() == GShape.EDrawingStyly.e2PStyle) {
                    startDrawing(e.getX(), e.getY());
                    eDrawingState = EDrawingState.e2PState;
                }
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (eDrawingState == EDrawingState.e2PState) {
                stopDrawing(e.getX(), e.getY());
                eDrawingState = EDrawingState.eIdle;
            }
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if (eDrawingState == EDrawingState.e2PState) {
                keepDrawing(e.getX(), e.getY());
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

    }
}
