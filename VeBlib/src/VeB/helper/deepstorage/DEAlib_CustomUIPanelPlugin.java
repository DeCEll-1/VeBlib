package VeB.helper.deepstorage;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.CustomUIPanelPlugin;
import com.fs.starfarer.api.input.InputEventAPI;
import com.fs.starfarer.api.ui.PositionAPI;

import java.util.List;

import static org.lwjgl.opengl.GL11.*;

public class DEAlib_CustomUIPanelPlugin implements CustomUIPanelPlugin {
    /**
     * Called whenever the location or size of this UI panel changes.
     *
     * @param position
     */
    @Override
    public void positionChanged(PositionAPI position) {

    }

    /**
     * Below any UI elements in the panel.
     *
     * @param alphaMult
     */
    @Override
    public void renderBelow(float alphaMult) {

    }

    /**
     * alphaMult is the transparency the panel should be rendered at.
     *
     * @param alphaMult
     */
    @Override
    public void render(float alphaMult) {
//        Global.getSector().getViewport();
//        glPolygonMode(GL_TRIANGLE_STRIP, GL_FILL);
//        glBegin(GL_TRIANGLE_STRIP);
//
//        glVertex2f(0, 0);
//        glVertex2f(0, 1);
//        glVertex2f(1, 0);
//        glVertex2f(1, 1);
//
//        glEnd();
//        glFlush();

    }

    /**
     * @param amount in seconds.
     */
    @Override
    public void advance(float amount) {

    }

    /**
     * List of input events that occurred this frame. (Almost) always includes one mouse move event.
     * <p>
     * Events should be consume()d if they are acted on.
     * Mouse-move events should generally not be consumed.
     * The loop processing events should check to see if an event has already been consumed, and if so, skip it.
     * Accessing the data of a consumed event will throw an exception.
     *
     * @param events
     */
    @Override
    public void processInput(List<InputEventAPI> events) {

    }

    @Override
    public void buttonPressed(Object buttonId) {

    }

//    @Override
//    public void advance(float amount, List<InputEventAPI> events) {
//        float x = 0;
//        float y = 0;
//
//        for (InputEventAPI event : events) {
//            if (event.isLMBDownEvent()) {
//                x = event.getX();
//                y = event.getY();
//
//
//
//            }
//
//        }
//
//    }

}
