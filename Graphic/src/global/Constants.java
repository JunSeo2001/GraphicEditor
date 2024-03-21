package global;

import shapeTools.GOvalTool;
import shapeTools.GRectangleTool;
import shapeTools.GShapeTool;


public class Constants {
    public enum EShapeButtons{
        eRectangle("Rectangle", new GRectangleTool()),
        eOval("Oval", new GOvalTool()),
        eLine("Line", new GRectangleTool()),
        ePolygon("Polygon", new GRectangleTool());

        private String text;
        private GShapeTool shapeTool;

        EShapeButtons(String text, GShapeTool shapeTool){
            this.text = text;
            this.shapeTool = shapeTool;
        }
        public String getText(){
            return this.text;
        }
        public GShapeTool getShapeTool(){
            return this.shapeTool;
        }
    }

}
