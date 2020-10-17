package Lesson04Polymorphism.Lab.pr01_overload_method;

public class MathOperation {

    public long add(int a, int b) {
        return a + b;
    }

    public long add(int a, int b, int c) {
        return a + b + c;
    }

    public long add(int a, int b, int c, int d) {
        return a + b + c + d;
    }

    public long add(Integer... numbers) {
        long result = 0;
        for (Integer number : numbers) {
            result += number;
        }
        return result;
    }
}
