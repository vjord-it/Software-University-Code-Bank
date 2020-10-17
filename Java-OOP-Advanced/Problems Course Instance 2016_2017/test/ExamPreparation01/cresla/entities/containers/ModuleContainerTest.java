package ExamPreparation01.cresla.entities.containers;

import ExamPreparation01.cresla.interfaces.AbsorbingModule;
import ExamPreparation01.cresla.interfaces.Container;
import ExamPreparation01.cresla.interfaces.EnergyModule;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ModuleContainerTest {

    private EnergyModule energyModule1;
    private EnergyModule energyModule2;
    private AbsorbingModule absorbingModule1;
    private AbsorbingModule absorbingModule2;
    private Container container;

    @Before
    public void setUp() {
        this.container = new ModuleContainer(3);
        this.energyModule1 = Mockito.mock(EnergyModule.class);
        this.energyModule2 = Mockito.mock(EnergyModule.class);
        this.absorbingModule1 = Mockito.mock(AbsorbingModule.class);
        this.absorbingModule2 = Mockito.mock(AbsorbingModule.class);

        Mockito.when(this.energyModule1.getId()).thenReturn(1);
        Mockito.when(this.energyModule2.getId()).thenReturn(2);
        Mockito.when(this.absorbingModule1.getId()).thenReturn(3);
        Mockito.when(this.absorbingModule2.getId()).thenReturn(4);

        Mockito.when(this.energyModule1.getEnergyOutput()).thenReturn(2_000_000_000);
        Mockito.when(this.energyModule2.getEnergyOutput()).thenReturn(2_000_000_000);
        Mockito.when(this.absorbingModule1.getHeatAbsorbing()).thenReturn(2_000_000_000);
        Mockito.when(this.absorbingModule2.getHeatAbsorbing()).thenReturn(2_000_000_000);
    }

    @Test
    public void getTotalEnergyOutputShouldReturnZero() {
        Assert.assertEquals(0L, this.container.getTotalEnergyOutput());

    }

    @Test
    public void getTotalHeatAbsorbingShouldReturnZero() {
        Assert.assertEquals(0L, this.container.getTotalHeatAbsorbing());

    }

    @Test
    public void getTotalEnergyOutputShouldReturnCorrectValue() {
        this.container.addEnergyModule(energyModule1);
        this.container.addEnergyModule(energyModule2);
        Assert.assertEquals(4_000_000_000L, this.container.getTotalEnergyOutput());
    }

    @Test
    public void getTotalHeatAbsorbingShouldReturnCorrectValue() {
        this.container.addAbsorbingModule(absorbingModule1);
        this.container.addAbsorbingModule(absorbingModule2);
        Assert.assertEquals(4_000_000_000L, this.container.getTotalHeatAbsorbing());
    }

    @Test
    public void removeFirstAbsorbingModuleOnTooManyModules() {
        this.container.addAbsorbingModule(absorbingModule1);
        this.container.addAbsorbingModule(absorbingModule2);
        this.container.addEnergyModule(energyModule1);
        this.container.addEnergyModule(energyModule2);
        Assert.assertEquals(4_000_000_000L, this.container.getTotalEnergyOutput());
        Assert.assertEquals(2_000_000_000L, this.container.getTotalHeatAbsorbing());
    }

    @Test
    public void removeFirstEnergyModuleOnTooManyModules() {
        this.container.addEnergyModule(energyModule1);
        this.container.addEnergyModule(energyModule2);
        this.container.addAbsorbingModule(absorbingModule1);
        this.container.addAbsorbingModule(absorbingModule2);
        Assert.assertEquals(2_000_000_000L, this.container.getTotalEnergyOutput());
        Assert.assertEquals(4_000_000_000L, this.container.getTotalHeatAbsorbing());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addNullEnergyModuleShouldFail() {
        this.container.addEnergyModule(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addNullAbsorbingModuleShouldFail() {
        this.container.addAbsorbingModule(null);
    }
}
