package Lesson04EnumsAndAnnotations.Lab.pr01_weekdays;

public class WeeklyEntry {

    private Weekday weekday;
    private String notes;

    public WeeklyEntry(String weekday, String notes) {
        this.weekday = Weekday.valueOf(weekday.toUpperCase());
        this.notes = notes;
    }

    public Weekday getWeekday() {
        return this.weekday;
    }

    @Override
    public String toString() {
        return this.weekday + " - " + this.notes;
    }
}
