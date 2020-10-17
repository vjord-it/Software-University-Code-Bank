package Lesson03Inheritance.Exercise.pr05_online_radio_database;

import Lesson03Inheritance.Exercise.pr05_online_radio_database.exceptions.InvalidSongException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int songsToRead = Integer.parseInt(reader.readLine());
            long songsTotalTimeInSeconds = 0L;
            int totalSongs = 0;

            Song song;
            while (songsToRead-- > 0) {
                String[] tokens = reader.readLine().trim().split(";");

                if (tokens.length == 3) {
                    try {
                        song = new Song(tokens);
                        songsTotalTimeInSeconds += song.getDurationInSeconds();
                        totalSongs++;
                        System.out.println("Song added.");
                    } catch (InvalidSongException ise) {
                        System.out.println(ise.getMessage());
                    }
                }
            }
            System.out.printf("Songs added: %d%n", totalSongs);
            System.out.printf("Playlist length: %s%n", getTime(songsTotalTimeInSeconds));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getTime(long songsTotalTimeInSeconds) {
        long hours = songsTotalTimeInSeconds / 3600;
        songsTotalTimeInSeconds %= 3600;
        long minutes = songsTotalTimeInSeconds / 60;
        long seconds = songsTotalTimeInSeconds % 60;

        return String.format("%dh %dm %ds", hours, minutes, seconds);
    }
}