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
	private boolean gameEnded = false;

	
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
		gameLoop(playerList);								//Goes to the gameLoop, where players throw dice and take turns etc. till game ends
//		Player s;		//Tjek CDIO1 eksempel for/om hvordan denne skal bruges senere...
	}
	/**
	 * The gameLoop, where players turn by turn throws dices, aqquire and lose wealth, till one person has won
	 * @param currentPlayer an integer that goes from 0 to playerList.getPlayers.length - used for giving each players turn.
	 */
	public void gameLoop(PlayerList playerList) {
		Player currentPlayer = new Player();
		Player winningPlayer = new Player();
		
		while(!checkIfPlayerHasWon(playerList)) {
			for (int i = 0; i < playerList.getPlayers().length; i++) {
				if(!playerList.getPlayer(i).getDeath()) {
					currentPlayer = playerList.getPlayer(i);
					
					//Gives diceThrow to currentPlayer
					matadorGUI.awaitDiceThrow(currentPlayer);
					//Randomizes the dices
					diceCup.throwDice();	
					//Sets the dices on the GUI
					matadorGUI.setDices(diceCup.getDice());
					
					//Placeholder variable for easier reading
					int diceSum = diceCup.getSum();
					
					currentPlayer.addCarField(diceSum);
					
					//Moves car for the current player who has just thrown dice
					matadorGUI.moveCar(currentPlayer);	
					
					//Placeholder variable for the current field the player is parked on 
//					int playerField = currentPlayer.getTotalDiceSum();
					//Going to Field controllers and action happens based on what field the player lands on
//					board.getField(playerField).landOnField(currentPlayer, matadorGUI);	 
					
				}
			}
//			currentTurnPlayer = playerList.getPlayer(currentPlayer);
			
//			checkIfPlayerIsDead(currentTurnPlayer);
			
			//Check if player can have turn, if they are dead they won't get a turn!
//			if(checkIfPlayerCanHaveTurn(currentTurnPlayer)) {
//				currentPlayer = playerList.nextPlayer(currentPlayer);
//				currentTurnPlayer = playerList.getPlayer(currentPlayer);
//			}

//			matadorGUI.awaitDiceThrow(currentPlayer, currentTurnPlayer);	
//			//Randomizes the dices
//			diceCup.throwDice();	
//			//Sets the dices on the GUI
//			matadorGUI.setDices(diceCup.getDice());
//			//Placeholder variable for easier reading
//			int diceSum = diceCup.getSum();
//			
//			//Moves car for the current player who has just thrown dice
//			matadorGUI.moveCar(diceSum, currentTurnPlayer);	
//			
//			//Placeholder variable for the current field the player is parked on 
//			int playerField = currentTurnPlayer.getTotalDiceSum();
//			//Going to Field controllers and action happens based on what field the player lands on
//			board.getField(playerField).landOnField(currentTurnPlayer, matadorGUI);	 	
//			
//			//Update player money on GUI
//			for (int i = 0; i < playerList.getPlayers().length; i++) {
//				matadorGUI.updateMoney(playerList.getPlayer(i));
//			}		
//			
//			//Checking if player has gone under 0 in account, if they have they are dead
//			if(checkIfPlayerIsDead(currentTurnPlayer)) {
//				matadorGUI.playerDied(currentTurnPlayer);
//			}
			
			//Gives next player turn
//			currentPlayer = playerList.nextPlayer(currentPlayer);			
		}
		gameEnded = true;
		if(gameEnded) {
			winningPlayer = findWinningPlayer(playerList);
			matadorGUI.playerWon(winningPlayer);
		}
	}
	
	public boolean getGameEnded() {
		return gameEnded;
	}
	
	//Checks if a player is dead according to game rules
	public boolean checkIfPlayerIsDead(Player player) {
		boolean x = false;
		if(player.getBalance() <= 0) {
			player.setDeath(true);
			x = true;
		}  return x;
	}
	
	//Returns player that has won!
	public Player findWinningPlayer(PlayerList playerlist) {
		Player winningPlayer = new Player();
		//We have already established that someone has won, but who we will find out now:
		for (int i = 0; i < playerList.getPlayers().length; i++) {
			if(playerList.getPlayer(i).getHasWon()) {
				winningPlayer = playerList.getPlayer(i);
			}
		}
		return winningPlayer;
	}
	
	//Check if someone among the playerList has won
	public boolean checkIfPlayerHasWon(PlayerList playerList2) {
		int x = 0;
		boolean hasSomeoneWon = false;
		//Collects number of dead players
		for (int i = 0; i < playerList2.getPlayers().length; i++) {
			if(playerList2.getPlayer(i).getDeath()) {
				x++;
			}
		//If there is only one player alive, he has won
		if(1 == (playerList2.getPlayers().length - x)) {
			hasSomeoneWon = true;
		}
	}
		return hasSomeoneWon;
	}
	
	public void resetOwner(Player player) {
		
	}
	
	public boolean checkIfPlayerCanHaveTurn(Player player) {
		boolean x = false;
		if(player.getDeath()) {
			x = false;
		} else if(!player.getDeath()) {
			x = true;
		}
		return x;
	}
}