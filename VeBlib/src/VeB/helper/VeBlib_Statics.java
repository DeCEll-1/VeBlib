package VeB.helper;

import VeB.helper.plugins.VeBlib_DebugValuesSlidebar;
import VeB.helper.test.VeBlib_BaseClasTEST;
import org.lazywizard.lazylib.ui.LazyFont;

import java.awt.*;
import java.util.*;
import java.util.List;

public class VeBlib_Statics {

    public static Random random = new Random();


    public static Color TRANSPARENT = new Color(0, 0, 0, 0);
    public static Color transparent = TRANSPARENT;

    public static Map<String, Color> debugTextList = new HashMap<>();
    public static List<VeBlib_DebugValuesSlidebar> slidebarList = new ArrayList<>();

//    public static VeBlib_BaseClasTEST BaseClassTest = null;

//    public static DEAlib_EveryFrameScript DEAlib_CampaignRenderer;

}
