package Lesson03IteratorsAndComparators.Exercises.pr09_linked_list_traversal;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //demo();
        judge();
    }

    private static void judge() {
        LinkedList<Integer> myLinkedList = new LinkedListImpl<>();
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < lines; i++) {
            String line = scanner.nextLine();
            String[] parameters = line.split(" ");
            String command = parameters[0];
            int number = Integer.parseInt(parameters[1]);
            if (command.equals("Add")) {
                myLinkedList.add(number);
            } else if (command.equals("Remove")) {
                myLinkedList.remove(number);
            }
        }

        System.out.println(myLinkedList.getSize());
        for (Integer number : myLinkedList) {
            System.out.print(number + " ");
        }

        System.out.println();
    }

    private static void demo() {
        LinkedList<Integer> list = new LinkedListImpl<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(1);
        System.out.println(list);
        System.out.println(list.getSize());

        list.forEachReversed(System.out::print);
        System.out.println();

        list.remove(1);
        list.remove(1);
        list.remove(1);
        list.forEach(System.out::println);
        System.out.println(list);
        list.remove(2);
        list.remove(3);
        System.out.println(list);
        list.remove(4);
        list.remove(4);
        System.out.println(list);


        list.addAll(1, 2, 3, 345, -234);
        System.out.println(list);

        LinkedList<String> listStr = new LinkedListImpl<>("One", "Two", "Three");
        System.out.println(listStr.getSize());
        System.out.println(listStr);
        listStr.remove("Two");
        System.out.println(listStr.getSize());
        System.out.println(listStr);
    }
}
