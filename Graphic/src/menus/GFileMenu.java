package menus;

import frame.GDrawingPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GFileMenu extends JMenu {
    private static final long serialVersionUID = 1L;

    private GDrawingPanel drawingPanel;

    public void associate(GDrawingPanel drawingPanel) {
        this.drawingPanel = drawingPanel;
    }

    public GFileMenu(String s){
        super(s);
        ActionHandler actionHandler = new ActionHandler();

        JMenuItem menuItempSave = new JMenuItem("Save");
        menuItempSave.setActionCommand("Save");
        menuItempSave.addActionListener(actionHandler);
        this.add(menuItempSave);

        JMenuItem menuItemOpen = new JMenuItem("Open");
        menuItemOpen.setActionCommand("Open");
        menuItemOpen.addActionListener(actionHandler);
        this.add(menuItemOpen);
    }

    private class ActionHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Open")) {
                drawingPanel.open();

            } else if (e.getActionCommand().equals("Save")) {
                drawingPanel.save();
            }

        }
    }


}
