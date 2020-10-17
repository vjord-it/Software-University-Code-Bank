package edu.pragmatic;

public class Square {

	private int side;
	
	public Square(int side) {
		this.side = side;
	}
	
	public int getSide() {
		return side;
	}
	
	public int calculateArea() {
		return side * side;
	}
	
	@Override
	public String toString() {
		return "Square(" + side + ")";
	}
	
}
