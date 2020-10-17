package Lesson04EnumsAndAnnotations.Lab.pr05_coding_tracker;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tracker {

    @Author(name = "Pesho")
    public static void printMethodsByAuthor(Class<?> tClass) {
        Map<String, List<String>> methodsByAuthor = new HashMap<>();

        Method[] methods = tClass.getMethods();

        for (Method method : methods) {
            Author author = method.getAnnotation(Author.class);
            if (author != null) {
                methodsByAuthor.putIfAbsent(author.name(), new ArrayList<>());
                methodsByAuthor.get(author.name()).add(method.getName() + "()");
            }
        }

//        methodsByAuthor.forEach((n, m) -> {
//            System.out.print(n);
//            System.out.print(": ");
//            System.out.println(m.stream().collect(Collectors.joining(", ")));
//        });

        for (String author : methodsByAuthor.keySet()) {
            System.out.printf("%s: %s%n", author, String.join(", ", methodsByAuthor.get(author)));
        }
    }

    @Author(name = "Pesho")
    public static void main(String[] args) {
        Tracker.printMethodsByAuthor(Tracker.class);
    }
}
