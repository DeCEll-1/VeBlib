package DEA.helper.render;

import DEA.helper.DEAlib_Logger;
import DEA.helper.DEAlib_VectorHelper;
import DEA.helper.helperHelperClasses.DEAlib_TriangleData;
import com.fs.starfarer.api.combat.ViewportAPI;
import org.lazywizard.lazylib.MathUtils;
import org.lazywizard.lazylib.VectorUtils;
import org.lwjgl.util.vector.Vector2f;

import java.util.*;
import java.awt.*;
import java.util.List;


import static org.lwjgl.opengl.GL11.*;

public class DEAlib_RenderPluginFunctions {

    //dont run anything here outside of render

    /**
     * makes polygon with height 30 makes a circle like thing</br>
     * <p>
     * MAX SİDES İS 360F the method wont do anything if you put more than that and return false</br>
     *
     * @param center      center of the circle
     * @param sides       amount of sides the "circle" will have
     * @param circleAngle angle of the circle, yk i named this circle but you can use this to make triangles and stuff too so thats for this, can be 0 but cant be more than 360
     * @param height      height of the circle
     * @param lineColor   color of the line
     */
    public static void DEAlib_DrawPolygonWHeightAndCenter(Vector2f center, float sides, float circleAngle, float height, java.awt.Color lineColor, ViewportAPI viewport) {

//        StarSystemAPI jsut change the location of the system

        if (sides > 360f || circleAngle > 360f) {
//            return "DEA_ERROR please put less than 360 and more than 0";
            return;
        }
//            errText.append("passed side validation");
//            errText.append("    *-*   ");


        Vector2f from = new Vector2f();
        Vector2f to = new Vector2f();

        from = MathUtils.getPointOnCircumference(center, height, circleAngle);
        int z = 0;

        for (float i = circleAngle; i < circleAngle + 360 + sides; i += 360 / sides) {
            if (z % 2 == 0) {
                to = MathUtils.getPointOnCircumference(center, height, i);
            } else {
                from = MathUtils.getPointOnCircumference(center, height, i);
            }
            DEAlib_RenderPluginFunctions.DEAlib_DrawLineWWidthForPlugin(from, to, 4f, lineColor, viewport);//400 makes orbiting lines same for -400//doesnt work rn
            z++;
        }
    }

    public static void DEAlib_DrawLineForPlugin(Vector2f from, Vector2f to, Color lineColor, ViewportAPI viewport) {
        glBegin(GL_LINE_STRIP);
//
//        FloatBuffer floatBuffer = BufferUtils.createFloatBuffer(16);
//
//        glGetFloat(GL_SMOOTH_LINE_WIDTH_RANGE, floatBuffer);
//
//        DEA_Logger.DEA_log(DEA_RenderPluginFunctions.class, "BufferUtils.createFloatBuffer(2) - ", "   first element:" + String.valueOf(floatBuffer.get(0)),"   second element:"+ String.valueOf(floatBuffer.get(1)));
//
//        DEA_Logger.DEA_log(DEA_RenderPluginFunctions.class, "glGetFloat(GL_SMOOTH_LINE_WIDTH_RANGE) - ", String.valueOf(glGetFloat(GL_ALIASED_LINE_WIDTH_RANGE)));

        glColor4f(255 / lineColor.getRed(), 255 / lineColor.getGreen(), 255 / lineColor.getBlue(), 255 / lineColor.getAlpha());

        glVertex2f(viewport.convertWorldXtoScreenX(from.x), viewport.convertWorldYtoScreenY(from.y));
        glVertex2f(viewport.convertWorldXtoScreenX(to.x), viewport.convertWorldYtoScreenY(to.y));
        glEnd();


    }

    public static void DEAlib_DrawLineWWidthForPlugin(Vector2f fromCenter, Vector2f toCenter, float width, Color lineColor, ViewportAPI viewport) {

        float angle = VectorUtils.getAngle(fromCenter, toCenter);


        Vector2f leftBottom = MathUtils.getPointOnCircumference(fromCenter, width / 2, angle + 90);
        Vector2f rightBottom = MathUtils.getPointOnCircumference(fromCenter, width / 2, angle - 90);

        Vector2f leftTop = MathUtils.getPointOnCircumference(toCenter, width / 2, angle + 90);
        Vector2f rightTop = MathUtils.getPointOnCircumference(toCenter, width / 2, angle - 90);

//        glPolygonMode(GL_FRONT_AND_BACK, GL_FILL);
//        glBegin(GL_QUADS);

//        glColor4f(255 / lineColor.getRed(), 255 / lineColor.getGreen(), 255 / lineColor.getBlue(), 255 / lineColor.getAlpha());

        DEAlib_DrawBox(leftTop, rightTop, leftBottom, rightBottom, lineColor, GL_FILL, viewport);

//        glColor4f(1, 0, 0, 255 / lineColor.getAlpha());
//
//        glVertex2f(viewport.convertWorldXtoScreenX(leftTop.x), viewport.convertWorldYtoScreenY(leftTop.y));
//        glVertex2f(viewport.convertWorldXtoScreenX(rightTop.x), viewport.convertWorldYtoScreenY(rightTop.y));
//        glVertex2f(viewport.convertWorldXtoScreenX(leftBottom.x), viewport.convertWorldYtoScreenY(leftBottom.y));
//
//
////        glPolygonMode(GL_FRONT_AND_BACK, GL_LINE);
////        glBegin(GL_LINE_LOOP);
//
////        glColor4f(0, 0, 1, 255 / lineColor.getAlpha());
//
//
//        glVertex2f(viewport.convertWorldXtoScreenX(rightBottom.x), viewport.convertWorldYtoScreenY(rightBottom.y));
//
//        glEnd();

//        glFlush();

    }

    public static void DEAlib_DrawBox(Vector2f leftTop, Vector2f rightTop, Vector2f leftBottom, Vector2f rightBottom, Color lineColor, int PolygonModeMode, ViewportAPI viewport) {
        glPolygonMode(GL_FRONT_AND_BACK, PolygonModeMode);
        glDisable(GL_TEXTURE_2D);//doesnt work without this
        glBegin(GL_TRIANGLE_STRIP);

        glColor4f(255 / lineColor.getRed(), 255 / lineColor.getGreen(), 255 / lineColor.getBlue(), 255 / lineColor.getAlpha());
        glVertex2f(viewport.convertWorldXtoScreenX(leftTop.x), viewport.convertWorldYtoScreenY(leftTop.y));
        glVertex2f(viewport.convertWorldXtoScreenX(rightTop.x), viewport.convertWorldYtoScreenY(rightTop.y));
        glVertex2f(viewport.convertWorldXtoScreenX(leftBottom.x), viewport.convertWorldYtoScreenY(leftBottom.y));
        glVertex2f(viewport.convertWorldXtoScreenX(rightBottom.x), viewport.convertWorldYtoScreenY(rightBottom.y));

//        glEnd();

//        glPolygonMode(GL_FRONT_AND_BACK, GL_LINE);
//        glBegin(GL_POLYGON);


        glEnd();
//        glFlush();
        glEnable(GL_TEXTURE_2D);

    }

    public static void DEA_DrawPolygon(List<Vector2f> vector2fList, List<Color> colorList, int PolygonModeMode, ViewportAPI viewport) {

//        Vector2f middlePoint = DEAlib_VectorHelper.DEAlib_GetTheMiddlePointInAVector2fList(vector2fList);

//        List<Vector2f> list = DEAlib_VectorHelper.DEAlib_ListVector2fsCounterClockwise(vector2fList);


        glPolygonMode(GL_FRONT_AND_BACK, PolygonModeMode);
        glDisable(GL_TEXTURE_2D);//doesnt work without this
        glBegin(GL_TRIANGLES);

        //region old
//        Vector2f triangleCorner1 = null;//so that you save the corners for triangle strip since you need them
//        Vector2f triangleCorner2 = null;
//
//        boolean turn = true;//turn for knowing which corner to replace
//
//        Iterator<Color> colorListIterator = colorList.iterator();
//
//        Color currentColor = Color.white;
//
//
//        for (Vector2f corner : list) {
//
//            if (triangleCorner1 == null) {
//
//                triangleCorner1 = corner;//gets the corner for start
//
//            } else if (triangleCorner2 == null) {
//
//                triangleCorner2 = corner;//gets the corner for start
//
//            }
//
//            if (triangleCorner1 != null &&
//                    triangleCorner2 != null) {
//
//
//                glColor4f(255 / currentColor.getRed(), 255 / currentColor.getGreen(), 255 / currentColor.getBlue(), 255 / currentColor.getAlpha());
//
//
//                glVertex2f(viewport.convertWorldXtoScreenX(triangleCorner1.x), viewport.convertWorldYtoScreenY(triangleCorner1.y));
//                glVertex2f(viewport.convertWorldXtoScreenX(triangleCorner2.x), viewport.convertWorldYtoScreenY(triangleCorner2.y));
//                glColor4f(1, 0, 0, 1);
//                glVertex2f(viewport.convertWorldXtoScreenX(middlePoint.x), viewport.convertWorldYtoScreenY(middlePoint.y));
//
//                if (colorListIterator.hasNext()) currentColor = colorListIterator.next();
//
//                if (!turn) {
//                    triangleCorner1 = corner;
//                    turn = !turn;
//                } else {
//                    triangleCorner2 = corner;
//                    turn = !turn;
//                }
//
//            }
//
//        }

        //endregion


        //region new



//        List<DEAlib_TriangleData> triangles = new ArrayList<>();
//        DEAlib_TriangleData currTriangle = new DEAlib_TriangleData(null, null, null);

        //i dont have any fucking idea on how this works i got this for from ai and it somehow works i dont give a fuck tho its 5 am it works



        //        for (Vector2f location : locations) {
//
//            if (currTriangle.corner1 == null) {
//
//                currTriangle.corner1 = location;
//
//            } else if (currTriangle.corner2 == null) {
//
//                currTriangle.corner2 = location;
//
//            } else if (currTriangle.corner3 == null) {
//
//                currTriangle.corner3 = location;
//
//                triangles.add(currTriangle);
//
//                currTriangle = new DEAlib_TriangleData(null, null, null);
//
//            } else {
//
//                triangles.add(currTriangle);
//
//                currTriangle = new DEAlib_TriangleData(null, null, null);
//
//            }
//
//            DEAlib_Logger.DEA_log(DEAlib_RenderPluginFunctions.class, String.valueOf(location.x)," - ", String.valueOf(location.y));
//
//        }
//
//        glColor4f(1, 0, 0, 1);//test
//
//        for (DEAlib_TriangleData triangle : triangles) {
//
//            glVertex2f(viewport.convertWorldXtoScreenX(triangle.corner1.x), viewport.convertWorldYtoScreenY(triangle.corner1.y));
//            glVertex2f(viewport.convertWorldXtoScreenX(triangle.corner2.x), viewport.convertWorldYtoScreenY(triangle.corner2.y));
//            glVertex2f(viewport.convertWorldXtoScreenX(triangle.corner3.x), viewport.convertWorldYtoScreenY(triangle.corner3.y));
//
//
//        }

        //endregion


        //region working one from chatgpt
        List<Vector2f> locations = DEAlib_VectorHelper.DEAlib_Triangulate(vector2fList);


        for (int i = 0; i < locations.size(); i += 3) {
            Vector2f corner1 = locations.get(i);
            Vector2f corner2 = locations.get(i + 1);
            Vector2f corner3 = locations.get(i + 2);

            glColor4f(1, 0, 0, 1); // Set color for the triangle
            glVertex2f(viewport.convertWorldXtoScreenX(corner1.x), viewport.convertWorldYtoScreenY(corner1.y));
            glVertex2f(viewport.convertWorldXtoScreenX(corner2.x), viewport.convertWorldYtoScreenY(corner2.y));
            glVertex2f(viewport.convertWorldXtoScreenX(corner3.x), viewport.convertWorldYtoScreenY(corner3.y));
        }

        //endregion

        glEnd();
//        glFlush();
        glEnable(GL_TEXTURE_2D);

    }

}
