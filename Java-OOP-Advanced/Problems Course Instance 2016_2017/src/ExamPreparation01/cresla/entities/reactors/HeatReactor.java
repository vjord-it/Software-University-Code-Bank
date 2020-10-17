package ExamPreparation01.cresla.entities.reactors;

import ExamPreparation01.cresla.interfaces.Container;

public class HeatReactor extends AbstractReactor {

    private int heatReduction;

    public HeatReactor(Container container, int heatReduction) {
        super(container);
        this.heatReduction = heatReduction;
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return super.getTotalHeatAbsorbing() + this.heatReduction;
    }

    @Override
    protected String getReactorType() {
        return "HeatReactor";
    }
}
