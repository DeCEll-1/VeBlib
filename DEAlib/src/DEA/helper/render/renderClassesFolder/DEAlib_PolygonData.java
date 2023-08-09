package DEA.helper.render.renderClassesFolder;

import org.lwjgl.util.vector.Vector2f;

import java.awt.*;
import java.util.List;


public class DEAlib_PolygonData {

    public DEAlib_PolygonData(List<Vector2f> vector2fList, List<Color> colorList, int PolygonModeMode) {
        this.vector2fList = vector2fList;
        this.colorList = colorList;
        this.PolygonModeMode = PolygonModeMode;
    }

    public List<Vector2f> vector2fList;

    public List<Color> colorList;

    public int PolygonModeMode;

}
