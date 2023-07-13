package DEA.helper.render;

import DEA.helper.DEA_Logger;
import DEA.helper.UNUSED.DEA_RenderHelper;
import DEA.helper.render.renderClassesFolder.DEA_BoxData;
import cmu.gui.CMUKitUI;
import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.combat.ViewportAPI;
import org.lazywizard.lazylib.MathUtils;
import org.lazywizard.lazylib.VectorUtils;
import org.lwjgl.util.vector.Vector2f;

import org.lwjgl.BufferUtils;

import java.util.List;
import java.awt.*;
import java.nio.FloatBuffer;


import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glFlush;
import static org.lwjgl.opengl.GL12.GL_ALIASED_LINE_WIDTH_RANGE;
import static org.lwjgl.opengl.GL12.GL_SMOOTH_LINE_WIDTH_RANGE;

public class DEA_RenderPluginFunctions {

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
    public static void DEA_DrawPolygonWHeightAndCenter(Vector2f center, float sides, float circleAngle, float height, java.awt.Color lineColor, ViewportAPI viewport) {


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
            DEA_RenderPluginFunctions.DEA_DrawLineWWidthForPlugin(from, to, 4f, lineColor, viewport);//400 makes orbiting lines same for -400//doesnt work rn
            z++;
        }
    }

    public static void DEA_DrawLineForPlugin(Vector2f from, Vector2f to, Color lineColor, ViewportAPI viewport) {
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

    public static void DEA_DrawLineWWidthForPlugin(Vector2f fromCenter, Vector2f toCenter, float width, Color lineColor, ViewportAPI viewport) {

        float angle = VectorUtils.getAngle(fromCenter, toCenter);


        Vector2f leftBottom = MathUtils.getPointOnCircumference(fromCenter, width / 2, angle + 90);
        Vector2f rightBottom = MathUtils.getPointOnCircumference(fromCenter, width / 2, angle - 90);

        Vector2f leftTop = MathUtils.getPointOnCircumference(toCenter, width / 2, angle + 90);
        Vector2f rightTop = MathUtils.getPointOnCircumference(toCenter, width / 2, angle - 90);

//        glPolygonMode(GL_FRONT_AND_BACK, GL_FILL);
//        glBegin(GL_QUADS);

//        glColor4f(255 / lineColor.getRed(), 255 / lineColor.getGreen(), 255 / lineColor.getBlue(), 255 / lineColor.getAlpha());

        DEA_DrawBox(leftTop, rightTop, leftBottom, rightBottom, lineColor, GL_FILL, viewport);

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

    public static void DEA_DrawBox(Vector2f leftTop, Vector2f rightTop, Vector2f leftBottom, Vector2f rightBottom, Color lineColor, int PolygonModeMode, ViewportAPI viewport) {
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

    public static void DEA_DrawPolygon(List<Vector2f> vector2fList, List<Color> colorList) {

    }

}
