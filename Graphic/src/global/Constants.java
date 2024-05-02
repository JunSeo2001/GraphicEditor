package global;

import shapeTools.*;


public class Constants{
    public enum EShapeButtons{
        eRectangle("Rectangle", new GRectangle()),
        eOval("Oval", new GOval()),
        eLine("Line", new GLine()),
        ePolygon("Polygon", new GPolygon());

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

    public final static int NUM_POINTS = 20;

}
