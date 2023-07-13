package DEA.helper.render;

import DEA.helper.render.renderClassesFolder.DEA_BoxData;
import DEA.helper.render.renderClassesFolder.DEA_LineData;
import DEA.helper.render.renderClassesFolder.DEA_LineWWidthData;
import DEA.helper.render.renderClassesFolder.DEA_PolygonWHeightAndCenterData;
import cmu.gui.CMUKitUI;
import com.fs.starfarer.api.combat.BaseCombatLayeredRenderingPlugin;
import com.fs.starfarer.api.combat.CombatEngineLayers;
import com.fs.starfarer.api.combat.ViewportAPI;
import org.lwjgl.opengl.Display;

import java.util.EnumSet;
import java.util.List;

import static org.lwjgl.opengl.GL11.*;
;

public class DEA_RendererPlugin extends BaseCombatLayeredRenderingPlugin {

    //ok ima try explain how to use this ball
    //simply add this to addLayeredRenderingPlugin ONCE per script, like make a pritave variable or smthin like:
    //private DEA.helper.plugins.DEA_RenderHelperPlugin plugin = null;
    //and add
    //if (plugin == null) {
    //      plugin = new renderPlugin((ShipAPI) stats.getEntity());
    //      Global.getCombatEngine().addLayeredRenderingPlugin(plugin);
    //}
    //if you add a plugin every frame it will obviously make the game shit itself and cry saying AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA so please dont do this to the game thank you
    //then you just, run whatever render script you want from DEA_RenderHelper and it works (hopefully(might not work(i hope it does)))

    //and pwease dont question this retarded coding :alpha:

//what the fuck have i cooked

    //https://youtu.be/FF22Fsx-XbA?t=3
    //Jesse!
    //Bu ne amına koyayım!

    private CombatEngineLayers CURRENT_LAYER = CombatEngineLayers.ABOVE_SHIPS_AND_MISSILES_LAYER;

    private List<DEA_LineData> lines;
    private List<DEA_LineWWidthData> lineWWidths;
    private List<DEA_PolygonWHeightAndCenterData> PolygonWHeightAndCenters;
    private List<DEA_BoxData> DEA_BoxDatas;

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
//            glLineWidth(1.5f);//i stole this from https://github.com/DesperatePeter/starsector-symbiotic-void-creatures/blob/main/src/tecrys/svc/utils/GLUtils.kt and will ask about it if it works but it didnt so

//            glDisable(GL_TEXTURE_2D);

            if (lines != null) {
                if (lines.size() != 0) {
                    for (DEA_LineData line : lines) {
                        DEA_RenderPluginFunctions.DEA_DrawLineForPlugin(line.from, line.to, line.lineColor, viewport);
                    }
                }
            }

            if (lineWWidths != null) {

                if (lineWWidths.size() != 0) {
                    for (DEA_LineWWidthData lineWWidth : lineWWidths) {
                        DEA_RenderPluginFunctions.DEA_DrawLineWWidthForPlugin(lineWWidth.fromCenter, lineWWidth.toCenter, lineWWidth.width, lineWWidth.lineColor, viewport);
                    }
                }
            }

            if (PolygonWHeightAndCenters != null) {
                if (PolygonWHeightAndCenters.size() != 0) {
                    for (DEA_PolygonWHeightAndCenterData PolygonWHeightAndCenter : PolygonWHeightAndCenters) {
                        DEA_RenderPluginFunctions.DEA_DrawPolygonWHeightAndCenter(PolygonWHeightAndCenter.center, PolygonWHeightAndCenter.sides, PolygonWHeightAndCenter.circleAngle, PolygonWHeightAndCenter.height, PolygonWHeightAndCenter.lineColor, viewport);
                    }
                }
            }

            if (DEA_BoxDatas != null) {
                if (DEA_BoxDatas.size() != 0) {
                    for (DEA_BoxData BoxData : DEA_BoxDatas) {
                        DEA_RenderPluginFunctions.DEA_DrawBox(BoxData.leftTop, BoxData.rightTop, BoxData.leftBottom, BoxData.rightBottom, BoxData.lineColor, BoxData.PolygonModeMode, viewport);
                    }
                }
            }

//            glEnable(GL_TEXTURE_2D);

//            glPopMatrix();

//            glDisable(GL_BLEND);
//            glPopMatrix();
//            glMatrixMode(GL_PROJECTION);
//            glPopMatrix();
//            glPopAttrib();

            CMUKitUI.closeGLForMisc();
        } catch (Exception ex) {
            return;
        }
    }

    public void DEA_DrawLineInPlugin(List<DEA_LineData> lines) {
        this.lines = lines;
    }

    public void DEA_DrawLineWWidthInPlugin(List<DEA_LineWWidthData> lineWWidths) {
        this.lineWWidths = lineWWidths;
    }


    public void DEA_DrawPolygonWHeightAndCenter(List<DEA_PolygonWHeightAndCenterData> PolygonWHeightAndCenters) {
        this.PolygonWHeightAndCenters = PolygonWHeightAndCenters;
    }

    public void DEA_DrawBoxInPlugin(List<DEA_BoxData> DEA_BoxDatas) {
        this.DEA_BoxDatas = DEA_BoxDatas;
    }

    public void DEA_ChangeRenderLayerInPlugin(CombatEngineLayers LAYER) {
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
