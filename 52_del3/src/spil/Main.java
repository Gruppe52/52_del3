package spil;
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
		System.out.println("Test");
		SpilController spilController = new SpilController(); //Kunne have argumenter for hvor mange spillere der er i spillet her.
		spilController.init();
	}

}
