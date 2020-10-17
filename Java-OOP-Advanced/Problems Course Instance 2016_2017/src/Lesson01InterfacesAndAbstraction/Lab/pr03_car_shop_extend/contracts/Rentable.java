package Lesson01InterfacesAndAbstraction.Lab.pr03_car_shop_extend.contracts;

public interface Rentable extends Car {

    int getMinRentDay();

    Double getPricePerDay();

}
