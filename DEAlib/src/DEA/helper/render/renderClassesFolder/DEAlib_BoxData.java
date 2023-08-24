package DEA.helper.render.renderClassesFolder;

import org.lwjgl.util.vector.Vector2f;

import java.awt.*;

public class DEAlib_BoxData {

    public DEAlib_BoxData(Vector2f leftTop, Vector2f rightTop, Vector2f leftBottom, Vector2f rightBottom, Color lineColor, boolean filled) {
        this.leftTop = leftTop;
        this.rightTop = rightTop;
        this.leftBottom = leftBottom;
        this.rightBottom = rightBottom;
        this.lineColor = lineColor;
        this.filled = filled;
    }

    public Vector2f leftTop;
    public Vector2f rightTop;
    public Vector2f leftBottom;
    public Vector2f rightBottom;
    public boolean filled;
    public Color lineColor;
}
