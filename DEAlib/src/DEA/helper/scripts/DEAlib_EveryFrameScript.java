package DEA.helper.scripts;

import DEA.helper.plugins.ui.DEAlib_CustomCampaignEntittyForUI;
import DEA.helper.render.renderClassesFolder.DEAlib_BoxData;
import DEA.helper.render.renderClassesFolder.DEAlib_LineData;
import DEA.helper.render.renderClassesFolder.DEAlib_LineWWidthData;
import DEA.helper.render.renderClassesFolder.DEAlib_PolygonWHeightAndCenterData;
import com.fs.starfarer.api.EveryFrameScript;
import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.CampaignEngineLayers;
import com.fs.starfarer.api.campaign.SectorEntityToken;

import java.util.HashMap;
import java.util.List;

public class DEAlib_EveryFrameScript implements EveryFrameScript {

    private CampaignEngineLayers CURRENT_LAYER = CampaignEngineLayers.ABOVE;

    private HashMap<String, DEAlib_LineData> lines;
    private HashMap<String, DEAlib_LineWWidthData> lineWWidths;
    private HashMap<String, DEAlib_PolygonWHeightAndCenterData> PolygonWHeightAndCenters;
    private HashMap<String, DEAlib_BoxData> boxDatas;

    private boolean doOnce = true;

    private DEAlib_CustomCampaignEntittyForUI CustomCampaignEntittyForUI;

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

    /**
     * Use SectorAPI.getClock() to convert to campaign days.
     *
     * @param amount seconds elapsed during the last frame.
     */
    @Override
    public void advance(float amount) {
        if (doOnce) {
            if (Global.getSector().getEntityById("dealib_render_plugin_thingEveryFrameScript") == null) {
                SectorEntityToken token = Global.getSector().getPlayerFleet().getStarSystem().addCustomEntity(
                        "dealib_render_plugin_thingEveryFrameScript",
                        "",
                        "dealib_render_plugin_thing",
                        "derelict"
                );

                CustomCampaignEntittyForUI = new DEAlib_CustomCampaignEntittyForUI(token);

//                CustomCampaignEntittyForUI.init(token, token.getCustomPlugin());
            } else {
                SectorEntityToken token = Global.getSector().getEntityById("dealib_render_plugin_thingEveryFrameScript");

                CustomCampaignEntittyForUI = new DEAlib_CustomCampaignEntittyForUI(token);
            }
            doOnce = false;
        }

        if (lines != null) CustomCampaignEntittyForUI.DEAlib_DrawLineInPlugin(lines);
        if (lineWWidths != null) CustomCampaignEntittyForUI.DEAlib_DrawLineWWidth(lineWWidths);
        if (PolygonWHeightAndCenters != null)
            CustomCampaignEntittyForUI.DEAlib_DrawPolygonWHeightAndCenter(PolygonWHeightAndCenters);
        if (boxDatas != null) CustomCampaignEntittyForUI.DEAlib_DrawBoxIn(boxDatas);


    }

    public void DEAlib_DrawLineInPlugin(HashMap<String, DEAlib_LineData> lines) {
        if (lines == null) this.lines = new HashMap<String, DEAlib_LineData>();
        this.lines.putAll(lines);
    }

    public void DEAlib_RemoveLineInPlugin(List<String> linesToRemove) {
        for (String stringData : linesToRemove) {
            lines.remove(stringData);
        }
    }

    public void DEAlib_DrawLineWWidthInPlugin(HashMap<String, DEAlib_LineWWidthData> lineWWidths) {
        if (lineWWidths == null) this.lineWWidths = new HashMap<String, DEAlib_LineWWidthData>();
        this.lineWWidths.putAll(lineWWidths);
    }

    public void DEAlib_RemoveLineWWidthInPlugin(List<String> lineWWidthsToRemove) {
        for (String stringData : lineWWidthsToRemove) {
            lineWWidths.remove(stringData);
        }
    }

    public void DEAlib_DrawPolygonWHeightAndCenterInPlugin(HashMap<String, DEAlib_PolygonWHeightAndCenterData> PolygonWHeightAndCenters) {
        if (PolygonWHeightAndCenters == null)
            this.PolygonWHeightAndCenters = new HashMap<String, DEAlib_PolygonWHeightAndCenterData>();
        this.PolygonWHeightAndCenters.putAll(PolygonWHeightAndCenters);
    }

    public void DEAlib_RemovePolygonWHeightAndCenterInPlugin(List<String> PolygonWHeightAndCentersToRemove) {
        for (String stringData : PolygonWHeightAndCentersToRemove) {
            PolygonWHeightAndCenters.remove(stringData);
        }
    }

    public void DEAlib_DrawBoxInPlugin(HashMap<String, DEAlib_BoxData> DEA_BoxDatas) {
        if (boxDatas == null) this.boxDatas = new HashMap<String, DEAlib_BoxData>();
        this.boxDatas.putAll(DEA_BoxDatas);
    }

    public void DEAlib_RemoveBoxInPlugin(List<String> DEA_BoxDatasToRemove) {
        for (String stringData : DEA_BoxDatasToRemove) {
            boxDatas.remove(stringData);
        }
    }


}
