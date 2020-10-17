package ExamPanzerBattles.panzer.models.parts;

import ExamPanzerBattles.panzer.contracts.AttackModifyingPart;

import java.math.BigDecimal;

public class ArsenalPart extends BasePart implements AttackModifyingPart {

    private final int attackModifier;

    public ArsenalPart(String model, double weight, BigDecimal price, int attackModifier) {
        super(model, weight, price);
        this.attackModifier = attackModifier;
    }

    @Override
    public int getAttackModifier() {
        return this.attackModifier;
    }
}
