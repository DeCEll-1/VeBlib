package VeB.helper.render;

import VeB.helper.render.premadeObjects.VeBlib_Panel00Animation;
import cmu.gui.CMUKitUI;
import com.fs.starfarer.api.combat.BaseCombatLayeredRenderingPlugin;
import com.fs.starfarer.api.combat.CombatEngineLayers;
import com.fs.starfarer.api.combat.ViewportAPI;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class VeBlib_AnimatedRendererPlugin extends BaseCombatLayeredRenderingPlugin {

    //this will be easier since i have some sort of knowledge on render now
    //right?

    private CombatEngineLayers CURRENT_LAYER = CombatEngineLayers.ABOVE_SHIPS_AND_MISSILES_LAYER;

    private List<VeBlib_Panel00Animation> VeBlib_Panel00AnimationList = new ArrayList<>();

    @Override
    public void advance(float amount) {



    }

    @Override
    public void render(CombatEngineLayers layer, ViewportAPI viewport) {
        //i am no longer paranoid and wont put try catch yay!


        CMUKitUI.openGLForMisc();

        //only RENDER the animated things do NOT advance them use the advance()


        CMUKitUI.closeGLForMisc();


    }

    public void PanelInPlugin(List<VeBlib_Panel00Animation> VeBlib_Panel00AnimationList) {
        this.VeBlib_Panel00AnimationList = VeBlib_Panel00AnimationList;
    }


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
