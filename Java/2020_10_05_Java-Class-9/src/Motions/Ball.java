package Motions;


import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

import java.awt.*;
import java.util.Random;

public class Ball extends Circle implements GameObject {

	private double centrex;
	private double centrey;
	private double radius;
	private double speedx;
	private double speedy;
	private double accx;
	private double accy;
	private double bottom;

	private Pane parent;
	private Updater updater;

	public Ball(double centrex,double centrey,Pane parent) {
		super(centrex,centrey,0);
		Random r = new Random();
		this.centrex = centrex;
		this.centrey = centrey;
		this.radius = 20 + r.nextDouble()*20;
		this.speedx = r.nextDouble();
		this.speedy = r.nextDouble();
		this.accx = 0.2;
		this.accy = 0.5;
		this.bottom = 1080;
		this.parent = parent;
		this.setRadius(radius);
		this.parent.getChildren().add(this);

		updater = new Updater(this);
		updater.start();
	}

	public boolean update(){
		this.speedy += this.accy;
		this.speedx += this.accx;
		this.centrex += this.speedx;
		this.centrey += this.speedy;
		if (centrey>=bottom-radius){
			collideVertical();
		}

		if(centrex>=1900 || centrex<=1920/2){
			collideHorizontal();
		}
		draw();
		return true;
	}

	private void collideVertical() {
		this.centrey -= 20;
		this.speedy = -1*this.speedy;
	}

	private void collideHorizontal() {
		this.speedx = -1*this.speedx;
	}

	private void burst() {
		updater.interrupt();
		this.parent.getChildren().removeAll(this);
	}

	private void draw(){
		this.setCenterX(centrex);
		this.setCenterY(centrey);
	}

}
