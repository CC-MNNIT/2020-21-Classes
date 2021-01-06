package FlappyBird;

import BasicShapes.CircleScreen;
import BasicShapes.ImageScreen;
import BasicShapes.PolygonScreen;
import BasicShapes.RectangleScreen;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane root = new Pane();
        primaryStage.setTitle("Graphics Tutorial");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.setFullScreen(true);
        primaryStage.setFullScreenExitHint("Press Escape to Quit");
        primaryStage.setResizable(true);
        primaryStage.show();

        root.setPrefSize(1920,1080);

        Text title = new Text();
        title.setText("Crazy Jumper");
        title.setLayoutX(1920/2-200);
        title.setLayoutY(80);
        title.setFont(new Font(80));
        root.getChildren().addAll(title);

        root.getChildren().addAll(new GamePannel());
    }


    public static void main(String[] args) {
        launch(args);
    }
}
