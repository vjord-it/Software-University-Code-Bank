package edu.pragmatic;

public class Box<T> {

	private T data;
	
	public Box() {
		
	}
	
	public Box(T o) {
		data = o;
	}
	
	public void setObject(T o) {
		data = o;
	}
	
	public T getObject() {
		return data;
	}
}
