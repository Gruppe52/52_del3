package controller;

import boundary.MatadorGUI;
import entity.Board;
import entity.Field;
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
	Board board = new Board();
	PlayerList playerList = new PlayerList(2);	//The constructor should ideally not be receiving number of players, as we find the number later in init()

	
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
		Player currentTurnPlayer = new Player();
		while(true) {					
			currentTurnPlayer = playerList.getPlayer(currentPlayer);
			
			//Check if player is dead, if they are dead they won't get a turn!
			if(currentTurnPlayer.getDeath()) {
				//Gives next player turn
				for (int i = 0; i < playerList.getPlayers().length; i++) {
					currentPlayer = playerList.nextPlayer(currentPlayer);
					currentTurnPlayer = playerList.getPlayer(currentPlayer);
				}				
			}			
			//Gives diceThrow to currentPlayer
			matadorGUI.awaitDiceThrow(currentPlayer, currentTurnPlayer);	
			//Randomizes the dices
			diceCup.throwDice();	
			//Sets the dices on the GUI
			matadorGUI.setDices(diceCup.getDice());
			//Placeholder variable for easier reading
			int diceSum = diceCup.getSum();
			
			//Moves car for the current player who has just thrown dice
			matadorGUI.moveCar(diceSum, currentTurnPlayer);	
			
			//Placeholder variable for the current field the player is parked on 
			int playerField = currentTurnPlayer.getTotalDiceSum();
			//Going to Field controllers and action happens based on what field the player lands on
			board.getField(playerField).landOnField(currentTurnPlayer, matadorGUI);	 	
			
			//Update player money on GUI
			for (int i = 0; i < playerList.getPlayers().length; i++) {
				matadorGUI.updateMoney(playerList.getPlayer(i));
			}			
			
			//Checking if player has gone under 0 in account, if they have they are dead
			if (currentTurnPlayer.getBalance() <= 0) {
				currentTurnPlayer.setDeath(true);
				matadorGUI.playerDied(currentTurnPlayer);
				
			}		
			
			//Gives next player turn
			currentPlayer = playerList.nextPlayer(currentPlayer);			
		}
	}
}