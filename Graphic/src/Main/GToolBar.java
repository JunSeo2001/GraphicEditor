package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class GToolBar extends JToolBar {
    private static final long serialVersionUID = 1L;

    public GToolBar(){
        this.setLayout(new FlowLayout());

        ButtonGroup shapeButtonGroup = new ButtonGroup();

        JRadioButton rectangleButton = new JRadioButton("Rectangle");
        JRadioButton ovalButton = new JRadioButton("Oval");
        JRadioButton lineButton = new JRadioButton("Line");
        JRadioButton polygonButton = new JRadioButton("Polygon");

        shapeButtonGroup.add(rectangleButton);
        shapeButtonGroup.add(ovalButton);
        shapeButtonGroup.add(lineButton);
        shapeButtonGroup.add(polygonButton);

        rectangleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ((GMainFrame) SwingUtilities.getWindowAncestor(GToolBar.this)).getDrawingPanel().setSelectedShape("Rectangle");
            }
        });

        ovalButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ((GMainFrame) SwingUtilities.getWindowAncestor(GToolBar.this)).getDrawingPanel().setSelectedShape("Oval");
            }
        });

        lineButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ((GMainFrame) SwingUtilities.getWindowAncestor(GToolBar.this)).getDrawingPanel().setSelectedShape("Line");
            }
        });

        polygonButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ((GMainFrame) SwingUtilities.getWindowAncestor(GToolBar.this)).getDrawingPanel().setSelectedShape("Polygon");
            }
        });

        this.add(rectangleButton);
        this.add(ovalButton);
        this.add(lineButton);
        this.add(polygonButton);


    }
}
