package Lesson03Inheritance.Exercise.pr05_online_radio_database.exceptions;

public class InvalidSongMinutesException extends InvalidSongLengthException {

    public InvalidSongMinutesException(String message) {
        super(message);
    }
}
