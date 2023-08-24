package DEA.helper.render.renderClassesFolder;

import org.lwjgl.util.vector.Vector2f;

import java.awt.*;

public class DEAlib_CircleData {

    public DEAlib_CircleData(Vector2f Center,float raidus,int numSegments,boolean filled,Color circleColor) {
        this.Center = Center;
        this.raidus = raidus;
        this.numSegments = numSegments;
        this.filled = filled;
        this.circleColor = circleColor;
    }

    public Vector2f Center;
    public float raidus;
    public int numSegments;
    public Color circleColor;
    public boolean filled;


}
