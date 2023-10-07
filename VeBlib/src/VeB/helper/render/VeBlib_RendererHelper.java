package VeB.helper.render;

import com.fs.starfarer.api.combat.ViewportAPI;
import org.lwjgl.util.vector.Vector2f;

import java.util.ArrayList;
import java.util.List;

public class VeBlib_RendererHelper {

    public static Vector2f worldVectorToScreenVector(Vector2f worldVector, ViewportAPI viewport) {
        return new Vector2f(viewport.convertWorldXtoScreenX(worldVector.x), viewport.convertWorldYtoScreenY(worldVector.y));//screen vector
    }

    public static List<Vector2f> worldVectorToScreenVector(List<Vector2f> worldVectorList, ViewportAPI viewport) {

        List<Vector2f> screenVectorList = new ArrayList<>();

        for (Vector2f screenVector : worldVectorList) {

            screenVectorList.add(worldVectorToScreenVector(screenVector, viewport));

        }

        return screenVectorList;//screen vector
    }

}
