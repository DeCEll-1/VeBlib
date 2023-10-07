package VeB.helper.geometry;
import org.lwjgl.util.vector.Vector2f;

import java.util.ArrayList;
import java.util.List;

//powered by chatgpt:tm:
public class VeBlib_PolygonTriangulation {

    public static List<Vector2f> triangulate(List<Vector2f> polygon) {
        List<Vector2f> triangles = new ArrayList<>();

        if (polygon.size() < 3) {
            return triangles; // Not enough vertices to form triangles
        }

        // Calculate the middle point of the polygon
        Vector2f middlePoint = calculateMiddlePoint(polygon);

        // Triangulate by connecting each vertex to the middle point
        for (int i = 0; i < polygon.size(); i++) {
            Vector2f vertex1 = polygon.get(i);
            Vector2f vertex2 = polygon.get((i + 1) % polygon.size());

            triangles.add(middlePoint);
            triangles.add(vertex1);
            triangles.add(vertex2);
        }

        return triangles;
    }

    private static Vector2f calculateMiddlePoint(List<Vector2f> polygon) {
        float totalX = 0;
        float totalY = 0;

        for (Vector2f vertex : polygon) {
            totalX += vertex.x;
            totalY += vertex.y;
        }

        int numVertices = polygon.size();
        return new Vector2f(totalX / numVertices, totalY / numVertices);
    }

    public static void main(String[] args) {
        List<Vector2f> polygon = new ArrayList<>();
        polygon.add(new Vector2f(0, 60));
        polygon.add(new Vector2f(0, 0));
        polygon.add(new Vector2f(60, 0));
        polygon.add(new Vector2f(60, 60));

        List<Vector2f> triangles = triangulate(polygon);

        System.out.println("Triangles:");
        for (Vector2f vector : triangles) {
            System.out.println("(" + vector.x + ", " + vector.y + ")");
        }
    }

}

