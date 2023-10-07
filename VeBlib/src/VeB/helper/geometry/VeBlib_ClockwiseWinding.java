package VeB.helper.geometry;

import org.lwjgl.util.vector.Vector2f;

import java.util.*;

//powered by Chatgpt:tm:(again)
public class VeBlib_ClockwiseWinding {

    private static Vector2f findCentroid(List<Vector2f> points) {
        double centerX = 0;
        double centerY = 0;

        for (Vector2f point : points) {
            centerX += point.x;
            centerY += point.y;
        }

        int numPoints = points.size();
        return new Vector2f((float) (centerX / numPoints), (float) (centerY / numPoints));
    }

    private static double calculatePolarAngle(Vector2f origin, Vector2f point) {
        return Math.atan2(point.y - origin.y, point.x - origin.x);
    }

    public static List<Vector2f> orderClockwise(List<Vector2f> points) {
        if (points.size() < 3) {
            return points; // Not enough points to order
        }

        Vector2f centroid = findCentroid(points);
        final Vector2f finalCentroid = centroid;

        // Sort the points based on their polar angles
        Collections.sort(points, new Comparator<Vector2f>() {
            @Override
            public int compare(Vector2f p1, Vector2f p2) {
                double angle1 = calculatePolarAngle(finalCentroid, p1);
                double angle2 = calculatePolarAngle(finalCentroid, p2);
                return Double.compare(angle1, angle2);
            }
        });

        return points;
    }

    public static void main(String[] args) {
        List<Vector2f> unsortedPoints = new ArrayList<>();
        unsortedPoints.add(new Vector2f(60f, 60f));
        unsortedPoints.add(new Vector2f(0f, 60f));
        unsortedPoints.add(new Vector2f(60f, 0f));
        unsortedPoints.add(new Vector2f(0f, 0f));

        List<Vector2f> clockwiseOrdered = orderClockwise(unsortedPoints);

        System.out.println("Clockwise Ordered Points:");
        for (Vector2f point : clockwiseOrdered) {
            System.out.println("(" + point.x + ", " + point.y + ")");
        }
    }

}
