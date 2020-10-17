package ExamPreparation01.cresla.entities.modules;

import ExamPreparation01.cresla.interfaces.EnergyModule;

public abstract class AbstractEnergyModule extends AbstractModule implements EnergyModule {

    private int energyOutput;

    protected AbstractEnergyModule(int energyOutput) {
        super();
        this.energyOutput = energyOutput;
    }

    @Override
    public int getEnergyOutput() {
        return this.energyOutput;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(super.toString());
        sb.append("Energy Output: ").append(this.getEnergyOutput());
        return sb.toString();
    }
}
