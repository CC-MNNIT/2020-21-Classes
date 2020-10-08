package Motions;

import javafx.scene.Group;
import javafx.scene.layout.Pane;

public class BounceBallScreen extends Pane {
	public BounceBallScreen(){
		setLayoutX(1920/2);
		setLayoutY(0);
		setPrefSize(1920/2,1080);
		this.setOnMouseClicked(event -> {
			new Ball(event.getX(),event.getY(),this);
		});
	}
}
