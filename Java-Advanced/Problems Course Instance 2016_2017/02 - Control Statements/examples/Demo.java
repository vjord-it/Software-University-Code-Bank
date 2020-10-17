import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter day: (1-7): ");
		int day = sc.nextInt();
		
		/*
		int alarm;
		if(day >= 6) {
			alarm = 10;
		} else {
			alarm = 8;
		}
		*/
		
		int alarm = (day >= 6) ? 10 : 8;
		
		System.out.println("Alarm: " + alarm);
		
		////////////////
		
		char direction = sc.next().charAt(0);
		
		/*
		if(direction == 'u') {
			System.out.println("Nagore");
		} else if(direction == 'd') {
			System.out.println("Nadolu");
		} else if(direction == 'l') {
			System.out.println("Naliavo");
		} else if(direction == 'r') {
			System.out.println("Nadiasno");
		} else {
			System.out.println("Greshka");
		}
		*/
				
		switch (direction) {
		case 'U':
		case 'u': 
			System.out.println("Nagore");
			break;
		case 'D':
		case 'd':
			System.out.println("Nadolu");
			break;		
		case 'L':
		case 'l':
			System.out.println("Naliavo");
			break;
		case 'R':
		case 'r':
			System.out.println("Nadiasno");
			break;
		default:
			System.out.println("Greshka");			
		}
		
		/*
		float f = 3.14f;
		switch (f) {
		case 1.2:
			System.out.println("");
			break;
		case 3.1:
			System.out.println("");
			break;
		}
		*/
		
		///////////////////
		System.out.println("1");
		System.out.println("2");
		System.out.println("3");
	}
}








