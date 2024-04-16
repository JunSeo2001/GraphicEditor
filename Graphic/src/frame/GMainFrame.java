package frame;

import global.Constants.EShapeButtons;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class GMainFrame extends JFrame {
    private static final long serialVersionUID = 1L;

    //attributes(속성 값이 추가된 것)


    //components(부품 추가)
    private GMenuBar menuBar;
    private GShapeToolBar shapeToolBar;
    private GDrawingPanel drawingPanel;

//    private GToolBar toolBar;

    //constructor
    public GMainFrame(){
        // set attributes
        this.setSize(700,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create components
        LayoutManager layoutManager = new BorderLayout();

        this.setLayout(layoutManager);


        MenuActionHandler menuActionHandler = new MenuActionHandler();
        this.menuBar = new GMenuBar(menuActionHandler);
        this.setJMenuBar(this.menuBar);

        ShapeActionHandler shapeActionHandler = new ShapeActionHandler();
        this.shapeToolBar = new GShapeToolBar(shapeActionHandler);
        this.add(shapeToolBar, BorderLayout.NORTH);


        this.drawingPanel = new GDrawingPanel();
        this.add(drawingPanel,BorderLayout.CENTER);

        this.initialize();
    }

    public void initialize() {
        this.menuBar.initialize();
        this.shapeToolBar.initialize();
        this.drawingPanel.initialize();
    }



    public class ShapeActionHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            EShapeButtons eShapeButtons = EShapeButtons.valueOf(e.getActionCommand());
            drawingPanel.setShapeTool(eShapeButtons.getShapeTool());
        }
    }

    public class MenuActionHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Save As");

            FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG Images", "png");
            fileChooser.setFileFilter(filter);

            int userSelection = fileChooser.showSaveDialog(null);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                String fileName = fileToSave.getAbsolutePath();
                if (!fileName.toLowerCase().endsWith(".png")) {
                    // 파일 이름에 .png 확장자가 없는 경우 확장자 추가
                    fileToSave = new File(fileName + ".png");
                }
                drawingPanel.save(fileToSave);
            }
        }
    }

}
