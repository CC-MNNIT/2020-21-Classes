package BasicShapes;

import javafx.scene.Group;
import javafx.scene.shape.Polygon;

public class PolygonScreen extends Group {
	private Polygon polygon;

	public PolygonScreen(){
		this.setLayoutX(0);
		this.setLayoutY(1080/2);
		polygon = new Polygon();
		polygon.getPoints().addAll(new Double[]{100.0, 100.0, 100.0, 200.0, 200.0, 200.0 });
		this.getChildren().addAll(polygon);
	}

}
