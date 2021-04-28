package musicplayer;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.io.File;
import java.util.HashMap;
import java.util.Set;

public class MusicPlayer extends Application {
    static MediaPlayer player;
    static double len = 0;
    static Label l = null;
    static Set<Song> songs_set;
    
    public static String[] songs = {
            "01 Giving Bad People Good Ideas.mp3",
            "02 Hot Head.mp3",
            "03 Spikes.mp3",
            "04 Warping.mp3",
            "05 Eh.mp3",
            "06 Bubbles Buried In This Jungle.mp3",
            "07 Trash.mp3",
            "08 Houdini.mp3",
            "09 BB Poison.mp3",
            "10 Three Bedrooms In A Good Neighborhood.mp3",
            "11 Ring A Bell.mp3",
            "12 80808.mp3",
            "13 Bottomless Pit.mp3"
    };
    public static String current_song = songs[0];
    
    public static javafx.scene.control.Label makeLabel(String text, javafx.scene.text.Font font, BackgroundFill backgroundFill, javafx.geometry.Insets insets){
        javafx.scene.control.Label label = new Label(text);
        label.setFont(font);
        label.setBackground(new Background(backgroundFill));
        label.setPadding(insets);
        label.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        return label;
    }
    private static javafx.scene.control.Button makeStopButton(String text, String path){
        javafx.scene.control.Button button = new Button(text);
        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        button.setOnAction((event) -> {
            player.stop();
        });
        return button;
    }

    private static javafx.scene.control.Button makePauseButton(String text, String path){
        javafx.scene.control.Button button = new Button(text);
        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        button.setOnAction((event) -> {
            if (player.getStatus() != MediaPlayer.Status.PAUSED) {
                len = player.getCurrentTime().toMillis();
                player.pause();
            } else if (player.getStatus() == MediaPlayer.Status.PAUSED) {
                player.seek(Duration.millis(len));
                player.play();
            }
        });
        return button;
    }

    private static javafx.scene.control.Button makeRestartButton(String text, String path){
        javafx.scene.control.Button button = new Button(text);
        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        button.setOnAction((event) -> {
            player.stop();
            player.play();
        });
        return button;
    }
    private static javafx.scene.control.Button makeSkipForward(String text, String path){
        javafx.scene.control.Button button = new Button(text);
        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        button.setOnAction((event) -> {
            len = player.getCurrentTime().toMillis();
            len = len + 10000.0;
            player.pause();
            player.seek(Duration.millis(len));
            player.play();
        });
        return button;
    }
    private static javafx.scene.control.Button makeSkipBackward(String text, String path){
        javafx.scene.control.Button button = new Button(text);
        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        button.setOnAction((event) -> {
            len = player.getCurrentTime().toMillis();
            len = len - 10000.0;
            player.pause();
            player.seek(Duration.millis(len));
            player.play();
        });
        return button;
    }
    private static javafx.scene.control.Button makePlayButton(String text, String path){
        javafx.scene.control.Button button = new Button(text);
        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        button.setOnAction((event) -> {
            String uri = new File("media/sounds/"+current_song).toURI().toString();
            Media media = new Media(uri);
            player = new MediaPlayer(media);
            player.play();
        });
        return button;
    }
    private static javafx.scene.control.Button makeUnpauseButton(String text, String path){
        javafx.scene.control.Button button = new Button(text);
        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        button.setOnAction((event) -> {
            player.seek(Duration.millis(len));
            player.play();
        });
        return button;
    }
    private static javafx.scene.control.Button makeButton(String text, String path){
        javafx.scene.control.Button button = new Button(text);
        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        button.setOnAction((event) -> {
            if (player != null) {
                player.stop();
            }
            current_song = path;
            Song s = new Song("media/sounds/"+path, text, "media/images/Cover.jpg");
            songs_set.add(s);
            String uri = new File("media/sounds/"+path).toURI().toString();
            Media media = new Media(uri);
            player = new MediaPlayer(media);
            player.play();
            l.setText(text);
        });
        return button;
    }

    @Override
    public void start(Stage stage) throws Exception {
        Label l = makeLabel("DEATH GRIPS : BOTTOMLESS PIT", new javafx.scene.text.Font("Comic Sans MS", 32), new BackgroundFill(javafx.scene.paint.Color.BLACK, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY), javafx.geometry.Insets.EMPTY);

        BorderPane pane = new BorderPane();
        VBox box = new VBox();
        box.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Color.GREY, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
        javafx.scene.image.Image image = new Image("file:media/images/Cover.jpg");
        ImageView view = new ImageView(image);
        VBox box3 = new VBox();
        box3.getChildren().add(view);
        box3.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Color.GREY, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));

        box.getChildren().addAll(
                makeButton("01 Giving Bad People Good Ideas", songs[0]), makeButton("02 Hot Head", songs[1]), makeButton("03 Spikes",songs[2]),
                makeButton("04 Warping",songs[3]), makeButton("05 Eh",songs[4]), makeButton("06 Bubbles Buried In This Jungle", songs[5]),
                makeButton("07 Trash",songs[6]),
                makeButton("08 Houdini",songs[7]),
                makeButton("10 Three Bedrooms In A Good Neighborhood",songs[9]),
                makeButton("12 80808",songs[11]),
                makeButton("13 Bottomless Pit",songs[12])
                );

        HBox box2 = new HBox();
        box2.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Color.GREY, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));

        box2.getChildren().addAll(
                makePlayButton("Play", "media/sounds/13 Bottomless Pit.mp3"    ), makeStopButton("Stop", "media/sounds/chomp.wav"), makePauseButton("Toggle Pause", "media/sounds/eat.wav"), makeSkipForward("+10s", "media/sounds/chomp.wav"), makeSkipBackward("-10s", "media/sounds/chomp.wav")
        );

        pane.setCenter(box);
        pane.setTop(l);
        pane.setLeft(box3);
        pane.setBottom(box2);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("Death Grips Music Player");
        stage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}