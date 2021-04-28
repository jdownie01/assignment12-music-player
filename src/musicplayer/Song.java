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

    public Song(String pathToFile, String description, String pathToImageFile) {
        this.pathToFile = pathToFile;
        this.description = description;
        this.pathToImageFile = pathToImageFile;
    }

    public void play() throws IOException {
        in = new FileInputStream(pathToFile);
        as = new AudioStream(in);
        AudioPlayer.player.start(as);



    }

    public void pause() {
        //
    }

    public void rewind() {
        playbackProgress -= 10;
    }

    public void forward() {
        playbackProgress += 10;
    }

    public void stop() {
        AudioPlayer.player.stop(as);
        playbackProgress = 0;
    }
}