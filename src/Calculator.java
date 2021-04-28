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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
public class Calculator extends Application {
    public Label makeLabel(String text){
        Label label = new Label(text);
        label.setFont(new Font("Arial",24));
        label.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));
        label.setPadding(new Insets(20));
        label.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        return label;
    }

    @Override
    public void start(Stage stage) throws Exception {
        GridPane pane = new GridPane();
        pane.add(makeLabel("AC"),0,1,2,1);
        pane.add(makeLabel("%"),2,1);
        pane.add(makeLabel("/"),3,1);

        pane.add(makeLabel("7"),0,2);
        pane.add(makeLabel("8"),1,2);
        pane.add(makeLabel("9"),2,2);
        pane.add(makeLabel("*"),3,2);

        pane.add(makeLabel("4"),0,3);
        pane.add(makeLabel("5"),1,3);
        pane.add(makeLabel("6"),2,3);
        pane.add(makeLabel("-"),3,3);

        pane.add(makeLabel("1"),0,4);
        pane.add(makeLabel("2"),1,4);
        pane.add(makeLabel("3"),2,4);
        pane.add(makeLabel("+"),3,4);

        pane.add(makeLabel("0"),0,5,2,1);
        pane.add(makeLabel("."),2,5);
        pane.add(makeLabel("="),3,5);



        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("Calculon");
        stage.show();

        
    }
    public static void main(String[] args) {
        launch(args);
    }
}
