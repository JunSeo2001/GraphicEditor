package shapeTools;

import java.awt.*;

public class GOvalTool extends GShapeTool{

    @Override
    public void draw(Graphics graphics, int x, int y, int i, int i1) {
        graphics.drawOval(x, y, i, i1);
    }
}
