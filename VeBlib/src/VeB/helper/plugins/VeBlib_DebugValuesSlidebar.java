package VeB.helper.plugins;

import java.awt.*;

public class VeBlib_DebugValuesSlidebar {

    public VeBlib_DebugValuesSlidebar(float currentValue, float maxValue, float minValue, float height, Color sliderColor, Color sliderButtonColor) {

        this.currentValue = currentValue;
        this.maxValue = maxValue;
        this.minValue = minValue;
        this.height = height;
        this.sliderColor = sliderColor;
        this.sliderButtonColor = sliderButtonColor;

    }

    public float currentValue;
    public float maxValue;
    public float minValue;
    public float height;
    public Color sliderColor;
    public Color sliderButtonColor;


}
