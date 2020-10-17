import java.util.Scanner;

public class Task03PrintNumbersFromUserInput {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Please enter first number:");
		int start = scanner.nextInt();

		System.out.print("Please enter second number:");
		int end = scanner.nextInt();

		if (start > end) {
			int temp = end;
			end = start;
			start = temp;
		}

		System.out.print("Result: ");
		while (start <= end) {
			System.out.printf("%d ", start++);
		}

		scanner.close();
	}
}