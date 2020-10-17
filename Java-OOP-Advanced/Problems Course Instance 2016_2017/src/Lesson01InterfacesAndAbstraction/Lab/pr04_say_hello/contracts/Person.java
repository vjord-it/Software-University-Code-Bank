package Lesson01InterfacesAndAbstraction.Lab.pr04_say_hello.contracts;

public interface Person {

    String getName();

    default String sayHello() {
        return "Hello";
    }
}
