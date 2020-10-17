import java.util.Scanner;

public class Task03SumNumbers {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("First integer number is: ");
		int firstNumber = scanner.nextInt();
		
		System.out.print("Second integer number is: ");
		int secondNumber = scanner.nextInt();
		
		long sum = firstNumber + secondNumber;
		
		System.out.printf("[%d] is %spositive number%n", sum, (sum < 0L) ? "not " : "");
		
		scanner.close();
	}
}
