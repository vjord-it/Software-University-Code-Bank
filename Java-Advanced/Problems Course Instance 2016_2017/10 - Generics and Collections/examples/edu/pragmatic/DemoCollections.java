package edu.pragmatic;

import java.util.*;

public class DemoCollections {
	
	public static void main(String[] args) {
		
		List<Integer> l1 = new LinkedList<>();
		l1.add(45);
		l1.add(12);
		l1.add(8);
		l1.add(12);
		
		System.out.println(l1.size());
		
		System.out.println("sys for i get()");
		for(int i = 0; i < l1.size(); i++) {
			System.out.println(l1.get(i));
		}
		
		System.out.println("s iterator");
		Iterator<Integer> it = l1.iterator();
		while(it.hasNext()) {
			Integer element = it.next();
			System.out.println(element);
		}
		
		System.out.println("for each");
		for(Integer element : l1) {
			System.out.println(element);
		}
		
		List<Integer> l2 = new LinkedList<>();
		l2.add(10);
		l2.add(11);
		l2.add(2);
		l2.add(15);
		l2.add(18);
		l2.add(12);
		
		/* Kolekciite ne triabva da se promeniat, dokato se iterirat
		for(Integer element : l2) {
			if(element % 2 == 1) {
				l2.remove(element);
			}
		}
		*/
		
		Iterator<Integer> it2 = l2.iterator();
		while(it2.hasNext()) {
			Integer element = it2.next();
			if(element % 2 == 1) {
				it2.remove();
			}
		}
		
		System.out.println(l2);
		
		
		Set<Integer> s1 = new HashSet<>();
		s1.add(23);
		s1.add(11);
		s1.add(11);
		s1.add(9);
		s1.add(1);
		s1.add(4);
		
		for(Integer el : s1) {
			System.out.println(el);
		}
		
		System.out.println(s1);
		
		Set<Integer> s2 = new HashSet<>(l2); 
		System.out.println(s2);
		
		Map<Integer, String> m = new HashMap<>();
		m.put(123, "hello");
		m.put(13, "jjj");
		m.put(1, "b");
		
		System.out.println(m);
		
		m.put(13, "bbbb");
		
		System.out.println(m);
		
		System.out.println(m.get(1));
		System.out.println(m.get(11111));
	}
}
