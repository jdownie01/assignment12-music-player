import javafx.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LabelActivity extends Application {

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
        Label label = new Label("A Very exciting label");
        label.setMaxHeight(Double.MAX_VALUE);
        label.setMaxWidth(Double.MAX_VALUE);
        Label label2 = new Label("A Very boring label");
        label2.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        Label label3 = new Label("A Very mediorce label");
        label3.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        label.setFont(new Font("Comic Sans MS",55));
        label.setBackground(new Background(new BackgroundFill(Color.MAGENTA,CornerRadii.EMPTY,Insets.EMPTY)));
        label.setPadding(new Insets(55));
        VBox box = new VBox();

        Label label4 = makeLabel("Label 4", new Font("Comic Sans MS", 32), new BackgroundFill(Color.ORANGE, CornerRadii.EMPTY, Insets.EMPTY),Insets.EMPTY);
        Label label5 = makeLabel("Label 5", new Font("Comic Sans MS", 15), new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY),new Insets(32));
        label5.setBorder(new Border(new BorderStroke(Color.AQUA,BorderStrokeStyle.SOLID, new CornerRadii(16),BorderStroke.THICK)));
        box.getChildren().addAll(label,label2,label3,label4,label5);
        Scene scene = new Scene(box);
        stage.setTitle("My First GUI!");
        stage.setScene(scene);
        stage.show();
        
    }
    public static void main(String[] args) {
        launch(args);
    }

    
}
