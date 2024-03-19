package Main;

import java.awt.*;

public class GOvalTool extends GShapeTool{
    public GOvalTool(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.drawOval(x, y, width, height);
    }
}
