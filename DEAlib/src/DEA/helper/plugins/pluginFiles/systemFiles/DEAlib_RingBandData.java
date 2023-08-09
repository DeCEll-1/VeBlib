package DEA.helper.plugins.pluginFiles.systemFiles;

import com.fs.starfarer.api.campaign.SectorEntityToken;

import java.awt.*;

public class DEAlib_RingBandData {

    public DEAlib_RingBandData(String ID, String focusID, String category, String key, float bandWidthInTexture, int bandIndex, Color color, float bandWidthInEngine, float middleRadius, float orbitDays, String terrainId, String optionalName) {
        this.ID = ID;//id of the band useless because bands arent used in anything USELESS https://ih1.redbubble.net/image.358838235.6847/raf,360x360,075,t,fafafa:ca443f4786.jpg
        //then why its here? maybe it will be used lol just put null
        this.focusID = focusID;
        this.category = category;//the category in the config/settings.json, misc is recommended its at line 1077,
        //try putting wormhole_ring2 lmao what can go wrong after all :xdd:
        this.key = key;//texture id, idk why its named key :taxevasion:
        this.bandWidthInTexture = bandWidthInTexture;
        this.bandIndex = bandIndex;//idfk what this is the default system i got from the fat fetishist is 1 and there arent any comments on it so use 1
        this.color = color;//colour tint, end text
        this.bandWidthInEngine = bandWidthInEngine;//band width in game, idk what the texture thing does but i think its for scaling nuts
        this.middleRadius = middleRadius;//probably the orbit radiussy
        this.orbitDays = orbitDays;//orbit days, do 1 for it to orbit once everyday (funi)
        this.terrainId = terrainId;//idk lol put null or smthin
        this.optionalName = optionalName;//idk lol put null or smthin


    }

    public String ID;
    public String focusID;
    public String category;
    public String key;
    public float bandWidthInTexture;
    public int bandIndex;
    public Color color;
    public float bandWidthInEngine;
    public float middleRadius;
    public float orbitDays;
    public String terrainId;
    public String optionalName;


}
