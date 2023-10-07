package VeB.helper.render.premadeObjects;

import VeB.helper.VeBlib_VectorHelper;
import VeB.helper.render.premadeObjects.VeBlib_Panel00Panel;
import com.fs.starfarer.api.Global;
import org.lazywizard.lazylib.MathUtils;
import org.lazywizard.lazylib.VectorUtils;
import org.lwjgl.util.vector.Vector2f;

public class VeBlib_Panel00Animation {

    public VeBlib_Panel00Animation(VeBlib_Panel00Panel fromPanel, VeBlib_Panel00Panel toPanel, float timeNeeded) {
        this.fromPanel = fromPanel;

        this.toPanel = toPanel;//initilisation ,,,, because the current location will be from when it starts

        this.currPanel = new VeBlib_Panel00Panel(fromPanel.topLeft,fromPanel.topRight,fromPanel.bottomLeft,fromPanel.bottomRight);//send coffe brain malfunction..


        this.timeNeeded = timeNeeded;

        distance = new float[]{
                MathUtils.getDistance(fromPanel.topLeft, toPanel.topLeft), MathUtils.getDistance(fromPanel.topRight, toPanel.topRight),//top left/right from/to distances
                MathUtils.getDistance(fromPanel.bottomLeft, toPanel.bottomLeft), MathUtils.getDistance(fromPanel.bottomRight, toPanel.bottomRight) //bottom left/right from/to distances
        };
    }

    public void advance() {

        if (finished) return;

        float timePassedSinceLastFrame = Global.getCombatEngine().getElapsedInLastFrame();

        currPanel.topLeft = VeBlib_VectorHelper.aproachVectors(
                currPanel.topLeft,
                toPanel.topLeft,
                //uzaklık / zaman
                distance[0] * (timePassedSinceLastFrame/timeNeeded)
        );

        currPanel.topRight = VeBlib_VectorHelper.aproachVectors(
                currPanel.topRight,
                toPanel.topRight,
                distance[1] * (timePassedSinceLastFrame/timeNeeded)
        );

        currPanel.bottomLeft = VeBlib_VectorHelper.aproachVectors(
                currPanel.bottomLeft,
                toPanel.bottomLeft,
                distance[2] * (timePassedSinceLastFrame/timeNeeded)
        );

        currPanel.bottomRight = VeBlib_VectorHelper.aproachVectors(
                currPanel.bottomRight,
                toPanel.bottomRight,
                distance[3] * (timePassedSinceLastFrame/timeNeeded)
        );

        timePassed += timePassedSinceLastFrame;

        if (timePassed >= timeNeeded) {
            finished = true;
        }

    }

    public boolean remove = false;
    public float timePassed;
    public float timeNeeded;

    public float[] distance;

    public boolean finished = false;

    public VeBlib_Panel00Panel fromPanel;
    public VeBlib_Panel00Panel toPanel;
    public VeBlib_Panel00Panel currPanel;


}
