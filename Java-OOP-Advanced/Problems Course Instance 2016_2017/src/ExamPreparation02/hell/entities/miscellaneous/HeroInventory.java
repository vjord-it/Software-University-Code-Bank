package ExamPreparation02.hell.entities.miscellaneous;

import ExamPreparation02.hell.entities.items.CommonItem;
import ExamPreparation02.hell.interfaces.Inventory;
import ExamPreparation02.hell.interfaces.Item;
import ExamPreparation02.hell.interfaces.Recipe;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class HeroInventory implements Inventory {

    @ItemCollection
    private final Map<String, Item> commonItems;
    private final Map<String, Recipe> recipeItems;

    public HeroInventory() {
        this.commonItems = new LinkedHashMap<>();
        this.recipeItems = new LinkedHashMap<>();
        this.checkRecipes();
    }

    @Override
    public long getTotalStrengthBonus() {
        return this.commonItems.values().stream().mapToLong(Item::getStrengthBonus).sum();
    }

    @Override
    public long getTotalAgilityBonus() {
        return this.commonItems.values().stream().mapToLong(Item::getAgilityBonus).sum();
    }

    @Override
    public long getTotalIntelligenceBonus() {
        return this.commonItems.values().stream().mapToLong(Item::getIntelligenceBonus).sum();
    }

    @Override
    public long getTotalHitPointsBonus() {
        return this.commonItems.values().stream().mapToLong(Item::getHitPointsBonus).sum();
    }

    @Override
    public long getTotalDamageBonus() {
        return this.commonItems.values().stream().mapToLong(Item::getDamageBonus).sum();
    }

    @Override
    public void addCommonItem(Item item) {
        this.commonItems.put(item.getName(), item);
        this.checkRecipes();
    }

    @Override
    public void addRecipeItem(Recipe recipe) {
        this.recipeItems.put(recipe.getName(), recipe);
        this.checkRecipes();
    }

    private void checkRecipes() {
        List<String> toRemove = new ArrayList<>();

        for (Recipe recipe : this.recipeItems.values()) {
            List<String> requiredItems = new ArrayList<>(recipe.getRequiredItems());

            for (Item item : this.commonItems.values()) {
                requiredItems.remove(item.getName());
            }

            if (requiredItems.isEmpty()) {
                this.combineRecipe(recipe);
                toRemove.add(recipe.getName());
            }
        }

        for (String recipe : toRemove) {
            this.recipeItems.remove(recipe);
        }
    }

    private void combineRecipe(Recipe recipe) {
        for (String item : recipe.getRequiredItems()) {
            this.commonItems.remove(item);
        }

        Item newItem = new CommonItem(recipe.getName(), recipe.getStrengthBonus(), recipe.getAgilityBonus(),
                recipe.getIntelligenceBonus(), recipe.getHitPointsBonus(), recipe.getDamageBonus());

        this.commonItems.put(newItem.getName(), newItem);
    }
}
