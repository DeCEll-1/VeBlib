package VeB.helper.plugins.pluginFiles.systemFiles;

public class VeBlib_AstreoidBeltData {

    public VeBlib_AstreoidBeltData(String ID, String focus, int numAsteroids, float orbitRadius, float width, float minOrbitDays, float maxOrbitDays, String terrainId, String optionalName) {
        this.ID = ID;
        this.focusID = focus;
        this.numAsteroids = numAsteroids;
        this.orbitRadius = orbitRadius;
        this.width = width;
        this.minOrbitDays = minOrbitDays;
        this.maxOrbitDays = maxOrbitDays;
        this.terrainId = terrainId;
        this.optionalName = optionalName;

    }

    public String ID;//this is for identifieing the belt, maybe it will be used, might crash if you dont give it an id, you can do java.util.UUID.randomUUID(); which will give a random string (just do toString), there can be duplicate ones but its pratically ibloppable so dont worry
    public String focusID;//orbit focus
    public int numAsteroids;//number of asteroid entities
    public float orbitRadius;//orbit radius is 500 gap for outer randomly generated entity above
    public float width;//width of band
    public float minOrbitDays;//minimum and maximum visual orbit speeds of asteroids
    public float maxOrbitDays;
    public String terrainId;//ID of the terrain type that appears in the section above the abilities bar
    public String optionalName;//display name


}
