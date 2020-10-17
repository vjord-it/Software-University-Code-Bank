package edu.pragmatic.demo4;

public class Demo {

	public static void main(String[] args) {
		
		Rectangle r1 = new Rectangle();
		//r1.width = 3;
		//r1.height = 10;
//		r1.setWidth(3);
//		r1.setHeight(10);
		r1.resize(3, 10);
		
		double a1 = r1.getLongestSide();
		System.out.println(a1);
		System.out.println(r1.calculateArea());
//		if(r1.width > r1.height) {
//			System.out.println(r1.width);
//		} else {
//			System.out.println(r1.height);
//		}
		
		Rectangle r2 = new Rectangle();
//		r2.width = 9;
//		r2.height = 3;
//		r2.setWidth(9);
//		r2.setHeight(3);
		r2.resize(9, 3);
		
		double a2 = r2.getLongestSide();
		System.out.println(a2);
//		if(r2.width > r2.height) {
//			System.out.println(r2.width);
//		} else {
//			System.out.println(r2.height);
//		}
		
		Rectangle r3 = new Rectangle();
		//r3.resize(10, 10);
		r3.resize(10);
				
		Rectangle r4 = new Rectangle(3, 40);		
		System.out.println(r4.calculateArea());
		
		Rectangle r5 = new Rectangle(10);
		System.out.println(r5.calculateArea());
	}
}
