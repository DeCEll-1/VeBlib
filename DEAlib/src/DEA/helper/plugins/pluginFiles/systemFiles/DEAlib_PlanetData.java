package DEA.helper.plugins.pluginFiles.systemFiles;

import com.fs.starfarer.api.campaign.SectorEntityToken;

public class DEAlib_PlanetData {

    public DEAlib_PlanetData(String Id, String OrbitFocus, String Name, String TypeId, float CircularOrbitAngle, float Radius, float CircularOrbitRadius, float CircularOrbitPeriod) {
        this.Id = Id;
        this.OrbitFocusID = OrbitFocus;
        this.Name = Name;
        this.TypeId = TypeId;
        this.CircularOrbitAngle = CircularOrbitAngle;
        this.Radius = Radius;
        this.CircularOrbitRadius = CircularOrbitRadius;
        this.CircularOrbitPeriod = CircularOrbitPeriod;

    }

    public String Id;
    public String OrbitFocusID;
    public String Name;
    public String TypeId;
    public float CircularOrbitAngle;
    public float Radius;
    public float CircularOrbitRadius;
    public float CircularOrbitPeriod;


}
