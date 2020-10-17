package ExamPreparation02.hell.entities.heroes;

import ExamPreparation02.hell.entities.miscellaneous.HeroInventory;
import ExamPreparation02.hell.entities.miscellaneous.ItemCollection;
import ExamPreparation02.hell.interfaces.Hero;
import ExamPreparation02.hell.interfaces.Inventory;
import ExamPreparation02.hell.interfaces.Item;
import ExamPreparation02.hell.interfaces.Recipe;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public abstract class AbstractHero implements Hero {

    private final String name;
    private final int strength;
    private final int agility;
    private final int intelligence;
    private final int hitPoints;
    private final int damage;
    private final Inventory inventory;

    protected AbstractHero(String name, int strength, int agility,
                           int intelligence, int hitPoints, int damage, Inventory inventory) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.hitPoints = hitPoints;
        this.damage = damage;
        this.inventory = inventory;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public long getStrength() {
        return this.strength + this.inventory.getTotalStrengthBonus();
    }

    @Override
    public long getAgility() {
        return this.agility + this.inventory.getTotalAgilityBonus();
    }

    @Override
    public long getIntelligence() {
        return this.intelligence + this.inventory.getTotalIntelligenceBonus();
    }

    @Override
    public long getHitPoints() {
        return this.hitPoints + this.inventory.getTotalHitPointsBonus();
    }

    @Override
    public long getDamage() {
        return this.damage + this.inventory.getTotalDamageBonus();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Collection<Item> getItems() {
//        try {
//            Field modulesByInput = HeroInventory.class.getDeclaredField("commonItems");
//            modulesByInput.setAccessible(true);
//            return ((Map<String, Item>) modulesByInput.get(this.inventory)).values();
//        } catch (NoSuchFieldException | IllegalAccessException e) {
//            e.printStackTrace();
//        }
//
//        return Collections.emptyList();

        Field fields[] = HeroInventory.class.getDeclaredFields();
        for (Field field : fields) {
            Annotation itemCollection = field.getAnnotation(ItemCollection.class);

            if (itemCollection != null) {
                try {
                    field.setAccessible(true);
                    return Collections.unmodifiableCollection(((Map<String, Item>) field.get(this.inventory)).values());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return Collections.unmodifiableCollection(Collections.EMPTY_LIST);
    }

    @Override
    public void addItem(Item item) {
        this.inventory.addCommonItem(item);
    }

    @Override
    public void addRecipe(Recipe recipe) {
        this.inventory.addRecipeItem(recipe);
    }
}
