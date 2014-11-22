package controller;
import java.io.File;

import boundary.MatadorGUI;
import entity.PlayerList;
/**
 * SpilController som uddelegerer opgaver
 * @author 52
 *
 */
public class GameController {
	/** Variable for number of players playing	 */
	private int numberOfPlayers;
	
	/**Creating various objects to be used by the controller */
	MatadorGUI matadorGUI = new MatadorGUI();
	
	
	/**
	 * Initialiserer spillet
	 */
	public void init() {
		matadorGUI.createBoard();
		numberOfPlayers = matadorGUI.getNumberOfPlayers();	//Gets input from user, for number of players
		PlayerList playerList = new PlayerList(numberOfPlayers);
		matadorGUI.askForPlayerNames(playerList, numberOfPlayers);
		matadorGUI.addPlayers(numberOfPlayers, playerList);
		matadorGUI.setCars();
	}	
	/**
	 * Not sure if this will get used
	 */
}
