package Lesson03Inheritance.Exercise.pr05_online_radio_database.exceptions;

public class InvalidSongLengthException extends InvalidSongException {

    public InvalidSongLengthException(String message) {
        super(message);
    }
}
