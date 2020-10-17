package date;

public class DatePrinter {
	
	private static DateReader myDate = new DateReader();
	
	public void printCurentDateToConsole() {
		
		System.out.println(getCurrentDateAsString("yyyy/MM/dd"));
	}
	
	public void printCurentDateToConsole(String format) {
		
		System.out.println(getCurrentDateAsString(format));
	}
	
	private static String getCurrentDateAsString(String format) {
		
		return myDate.getCurrentDate(format);
	}
	

	public static void printCurentDateToConsoleStatic() {
		
		System.out.println(getCurrentDateAsString("yyyy/MM/dd"));
	}
}
