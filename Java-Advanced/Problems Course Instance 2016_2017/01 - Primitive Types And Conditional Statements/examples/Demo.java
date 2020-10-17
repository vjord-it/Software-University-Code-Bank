import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {

		byte age = 7;
		// System.out.println(age);
		// age = 7;
		System.out.println(age);
		age = 40;
		System.out.println(age);
		// age = 128;
		// firstName

		short sh = 12345;

		int i = 324254522;

		long l = 40000000000L;

		float f = 2.12345678912345678f;
		System.out.println(f);

		double d = 2.12345678912345678;
		System.out.println(d);

		float f2 = 0.1f + 0.1f + 0.1f + 0.1f + 0.1f + 0.1f + 0.1f;
		System.out.println(f2);

		float f3 = 7 * 0.1f;
		System.out.println(f3);

		char ch = 't';
		ch = '*';
		System.out.println(ch);
		ch = '♞';
		System.out.println(ch);

		ch = '\u2744';
		System.out.println(ch);

		boolean b = true;

		/////////////

		int i1 = 8;
		int i2 = 10;
		int r = i1 + i2;

		int r2 = i2 / i1; // r2 e 1
		int r4 = i2 % i1;

		double d1 = 8;
		double d2 = 10;
		double r3 = d2 / d1;

		i = 10;
		i = i + 5;
		i /= 5;

		i = 10;
		i = i + 1;
		i += 1;
		i++;
		++i;

		i = 10;
		i++;
		System.out.println(i);
		i = 10;
		++i;
		System.out.println(i);

		i = 10;
		int a = i++;
		// int a = i;
		// i++;
		// a e 10, i e 11

		i = 10;
		int c = ++i;
		// c e 11, i e 11

		////////////

		int e = 10000;
		byte v = (byte) e;
		System.out.println(v);

		/////

		byte t = 10;
		int g = t;

		////////

		{
			int uu = 23;
			System.out.println(uu);
			// float uu = 3;
			System.out.println(g);
			g = 99;
		}

		float uu = 3;
		System.out.println(uu);

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first number: ");
		int first = sc.nextInt();
		System.out.println("Enter second number: ");
		int second = sc.nextInt();

		int result = first + second;
		// System.out.print("Result is: ");
		// System.out.println(result);
		System.out.println("Result is: " + result);
		boolean isChetno = (result % 2 == 0);

		/*
		 * if (result % 2 == 0) { System.out.println("Chetno"); } else {
		 * System.out.println("Nechetno"); }
		 */
		// if (isChetno == true) {
		// System.out.println("Chetno");
		// } else {
		// System.out.println("Nechetno");
		// }

		if (isChetno) {
			System.out.println("Chetno");
		} else {
			System.out.println("Nechetno");
		}

		if (!isChetno) {
			System.out.println("Nechetno");
		} else {
			System.out.println("Chetno");
		}
	}
}
