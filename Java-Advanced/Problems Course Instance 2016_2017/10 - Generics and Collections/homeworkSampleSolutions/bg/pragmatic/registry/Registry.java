package bg.pragmatic.registry;

import java.util.*;

public class Registry<T> {

	private String name;
	private int maxNumberOfElements;
	private List<T> elements;
	
	public Registry(String name, int maxElementsNumber) {
		this.maxNumberOfElements = maxElementsNumber;
		elements = new LinkedList<>();
		this.name = name;
	}
	
	public boolean addElement(T element) {
		if(elements.size() < maxNumberOfElements) 
			return elements.add(element);
		
		return false;
	}
	
	public boolean removeElement(T element) {
		return elements.remove(element);
	}

	public String getName() {
		return name;
	}
	
	public int size() {
		return this.elements.size();
	}
	
	public Object[] getElementsArray() {
		return elements.toArray();
	}
}
