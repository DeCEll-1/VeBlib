package DEA.helper;

import com.fs.starfarer.api.combat.*;
import org.lazywizard.lazylib.MathUtils;
import org.lwjgl.util.vector.Vector2f;

import java.awt.*;


public class DEAlib_Helper {



    /**
     * did this because i didnt knew beam.getRayEndPrevFrame() gets the end point of the beam
     */
    public static Vector2f EndOfBeamGiver(BeamAPI beam) {
        return MathUtils.getPointOnCircumference(beam.getWeapon().getLocation(), beam.getLength(), beam.getWeapon().getCurrAngle());
    }


    /**
     * keeps the angle between 0 and 360<br/>
     * like 340 + 60 = 400 but this will make it 40 <br/>
     *
     * @param angle     base angle
     * @param PlusMinus how much you want to increase/decrease the angle
     * @return if the proccess completed successfully returns true, false othervise. so instead of crashing it just, doesnt work
     */
    public static float GetPlusMinusAngle(float angle, float PlusMinus) {
        try {

            if (angle + PlusMinus < 360 && angle + PlusMinus > 0) return angle + PlusMinus;

            if (angle + PlusMinus > 360) return (angle + PlusMinus) - 360f;

            if (angle + PlusMinus < 0) return (angle + PlusMinus) + 360f;




            return 0f;
        } catch (Exception ex) {
            return 0f;
        }
    }


}
