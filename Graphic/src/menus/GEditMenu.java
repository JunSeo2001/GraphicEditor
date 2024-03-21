package menus;

import javax.swing.*;

public class GEditMenu extends JMenu {
    private static final long serialVersionUID = 1L;

    public GEditMenu(String s){
        super(s);

        JMenuItem cutMenuItem = new JMenuItem("Cut");
        JMenuItem copyMenuItem = new JMenuItem("Copy");
        JMenuItem pasteMenuItem = new JMenuItem("Paste");

        this.add(cutMenuItem);
        this.add(copyMenuItem);
        this.add(pasteMenuItem);
    }

}
