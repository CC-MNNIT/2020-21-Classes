package Motions;

import javafx.application.Platform;

import java.util.Date;

public class Updater extends Thread {

	private double fps = 60;

	private GameObject gameObject;

	public Updater(GameObject gameObject){
		this.gameObject = gameObject;
	}

	public void run(){
		Date time = new Date();
		while(true){
			if(new Date().getTime()-time.getTime()>=1000.0/fps){


				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						gameObject.update();
					}
				});

				time = new Date();
			}
		}
	}

}
