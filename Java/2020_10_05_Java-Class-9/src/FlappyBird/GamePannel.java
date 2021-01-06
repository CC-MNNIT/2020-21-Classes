package FlappyBird;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class GamePannel extends Pane {

	private Rectangle background;
	private Player player;
	private BarrierCreater barrierCreater;

	public GamePannel(){
		this.setPrefSize(1920,1000);
		this.setLayoutX(0);
		this.setLayoutY(80);

		background = new Rectangle();
		background.setWidth(1920);
		background.setHeight(1000);
		background.setLayoutX(0);
		background.setLayoutY(0);
		background.setFill(new Color(0.5,0.6,0.5,0.9));
		this.getChildren().addAll(background);

		player = new Player(this);
		barrierCreater = new BarrierCreater(this);

		this.setOnMouseClicked(event -> {
			player.jump();
		});

	}

	public void gameOver() {
		player.destroy();
		barrierCreater.destroy();
		Text t = new Text("Game Over");
		t.setFont(new Font(150));
		t.setLayoutX(500);
		t.setLayoutY(500);
		this.getChildren().add(t);
//		System.out.println("Game Over");
	}

}
