package task02_read_from_file_and_sum_digits;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadFromFileAndSumDigits {
	static final String INPUT_FILE = "res/numbers.txt";
	static final String OUTPUT_FILE = "res/result.txt";

	public static void main(String[] args) {

		try (BufferedReader input = new BufferedReader(new FileReader(INPUT_FILE));
				BufferedWriter output = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {

			long sum = 0L;
			int b;
			while ((b = input.read()) != -1) {
				if (b > '0' && b <= '9') {
					sum += (b - '0');
				}
			}

			String result = String.format("Sum of values of all digits in \"%s\": %d", INPUT_FILE, sum);
			System.out.println(result);
			output.write(result);
			System.out.println("Result saved to \"" + OUTPUT_FILE + "\"");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Released open resources.");
		}
	}
}