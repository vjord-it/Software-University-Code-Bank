package Lesson01InterfacesAndAbstraction.Exercises.pr07_food_shortage.model;

public class Robot extends AbstractIdentable {

    private final String model;

    public Robot(String id, String model) {
        super(id);
        this.model = model;
    }
}
