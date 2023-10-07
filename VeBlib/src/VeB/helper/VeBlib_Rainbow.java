package VeB.helper;

import java.awt.*;

public class VeBlib_Rainbow {

    private int colorRed = 254;
    private int colorGreen = 0;
    private int colorBlue = 0;

    private Color RainbowColor;

    /**
     * advances rainbow </br>
     * changes the color every time its called, add a number in the method to change it faster (like advance(5) will speed it up 5 times)
     */
    public void advance() {
        int b = 1;
//this code is transformed from js to java, both versions are made by me :clueless:
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
     * advances rainbow as much as the advanceHowMuch </br>like putting 5 advances 5 times
     * changes the color every time its called, add a number in the method to change it faster (like advance(5) will speed it up 5 times)
     */
    public void advance(int advanceHowMuch) {
        if (advanceHowMuch <= 0) return;
        for (int i = 0; i < advanceHowMuch; i++) {
            advance();
        }
    }

    /**
     * gets the color rainbow </br>
     *
     * @param alpha
     * @return the current color of rainbow(gay)
     */
    public Color RainbowWithAlpha(int alpha) {

        if (alpha < 0 || alpha > 255) return null;

        return new Color(RainbowColor.getRed(), RainbowColor.getGreen(), RainbowColor.getBlue(), alpha);
    }

    public Color getRainbow() {
        return new Color(RainbowColor.getRed(), RainbowColor.getGreen(), RainbowColor.getBlue());
    }

}
