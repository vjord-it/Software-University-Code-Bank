package ExamPanzerBattles.panzer.models.vehicles;

import ExamPanzerBattles.panzer.constants.EngineConstants;

import java.math.BigDecimal;

public class Vanguard extends BaseVehicle {

    public Vanguard(String model, double weight, BigDecimal price,
                    long attack, long defense, long hitPoints) {
        super(model, weight, price, attack, defense, hitPoints);
    }

    @Override
    protected double getWeightModifier() {
        return 2.0;
    }

    @Override
    protected double getAttackModifier() {
        return 0.75;
    }

    @Override
    protected double getDefenseModifier() {
        return 1.5;
    }

    @Override
    protected double getHitPointsModifier() {
        return 1.75;
    }

    @Override
    protected String getType() {
        return EngineConstants.VANGUARD;
    }
}
