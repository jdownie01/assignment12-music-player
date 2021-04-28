import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class StackPaneAcitivity extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        StackPane pane = new StackPane();
        
        pane.getChildren().addAll(
            new ImageView("file:media/images/emojis/browsangry.png"),new ImageView("file:media/images/emojis/headblue.png"),new ImageView("file:media/images/emojis/eyesblack.png"),new ImageView("file:media/images/emojis/mouthbasic.png")
        );

        stage.setTitle("Emoji!");
        stage.setScene(new Scene(pane));
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
