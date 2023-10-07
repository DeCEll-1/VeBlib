package VeB.helper;

import java.awt.*;

public class VeBlib_ColorHelper {

    /**
     * turns a Color into hex <br>
     * as example, for Color.WHITE it will return #FFFFFFFF if it haves isTransparent true, if not #FFFFFF
     *
     * @param color         the color that will be turned into hex
     * @param isTransparent if the target hex is transparent this need to be true, otherwise it wont return a color that haves alpha value
     * @return the hex
     */
    public static String ColorToHexString(Color color, boolean isTransparent) {
        if (!isTransparent) {
            return String.format("#%02X%02X%02X", color.getRed(), color.getGreen(), color.getBlue());
        } else {
            return String.format("#%02X%02X%02X%02X", color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
        }
    }

    /**
     * gets value from a string sequence <br>
     * as example for Sw2foskv$sp241Fds string if the key is $ and lenght is 3 it will return sp2
     *
     * @param string the hex string that will get turned into color
     * @return the color
     */
    public static Color getColorFromHexString(String string) {
        return VeBlib_StringHelper.getColorFromHexString(string);
    }

    public static Color randomColor(boolean isAlpha) {
        if (isAlpha)
            return new Color(VeBlib_Statics.random.nextInt(255), VeBlib_Statics.random.nextInt(255), VeBlib_Statics.random.nextInt(255), VeBlib_Statics.random.nextInt(255));
        return new Color(VeBlib_Statics.random.nextInt(255), VeBlib_Statics.random.nextInt(255), VeBlib_Statics.random.nextInt(255));
    }

    public static Color randomiseAlpha(Color color) {
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), VeBlib_Statics.random.nextInt(255));
    }

}
