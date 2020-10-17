package edu.pragmatic.enums;

public class Alarm {

	private int time;
	
	public int getTime() {
		return time;
	}
	
	/**
	 *
	 * @param day use the constants from Day
	 */
//	public void setDay(int day) {
//		if(day >= DayConstants.MONDAY && day <= DayConstants.FRIDAY) {
//			time = 8;
//		} else if(day == DayConstants.SATURDAY || day == DayConstants.SUNDAY) {
//			time = 10;
//		} else {
//			throw new IllegalArgumentException();
//		}
//	}
	public void setDay(Day d) {
		switch (d) {
		case MONDAY:
		case TUESDAY:
		case WEDNESDAY:
		case THURSDAY:
		case FRIDAY:
			time = 8;
			break;
		case SATURDAY:
		case SUNDAY:
			time = 10;
			break;
		}
	}
}
