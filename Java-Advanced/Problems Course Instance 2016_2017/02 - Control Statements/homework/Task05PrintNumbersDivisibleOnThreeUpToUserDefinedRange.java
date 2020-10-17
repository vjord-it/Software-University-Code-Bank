import java.util.Scanner;

public class Task05PrintNumbersDivisibleOnThreeUpToUserDefinedRange {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int endNumber;

		do {
			System.out.print("Enter n:");
			endNumber = scanner.nextInt();
		} while (endNumber <= 2);

		StringBuilder sb = new StringBuilder();

		int currentNumber = 3;

		while (currentNumber <= endNumber) {
			sb.append(currentNumber).append(",");
			currentNumber += 3;
		}

		sb.delete(sb.length() - 1, sb.length());

		System.out.println(sb);

		scanner.close();
	}
}
