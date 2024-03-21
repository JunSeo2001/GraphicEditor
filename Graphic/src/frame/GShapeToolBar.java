package frame;


import global.Constants.EShapeButtons;

import javax.swing.*;
import java.awt.*;

public class GShapeToolBar extends JToolBar {
    private static final long serialVersionUID = 1L;


    public GShapeToolBar(GMainFrame.ShapeActionHandler shapeActionHandler) {
        this.setLayout(new FlowLayout());
        ButtonGroup shapeButtonGroup = new ButtonGroup();

        for(EShapeButtons eShapeButtons: EShapeButtons.values()){
            JRadioButton button = new JRadioButton(eShapeButtons.getText());
            button.addActionListener(shapeActionHandler);
            button.setActionCommand(eShapeButtons.toString());
            this.add(button);
            shapeButtonGroup.add(button);
        }

    }
}
