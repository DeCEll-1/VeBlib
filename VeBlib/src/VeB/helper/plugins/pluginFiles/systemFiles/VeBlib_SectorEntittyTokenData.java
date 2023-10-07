package VeB.helper.plugins.pluginFiles.systemFiles;

public class VeBlib_SectorEntittyTokenData {

    public VeBlib_SectorEntittyTokenData(String ID, String name, String customEntittyType, String factionID, float x, float y) {
        this.ID = ID;
        this.name = name;
        this.customEntittyType = customEntittyType;
        this.factionID = factionID;
        this.x = x;
        this.y = y;
        this.orbitLocationMode = 0;
    }

    public VeBlib_SectorEntittyTokenData(String ID, String name, String customEntittyType, String factionID, String focusID, float angle, float orbitRadius, float orbitDays, boolean setCircularOrbitPointingDown) {
        this.ID = ID;
        this.name = name;
        this.customEntittyType = customEntittyType;
        this.factionID = factionID;
        this.focusID = focusID;
        this.angle = angle;
        this.orbitRadius = orbitRadius;
        this.orbitDays = orbitDays;
        if (setCircularOrbitPointingDown) this.orbitLocationMode = 2;
        else this.orbitLocationMode = 1;
    }

    public VeBlib_SectorEntittyTokenData(String ID, String name, String customEntittyType, String factionID, String focusID, float angle, float orbitRadius, float orbitDays, float minSpin, float maxSpin) {
        this.ID = ID;
        this.name = name;
        this.customEntittyType = customEntittyType;
        this.factionID = factionID;
        this.focusID = focusID;
        this.angle = angle;
        this.orbitRadius = orbitRadius;
        this.orbitDays = orbitDays;
        this.minSpin = minSpin;
        this.maxSpin = maxSpin;
        this.orbitLocationMode = 3;
    }

    public String ID;//neccessary
    public String name;//neccessary
    public String customEntittyType;//neccessary
    public String factionID;//neccessary

    public float x;
    public float y;

    public String focusID;

    public float angle;
    public float orbitRadius;
    public float orbitDays;
    public float minSpin;
    public float maxSpin;
    public int orbitLocationMode;
    //0 = setFixedLocation; only needs x and y other than neccessary stuff.
    //1 = setCircularOrbit; needs focusID;angle;orbitRadius;orbitDays;
    //2 = setCircularOrbitPointingDown; same as 1
    //3 = setCircularOrbitWithSpin; same as 1/2 just with minSpin  maxSpin additions


}
