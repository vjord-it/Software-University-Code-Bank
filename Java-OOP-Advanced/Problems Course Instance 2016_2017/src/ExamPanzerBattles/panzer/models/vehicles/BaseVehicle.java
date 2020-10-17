package ExamPanzerBattles.panzer.models.vehicles;

import ExamPanzerBattles.panzer.constants.Messages;
import ExamPanzerBattles.panzer.contracts.Assembler;
import ExamPanzerBattles.panzer.contracts.Modelable;
import ExamPanzerBattles.panzer.contracts.Part;
import ExamPanzerBattles.panzer.contracts.Vehicle;
import ExamPanzerBattles.panzer.models.miscellaneous.VehicleAssembler;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseVehicle implements Vehicle {

    private final String model;
    private final double weight;
    private final BigDecimal price;
    private final long attack;
    private final long defense;
    private final long hitPoints;
    private final Assembler assembler;

    protected BaseVehicle(String model, double weight, BigDecimal price,
                          long attack, long defense, long hitPoints) {
        this.model = model;
        this.weight = weight;
        this.price = price;
        this.attack = attack;
        this.defense = defense;
        this.hitPoints = hitPoints;
        this.assembler = new VehicleAssembler(); //TODO - Dependency Injection or Factory
    }

    protected double getPriceModifier() {
        return 1.0;
    }

    protected double getWeightModifier() {
        return 1.0;
    }

    protected double getAttackModifier() {
        return 1.0;
    }

    protected double getDefenseModifier() {
        return 1.0;
    }

    protected double getHitPointsModifier() {
        return 1.0;
    }

    protected abstract String getType();

    @Override
    public double getTotalWeight() {
        return this.weight * this.getWeightModifier() + this.assembler.getTotalWeight();
    }

    @Override
    public BigDecimal getTotalPrice() {
        return this.price
                .multiply(BigDecimal.valueOf(this.getPriceModifier()))
                .add(this.assembler.getTotalPrice());
    }

    @Override
    public long getTotalAttack() {
        return (long) (this.attack * this.getAttackModifier()) + this.assembler.getTotalAttackModification();
    }

    @Override
    public long getTotalDefense() {
        return (long) (this.defense * this.getDefenseModifier()) + this.assembler.getTotalDefenseModification();
    }

    @Override
    public long getTotalHitPoints() {
        return (long) (this.hitPoints * this.getHitPointsModifier()) + this.assembler.getTotalHitPointModification();
    }

    @Override
    public void addArsenalPart(Part arsenalPart) {
        this.assembler.addArsenalPart(arsenalPart);
    }

    @Override
    public void addShellPart(Part shellPart) {
        this.assembler.addShellPart(shellPart);
    }

    @Override
    public void addEndurancePart(Part endurancePart) {
        this.assembler.addEndurancePart(endurancePart);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterable<Part> getParts() {
        try {
            Field allParts = VehicleAssembler.class.getDeclaredField("allParts");
            allParts.setAccessible(true);
            return (List<Part>) allParts.get(this.assembler);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String toString() {

        List<Part> partsList = new ArrayList<>();
        getParts().forEach(partsList::add);

        return String.format(Messages.VEHICLES_FORMAT,
                this.getType(), this.model, this.getTotalWeight(),
                this.getTotalPrice(), this.getTotalAttack(),
                this.getTotalDefense(), this.getTotalHitPoints(),
                partsList.isEmpty() ? Messages.NONE :
                        partsList.stream().map(Modelable::getModel).collect(Collectors.joining(", ")));

    }
}
