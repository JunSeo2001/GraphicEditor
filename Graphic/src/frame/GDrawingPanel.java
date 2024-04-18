package frame;

import shapeTools.GShapeTool;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

public class GDrawingPanel extends JPanel {
    //attributes(GDrawingPanel 이 가지고 있는 속성)
    private static final long serialVersionUID = 1L;
    private GShapeTool shapeTool;
    private GShapeTool currentShape;
    private Vector<GShapeTool> shapes;

    private enum EDrawingState {
        eIdle,
        e2PState,
        eNPState
    }
    private EDrawingState eDrawingState;




    //constructors
    public GDrawingPanel() {
        this.setBackground(Color.gray);
//        this.shapes = new ArrayList<>(); // 리스트 초기화
        this.shapes = new Vector<GShapeTool>();
        this.eDrawingState = EDrawingState.eIdle;

        MouseEventHandler mouseEventHandler = new MouseEventHandler();
        this.addMouseListener(mouseEventHandler);
        this.addMouseMotionListener(mouseEventHandler);
    }

    public void initialize() {

    }

    //setters and getters
    public void setShapeTool(GShapeTool shapeTool) {
        this.shapeTool = shapeTool;
        System.out.println(shapeTool); //로그 확인
    }


    //method
    public void save(File file) {
        System.out.println("save");
        BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        paint(g); // 현재 패널에 그려진 그림을 이미지로 그림

        try {
            ImageIO.write(image, "PNG", file); // 이미지를 PNG 형식으로 파일에 저장
            System.out.println("파일이 저장되었습니다: " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("파일을 저장하는 도중 오류가 발생했습니다.");
        }
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
        currentShape.movePoint(x, y);
        currentShape.draw(getGraphics());
    }

    public void move(int x, int y) {

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
            } else if (eDrawingState == EDrawingState.eNPState) {
                ContinueDrawing(e.getX(), e.getY());
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
