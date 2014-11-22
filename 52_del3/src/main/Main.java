package main;

import controller.GameController;

/**
 * Main Class
 * 
 * instansierer SpilController objektet, og kører Entry point metoden. Kan evt. tage imod argumenter fra cmd line.
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
