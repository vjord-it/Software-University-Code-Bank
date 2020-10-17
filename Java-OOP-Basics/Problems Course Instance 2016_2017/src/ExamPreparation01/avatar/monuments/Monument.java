package ExamPreparation01.avatar.monuments;

public abstract class Monument {

    private String name;

    protected Monument(String name) {
        this.setName(name);
    }

    private void setName(String name) {
        this.name = name;
    }
}