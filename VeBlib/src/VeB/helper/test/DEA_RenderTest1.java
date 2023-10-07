//package DEA.helper.test;
//
//
//import DEA.helper.DEA_Logger;
//import DEA.helper.render.DEA_RenderPluginFunctions;
//import DEA.helper.render.renderClassesFolder.DEA_LineData;
//import com.fs.starfarer.api.combat.BaseCombatLayeredRenderingPlugin;
//import com.fs.starfarer.api.combat.CombatEngineLayers;
//import com.fs.starfarer.api.combat.ViewportAPI;
//import org.lazywizard.lazylib.MathUtils;
//import org.lazywizard.lazylib.VectorUtils;
//import org.lwjgl.util.vector.Vector2f;
//
//import java.awt.*;
//import java.util.EnumSet;
//import java.util.List;
//
//import static org.lwjgl.opengl.GL11.*;
//import static org.lwjgl.opengl.GL11.glFlush;
//
//public class DEA_RenderTest1 extends BaseCombatLayeredRenderingPlugin {
//
//    private List<DEA_LineData> lines;
//
//    @Override
//    public void render(CombatEngineLayers layer, ViewportAPI viewport) {
//
//        if (lines.size() != 0) {
//            for (DEA_LineData line : lines) {
//                DEA_RenderPluginFunctions.DEA_DrawLineForPlugin(line.from, line.to, line.lineColor, viewport);
//            }
//        }
//
//    }
//
//    @Override
//    public boolean isExpired() {
//        return false;
//    }
//
//    @Override
//    public float getRenderRadius() {
//        return Float.MAX_VALUE;
//    }
//
//    @Override
//    public EnumSet<CombatEngineLayers> getActiveLayers() {
//        return EnumSet.of(CombatEngineLayers.ABOVE_SHIPS_AND_MISSILES_LAYER);
//    }
//
//}
