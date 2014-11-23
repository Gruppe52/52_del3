package controller;

import boundary.MatadorGUI;
import entity.Board;
import entity.PlayerList;
//import entity.Player;
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
	Board board = new Board();
	PlayerList playerList = new PlayerList(2);
	/**
	 * Initialiserer spillet
	 */
	public void init() {
		matadorGUI.createBoard();
		numberOfPlayers = matadorGUI.getNumberOfPlayers();	//Gets input from user, for number of players
		PlayerList playerList = new PlayerList(numberOfPlayers);
		matadorGUI.askForPlayerNames(playerList);
		matadorGUI.addPlayers(numberOfPlayers, playerList);
		matadorGUI.setCars(playerList);
		int currentPlayer = 0;	//Used for giving turns to players in gameLoop
		gameLoop(currentPlayer, playerList);								//Goes to the gameLoop, where players throw dice and take turns etc. till game ends
//		Player s;		//Tjek CDIO1 eksempel for/om hvordan denne skal bruges senere...
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
			matadorGUI.moveCar(diceCup.getSum(), playerList.getPlayer(currentPlayer));	//Moves car for the current player who has just thrown dice
			currentPlayer = playerList.nextPlayer(currentPlayer); //Gives next player turn
			
		}
	}
}