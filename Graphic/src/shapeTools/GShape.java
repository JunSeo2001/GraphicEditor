package shapeTools;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;

public abstract class GShape implements Serializable {
    private static final long serialVersionUID = 1L;

    public enum EDrawingStyle {
        e2PStyle,
        eNPStyle
    }
    private EDrawingStyle eDrawingStyle;
    public EDrawingStyle getEDrawingStyle() {
        return this.eDrawingStyle;
    }

    // int x[], int y[]
    protected Shape shape;
    protected int x1, y1, x2, y2, ox2, oy2;

    //    protected ArrayList<GAnchor> anchors;
    public enum EAnchors {
        eRR(new Cursor(Cursor.HAND_CURSOR)),
        eNN(new Cursor(Cursor.N_RESIZE_CURSOR)),
        eSS(new Cursor(Cursor.S_RESIZE_CURSOR)),
        eEE(new Cursor(Cursor.E_RESIZE_CURSOR)),
        eWW(new Cursor(Cursor.W_RESIZE_CURSOR)),
        eNE(new Cursor(Cursor.NE_RESIZE_CURSOR)),
        eSE(new Cursor(Cursor.SE_RESIZE_CURSOR)),
        eNW(new Cursor(Cursor.NW_RESIZE_CURSOR)),
        eSW(new Cursor(Cursor.SW_RESIZE_CURSOR)),
        eMM(new Cursor(Cursor.CROSSHAIR_CURSOR));

        private Cursor cursor;
        private EAnchors(Cursor cursor) {
            this.cursor = cursor;
        }

        public Cursor getCursor() {
            return this.cursor;
        }
    }
    private EAnchors eSelectedAnchor;
    protected Ellipse2D.Float[] anchors;

    //resize
    private double sx, sy;
    private double dx, dy;

    //setters and getters
    public void setSelected(Graphics graphics) {
        this.drawAnchors(graphics);
    }

    public void clearSelected() {
        this.anchors = null;
    }

    public EAnchors getSelectedAnchor() {
        return this.eSelectedAnchor;
    }

    public Cursor getCursor() {
        return this.eSelectedAnchor.getCursor();
    }


    public GShape(EDrawingStyle eDrawingStyle, Shape shape) {
        this.eDrawingStyle = eDrawingStyle;
        this.shape = shape;
//        this.anchors = new ArrayList<>();
        this.anchors = null;
        this.eSelectedAnchor = null;

        this.x1 = 0;
        this.y1 = 0;
        this.x2 = 0;
        this.y2 = 0;
        this.ox2 = 0;
        this.oy2 = 0;
    }

    public abstract GShape clone();


    public void draw(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.draw(shape);
//        for (GAnchor anchor : anchors) {
//            anchor.draw(graphics);
//        }
    }

    private void drawAnchors(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        Rectangle2D bounds = this.shape.getBounds2D();
        int x = (int) bounds.getX();
        int y = (int) bounds.getY();
        int w = (int) bounds.getWidth();
        int h = (int) bounds.getHeight();
        int ANCHOR_WIDTH = 10;
        int ANCHOR_HEIGHT = 10;

        this.anchors = new Ellipse2D.Float[EAnchors.values().length - 1];
        this.anchors[EAnchors.eRR.ordinal()] = new Ellipse2D.Float(x + w / 2 - ANCHOR_WIDTH / 2, y - 30, ANCHOR_WIDTH, ANCHOR_HEIGHT);
        this.anchors[EAnchors.eNN.ordinal()] = new Ellipse2D.Float(x + w / 2 - ANCHOR_WIDTH / 2, y - ANCHOR_HEIGHT / 2, ANCHOR_WIDTH, ANCHOR_HEIGHT);
        this.anchors[EAnchors.eSS.ordinal()] = new Ellipse2D.Float(x + w / 2 - ANCHOR_WIDTH / 2, y + h - ANCHOR_HEIGHT / 2, ANCHOR_WIDTH, ANCHOR_HEIGHT);
        this.anchors[EAnchors.eEE.ordinal()] = new Ellipse2D.Float(x + w - ANCHOR_WIDTH / 2, y + h / 2 - ANCHOR_HEIGHT / 2, ANCHOR_WIDTH, ANCHOR_HEIGHT);
        this.anchors[EAnchors.eWW.ordinal()] = new Ellipse2D.Float(x - ANCHOR_WIDTH / 2, y + h / 2 - ANCHOR_HEIGHT / 2, ANCHOR_WIDTH, ANCHOR_HEIGHT);
        this.anchors[EAnchors.eNW.ordinal()] = new Ellipse2D.Float(x - ANCHOR_WIDTH / 2, y - ANCHOR_HEIGHT / 2, ANCHOR_WIDTH, ANCHOR_HEIGHT);
        this.anchors[EAnchors.eNE.ordinal()] = new Ellipse2D.Float(x + w - ANCHOR_WIDTH / 2, y - ANCHOR_HEIGHT / 2, ANCHOR_WIDTH, ANCHOR_HEIGHT);
        this.anchors[EAnchors.eSW.ordinal()] = new Ellipse2D.Float(x - ANCHOR_WIDTH / 2, y + h - ANCHOR_HEIGHT / 2, ANCHOR_WIDTH, ANCHOR_HEIGHT);
        this.anchors[EAnchors.eSE.ordinal()] = new Ellipse2D.Float(x + w - ANCHOR_WIDTH / 2, y + h - ANCHOR_HEIGHT / 2, ANCHOR_WIDTH, ANCHOR_HEIGHT);

        for (Ellipse2D anchor : this.anchors) {
            graphics2D.draw(anchor);
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
    public abstract void drag(Graphics graphics);

    public void addPoint(int x2, int y2) {
        this.x2 = x2;
        this.y2 = y2;
    }

    public boolean onShape(int x, int y) {
        this.eSelectedAnchor = null;
        if (this.anchors != null) {
            for (int i = 0 ; i<EAnchors.values().length-1; i++) {
                if (anchors[i].contains(x, y)) {
                    this.eSelectedAnchor = EAnchors.values()[i];
                    return true;
                }
            }
        }
        boolean isOnShape = this.shape.contains(x, y);
        if (isOnShape) {
            this.eSelectedAnchor = EAnchors.eMM;
        }
        return isOnShape;
    }

//    public abstract void updateShape();



    public void startMove(Graphics graphics, int x, int y) {
        this.ox2 = x;
        this.oy2 = y;
        this.x2 = x;
        this.y2 = y;
    }
    public void keepMove(Graphics graphics, int x, int y) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setXORMode(graphics2D.getBackground());
        graphics2D.draw(this.shape);
        //		this.movePoint(x, y);
        this.x2 = x;
        this.y2 = y;
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.setToTranslation(x2-ox2, y2-oy2);
        this.shape = affineTransform.createTransformedShape(this.shape);
        this.ox2 = x2;
        this.oy2 = y2;

        graphics2D.draw(this.shape);
    }
    public void stopMove(Graphics graphics, int x, int y) {
    }

    public void startResize(Graphics graphics, int x, int y) {
        this.ox2 = x;
        this.oy2 = y;
        this.x2 = x;
        this.y2 = y;
    }

    private Point2D getResizeFactor() {
        sx = 1.0;
        sy = 1.0;
        dx = 0.0;
        dy = 0.0;

        Rectangle2D bounds = this.shape.getBounds2D();
        double w = bounds.getWidth();
        double h = bounds.getHeight();

        switch (this.eSelectedAnchor) {
            case eEE:
                sx = (w + x2 - ox2) / w;
                dx = bounds.getX() * (1 - sx);
                break;
            case eWW:
                sx = (w + ox2 - x2) / w;
                dx = bounds.getX() * (1 - sx) + w * (1 - sx);
                break;
            case eSS:
                sy = (h + y2 - oy2) / h;
                dy = bounds.getY() * (1 - sy);
                break;
            case eNN:
                sy = (h + oy2 - y2) / h;
                dy = bounds.getY() * (1 - sy) + h * (1 - sy);
                break;
            case eSE:
                sx = (w + x2 - ox2) / w;
                sy = (h + y2 - oy2) / h;
                dx = bounds.getX() * (1 - sx);
                dy = bounds.getY() * (1 - sy);
                break;
            case eSW:
                sx = (w + ox2 - x2) / w;
                sy = (h + y2 - oy2) / h;
                dx = bounds.getX() * (1 - sx) + w * (1 - sx);
                dy = bounds.getY() * (1 - sy);
                break;
            case eNE:
                sx = (w + x2 - ox2) / w;
                sy = (h + oy2 - y2) / h;
                dx = bounds.getX() * (1 - sx);
                dy = bounds.getY() * (1 - sy) + h * (1 - sy);
                break;
            case eNW:
                sx = (w + ox2 - x2) / w;
                sy = (h + oy2 - y2) / h;
                dx = bounds.getX() * (1 - sx) + w * (1 - sx);
                dy = bounds.getY() * (1 - sy) + h * (1 - sy);
                break;
            default:
                break;
        }
        return new Point2D.Double(sx, sy);
    }


    public void keepResize(Graphics graphics, int x, int y) {
        this.ox2 = x2;
        this.oy2 = y2;
        this.x2 = x;
        this.y2 = y;

        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setXORMode(graphics2D.getBackground());
        graphics2D.draw(this.shape);


        Point2D resizeFactor = getResizeFactor();

        AffineTransform affineTransform = new AffineTransform();
        affineTransform.translate(dx, dy);
        affineTransform.scale(resizeFactor.getX(), resizeFactor.getY());

        this.shape = affineTransform.createTransformedShape(this.shape);


        graphics2D.draw(this.shape);
    }
    public void stopResize(Graphics graphics, int x, int y) {
    }

}
