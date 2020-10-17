package Lesson02Encapsulation.Exercise.pr05_pizza_calories;

class Dough extends BaseComponent {

    private static final String INVALID_TYPE_TEXT = "Invalid type of dough.";
    private static final String INVALID_WEIGHT_TEXT = "Dough weight should be in the range [1..200].";
    private static final double MIN_WEIGHT = 1.0;
    private static final double MAX_WEIGHT = 200.0;

    private Flour flour;
    private Technique technique;

    Dough(String flour, String technique, double weight) {
        super();
        this.setFlour(flour);
        this.setTechnique(technique);
        this.setWeight(weight);
        this.setCalories();
    }

    private void setFlour(String flour) {
        if (flour == null) {
            throw new IllegalArgumentException(INVALID_TYPE_TEXT);
        }
        switch (flour.trim().toLowerCase()) {
        case "white":
            this.flour = Flour.WHITE;
            break;
        case "wholegrain":
            this.flour = Flour.WHOLEGRAIN;
            break;
        default:
            throw new IllegalArgumentException(INVALID_TYPE_TEXT);
        }
    }

    private void setTechnique(String technique) {
        if (technique == null) {
            throw new IllegalArgumentException(INVALID_TYPE_TEXT);
        }
        switch (technique.trim().toLowerCase()) {
        case "crispy":
            this.technique = Technique.CRISPY;
            break;
        case "chewy":
            this.technique = Technique.CHEWY;
            break;
        case "homemade":
            this.technique = Technique.HOMEMADE;
            break;
        default:
            throw new IllegalArgumentException(INVALID_TYPE_TEXT);
        }
    }

    private void setWeight(double weight) {
        if (weight < MIN_WEIGHT || weight > MAX_WEIGHT) {
            throw new IllegalArgumentException(INVALID_WEIGHT_TEXT);
        }
        this.weight = weight;
    }

    private void setCalories() {
        this.calories = this.weight * this.flour.caloriesModifier() * this.technique.caloriesModifier();
    }

    private enum Flour {
        WHITE {
            @Override
            public double caloriesModifier() {
                return 1.5;
            }
        },
        WHOLEGRAIN {
            @Override
            public double caloriesModifier() {
                return 1.0;
            }
        };

        public abstract double caloriesModifier();
    }

    private enum Technique {
        CRISPY {
            @Override
            public double caloriesModifier() {
                return 0.9;
            }
        },
        CHEWY {
            @Override
            public double caloriesModifier() {
                return 1.1;
            }
        },
        HOMEMADE {
            @Override
            public double caloriesModifier() {
                return 1.0;
            }
        };

        public abstract double caloriesModifier();
    }
}