package BasicShapes;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ImageScreen extends Group {

	private Image image;
	private ImageView imageView;

	public ImageScreen(){
		this.setLayoutX(1920/2);
		this.setLayoutY(1080/2);
		try {
			image = new Image(new FileInputStream("assets/red.png"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		imageView = new ImageView(image);
		imageView.setX(300);
		imageView.setY(300);
		imageView.setFitWidth(200);
		imageView.setFitHeight(200);
		this.getChildren().addAll(imageView);
	}
}
