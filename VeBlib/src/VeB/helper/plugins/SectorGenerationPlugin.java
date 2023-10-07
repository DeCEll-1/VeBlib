package VeB.helper.plugins;

import VeB.helper.plugins.pluginFiles.systemFiles.*;
import com.fs.starfarer.api.campaign.*;
import com.fs.starfarer.api.campaign.econ.Industry;
import com.fs.starfarer.api.campaign.econ.MarketConditionAPI;
import com.fs.starfarer.api.campaign.econ.SubmarketAPI;
import com.fs.starfarer.api.impl.campaign.procgen.NebulaEditor;
import com.fs.starfarer.api.impl.campaign.terrain.HyperspaceTerrainPlugin;
import com.fs.starfarer.api.util.Misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SectorGenerationPlugin implements SectorGeneratorPlugin {

    public List<VeBlib_StarSystemData> starSystemDataList;

    public SectorGenerationPlugin(List<VeBlib_StarSystemData> starSystemDataList) {
        this.starSystemDataList = starSystemDataList;
    }

    @Override
    public void generate(SectorAPI sector) {

        if (starSystemDataList != null) {


            for (VeBlib_StarSystemData data : starSystemDataList) {
                StarSystemAPI system = sector.createStarSystem(data.systemID);
                system.getLocation().set(data.systemX, data.systemY);
                system.setBackgroundTextureFilename(data.backgroundTextureFilename);

                HashMap<String, SectorEntityToken> SectorEntittyTokenHashMap = new HashMap<>();

                if (data.starList != null) {
                    //çalış
                    for (VeBlib_StarData starData : data.starList) {
                        PlanetAPI star = system.initStar(
                                starData.ID,
                                starData.typeID,
                                starData.radius,
                                starData.location.x,
                                starData.location.y,
                                starData.coronaSize
                        );
                        SectorEntittyTokenHashMap.put(starData.ID, star);
                    }
                }

                if (data.planetList != null) {
                    //planets, it shuld work
                    for (VeBlib_PlanetData planetData : data.planetList) {
                        PlanetAPI planet = system.addPlanet(
                                planetData.Id,
                                SectorEntittyTokenHashMap.get(planetData.OrbitFocusID),
                                planetData.Name,
                                planetData.TypeId,
                                planetData.CircularOrbitAngle,
                                planetData.Radius,
                                planetData.CircularOrbitRadius,
                                planetData.CircularOrbitPeriod
                        );
                        SectorEntittyTokenHashMap.put(planetData.Id, planet);
                    }
                }

//markets, it should work
//            Iterator WithJunkAndChatterIterator = data.WithJunkAndChatter.iterator();

//            Iterator PirateModeIterator = data.PirateMode.iterator();

                if (data.marketList != null) {
                    for (VeBlib_MarketData marketData : data.marketList) {

//                boolean currentWithJunkAndChatter = false;

//                if (WithJunkAndChatterIterator.hasNext()) {
//                    currentWithJunkAndChatter = (boolean) WithJunkAndChatterIterator.next();
//                }
//
//                boolean PirateMode = false;
//
//                if (PirateModeIterator.hasNext()) {
//                    PirateMode = (boolean) PirateModeIterator.next();
//                }
                        ArrayList<String> marketDataConditionAList = new ArrayList<>();
                        for (MarketConditionAPI conditionData : marketData.marketConditions) {

                            marketDataConditionAList.add(conditionData.getId());

                        }
                        ArrayList<String> marketDataSubmarketList = new ArrayList<>();
                        for (SubmarketAPI submarketData : marketData.submarkets) {

                            marketDataSubmarketList.add(submarketData.getSpecId());

                        }
                        ArrayList<String> marketDataIndustriesList = new ArrayList<>();
                        for (Industry conditionData : marketData.industries) {

                            marketDataIndustriesList.add(conditionData.getId());

                        }
                        addMarket.addMarketplace(
                                marketData.factionID,
                                marketData.primaryEntity,
                                marketData.connectedEntities,
                                marketData.name,
                                marketData.size,
                                marketDataConditionAList,
                                marketDataSubmarketList,
                                marketDataIndustriesList,
                                marketData.WithJunkAndChatter,
                                marketData.PirateMode
                        );
                    }
                }

                if (data.astreoidBeltDataList != null) {
                    for (VeBlib_AstreoidBeltData astreoidData : data.astreoidBeltDataList) {
                        SectorEntityToken astreoidBelt = system.addAsteroidBelt(
                                SectorEntittyTokenHashMap.get(astreoidData.focusID),
                                astreoidData.numAsteroids,
                                astreoidData.orbitRadius,
                                astreoidData.width,
                                astreoidData.minOrbitDays,
                                astreoidData.maxOrbitDays
                        );
                        SectorEntittyTokenHashMap.put(astreoidData.optionalName, astreoidBelt);
                    }
                }

                if (data.ringBandDataList != null) {
                    for (VeBlib_RingBandData ringBandData : data.ringBandDataList) {
                        SectorEntityToken ringBand = system.addRingBand(
                                SectorEntittyTokenHashMap.get(ringBandData.focusID),
                                ringBandData.category,
                                ringBandData.key,
                                ringBandData.bandWidthInTexture,
                                ringBandData.bandIndex,
                                ringBandData.color,
                                ringBandData.bandWidthInEngine,
                                ringBandData.middleRadius,
                                ringBandData.orbitDays,
                                ringBandData.terrainId,
                                ringBandData.optionalName
                        );
                        SectorEntittyTokenHashMap.put(ringBandData.ID, ringBand);
                    }
                }

                if (data.sectorEntityTokenList != null) {
                    for (VeBlib_SectorEntittyTokenData sectorEntityTokenData : data.sectorEntityTokenList) {
                        SectorEntityToken addCustomEntity = system.addCustomEntity(
                                sectorEntityTokenData.ID,
                                sectorEntityTokenData.name,
                                sectorEntityTokenData.customEntittyType,
                                sectorEntityTokenData.factionID
                        );
                        SectorEntittyTokenHashMap.put(sectorEntityTokenData.ID, addCustomEntity);
                    }
                }

                if (data.autoGenerateEntrancesAtGasGiants || data.autoGenerateFringeJumpPoint || data.generatePlanetConditions) {
                    system.autogenerateHyperspaceJumpPoints(data.autoGenerateEntrancesAtGasGiants, data.autoGenerateFringeJumpPoint, data.generatePlanetConditions);
                }

                HyperspaceTerrainPlugin hyperspaceTerrainPlugin = (HyperspaceTerrainPlugin) Misc.getHyperspaceTerrain().getPlugin(); //get instance of hyperspace terrain
                NebulaEditor nebulaEditor = new NebulaEditor(hyperspaceTerrainPlugin); //object used to make changes to hyperspace nebula

                float minHyperspaceRadius = hyperspaceTerrainPlugin.getTileSize() * data.minHyperspaceRadius;
                float maxHyperspaceRadius = system.getMaxRadiusInHyperspace();

                nebulaEditor.clearArc(data.systemX, data.systemY, 0, minHyperspaceRadius + maxHyperspaceRadius, 0f, 360f, 0.25f);

            }
        }
    }
}
