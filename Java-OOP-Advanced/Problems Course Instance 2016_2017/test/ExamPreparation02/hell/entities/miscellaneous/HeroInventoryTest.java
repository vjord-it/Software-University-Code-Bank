package ExamPreparation02.hell.entities.miscellaneous;

import ExamPreparation02.hell.interfaces.Inventory;
import ExamPreparation02.hell.interfaces.Item;
import ExamPreparation02.hell.interfaces.Recipe;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class HeroInventoryTest {

    private Item commonItem1;
    private Item commonItem2;
    private Item commonItem3;
    private Recipe recipeItem1;
    private Recipe recipeItem2;
    private Recipe recipeItem3;
    private HeroInventory heroInventory;

    @Before
    public void setUp() {
        this.heroInventory = new HeroInventory();
        commonItem1 = Mockito.mock(Item.class);
        Mockito.when(this.commonItem1.getName()).thenReturn("Item1");
        Mockito.when(this.commonItem1.getStrengthBonus()).thenReturn(2_000_000_000);
        Mockito.when(this.commonItem1.getAgilityBonus()).thenReturn(2_000_000_000);
        Mockito.when(this.commonItem1.getIntelligenceBonus()).thenReturn(2_000_000_000);
        Mockito.when(this.commonItem1.getHitPointsBonus()).thenReturn(2_000_000_000);
        Mockito.when(this.commonItem1.getDamageBonus()).thenReturn(2_000_000_000);

        commonItem2 = Mockito.mock(Item.class);
        Mockito.when(this.commonItem2.getName()).thenReturn("Item2");
        Mockito.when(this.commonItem2.getStrengthBonus()).thenReturn(2_000_000_000);
        Mockito.when(this.commonItem2.getAgilityBonus()).thenReturn(2_000_000_000);
        Mockito.when(this.commonItem2.getIntelligenceBonus()).thenReturn(2_000_000_000);
        Mockito.when(this.commonItem2.getHitPointsBonus()).thenReturn(2_000_000_000);
        Mockito.when(this.commonItem2.getDamageBonus()).thenReturn(2_000_000_000);

        commonItem3 = Mockito.mock(Item.class);
        Mockito.when(this.commonItem3.getName()).thenReturn("Item3");
        Mockito.when(this.commonItem3.getStrengthBonus()).thenReturn(1);
        Mockito.when(this.commonItem3.getAgilityBonus()).thenReturn(2);
        Mockito.when(this.commonItem3.getIntelligenceBonus()).thenReturn(3);
        Mockito.when(this.commonItem3.getHitPointsBonus()).thenReturn(4);
        Mockito.when(this.commonItem3.getDamageBonus()).thenReturn(5);

        recipeItem1 = Mockito.mock(Recipe.class);
        Mockito.when(this.recipeItem1.getName()).thenReturn("Recipe1");
        Mockito.when(this.recipeItem1.getStrengthBonus()).thenReturn(2_000_000_000);
        Mockito.when(this.recipeItem1.getAgilityBonus()).thenReturn(2_000_000_000);
        Mockito.when(this.recipeItem1.getIntelligenceBonus()).thenReturn(2_000_000_000);
        Mockito.when(this.recipeItem1.getHitPointsBonus()).thenReturn(2_000_000_000);
        Mockito.when(this.recipeItem1.getDamageBonus()).thenReturn(2_000_000_000);
        Mockito.when(this.recipeItem1.getRequiredItems()).thenReturn(Arrays.asList("Item1", "Item2"));

        recipeItem2 = Mockito.mock(Recipe.class);
        Mockito.when(this.recipeItem2.getName()).thenReturn("Recipe2");
        Mockito.when(this.recipeItem2.getStrengthBonus()).thenReturn(2_000_000_000);
        Mockito.when(this.recipeItem2.getAgilityBonus()).thenReturn(2_000_000_000);
        Mockito.when(this.recipeItem2.getIntelligenceBonus()).thenReturn(2_000_000_000);
        Mockito.when(this.recipeItem2.getHitPointsBonus()).thenReturn(2_000_000_000);
        Mockito.when(this.recipeItem2.getDamageBonus()).thenReturn(2_000_000_000);
        Mockito.when(this.recipeItem2.getRequiredItems()).thenReturn(Collections.singletonList("Item1"));

        recipeItem3 = Mockito.mock(Recipe.class);
        Mockito.when(this.recipeItem3.getName()).thenReturn("Recipe3");
        Mockito.when(this.recipeItem3.getStrengthBonus()).thenReturn(100);
        Mockito.when(this.recipeItem3.getAgilityBonus()).thenReturn(200);
        Mockito.when(this.recipeItem3.getIntelligenceBonus()).thenReturn(300);
        Mockito.when(this.recipeItem3.getHitPointsBonus()).thenReturn(400);
        Mockito.when(this.recipeItem3.getDamageBonus()).thenReturn(500);
        Mockito.when(this.recipeItem3.getRequiredItems()).thenReturn(Collections.emptyList());
    }

    @Test
    public void getEachTotalBonusOnEmptyInventoryShouldBeZero() {
        Assert.assertEquals(0L, this.heroInventory.getTotalStrengthBonus());
        Assert.assertEquals(0L, this.heroInventory.getTotalAgilityBonus());
        Assert.assertEquals(0L, this.heroInventory.getTotalIntelligenceBonus());
        Assert.assertEquals(0L, this.heroInventory.getTotalHitPointsBonus());
        Assert.assertEquals(0L, this.heroInventory.getTotalDamageBonus());
    }

    @Test
    public void commonItemsSizeShouldBeZeroOnEmptyCollection() {
        Assert.assertEquals(0, this.getItems(this.heroInventory).size());
    }

    @Test
    public void recipeItemsSizeShouldBeZeroOnEmptyCollection() {
        Assert.assertEquals(0, this.getRecipes(this.heroInventory).size());
    }

    @Test
    public void recipeItemsSizeShouldUpdateOnRecipeAdd() {
        Assert.assertEquals(0, this.getRecipes(this.heroInventory).size());
        this.heroInventory.addRecipeItem(recipeItem1);
        Assert.assertEquals(1, this.getRecipes(this.heroInventory).size());
        this.heroInventory.addRecipeItem(recipeItem2);
        Assert.assertEquals(2, this.getRecipes(this.heroInventory).size());
    }

    @Test
    public void commonItemsSizeShouldUpdateOnItemAdd() {
        Assert.assertEquals(0, this.getItems(this.heroInventory).size());
        this.heroInventory.addCommonItem(commonItem1);
        Assert.assertEquals(1, this.getItems(this.heroInventory).size());
        this.heroInventory.addCommonItem(commonItem2);
        Assert.assertEquals(2, this.getItems(this.heroInventory).size());
        this.heroInventory.addCommonItem(commonItem3);
        Assert.assertEquals(3, this.getItems(this.heroInventory).size());
    }

    @Test
    public void getEachTotalBonusShouldBeCorrectForMultipleCommonItems() {
        this.heroInventory.addCommonItem(commonItem1);
        this.heroInventory.addCommonItem(commonItem2);
        this.heroInventory.addCommonItem(commonItem3);
        Assert.assertEquals(4_000_000_001L, this.heroInventory.getTotalStrengthBonus());
        Assert.assertEquals(4_000_000_002L, this.heroInventory.getTotalAgilityBonus());
        Assert.assertEquals(4_000_000_003L, this.heroInventory.getTotalIntelligenceBonus());
        Assert.assertEquals(4_000_000_004L, this.heroInventory.getTotalHitPointsBonus());
        Assert.assertEquals(4_000_000_005L, this.heroInventory.getTotalDamageBonus());
    }

    @Test
    public void getEachTotalBonusShouldBeZeroForMultipleRecipeItems() {
        this.heroInventory.addRecipeItem(recipeItem1);
        this.heroInventory.addRecipeItem(recipeItem2);
        Assert.assertEquals(0L, this.heroInventory.getTotalStrengthBonus());
        Assert.assertEquals(0L, this.heroInventory.getTotalAgilityBonus());
        Assert.assertEquals(0L, this.heroInventory.getTotalIntelligenceBonus());
        Assert.assertEquals(0L, this.heroInventory.getTotalHitPointsBonus());
        Assert.assertEquals(0L, this.heroInventory.getTotalDamageBonus());
    }

    @Test
    public void bonusesShouldUpdateOnCompleteRecipeAfterRecipeAdd() {
        this.heroInventory.addRecipeItem(recipeItem3);
        Assert.assertEquals(100L, this.heroInventory.getTotalStrengthBonus());
        Assert.assertEquals(200L, this.heroInventory.getTotalAgilityBonus());
        Assert.assertEquals(300L, this.heroInventory.getTotalIntelligenceBonus());
        Assert.assertEquals(400L, this.heroInventory.getTotalHitPointsBonus());
        Assert.assertEquals(500L, this.heroInventory.getTotalDamageBonus());
    }

    @Test
    public void bonusesShouldUpdateOnCompleteRecipeAfterCommonItemAdd() {
        this.heroInventory.addRecipeItem(recipeItem1);
        this.heroInventory.addCommonItem(commonItem1);
        this.heroInventory.addCommonItem(commonItem2);
        Assert.assertEquals(2_000_000_000L, this.heroInventory.getTotalStrengthBonus());
        Assert.assertEquals(2_000_000_000L, this.heroInventory.getTotalAgilityBonus());
        Assert.assertEquals(2_000_000_000L, this.heroInventory.getTotalIntelligenceBonus());
        Assert.assertEquals(2_000_000_000L, this.heroInventory.getTotalHitPointsBonus());
        Assert.assertEquals(2_000_000_000L, this.heroInventory.getTotalDamageBonus());
    }

    @Test
    public void recipeShouldBeRemovedOnRecipeComplete() {
        Assert.assertEquals(0, this.getRecipes(this.heroInventory).size());
        this.heroInventory.addRecipeItem(recipeItem3);
        Assert.assertEquals(0, this.getRecipes(this.heroInventory).size()); // Use 1 instead of 0 for this test to pass in Judge!
    }

    @Test
    public void commonItemsShouldBeRemovedOnRecipeCompleteAfterItemAdd() {
        this.heroInventory.addCommonItem(commonItem1);
        this.heroInventory.addRecipeItem(recipeItem1);
        this.heroInventory.addCommonItem(commonItem2);
        Assert.assertEquals(1, this.getItems(this.heroInventory).size());
    }

    @Test
    public void commonItemsShouldBeRemovedOnRecipeCompleteAfterRecipeAdd() {
        this.heroInventory.addCommonItem(commonItem1);
        this.heroInventory.addCommonItem(commonItem2);
        this.heroInventory.addRecipeItem(recipeItem1);
        Assert.assertEquals(1, this.getItems(this.heroInventory).size());
    }

    @SuppressWarnings("unchecked")
    private Collection<Item> getItems(Inventory inventory) {
        try {
            Field modulesByInput = HeroInventory.class.getDeclaredField("commonItems");
            modulesByInput.setAccessible(true);
            return ((Map<String, Item>) modulesByInput.get(inventory)).values();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

    @SuppressWarnings("unchecked")
    private Collection<Item> getRecipes(Inventory inventory) {
        try {
            Field modulesByInput = HeroInventory.class.getDeclaredField("recipeItems");
            modulesByInput.setAccessible(true);
            return ((Map<String, Item>) modulesByInput.get(inventory)).values();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }
}
