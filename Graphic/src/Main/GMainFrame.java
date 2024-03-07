package Main;

import javax.swing.*;
import java.awt.*;

public class GMainFrame extends JFrame {
    private static final long serialVersionUID = 1L;

    private GMenuBar menuBar;
    private GToolBar toolBar;
    private GDrawingPanel drawingPanel;
//    private GToolBar toolBar;

    public GMainFrame(){
        this.setSize(400,600);
        this.menuBar = new GMenuBar();
        this.toolBar = new GToolBar();
        this.drawingPanel = new GDrawingPanel();
//        this.toolBar = new GToolBar();

        this.setJMenuBar(this.menuBar);
        this.add(toolBar, BorderLayout.NORTH);
        this.add(drawingPanel,BorderLayout.CENTER);
    }
    public GDrawingPanel getDrawingPanel() {
        return drawingPanel;
    }


}
