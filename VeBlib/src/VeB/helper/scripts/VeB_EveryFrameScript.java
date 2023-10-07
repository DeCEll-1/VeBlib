package VeB.helper.scripts;

import VeB.helper.render.VeBlib_CustomCampaignEntittyForRenderV2;
import VeB.helper.render.renderClassesFolder.*;
import com.fs.starfarer.api.EveryFrameScript;
import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.SectorEntityToken;
import com.fs.starfarer.api.combat.ViewportAPI;
import org.lwjgl.util.vector.Vector2f;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class VeB_EveryFrameScript implements EveryFrameScript {

    private boolean doOnce = true;

    private VeBlib_CustomCampaignEntittyForRenderV2 CustomCampaignEntittyForRender;

    /**
     * @return true when the script is finished and can be cleaned up by the engine.
     */
    @Override
    public boolean isDone() {
        return false;
    }

    /**
     * @return whether advance() should be called while the campaign engine is paused.
     */
    @Override
    public boolean runWhilePaused() {
        return true;
    }

    private List<VeBlib_LineData> lines = new ArrayList<>();
    public List<VeBlib_LineData> getlines(){
        return lines;
    }
    private List<VeBlib_LineWWidthData> lineWWidths = new ArrayList<>();
    public List<VeBlib_LineWWidthData> getlineWWidths(){
        return lineWWidths;
    }
    private List<VeBlib_RingData> RingData = new ArrayList<>();
    public List<VeBlib_RingData> getRingData(){
        return RingData;
    }
    private List<VeBlib_SquareData> SquareDatas = new ArrayList<>();
    public List<VeBlib_SquareData> getSquareDatas(){
        return SquareDatas;
    }
    private List<VeBlib_TriangleData> TriangleDatas = new ArrayList<>();
    public List<VeBlib_TriangleData> getTriangleDatas(){
        return TriangleDatas;
    }
    private List<VeBlib_PolygonData> PolygonData = new ArrayList<>();
    public List<VeBlib_PolygonData> getPolygonData(){
        return PolygonData;
    }
    private List<VeBlib_CircleData> CircleData = new ArrayList<>();
    public List<VeBlib_CircleData> getCircleData(){
        return CircleData;
    }
    private List<VeBlib_SphereData> SphereData = new ArrayList<>();
    public List<VeBlib_SphereData> getSphereData(){
        return SphereData;
    }

    private void reset() {
        this.lines = new ArrayList<>();
        this.lineWWidths = new ArrayList<>();
        this.RingData = new ArrayList<>();
        this.SquareDatas = new ArrayList<>();
        this.TriangleDatas = new ArrayList<>();
        this.PolygonData = new ArrayList<>();
        this.CircleData = new ArrayList<>();
        this.SphereData = new ArrayList<>();
    }

    /**
     * Use SectorAPI.getClock() to convert to campaign days.
     *
     * @param amount seconds elapsed during the last frame.
     */
    @Override
    public void advance(float amount) {
        if (doOnce) {

            for (SectorEntityToken entity : Global.getSector().getEntitiesWithTag("dealib_renderer_old")) {
                entity.getStarSystem().removeEntity(entity);
            }
//            for (SectorEntityToken entity : Global.getSector().getEntitiesWithTag("dealib_renderer_V2")) {entity.getStarSystem().removeEntity(entity);}//uncomment this when the new version of renderer comes

//            Global.getSector().getEntityById("dealib_render_plugin_thingEveryFrameScript").getStarSystem().removeEntity(Global.getSector().getEntityById("dealib_render_plugin_thingEveryFrameScript"));

            if (Global.getSector().getEntityById("dealib_render_plugin_thingEveryFrameScriptV2") == null) {//update this with new renderer id when the version comes
                SectorEntityToken token = Global.getSector().getPlayerFleet().getStarSystem().addCustomEntity(
                        "dealib_render_plugin_thingV2_Render",
                        "",
                        "dealib_render_plugin_thingV2",
                        "derelict"
                );

                CustomCampaignEntittyForRender = new VeBlib_CustomCampaignEntittyForRenderV2(token);

                CustomCampaignEntittyForRender.init(token, null);
            } else {
                SectorEntityToken token = Global.getSector().getEntityById("dealib_render_plugin_thingV2_Render");

                CustomCampaignEntittyForRender = new VeBlib_CustomCampaignEntittyForRenderV2(token);
                CustomCampaignEntittyForRender.init(token, null);
            }
            doOnce = false;
        }

        reset();

        ViewportAPI viewport = Global.getSector().getViewport();

        VeBlib_SquareData square = new VeBlib_SquareData(
                new Vector2f(viewport.convertScreenXToWorldX(0f), viewport.convertScreenYToWorldY(1f)),
                new Vector2f(viewport.convertScreenXToWorldX(1f), viewport.convertScreenYToWorldY(1f)),
                new Vector2f(viewport.convertScreenXToWorldX(0f), viewport.convertScreenYToWorldY(0f)),
                new Vector2f(viewport.convertScreenXToWorldX(1f), viewport.convertScreenYToWorldY(0f)),
                Color.white,
                true
        );

//        DEAlib_Statics.DEAlib_CampaignRenderer.reset();

        List<VeBlib_SquareData> squareDataList = new ArrayList<>();
        squareDataList.add(square);

//        DEAlib_Statics.DEAlib_CampaignRenderer.SquareInPlugin(squareDataList);

//        CustomCampaignEntittyForRender.SquareInPlugin(squareDataList);


    }

    public void LineInPlugin(List<VeBlib_LineData> lines) {
        this.lines.addAll(lines);
    }

    public void LineWWidthInPlugin(List<VeBlib_LineWWidthData> lineWWidths) {
        this.lineWWidths.addAll(lineWWidths);
    }


    public void Ring(List<VeBlib_RingData> RingData) {
        this.RingData.addAll(RingData);
    }

    public void SquareInPlugin(List<VeBlib_SquareData> SquareDatas) {
        this.SquareDatas.addAll(SquareDatas);
    }

    public void TriangleInPlugin(List<VeBlib_TriangleData> TriangleDatas) {
        this.TriangleDatas.addAll(TriangleDatas);
    }

    public void PolygonInPlugin(List<VeBlib_PolygonData> PolygonData) {
        this.PolygonData.addAll(PolygonData);
    }

    public void CircleInPlugin(List<VeBlib_CircleData> CircleData) {
        this.CircleData.addAll(CircleData);
    }

    public void SphereInPlugin(List<VeBlib_SphereData> SphereData) {
        this.SphereData.addAll(SphereData);
    }

}
