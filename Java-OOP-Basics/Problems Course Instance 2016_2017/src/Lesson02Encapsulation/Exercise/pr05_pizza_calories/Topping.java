package Lesson02Encapsulation.Exercise.pr05_pizza_calories;

class Topping extends BaseComponent {

    private static final String INVALID_TYPE_TEXT = "Cannot place %s on top of your pizza.";
    private static final String INVALID_WEIGHT_TEXT = "%s weight should be in the range [1..50].";
    private static final double MIN_WEIGHT = 1.0;
    private static final double MAX_WEIGHT = 50.0;

    private Type type;

    Topping(String type, double weight) {
        super();
        this.setType(type);
        this.setWeight(weight);
        this.setCalories();
    }

    private void setType(String topping) {
        if (topping == null) {
            throw new IllegalArgumentException(String.format(INVALID_TYPE_TEXT, (Object) null));
        }
        switch (topping.trim().toLowerCase()) {
        case "meat":
            this.type = Type.MEAT;
            break;
        case "veggies":
            this.type = Type.VEGGIES;
            break;
        case "cheese":
            this.type = Type.CHEESE;
            break;
        case "sauce":
            this.type = Type.SAUCE;
            break;
        default:
            throw new IllegalArgumentException(String.format(INVALID_TYPE_TEXT, topping));
        }
    }

    private void setWeight(double weight) {
        if (weight < MIN_WEIGHT || weight > MAX_WEIGHT) {
            throw new IllegalArgumentException(String.format(INVALID_WEIGHT_TEXT, this.type.getName()));
        }

        this.weight = weight;
    }

    private void setCalories() {
        this.calories = this.weight * this.type.caloriesModifier();
    }

    private enum Type {
        MEAT {
            @Override
            public double caloriesModifier() {
                return 1.2;
            }

            @Override
            public String getName() {
                return "Meat";
            }
        },
        VEGGIES {
            @Override
            public double caloriesModifier() {
                return 0.8;
            }

            @Override
            public String getName() {
                return "Veggies";
            }
        },
        CHEESE {
            @Override
            public double caloriesModifier() {
                return 1.1;
            }

            @Override
            public String getName() {
                return "Cheese";
            }
        },
        SAUCE {
            @Override
            public double caloriesModifier() {
                return 0.9;
            }

            @Override
            public String getName() {
                return "Sauce";
            }
        };

        public abstract double caloriesModifier();

        public abstract String getName();
    }
}