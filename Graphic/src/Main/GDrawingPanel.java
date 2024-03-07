package Main;

import javax.swing.*;
import java.awt.*;

public class GDrawingPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    private String selectedShape;

    public GDrawingPanel(){
        this.selectedShape = null;
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        if (selectedShape != null) {
            switch (selectedShape) {
                case "Rectangle":
                    g.drawRect(50, 50, 100, 100); // 임의의 위치와 크기로 사각형을 그립니다.
                    break;
                case "Oval":
                    g.drawOval(50, 50, 100, 100); // 임의의 위치와 크기로 타원을 그립니다.
                    break;
                case "Line":
                    g.drawLine(50, 50, 150, 150); // 임의의 위치에 선을 그립니다.
                    break;
                case "Polygon":
                    int[] xPoints = {50, 100, 150}; // 다각형의 x 좌표 배열
                    int[] yPoints = {50, 150, 50}; // 다각형의 y 좌표 배열
                    g.drawPolygon(xPoints, yPoints, 3); // 임의의 위치에 다각형을 그립니다.
                    break;
                default:
                    break;
            }
        }
    }

    public void setSelectedShape(String shape){
        this.selectedShape = shape;
        repaint();
    }
}
