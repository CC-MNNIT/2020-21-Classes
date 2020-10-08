package BasicShapes;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CircleScreen extends Group {

	private Circle circle;

	public CircleScreen(){
		this.setLayoutX(0);
		this.setLayoutY(0);

		Group group = new Group();
		group.setLayoutX(10);
		group.setLayoutY(10);

		circle = new Circle();
		circle.setCenterX(100);
		circle.setCenterY(100);
		circle.setRadius(50);
		circle.setFill(new Color(0.2,0.3,0.800,0.5));

		group.getChildren().addAll(circle);

		Image image = null;
		try {
			image = new Image(new FileInputStream("assets/red.png"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		ImageView imageView = new ImageView(image);
		imageView.setX(300);
		imageView.setY(300);
		imageView.setFitWidth(200);
		imageView.setFitHeight(200);

		group.getChildren().add(imageView);

		this.getChildren().addAll(group);
	}

}
