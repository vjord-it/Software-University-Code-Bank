package BashSoft.src.bashsoft.models;

import BashSoft.src.bashsoft.io.OutputWriter;
import BashSoft.src.bashsoft.staticData.ExceptionMessages;

import java.util.LinkedHashMap;
import java.util.Map;

public class Course {

    public static final int NUMBER_OF_TASKS_ON_EXAM = 5;
    public static final int MAX_SCORE_ON_EXAM_TASK = 100;

    private String name;
    private Map<String, Student> studentsByName;

    public Course(String name) {
        this.name = name;
        this.studentsByName = new LinkedHashMap<>();
    }

    public String getName() {
        return name;
    }

    public void enrollStudent(Student student) {
        if (this.studentsByName.containsKey(student.getName())) {
            OutputWriter.displayException(String.format(
                    ExceptionMessages.STUDENT_ALREADY_ENROLLED_IN_GIVEN_COURSE,
                    student.getName(), this.name));
            return;
        }

        this.studentsByName.put(student.getName(), student);
    }
}
