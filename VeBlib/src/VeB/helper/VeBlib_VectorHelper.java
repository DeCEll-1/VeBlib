package VeB.helper;

import VeB.helper.geometry.VeBlib_ClockwiseWinding;
import VeB.helper.geometry.VeBlib_PolygonTriangulation;
import org.lazywizard.lazylib.MathUtils;
import org.lazywizard.lazylib.VectorUtils;
import org.lwjgl.util.vector.Vector2f;

import java.util.List;

public class VeBlib_VectorHelper {

    /**
     * <b> it clockwise turns, idk the order</b> </br>
     *
     * @param relived the list of vectors that will get ordered //dont mind the name
     * @return returns the "ordered" list of vectors
     */
    public static List<Vector2f> ListVector2fsClockwise(List<Vector2f> relived) {
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

        return VeBlib_ClockwiseWinding.orderClockwise(relived);

    }

    /**
     * returns the middle point of a list of vectors </br>
     * <i><b>if 2 bounds are located in the same place it will return NaN and wont work</b></i>
     *
     * @param list list of the vectors to get the center of, only for vector2f
     * @return if the list is 0 will return null, otherwise returns the middle point
     */
    public static Vector2f GetTheMiddlePointInAVector2fList(List<Vector2f> list) {

        if (list.size() == 0) return null;

        Vector2f totalVectorData = null;

        for (Vector2f location : list) {
//gets the middle point
            if (totalVectorData == null) {
                totalVectorData = location;
            } else {
                totalVectorData.x = (totalVectorData.x + location.x);
                totalVectorData.y = (totalVectorData.y + location.y);
            }

        }

        Vector2f realVector = new Vector2f(totalVectorData.x / list.size(), totalVectorData.y / list.size());

        return realVector;
    }

    public static List<Vector2f> Triangulate(List<Vector2f> list) {

        List<Vector2f> clockedList = VeBlib_VectorHelper.ListVector2fsClockwise(list);

        return VeBlib_PolygonTriangulation.triangulate(clockedList);
    }

    public static Vector2f AvarageVectors(Vector2f firstVector, Vector2f secondVector) {

        Vector2f avaragedVector = new Vector2f();

        avaragedVector.x = (firstVector.x + secondVector.x) / 2f;
        avaragedVector.y = (firstVector.y + secondVector.y) / 2f;

        return avaragedVector;

    }


    public static Vector2f aproachVectors(Vector2f aproachant, Vector2f target, float aproachAmount) {

        if (aproachAmount == 0f) return target;

        Vector2f aproachedVector = new Vector2f(

                MathUtils.getPointOnCircumference(
                        aproachant,
                        aproachAmount,
                        VectorUtils.getAngle(aproachant, target)
                )

        );

        return aproachedVector;
    }

}
