package ExamPreparation01.cresla.entities.modules;

public class CooldownSystem extends AbstractAbsorbingModule {

    public CooldownSystem(int heatAbsorbing) {
        super(heatAbsorbing);
    }

    @Override
    protected String getModuleName() {
        return "CooldownSystem";
    }
}
