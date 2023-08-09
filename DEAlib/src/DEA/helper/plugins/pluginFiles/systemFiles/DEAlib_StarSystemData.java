package DEA.helper.plugins.pluginFiles.systemFiles;

import com.fs.starfarer.api.campaign.PlanetAPI;
import com.fs.starfarer.api.campaign.SectorEntityToken;
import com.fs.starfarer.api.campaign.StarSystemAPI;
import com.fs.starfarer.api.campaign.econ.MarketAPI;

import java.util.ArrayList;
import java.util.List;

public class DEAlib_StarSystemData {


public DEAlib_StarSystemData( String systemID, float systemX, float systemY, String backgroundTextureFilename,List<DEAlib_StarData> starList, List<DEAlib_PlanetData> planetList, List<DEAlib_MarketData> marketList, List<DEAlib_AstreoidBeltData> astreoidBeltDataList, List<DEAlib_RingBandData> ringBandDataList, List<DEAlib_SectorEntittyTokenData> sectorEntityTokenList,boolean autoGenerateEntrancesAtGasGiants, boolean autoGenerateFringeJumpPoint, boolean generatePlanetConditions, float minHyperspaceRadius){
        this.systemID= systemID;

        this.systemX= systemX;

        this.systemY= systemY;

        this.backgroundTextureFilename= backgroundTextureFilename;


        this.starList= starList;

        this.planetList= planetList;

        this.marketList= marketList;

//        this.WithJunkAndChatter= WithJunkAndChatter;
//        this.PirateMode= PirateMode;

        this.astreoidBeltDataList= astreoidBeltDataList;
        this.ringBandDataList= ringBandDataList;

        this.sectorEntityTokenList= sectorEntityTokenList;


        this.autoGenerateEntrancesAtGasGiants= autoGenerateEntrancesAtGasGiants;

        this.autoGenerateFringeJumpPoint= autoGenerateFringeJumpPoint;
        this.generatePlanetConditions= generatePlanetConditions;

        this.minHyperspaceRadius= minHyperspaceRadius;

    }

    public String systemID;

    public float systemX;

    public float systemY;

    public String backgroundTextureFilename;


    public List<DEAlib_StarData> starList;

    public List<DEAlib_PlanetData> planetList;

    public List<DEAlib_MarketData> marketList;

//    public ArrayList<Boolean> WithJunkAndChatter;//if its null will be false
//    public ArrayList<Boolean> PirateMode;//if its null will be false

    public List<DEAlib_AstreoidBeltData> astreoidBeltDataList;
    public List<DEAlib_RingBandData> ringBandDataList;

    public List<DEAlib_SectorEntittyTokenData> sectorEntityTokenList;//anchors,custom entittys in Entities aka com.fs.starfarer.api.impl.campaign.ids;


    public boolean autoGenerateEntrancesAtGasGiants;//for autogenerateHyperspaceJumpPoints

    public boolean autoGenerateFringeJumpPoint;
    public boolean generatePlanetConditions;

    public float minHyperspaceRadius;


}
