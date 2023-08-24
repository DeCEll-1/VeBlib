package DEA.helper.render.renderClassesFolder;

import org.lwjgl.util.vector.Vector2f;

import java.awt.*;

public class DEAlib_RingData {

    public DEAlib_RingData(Vector2f center, float segments, float circleAngle, float height,float lineWidth, java.awt.Color lineColor) {
        this.center = center;
        this.segments = segments;
        this.circleAngle = circleAngle;
        this.height = height;
        this.lineWidth = lineWidth;
        this.lineColor = lineColor;
    }

    public Vector2f center;
    public float segments;
    public float circleAngle;
    public float height;
    public float lineWidth;
    public Color lineColor;

}
