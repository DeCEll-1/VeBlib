package DEA.helper.deepstorage;

import DEA.helper.DEAlib_VectorHelper;
import com.fs.starfarer.api.combat.ViewportAPI;
import org.lwjgl.util.vector.Vector2f;

import java.awt.*;
import java.util.Iterator;
import java.util.List;

import static org.lwjgl.opengl.GL11.*;

public class AAAAAAAAAAAA {

    public void function(java.util.List<Vector2f> vector2fList, List<Color> colorList, int PolygonModeMode, ViewportAPI viewport){
        vector2fList = DEAlib_VectorHelper.ListVector2fsClockwise(vector2fList);

        Vector2f middlePoint = DEAlib_VectorHelper.GetTheMiddlePointInAVector2fList(vector2fList);


        glPolygonMode(GL_FRONT_AND_BACK, PolygonModeMode);
        glDisable(GL_TEXTURE_2D);//doesnt work without this
        glBegin(GL_TRIANGLE_STRIP);

        Vector2f triangleCorner1 = null;//so that you save the corners for triangle strip since you need them
        Vector2f triangleCorner2 = null;

        boolean turn = false;//turn for knowing which corner to replace

        Iterator<Color> colorListIterator = colorList.iterator();

        Color currentColor = Color.white;

        for (Vector2f corner : vector2fList) {

            if (triangleCorner1 == null) {

                triangleCorner1 = corner;//gets the corner for start

            } else if (triangleCorner2 == null) {

                triangleCorner2 = corner;//gets the corner for start

            }

            if (triangleCorner1 != null &&
                    triangleCorner2 != null) {


                glColor4f(255 / currentColor.getRed(), 255 / currentColor.getGreen(), 255 / currentColor.getBlue(), 255 / currentColor.getAlpha());


                glVertex2f(viewport.convertWorldXtoScreenX(triangleCorner1.x), viewport.convertWorldYtoScreenY(triangleCorner1.y));
                glVertex2f(viewport.convertWorldXtoScreenX(triangleCorner2.x), viewport.convertWorldYtoScreenY(triangleCorner2.y));
                glVertex2f(viewport.convertWorldXtoScreenX(middlePoint.x), viewport.convertWorldYtoScreenY(middlePoint.y));

                if (colorListIterator.hasNext()) currentColor = colorListIterator.next();

                if (turn) {
                    triangleCorner1 = corner;
                    turn = false;
                } else {
                    triangleCorner2 = corner;
                    turn = true;
                }

            }

        }

        glEnd();
//        glFlush();
        glEnable(GL_TEXTURE_2D);
    }

}
