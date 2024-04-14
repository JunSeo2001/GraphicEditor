package frame;

import shapeTools.GShapeTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

public class GDrawingPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private GShapeTool shapeTool;
    private GShapeTool currentShape;
    private Vector<GShapeTool> shapes;

    public void initialize() {

    }


    private enum EDrawingState {
        eIdle,
        e2PState,
        eNPState
    }
    private EDrawingState eDrawingState;

    public GDrawingPanel() {
        this.setBackground(Color.gray);
//        this.shapes = new ArrayList<>(); // 리스트 초기화
        this.shapes = new Vector<GShapeTool>();
        this.eDrawingState = EDrawingState.eIdle;

        MouseEventHandler mouseEventHandler = new MouseEventHandler();
        this.addMouseListener(mouseEventHandler);
        this.addMouseMotionListener(mouseEventHandler);
    }

    public void setShapeTool(GShapeTool shapeTool) {
        this.shapeTool = shapeTool;
        System.out.println(shapeTool); //로그 확인
    }


    @Override
    public void paint(Graphics graphics) {
        if (shapes != null) {
            for (GShapeTool shape : shapes)
                shape.redraw(graphics);
        }
    }

    private void startDrawing(int x, int y) {
        currentShape = shapeTool.clone();
        currentShape.setOrigin(x, y);
    }

    private void keepDrawing(int x, int y) {
        currentShape.addPoint(x, y);
        currentShape.draw(getGraphics());
    }

    private void stopDrawing(int x, int y) {
        if (shapeTool.getEDrawingStyle() == GShapeTool.EDrawingStyly.e2PStyle) {
            currentShape.addPoint(x, y);
            shapes.add(currentShape);
        } else if (shapeTool.getEDrawingStyle() == GShapeTool.EDrawingStyly.eNPStyle) {
            currentShape.addPoint(x, y);
            shapes.add(currentShape);
            currentShape.draw(getGraphics());
        }

    }

    private void ContinueDrawing(int x, int y) {

    }


    private class MouseEventHandler implements MouseListener, MouseMotionListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (eDrawingState == EDrawingState.eIdle) {
                if (shapeTool.getEDrawingStyle() == GShapeTool.EDrawingStyly.e2PStyle) {
                    startDrawing(e.getX(), e.getY());
                    eDrawingState = EDrawingState.e2PState;

                } else if (shapeTool.getEDrawingStyle() == GShapeTool.EDrawingStyly.eNPStyle) {
                    startDrawing(e.getX(), e.getY());
                    eDrawingState = EDrawingState.eNPState;
                }

            }else {
                if (shapeTool.getEDrawingStyle() == GShapeTool.EDrawingStyly.e2PStyle) {
                    stopDrawing(e.getX(), e.getY());
                    eDrawingState = EDrawingState.eIdle;
                } else if (shapeTool.getEDrawingStyle() == GShapeTool.EDrawingStyly.eNPStyle) {
                    if (e.getClickCount() == 2) {
                        stopDrawing(e.getX(), e.getY());
                        eDrawingState = EDrawingState.eIdle;
                    }else{
                        keepDrawing(e.getX(), e.getY());
                    }
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
//            if (eDrawingState == EDrawingState.eIdle) {
//                if (shapeTool.getEDrawingStyle() == GShapeTool.EDrawingStyly.e2PStyle) {
//                    startDrawing(e.getX(), e.getY());
//                    eDrawingState = EDrawingState.e2PState;
//                }
//            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
//            if (eDrawingState == EDrawingState.e2PState) {
//                stopDrawing(e.getX(), e.getY());
//                eDrawingState = EDrawingState.eIdle;
//            }
        }

        @Override
        public void mouseDragged(MouseEvent e) {
//            if (eDrawingState == EDrawingState.e2PState) {
//                keepDrawing(e.getX(), e.getY());
//            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

    }
}
