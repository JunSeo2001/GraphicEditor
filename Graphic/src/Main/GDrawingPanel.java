package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList; // 수정된 부분
import java.util.List;

public class GDrawingPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    private String selectedShape = null;

    private int startX, startY, currentX, currentY;
    private int[] xPoints, yPoints;
    private int numPoints;

    public GDrawingPanel() {
//        this.setBackground(Color.GRAY);
//        this.selectedShape = null; // 초기화 추가
        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                startX = e.getX();
                startY = e.getY();
                if (selectedShape != null && selectedShape.equals("Polygon")) {
                    xPoints = new int[100];
                    yPoints = new int[100];
                    numPoints = 0;
                    xPoints[numPoints] = startX;
                    yPoints[numPoints] = startY;
                    numPoints++;
                }
            }
        });

        this.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                currentX = e.getX();
                currentY = e.getY();
                repaint();
            }
        });
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        if (selectedShape != null) {
            switch (selectedShape) {
                case "Rectangle":
                    int width = currentX - startX;
                    int height = currentY - startY;
                    g.drawRect(startX, startY, width, height);
                    break;
                case "Oval":
                    width = currentX - startX;
                    height = currentY - startY;
                    g.drawOval(startX, startY, width, height);
                    break;
                case "Line":
                    g.drawLine(startX, startY, currentX, currentY);
                    break;
                case "Polygon":
                    if (numPoints > 0) {
                        g.drawPolygon(xPoints, yPoints, numPoints);
                    }
                    break;
                default:
                    break;
            }
        }
    }

    public void setSelectedShape(String shape){
        this.selectedShape = shape;
        System.out.println(shape);
        repaint();
    }
}

