package FlappyBird;

import Motions.GameObject;
import Motions.Updater;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

import java.util.Random;

public class Player extends Circle implements GameObject {

	private double centrex;
	private double centrey;
	private double radius;
	private double speedx;
	private double speedy;
	private double accx;
	private double accy;
	private double maxSpeed;

	private Pane parent;
	private Updater updater;

	public Player(Pane parent) {
		super(100,100,30);
		this.centrex = 100;
		this.centrey = 100;
		this.radius = 30;
		this.speedx = 0;
		this.speedy = 0;
		this.accx = 0;
		this.accy = 0.5;
		this.parent = parent;
		this.maxSpeed = -30;
		this.parent.getChildren().add(this);

		updater = new Updater(this);
		updater.start();
	}

	public boolean update(){
		this.speedy += this.accy;
		this.speedx += this.accx;
		this.centrex += this.speedx;
		this.centrey += this.speedy;
		if (centrey>=parent.getHeight()-radius || centrey<radius){
			collideVertical();
		}
		if(collisionCheck()){
			((GamePannel)parent).gameOver();
		}
		draw();
		return true;
	}

	private void collideVertical() {
		this.speedy = -1*this.speedy;
	}

	public void destroy() {
		this.updater.interrupt();
		this.parent.getChildren().removeAll(this);
	}

	private void draw(){
		this.setCenterX(centrex);
		this.setCenterY(centrey);
	}

	public void jump(){
		this.accy = 0.5;
		this.speedy -= 20;
		if (this.speedy<=this.maxSpeed){
			this.speedy = this.maxSpeed;
		}
	}

	public boolean collisionCheck(){

		for (Node X : parent.getChildren()){
			if (X.toString().equals("Barrier")){
				Shape x = (Shape)X;
				if(x.getBoundsInParent().intersects(this.getBoundsInParent())){
//					System.out.println("Collided");
					return true;
				}
			}
		}

		return false;
	}

}
