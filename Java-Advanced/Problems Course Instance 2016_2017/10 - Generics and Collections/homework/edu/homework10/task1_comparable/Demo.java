package edu.homework10.task1_comparable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Demo {

	public static void main(String[] args) {
		Person p1 = new Person("A", "A", 0L);
		Person p2 = new Person("B", "A", 0L);
		Person p3 = new Person("A", "B", 0L);
		Person p4 = new Person("A", "A", 1L);
		Person p5 = new Person("B", "B", 0L);

		System.out.println("Sorted with priority queue:");
		Queue<Person> prio = new PriorityQueue<>();
		prio.add(p5);
		prio.add(p4);
		prio.add(p1);
		prio.add(p3);
		prio.add(p2);

		while (!prio.isEmpty()) {
			System.out.println(prio.poll());
		}
		System.out.println();
		System.out.println("------------------");
		System.out.println("Unsorted list:");
		List<Person> list = new ArrayList<>(5);
		list.add(p5);
		list.add(p4);
		list.add(p1);
		list.add(p3);
		list.add(p2);

		for (Person person : list) {
			System.out.println(person);
		}

		System.out.println();
		System.out.println("Sorted list:");
		Collections.sort(list);
		for (Person person : list) {
			System.out.println(person);
		}

		System.out.println();
		System.out.println("------------------");
		System.out.println("Unsorted array:");
		Person[] arr = new Person[5];
		arr[0] = p5;
		arr[1] = p3;
		arr[2] = p1;
		arr[3] = p4;
		arr[4] = p2;

		for (int i = 0; i < 5; i++) {
			System.out.println(arr[i]);
		}

		System.out.println();
		System.out.println("Sorted array:");
		Arrays.sort(arr);

		for (int i = 0; i < 5; i++) {
			System.out.println(arr[i]);
		}
	}

}
