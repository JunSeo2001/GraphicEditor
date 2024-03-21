package frame;

import global.Constants.EShapeButtons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GMainFrame extends JFrame {
    private static final long serialVersionUID = 1L;

    private GMenuBar menuBar;
    private GShapeToolBar shapeToolBar;
    private GDrawingPanel drawingPanel;

//    private GToolBar toolBar;

    public GMainFrame(){
        this.setSize(400,600);
        LayoutManager layoutManager = new BorderLayout();

        this.setLayout(layoutManager);


        this.menuBar = new GMenuBar();
        this.setJMenuBar(this.menuBar);

        ShapeActionHandler shapeActionHandler = new ShapeActionHandler();
        this.shapeToolBar = new GShapeToolBar(shapeActionHandler);
        this.add(shapeToolBar, BorderLayout.NORTH);


        this.drawingPanel = new GDrawingPanel();
        this.add(drawingPanel,BorderLayout.CENTER);

//        shapeToolBar.setDrawingPanel(drawingPanel);
    }

    public class ShapeActionHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            EShapeButtons eShapeButtons = EShapeButtons.valueOf(e.getActionCommand());
            drawingPanel.setShapeTool(eShapeButtons.getShapeTool());
        }
    }

}
