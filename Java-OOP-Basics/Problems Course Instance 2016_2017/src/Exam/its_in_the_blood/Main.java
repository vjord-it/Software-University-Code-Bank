package Exam.its_in_the_blood;

import Exam.its_in_the_blood.controller.HealthManager;
import Exam.its_in_the_blood.view.InputOutputManager;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        InputOutputManager.getInstance().run(HealthManager.getInstance());
    }
}