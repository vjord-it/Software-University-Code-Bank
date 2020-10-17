package ExamPanzerBattles.panzer.models.miscellaneous;

import ExamPanzerBattles.panzer.contracts.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.List;

public class VehicleAssemblerTest {

    private Assembler assembler;
    private AttackModifyingPart attackPart;
    private DefenseModifyingPart defensePart;
    private HitPointsModifyingPart endurancePart;

    @Before
    public void setUp() {
        this.assembler = new VehicleAssembler();

        this.attackPart = Mockito.mock(AttackModifyingPart.class);
        this.defensePart = Mockito.mock(DefenseModifyingPart.class);
        this.endurancePart = Mockito.mock(HitPointsModifyingPart.class);
    }

    @Test
    public void attackerPartShouldIncreaseAttack() {
        Mockito.when(this.attackPart.getAttackModifier()).thenReturn(Integer.MAX_VALUE);

        this.assembler.addArsenalPart(this.attackPart);
        this.assembler.addArsenalPart(this.attackPart);

        Assert.assertEquals(this.assembler.getTotalAttackModification(), 2L * Integer.MAX_VALUE);
    }

    @Test
    public void defensePartShouldIncreaseDefense() {
        Mockito.when(this.defensePart.getDefenseModifier()).thenReturn(Integer.MAX_VALUE);

        this.assembler.addShellPart(this.defensePart);
        this.assembler.addShellPart(this.defensePart);

        Assert.assertEquals(this.assembler.getTotalDefenseModification(), 2L * Integer.MAX_VALUE);
    }

    @Test
    public void hitPointsPartShouldIncreaseHitPoints() {
        Mockito.when(this.endurancePart.getHitPointsModifier()).thenReturn(Integer.MAX_VALUE);

        this.assembler.addEndurancePart(this.endurancePart);
        this.assembler.addEndurancePart(this.endurancePart);

        Assert.assertEquals(this.assembler.getTotalHitPointModification(), 2L * Integer.MAX_VALUE);
    }

    @Test
    public void priceShouldAccountForAllPartTypes() {
        Mockito.when(this.attackPart.getPrice()).thenReturn(new BigDecimal(10));
        Mockito.when(this.defensePart.getPrice()).thenReturn(new BigDecimal(100));
        Mockito.when(this.endurancePart.getPrice()).thenReturn(new BigDecimal(1000));

        this.assembler.addArsenalPart(this.attackPart);
        this.assembler.addShellPart(this.defensePart);
        this.assembler.addEndurancePart(this.endurancePart);

        Assert.assertTrue(this.assembler.getTotalPrice().equals(new BigDecimal(10 + 100 + 1000)));
    }

    @Test
    public void weightShouldAccountForAllPartTypes() {
        Mockito.when(this.attackPart.getWeight()).thenReturn(1.0);
        Mockito.when(this.defensePart.getWeight()).thenReturn(10.0);
        Mockito.when(this.endurancePart.getWeight()).thenReturn(100.0);

        this.assembler.addArsenalPart(this.attackPart);
        this.assembler.addShellPart(this.defensePart);
        this.assembler.addEndurancePart(this.endurancePart);

        Assert.assertEquals(this.assembler.getTotalWeight(), 111.0, Double.MIN_VALUE);
    }


    @Test
    public void addingArsenalPartShouldIncreaseSize() {
        this.assembler.addArsenalPart(this.attackPart);
        int size = getListSize("arsenalParts");

        Assert.assertEquals(size, 1);
    }

    @Test
    public void addingShellPartShouldIncreaseSize() {
        this.assembler.addShellPart(this.defensePart);
        int size = getListSize("shellParts");

        Assert.assertEquals(size, 1);
    }

    @Test
    public void addingEndurancePartShouldIncreaseSize() {
        this.assembler.addEndurancePart(this.endurancePart);
        int size = getListSize("enduranceParts");

        Assert.assertEquals(size, 1);
    }

    @SuppressWarnings("unchecked")
    private int getListSize(String partsList) {
        int size = 0;
        try {
            Field allParts = VehicleAssembler.class.getDeclaredField(partsList);
            allParts.setAccessible(true);
            size = ((List<Part>) allParts.get(this.assembler)).size();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return size;
    }
}
