import javafx.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class BorderPaneActivity extends Application {
    public Label makeLabel(String text, Font font, BackgroundFill backgroundFill, Insets insets){
        Label label = new Label(text);
        label.setFont(font);
        label.setBackground(new Background(backgroundFill));
        label.setPadding(insets);
        label.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        return label;
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane pane = new BorderPane();
        pane.setCenter(makeLabel("Label 4", new Font("Comic Sans MS", 32), new BackgroundFill(Color.ORANGE, CornerRadii.EMPTY, Insets.EMPTY),Insets.EMPTY));
        pane.setTop(makeLabel("Label 3", new Font("Comic Sans MS", 32), new BackgroundFill(Color.ORANGE, CornerRadii.EMPTY, Insets.EMPTY),Insets.EMPTY));
        pane.setLeft(makeLabel("Label 2", new Font("Comic Sans MS", 32), new BackgroundFill(Color.ORANGE, CornerRadii.EMPTY, Insets.EMPTY),Insets.EMPTY));
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("BorderPane Example");
        stage.show();
        
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
