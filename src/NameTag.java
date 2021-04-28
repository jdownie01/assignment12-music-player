import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class NameTag extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        VBox labels = new VBox();
        labels.setPadding(new Insets(15));
        Label hello = new Label("HELLO MY NAME IS");
        hello.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        hello.setFont(new Font("Impact", 24));
        hello.setAlignment(Pos.CENTER);
        hello.setTextFill(Color.AQUA);

        Label name = new Label("YOUR NAME");
        name.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        name.setFont(new Font("Comic Sans MS", 32));
        name.setAlignment(Pos.CENTER);
        name.setTextFill(Color.ORANGE);
        labels.getChildren().addAll(hello,name);

        VBox box = new VBox();
        TextField field = new TextField();
        field.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        field.setPromptText("Enter Your name");
        Button button = new Button("Update Name Tag");

        //Updater updater = new Updater(field, name);
        button.setOnAction((event) -> name.setText(field.getText()));

        Button button2 = new Button("Clear");
        // button2.setOnAction(new EventHandler<ActionEvent>(){
        //     @Override
        //     public void handle(ActionEvent arg0) {
        //         name.setText("");
                
        //     }
        // });

        button2.setOnAction((event) -> name.setText(""));

        box.getChildren().addAll(labels,field,button,button2);
        
        stage.setScene(new Scene(box));
        stage.setTitle("Your name");
        stage.show();;
        
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
