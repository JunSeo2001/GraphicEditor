package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class GShapeToolBar extends JToolBar {
    private static final long serialVersionUID = 1L;
    private GDrawingPanel drawingPanel;
    private JRadioButton rectangleButton;
    private JRadioButton ovalButton;
    private JRadioButton lineButton;
    private JRadioButton polygonButton;

    public enum EShapeButtons{
        eRectangle,
        eOval,
        eLine,
        ePolygon
    }

    public GShapeToolBar(GMainFrame.ShapeActionHandler shapeActionHandler) {
        this.setLayout(new FlowLayout());
        ButtonGroup shapeButtonGroup = new ButtonGroup();

        this.rectangleButton = new JRadioButton("Rectangle");
        this.rectangleButton.addActionListener(shapeActionHandler);
        this.add(rectangleButton);
        shapeButtonGroup.add(rectangleButton);

        this.ovalButton = new JRadioButton("Oval");
        this.ovalButton.addActionListener(shapeActionHandler);
        this.add(ovalButton);
        shapeButtonGroup.add(ovalButton);

        this.lineButton = new JRadioButton("Line");
        this.lineButton.addActionListener(shapeActionHandler);
        this.add(lineButton);
        shapeButtonGroup.add(lineButton);

        this.polygonButton = new JRadioButton("Polygon");
        this.polygonButton.addActionListener(shapeActionHandler);
        this.add(polygonButton);
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
    }
    public void setDrawingPanel(GDrawingPanel drawingPanel) {

        this.drawingPanel = drawingPanel;
    }
}
