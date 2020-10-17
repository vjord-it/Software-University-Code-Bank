package Lesson01DefiningClasses.Exercise.pr09_google;

class Company {
    private String name;
    private String department;
    private double salary;

    Company(String company, String department, double salary) {
        this.name = company;
        this.department = department;
        this.salary = salary;
    }

    String getInfo() {
        return String.format("%s %s %.2f", this.name, this.department, this.salary);
    }
}
