package VeB.helper.render;

import VeB.helper.render.renderClassesFolder.*;
import cmu.gui.CMUKitUI;
import com.fs.starfarer.api.combat.BaseCombatLayeredRenderingPlugin;
import com.fs.starfarer.api.combat.CombatEngineLayers;
import com.fs.starfarer.api.combat.ViewportAPI;
import org.lwjgl.util.vector.Vector2f;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import static VeB.helper.render.VeBlib_RendererHelper.*;


;

public class VeBlib_RendererPlugin extends BaseCombatLayeredRenderingPlugin {

    //ok ima try explain how to use this ball
    //simply add this to addLayeredRenderingPlugin ONCE per script, like make a pritave variable or smthin like:
//    private VeBlib_RendererPlugin plugin = null;
    //and add
//if (plugin == null) {
//        plugin = new VeBlib_RendererPlugin();
//        Global.getCombatEngine().addLayeredRenderingPlugin(plugin);
//    }
    //if you add a plugin every frame it will obviously make the game shit itself and cry saying AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA so please dont do this to the game thank you
    //then you just, run whatever render script you want from DEA_RenderHelper and it works (hopefully(might not work(i hope it does)))

    //https://youtu.be/FF22Fsx-XbA?t=3
    //Jesse!
    //Bu ne amına koyayım!

    //JESSE
    //AMOGUS JESSİE

    //dont you get annoyed when the sdk shets itself when you open the ide and you have to close and open the sdk again? only me? ok

    private CombatEngineLayers CURRENT_LAYER = CombatEngineLayers.ABOVE_SHIPS_AND_MISSILES_LAYER;

    private List<VeBlib_LineData> lines;
    private List<VeBlib_LineWWidthData> lineWWidths;
    private List<VeBlib_RingData> RingData;
    private List<VeBlib_SquareData> SquareDatas;
    private List<VeBlib_TriangleData> TriangleDatas;
    private List<VeBlib_PolygonData> PolygonData;
    private List<VeBlib_CircleData> CircleData;
    private List<VeBlib_SphereData> SphereData;
//    private List<VeBlib_PointData> PointData;
//    private List<DEAlib_CustomFunctionData> CustomFunctionData;


    @Override
    public void render(CombatEngineLayers layer, ViewportAPI viewport) {
        try {//this probably wont do anything but i feel paranoid about it so

            CMUKitUI.openGLForMisc();

//            glPushMatrix();
//            glDisable(GL_TEXTURE_2D);
//            glEnable(GL_BLEND);
//            glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

//            glPushAttrib(GL_ALL_ATTRIB_BITS);
//            glMatrixMode(GL_PROJECTION);
//            glPushMatrix();
//            glLoadIdentity();
//            glMatrixMode(GL_MODELVIEW);
//            glPushMatrix();
//            glLoadIdentity();
//            glDisable(GL_TEXTURE_2D);
//            glEnable(GL_BLEND);
//            glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
//            glViewport(0, 0, Display.getWidth(), Display.getHeight());
//            glOrtho(0.0, (double) Display.getWidth(), 0.0, (double) Display.getHeight(), -1.0, 1.0);
//            glTranslatef(0.01f, 0.01f, 0f);
//            glEnable(GL_LINE_SMOOTH);
//            glHint(GL_LINE_SMOOTH_HINT, GL_NICEST);
//            glLineWidth(1.5f);//i stole this from https://github.com/DesperatePeter/starsector-symbiotic-void-creatures/blob/main/src/tecrys/svc/utils/GLUtils.kt and will ask about it if itd workd but it didnt so

//            glDisable(GL_TEXTURE_2D);

            if (lines != null) {
                if (lines.size() != 0) {
                    for (VeBlib_LineData line : lines) {
                        VeBlib_RenderPluginFunctions.DrawLineForPlugin(
                                new Vector2f(viewport.convertWorldXtoScreenX(line.from.x), viewport.convertWorldYtoScreenY(line.from.y)),
                                new Vector2f(viewport.convertWorldXtoScreenX(line.to.x), viewport.convertWorldYtoScreenY(line.to.y)),
                                line.lineColor,
                                viewport);
                    }
                }
            }

            if (lineWWidths != null) {

                if (lineWWidths.size() != 0) {
                    for (VeBlib_LineWWidthData lineWWidth : lineWWidths) {
                        VeBlib_RenderPluginFunctions.DrawLineWWidthForPlugin(
                                lineWWidth.fromCenter,
                                lineWWidth.toCenter,
                                lineWWidth.width,
                                lineWWidth.lineColor,
                                viewport
                        );
                    }
                }
            }

            if (RingData != null) {
                if (RingData.size() != 0) {
                    for (VeBlib_RingData Ring : RingData) {
                        VeBlib_RenderPluginFunctions.DrawRing(
                                Ring.center, Ring.segments, Ring.circleAngle, Ring.height, Ring.lineWidth, Ring.lineColor, viewport);
                    }
                }
            }

            if (SquareDatas != null) {
                if (SquareDatas.size() != 0) {
                    for (VeBlib_SquareData square : SquareDatas) {
                        if (square.texture == null) {
                            VeBlib_RenderPluginFunctions.DrawSquare(
                                    worldVectorToScreenVector(square.leftTop, viewport),
                                    worldVectorToScreenVector(square.rightTop, viewport),
                                    worldVectorToScreenVector(square.leftBottom, viewport),
                                    worldVectorToScreenVector(square.rightBottom, viewport),
                                    square.color,
                                    square.filled,
                                    viewport
                            );
                        } else {
                            VeBlib_RenderPluginFunctions.DrawSquare(
                                    worldVectorToScreenVector(square.leftTop, viewport),
                                    worldVectorToScreenVector(square.rightTop, viewport),
                                    worldVectorToScreenVector(square.leftBottom, viewport),
                                    worldVectorToScreenVector(square.rightBottom, viewport),
                                    square.color,
                                    square.filled,
                                    square.texture,
                                    square.textureMode,
                                    viewport
                            );
                        }
                    }
                }
            }

            if (TriangleDatas != null) {
                if (TriangleDatas.size() != 0) {
                    for (VeBlib_TriangleData triangle : TriangleDatas) {
                        if (triangle.texture == null) {
                            VeBlib_RenderPluginFunctions.DrawTriangle(
                                    worldVectorToScreenVector(triangle.corner1, viewport),
                                    worldVectorToScreenVector(triangle.corner2, viewport),
                                    worldVectorToScreenVector(triangle.corner3, viewport),
                                    triangle.color,
                                    triangle.filled,
                                    viewport
                            );
                        } else {
                            VeBlib_RenderPluginFunctions.DrawTriangle(
                                    worldVectorToScreenVector(triangle.corner1, viewport),
                                    worldVectorToScreenVector(triangle.corner2, viewport),
                                    worldVectorToScreenVector(triangle.corner3, viewport),
                                    triangle.color,
                                    triangle.filled,
                                    triangle.texture,
                                    triangle.textureSide,
                                    viewport
                            );
                        }

                    }
                }
            }

            if (PolygonData != null) {
                if (PolygonData.size() != 0) {
                    for (VeBlib_PolygonData polygon : PolygonData) {
                        VeBlib_RenderPluginFunctions.DrawPolygon(
                                worldVectorToScreenVector(polygon.vector2fList, viewport),
                                polygon.colorList,
                                polygon.filled,
                                viewport
                        );
                    }
                }
            }

            if (CircleData != null) {
                if (CircleData.size() != 0) {
                    for (VeBlib_CircleData circle : CircleData) {
                        VeBlib_RenderPluginFunctions.drawCircle(
                                worldVectorToScreenVector(circle.Center, viewport),
                                viewport.convertScreenWidthToWorldWidth(circle.raidus),
                                circle.numSegments,
                                circle.filled,
                                circle.circleColor,
                                viewport
                        );
                    }
                }
            }

            //region useless stuff

//            if (PointData != null) {
//                if (PointData.size() != 0) {
//                    for (VeBlib_PointData point : PointData) {
//                        VeBlib_RenderPluginFunctions.DrawPoint(point.location, point.pointSize, point.color, viewport);
//                    }
//                }
//            }


            //dont use this
            if (SphereData != null) {
                if (SphereData.size() != 0) {
                    for (VeBlib_SphereData sphere : SphereData) {

//                        DEAlib_Sphere sphere1 = new DEAlib_Sphere(sphere.numTriangles, sphere.center, sphere.height, sphere.width, sphere.texture, viewport);//this does all the work, see the script
//
//                        sphere1.render();
//DO NOT USE THİS game doesnt allow using spheres on combat or smthin  (afai tested ofc which was like a day, if you manage to do it ping me @.7556 i wanna see how you made it)
                        VeBlib_SphereWGLU.DEAlib_Sphere(sphere.center, sphere.radius, sphere.slices, sphere.stacks, sphere.sphere, sphere.texture, viewport);


                    }
                }
            }

//this shit doesnt work for "secuwity weasowns" or because of skill issue
//            if (CustomFunctionData != null) {
//                if (CustomFunctionData.size() != 0) {
//                    for (DEAlib_CustomFunctionData function : CustomFunctionData) {
//                        try {
//                            function.TheClass.getMethod(function.MethodName, function.cArgs).invoke(null, function.Variables);
//                        } catch (Exception ex) {
//                            DEAlib_Logger.DEA_log(DEAlib_RendererPlugin.class, function.TheClass.toString() + " RENDER PLUGIN(İ) ERROR crashed at function " + function.MethodName.toString(), "\nREASON: " + ex.toString());
//                        }
//                    }
//                }
//            }


//            glEnable(GL_TEXTURE_2D);

//            glPopMatrix();

//            glDisable(GL_BLEND);
//            glPopMatrix();
//            glMatrixMode(GL_PROJECTION);
//            glPopMatrix();
//            glPopAttrib();

            //endregion
            CMUKitUI.closeGLForMisc();
            reset();
        } catch (Exception ex) {
            return;
        }
    }

    public void reset() {
        this.lines = new ArrayList<>();
        this.lineWWidths = new ArrayList<>();
        this.RingData = new ArrayList<>();
        this.SquareDatas = new ArrayList<>();
        this.TriangleDatas = new ArrayList<>();
        this.PolygonData = new ArrayList<>();
        this.CircleData = new ArrayList<>();
        this.SphereData = new ArrayList<>();
    }

    public void LineInPlugin(List<VeBlib_LineData> lines) {
        this.lines = lines;
    }

    public void LineWWidthInPlugin(List<VeBlib_LineWWidthData> lineWWidths) {
        this.lineWWidths = lineWWidths;
    }


    public void Ring(List<VeBlib_RingData> RingData) {
        this.RingData = RingData;
    }

    public void SquareInPlugin(List<VeBlib_SquareData> BoxDatas) {
        this.SquareDatas = BoxDatas;
    }

    public void TriangleInPlugin(List<VeBlib_TriangleData> TriangleDatas) {
        this.TriangleDatas = TriangleDatas;
    }

    public void PolygonInPlugin(List<VeBlib_PolygonData> PolygonData) {
        this.PolygonData = PolygonData;
    }

    public void CircleInPlugin(List<VeBlib_CircleData> CircleData) {
        this.CircleData = CircleData;
    }

    private void SphereInPlugin(List<VeBlib_SphereData> SphereData) {
        this.SphereData = SphereData;
    }

//    private void PointInPlugin(List<VeBlib_PointData> PointData) {
//        this.PointData = PointData;
//    }

    public void ChangeRenderLayerInPlugin(CombatEngineLayers LAYER) {
        this.CURRENT_LAYER = LAYER;
    }

    @Override
    public boolean isExpired() {
        return false;
    }

    @Override
    public float getRenderRadius() {
        return Float.MAX_VALUE;
    }

    @Override
    public EnumSet<CombatEngineLayers> getActiveLayers() {
        return EnumSet.of(CURRENT_LAYER);
    }

}
