package VeB.helper.deepstorage;

import com.fs.starfarer.api.combat.ViewportAPI;
import com.fs.starfarer.api.graphics.SpriteAPI;
import org.lwjgl.util.vector.Vector2f;

import java.util.ArrayList;

import static org.lwjgl.opengl.GL11.*;

class Vector3f {
    float x, y, z;

    public Vector3f(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class DEAlib_Sphere {
    ArrayList<Vector3f> vertices;
    int numTriangles;
    float height;
    float width;

    SpriteAPI sprite;

    ViewportAPI viewport;

    public DEAlib_Sphere(int numTriangles, Vector2f center, float height, float width, SpriteAPI sprite, ViewportAPI viewport) {
        this.numTriangles = numTriangles;
        this.height = height;
        this.width = width;
        this.sprite = sprite;
        this.viewport = viewport;
        generateVertices(numTriangles, center.x, center.y, width, height);
    }

    private void generateVertices(int numTriangles, float centerX, float centerY, float width, float height) {
        vertices = new ArrayList<>();

        // Calculate vertices based on the number of triangles
        float halfWidth = width / 2;
        float halfHeight = height / 2;

        vertices.add(new Vector3f(centerX, centerY, halfHeight));
        vertices.add(new Vector3f(centerX, centerY, -halfHeight));

        for (int i = 0; i < numTriangles; i++) {
            float angle = (float) Math.toRadians(360.0f / numTriangles * i);
            float x = (float) (centerX + halfWidth * Math.cos(angle));
            float y = (float) (centerY + halfHeight * Math.sin(angle));
            vertices.add(new Vector3f(x, y, 0));
        }
    }

    public void render() {
        glBegin(GL_TRIANGLES);

        // Render triangles
        int numTriangles = vertices.size() - 2;

        for (int i = 0; i < numTriangles; i++) {
            Vector3f p1 = vertices.get(0);
            Vector3f p2 = vertices.get(i + 2);
            Vector3f p3 = vertices.get(i + 1);

            glVertex3d(p1.x, p1.y, p1.z);
            glVertex3d(p2.x, p2.y, p2.z);
            glVertex3d(p3.x, p3.y, p3.z);
        }

        for (int i = 0; i < numTriangles; i++) {
            Vector3f p1 = vertices.get(1);
            Vector3f p2 = vertices.get(i + 1);
            Vector3f p3 = vertices.get(i + 2);

            glVertex3f(viewport.convertWorldXtoScreenX(p1.x), viewport.convertWorldYtoScreenY(p1.y), p1.z);
            glVertex3f(viewport.convertWorldXtoScreenX(p2.x), viewport.convertWorldYtoScreenY(p2.y), p2.z);
            glVertex3f(viewport.convertWorldXtoScreenX(p3.x), viewport.convertWorldYtoScreenY(p3.y), p3.z);
        }

        glEnd();
    }
}

//public class OctahedronDemo extends JPanel {
//    DEAlib_Sphere octahedron;
//
//    public OctahedronDemo(int numTriangles, float height, float width) {
////        octahedron = new DEAlib_Sphere(numTriangles, height, width);
//    }
//
//    @Override
//    public void paintComponent(Graphics g) {
//        super.paintComponent(g);
//
////        GL2 gl = ((GLGraphics) g).getGL().getGL2();//what this do? god knows mate ask chatgpt
////        octahedron.render(gl);
//    }
//
//    public static void main(String[] args) {
//        JFrame frame = new JFrame("Octahedron Demo");
//
//        int numTriangles = Integer.parseInt(JOptionPane.showInputDialog("Enter number of triangles: "));
//        double height = Double.parseDouble(JOptionPane.showInputDialog("Enter height: "));
//        double width = Double.parseDouble(JOptionPane.showInputDialog("Enter width: "));
//
////        OctahedronDemo demo = new OctahedronDemo(numTriangles, height, width);
////        GLJPanel glPanel = new GLJPanel();
////        glPanel.addGLEventListener(demo);
//
////        frame.add(glPanel);
//        frame.setSize(800, 600);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);
//    }
//}
