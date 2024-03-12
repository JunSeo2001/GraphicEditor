package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class GShapeToolBar extends JToolBar {
    private static final long serialVersionUID = 1L;
    private GDrawingPanel drawingPanel;

    public GShapeToolBar() {
        this.setLayout(new FlowLayout());

        JRadioButton rectangleButton = new JRadioButton("Rectangle");
        JRadioButton ovalButton = new JRadioButton("Oval");
        JRadioButton lineButton = new JRadioButton("Line");
        JRadioButton polygonButton = new JRadioButton("Polygon");

        ButtonGroup shapeButtonGroup = new ButtonGroup();
        shapeButtonGroup.add(rectangleButton);
        shapeButtonGroup.add(ovalButton);
        shapeButtonGroup.add(lineButton);
        shapeButtonGroup.add(polygonButton);

        rectangleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (drawingPanel != null) {
                    drawingPanel.setSelectedShape("Rectangle");
                }
            }
        });

        ovalButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (drawingPanel != null) {
                    drawingPanel.setSelectedShape("Oval");
                }
            }
        });

        lineButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (drawingPanel != null) {
                    drawingPanel.setSelectedShape("Line");
                }
            }
        });

        polygonButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (drawingPanel != null) {
                    drawingPanel.setSelectedShape("Polygon");
                }
            }
        });

        this.add(rectangleButton);
        this.add(ovalButton);
        this.add(lineButton);
        this.add(polygonButton);
    }
    public void setDrawingPanel(GDrawingPanel drawingPanel) {
        this.drawingPanel = drawingPanel;
    }
}
