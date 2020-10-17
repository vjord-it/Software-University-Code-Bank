package ExamPanzerBattles.panzer.models.parts;

import ExamPanzerBattles.panzer.contracts.Part;

import java.math.BigDecimal;

public abstract class BasePart implements Part {

    private final String model;
    private final double weight;
    private final BigDecimal price;

    protected BasePart(String model, double weight, BigDecimal price) {
        this.model = model;
        this.weight = weight;
        this.price = price;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public BigDecimal getPrice() {
        return this.price;
    }

    @Override
    public String getModel() {
        return this.model;
    }
}
