package DEA.helper.plugins;

import DEA.helper.DEAlib_Logger;
import DEA.helper.plugins.pluginFiles.systemFiles.*;
import DEA.helper.render.renderClassesFolder.DEAlib_BoxData;
import DEA.helper.scripts.DEAlib_EveryFrameScript;
import com.fs.starfarer.api.BaseModPlugin;
import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.StarSystemAPI;
import com.fs.starfarer.api.combat.ViewportAPI;
import com.fs.starfarer.api.impl.campaign.ids.Entities;
import com.fs.starfarer.api.impl.campaign.ids.Terrain;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static DEA.helper.DEAlib_Statics.DEAlib_CampaignRenderer;

public class DEAlib_ModPlugin extends BaseModPlugin {


    @Override
    public void onApplicationLoad() {
        StringBuilder errText = new StringBuilder("    *-*   ");
        try {
            errText.append("DEA_Logger.DEA_log(DEA_Plugin.class, \"loadedDEA\");");
            DEAlib_Logger.DEA_log(DEAlib_ModPlugin.class, "loadedDEAlib");
            errText.append("    *-*    worked");

//            DEAlib_CustomUIPanelPlugin deAlibCampaignUIPlugin = new DEAlib_CustomUIPanelPlugin();


        } catch (Exception ex) {
            DEAlib_Logger.DEA_log(DEAlib_ModPlugin.class, "DEA_ERROR" + errText + "\n ERROR MESSAGE: " + ex.getMessage());
        }
    }

    @Override
    public void onGameLoad(boolean newGame) {

        DEAlib_EveryFrameScript z = new DEAlib_EveryFrameScript();

        DEAlib_CampaignRenderer = z;

        ViewportAPI viewport = Global.getSector().getViewport();

        DEAlib_BoxData box = new DEAlib_BoxData(
                new Vector2f(viewport.convertScreenXToWorldX(0), viewport.convertScreenYToWorldY(1)),
                new Vector2f(viewport.convertScreenXToWorldX(1), viewport.convertScreenYToWorldY(1)),
                new Vector2f(viewport.convertScreenXToWorldX(0), viewport.convertScreenYToWorldY(0)),
                new Vector2f(viewport.convertScreenXToWorldX(1), viewport.convertScreenYToWorldY(0)),
                Color.white,
                GL11.GL_FILL
        );

        HashMap<String, DEAlib_BoxData> y = new HashMap<>();

        y.put("DEAlib_TestBox", box);

        DEAlib_CampaignRenderer.DEAlib_DrawBoxInPlugin(y);


        Global.getSector().addTransientScript(z);

        StarSystemAPI DEAlib_TestSystem = null;

        for (StarSystemAPI s : Global.getSector().getStarSystems()) {
            if (s.getId().equals("dealib_testsector")) {
                DEAlib_TestSystem = s;
            }
            DEAlib_Logger.DEA_log(DEAlib_ModPlugin.class, s.getId(), s.getName());
        }

        if (DEAlib_TestSystem == null) {
            makeTestSector();
        } else {
//            Global.getSector().removeStarSystem(DEAlib_TestSystem);
//            DEA_Logger.DEA_log(DEAlib_ModPlugin.class, "removed system");
//            makeTestSector();
//            DEA_Logger.DEA_log(DEAlib_ModPlugin.class, "made system");
        }
//        for (String s : Global.getSector().getEconomy().getMarket("kazeron").getMemory().getKeys()) {
//
//            DEA_Logger.DEA_log(DEAlib_ModPlugin.class, s);
//        }


    }

    public void makeTestSector() {
        List<DEAlib_StarSystemData> systemDataList = new ArrayList<>();

        List<DEAlib_StarData> starList = new ArrayList<>();

        starList.add(new DEAlib_StarData(
                "DEAlib_TestSystemStar1",
                "black_hole",
                9000,
                new Vector2f(0f, 0f),
                900
        ));


        List<DEAlib_PlanetData> planetList = new ArrayList<>();

        planetList.add(new DEAlib_PlanetData(
                "DEAlib_TestSystemPlanet1",//planet id, can be used for orbiting AS LONG AS the planet it orbits around came before this
                "DEAlib_TestSystemStar1",//id of the thing its focusing to
                "DEAlib_TestSystemPlanet1Name",//planets name
                "rocky_unstable",//planet type
                30f,
                150f,
                3000f,
                0.0001f
        ));

        List<DEAlib_MarketData> marketList = new ArrayList<>();

        List<DEAlib_AstreoidBeltData> astreoidBeltList = new ArrayList<>();

        astreoidBeltList.add(new DEAlib_AstreoidBeltData(
                java.util.UUID.randomUUID().toString(),//this gives a random string, like `44e128a5-ac7a-4c9a-be4c-224b6bf81b20`// the reason is that astreoid belt is *not* used on anything else afaik so
                "DEAlib_TestSystemPlanet1",
                20,
                500f,
                200,
                40,
                70,
                Terrain.PULSAR_BEAM,
                "DEAlib_TestSystemPlanet1OptionalName"
        ));

        List<DEAlib_RingBandData> ringBandList = new ArrayList<>();

        ringBandList.add(new DEAlib_RingBandData(
                java.util.UUID.randomUUID().toString(),//this gives a random string, like `44e128a5-ac7a-4c9a-be4c-224b6bf81b20`// the reason is that astreoid belt is *not* used on anything else afaik so
                "DEAlib_TestSystemStar1",
                "misc", //rings_asteroids0 is probably the working one//mfer they are the ids of the textures lol, should work
                "dust_particles", //texture id, idk why its named key//also you can put any images and itll work lol
                8000f,
                1,
                Color.CYAN,
                2500f,
                2000f,
                1,
                null,
                null
        ));

        List<DEAlib_SectorEntittyTokenData> sectorEntityTokenList = new ArrayList<>();

        sectorEntityTokenList.add(new DEAlib_SectorEntittyTokenData(
                "DEAlib_CustomEntittyToken1_SetLocation1",
                "DEAlib_CustomEntittyToken1_SetLocation1_Name",
                Entities.SENSOR_ARRAY,
                "derelict",
                1500f,
                1500f
        ));


        DEAlib_StarSystemData DEAlib_TestSector = new DEAlib_StarSystemData(
                "dealib_testsector",
                0f,
                0f,
                "graphics/background/Beams.png",
                starList,
                planetList,
                null,
                astreoidBeltList,
                ringBandList,
                sectorEntityTokenList,
                true,
                true,
                true,
                0f
        );

        systemDataList.add(DEAlib_TestSector);

        DEAlib_WorldGen z = new DEAlib_WorldGen(systemDataList);

        z.generate(Global.getSector());
    }

}
