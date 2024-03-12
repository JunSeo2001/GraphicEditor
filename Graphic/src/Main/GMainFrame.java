package Main;

import javax.swing.*;
import java.awt.*;

public class GMainFrame extends JFrame {
    private static final long serialVersionUID = 1L;

    private GMenuBar menuBar;
    private GShapeToolBar shapeToolBar;
    private GDrawingPanel drawingPanel;

//    private GToolBar toolBar;

    public GMainFrame(){
        this.setSize(400,600);

//        LayoutManager layoutManager = new FlowLayout();
//        LayoutManager layoutManager = new CardLayout();
        LayoutManager layoutManager = new BorderLayout();

        // 배치 매니저
//        BoxLayout layoutManager = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);
        this.setLayout(layoutManager);


        this.menuBar = new GMenuBar();
        this.setJMenuBar(this.menuBar);

        this.shapeToolBar = new GShapeToolBar();
        this.add(shapeToolBar, BorderLayout.NORTH);

        this.drawingPanel = new GDrawingPanel();
        this.add(drawingPanel,BorderLayout.CENTER);

        shapeToolBar.setDrawingPanel(drawingPanel);
    }


}
