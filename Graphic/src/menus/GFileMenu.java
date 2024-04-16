package menus;

import frame.GMainFrame;

import javax.swing.*;

public class GFileMenu extends JMenu {
    private static final long serialVersionUID = 1L;

    public GFileMenu(GMainFrame.MenuActionHandler menuActionHandler){

        JMenuItem save = new JMenuItem("Save");
        JMenuItem open = new JMenuItem("Open");


        this.add(save);
        this.add(open);
        save.addActionListener(menuActionHandler);
    }


}
