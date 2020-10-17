package ExamPreparation02.hell.entities.items;

import ExamPreparation02.hell.interfaces.Item;

public abstract class AbstractItem implements Item {

    private final String name;
    private final int strengthBonus;
    private final int agilityBonus;
    private final int intelligenceBonus;
    private final int hitPointsBonus;
    private final int damageBonus;

    protected AbstractItem(String name, int strengthBonus, int agilityBonus,
                           int intelligenceBonus, int hitPointsBonus, int damageBonus) {
        this.name = name;
        this.strengthBonus = strengthBonus;
        this.agilityBonus = agilityBonus;
        this.intelligenceBonus = intelligenceBonus;
        this.hitPointsBonus = hitPointsBonus;
        this.damageBonus = damageBonus;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getStrengthBonus() {
        return this.strengthBonus;
    }

    @Override
    public int getAgilityBonus() {
        return this.agilityBonus;
    }

    @Override
    public int getIntelligenceBonus() {
        return this.intelligenceBonus;
    }

    @Override
    public int getHitPointsBonus() {
        return this.hitPointsBonus;
    }

    @Override
    public int getDamageBonus() {
        return this.damageBonus;
    }
}
