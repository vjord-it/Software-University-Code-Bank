package ExamPanzerBattles.panzer.models.vehicles;

import ExamPanzerBattles.panzer.constants.EngineConstants;

import java.math.BigDecimal;

public class Revenger extends BaseVehicle {

    public Revenger(String model, double weight, BigDecimal price,
                    long attack, long defense, long hitPoints) {
        super(model, weight, price, attack, defense, hitPoints);
    }

    @Override
    protected double getPriceModifier() {
        return 1.5;
    }

    @Override
    protected double getAttackModifier() {
        return 2.5;
    }

    @Override
    protected double getDefenseModifier() {
        return 0.5;
    }

    @Override
    protected double getHitPointsModifier() {
        return 0.5;
    }

    @Override
    protected String getType() {
        return EngineConstants.REVENGER;
    }
}
