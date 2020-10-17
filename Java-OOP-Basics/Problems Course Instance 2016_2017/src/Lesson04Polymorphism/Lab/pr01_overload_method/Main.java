package Lesson04Polymorphism.Lab.pr01_overload_method;

public class Main {

    public static void main(String[] args) {
        MathOperation math = new MathOperation();
        System.out.println(math.add(2, 2));
        System.out.println(math.add(3, 3, 3));
        System.out.println(math.add(4, 4, 4, 4));
        System.out.println(math.add(5, 5, 5, 5, 5));
        System.out.println(math.add(6, 6, 6, 6, 6, 6));
    }
}
