package VeB.helper.plugins.pluginFiles.systemFiles;

public class VeBlib_PlanetData {

    public VeBlib_PlanetData(String Id, String OrbitFocus, String Name, String TypeId, float CircularOrbitAngle, float Radius, float CircularOrbitRadius, float CircularOrbitPeriod) {
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
