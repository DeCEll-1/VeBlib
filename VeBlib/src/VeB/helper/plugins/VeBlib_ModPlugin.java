package VeB.helper.plugins;

import VeB.helper.VeBlib_Logger;
import VeB.helper.plugins.pluginFiles.systemFiles.*;
import com.fs.starfarer.api.BaseModPlugin;
import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.StarSystemAPI;
import com.fs.starfarer.api.impl.campaign.CoreLifecyclePluginImpl;
import com.fs.starfarer.api.impl.campaign.ids.Entities;
import com.fs.starfarer.api.impl.campaign.ids.Terrain;
import com.fs.starfarer.api.impl.campaign.skills.NeuralLinkScript;
import org.lwjgl.util.vector.Vector2f;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

//import static DEA.helper.DEAlib_Statics.DEAlib_CampaignRenderer;

public class VeBlib_ModPlugin extends BaseModPlugin {


    @Override
    public void onApplicationLoad() {

        StringBuilder errText = new StringBuilder("    *-*   ");
        try {
            errText.append("DEA_Logger.DEA_log(DEA_Plugin.class, \"loadedDEA\");");
            VeBlib_Logger.log(VeBlib_ModPlugin.class, "loadedDEAlib");
            errText.append("    *-*    worked");

//            DEAlib_CustomUIPanelPlugin deAlibCampaignUIPlugin = new DEAlib_CustomUIPanelPlugin();

//            Global.getSettings().writeTextFileToCommon("DEAlib","DATA1");

        } catch (Exception ex) {
            VeBlib_Logger.log(VeBlib_ModPlugin.class, "DEA_ERROR" + errText + "\n ERROR MESSAGE: " + ex.getMessage());
        }

        int s = 2;

        (s)>> 5;
    }

    @Override
    public void onGameLoad(boolean newGame) {

//        DEAlib_EveryFrameScript z = new DEAlib_EveryFrameScript();
//
//        DEAlib_CampaignRenderer = z;
//
//        ViewportAPI viewport = Global.getSector().getViewport();
//
//        DEAlib_SquareData box = new DEAlib_SquareData(
//                new Vector2f(viewport.convertScreenXToWorldX(0f), viewport.convertScreenYToWorldY(1f)),
//                new Vector2f(viewport.convertScreenXToWorldX(1f), viewport.convertScreenYToWorldY(1f)),
//                new Vector2f(viewport.convertScreenXToWorldX(0f), viewport.convertScreenYToWorldY(0f)),
//                new Vector2f(viewport.convertScreenXToWorldX(1f), viewport.convertScreenYToWorldY(0f)),
//                Color.white,
//                true
//        );
//
//
//        List<DEAlib_SquareData> y = new ArrayList<>();
//
//
//        y.add(box);


//        DEAlib_CampaignRenderer.SquareInPlugin(y);


//        Global.getSector().addTransientScript(new DEAlib_EveryFrameScript());

        StarSystemAPI DEAlib_TestSystem = null;

        for (StarSystemAPI s : Global.getSector().getStarSystems()) {
            if (s.getId().equals("dealib_testsector")) {
                DEAlib_TestSystem = s;
            }
            VeBlib_Logger.log(VeBlib_ModPlugin.class, s.getId(), s.getName());
        }

        if (DEAlib_TestSystem == null) {
            makeTestSector();
        } else {
//            Global.getSector().removeStarSystem(DEAlib_TestSystem);
//            DEAlib_Logger.log(DEAlib_ModPlugin.class, "removed system");
//            makeTestSector();
//            DEAlib_Logger.log(DEAlib_ModPlugin.class, "made system");
        }
//        for (String s : Global.getSector().getEconomy().getMarket("kazeron").getMemory().getKeys()) {
//
//            DEA_Logger.DEA_log(DEAlib_ModPlugin.class, s);
//        }


    }

    public void makeTestSector() {
        List<VeBlib_StarSystemData> systemDataList = new ArrayList<>();

        List<VeBlib_StarData> starList = new ArrayList<>();

        starList.add(new VeBlib_StarData(
                "DEAlib_TestSystemStar1",
                "black_hole",
                9000,
                new Vector2f(0f, 0f),
                900
        ));


        List<VeBlib_PlanetData> planetList = new ArrayList<>();

        planetList.add(new VeBlib_PlanetData(
                "DEAlib_TestSystemPlanet1",//planet id, can be used for orbiting AS LONG AS the planet it orbits around came before this
                "DEAlib_TestSystemStar1",//id of the thing its focusing to
                "DEAlib_TestSystemPlanet1Name",//planets name
                "rocky_unstable",//planet type
                30f,
                150f,
                3000f,
                0.0001f
        ));

        List<VeBlib_MarketData> marketList = new ArrayList<>();

        List<VeBlib_AstreoidBeltData> astreoidBeltList = new ArrayList<>();

        astreoidBeltList.add(new VeBlib_AstreoidBeltData(
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

        List<VeBlib_RingBandData> ringBandList = new ArrayList<>();

        ringBandList.add(new VeBlib_RingBandData(
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

        List<VeBlib_SectorEntittyTokenData> sectorEntityTokenList = new ArrayList<>();

        sectorEntityTokenList.add(new VeBlib_SectorEntittyTokenData(
                "DEAlib_CustomEntittyToken1_SetLocation1",
                "DEAlib_CustomEntittyToken1_SetLocation1_Name",
                Entities.SENSOR_ARRAY,
                "derelict",
                1500f,
                1500f
        ));


        VeBlib_StarSystemData DEAlib_TestSector = new VeBlib_StarSystemData(
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

        VeBlib_WorldGen z = new VeBlib_WorldGen(systemDataList);

        z.generate(Global.getSector());
    }

}
