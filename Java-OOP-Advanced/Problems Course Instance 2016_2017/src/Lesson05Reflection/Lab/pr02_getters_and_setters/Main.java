package Lesson05Reflection.Lab.pr02_getters_and_setters;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        Class<Reflection> aClass = Reflection.class;

        Method[] methods = aClass.getDeclaredMethods();

        Arrays.stream(methods)
                .filter(m -> m.getName().startsWith("get") && m.getParameterCount() == 0)
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> System.out.println(m.getName() + " will return " + m.getReturnType()));

        Arrays.stream(methods)
                .filter(m -> m.getName().startsWith("set") && m.getParameterCount() == 1)
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> System.out.println(m.getName() + " and will set field of " + m.getParameterTypes()[0]));
    }
}
