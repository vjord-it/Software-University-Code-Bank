import java.util.Scanner;

public class Task04DecisionMaker {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter time (byte): ");
		byte hour = scanner.nextByte();
		
		System.out.printf("%nIt is %d o'clock.%nWhat am I ging to do today?%n%n", hour % 24);
		
		System.out.print("Enter money (double): ");
		double money = scanner.nextDouble();
		
		System.out.print("Are you sick (boolean - true or false): ");
		boolean isSick = scanner.nextBoolean();
		
		System.out.println();
		
		if (isSick) {
			if (money<= 0d) {
				System.out.println("I'm sick and I have no money. I'm stying home today.");
			} else {
				System.out.printf("I'm sick, but I have some money (%.2f), so I'll go out to buy me some medicine.%n", money);
			}
		} else {
			if (money < 1d) {
				System.out.printf("I feel good, but I have no extra money (%.2f), so I'll stay home and play computer games today.%n", money);
			} else if (money >= 1d && money <= 10d) {
				System.out.printf("I feel good and I have some money (%.2f), so I'll go out to a coffee.%n", money);
			} else {
				System.out.printf("I feel great and I have just enough money (%.2f) to go out and party all night long!%n", money);
			}
		}
		
		scanner.close();
	}
}
