package ExamPreparation01.cresla.entities.reactors;

import ExamPreparation01.cresla.interfaces.Container;

public class CryoReactor extends AbstractReactor {

    private int cryoProductionIndex;

    public CryoReactor(Container container, int cryoProductionIndex) {
        super(container);
        this.cryoProductionIndex = cryoProductionIndex;
    }

    @Override
    protected long getEnergy() {
        return super.getEnergy() * this.cryoProductionIndex;
    }

    @Override
    protected String getReactorType() {
        return "CryoReactor";
    }
}
