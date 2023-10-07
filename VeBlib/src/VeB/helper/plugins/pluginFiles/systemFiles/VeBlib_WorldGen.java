package VeB.helper.plugins.pluginFiles.systemFiles;

import VeB.helper.plugins.SectorGenerationPlugin;
import com.fs.starfarer.api.campaign.SectorAPI;
import com.fs.starfarer.api.campaign.SectorGeneratorPlugin;

import java.util.List;

public class VeBlib_WorldGen implements SectorGeneratorPlugin {

    public List<VeBlib_StarSystemData> starSystemDataList;

    public VeBlib_WorldGen(List<VeBlib_StarSystemData> starSystemDataList) {
        this.starSystemDataList = starSystemDataList;
    }

    @Override
    public void generate(SectorAPI sector) {

        SectorGenerationPlugin sectorGenerationPlugin = new SectorGenerationPlugin(starSystemDataList);

        sectorGenerationPlugin.generate(sector);
    }
}
