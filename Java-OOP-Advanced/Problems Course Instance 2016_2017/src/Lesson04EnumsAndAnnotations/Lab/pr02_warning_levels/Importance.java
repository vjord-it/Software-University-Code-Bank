package Lesson04EnumsAndAnnotations.Lab.pr02_warning_levels;

public enum Importance {
    LOW(1), NORMAL(2), MEDIUM(3), HIGH(4);

    private int level;

    Importance(int level) {
        this.level = level;
    }

    public int getLevel() {
        return this.level;
    }
}
