package VeB.helper.render.renderClassesFolder;

import com.fs.starfarer.api.graphics.SpriteAPI;
import org.lwjgl.util.vector.Vector2f;

import java.awt.*;

public class VeBlib_TriangleData {

    public VeBlib_TriangleData(Vector2f corner1, Vector2f corner2, Vector2f corner3, Color color, boolean filled) {
        this.corner1 = corner1;
        this.corner2 = corner2;
        this.corner3 = corner3;
        this.color = color;
        this.filled = filled;
    }

    public VeBlib_TriangleData(Vector2f corner1, Vector2f corner2, Vector2f corner3, Color color, boolean filled, SpriteAPI texture, boolean textureSide) {
        this.corner1 = corner1;
        this.corner2 = corner2;
        this.corner3 = corner3;
        this.color = color;
        this.filled = filled;
        this.texture = texture;
        this.textureSide = textureSide;
    }

    public SpriteAPI texture;

    public Vector2f corner1;
    public Vector2f corner2;
    public Vector2f corner3;
    public boolean filled;
    public boolean textureSide;//false for left bottom true for right top
    public Color color;

    public final static boolean BOTTOM_LEFT = false;
    public final static boolean TOP_RIGHT = true;

}
