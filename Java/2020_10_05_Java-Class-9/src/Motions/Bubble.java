package Motions;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class Bubble extends Circle implements GameObject{

	private double centrex;
	private double centrey;
    private double radius;
	private double maxRadius;
    private double speed;

    private Pane parent;
	private Updater updater;

	public Bubble(double centrex, double centrey, Pane parent) {
		super(centrex,centrey,0);
		this.centrex = centrex;
		this.centrey = centrey;
		this.radius = 0;
		this.maxRadius = 100;
		this.speed = 0.5;
		this.parent = parent;

		this.parent.getChildren().addAll(this);

		updater = new Updater(this);
		updater.start();

	}

	public boolean update(){
    	radius += speed;
		this.setRadius(radius);
    	if(radius>=maxRadius){
    		burst();
    		return false;
	    }
    	return true;
    }

	private void burst() {
		updater.interrupt();
		this.parent.getChildren().removeAll(this);
	}


}
