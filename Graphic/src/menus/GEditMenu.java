package menus;

import frame.GMainFrame;

import javax.swing.*;

public class GEditMenu extends JMenu {
    private static final long serialVersionUID = 1L;

    public GEditMenu(GMainFrame.MenuActionHandler menuActionHandler){

        JMenuItem cutMenuItem = new JMenuItem("Cut");
        JMenuItem copyMenuItem = new JMenuItem("Copy");
        JMenuItem pasteMenuItem = new JMenuItem("Paste");


        this.add(cutMenuItem);
        this.add(copyMenuItem);
        this.add(pasteMenuItem);
    }

}
