package edu.pragmatic;

public class Demo {

	public static void main(String[] args) {
		
		BoxObject b1 = new BoxObject();
		b1.setObject("hello");
		
		//b1.setObject(40);
		//////
		
		int length = ((String)b1.getObject()).length();
		System.out.println(length);
		
		
		Box<String> b2 = new Box<String>();
		Box<Integer> b3 = new Box<Integer>();
		
		b2.setObject("hello");
		
		
		//b2.setObject(3242423);
		/////
		
		
		System.out.println(b2.getObject().length());
		
		
		b3.setObject(30);
		Integer i = b3.getObject();
		System.out.println(i);
		
		f(b3);
		
//		Box<Object> b5 = new Box<>();
//		f(b5);
	}
	
	private static void f(Box<? extends Number> b) {
		System.out.println(b.getObject().doubleValue());
	}
}
