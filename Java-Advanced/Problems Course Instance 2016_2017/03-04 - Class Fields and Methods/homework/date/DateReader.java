package date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateReader {
	
	public String getCurrentDate(String format) {
		
		DateFormat dateFormat = new SimpleDateFormat(format);
		Date date = new Date();
		return dateFormat.format(date);		
	}

}