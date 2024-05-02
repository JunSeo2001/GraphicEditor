package frame;

import menus.GEditMenu;
import menus.GFileMenu;

import javax.swing.*;

public class GMenuBar extends JMenuBar {
    private static final long serialVersionUID = 1L;

    public GFileMenu fileMenu;
    public GEditMenu editMenu;

    private GDrawingPanel drawingPanel;

    public GMenuBar(GMainFrame.MenuActionHandler menuActionHandler){
//        this.fileMenu = new GFileMenu(menuActionHandler);
//        this.editMenu = new GEditMenu(menuActionHandler);
//
//        this.add(this.fileMenu);
//        this.add(this.editMenu);

        JMenuItem save = new JMenuItem("Save");
        JMenuItem open = new JMenuItem("Open");
        save.addActionListener(menuActionHandler);
        add(save);
        add(open);
    }

    public void associate() {
        this.drawingPanel = drawingPanel;
        this.fileMenu.assoicate(drawingPanel);
    }

    public void initialize() {

    }
}
