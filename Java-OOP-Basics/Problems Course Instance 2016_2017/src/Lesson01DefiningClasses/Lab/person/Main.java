package Lesson01DefiningClasses.Lab.person;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Person andy = new Person("Andy", 32);

        List<BankAccount> accounts = new ArrayList<>();
        accounts.add(new BankAccount(99.9));
        accounts.add(new BankAccount(100d));
        accounts.add(new BankAccount(1000d));

        Person ivan = new Person("Ivan", 37, accounts);

        System.out.printf("%s is %d years old and his balance is $%.2f%n", andy.getName(), andy.getAge(), andy.getBalance());
        System.out.printf("%s is %d years old and his balance is $%.2f%n", ivan.getName(), ivan.getAge(), ivan.getBalance());
    }
}
