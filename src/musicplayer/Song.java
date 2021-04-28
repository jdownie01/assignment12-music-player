package musicplayer;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Song {
    private String pathToFile;
    private String description;
    private String pathToImageFile;
    private InputStream in;
    private AudioStream as;
    private int playbackProgress;

    public int getPlaybackProgress() {
        return playbackProgress;
    }

    public String getDescription() {
        return description;
    }

    public String getPathToFile() {
        return pathToFile;
    }

    public String getPathToImageFile() {
        return pathToImageFile;
    }

    enum STATE {
        PLAYING,
        PAUSED,
        STOPPED
    }

    private STATE state;

    public Song(String pathToFile, String description, String pathToImageFile) {
        this.pathToFile = pathToFile;
        this.description = description;
        this.pathToImageFile = pathToImageFile;
        state = STATE.STOPPED;
    }
}