import java.util.Scanner;

public class Task01PrintYouName {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("What is your name: ");
		
		String name = scanner.nextLine().trim();
		
		System.out.printf("Hello, %s!%n", name);
		
		scanner.close();
	}

}
