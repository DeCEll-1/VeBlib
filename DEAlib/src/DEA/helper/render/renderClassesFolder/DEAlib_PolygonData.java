package DEA.helper.render.renderClassesFolder;

import org.lwjgl.util.vector.Vector2f;

import java.awt.*;
import java.util.List;


public class DEAlib_PolygonData {

    public DEAlib_PolygonData(List<Vector2f> vector2fList, List<Color> colorList, boolean filled) {
        this.vector2fList = vector2fList;
        this.colorList = colorList;
        this.filled = filled;
    }

    public List<Vector2f> vector2fList;

    public List<Color> colorList;

    public boolean filled;

}
