package main;
import controller.GameController;

/**
 * Main Class
 * 
 * instansierer SpilController objektet, og kører controllerens init(), Entry point.
 * 
 * @author 52
 *
 */
public class Main {

	public static void main(String[] args) {
		GameController spilController = new GameController(); 
		spilController.init();
	}
}
