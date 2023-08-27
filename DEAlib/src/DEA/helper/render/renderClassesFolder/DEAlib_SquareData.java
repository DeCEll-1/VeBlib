package DEA.helper.render.renderClassesFolder;

import com.fs.starfarer.api.graphics.SpriteAPI;
import org.lwjgl.util.vector.Vector2f;

import java.awt.*;

public class DEAlib_SquareData {


    public DEAlib_SquareData(Vector2f leftTop, Vector2f rightTop, Vector2f leftBottom, Vector2f rightBottom, Color lineColor, boolean filled) {
        this.leftTop = leftTop;
        this.rightTop = rightTop;
        this.leftBottom = leftBottom;
        this.rightBottom = rightBottom;
        this.lineColor = lineColor;
        this.filled = filled;
        this.texture = null;
    }

    public DEAlib_SquareData(Vector2f leftTop, Vector2f rightTop, Vector2f leftBottom, Vector2f rightBottom, Color lineColor, boolean filled, SpriteAPI texture) {
        this.leftTop = leftTop;
        this.rightTop = rightTop;
        this.leftBottom = leftBottom;
        this.rightBottom = rightBottom;
        this.lineColor = lineColor;
        this.filled = filled;
        this.texture = texture;
    }


    public Vector2f leftTop;
    public Vector2f rightTop;
    public Vector2f leftBottom;
    public Vector2f rightBottom;
    public boolean filled;
    public Color lineColor;
    public SpriteAPI texture;
}
