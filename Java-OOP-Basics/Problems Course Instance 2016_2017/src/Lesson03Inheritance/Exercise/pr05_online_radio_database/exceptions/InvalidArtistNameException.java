package Lesson03Inheritance.Exercise.pr05_online_radio_database.exceptions;

public class InvalidArtistNameException extends InvalidSongException {

    public InvalidArtistNameException(String message) {
        super(message);
    }
}
