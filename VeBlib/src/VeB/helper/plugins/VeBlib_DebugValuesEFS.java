package VeB.helper.plugins;

import VeB.helper.VeBlib_Statics;
import VeB.helper.render.VeBlib_RendererPlugin;
import VeB.helper.render.premadeObjects.VeBlib_Panel00Animation;
import VeB.helper.render.premadeObjects.VeBlib_Panel00Panel;
import VeB.helper.render.premadeObjectsRenderers.VeBlib_Panel00Renderer;
import VeB.helper.render.renderClassesFolder.VeBlib_SquareData;
import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.combat.BaseEveryFrameCombatPlugin;
import com.fs.starfarer.api.combat.ViewportAPI;
import com.fs.starfarer.api.input.InputEventAPI;
import com.fs.starfarer.api.util.Misc;
import org.lazywizard.lazylib.ui.FontException;
import org.lazywizard.lazylib.ui.LazyFont;
import org.lwjgl.util.vector.Vector2f;

import java.awt.*;
import java.util.*;
import java.util.List;

public class VeBlib_DebugValuesEFS extends BaseEveryFrameCombatPlugin {

    private boolean doOnce = true;
    private boolean active = true;
    private boolean enabled = true;
    private char toggleCharacter = '.';


    private LazyFont s = null;
    private float combatTime = 0f;


    private List<LazyFont.DrawableString> textList = new ArrayList<>();

    private float marginTopIncreaseAmount = 48f;

    private VeBlib_RendererPlugin plugin = null;
    private VeBlib_Panel00Renderer panelRendererPlugin = null;

    private VeBlib_Panel00Panel panelTo;
    private VeBlib_Panel00Panel panelFrom;

    private float screenHeight = Global.getSettings().getScreenHeight();
    private float screenWidth = Global.getSettings().getScreenWidth();
    private float panelHeight = 300f;
    private float[] panelPaddings = {
            0f,
            120f,
            0f,
            screenWidth - (panelHeight * 2)
    };

    public VeBlib_DebugValuesEFS() throws FontException {

        //region panels location to

        panelTo = new VeBlib_Panel00Panel(
                new Vector2f(
                        0 + panelPaddings[3],
                        screenHeight - panelPaddings[0]
                ),//top left duud

                new Vector2f(
                        screenWidth - panelPaddings[1],
                        screenHeight - panelPaddings[0]
                ),//top right duud

                new Vector2f(
                        0 + panelPaddings[3],
                        screenHeight - panelHeight + panelPaddings[2]
                ),//bottom left duud

                new Vector2f(
                        screenWidth - panelPaddings[1],
                        screenHeight - panelHeight + panelPaddings[2]
                )//bottom right duud
        );

//            Vector2f topLeft = new Vector2f(
//                    0 + panelPaddings[3],
//                    screenHeight - panelPaddings[0]
//            );//top left duud
//
//            Vector2f topRight = new Vector2f(
//                    screenWidth - panelPaddings[1],
//                    screenHeight - panelPaddings[0]
//            );//top right duud
//
//            Vector2f bottomLeft = new Vector2f(
//                    0 + panelPaddings[3],
//                    screenHeight - panelHeight + panelPaddings[2]
//            );//bottom left duud
//
//            Vector2f bottomRight = new Vector2f(
//                    screenWidth - panelPaddings[1],
//                    screenHeight - panelHeight + panelPaddings[2]
//            );//bottom right duud

        //endregion

        //region panels location from

        panelFrom = new VeBlib_Panel00Panel(
                new Vector2f(
                        0 + panelPaddings[3],
                        screenHeight - panelPaddings[0]
                ),//top left duud

                new Vector2f(
                        screenWidth - panelPaddings[1],
                        screenHeight - panelPaddings[0]
                ),//top right duud

                new Vector2f(
                        0 + panelPaddings[3],
                        screenHeight - panelPaddings[0]
                ),//top left duud

                new Vector2f(
                        screenWidth - panelPaddings[1],
                        screenHeight - panelPaddings[0]
                )//top right duud
        );

        //endregion

    }

    @Override
    public void renderInUICoords(ViewportAPI viewport) {
        if (!enabled) return;

        if (active) {
//todo add a setting in settings to disable this

            if (plugin == null) {
                plugin = new VeBlib_RendererPlugin();
                Global.getCombatEngine().addLayeredRenderingPlugin(plugin);

                panelRendererPlugin = new VeBlib_Panel00Renderer(new VeBlib_Panel00Animation(
                        panelFrom,
                        panelTo,
                        1.5f
                ));
//                panelRendererPlugin = new VeBlib_Panel00Renderer(panelTo);
                Global.getCombatEngine().addLayeredRenderingPlugin(panelRendererPlugin);

            }


            try {

                //todo ~~make this a generalised fuction~~ see VeBlib_Panel00Renderer


            } catch (Exception ex) {

            }


            try {

//                CollisionUtils.getCollisionPoint()//https://cdn.discordapp.com/attachments/824910699415207937/1154100025383727295/image.png

//                debugTextList.put("aaaaaaaaaaaaaaaaaaaaaaaa", Color.CYAN);

//                Global.getCombatEngine().getPlayerShip().setHitpoints(-1f);


                if (doOnce) {
//                    s = LazyFont.loadFont("data/fonts/fontTest1/fontTest1.fnt");
                    s = LazyFont.loadFont("graphics/fonts/insignia16.fnt");

                    if (!Global.getSettings().getBoolean("enableDebugValuesOnCombat")) enabled = false;

                    toggleCharacter = Global.getSettings().getString("showDebugValuesOnCombat").toCharArray()[0];
                }

//region font

                if (s == null) s = LazyFont.loadFont("graphics/fonts/insignia16.fnt");


                textList = new ArrayList<>();

//            textList.add(s.createText("x: " + Float.toString((float) Math.floor(Global.getCombatEngine().getPlayerShip().getLocation().x))));
//            textList.add(s.createText("y: " + Float.toString((float) Math.floor(Global.getCombatEngine().getPlayerShip().getLocation().y))));
//
//            textList.add(s.createText("cursorX: " + Float.toString((float) Math.floor(Global.getCombatEngine().getPlayerShip().getMouseTarget().x))));
//            textList.add(s.createText("cursorY: " + Float.toString((float) Math.floor(Global.getCombatEngine().getPlayerShip().getMouseTarget().y))));

                textList.add(s.createText("debugDatas:", Misc.getTextColor()));

                VeBlib_Statics.debugTextList.put("totalCombatTime: " + combatTime, Misc.getTextColor());
//                VeBlib_Statics.debugTextList.put("getHighlightColor: <insert value here>", Misc.getHighlightColor());
//                VeBlib_Statics.debugTextList.put("getNegativeHighlightColor: <insert value here>", Misc.getNegativeHighlightColor());
//                VeBlib_Statics.debugTextList.put("getPositiveHighlightColor: <insert value here>", Misc.getPositiveHighlightColor());
//                VeBlib_Statics.debugTextList.put("getStoryOptionColor: <insert value here>", Misc.getStoryOptionColor());
//                VeBlib_Statics.debugTextList.put("i am longggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg", Misc.getTextColor());

                for (Map.Entry<String, Color> texts : VeBlib_Statics.debugTextList.entrySet()) {

                    textList.add(s.createText(texts.getKey(), texts.getValue()));

                }

                VeBlib_Statics.debugTextList = new HashMap<>();

                float marginTop = 32f;

                for (LazyFont.DrawableString text : textList) {

                    text.setMaxWidth(panelTo.topRight.x - panelTo.topLeft.x - 64f);

                    text.setFontSize(16f);

                    text.draw(panelTo.topLeft.x + 32f, Global.getSettings().getScreenHeight() - marginTop);
                    marginTop += marginTopIncreaseAmount;
                }

                //endregion

                //region sliders

                List<VeBlib_SquareData> squareDataList = new ArrayList<>();


//endregion

            } catch (Exception ex) {
            }

        }

    }

    @Override
    public void renderInWorldCoords(ViewportAPI viewport) {

        //region wave shit not worked

//        lineWWidthList = new ArrayList<>();
//        lastVector = null;
//
//        if (plugin == null) {
//            plugin = new VeBlib_RendererPlugin();
//            Global.getCombatEngine().addLayeredRenderingPlugin(plugin);
//        }
//
//        if (Global.getCombatEngine().isPaused()) return;

        // first test

//        float detail = 1f;
//        float waveLenght = 400f;
//        float lenghtBetweenWaves = 200f;
//        float widthOfTheWave = 50f;
//        float angleOfLines = 0f;
//        float angleOfWave = 0f;
//        float amountOfSins = 2f;
//        float timeMult = 50f;
//
//        Vector2f from = new Vector2f(
//                Global.getCombatEngine().getPlayerShip().getLocation().x,
//                Global.getCombatEngine().getPlayerShip().getLocation().y
//        );
//
//        VeBlib_Statics.debugTextList.put("segmentPopulationScale: " + detail, Color.magenta);
//        VeBlib_Statics.debugTextList.put("waveLenght: " + waveLenght, Color.pink);
//        VeBlib_Statics.debugTextList.put("lenghtBetweenWaves: " + lenghtBetweenWaves, Color.cyan);
//        VeBlib_Statics.debugTextList.put("widthOfTheWave: " + widthOfTheWave, Color.yellow);
////        VeBlib_Statics.debugTextList.put("time: " + time, Color.ORANGE);
//
//        Vector2f to = null;
//
//        VeBlib_Statics.debugTextList.put("lineCount: " + lineWWidthList.size(), Color.red);
//
//
//        if (plugin == null) {
//            plugin = new VeBlib_RendererPlugin();
//            Global.getCombatEngine().addLayeredRenderingPlugin(plugin);
//        }
//
//        if (Global.getCombatEngine().isPaused()) return;
//
//        lineWWidthList = new ArrayList<>();
//
//        plugin.ChangeRenderLayerInPlugin(CombatEngineLayers.ABOVE_PARTICLES);
//
//
//        float x = 0;
//
//        while (true) {
//
//            x += 1f;
//
//            sinN += 0.5f;
//
////            List<VeBlib_LineData> lineList = new ArrayList<>();
//
//
////            if (true) {
////            if (sinN % segmentPopulationScale < 0.1f) {
//
//
//            to = new Vector2f(
//                    MathUtils.getPointOnCircumference(
//                            from,
//                            (float) Math.sin(sinN + (t * timeMult) + (randomWaveValue)) * widthOfTheWave,//where magic happens (i dont know math)
//                            0f
//                    )
//            );
//
////            to = MathUtils.getPointOnCircumference(
////                    to,
////                    lenghtBetweenWaves,
////                    90f
////            );
//
//            to.y += sinN * lenghtBetweenWaves / 2f / 3.1f;//lenght between waves//3.1f is the magic number and idk why
//
//            to.y -= (sinN * lenghtBetweenWaves / 2f / 3.1f) / 2;
//
////fazladan çalıştır ama böl
//
//            if (lastVector != null) {
//                if (angleOfLines == 0f) {
//                    lineWWidthList.add(
//                            new VeBlib_LineWWidthData(
//                                    lastVector,
//                                    to,
//                                    1f,
//                                    Color.RED
//                            )
//                    );
//                } else {//for the 3d effect waves
//                    lineWWidthList.add(
//                            new VeBlib_LineWWidthData(
//                                    lastVector,
//                                    MathUtils.getPointOnCircumference(
//                                            lastVector,
//                                            MathUtils.getDistance(lastVector, to),
//                                            angleOfLines
//
//                                    ),
//                                    1f,
//                                    Color.RED
//                            )
//                    );
//                }
//
//
//            } else {
//                lastVector = from;
//            }
//
//            lastVector = to;
//
//
//            if (sinN / 3.1f >= waveLenght / lenghtBetweenWaves * 2f) {//the bigger number on the right side the longer it gets
//                sinN = 0;
//                lineWWidthList.add(
//                        new VeBlib_LineWWidthData(
//                                lastVector,
//                                to,
//                                1f,
//                                Color.RED
//                        )
//                );
//                lastVector = null;
//
//                break;
//
//            }
//        }
//
//        if (sinN % 0.5f < 0.05f) {
//
//            for (float i = 1; i < amountOfSins; i++) {
//                randomWaveValue += Math.sin(x + 1 / i);
////                    lenghtBetweenWaves += lenghtBetweenWaves;
//            }
//
////            }
//
//
//        }
//
//        randomWaveValue = 0f;
//
//        t += 0.001f;
//
//        if (t > 50f) {
//            t = -50f;
//        }
//
//
//        ShipAPI ship = Global.getCombatEngine().getPlayerShip();
//
////        linesForWave.add(new VeBlib_LineWWidthData(ship.getLocation(), new Vector2f(ship.getLocation().x, ship.getLocation().y + lenghtBetweenWaves), 4f, Color.cyan));
//        plugin.LineWWidthInPlugin(lineWWidthList);


        // AAAAAAAAAA
//
//        Vector2f center = new Vector2f(0, -1500);
//
//        Vector2f target = new Vector2f(0f, -1300);
//
//        List<VeBlib_LineData> lineData = new ArrayList<>();
//
////        lineData.add(new VeBlib_LineData(center, target, Color.WHITE));
//
//        plugin.LineInPlugin(lineData);
//
//        //region variables
//
//        VeBlib_Statics.debugTextList.put("lineCount: " + lineWWidthList.size(), Color.red);
//
//
//        float timeMult = 0.00001f;
//        float lenght = 200f;
//        float lenghtBetweenWaves = 20f;
//        float angle = 30f;
//        float widthOfTheWave = 40f;
////        Vector2f from = Global.getCombatEngine().getPlayerShip().getLocation();
//        Vector2f from = new Vector2f(0f, -1500f);
//
//        //endregion
//
////HELP ME COSMOS HELP ME
//
//        if (Global.getCombatEngine().isPaused()) return;
//
//        lineWWidthList = new ArrayList<>();
//
//        float x = 0f;//THE FLOOR
//        float y = 0f;//THE ESCALATOR
//
//
//        t += Global.getCombatEngine().getTotalElapsedTime(false) * timeMult;//increase time
//
//        for (int i = 0; x < lenght / lenghtBetweenWaves; x += 1f) {//i dont know what i am doing :(
//
//            y = (float) Math.sin((t + x)) * widthOfTheWave;
//
////            if (y < 0) y = y * -1;
//
//            Vector2f yRightBottom = MathUtils.getPointOnCircumference(
//                    from,
//                    y,
//                    0 + angle
//            );
//
//
//            Vector2f to = MathUtils.getPointOnCircumference(
//                    yRightBottom,
//                    lenghtBetweenWaves,
//                    90 + angle
//            );
//
//
//            lineWWidthList.add(
//                    new VeBlib_LineWWidthData(
//                            from,
//                            to,
//                            1f,
//                            Color.red
//                    )
//            );
//
//            from = to;
//
////            angle = VeBlib_Helper.GetPlusMinusAngle(angle, 180);
//
//        }
//
//        plugin.LineWWidthInPlugin(lineWWidthList);
//
//
//        if (t > 1000f) t = 0f;


        //düz dalga yap sonra döndür DESMOS ANANIN ANI DESMOS AZCIK YARDIM ET

        // use your brain neurons for code not for flat girl trianglussy

//        ShipAPI ship = Global.getCombatEngine().getPlayerShip();
//
////variables
//        t += Global.getCombatEngine().getElapsedInLastFrame();
//        List<VeBlib_LineWWidthData> unrotatedLineList = new ArrayList<>();
//        float height = 1000f;
//        float detail = 5f;
//        float waveHeight = 500f;
//        Vector2f from = new Vector2f(
//                ship.getLocation().x,
//                ship.getLocation().y
//        );
//        float angle = ship.getFacing();
//        float width = 50f;
//
//        float y = 0f;
//        float x = 0f;
//
//        //CODE
//        if (lastVector == null) lastVector = from;
//
//        while (true) {
//            y += 0.5f;
//
//            x = y / waveHeight / 4f;
//
//            if (y % detail < 0.03) {
//
//
//                float xSin = (float) Math.sin(t + (x * 360f)) * width;//value thatll be used for x
////it does work but the problem is that it needs a value between 0-360 and its usually not between 360 sooooo
//
//
//                Vector2f to = new Vector2f(
//                        lastVector.x,
//                        from.y
//                );
//
//                to.x += xSin;
//
//                to.y += y;
//
//                unrotatedLineList.add(new VeBlib_LineWWidthData(lastVector, to, 1f, Color.WHITE));
//
//                lastVector = to;
//
//            }
//
//            if (y > height) {
//                break;
//            }
//
//        }
//
//
//        for (VeBlib_LineWWidthData lineToRotate : unrotatedLineList) {
//
//            lineWWidthList.add(
//                    new VeBlib_LineWWidthData(
//                            MathUtils.getPointOnCircumference(
//                                    from,
//                                    MathUtils.getDistance(
//                                            from,
//                                            lineToRotate.fromCenter
//                                    ),
//                                    angle + VectorUtils.getAngle(from, lineToRotate.fromCenter) - 90f
//                            ),
//                            MathUtils.getPointOnCircumference(
//                                    from,
//                                    MathUtils.getDistance(
//                                            from,
//                                            lineToRotate.toCenter
//                                    ),
//                                    angle + VectorUtils.getAngle(from, lineToRotate.toCenter) - 90f
//                            ),
//                            2f,
//                            Color.WHITE
//                    )
//            );
//
//        }
//
//        plugin.LineWWidthInPlugin(lineWWidthList);
//
//        lineList = new ArrayList<>();
//
//        lineList.add(new VeBlib_LineData(from, MathUtils.getPointOnCircumference(from, height, angle), Color.CYAN));
//
//        plugin.LineInPlugin(lineList);


        //endregion


    }

    @Override
    public void advance(float amount, List<InputEventAPI> events) {

        combatTime += Global.getCombatEngine().getElapsedInLastFrame();

        //
//        try {
//
////            if (plugin == null) {
////                plugin = new VeBlib_RendererPlugin();
////                Global.getCombatEngine().addLayeredRenderingPlugin(plugin);
////
////                mapWidth = Global.getCombatEngine().getMapWidth();
////                mapHeight = Global.getCombatEngine().getMapHeight();
////
////
////                for (float i = mapHeight / 2 * -1; i < mapHeight / 2; i += 100f) {
////
////                    Vector2f from = new Vector2f(i, mapHeight / 2 * -1f);
////
////                    Vector2f to = new Vector2f(i, mapHeight / 2);
////
////                    VeBlib_LineData line = new VeBlib_LineData(from, to, Color.WHITE);
////
////                    lineList.add(line);
////                }
////
////
////            }
////
////            plugin.LineInPlugin(lineList);
//
//        } catch (Exception ex) {
//
//        }

    }


    @Override
    public void processInputPreCoreControls(float amount, List<InputEventAPI> events) {

        if (!enabled) return;

        for (InputEventAPI event : events) {
            if (event.isKeyboardEvent() && event.getEventChar() == toggleCharacter) {
                active = !active;

                panelRendererPlugin.resetAnimation();
                panelRendererPlugin.stopContinueAnimation();

            }

            if (event.isLMBDownEvent()) {

//                VeBlib_Logger.log(VeBlib_Logger.class, Integer.toString(event.getX()));
//                VeBlib_Logger.log(VeBlib_Logger.class, Integer.toString(event.getY()));


            }

        }


    }


}

