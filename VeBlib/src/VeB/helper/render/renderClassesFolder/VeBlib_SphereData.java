package VeB.helper.render.renderClassesFolder;

import com.fs.starfarer.api.graphics.SpriteAPI;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.glu.Sphere;

public class VeBlib_SphereData {

    public VeBlib_SphereData(float radius, int stacks, int slices, Sphere sphere, Vector2f center, SpriteAPI texture) {
        this.radius = radius;
        this.stacks = stacks;
        this.slices = slices;
        this.center = center;
        this.texture = texture;

    }

    //dont use this

    //GENERATİNG A SPHERE EVERY FRAME İS EXTREMLY LAGGY CREATE İT ONCE AND THEN KEEP İT

    //USE THİS to make the sphere
    //        Sphere sphere = new Sphere();


    ////i dont have any idea what those things mean
//        sphere.setTextureFlag(true);
//        sphere.setDrawStyle(GLU.GLU_FILL);
//        sphere.setNormals(GLU.GLU_SMOOTH);
//        sphere.setOrientation(GLU.GLU_OUTSIDE);


    //imports:
//import org.lwjgl.util.glu.Sphere;
//import org.lwjgl.util.glu.GLU;
//import static org.lwjgl.util.glu.GLU.*;
//import static org.lwjgl.util.glu.Util.*;
    //or smthin like that

    public Sphere sphere;

    public float radius;
    public int stacks;
    public int slices;
    public Vector2f center;
    public SpriteAPI texture;


}
