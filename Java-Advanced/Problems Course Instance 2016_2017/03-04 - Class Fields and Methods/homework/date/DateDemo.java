package date;

public class DateDemo {

	public static void main(String[] args) {

		DatePrinter.printCurentDateToConsoleStatic();
				
		DatePrinter datePrinter = new DatePrinter();
		datePrinter.printCurentDateToConsole();
		datePrinter.printCurentDateToConsole("yyyy/MM/dd HH:mm:ss");

		DatePrinter datePrinter2 = new DatePrinter();
		datePrinter2.printCurentDateToConsole();
		datePrinter2.printCurentDateToConsole("yyyy/MM/dd HH:mm:ss");
		
		DatePrinter.printCurentDateToConsoleStatic();
	}

}
