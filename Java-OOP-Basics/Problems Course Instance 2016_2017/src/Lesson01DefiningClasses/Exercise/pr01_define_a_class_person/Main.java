package Lesson01DefiningClasses.Exercise.pr01_define_a_class_person;

import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) throws Exception {
        Class person = Person.class;
        Field[] fields = person.getDeclaredFields();
        System.out.println(fields.length);
    }
}
