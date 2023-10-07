package VeB.helper.render;

import VeB.helper.VeBlib_VectorHelper;
import VeB.helper.render.renderClassesFolder.VeBlib_SquareData;
import cmu.gui.CMUKitUI;
import com.fs.starfarer.api.combat.ViewportAPI;
import com.fs.starfarer.api.graphics.SpriteAPI;
import org.lazywizard.lazylib.MathUtils;
import org.lazywizard.lazylib.VectorUtils;
import org.lazywizard.lazylib.opengl.DrawUtils;
import org.lwjgl.util.vector.Vector2f;

import java.awt.*;
import java.util.List;


import static VeB.helper.render.VeBlib_RendererHelper.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL30.glGenerateMipmap;

public class VeBlib_RenderPluginFunctions {

    //dont run anything here outside of render

    /**
     * makes polygon with height 30 makes a circle like thing</br>
     * <p>
     * MAX SİDES İS 360F the method wont do anything if you put more than that and return false</br>
     *
     * @param center      center of the circle
     * @param segments    amount of sides the "circle" will have
     * @param circleAngle angle of the circle, yk i named this circle but you can use this to make triangles and stuff too so thats for this, can be 0 but cant be more than 360
     * @param height      height of the circle
     * @param lineWidth   height of the circle
     * @param lineColor   color of the line
     */
    public static void DrawRing(Vector2f center, float segments, float circleAngle, float height, float lineWidth, java.awt.Color lineColor, ViewportAPI viewport) {
        if (lineColor == null) return;

//        StarSystemAPI jsut change the location of the system


        if (segments > 360f || circleAngle > 360f) {
//            return "DEA_ERROR please put less than 360 and more than 0";
            return;
        }
//            errText.append("passed side validation");
//            errText.append("    *-*   ");


        Vector2f from = new Vector2f();
        Vector2f to = new Vector2f();

        from = MathUtils.getPointOnCircumference(center, height, circleAngle);
        int z = 0;

        for (float i = circleAngle; i < circleAngle + 360 + segments; i += 360 / segments) {
            if (z % 2 == 0) {
                to = MathUtils.getPointOnCircumference(center, height, i);
            } else {
                from = MathUtils.getPointOnCircumference(center, height, i);
            }
            VeBlib_RenderPluginFunctions.DrawLineWWidthForPlugin(from, to, lineWidth, lineColor, viewport);//400 makes orbiting lines same for -400//doesnt work rn
            z++;
        }
    }

    /**
     * draws a line, not suggested because you cant change width just use DEAlib_DrawLineWWidthForPlugin
     *
     * @param from      start of the line
     * @param to        end of the line
     * @param lineColor color of the line
     */
    public static void DrawLineForPlugin(Vector2f from, Vector2f to, Color lineColor, ViewportAPI viewport) {
        if (lineColor == null) return;
        glBegin(GL_LINE_STRIP);
//
//        FloatBuffer floatBuffer = BufferUtils.createFloatBuffer(16);
//
//        glGetFloat(GL_SMOOTH_LINE_WIDTH_RANGE, floatBuffer);
//
//        DEA_Logger.DEA_log(DEA_RenderPluginFunctions.class, "BufferUtils.createFloatBuffer(2) - ", "   first element:" + String.valueOf(floatBuffer.get(0)),"   second element:"+ String.valueOf(floatBuffer.get(1)));
//
//        DEA_Logger.DEA_log(DEA_RenderPluginFunctions.class, "glGetFloat(GL_SMOOTH_LINE_WIDTH_RANGE) - ", String.valueOf(glGetFloat(GL_ALIASED_LINE_WIDTH_RANGE)));

        glColor4f(lineColor.getRed() / 255f, lineColor.getGreen() / 255f, lineColor.getBlue() / 255f, lineColor.getAlpha() / 255f);


        glVertex2f(from.x, from.y);
        glVertex2f(to.x, to.y);
        glEnd();


    }

    /**
     * draws a line with width, thanks to the guy on usc that i forgot the name for the math :people_hugging:
     *
     * @param fromCenter start of the line
     * @param toCenter   end of the line
     * @param width      width
     * @param lineColor  color of the line
     */
    public static void DrawLineWWidthForPlugin(Vector2f fromCenter, Vector2f toCenter, float width, Color lineColor, ViewportAPI viewport) {

        if (lineColor == null) return;

        float angle = VectorUtils.getAngle(fromCenter, toCenter);


        Vector2f leftBottom = MathUtils.getPointOnCircumference(fromCenter, width / 2, angle + 90);
        Vector2f rightBottom = MathUtils.getPointOnCircumference(fromCenter, width / 2, angle - 90);

        Vector2f leftTop = MathUtils.getPointOnCircumference(toCenter, width / 2, angle + 90);
        Vector2f rightTop = MathUtils.getPointOnCircumference(toCenter, width / 2, angle - 90);

//        glPolygonMode(GL_FRONT_AND_BACK, GL_FILL);
//        glBegin(GL_QUADS);

//        glColor4f(255 / lineColor.getRed(), 255 / lineColor.getGreen(), 255 / lineColor.getBlue(), 255 / lineColor.getAlpha());


        DrawSquare(
                worldVectorToScreenVector(leftTop, viewport),
                worldVectorToScreenVector(rightTop, viewport),
                worldVectorToScreenVector(leftBottom, viewport),
                worldVectorToScreenVector(rightBottom, viewport),
                lineColor,
                true,
                viewport
        );

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

    /**
     * put the locations in the correct order for it to work properly<br>
     * 1---2<br>
     * &nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;|<br>
     * 3---4<br>
     *
     * @param leftTop     leftTop
     * @param rightTop    rightTop
     * @param leftBottom  leftBottom
     * @param rightBottom rightBottom
     * @param filled      is filled?
     * @param color       color
     */
    public static void DrawSquare(Vector2f leftTop, Vector2f rightTop, Vector2f leftBottom, Vector2f rightBottom, Color color, boolean filled, ViewportAPI viewport) {
        if (color == null) return;

        if (filled) {
            glPolygonMode(GL_FRONT_AND_BACK, GL_FILL);
        } else {
            glPolygonMode(GL_FRONT_AND_BACK, GL_LINE);
        }
        glDisable(GL_TEXTURE_2D);//doesnt work without this
        glBegin(GL_TRIANGLE_STRIP);

        glColor4f(color.getRed() / 255f, color.getGreen() / 255f, color.getBlue() / 255f, color.getAlpha() / 255f);

        glVertex2f(leftTop.x, leftTop.y);
        glVertex2f(rightTop.x, rightTop.y);
        glVertex2f(leftBottom.x, leftBottom.y);
        glVertex2f(rightBottom.x, rightBottom.y);

//        glEnd();

//        glPolygonMode(GL_FRONT_AND_BACK, GL_LINE);
//        glBegin(GL_POLYGON);


        glEnd();
//        glFlush();
        glEnable(GL_TEXTURE_2D);

    }

    /**
     * put the locations in the correct order for it to work properly <br>
     * 1---2<br>
     * &nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;|<br>
     * 3---4<br>
     *
     * @param leftTop     leftTop
     * @param rightTop    rightTop
     * @param leftBottom  leftBottom
     * @param rightBottom rightBottom
     * @param filled      is filled?
     * @param color       color
     * @param texture     texture
     */
    public static void DrawSquare(Vector2f leftTop, Vector2f rightTop, Vector2f leftBottom, Vector2f rightBottom, Color color, boolean filled, SpriteAPI texture, int textureMode, ViewportAPI viewport) {

        if (texture == null) return;

//        if (true) return;

        if (filled) {
            glPolygonMode(GL_FRONT_AND_BACK, GL_FILL);
        } else {
            glPolygonMode(GL_FRONT_AND_BACK, GL_LINE);
        }


        texture.bindTexture();

//        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
//        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);

        glEnable(GL_BLEND);//for transparency
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);//https://www.codeproject.com/Questions/512386/TransparentplustextureplusinplusOpenGL
        glEnable(GL_TEXTURE_2D);

        glBegin(GL_TRIANGLE_STRIP);


        if (color != null) {
            glColor4f(color.getRed() / 255f, color.getGreen() / 255f, color.getBlue() / 255f, color.getAlpha() / 255f);
        } else {
            color = texture.getColor();
            glColor4f(color.getRed() / 255f, color.getGreen() / 255f, color.getBlue() / 255f, color.getAlpha() / 255f);
        }

        if (textureMode == VeBlib_SquareData.SCALE) {

            glTexCoord2f(0f, texture.getTextureHeight());
            glVertex2f(leftTop.x, leftTop.y);

            glTexCoord2f(texture.getTextureWidth(), texture.getTextureHeight());
            glVertex2f(rightTop.x, rightTop.y);

            glTexCoord2f(0f, 0f);
            glVertex2f(leftBottom.x, leftBottom.y);

            glTexCoord2f(texture.getTextureWidth(), 0f);
            glVertex2f(rightBottom.x, rightBottom.y);

        } else if (textureMode == VeBlib_SquareData.TILE) {
//            glTexCoord2f(0f, texture.getHeight());
//            glVertex2f(leftTop.x, leftTop.y);
//
//            glTexCoord2f(texture.getWidth(), texture.getHeight());
//            glVertex2f(rightTop.x, rightTop.y);
//
//            glTexCoord2f(0f, 0f);
//            glVertex2f(leftBottom.x, leftBottom.y);
//
//            glTexCoord2f(texture.getWidth(), 0f);
//            glVertex2f(rightBottom.x, rightBottom.y);

//            glTexCoord2f(0f, 0.1f);
//            glVertex2f(leftTop.x, leftTop.y);
//
//            glTexCoord2f(0.1f, 0.1f);
//            glVertex2f(rightTop.x, rightTop.y);
//
//            glTexCoord2f(0f, 0f);
//            glVertex2f(leftBottom.x, leftBottom.y);
//
//            glTexCoord2f(0.1f, 0f);
//            glVertex2f(rightBottom.x, rightBottom.y);

            float texCoordHeight = (leftTop.y - leftBottom.y) / texture.getHeight();
            float texCoordWidth = (leftBottom.x - rightBottom.x) / texture.getWidth();

            if (texCoordHeight < 0) texCoordHeight *= -1;
            if (texCoordWidth < 0) texCoordWidth *= -1;

            glTexCoord2f(0f, texCoordHeight);
            glVertex2f(leftTop.x, leftTop.y);

            glTexCoord2f(texCoordWidth, texCoordHeight);
            glVertex2f(rightTop.x, rightTop.y);

            glTexCoord2f(0f, 0f);
            glVertex2f(leftBottom.x, leftBottom.y);

            glTexCoord2f(texCoordWidth, 0f);
            glVertex2f(rightBottom.x, rightBottom.y);


        }


        glEnd();
//        glFlush();
        glDisable(GL_TEXTURE_2D);
        glDisable(GL_BLEND);


        CMUKitUI.closeGLForMisc();
        try {
            texture.setWidth(MathUtils.getDistance(leftBottom, rightBottom));

            texture.setHeight(MathUtils.getDistance(leftBottom, leftTop));

            texture.render(leftBottom.x, leftBottom.y);

        } catch (Exception ex) {
        } finally {
            CMUKitUI.openGLForMisc();
        }


    }

    /**
     * makes a polygon with corners, can cause some lag. since this triangulation uses a middle point for triangulating stuff that haves holes will work wacky (if i could make a proper triangulation it wouldnt be a problem but i am shit at math this middle point one is made by chatgpt. (i tried making my own you can see the comments))
     *
     * @param vector2fList list of the corners of the polygon
     * @param colorList    color list, so that you can just yk have gradients and stuff, might not work as expected because of shity triangulation script
     *                     NOTE i will fix this thing and use a hash map instead of 2 lists for proper colors but its not now SO <b>colorList is not used right now</b>
     *                     CURRENTLY JUST RED
     * @param filled       is filled?
     */
    public static void DrawPolygon(List<Vector2f> vector2fList, List<Color> colorList, boolean filled, ViewportAPI viewport) {
        if (colorList == null) return;

//        Vector2f middlePoint = DEAlib_VectorHelper.DEAlib_GetTheMiddlePointInAVector2fList(vector2fList);

//        List<Vector2f> list = DEAlib_VectorHelper.DEAlib_ListVector2fsCounterClockwise(vector2fList);


        if (filled) {
            glPolygonMode(GL_FRONT_AND_BACK, GL_FILL);
        } else {
            glPolygonMode(GL_FRONT_AND_BACK, GL_LINE);
        }
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
//     todo add colors
        List<Vector2f> locations = VeBlib_VectorHelper.Triangulate(vector2fList);


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

    /**
     * draw circle, the script uses lazy libs draw circle thx to him for the script :people_hugging:
     *
     * @param Center      center of the circle
     * @param raidus      the raidus
     * @param circleColor color of the circle
     * @param numSegments the amount of sides the circle will have, higher numbers are more laggy so stick with low ones (dont mind it much tho :p)
     * @param filled      is filled?
     */
    public static void drawCircle(Vector2f Center, float raidus, int numSegments, boolean filled, Color circleColor, ViewportAPI viewport) {
        if (circleColor == null) return;
        glDisable(GL_TEXTURE_2D);
        glBegin(GL_LINE);

        glColor4f(circleColor.getRed() / 255f, circleColor.getGreen() / 255f, circleColor.getBlue() / 255f, circleColor.getAlpha() / 255f);


        DrawUtils.drawCircle(Center.x, Center.y, raidus, numSegments, filled);

        glEnd();
        glEnable(GL_TEXTURE_2D);
    }

    public static void DrawTriangle(Vector2f corner1, Vector2f corner2, Vector2f corner3, Color color, boolean filled, ViewportAPI viewport) {

        if (color == null) return;

        if (filled) {
            glPolygonMode(GL_FRONT_AND_BACK, GL_FILL);
        } else {
            glPolygonMode(GL_FRONT_AND_BACK, GL_LINE);
        }
        glDisable(GL_TEXTURE_2D);//doesnt work without this
        glBegin(GL_TRIANGLES);

        glColor4f(color.getRed() / 255f, color.getGreen() / 255f, color.getBlue() / 255f, color.getAlpha() / 255f);

        glVertex2f(corner1.x, corner1.y);
        glVertex2f(corner2.x, corner2.y);
        glVertex2f(corner3.x, corner3.y);

//        glEnd();

//        glPolygonMode(GL_FRONT_AND_BACK, GL_LINE);
//        glBegin(GL_POLYGON);


        glEnd();
//        glFlush();
        glEnable(GL_TEXTURE_2D);


    }

    public static void DrawTriangle(Vector2f corner1, Vector2f corner2, Vector2f corner3, Color color, boolean filled, SpriteAPI texture, Boolean textureSide, ViewportAPI viewport) {

//        if (color == null) return;

        if (texture == null) return;

        if (filled) {
            glPolygonMode(GL_FRONT_AND_BACK, GL_FILL);
        } else {
            glPolygonMode(GL_FRONT_AND_BACK, GL_LINE);
        }

//        texture.setTexHeight(17f);
//        texture.setTexWidth(17f);

//        texture.setHeight(64f);
//        texture.setWidth(64f);

        texture.bindTexture();

        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        glEnable(GL_TEXTURE_2D);//doesnt work without this
        glBegin(GL_TRIANGLES);


        if (color != null) {
            glColor4f(color.getRed() / 255f, color.getGreen() / 255f, color.getBlue() / 255f, color.getAlpha() / 255f);
        } else {
            color = texture.getColor();
            glColor4f(color.getRed() / 255f, color.getGreen() / 255f, color.getBlue() / 255f, color.getAlpha() / 255f);
        }

        if (!textureSide) {//left bottom


            glTexCoord2f(texture.getTextureWidth(), 0f);
            glVertex2f(corner1.x, corner1.y);

            glTexCoord2f(0f, 0f);
            glVertex2f(corner2.x, corner2.y);


            glTexCoord2f(0f, texture.getTextureHeight());
            glVertex2f(corner3.x, corner3.y);

        } else {

            glTexCoord2f(texture.getTextureWidth(), 0f);
            glVertex2f(corner1.x, corner1.y);

            glTexCoord2f(texture.getTextureWidth(), texture.getTextureHeight());
            glVertex2f(corner2.x, corner2.y);


            glTexCoord2f(0f, texture.getTextureHeight());
            glVertex2f(corner3.x, corner3.y);

        }
//        glEnd();

//        glPolygonMode(GL_FRONT_AND_BACK, GL_LINE);
//        glBegin(GL_POLYGON);


        glEnd();

//        glFlush();
        glDisable(GL_TEXTURE_2D);
        glDisable(GL_BLEND);


    }

//    public static void DrawPoint(Vector2f location, float pointSize, Color color, ViewportAPI viewport) {
//
//        glDisable(GL_TEXTURE_2D);
//
//        glPointSize(pointSize);
//
//        glColor4f(color.getRed() / 255f, color.getGreen() / 255f, color.getBlue() / 255f, color.getAlpha() / 255f);
//
//
//        glVertex2f(viewport.convertWorldXtoScreenX(location.x), viewport.convertWorldYtoScreenY(location.y));
//
//        glEnable(GL_TEXTURE_2D);
//    }

}
