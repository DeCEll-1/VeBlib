package DEA.helper.render;

import cmu.CMUtils;
import cmu.gui.CMUKitUI;
import com.fs.starfarer.api.combat.ViewportAPI;
import com.fs.starfarer.api.graphics.SpriteAPI;
import org.lwjgl.util.glu.Sphere;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.util.glu.Quadric;
import org.lwjgl.util.vector.Vector2f;


import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.*;
import static org.lwjgl.util.glu.Util.*;

public class DEAlib_SphereWGLU {
//doesnt work
    public static void DEAlib_Sphere(Vector2f location, float radius, int slices, int stacks, Sphere sphere, SpriteAPI texture, ViewportAPI viewport) {

        CMUKitUI.closeGLForMisc();

//        glDisable(GL_TEXTURE_2D);//idk if this is even here for a reason
        glMatrixMode(GL_TEXTURE_MATRIX);//texture
        glPushMatrix();
        texture.bindTexture();
//
//this shitahh code doesnt work and i am psure its because of the games render thing or smthin becaue for GODS sake there is literally no reason for it to not render
//ofc i could make a java app and test it there but too much work
        sphere.setOrientation(GLU_INSIDE);
        sphere.setNormals(GLU_SMOOTH);
        sphere.setDrawStyle(GLU_FILL);
        sphere.setTextureFlag(true);

        glMatrixMode(GL_PROJECTION_MATRIX);//projection at bottom cuz it projects i suppose
        glPushMatrix();

        glMatrixMode(GL_MODELVIEW_MATRIX);//for objects or 3d stuff idk
        glPushMatrix();
//        Sphere sphere = new Sphere();

        glTranslatef(viewport.convertWorldXtoScreenX(location.x), viewport.convertWorldYtoScreenY(location.y), 0);

//        sphere.setTextureFlag(true);
//        sphere.setDrawStyle(GLU.GLU_FILL);
//        sphere.setNormals(GLU.GLU_SMOOTH);
//        sphere.setOrientation(GLU.GLU_OUTSIDE);

        sphere.draw(radius, slices, stacks);

        glPopMatrix();
        glPopMatrix();
        glPopMatrix();
//        glEnable(GL_TEXTURE_2D);

        CMUKitUI.openGLForMisc();
    }

}
