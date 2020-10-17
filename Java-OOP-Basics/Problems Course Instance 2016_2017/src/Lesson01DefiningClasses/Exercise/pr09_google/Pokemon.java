package Lesson01DefiningClasses.Exercise.pr09_google;

public class Pokemon {
    private String name;
    private String type;

    Pokemon(String name, String type) {
        this.name = name;
        this.type = type;
    }

    String getInfo() {
        return String.format("%s %s", this.name, this.type);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Pokemon pokemon = (Pokemon) o;

        return name != null ? name.equals(pokemon.name) : pokemon.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
