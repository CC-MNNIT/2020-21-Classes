package BasicShapes;

import javafx.scene.Group;
import javafx.scene.shape.Rectangle;

public class RectangleScreen extends Group {

	private Rectangle r;

	public RectangleScreen(){
		this.setLayoutX(1920/2);
		this.setLayoutY(0);
		r = new Rectangle();
		r.setX(50);
		r.setY(50);
		r.setWidth(200);
		r.setHeight(100);
		r.setArcWidth(20);
		r.setArcHeight(20);
		this.getChildren().addAll(r);
	}

}
