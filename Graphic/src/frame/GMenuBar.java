package frame;

import menus.GEditMenu;
import menus.GFileMenu;

import javax.swing.*;

public class GMenuBar extends JMenuBar {
    private static final long serialVersionUID = 1L;

    public GFileMenu fileMenu;
    public GEditMenu editMenu;

    private GDrawingPanel drawingPanel;

    public GMenuBar(){
        this.fileMenu = new GFileMenu("file");
        this.editMenu = new GEditMenu("edit");

        this.add(this.fileMenu);
        this.add(this.editMenu);
    }

    public void associate(GDrawingPanel drawingPanel) {
        this.drawingPanel = drawingPanel;
        this.fileMenu.associate(drawingPanel);
    }

    public void initialize() {

    }
}
