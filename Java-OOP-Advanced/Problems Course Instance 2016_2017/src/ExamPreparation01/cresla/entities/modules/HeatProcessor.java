package ExamPreparation01.cresla.entities.modules;

public class HeatProcessor extends AbstractAbsorbingModule {

    public HeatProcessor(int heatAbsorbing) {
        super(heatAbsorbing);
    }

    @Override
    protected String getModuleName() {
        return "HeatProcessor";
    }
}
