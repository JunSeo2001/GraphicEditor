package shapeTools;

import java.awt.*;

public class GRectangleTool extends GShapeTool{
//    public GRectangleTool(int x, int y, int width, int height) {
//        super(x, y, width, height);
//    }

    @Override
    public void draw(Graphics graphics, int x, int y, int w, int h){

        graphics.drawRect(x, y, w, h);
    }
}
