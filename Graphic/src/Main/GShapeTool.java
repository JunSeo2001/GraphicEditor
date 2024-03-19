package Main;

import java.awt.*;

public abstract class GShapeTool {
    protected int x, y, width, height;

    public GShapeTool(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public abstract void draw(Graphics graphics);

}
