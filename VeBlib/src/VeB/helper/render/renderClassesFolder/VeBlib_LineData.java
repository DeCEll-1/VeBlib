package VeB.helper.render.renderClassesFolder;

import java.awt.Color;

import org.lwjgl.util.vector.Vector2f;

public class VeBlib_LineData {

    public VeBlib_LineData(Vector2f from, Vector2f to, Color lineColor) {
        this.from = from;
        this.to = to;
        this.lineColor = lineColor;
    }

    public Vector2f from;

    public Vector2f to;

    public Color lineColor;

}
