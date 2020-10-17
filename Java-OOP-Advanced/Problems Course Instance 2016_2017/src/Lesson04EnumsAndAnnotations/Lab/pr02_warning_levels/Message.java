package Lesson04EnumsAndAnnotations.Lab.pr02_warning_levels;

public class Message {

    private Importance importance;
    private String content;

    public Message(Importance importance, String content) {
        this.importance = importance;
        this.content = content;
    }

    @Override
    public String toString() {
        return this.importance + ": " + this.content;
    }

    public Importance getLevel() {
        return this.importance;
    }
}
