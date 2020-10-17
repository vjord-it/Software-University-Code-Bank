package Lesson01InterfacesAndAbstraction.Lab.pr03_car_shop_extend;

import Lesson01InterfacesAndAbstraction.Lab.pr03_car_shop_extend.contracts.Car;
import Lesson01InterfacesAndAbstraction.Lab.pr03_car_shop_extend.contracts.Rentable;
import Lesson01InterfacesAndAbstraction.Lab.pr03_car_shop_extend.contracts.Sellable;
import Lesson01InterfacesAndAbstraction.Lab.pr03_car_shop_extend.model.Audi;
import Lesson01InterfacesAndAbstraction.Lab.pr03_car_shop_extend.model.Seat;

public class Main {


    public static void main(String[] args) {
        Sellable seat = new Seat("Leon", "Gray", 110, "Spain", 11111.1);
        Rentable audi = new Audi("Leon", "Gray", 110, "Spain", 3, 99.9);

        printCarInfo(seat);
        printCarInfo(audi);
    }

    private static void printCarInfo(Car car) {
        System.out.println(String.format(
                "%s is %s color and have %s horse power",
                car.getModel(),
                car.getColor(),
                car.getHorsePower()));
        System.out.println(car.toString());
    }
}
