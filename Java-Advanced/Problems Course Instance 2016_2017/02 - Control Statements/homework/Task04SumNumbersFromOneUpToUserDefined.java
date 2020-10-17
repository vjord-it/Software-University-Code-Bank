import java.util.Scanner;

public class Task04SumNumbersFromOneUpToUserDefined {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int endNumber;

		do {
			System.out.print("Enter a number:");
			endNumber = scanner.nextInt();
		} while (endNumber <= 0);

		long sum = 0L;

		while (endNumber > 0) {
			sum += endNumber--;
		}

		System.out.printf("Result %d%n", sum);

		scanner.close();
	}
}
