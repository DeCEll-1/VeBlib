package DEA.helper.helperHelperClasses;

import org.lwjgl.util.vector.Vector2f;

public class DEAlib_TriangleData {

    public DEAlib_TriangleData(Vector2f corner1, Vector2f corner2, Vector2f corner3) {
        this.corner1 = corner1;
        this.corner2 = corner2;
        this.corner3 = corner3;
    }

    public DEAlib_TriangleData() {

    }

    ;

    public Vector2f corner1;
    public Vector2f corner2;
    public Vector2f corner3;


}
