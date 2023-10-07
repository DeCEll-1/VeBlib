package VeB.helper.plugins.pluginFiles.systemFiles;

import com.fs.starfarer.api.Global;
import com.sun.org.apache.xerces.internal.jaxp.SAXParserFactoryImpl;


import java.util.List;

public class VeBlib_StarSystemData {


    public VeBlib_StarSystemData(String systemID, float systemX, float systemY, String backgroundTextureFilename, List<VeBlib_StarData> starList, List<VeBlib_PlanetData> planetList, List<VeBlib_MarketData> marketList, List<VeBlib_AstreoidBeltData> astreoidBeltDataList, List<VeBlib_RingBandData> ringBandDataList, List<VeBlib_SectorEntittyTokenData> sectorEntityTokenList, boolean autoGenerateEntrancesAtGasGiants, boolean autoGenerateFringeJumpPoint, boolean generatePlanetConditions, float minHyperspaceRadius) {
        this.systemID = systemID;

        this.systemX = systemX;

        this.systemY = systemY;

        this.backgroundTextureFilename = backgroundTextureFilename;


        this.starList = starList;

        this.planetList = planetList;

        this.marketList = marketList;

//        this.WithJunkAndChatter= WithJunkAndChatter;
//        this.PirateMode= PirateMode;

        this.astreoidBeltDataList = astreoidBeltDataList;
        this.ringBandDataList = ringBandDataList;

        this.sectorEntityTokenList = sectorEntityTokenList;


        this.autoGenerateEntrancesAtGasGiants = autoGenerateEntrancesAtGasGiants;

        this.autoGenerateFringeJumpPoint = autoGenerateFringeJumpPoint;
        this.generatePlanetConditions = generatePlanetConditions;



        this.minHyperspaceRadius = minHyperspaceRadius;

    }

    public String systemID;

    public float systemX;

    public float systemY;

    public String backgroundTextureFilename;


    public List<VeBlib_StarData> starList;

    public List<VeBlib_PlanetData> planetList;

    public List<VeBlib_MarketData> marketList;

//    public ArrayList<Boolean> WithJunkAndChatter;//if its null will be false
//    public ArrayList<Boolean> PirateMode;//if its null will be false

    public List<VeBlib_AstreoidBeltData> astreoidBeltDataList;
    public List<VeBlib_RingBandData> ringBandDataList;

    public List<VeBlib_SectorEntittyTokenData> sectorEntityTokenList;//anchors,custom entittys in Entities aka com.fs.starfarer.api.impl.campaign.ids;


    public boolean autoGenerateEntrancesAtGasGiants;//for autogenerateHyperspaceJumpPoints

    public boolean autoGenerateFringeJumpPoint;
    public boolean generatePlanetConditions;

    public float minHyperspaceRadius;


}
