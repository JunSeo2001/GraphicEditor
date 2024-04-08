package shapeTools;

import java.awt.*;

public abstract class G2PShapeTool extends GShapeTool {
    protected int x1, y1, x2, y2, ox2, oy2;

    public G2PShapeTool(EDrawingStyly eDrawingStyle) {
        super(eDrawingStyle);
        this.x1 = 0;
        this.y1 = 0;
        this.x2 = 0;
        this.y2 = 0;
        this.ox2 = 0;
        this.oy2 = 0;
    }

    public void setOrigin(int x1, int y1){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x1;
        this.y2 = y1;
        this.ox2 = x1;
        this.oy2 = y1;
    }

    public void movePoint(int x2, int y2){
        this.ox2 = this.x2;
        this.oy2 = this.y2;
        this.x2 = x2;
        this.y2 = y2;
    }

    public void addPoint(int x2, int y2) {
        this.ox2 = this.x2;
        this.oy2 = this.y2;
        this.x2 = x2;
        this.y2 = y2;
    }
    public abstract void draw(Graphics graphics);
    public abstract void redraw(Graphics graphics);
    public abstract GShapeTool clone();
}
