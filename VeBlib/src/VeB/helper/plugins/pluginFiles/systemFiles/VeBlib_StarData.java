package VeB.helper.plugins.pluginFiles.systemFiles;

import org.lwjgl.util.vector.Vector2f;

public class VeBlib_StarData {

    public VeBlib_StarData(String ID, String typeID, float radius, Vector2f location, float coronaSize) {
        this.ID = ID;
        this.typeID = typeID;
        this.radius = radius;
        this.location = location;
        this.coronaSize = coronaSize;

    }

    public String ID;
    public String typeID;
    public float radius;
    public Vector2f location;
    public float coronaSize;


}
