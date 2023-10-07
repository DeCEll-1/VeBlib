package VeB.helper.render.renderClassesFolder;

import org.lwjgl.util.vector.Vector2f;

import java.awt.*;

public class VeBlib_PointData {
//not used

    public VeBlib_PointData(Vector2f location, float pointSize, Color color) {
        this.location = location;
        this.color = color;
        this.pointSize = pointSize;
    }


    public Vector2f location;
    public float pointSize;

    public Color color;

}
