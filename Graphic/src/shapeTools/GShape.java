package shapeTools;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class GShape implements Serializable {
    private static final long serialVersionUID = 1L;

    public enum EDrawingStyle {
        e2PStyle,
        eNPStyle
    }
    public enum EAnchor {
        eMove,
        eResize,
        eRotate
    }
    private EDrawingStyle eDrawingStyle;
    public EDrawingStyle getEDrawingStyle() {
        return this.eDrawingStyle;
    }

    // int x[], int y[]
    protected Shape shape;
    protected int x1, y1, x2, y2, ox2, oy2;
    protected ArrayList<GAnchor> anchors;


    public GShape(EDrawingStyle eDrawingStyle, Shape shape) {
        this.eDrawingStyle = eDrawingStyle;
        this.shape = shape;
        this.anchors = new ArrayList<>();

        this.x1 = 0;
        this.y1 = 0;
        this.x2 = 0;
        this.y2 = 0;
        this.ox2 = 0;
        this.oy2 = 0;
    }


    public void draw(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.draw(shape);
        for (GAnchor anchor : anchors) {
            anchor.draw(graphics);
        }
    }

    public void setOrigin(int x1, int y1) {
        this.x1 = x1;
        this.y1 = y1;

        this.ox2 = x1;
        this.oy2 = y1;
        this.x2 = x1;
        this.y2 = y1;
    }
    public void movePoint(int x2, int y2) {
        this.ox2 = this.x2;
        this.oy2 = this.y2;
        this.x2 = x2;
        this.y2 = y2;
    }

    public void addPoint(int x2, int y2) {
        this.x2 = x2;
        this.y2 = y2;
    }

    public boolean onShape(int x, int y) {
        return false;
    }

    public abstract GShape clone();
    public abstract void drag(Graphics graphics);
    public abstract void updateShape();

    public void startMove(Graphics graphics, int x, int y) {
        this.setOrigin(x, y);
    }
    public void keepMove(Graphics graphics, int x, int y) {
        this.movePoint(x, y);
    }
    public void stopMove(Graphics graphics, int x, int y) {

    }

    public void updateAnchors() {
        anchors.clear();
        Rectangle2D bounds = shape.getBounds2D();
        anchors.add(new GAnchor(new Point((int) bounds.getMinX(), (int) bounds.getMinY())));
        anchors.add(new GAnchor(new Point((int) bounds.getMaxX(), (int) bounds.getMinY())));
        anchors.add(new GAnchor(new Point((int) bounds.getMinX(), (int) bounds.getMaxY())));
        anchors.add(new GAnchor(new Point((int) bounds.getMaxX(), (int) bounds.getMaxY())));
    }

    public GAnchor getAnchor(Point point) {
        for (GAnchor anchor : anchors) {
            if (anchor.contains(point)) {
                return anchor;
            }
        }
        return null;
    }

    public void drawAnchors(Graphics graphics) {
        for (GAnchor anchor : anchors) {
            anchor.draw(graphics);
        }
    }

}
