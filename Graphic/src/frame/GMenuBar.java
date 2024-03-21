package frame;

import menus.GEditMenu;
import menus.GFileMenu;

import javax.swing.*;

public class GMenuBar extends JMenuBar {
    private static final long serialVersionUID = 1L;

    public GFileMenu fileMenu;
    public GEditMenu editMenu;


    public GMenuBar(){
        this.fileMenu = new GFileMenu("File");
        this.editMenu = new GEditMenu("Edit");
        this.add(this.fileMenu);
        this.add(this.editMenu);

    }

}
