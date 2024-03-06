package Main;

import javax.swing.*;

public class GMenuBar extends JMenuBar {
    private static final long serialVersionUID = 1L;

    public GFileMenu fileMenu;

    public GMenuBar(){
        this.fileMenu = new GFileMenu("file");
        this.add(this.fileMenu);

    }

}
