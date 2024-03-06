package Main;

import javax.swing.*;

public class GMainFrame extends JFrame {
    private static final long serialVersionUID = 1L;

    private GMenuBar menuBar;
    private GToolBar toolBar;

    public GMainFrame(){
        this.setSize(400,600);
        this.menuBar = new GMenuBar();
        this.toolBar = new GToolBar();

        this.setJMenuBar(this.menuBar);



    }
}
