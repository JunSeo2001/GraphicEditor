package shapeTools;

import global.Constants;

import java.awt.*;

public abstract class GNPShapeTool extends GShapeTool{

    protected int aX[];
    protected int aY[];
    protected int pointIndex;
    public GNPShapeTool(EDrawingStyly eDrawingStyle) {
        super(eDrawingStyle);
        this.aX = new int[Constants.NUM_POINTS];
        this.aY = new int[Constants.NUM_POINTS];
        this.pointIndex = 0;
    }


    public void setOrigin(int x, int y){
        this.aX[pointIndex] = x;
        this.aY[pointIndex] = y;

        this.pointIndex++;

        this.aX[pointIndex] = x;
        this.aY[pointIndex] = y;
    }

    public void movePoint(int x, int y){
        this.aX[pointIndex] = x;
        this.aY[pointIndex] = y;
    }

    public void addPoint(int x, int y) {
        this.pointIndex++;
        this.aX[pointIndex] = x;
        this.aY[pointIndex] = y;
    }


    public abstract void draw(Graphics graphics);
    public abstract void redraw(Graphics graphics);
    public abstract GShapeTool clone();
}
