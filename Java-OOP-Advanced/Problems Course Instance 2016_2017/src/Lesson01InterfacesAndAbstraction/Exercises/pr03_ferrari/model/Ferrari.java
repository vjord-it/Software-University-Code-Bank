package Lesson01InterfacesAndAbstraction.Exercises.pr03_ferrari.model;


import Lesson01InterfacesAndAbstraction.Exercises.pr03_ferrari.constants.Constants;

public class Ferrari extends AbstractCar {

    public Ferrari(String driver) {
        super(Constants.FERRARI_MODEL, driver);
    }
}
