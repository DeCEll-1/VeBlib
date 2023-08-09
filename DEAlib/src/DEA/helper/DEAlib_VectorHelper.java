package DEA.helper;

import DEA.helper.geometry.DEAlib_ClockwiseWinding;
import DEA.helper.geometry.DEAlib_PolygonTriangulation;
import DEA.helper.helperHelperClasses.DEAlib_TriangleData;
import org.lazywizard.lazylib.VectorUtils;
import org.lwjgl.util.vector.Vector2f;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DEAlib_VectorHelper {

    /**
     * <b> it starts from bottom and is reverse clockwise</b> </br>
     *
     * @param relived the list of vectors that will get ordered //dont mind the name
     * @return returns the "ordered" list of vectors
     */
    public static List<Vector2f> DEAlib_ListVector2fsClockwise(List<Vector2f> relived) {
//region İ LOVE CHATGPT
//
//
////gets the middle point
//        Vector2f middlePoint = DEAlib_GetTheMiddlePointInAVector2fList(HELP);
//
//
//        Map<Float, Vector2f> angles = new HashMap<>();
//
////orders stuff clockwise but starts from bottom, see /images/Adsız.png// the image is old it starts from bottom and is reverse clockwise
//
//        boolean doOnce = true;
//
//        for (Vector2f location : HELP) {
////get angles
//            //90 is top, 0 is to the right, 180 is to the left and -90 is down for god knows why
//            //so this reverse clockwises from bottom
//            //tbh it doesnt matter since ill use this for fan polygon triangulation so it doesnt matter but its annoying
////            if (true) {//it gives 0 otherwwise
//            angles.put(VectorUtils.getAngle(middlePoint, location), location);
//            doOnce = false;
////            }
//        }
//
//        Map<Float, Vector2f> orderedAngles = new HashMap<>();
//
//        float smallestOneForNow = 999f;
//
//        Vector2f lowestAngledVector = null;
//
//        int sizeOfTheHashMapangles = angles.size();//this is because the lower the cound of its size gets the faster it stops the for, like if there is 50 entries for angles it stops at 25 because the size of the thing becomes 25
//
//        for (int i = 0; i < sizeOfTheHashMapangles; i++) {//to cycle enough for ordering stuff
//            smallestOneForNow = 999f;
//            for (Map.Entry<Float, Vector2f> angle : angles.entrySet()) {
//
//                if (angle.getKey() < smallestOneForNow) {//is current angle smaller than the last one?
//                    //if so
//                    smallestOneForNow = angle.getKey();//update latest one
//
//                    lowestAngledVector = angle.getValue();//update latest vector
//
//                    //for putting them on ordered list
//                }
//
//            }
//
//            orderedAngles.put(smallestOneForNow, lowestAngledVector);//adds the smallest one to the ordered map
//
//            angles.remove(smallestOneForNow);//removes the angle so it doesnt go inside the list again
//
//        }
//
//        HELP.clear();
//
//        for (Map.Entry<Float, Vector2f> HELP2 : orderedAngles.entrySet()) {
//
//            HELP.add(HELP2.getValue());
//
//        }
//
//        return HELP;
        //endregion

        //i still worked on the upper non working code for around 3 days, same for non- working triangulation script total of around a week of *working* on them so i feed good about using chatgpt

        return DEAlib_ClockwiseWinding.orderClockwise(relived);

    }

    /**
     * returns the middle point of a list of vectors </br>
     * <i><b>if 2 bounds are located in the same place it will return NaN and wont work</b></i>
     *
     * @param list list of the vectors to get the center of, only for vector2f
     * @return returns the middle point
     */
    public static Vector2f DEAlib_GetTheMiddlePointInAVector2fList(List<Vector2f> list) {

        Vector2f middlePoint = null;

        for (Vector2f location : list) {
//gets the middle point
            if (middlePoint == null) {
                middlePoint = location;
            } else {
                middlePoint.x = (middlePoint.x + location.x) / 2;
                middlePoint.y = (middlePoint.y + location.y) / 2;
            }

        }
        return middlePoint;
    }

    public static List<Vector2f> DEAlib_Triangulate(List<Vector2f> list) {

        List<Vector2f> clockedList = DEAlib_VectorHelper.DEAlib_ListVector2fsClockwise(list);

        return DEAlib_PolygonTriangulation.triangulate(clockedList);
    }


}
