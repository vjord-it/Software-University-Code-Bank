import java.util.Scanner;

public class LoopDemo {

	public static void main(String[] args) {
		
		int i = 1;
		while (i <= 100) {
			System.out.println(i);
			i++;
		}
		
		/////////
		
		i = 10000;
		do {
			System.out.println(i);
			i++;
		} while(i <= 100);
		
		/*
		Scanner sc = new Scanner(System.in);
		int day;
		
		do {
			System.out.println("Enter day (1-7):");
			day = sc.nextInt();
		} while (day < 1 || day > 7);
		*/		
		
		//////////
		
		
		for (int j = 1; j <= 100; j++) {
			System.out.println(j);
			j++;
		}
		
		for(int k = 1; k <= 100; k++) {
			if(k < 50 || k > 60) {
				System.out.println(k);
			}
		}
		
		for(int l = 1; l <= 100; l++) {
			if(l >= 50 && l <= 60) {
				continue;
			}
			
			System.out.println(l);
		}
		
		for(int p = 1; p <= 100; p++) {
			if(p == 15) {
				break;
			}
			
			System.out.println(p);
		}
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Vyvedi chetno chislo: ");
			int result = sc.nextInt();
			if(result % 2 == 0) {
				break;
			}
		}
	}
}
