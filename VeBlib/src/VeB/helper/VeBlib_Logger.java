package VeB.helper;

import com.fs.starfarer.api.Global;

public class VeBlib_Logger {

    /**
     * logs stuff. <br/>
     * returns true if logged, othervise false
     */
    public static void log(Class myClass, String val1, String val2, String val3) {
        Global.getLogger(myClass).info(val1 + val2 + val3);
    }

    /**
     * logs stuff. <br/>
     * returns true if logged, othervise false
     */
    public static void log(Class myClass, String val1, String val2) {
        Global.getLogger(myClass).info(val1 + val2);
    }

    /**
     * logs stuff. <br/>
     * returns true if logged, othervise false
     */
    public static void log(Class myClass, String val1) {
        Global.getLogger(myClass).info(val1);
    }

}
