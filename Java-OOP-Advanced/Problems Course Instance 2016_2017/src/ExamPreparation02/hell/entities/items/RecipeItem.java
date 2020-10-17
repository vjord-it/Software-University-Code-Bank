package ExamPreparation02.hell.entities.items;

import ExamPreparation02.hell.interfaces.Recipe;

import java.util.Collections;
import java.util.List;

public class RecipeItem extends AbstractItem implements Recipe {

    private final List<String> requiredItems;

    public RecipeItem(String name, int strengthBonus, int agilityBonus, int intelligenceBonus,
                      int hitPointsBonus, int damageBonus, List<String> requiredItems) {
        super(name, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus);
        this.requiredItems = requiredItems;
    }

    @Override
    public List<String> getRequiredItems() {
        return Collections.unmodifiableList(this.requiredItems);
    }
}
