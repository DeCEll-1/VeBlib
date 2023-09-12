package DEA.helper;

import java.awt.*;

public class DEAlib_StringHelper {
    /**
     * gets color from a string that haves hex <br>it shouldnt be effected by uppercase/lovercase <br>
     * for example: #a2f94cF3 as input (needs #)
     *
     * @param string the string you want to get the color out of off that haves hex
     * @return returns the color it finds, if the hex is incorrect it will return an opaque white(is not tested with all of the hex values)
     */
    public static Color getColorFromHexString(String string) {
        //getting the color
        char[] slotID = string.toCharArray();

        StringBuilder ColorAsHexBuilder = null;
        StringBuilder AlphaBuilder = null;

        boolean foundTag = false;

        for (int i = 0; i < slotID.length; i++) {//getting the hex
//need a custom made value getter from string because hexes can have 2 extra letters that are for alpha and i cant just guess them nor force people to use only non transparent/only colors that have transparency so
            if (slotID[i] == '#') {

                foundTag = true;//for later

                for (int j = 1; j < 7; j++) {//it haves 6 because a hex without alpha is 6 characters

                    if (ColorAsHexBuilder == null) {
                        ColorAsHexBuilder = new StringBuilder();//makes the builder here for null check of it later in the code
                        ColorAsHexBuilder.append('#');//decoder needs either 0x of #
                    }


                    ColorAsHexBuilder.append(slotID[i + j]);//add the character to the builder

                    try {//in try catch for hexes without alpha value
                        if (j == 6) {//at the end of the opaque hex this will get the last 2 characters which carry the alpha value//if it doesnt have alpha value it will crash
                            AlphaBuilder = new StringBuilder();
                            AlphaBuilder.append(slotID[i + j + 1]);
                            AlphaBuilder.append(slotID[i + j + 2]);
                        }
                    } catch (Exception ex) {
                    }

                }

            }

        }

        Color ColorOfTheTriangleWOAlpha = null;

        Color Alpha = new Color(0, 0, 255, 255);//setting so if it doesnt gets set after it will still work
        if (!foundTag) {
            ColorOfTheTriangleWOAlpha = Color.white;//if the triangle is colorless it will be white
        } else {
            try {//color is rather weird so try catch

                String ColorAsHexString = "";
                ColorAsHexString = ColorAsHexBuilder.toString();//get normal color

                if (AlphaBuilder != null && !AlphaBuilder.toString().equals("")) {
                    Alpha = Color.decode("#000000" + AlphaBuilder.toString());//get alpha//in if because for the hexes without alpha value;
                }


                ColorOfTheTriangleWOAlpha = Color.decode(ColorAsHexString);//decodes normal color, didnt combined alpha with this because i changed it to set alpha externall and i dont want to change it// also because of the hexes without alpha it might act weird

//                            String s = "";//debug stuff

            } catch (Exception ex) {
                ColorOfTheTriangleWOAlpha = Color.white;//it will be setten white if something happens
            }
        }


        return new Color(ColorOfTheTriangleWOAlpha.getRed(), ColorOfTheTriangleWOAlpha.getGreen(), ColorOfTheTriangleWOAlpha.getBlue(), Alpha.getBlue());//combines alpha and color

    }


    /**
     * gets value from a string sequence <br>
     * as example for Sw2foskv$sp241Fds string if the key is $ and lenght is 3 it will return sp2
     *
     * @param string        the string you want to get the value out of off
     * @param key           the key character
     * @param lenghtOfValue the lenght of the value
     * @return returns the value if it can find it, if the result is null it will return null
     */
    public static String GetValueFromStringWithKey(String string, char key, int lenghtOfValue) {

        StringBuilder result = null;

        boolean foundTag = false;

        char[] stringList = string.toCharArray();

        for (int i = 0; i < stringList.length; i++) {//getting the hex

            if (stringList[i] == key) {

                foundTag = true;//for later

                for (int j = 1; j < lenghtOfValue + 1; j++) {//it haves 6 because a hex without alpha is 6 characters

                    if (result == null) {
                        result = new StringBuilder();//makes the builder here for null check of it later in the code
                    }


                    result.append(stringList[i + j]);//add the character to the builder

                }

            }

        }

        if (result != null) return result.toString();
        else return null;

    }

    /**
     * turns a Color into hex <br>
     * as example, for Color.WHITE it will return #FFFFFFFF if it haves isTransparent true, if not #FFFFFF
     *
     * @param color         the color that will be turned into hex
     * @param isTransparent if the target hex is transparent this need to be true, otherwise it wont return a color that haves alpha value
     * @return the hex
     */
    public static String ColorToHexString(Color color, boolean isTransparent) {
        return DEAlib_ColorHelper.ColorToHexString(color, isTransparent);
    }

    /**
     * gets the value between 2 different keys in a string sequence <br>
     * as example for a723nu89€fjısdkf$s9d8u as string input, € as firstKey and $ as secondKey it will give fjısdkf
     *
     * @param string    the string you want to get the value out of off
     * @param firstKey  first key
     * @param secondKey second key
     * @return returns the value if it can find it, if strings lenght is less than 3,if it cant find the lenght between 2 keys (see the code for referance) or if it crashes somewhere (probably due to wrong string input, no offense) it will return ""
     */
    public static String getStringBetween2Keys(String string, char firstKey, char secondKey) {
        try {

            if (string.length() < 3) return "";

            StringBuilder sb = new StringBuilder();

            char[] charArray = string.toCharArray();

            for (int i = 0; i < charArray.length; i++) {

                if (charArray[i] == firstKey) {

                    if (getLenghtBetween2Keys(string, firstKey, secondKey) <= -1) return "";

                    int lenght = getLenghtBetween2Keys(string, firstKey, secondKey);

                    for (int j = 0; j < lenght - 1; j++) {
                        sb.append(charArray[1 + i + j]);
                    }

                    break;

                }

            }

            return sb.toString();
        } catch (Exception ex) {
            return "";
        }
    }


    private static int getLenghtBetween2Keys(String string, char firstKey, char secondKey) {
        try {
            char[] charArray = string.toCharArray();

            int firstKeyLocation = 0;
            int secondKeyLocation = 0;

            for (int i = 0; i < charArray.length; i++) {

                if (charArray[i] == firstKey && firstKeyLocation == 0) {
                    firstKeyLocation = i;
                } else if (charArray[i] == secondKey && secondKeyLocation == 0) {
                    secondKeyLocation = i;
                    break;
                }

//                if (charArray[i] == secondKey && secondKeyLocation == 0) {
            }

            return secondKeyLocation - firstKeyLocation;

        } catch (Exception ex) {
            return -1;
        }
    }
}
