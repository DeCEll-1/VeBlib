package DEA.helper.deepstorage;

import com.fs.starfarer.api.campaign.CustomUIPanelPlugin;
import com.fs.starfarer.api.campaign.CustomVisualDialogDelegate;
import com.fs.starfarer.api.ui.CustomPanelAPI;

public class DEAlib_CustomVisualDialogDelegate implements CustomVisualDialogDelegate {
    @Override
    public void init(CustomPanelAPI panel, DialogCallbacks callbacks) {

    }

    @Override
    public CustomUIPanelPlugin getCustomPanelPlugin() {
        return null;
    }

    @Override
    public float getNoiseAlpha() {
        return 0;
    }

    @Override
    public void advance(float amount) {

    }

    @Override
    public void reportDismissed(int option) {

    }
}
