package ExamPanzerBattles.panzer.factories;

import ExamPanzerBattles.panzer.constants.EngineConstants;
import ExamPanzerBattles.panzer.contracts.Part;
import ExamPanzerBattles.panzer.contracts.PartsFactory;
import ExamPanzerBattles.panzer.models.parts.ArsenalPart;
import ExamPanzerBattles.panzer.models.parts.EndurancePart;
import ExamPanzerBattles.panzer.models.parts.ShellPart;

import java.math.BigDecimal;

public class PartsFactoryImpl implements PartsFactory {

    private static final PartsFactoryImpl INSTANCE = new PartsFactoryImpl();

    private PartsFactoryImpl() {
    }

    public static PartsFactoryImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public Part create(String[] parameters) {
        String type = parameters[0];
        String model = parameters[1];
        double weight = Double.parseDouble(parameters[2]);
        BigDecimal price = new BigDecimal(parameters[3]);
        int additionalParameter = Integer.parseInt(parameters[4]);

        switch (type) {
        case EngineConstants.ARSENAL:
            return new ArsenalPart(model, weight, price, additionalParameter);
        case EngineConstants.SHELL:
            return new ShellPart(model, weight, price, additionalParameter);
        case EngineConstants.ENDURANCE:
            return new EndurancePart(model, weight, price, additionalParameter);
        default:
            return null;
        }
    }
}
