package Lesson01DefiningClasses.Exercise.pr08_pokemon_trainer;

class Pokemon {
    private static final int HEALTH_HIT_ON_LOST_BATTLE = 10;
    private String name;
    private String element;
    private int health;

    Pokemon(String name, String element, int health) {
        super();
        this.name = name;
        this.element = element;
        this.health = health;
    }

    String getElement() {
        return element;
    }

    void loseTournament() {
        this.health -= HEALTH_HIT_ON_LOST_BATTLE;
    }

    boolean isDead() {
        return this.health <= 0;
    }
}
