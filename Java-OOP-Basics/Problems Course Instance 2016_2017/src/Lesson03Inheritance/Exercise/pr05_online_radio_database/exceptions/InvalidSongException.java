package Lesson03Inheritance.Exercise.pr05_online_radio_database.exceptions;

public class InvalidSongException extends Exception {

    InvalidSongException(String message) {
        super(message);
    }
}
