package VeB.helper.render.renderClassesFolder;

import com.fs.starfarer.api.graphics.SpriteAPI;
import org.lwjgl.util.vector.Vector2f;

import java.awt.*;

public class VeBlib_SquareData {


    public VeBlib_SquareData(Vector2f leftTop, Vector2f rightTop, Vector2f leftBottom, Vector2f rightBottom, Color color, boolean filled) {
        this.leftTop = leftTop;
        this.rightTop = rightTop;
        this.leftBottom = leftBottom;
        this.rightBottom = rightBottom;
        this.color = color;
        this.filled = filled;
        this.texture = null;
    }

    public VeBlib_SquareData(Vector2f leftTop, Vector2f rightTop, Vector2f leftBottom, Vector2f rightBottom, Color color, boolean filled, SpriteAPI texture, int textureMode) {
        this.leftTop = leftTop;
        this.rightTop = rightTop;
        this.leftBottom = leftBottom;
        this.rightBottom = rightBottom;
        this.color = color;
        this.filled = filled;
        this.texture = texture;
        this.textureMode = textureMode;
    }


    public Vector2f leftTop;
    public Vector2f rightTop;
    public Vector2f leftBottom;
    public Vector2f rightBottom;
    public boolean filled;
    public Color color;
    public SpriteAPI texture;
    public int textureMode;

    public final static int TILE = 0;
    public final static int SCALE = 1;
}
