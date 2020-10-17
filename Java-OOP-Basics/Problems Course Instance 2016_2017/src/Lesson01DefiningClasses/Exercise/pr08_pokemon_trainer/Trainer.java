package Lesson01DefiningClasses.Exercise.pr08_pokemon_trainer;

import java.util.*;

public class Trainer implements Comparable<Trainer> {
    private String name;
    private int badges;
    private Map<String, List<Pokemon>> pokemonCollection;

    Trainer(String name) {
        this.name = name;
        this.pokemonCollection = new LinkedHashMap<>();
    }

    void addPokemon(Pokemon pokemon) {
        this.pokemonCollection.putIfAbsent(pokemon.getElement(), new LinkedList<>());
        this.pokemonCollection.get(pokemon.getElement()).add(pokemon);
    }

    void participateInTournament(String element) {
        if (hasPokemonOfType(element)) {
            this.badges++;
        } else {
            for (List<Pokemon> pokemonList : this.pokemonCollection.values()) {
                Iterator<Pokemon> it = pokemonList.iterator();
                while (it.hasNext()) {
                    Pokemon pokemon = it.next();
                    pokemon.loseTournament();
                    if (pokemon.isDead()) {
                        it.remove();
                    }
                }
            }
        }
    }

    private boolean hasPokemonOfType(String element) {
        return this.pokemonCollection.containsKey(element) &&
                !this.pokemonCollection.get(element).isEmpty();
    }

    private int getPokemonCount() {
        return this.pokemonCollection.entrySet().stream()
                .mapToInt(x -> x.getValue().size()).sum();
    }

    String getTrainerInfo() {
        return String.format("%s %d %d", this.name, this.badges, this.getPokemonCount());
    }

    @Override
    public int compareTo(Trainer o) {
        return (Integer.compare(o.badges, this.badges));
    }
}
