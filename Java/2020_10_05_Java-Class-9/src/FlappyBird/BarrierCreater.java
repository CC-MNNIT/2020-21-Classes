package FlappyBird;

import Motions.GameObject;
import Motions.Updater;
import javafx.scene.layout.Pane;

import java.util.Random;

public class BarrierCreater implements GameObject {

	private Pane game;
	private int frame;
	private int obstacleFrame;
	private Random random;
	private double gap;
	private Updater updater;

	public BarrierCreater (Pane game){
		this.game = game;
		this.frame = 0;
		this.obstacleFrame = 300;
		this.random = new Random();
		this.updater = new Updater(this);
		this.updater.start();
		this.gap = 500;
	}

	@Override
	public boolean update() {
		frame++;
		frame %= obstacleFrame;
		if (frame==0){
			double x = random.nextDouble()*(game.getHeight()-gap);
			new Barrier(0,x,game);
			new Barrier(x+gap,game.getHeight()-(x+gap),game);
		}

		return true;
	}

	public void destroy(){
		this.updater.interrupt();
	}

}
