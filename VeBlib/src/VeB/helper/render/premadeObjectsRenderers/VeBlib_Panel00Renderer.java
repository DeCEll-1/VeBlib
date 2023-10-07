package VeB.helper.render.premadeObjectsRenderers;

import VeB.helper.VeBlib_Statics;
import VeB.helper.render.premadeObjects.VeBlib_Panel00Animation;
import VeB.helper.render.premadeObjects.VeBlib_Panel00Panel;
import VeB.helper.render.renderClassesFolder.VeBlib_SquareData;
import cmu.gui.CMUKitUI;
import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.combat.BaseCombatLayeredRenderingPlugin;
import com.fs.starfarer.api.combat.CombatEngineLayers;
import com.fs.starfarer.api.combat.ViewportAPI;
import com.fs.starfarer.api.graphics.SpriteAPI;
import org.lazywizard.lazylib.MathUtils;
import org.lwjgl.util.vector.Vector2f;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import static VeB.helper.render.VeBlib_RenderPluginFunctions.DrawSquare;

public class VeBlib_Panel00Renderer extends BaseCombatLayeredRenderingPlugin {

    /*
     *panel00_top_left              panel00_top             panel00_top_right
     *
     *
     *
     *panel00_left                  panel00_center          panel00_right
     *
     *
     *
     *panel00_bot_left              panel00_bot             panel00_bot_right
     *
     *
     * */


    //region textures
    private SpriteAPI top_left = Global.getSettings().getSprite("ui", "panel00_top_left");
    private SpriteAPI top = Global.getSettings().getSprite("ui", "panel00_top");
    private SpriteAPI top_right = Global.getSettings().getSprite("ui", "panel00_top_right");


    private SpriteAPI left = Global.getSettings().getSprite("ui", "panel00_left");
    private SpriteAPI center = Global.getSettings().getSprite("ui", "panel00_center");
    private SpriteAPI right = Global.getSettings().getSprite("ui", "panel00_right");


    private SpriteAPI bot_left = Global.getSettings().getSprite("ui", "panel00_bot_left");
    private SpriteAPI bot = Global.getSettings().getSprite("ui", "panel00_bot");
    private SpriteAPI bot_right = Global.getSettings().getSprite("ui", "panel00_bot_right");
//endregion

    private CombatEngineLayers CURRENT_LAYER = CombatEngineLayers.JUST_BELOW_WIDGETS;

    private VeBlib_Panel00Animation panelToRenderAnimated = null;
    private VeBlib_Panel00Animation panelToRenderAnimatedMain = null;
    private boolean continueAnimation = true;

    private ViewportAPI viewport = null;

    private VeBlib_Panel00Panel panelToRender = null;

    public void resetAnimation() {
        this.panelToRenderAnimated = new VeBlib_Panel00Animation(panelToRenderAnimated.fromPanel, panelToRenderAnimated.toPanel, panelToRenderAnimated.timeNeeded);
//        panelToRenderAnimated = panelToRenderAnimatedMain;
        panelToRender = null;
    }

    public void stopContinueAnimation() {
        continueAnimation = !continueAnimation;
    }

    public void changeViewport(ViewportAPI viewport) {
        this.viewport = viewport;
    }

    public VeBlib_Panel00Renderer(VeBlib_Panel00Panel panelToRender) {
        this.panelToRender = panelToRender;
    }

    public VeBlib_Panel00Renderer(VeBlib_Panel00Animation panelToRenderAnimated) {
        this.panelToRenderAnimated = panelToRenderAnimated;
        this.panelToRenderAnimatedMain = panelToRenderAnimated;
    }

    public void updateSprites() {
        top_left = Global.getSettings().getSprite("ui", "panel00_top_left");
        top = Global.getSettings().getSprite("ui", "panel00_top");
        top_right = Global.getSettings().getSprite("ui", "panel00_top_right");


        left = Global.getSettings().getSprite("ui", "panel00_left");
        center = Global.getSettings().getSprite("ui", "panel00_center");
        right = Global.getSettings().getSprite("ui", "panel00_right");


        bot_left = Global.getSettings().getSprite("ui", "panel00_bot_left");
        bot = Global.getSettings().getSprite("ui", "panel00_bot");
        bot_right = Global.getSettings().getSprite("ui", "panel00_bot_right");
    }

    @Override
    public void advance(float amount) {


        if (panelToRenderAnimated == null) return;
        if (!continueAnimation) return;

        if (panelToRenderAnimated.finished) {
            panelToRender = panelToRenderAnimated.toPanel;
            updateSprites();
            return;
        }

        updateSprites();

        panelToRenderAnimated.advance();

        panelToRender = panelToRenderAnimated.currPanel;


    }


    @Override
    public void render(CombatEngineLayers layer, ViewportAPI viewport) {
        //i am no longer paranoid and wont put try catch yay!

        viewport = this.viewport;

        if (panelToRender == null) return;
        if (!continueAnimation) return;

        CMUKitUI.openGLForMisc();

        //only RENDER the animated things do NOT advance them use the advance()

        List<VeBlib_SquareData> squareList = new ArrayList<>();

        //region draw

        //region left
        VeBlib_SquareData topLeftSquare = new VeBlib_SquareData(
                panelToRender.topLeft,
                new Vector2f(
                        panelToRender.topLeft.x + 32f,
                        panelToRender.topLeft.y
                ),//top right
                new Vector2f(
                        panelToRender.topLeft.x,
                        panelToRender.topLeft.y - 32f
                ),//bottom left
                new Vector2f(
                        panelToRender.topLeft.x + 32f,
                        panelToRender.topLeft.y - 32f
                ),//bottom right
                null,
                true,
                top_left,
                VeBlib_SquareData.TILE
        );
        squareList.add(topLeftSquare);

        VeBlib_SquareData leftSquare = new VeBlib_SquareData(
                topLeftSquare.leftBottom,
                new Vector2f(
                        topLeftSquare.leftBottom.x + 32f,
                        topLeftSquare.leftBottom.y
                ),//top right
                new Vector2f(
                        topLeftSquare.leftBottom.x,
                        topLeftSquare.leftBottom.y - MathUtils.getDistance(panelToRender.topLeft, panelToRender.bottomLeft) - 64f
                ),//bottom left
                new Vector2f(
                        topLeftSquare.leftBottom.x + 32f,
                        topLeftSquare.leftBottom.y - MathUtils.getDistance(panelToRender.topLeft, panelToRender.bottomLeft) - 64f
                ),//bottom right
                null,
                true,
                left,
                VeBlib_SquareData.TILE
        );
        squareList.add(leftSquare);

        VeBlib_SquareData bottomLeftSquare = new VeBlib_SquareData(
                leftSquare.leftBottom,
                new Vector2f(
                        leftSquare.leftBottom.x + 32f,
                        leftSquare.leftBottom.y
                ),//top right
                new Vector2f(
                        leftSquare.leftBottom.x,
                        leftSquare.leftBottom.y - 32f
                ),//bottom left
                new Vector2f(
                        leftSquare.leftBottom.x + 32f,
                        leftSquare.leftBottom.y - 32f
                ),//bottom right
                null,
                true,
                bot_left,
                VeBlib_SquareData.TILE
        );
        squareList.add(bottomLeftSquare);

//endregion

        //region middle

        VeBlib_SquareData topSquare = new VeBlib_SquareData(
                topLeftSquare.rightTop,//top left
                new Vector2f(
                        topLeftSquare.rightTop.x + MathUtils.getDistance(panelToRender.topLeft, panelToRender.topRight) - 64f,
                        topLeftSquare.rightTop.y
                ),//top right
                new Vector2f(
                        topLeftSquare.rightTop.x,
                        topLeftSquare.rightTop.y - 32f
                ),//bottom left
                new Vector2f(
                        topLeftSquare.rightTop.x + MathUtils.getDistance(panelToRender.topLeft, panelToRender.topRight) - 64f,
                        topLeftSquare.rightTop.y - 32f
                ),//bottom right
                null,
                true,
                top,
                VeBlib_SquareData.TILE
        );
        squareList.add(topSquare);

        VeBlib_SquareData middleSquare = new VeBlib_SquareData(
                topSquare.leftBottom,
                new Vector2f(
                        topSquare.leftBottom.x + MathUtils.getDistance(panelToRender.topLeft, panelToRender.topRight) - 64f,
                        topSquare.leftBottom.y
                ),//top right
                new Vector2f(
                        topSquare.leftBottom.x,
                        topSquare.leftBottom.y - MathUtils.getDistance(panelToRender.topLeft, panelToRender.bottomLeft) - 64f
                ),//bottom left
                new Vector2f(
                        topSquare.leftBottom.x + MathUtils.getDistance(panelToRender.topLeft, panelToRender.topRight) - 64f,
                        topSquare.leftBottom.y - MathUtils.getDistance(panelToRender.topLeft, panelToRender.bottomLeft) - 64f
                ),//bottom right
                VeBlib_Statics.transparent,
                true,
                center,
                VeBlib_SquareData.TILE
        );
        squareList.add(middleSquare);

        VeBlib_SquareData bottomSquare = new VeBlib_SquareData(
                middleSquare.leftBottom,//top left
                new Vector2f(
                        middleSquare.leftBottom.x + MathUtils.getDistance(panelToRender.topLeft, panelToRender.topRight) - 64f,
                        middleSquare.leftBottom.y
                ),//top right
                new Vector2f(
                        middleSquare.leftBottom.x,
                        middleSquare.leftBottom.y - 32f
                ),//bottom left
                new Vector2f(
                        middleSquare.leftBottom.x + MathUtils.getDistance(panelToRender.topLeft, panelToRender.topRight) - 64f,
                        middleSquare.leftBottom.y - 32f
                ),//bottom right
                null,
                true,
                bot,
                VeBlib_SquareData.TILE
        );
        squareList.add(bottomSquare);

        //endregion

        //region right
        VeBlib_SquareData topRightSquare = new VeBlib_SquareData(
                topSquare.rightTop,//top left
                new Vector2f(
                        topSquare.rightTop.x + 32f,
                        topSquare.rightTop.y
                ),//top right
                new Vector2f(
                        topSquare.rightTop.x,
                        topSquare.rightTop.y - 32f
                ),//bottom left
                new Vector2f(
                        topSquare.rightTop.x + 32f,
                        topSquare.rightTop.y - 32f
                ),//bottom right
                null,
                true,
                top_right,
                VeBlib_SquareData.TILE
        );
        squareList.add(topRightSquare);

        VeBlib_SquareData rightSquare = new VeBlib_SquareData(
                topRightSquare.leftBottom,
                new Vector2f(
                        topRightSquare.leftBottom.x + 32f,
                        topRightSquare.leftBottom.y
                ),//top right
                new Vector2f(
                        topRightSquare.leftBottom.x,
                        topRightSquare.leftBottom.y - MathUtils.getDistance(panelToRender.topLeft, panelToRender.bottomLeft) - 64f
                ),//bottom left
                new Vector2f(
                        topRightSquare.leftBottom.x + 32f,
                        topRightSquare.leftBottom.y - MathUtils.getDistance(panelToRender.topLeft, panelToRender.bottomLeft) - 64f
                ),//bottom right
                null,
                true,
                right,
                VeBlib_SquareData.TILE
        );
        squareList.add(rightSquare);

        VeBlib_SquareData bottomRightSquare = new VeBlib_SquareData(
                rightSquare.leftBottom,
                new Vector2f(
                        rightSquare.leftBottom.x + 32f,
                        rightSquare.leftBottom.y
                ),//top right
                new Vector2f(
                        rightSquare.leftBottom.x,
                        rightSquare.leftBottom.y - 32f
                ),//bottom left
                new Vector2f(
                        rightSquare.leftBottom.x + 32f,
                        rightSquare.leftBottom.y - 32f
                ),//bottom right
                null,
                true,
                bot_right,
                VeBlib_SquareData.TILE
        );
        squareList.add(bottomRightSquare);

        renderSquares(squareList, viewport);

        //endregion

        //endregion


        CMUKitUI.closeGLForMisc();


    }

    private void renderSquares(List<VeBlib_SquareData> squares, ViewportAPI viewport) {

        for (VeBlib_SquareData square : squares) {
            DrawSquare(
                    square.leftTop,
                    square.rightTop,
                    square.leftBottom,
                    square.rightBottom,
                    null,
                    true,
                    square.texture,
                    square.textureMode,
                    viewport
            );
        }
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
