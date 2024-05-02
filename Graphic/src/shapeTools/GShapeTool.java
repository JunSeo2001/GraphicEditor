package shapeTools;

import java.awt.*;
import java.io.Serializable;

public abstract class GShapeTool implements Serializable {
    public enum EDrawingStyly{
        e2PStyle,
        eNPStyle
    }
    private EDrawingStyly eDrawingStyle;

    public EDrawingStyly getEDrawingStyle() {
        return this.eDrawingStyle;
    }


    public GShapeTool(EDrawingStyly eDrawingStyle){
        this.eDrawingStyle = eDrawingStyle;
    }
    public abstract void movePoint(int x, int y);
    public abstract void setOrigin(int x, int y);
    public abstract void addPoint(int x, int y);

    public abstract void draw(Graphics graphics);
    public abstract void redraw(Graphics graphics);
    public abstract GShapeTool clone();
}
