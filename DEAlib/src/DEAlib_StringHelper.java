public class DEAlib_StringHelper {

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

}
