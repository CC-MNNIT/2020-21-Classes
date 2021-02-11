package Motions;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = new Group();
        primaryStage.setTitle("Graphics Tutorial");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.setFullScreen(true);
        primaryStage.setFullScreenExitHint("Press Escape to Quit");
        primaryStage.setResizable(true);
        primaryStage.show();
        root.getChildren().addAll(new BubbleScreen(),new BounceBallScreen());
    }


    public static void main(String[] args) {
        launch(args);
    }
}
