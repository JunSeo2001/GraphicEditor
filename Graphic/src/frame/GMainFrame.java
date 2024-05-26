package frame;
import java.awt.BorderLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import global.Constants;
import global.Constants.EShapeButtons;

public class GMainFrame extends JFrame {
    private static final long serialVersionUID = 1L;

    // attributes

    // components
    private GMenuBar menuBar;
    private GShapeToolBar shapeToolBar;
    private GDrawingPanel drawingPanel;

    // constructor
    public GMainFrame() {
        // set attributes

        this.setSize(Constants.GMainFrame.WIDTH, Constants.GMainFrame.HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create components
        LayoutManager layoutManager = new BorderLayout();
        this.setLayout(layoutManager);

        this.menuBar = new GMenuBar();
        this.setJMenuBar(this.menuBar);

        this.shapeToolBar = new GShapeToolBar();
        this.add(shapeToolBar, BorderLayout.NORTH);

        this.drawingPanel = new GDrawingPanel();
        this.add(drawingPanel, BorderLayout.CENTER);

        // associate
        this.menuBar.associate(this.drawingPanel);
        this.shapeToolBar.associate(this.drawingPanel);
    }

    // methods
    public void initialize() {
        this.menuBar.initialize();
        this.shapeToolBar.intitialize();
        this.drawingPanel.intitialize();
    }
}
