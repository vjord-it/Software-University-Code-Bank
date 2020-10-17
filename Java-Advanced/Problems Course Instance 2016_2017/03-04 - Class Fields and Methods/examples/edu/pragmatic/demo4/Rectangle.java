package edu.pragmatic.demo4;

public class Rectangle {

	private double width;
	private double height;

	Rectangle() { 
	}
	
	Rectangle(double side) {
		// 1
//		setWidth(side);
//		setHeight(side);
		
		// 2
		// resize(side, side);
		
		// 3
		//resize(side);
		
		// 4 (izvikvane na drug konstruktor)
		//Rectangle(side, side);		
		this(side, side);		
	}
	
	Rectangle(double width, double height) {
		resize(width, height);		
	}
	
	void setWidth(double width) {				
		if(width >= 0) {
			this.width = width;
		}
	}
	
	public double getWidth() {
		return width;
	}

	void setHeight(double height) {
		if(height >= 0) {
			this.height = height;
		}
	}
	
	public double getHeight() {
		return height;
	}
	
	void resize(double width, double height) {
		setWidth(width);
		setHeight(height);
	}
	
	void resize(double side) {
//		setWidth(side);
//		setHeight(side);
		resize(side, side);
	}
	
	double calculateArea() {
		double area = width * height;
		
		return area;		
	}
	
	double getLongestSide() {
//		if(width > height) {
//			return width;
//		} else {
//			return height;
//		}
		
//		return (width > height ? width : height);
		
		if(width > height) {
			return width;
		}
		
		return height;
	}
} 
