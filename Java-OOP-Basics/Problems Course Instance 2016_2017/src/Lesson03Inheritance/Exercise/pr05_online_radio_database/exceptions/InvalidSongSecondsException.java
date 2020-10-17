package Lesson03Inheritance.Exercise.pr05_online_radio_database.exceptions;

public class InvalidSongSecondsException extends InvalidSongLengthException {

    public InvalidSongSecondsException(String message) {
        super(message);
    }
}
