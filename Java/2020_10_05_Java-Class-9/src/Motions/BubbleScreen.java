package Motions;

import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.Pane;

public class BubbleScreen extends Pane {

	public BubbleScreen(){
		setLayoutX(0);
		setLayoutY(0);
		setPrefSize(1920/2,1080);

		this.setOnMouseClicked(event -> {

			new Bubble(event.getX(),event.getY(),this);

		});
	}

}
