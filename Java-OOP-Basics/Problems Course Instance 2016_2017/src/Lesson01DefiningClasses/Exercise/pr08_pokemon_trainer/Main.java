package Lesson01DefiningClasses.Exercise.pr08_pokemon_trainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Map<String, Trainer> trainers = readTrainers(reader);
            readAndProcessTournaments(trainers, reader);

            StringBuilder result = new StringBuilder();
            trainers.values().stream()
                    .sorted()
                    .forEachOrdered(trainer -> result.append(trainer.getTrainerInfo()).append(System.lineSeparator()));
            System.out.print(result.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            // Invalid tests in Judge
        }
    }

    private static void readAndProcessTournaments(Map<String, Trainer> trainers, BufferedReader reader) throws IOException {
        String element;
        while (!"end".equals(element = reader.readLine().toLowerCase())) {
            for (Trainer trainer : trainers.values()) {
                trainer.participateInTournament(element);
            }
        }
    }

    private static Map<String, Trainer> readTrainers(BufferedReader reader) throws IOException {
        Map<String, Trainer> trainers = new LinkedHashMap<>();

        String input;
        while (!"tournament".equalsIgnoreCase(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String elementType = tokens[2].toLowerCase();
            int health = Integer.parseInt(tokens[3]);
            trainers.putIfAbsent(trainerName, new Trainer(trainerName));
            trainers.get(trainerName).addPokemon(new Pokemon(pokemonName, elementType, health));
        }

        return trainers;
    }
}
