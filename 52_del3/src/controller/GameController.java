package controller;
import java.io.File;
import boundary.MatadorGUI;
import entity.PlayerList;
import entity.Player;
import entity.DiceCup;
/**
 * SpilController som uddelegerer opgaver
 * @author 52
 */
public class GameController {
	/** Variable for number of players playing	 */
	private int numberOfPlayers;	
	/**Creating various objects to be used by the controller */
	MatadorGUI matadorGUI = new MatadorGUI();
	DiceCup diceCup = new DiceCup();
	
	/**
	 * Initialiserer spillet
	 */
	public void init() {
		matadorGUI.createBoard();
		numberOfPlayers = matadorGUI.getNumberOfPlayers();	//Gets input from user, for number of players
		PlayerList playerList = new PlayerList(numberOfPlayers);
		matadorGUI.askForPlayerNames(playerList, numberOfPlayers);
		matadorGUI.addPlayers(numberOfPlayers, playerList);
		int currentPlayer = 0;
		Player s;		//Tjek CDIO1 for hvordan denne skal bruges senere...
		gameLoop(currentPlayer, playerList);								//Goes to the gameLoop, where players throw dice and take turns etc. till game ends
	}
	/**
	 * The gameLoop, where players turn by turn throws dices, aqquire and lose wealth, till one person has won
	 * @param currentPlayer an integer that goes from 0 to playerList.getPlayers.length - used for giving each players turn.
	 */
	private void gameLoop(int currentPlayer, PlayerList playerList) {
		while(true) {
			matadorGUI.awaitDiceThrow(currentPlayer, playerList.getPlayer(currentPlayer));	//Gives diceThrow to currentPlayer
			diceCup.throwDice();	//Randomizes the dices
			int[] faceValues = diceCup.getDice();
			matadorGUI.setDices(faceValues);
			currentPlayer = playerList.nextPlayer(currentPlayer); //Gives next player turn			
		}
	}
}
//while(true) {
//	out.venterPaaSlag(pNr);
//	keyb.waitForEnter();
//	rafle.rollDice();
//	out.visSlag(rafle.getTerninger());
//	s = spillist.getSpiller(pNr);
