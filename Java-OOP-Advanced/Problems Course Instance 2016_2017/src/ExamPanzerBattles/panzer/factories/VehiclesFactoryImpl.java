package ExamPanzerBattles.panzer.factories;

import ExamPanzerBattles.panzer.constants.EngineConstants;
import ExamPanzerBattles.panzer.contracts.Vehicle;
import ExamPanzerBattles.panzer.contracts.VehiclesFactory;
import ExamPanzerBattles.panzer.models.vehicles.Revenger;
import ExamPanzerBattles.panzer.models.vehicles.Vanguard;

import java.math.BigDecimal;

public class VehiclesFactoryImpl implements VehiclesFactory {

    private static final VehiclesFactoryImpl INSTANCE = new VehiclesFactoryImpl();

    private VehiclesFactoryImpl() {
    }

    public static VehiclesFactoryImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public Vehicle create(String[] parameters) {
        String type = parameters[0];
        String model = parameters[1];
        double weight = Double.parseDouble(parameters[2]);
        BigDecimal price = new BigDecimal(parameters[3]);
        long attack = Long.parseLong(parameters[4]);
        long defense = Long.parseLong(parameters[5]);
        long hitPoints = Long.parseLong(parameters[6]);

        switch (type) {
        case EngineConstants.VANGUARD:
            return new Vanguard(model, weight, price, attack, defense, hitPoints);
        case EngineConstants.REVENGER:
            return new Revenger(model, weight, price, attack, defense, hitPoints);
        default:
            return null;
        }
    }
}
