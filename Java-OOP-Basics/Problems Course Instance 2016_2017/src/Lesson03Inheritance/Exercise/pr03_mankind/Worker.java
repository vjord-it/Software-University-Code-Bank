package Lesson03Inheritance.Exercise.pr03_mankind;

public class Worker extends Human {

    private static final String TOO_SHORT_LAST_NAME = "Expected length more than 3 symbols!Argument: lastName";
    private static final String INVALID_WEEK_SALARY = "Expected value mismatch!Argument: weekSalary";
    private static final String INVALID_WORK_HOURS_PER_DAY = "Expected value mismatch!Argument: workHoursPerDay";
    private static final double MIN_WEEK_SALARY = 10d;
    private static final int MAX_WORK_HOURS = 12;
    private static final int MIN_WORK_HOURS = 1;

    private double weekSalary;
    private double workHoursPerDay;

    public Worker(String firstName, String lastName, double weekSalary, double workHoursPerDay) {
        super(firstName, lastName);
        this.setWeekSalary(weekSalary);
        this.setWorkHoursPerDay(workHoursPerDay);
    }

    private void setWeekSalary(double weekSalary) {
        if (weekSalary < MIN_WEEK_SALARY) {
            throw new IllegalArgumentException(INVALID_WEEK_SALARY);
        }
        this.weekSalary = weekSalary;
    }

    private void setWorkHoursPerDay(double workHoursPerDay) {
        if (workHoursPerDay < MIN_WORK_HOURS || workHoursPerDay > MAX_WORK_HOURS) {
            throw new IllegalArgumentException(INVALID_WORK_HOURS_PER_DAY);
        }
        this.workHoursPerDay = workHoursPerDay;
    }

    private double getSalaryPerHour() {
        return this.weekSalary / this.workHoursPerDay / 7d;
    }

    @Override
    protected void setLastName(String lastName) {
        if (lastName == null || lastName.trim().length() < 4) {
            throw new IllegalArgumentException(TOO_SHORT_LAST_NAME);
        }
        super.setLastName(lastName);
    }

    @Override
    protected String getInfo() {
        return String.format("%s%nSalary:  %.2f%nHours per day: %.2f%nSalary per hour: %.2f",
                super.getInfo(), this.weekSalary, this.workHoursPerDay, this.getSalaryPerHour());
    }
}
