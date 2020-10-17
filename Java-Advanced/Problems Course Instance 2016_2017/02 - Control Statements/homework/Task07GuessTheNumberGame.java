import java.util.Random;
import java.util.Scanner;

public class Task07GuessTheNumberGame {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int gamesWon = 0;
		int gamesLost = 0;
		boolean play = true;

		while (play) {
			if (playGame(scanner)) {
				gamesWon++;
			} else {
				gamesLost++;
			}

			System.out.printf("Games won: %d%n", gamesWon);
			System.out.printf("Games lost: %d%n", gamesLost);
			System.out.print("Do you want to play another round? (y/n):");

			play = (scanner.next().charAt(0) == 'y');
		}

		System.out.println("Goodbye!");

		scanner.close();
	}

	private static boolean playGame(Scanner scanner) {
		final int maxNumber = 20;
		final int maxTries = 3;

		Random randomGenerator = new Random();
		int number = randomGenerator.nextInt(maxNumber) + 1;

		boolean victory = false;
		int minGuess = 1;
		int maxGuess = maxNumber;
		int tries = maxTries;
		
		while (tries > 0) {
			System.out.printf("Guess the number (%d-%d), %d tries left: ", minGuess, maxGuess, tries);

			if (!scanner.hasNextInt()) {
				scanner.next();
				continue;
			}
			
			int guess = scanner.nextInt();

			if (guess < minGuess || guess > maxGuess) {
				System.out.println("Invalid input");
				continue;
			}

			if (guess == number) {
				victory = true;
				break;
			} else if (guess < number) {
				minGuess = guess + 1;
				System.out.println("Your guess is too low");
			} else {
				maxGuess = guess - 1;
				System.out.println("Your guess is too high");
			}

			tries--;
		}

		if (victory) {
			System.out.println("You win!");
		} else {
			System.out.printf("Game Over (number = %d)%n", number);
		}

		return victory;
	}
}