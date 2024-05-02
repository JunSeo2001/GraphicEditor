package menus;

import frame.GDrawingPanel;
import frame.GMainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GFileMenu extends JMenu {
    private static final long serialVersionUID = 1L;

    private GDrawingPanel drawingPanel;

    public void assoicate(GDrawingPanel drawingPanel) {
        this.drwingPanel = draingPanel;
    }
    public GFileMenu(String s){
        super(s);
        ActionHandler actionHandler = new ActionHandler();

        JMenuItem save = new JMenuItem("Save");
        save.setActionCommand("Save");
        save.addActionListener(actionHandler);

        JMenuItem open = new JMenuItem("Open");
        open.setActionCommand("Open");
        open.addActionListener(actionHandler);

        this.add(save);
        this.add(open);
    }

    private class ActionHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Open")) {
                drawing

            } else if (e.getActionCommand().equals("Save")) {

            }

        }
    }


}
