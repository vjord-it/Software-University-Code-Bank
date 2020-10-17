package Lesson03Inheritance.Exercise.pr05_online_radio_database.exceptions;

public class InvalidSongNameException extends InvalidSongException {

    public InvalidSongNameException(String message) {
        super(message);
    }
}
