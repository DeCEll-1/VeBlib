package VeB.helper;

import com.fs.starfarer.api.combat.BoundsAPI;
import com.fs.starfarer.api.combat.ShipAPI;
import org.lazywizard.lazylib.MathUtils;
import org.lwjgl.util.vector.Vector2f;

import java.util.ArrayList;
import java.util.List;

public class VeBlib_BoundsHelper {

    /**
     * gets a random bound </br>
     *
     * @param ship the ship
     * @return if the proccess completed successfully returns the location of the bound,othervise null. so instead of crashing it just, doesnt work
     */
    public static Vector2f GetRandomBoundLocation(ShipAPI ship) {
        try {
            BoundsAPI.SegmentAPI segment = ship.getExactBounds().getSegments().get(VeBlib_Statics.random.nextInt(ship.getExactBounds().getSegments().size()));
            Vector2f segmentLocation = MathUtils.getNearestPointOnLine(ship.getLocation(), segment.getP1(), segment.getP2());
            return segmentLocation;
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * get the list of bound loctions </br>
     *
     * @param ship the ship
     * @return if the proccess completed successfully returns the location of the bound,othervise null. so instead of crashing it just, doesnt work
     */
    public static List<Vector2f> GetListOfBoundLocations(ShipAPI ship) {
        try {

            List<Vector2f> list = new ArrayList<>();

            Vector2f segmentLocation1st = null;

            for (int i = 0; i < ship.getExactBounds().getSegments().size() + 1; i++) {

                BoundsAPI.SegmentAPI segment = null;

//                if (!(ship.getExactBounds().getSegments().size() == i)) {//middle of the line ver
//                    segment = ship.getExactBounds().getSegments().get(i);
//
//                    Vector2f segmentLocation = MathUtils.getNearestPointOnLine(ship.getLocation(), segment.getP1(), segment.getP2());
//
//                    if (i == 0) {
//                        segmentLocation1st = segmentLocation;
//                    }
//
//                    list.add(segmentLocation);
//                }


                if (!(ship.getExactBounds().getSegments().size() == i)) {
                    segment = ship.getExactBounds().getSegments().get(i);

                    Vector2f segmentLocation = segment.getP1();

                    if (i == 0) {
                        segmentLocation1st = segment.getP1();
                    }

                    list.add(segmentLocation);
                } else {
                    list.add(segmentLocation1st);
                }


            }
            return list;
        } catch (Exception ex) {
            return null;
        }
    }

}
