package VeB.helper.plugins.pluginFiles.systemFiles;

import com.fs.starfarer.api.campaign.SectorEntityToken;
import com.fs.starfarer.api.campaign.econ.Industry;
import com.fs.starfarer.api.campaign.econ.MarketConditionAPI;
import com.fs.starfarer.api.campaign.econ.SubmarketAPI;

import java.util.ArrayList;
import java.util.List;

public class VeBlib_MarketData {

    public VeBlib_MarketData(String factionID,    SectorEntityToken primaryEntity,    ArrayList<SectorEntityToken> connectedEntities,    String name,    int size,    List<MarketConditionAPI> marketConditions,    List<SubmarketAPI> submarkets,    List<Industry> industries,    Boolean WithJunkAndChatter,    Boolean PirateMode) {
        this.factionID = factionID;
        this.primaryEntity = primaryEntity;
        this.connectedEntities = connectedEntities;
        this.name = name;
        this.size = size;
        this.marketConditions = marketConditions;
        this.submarkets = submarkets;
        this.industries = industries;
        this.WithJunkAndChatter = WithJunkAndChatter;
        this.PirateMode = PirateMode;
    }

    public String factionID;
    public SectorEntityToken primaryEntity;
    public ArrayList<SectorEntityToken> connectedEntities;
    public String name;
    public int size;
    public List<MarketConditionAPI> marketConditions;
    public List<SubmarketAPI> submarkets;
    public List<Industry> industries;
    public Boolean WithJunkAndChatter;
    public Boolean PirateMode;

}
