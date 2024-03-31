package global;

import shapeTools.*;


public class Constants {
    public enum EShapeButtons{
        eRectangle("Rectangle", new GRectangle()),
        eOval("Oval", new GOval()),
        eLine("Line", new GLine()),
        ePolygon("Polygon", new GPolygon());

        private String text;
        private GShape shapeTool;

        EShapeButtons(String text, GShape shapeTool){
            this.text = text;
            this.shapeTool = shapeTool;
        }
        public String getText(){
            return this.text;
        }
        public GShape getShapeTool(){
            return this.shapeTool;
        }
    }

}
