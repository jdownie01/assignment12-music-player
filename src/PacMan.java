import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class PacMan extends Application{

    private static Button makeButton(String text, String path){
        Button button = new Button(text);
        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        
        button.setOnAction((event) -> {
            String uri = new File(path).toURI().toString();
            Media media = new Media(uri);
            MediaPlayer player = new MediaPlayer(media);
            player.play();
        });
        return button;
    }

    @Override
    public void start(Stage stage) throws Exception {
        VBox box = new VBox();

        box.getChildren().addAll(
            makeButton("Start", "media/sounds/start.wav"), makeButton("Chomp", "media/sounds/chomp.wav"), makeButton("Eat", "media/sounds/eat.wav"), makeButton("End", "path")
        );

        stage.setTitle("Pac-Man");
        stage.setScene(new Scene(box));
        stage.show();
        
    }
    public static void main(String[] args) {
        launch(args);
    }

    
}
