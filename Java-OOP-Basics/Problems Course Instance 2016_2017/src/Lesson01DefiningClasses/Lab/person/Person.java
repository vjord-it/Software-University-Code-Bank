package Lesson01DefiningClasses.Lab.person;

import java.util.ArrayList;
import java.util.List;

class Person {

    private String name;
    private int age;
    private List<BankAccount> accounts;

    Person(String name, int age, List<BankAccount> accounts) {
        super();
        this.name = name;
        this.age = age;
        this.accounts = accounts;
    }

    Person(String name, int age) {
        this(name, age, new ArrayList<>());
    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }

    double getBalance() {
        return this.accounts.stream()
                .mapToDouble(BankAccount::getBalance)
                .sum();
    }
}
