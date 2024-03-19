package Main;

import java.awt.*;

public class GRectangleTool extends GShapeTool{
    public GRectangleTool(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.drawRect(x, y, width, height);
    }
}
