package VeB.helper.render;

import VeB.helper.render.renderClassesFolder.*;
import cmu.gui.CMUKitUI;
import com.fs.starfarer.api.campaign.CampaignEngineLayers;
import com.fs.starfarer.api.campaign.SectorEntityToken;
import com.fs.starfarer.api.combat.ViewportAPI;
import com.fs.starfarer.api.impl.campaign.BaseCustomEntityPlugin;

import java.util.List;

public class VeBlib_CustomCampaignEntittyForRenderV2 extends BaseCustomEntityPlugin {

    public VeBlib_CustomCampaignEntittyForRenderV2(SectorEntityToken plugin) {
        this.entity = plugin;
    }

    @Override
    public void advance(float amount) {

//        Global.getSector().getPlayerFleet().addFloatingText("" + amount, Color.BLACK, amount);

    }

    public VeBlib_CustomCampaignEntittyForRenderV2() {
    }

    private CampaignEngineLayers CURRENT_LAYER = CampaignEngineLayers.ABOVE;

    private List<VeBlib_LineData> lines = null;
    private List<VeBlib_LineWWidthData> lineWWidths = null;
    private List<VeBlib_RingData> RingData = null;
    private List<VeBlib_SquareData> SquareDatas = null;
    private List<VeBlib_TriangleData> TriangleDatas = null;
    private List<VeBlib_PolygonData> PolygonData = null;
    private List<VeBlib_CircleData> CircleData = null;
    private List<VeBlib_SphereData> SphereData = null;

//    private void getData() {
//        this.lines = DEAlib_Statics.DEAlib_CampaignRenderer.getlines();
//        this.lineWWidths = DEAlib_Statics.DEAlib_CampaignRenderer.getlineWWidths();
//        this.RingData = DEAlib_Statics.DEAlib_CampaignRenderer.getRingData();
//        this.SquareDatas = DEAlib_Statics.DEAlib_CampaignRenderer.getSquareDatas();
//        this.TriangleDatas = DEAlib_Statics.DEAlib_CampaignRenderer.getTriangleDatas();
//        this.PolygonData = DEAlib_Statics.DEAlib_CampaignRenderer.getPolygonData();
//        this.CircleData = DEAlib_Statics.DEAlib_CampaignRenderer.getCircleData();
//        this.SphereData = DEAlib_Statics.DEAlib_CampaignRenderer.getSphereData();
//    }

    @Override
    public void init(SectorEntityToken entity, Object pluginParams) {
        super.init(entity, pluginParams);
        this.entity = entity;
    }

    @Override
    public float getRenderRange() {
        return Float.MAX_VALUE;
    }

    @Override
    public boolean isMapTooltipExpandable() {
        return false;
    }

    @Override
    public boolean hasCustomMapTooltip() {
        return false;
    }

//    @Override
//    public void render(CampaignEngineLayers layer, ViewportAPI viewport) {
//        try {//this probably wont do anything but i feel paranoid about it so
//
////            getData();
//
//            CMUKitUI.openGLForMisc();
//
////            glPushMatrix();
////            glDisable(GL_TEXTURE_2D);
////            glEnable(GL_BLEND);
////            glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
//
////            glPushAttrib(GL_ALL_ATTRIB_BITS);
////            glMatrixMode(GL_PROJECTION);
////            glPushMatrix();
////            glLoadIdentity();
////            glMatrixMode(GL_MODELVIEW);
////            glPushMatrix();
////            glLoadIdentity();
////            glDisable(GL_TEXTURE_2D);
////            glEnable(GL_BLEND);
////            glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
////            glViewport(0, 0, Display.getWidth(), Display.getHeight());
////            glOrtho(0.0, (double) Display.getWidth(), 0.0, (double) Display.getHeight(), -1.0, 1.0);
////            glTranslatef(0.01f, 0.01f, 0f);
////            glEnable(GL_LINE_SMOOTH);
////            glHint(GL_LINE_SMOOTH_HINT, GL_NICEST);
////            glLineWidth(1.5f);//i stole this from https://github.com/DesperatePeter/starsector-symbiotic-void-creatures/blob/main/src/tecrys/svc/utils/GLUtils.kt and will ask about it if itd workd but it didnt so
//
////            glDisable(GL_TEXTURE_2D);
//
//            if (lines != null) {
//                if (lines.size() != 0) {
//                    for (VeBlib_LineData line : lines) {
//                        VeBlib_RenderPluginFunctions.DrawLineForPlugin(line.from, line.to, line.lineColor, viewport);
//                    }
//                }
//            }
//
//            if (lineWWidths != null) {
//
//                if (lineWWidths.size() != 0) {
//                    for (VeBlib_LineWWidthData lineWWidth : lineWWidths) {
//                        VeBlib_RenderPluginFunctions.DrawLineWWidthForPlugin(lineWWidth.fromCenter, lineWWidth.toCenter, lineWWidth.width, lineWWidth.lineColor, viewport);
//                    }
//                }
//            }
//
//            if (RingData != null) {
//                if (RingData.size() != 0) {
//                    for (VeBlib_RingData Ring : RingData) {
//                        VeBlib_RenderPluginFunctions.DrawRing(Ring.center, Ring.segments, Ring.circleAngle, Ring.height, Ring.lineWidth, Ring.lineColor, viewport);
//                    }
//                }
//            }
//
//            if (SquareDatas != null) {
//                if (SquareDatas.size() != 0) {
//                    for (VeBlib_SquareData square : SquareDatas) {
//                        if (square.texture == null) {
//                            VeBlib_RenderPluginFunctions.DrawSquare(square.leftTop, square.rightTop, square.leftBottom, square.rightBottom, square.lineColor, square.filled, viewport);
//                        } else {
//                            VeBlib_RenderPluginFunctions.DrawSquare(square.leftTop, square.rightTop, square.leftBottom, square.rightBottom, square.lineColor, square.filled, square.texture, viewport);
//                        }
//                    }
//                }
//            }
//
//            if (TriangleDatas != null) {
//                if (TriangleDatas.size() != 0) {
//                    for (VeBlib_TriangleData triangle : TriangleDatas) {
//                        if (triangle.texture == null) {
//                            VeBlib_RenderPluginFunctions.DrawTriangle(triangle.corner1, triangle.corner2, triangle.corner3, triangle.color, triangle.filled, viewport);
//                        } else {
//                            VeBlib_RenderPluginFunctions.DrawTriangle(triangle.corner1, triangle.corner2, triangle.corner3, triangle.color, triangle.filled, triangle.texture, triangle.textureSide, viewport);
//                        }
//
//                    }
//                }
//            }
//
//            if (PolygonData != null) {
//                if (PolygonData.size() != 0) {
//                    for (VeBlib_PolygonData polygon : PolygonData) {
//                        VeBlib_RenderPluginFunctions.DrawPolygon(polygon.vector2fList, polygon.colorList, polygon.filled, viewport);
//                    }
//                }
//            }
//
//            if (CircleData != null) {
//                if (CircleData.size() != 0) {
//                    for (VeBlib_CircleData circle : CircleData) {
//                        VeBlib_RenderPluginFunctions.drawCircle(circle.Center, circle.raidus, circle.numSegments, circle.filled, circle.circleColor, viewport);
//                    }
//                }
//            }
//
//            //dont use this
//            if (SphereData != null) {
//                if (SphereData.size() != 0) {
//                    for (VeBlib_SphereData sphere : SphereData) {
//
////                        DEAlib_Sphere sphere1 = new DEAlib_Sphere(sphere.numTriangles, sphere.center, sphere.height, sphere.width, sphere.texture, viewport);//this does all the work, see the script
////
////                        sphere1.render();
////DO NOT USE THİS game doesnt allow using spheres on combat because fuck you  (afai tested ofc which was like a day, if you manage to do it ping me @.7556 i wanna see how you made it)
//                        VeBlib_SphereWGLU.DEAlib_Sphere(sphere.center, sphere.radius, sphere.slices, sphere.stacks, sphere.sphere, sphere.texture, viewport);
//
//
//                    }
//                }
//            }
//
////this shit doesnt work for "secuwity weasowns" or because of skill issue
////            if (CustomFunctionData != null) {
////                if (CustomFunctionData.size() != 0) {
////                    for (DEAlib_CustomFunctionData function : CustomFunctionData) {
////                        try {
////                            function.TheClass.getMethod(function.MethodName, function.cArgs).invoke(null, function.Variables);
////                        } catch (Exception ex) {
////                            DEAlib_Logger.DEA_log(DEAlib_RendererPlugin.class, function.TheClass.toString() + " RENDER PLUGIN(İ) ERROR crashed at function " + function.MethodName.toString(), "\nREASON: " + ex.toString());
////                        }
////                    }
////                }
////            }
//
//
////            glEnable(GL_TEXTURE_2D);
//
////            glPopMatrix();
//
////            glDisable(GL_BLEND);
////            glPopMatrix();
////            glMatrixMode(GL_PROJECTION);
////            glPopMatrix();
////            glPopAttrib();
//
//            CMUKitUI.closeGLForMisc();
//        } catch (Exception ex) {
//            return;
//        }
//    }

//    public void reset() {
//        this.lines = null;
//        this.lineWWidths = null;
//        this.RingData = null;
//        this.SquareDatas = null;
//        this.TriangleDatas = null;
//        this.PolygonData = null;
//        this.CircleData = null;
//        this.SphereData = null;
//    }
//
//    private void nullCheck() {
//        if (this.lines == null) this.lines = new ArrayList<>();
//        if (this.lineWWidths == null) this.lineWWidths = new ArrayList<>();
//        if (this.RingData == null) this.RingData = new ArrayList<>();
//        if (this.SquareDatas == null) this.SquareDatas = new ArrayList<>();
//        if (this.TriangleDatas == null) this.TriangleDatas = new ArrayList<>();
//        if (this.PolygonData == null) this.PolygonData = new ArrayList<>();
//        if (this.CircleData == null) this.CircleData = new ArrayList<>();
//        if (this.SphereData == null) this.SphereData = new ArrayList<>();
//
//    }

    public void LineInPlugin(List<VeBlib_LineData> lines) {
        this.lines = lines;
    }

    public void LineWWidthInPlugin(List<VeBlib_LineWWidthData> lineWWidths) {
        this.lineWWidths = lineWWidths;
    }


    public void Ring(List<VeBlib_RingData> RingData) {
        this.RingData = RingData;
    }

    public void SquareInPlugin(List<VeBlib_SquareData> SquareDatas) {
        this.SquareDatas = SquareDatas;
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

    public void SphereInPlugin(List<VeBlib_SphereData> SphereData) {
        this.SphereData = SphereData;
    }


}
