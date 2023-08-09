package DEA.helper.plugins.pluginFiles.systemFiles;

import com.fs.starfarer.api.campaign.SectorEntityToken;
import com.fs.starfarer.api.campaign.econ.Industry;
import com.fs.starfarer.api.campaign.econ.MarketConditionAPI;
import com.fs.starfarer.api.campaign.econ.SubmarketAPI;

import java.util.ArrayList;
import java.util.List;

public class DEAlib_MarketData {

public DEAlib_MarketData(){

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
