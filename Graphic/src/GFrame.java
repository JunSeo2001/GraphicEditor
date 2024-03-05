import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GFrame extends JFrame {

    public void frame(){
        setTitle("도형 그리기");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,400);

        add(new MyPanel());


    }

    class MyPanel extends JPanel{
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            //사각형
            g.drawRect(50,50,100,100);
            g.drawRect(50,50,100,100);

            //삼각형
            int[] xPoints = {200, 250, 150}; // 삼각형의 x 좌표
            int[] yPoints = {50, 150, 150};  // 삼각형의 y 좌표
            g.drawPolygon(xPoints, yPoints, 3); // 삼각형을 그림

            // 원 그리기
            g.drawOval(100, 200, 100, 100); // (100, 200) 위치에서 가로 100, 세로 100 크기의 원을 그림
        }
    }

}
