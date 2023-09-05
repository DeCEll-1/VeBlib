package DEA.helper;

import java.awt.*;

public class DEAlib_Rainbow {

    public int colorRed = 254;
    public int colorGreen = 0;
    public int colorBlue = 0;

    public Color RainbowColor;

    /**
     * makes rainbow </br>
     * changes the color every time its called, use multiple times every frame to speed it up
     */
    public void Rainbow() {
        int b = 1;

        if (colorRed == 254 && !(colorGreen >= 254) && colorBlue == 0) {
            colorGreen = colorGreen + b;
        } else if (colorRed <= 254 && colorRed != 0 && colorGreen == 254 && colorBlue == 0) {
            colorRed = colorRed - b;
        } else if (colorRed <= 254 && colorGreen == 254 && colorBlue >= 0 && colorBlue < 254) {
            colorBlue = colorBlue + b;
        } else if (colorRed == 0 && colorGreen <= 254 && colorGreen > 0 && colorBlue == 254) {
            colorGreen = colorGreen - b;
        } else if (colorRed < 254 && colorGreen == 0 && colorBlue == 254) {
            colorRed = colorRed + b;
        } else if (colorRed == 254 && colorGreen == 0 && colorBlue > 0) {
            colorBlue = colorBlue - b;
        }
        RainbowColor = new Color(colorRed, colorGreen, colorBlue, 255);
    }

    /**
     * gets the color rainbow </br>
     *
     * @param alpha the alpha value MUST be between 0-255 AND int (0 being min 255 being max)
     * @return the current color of rainbow(gay)
     */
    public Color RainbowWithAlpha(int alpha) {
        return new Color(RainbowColor.getRed(), RainbowColor.getGreen(), RainbowColor.getBlue(), alpha);
    }

}
