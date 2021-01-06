package FlappyBird;

import Motions.GameObject;
import Motions.Updater;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Barrier extends Rectangle implements GameObject {

	private double x;
	private double y;
	private double width;
	private double height;
	private double speedx;

	private Pane parent;
	private Updater updater;

	public Barrier (double top,double height, Pane parent) {
		super();
		x = 1920;
		y = top;
		width = 100;
		this.height = height;
		speedx = -10;
		this.setFill(new Color(0.2,0.9,0.1,0.6));
		this.parent = parent;

		this.updater = new Updater(this);
		updater.start();

		parent.getChildren().add(this);

	}

	public void draw () {
		this.setLayoutX(x);
		this.setLayoutY(y);
		this.setWidth(width);
		this.setHeight(height);
	}


	@Override
	public boolean update() {
		this.x += speedx;

		if(this.x<-30){
			this.end();
			return false;
		}
		draw();
		return true;
	}

	private void end() {
		updater.interrupt();
		this.parent.getChildren().removeAll(this);
	}

	public String toString(){
		return "Barrier";
	}

}
