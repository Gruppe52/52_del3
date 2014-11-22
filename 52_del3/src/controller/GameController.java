package controller;
import boundary.MatadorGUI;
import entity.PlayerList;
/**
 * SpilController som uddelegerer opgaver
 * @author 52
 *
 */
public class GameController {
	private int numberOfPlayers;
	MatadorGUI matadorGUI = new MatadorGUI();
	PlayerList playerList = new PlayerList(numberOfPlayers);
	/**
	 * Initialiserer spillet
	 */
	public void init() {
		matadorGUI.gameStarter();
		matadorGUI.addPlayers(numberOfPlayers, playerList);
		playerList.getPlayer(2).getName();
	}	
	/**
	 * Not sure if this will get used
	 */
	public void askForNumberOfPlayers() {
		matadorGUI.askForNumberOfPlayers();
	}
}
