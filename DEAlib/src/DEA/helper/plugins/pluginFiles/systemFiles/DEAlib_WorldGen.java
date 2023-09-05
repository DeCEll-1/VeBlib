package DEA.helper.plugins.pluginFiles.systemFiles;

import DEA.helper.plugins.SectorGenerationPlugin;
import com.fs.starfarer.api.campaign.SectorAPI;
import com.fs.starfarer.api.campaign.SectorGeneratorPlugin;

import java.util.List;

public class DEAlib_WorldGen implements SectorGeneratorPlugin {

    public List<DEAlib_StarSystemData> starSystemDataList;

    public DEAlib_WorldGen(List<DEAlib_StarSystemData> starSystemDataList) {
        this.starSystemDataList = starSystemDataList;
    }

    @Override
    public void generate(SectorAPI sector) {

        SectorGenerationPlugin sectorGenerationPlugin = new SectorGenerationPlugin(starSystemDataList);

        sectorGenerationPlugin.generate(sector);
    }
}
