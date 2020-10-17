import java.util.Scanner;

public class Task02PrimitivesExample {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		byteDemo(scanner);
		
		shortDemo(scanner);
		
		intDemo(scanner);
		
		longDemo(scanner);
		
		floatDemo(scanner);
		
		doubleDemo(scanner);
		
		charDemo();
		
		booleanDemo();
	}

	private static void byteDemo(Scanner scanner) {
		byte byteMin = Byte.MIN_VALUE;
		byte byteMax = Byte.MAX_VALUE;
		
		final String promptMessage = String.format("Enter number of byte type [%d, %d]: ", byteMin, byteMax);
		
		System.out.printf(promptMessage);
		
		while (!scanner.hasNextByte()) {
			System.out.printf("Error - invalid value [%s]%n", scanner.nextLine().trim());
			System.out.printf(promptMessage);
		}
		
		byte myByte = Byte.parseByte(scanner.nextLine().trim());
		
		System.out.printf("Success! Your number is %d%n", myByte);
	}

	private static void shortDemo(Scanner scanner) {
		short shortMin = Short.MIN_VALUE;
		short shortMax = Short.MAX_VALUE;
		
		final String promptMessage = String.format("Enter number of short type [%d, %d]: ", shortMin, shortMax);

		System.out.printf(promptMessage);
		
		while (!scanner.hasNextShort()) {
			System.out.printf("Error - invalid value [%s]%n", scanner.nextLine().trim());
			System.out.printf(promptMessage);
		}
		
		short myShort = Short.parseShort(scanner.nextLine().trim());
		
		System.out.printf("Success! Your number is %d%n", myShort);
	}
	

	private static void intDemo(Scanner scanner) {
		int intMin = Integer.MIN_VALUE;
		int intMax = Integer.MAX_VALUE;
		
		final String promptMessage = String.format("Enter number of int type [%d, %d]: ", intMin, intMax);

		System.out.printf(promptMessage);
		
		while (!scanner.hasNextInt()) {
			System.out.printf("Error - invalid value [%s]%n", scanner.nextLine().trim());
			System.out.printf(promptMessage);
		}
		
		int myInt = Integer.parseInt(scanner.nextLine().trim());
		
		System.out.printf("Success! Your number is %d%n", myInt);
	}
	
	private static void longDemo(Scanner scanner) {
		long longMin = Long.MIN_VALUE;
		long longMax = Long.MAX_VALUE;
		
		final String promptMessage = String.format("Enter number of long type [%d, %d]: ", longMin, longMax);

		System.out.printf(promptMessage);
		
		while (!scanner.hasNextLong()) {
			System.out.printf("Error - invalid value [%s]%n", scanner.nextLine().trim());
			System.out.printf(promptMessage);
		}
		
		long myLong = Long.parseLong(scanner.nextLine().trim());
		
		System.out.printf("Success! Your number is %d%n", myLong);
	}
	
	private static void floatDemo(Scanner scanner) {
		float floatMin = -Float.MAX_VALUE;
		float floatMax = Float.MAX_VALUE;
		float floatMinNormal = Float.MIN_NORMAL;
		
		System.out.printf("Float min normal = %f%n", floatMinNormal);
		
		final String promptMessage = String.format("Enter number of float type [%f, %f]: ", floatMin, floatMax);

		System.out.printf(promptMessage);
		
		while (!scanner.hasNextFloat()) {
			System.out.printf("Error - invalid value [%s]%n", scanner.nextLine().trim());
			System.out.printf(promptMessage);
		}
		
		float myFloat = Float.parseFloat(scanner.nextLine().trim());
		
		System.out.printf("Success! Your number is %.100f%n", myFloat);
	}
	
	private static void doubleDemo(Scanner scanner) {
		double doubleMin = -Double.MAX_VALUE;
		double doubleMax = Double.MAX_VALUE;
		double doubleMinNormal = Double.MIN_NORMAL;
		
		System.out.printf("Double min normal = %f%n", doubleMinNormal);
		
		final String promptMessage = String.format("Enter number of double type [%f, %f]: ", doubleMin, doubleMax);

		System.out.printf(promptMessage);
		
		while (!scanner.hasNextDouble()) {
			System.out.printf("Error - invalid value [%s]%n", scanner.nextLine().trim());
			System.out.printf(promptMessage);
		}
		
		double myDouble = Double.parseDouble(scanner.nextLine().trim());
		
		System.out.printf("Success! Your number is %.100f%n", myDouble);
	}
	
	private static void charDemo() {
		char charOne = '1';
		char charTwo = 'щ';
		char charThree = '\u5679';
		
		System.out.printf("First character is '%c'%n", charOne);
		System.out.printf("Second character is '%c'%n", charTwo);
		System.out.printf("Third character is '%c'%n", charThree);
	}
	
	private static void booleanDemo() {
		boolean boolTrue = Boolean.TRUE;
		boolean boolAnotherTrue = true;
		boolean boolFalse = (1 < -1);

		System.out.printf("First boolean is '%s'%n", boolTrue);
		System.out.printf("Second boolean is '%s'%n", boolAnotherTrue);
		System.out.printf("Third boolean is '%s'%n", boolFalse);
	}
}
