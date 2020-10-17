package Lesson03Inheritance.Exercise.pr05_online_radio_database;

import Lesson03Inheritance.Exercise.pr05_online_radio_database.exceptions.*;

class Song {

    private String artistName;
    private String songName;
    private int durationInSeconds;

    Song(String... tokens) throws InvalidSongException {
        this.setArtistName(tokens[0]);
        this.setSongName(tokens[1]);
        this.setDurationInSeconds(tokens[2]);
    }

    private void setArtistName(String artistName) throws InvalidArtistNameException {
        if (artistName == null || artistName.length() < 3 || artistName.length() > 20) {
            throw new InvalidArtistNameException("Artist name should be between 3 and 20 symbols.");
        }
        this.artistName = artistName;
    }

    private void setSongName(String songName) throws InvalidSongNameException {
        if (songName == null || songName.length() < 3 || songName.length() > 30) {
            throw new InvalidSongNameException("Song name should be between 3 and 30 symbols.");
        }
        this.songName = songName;
    }

    long getDurationInSeconds() {
        return this.durationInSeconds;
    }

    private void setDurationInSeconds(String duration) throws InvalidSongException {
        int minutes;
        int seconds;
        try {
            String[] tokens = duration.split(":");
            minutes = Integer.parseInt(tokens[0]);
            seconds = Integer.parseInt(tokens[1]);
        } catch (Exception e) {
            throw new InvalidSongLengthException("Invalid song length.");
        }

        if (minutes < 0 || minutes > 14) {
            throw new InvalidSongMinutesException("Song minutes should be between 0 and 14.");
        }
        if (seconds < 0 || seconds > 59) {
            throw new InvalidSongSecondsException("Song seconds should be between 0 and 59.");
        }
        this.durationInSeconds = minutes * 60 + seconds;
    }
}
