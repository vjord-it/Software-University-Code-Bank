package task02_04;

public class Person {

	private String name;
	private double height;

	public Person(String name, double height) {
		this.name = name;
		this.height = height;
	}

	public String getName() {
		return this.name;
	}

	public double getHeight() {
		return this.height;
	}

	public String getInfo() {
		return this.name + " (" + this.height + "cm)";
	}
}