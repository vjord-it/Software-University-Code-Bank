import java.util.Scanner;

public class Task06FindMinAndMaxNumbers {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int minNumber = Integer.MAX_VALUE;
		int maxNumber = Integer.MIN_VALUE;

		System.out.println("Enter 15 integer numbers");

		for (int i = 1; i <= 15; i++) {
			System.out.printf("Number %02d: ", i);
			int currentNumber = scanner.nextInt();

			if (currentNumber > maxNumber) {
				maxNumber = currentNumber;
			}

			if (currentNumber < minNumber) {
				minNumber = currentNumber;
			}
		}

		System.out.printf("Min number: %d%n", minNumber);
		System.out.printf("Max number: %d%n", maxNumber);

		scanner.close();
	}
}
