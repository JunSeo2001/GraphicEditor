package frame;


import global.Constants.EShapeButtons;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class GShapeToolBar extends JToolBar {
    private static final long serialVersionUID = 1L;

    public GShapeToolBar(GMainFrame.ShapeActionHandler shapeActionHandler) {
//        this.setLayout(new FlowLayout());
        this.setLayout(new FlowLayout());
        ButtonGroup buttonGroup = new ButtonGroup();

        for(EShapeButtons eShapeButtons: EShapeButtons.values()){
            //이미지 삽입
            ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/image/"+eShapeButtons.getText()+".png")));
            Image image = icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            icon = new ImageIcon(image);
            JLabel label  = new JLabel(icon);

            //버튼 생성
            JRadioButton button = new JRadioButton(eShapeButtons.getText());
            button.addActionListener(shapeActionHandler);
            button.setActionCommand(eShapeButtons.toString());
            add(label);
            add(button);
            buttonGroup.add(button);
        }

    }


    public void initialize() {
        JToggleButton defaultButton = (JRadioButton) (this.getComponent(EShapeButtons.eOval.ordinal()));
        defaultButton.doClick();
        //초기 값 설정
    }

}
