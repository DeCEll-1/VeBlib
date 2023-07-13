package DEA.helper.render.renderClassesFolder;

import org.lwjgl.util.vector.Vector2f;

import java.awt.*;

public class DEA_PolygonWHeightAndCenterData {

    public DEA_PolygonWHeightAndCenterData(Vector2f center, float sides, float circleAngle, float height, java.awt.Color lineColor) {
        this.center = center;
        this.sides = sides;
        this.circleAngle = circleAngle;
        this.height = height;
        this.lineColor = lineColor;
    }

    public Vector2f center;
    public float sides;
    public float circleAngle;
    public float height;
    public Color lineColor;

}
