package ExamPreparation01.cresla.entities.modules;

import ExamPreparation01.cresla.entities.AbstractIdentifiable;
import ExamPreparation01.cresla.interfaces.Module;

public abstract class AbstractModule extends AbstractIdentifiable implements Module {

    protected AbstractModule() {
        super();
    }

    protected abstract String getModuleName();

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.getModuleName()).append(" Module - ").append(this.getId()).append(System.lineSeparator());
        return sb.toString();
    }
}
