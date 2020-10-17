package ExamPreparation01.cresla.entities.modules;

import ExamPreparation01.cresla.interfaces.AbsorbingModule;

public abstract class AbstractAbsorbingModule extends AbstractModule implements AbsorbingModule {

    private int heatAbsorbing;

    protected AbstractAbsorbingModule(int heatAbsorbing) {
        super();
        this.heatAbsorbing = heatAbsorbing;
    }

    @Override
    public int getHeatAbsorbing() {
        return this.heatAbsorbing;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(super.toString());
        sb.append("Heat Absorbing: ").append(this.getHeatAbsorbing());
        return sb.toString();
    }
}
