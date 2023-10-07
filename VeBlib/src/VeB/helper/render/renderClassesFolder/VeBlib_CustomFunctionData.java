package VeB.helper.render.renderClassesFolder;

public class VeBlib_CustomFunctionData {
    //you need to make the called function static
//this shit doesnt work for "secuwity weasowns" or because of skill issue

//    DEAlib_CustomFunctionData fuction = new DEAlib_CustomFunctionData();
//
//    fuction.TheClass = DEA_DrawEye.class;
//    fuction.MethodName = "DEA_DrawEyeFull";
//
//    Class[] cArgs = new Class[4];
//    cArgs[0] = ViewportAPI .class;
//    cArgs[1] = Vector2f .class;
//    cArgs[2] = float.class;
//    cArgs[3] = float.class;
//
//    fuction.cArgs = cArgs;
//
//    Object[] Variables = new Object[4];
//
//    Variables[0] = Global.getCombatEngine().getViewport();
//    Variables[1] = ship.getLocation();
//    Variables[2] = 12;
//    Variables[3] = 50;
//
//    fuction.Variables = Variables;
//
//    List<DEAlib_CustomFunctionData> customFunctionDataList = new ArrayList<>();
//
//                    customFunctionDataList.add(fuction);
//
//                    plugin.DEAlib_CustomScriptInPlugin(customFunctionDataList);

    public VeBlib_CustomFunctionData(Class TheClass, String MethodName, Class[] cArgs, Object[] Variables) {

        this.TheClass = TheClass;
        this.MethodName = MethodName;
        this.cArgs = cArgs;
        this.Variables = Variables;

    }

    public VeBlib_CustomFunctionData() {
    }

    //class
    public Class TheClass;
    //the name of the method as string, like put toString for toString()
    public String MethodName;

    //  you put stuff like this, this is for a function with one variable thats long, for custom classes do CustomClass.class and add it to this array
    //n is the amount of variables the function can take
    //      Class[] cArg = new Class[n];
    //      cArg[0] = Long.class;
    public Class[] cArgs;


    //the actual variables the function will use, not the classes of the variables
    //so if you have a long needed for a function you will need to put a number in it
    public Object[] Variables;

}
