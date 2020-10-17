package Lesson03Inheritance.Lab.pr06_stack_of_strings;

import java.util.ArrayList;
import java.util.List;

public class StackOfStrings {
    private List<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String string) {
        this.data.add(string);
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }

    public String peek() {
        if (this.isEmpty()) {
            return null;
        }

        return this.data.get(this.data.size() - 1);

    }

    public String pop() {
        if (this.isEmpty()) {
            return null;
        }

        return this.data.remove(this.data.size() - 1);
    }
}
