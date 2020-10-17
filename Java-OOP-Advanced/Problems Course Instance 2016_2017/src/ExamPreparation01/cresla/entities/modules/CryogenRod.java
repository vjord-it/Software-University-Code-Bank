package ExamPreparation01.cresla.entities.modules;

public class CryogenRod extends AbstractEnergyModule {

    public CryogenRod(int energyOutput) {
        super(energyOutput);
    }

    @Override
    protected String getModuleName() {
        return "CryogenRod";
    }
}
