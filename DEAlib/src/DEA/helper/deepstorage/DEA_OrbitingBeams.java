package DEA.helper.deepstorage;

public class DEA_OrbitingBeams {

//    public static void DEA_DrawPolygonWHeightAndCenter(Vector2f center, float sides, float circleAngle, float height, java.awt.Color lineColor, ViewportAPI viewport) {
//
//
//        if (sides > 360f || circleAngle > 360f) {
////            return "DEA_ERROR please put less than 360 and more than 0";
//            return;
//        }
////            errText.append("passed side validation");
////            errText.append("    *-*   ");
//
//
//        Vector2f from = new Vector2f();
//        Vector2f to = new Vector2f();
//
//        from = MathUtils.getPointOnCircumference(center, height, circleAngle);
//        int z = 0;
//
//        for (float i = circleAngle; i < circleAngle + 360 + sides; i += 360 / sides) {
//            if (z % 2 == 0) {
//                to = MathUtils.getPointOnCircumference(center, height, i);
//            } else {
//                from = MathUtils.getPointOnCircumference(center, height, i);
//            }
//            DEA_RenderPluginFunctions.DEA_DrawLineWWidthForPlugin(from, to, 0f, lineColor, viewport);//400 makes orbiting lines same for -400
//            z++;
//        }
//    }
//
//    public static void DEA_DrawLineWWidthForPlugin(Vector2f fromCenter, Vector2f toCenter, float width, Color
//            lineColor, ViewportAPI viewport) {
//        Vector2f leftBottom = MathUtils.getPointOnCircumference(fromCenter, width / 2, 90 - VectorUtils.getAngle(fromCenter, toCenter));
//        Vector2f rightBottom = MathUtils.getPointOnCircumference(fromCenter, width / 2, 90 - VectorUtils.getAngle(fromCenter, toCenter));
//
//        Vector2f leftTop = MathUtils.getPointOnCircumference(toCenter, width / 2, 90 - VectorUtils.getAngle(fromCenter, toCenter));
//        Vector2f rightTop = MathUtils.getPointOnCircumference(toCenter, width / 2, 90 - VectorUtils.getAngle(fromCenter, toCenter));
//
//        glPolygonMode(GL_FRONT_AND_BACK, GL_LINE);
//        glBegin(GL_TRIANGLE_STRIP);
//
//        glColor4f(255 / lineColor.getRed(), 255 / lineColor.getGreen(), 255 / lineColor.getBlue(), 255 / lineColor.getAlpha());
//
//        glVertex2f(viewport.convertWorldXtoScreenX(leftTop.x), viewport.convertWorldYtoScreenY(leftTop.y));
//        glVertex2f(viewport.convertWorldXtoScreenX(rightTop.x), viewport.convertWorldYtoScreenY(rightTop.y));
//        glVertex2f(viewport.convertWorldXtoScreenX(leftBottom.x), viewport.convertWorldYtoScreenY(leftBottom.y));
//
//        glEnd();
//
//        glPolygonMode(GL_FRONT_AND_BACK, GL_LINE);
//        glBegin(GL_TRIANGLE_STRIP);
//
//        glVertex2f(viewport.convertWorldXtoScreenX(rightTop.x), viewport.convertWorldYtoScreenY(rightTop.y));
//        glVertex2f(viewport.convertWorldXtoScreenX(leftBottom.x), viewport.convertWorldYtoScreenY(leftBottom.y));
//        glVertex2f(viewport.convertWorldXtoScreenX(rightBottom.x), viewport.convertWorldYtoScreenY(rightBottom.y));
//
//        glEnd();
//
//        glFlush();
//
//    }
}
