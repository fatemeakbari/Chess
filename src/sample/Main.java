package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import sample.background.CustomControl;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        StackPane root = new StackPane();
        root.getChildren().add(new CustomControl());

        primaryStage.setScene(new Scene(root,800,800));
        primaryStage.setTitle("chess");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
