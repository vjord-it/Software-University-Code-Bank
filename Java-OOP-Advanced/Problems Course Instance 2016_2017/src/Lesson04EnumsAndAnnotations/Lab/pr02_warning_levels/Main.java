package Lesson04EnumsAndAnnotations.Lab.pr02_warning_levels;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String level = scanner.nextLine().trim().toUpperCase();

        Logger logger = new Logger(Importance.valueOf(level));

        while (true) {
            String log = scanner.nextLine();

            if ("END".equalsIgnoreCase(log)) {
                break;
            }
            String[] tokens = log.split("\\s*:\\s+");
            logger.log(new Message(Importance.valueOf(tokens[0]), tokens[1]));
        }

        logger.getMessages().forEach(System.out::println);
    }
}
