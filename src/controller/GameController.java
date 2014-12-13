package controller;

import boundary.MatadorGUI;
import entity.Board;
import entity.Field;
import entity.PlayerList;
import entity.Player;
import entity.DiceCup;
/**
 * GameController for monopoly like game
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
	 * Initializes game
	 * Creates board, playerList object with numberOfPlayers, ask's for names, and sets cars on board
	 * Then entering gameLoop
	 */
	public void init() {
		
		matadorGUI.createBoard();
		numberOfPlayers = matadorGUI.getNumberOfPlayers();	//Gets input from user, for number of players
		PlayerList playerList = new PlayerList(numberOfPlayers);
		matadorGUI.askForPlayerNames(playerList);
		matadorGUI.addPlayers(numberOfPlayers, playerList);
		matadorGUI.setCars(playerList);
		gameLoop(playerList);								//Goes to the gameLoop, where players throw dice and take turns etc. till game ends
		
	}
	/**
	 * The gameLoop, where players turn by turn throws dices, aqquire and lose wealth, till one person has won
	 * @param PlayerList playerList is an array type object containing a list of player objects
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
					
					//Sets the players carField variable, used for getting the car around on board
					currentPlayer.addCarField(diceSum);	
					
					//Sets the players current diceThrow, used by LaborCamp to find fee
					currentPlayer.setDice(diceSum);
					
					//Moves car for the current player who has just thrown dice
					matadorGUI.moveCar(currentPlayer);	
					
					//LandOnField method handles if player can buy property, pays taxes etc, for specific field he lands on
					board.getField(currentPlayer.getCarField()).landOnField(currentPlayer, matadorGUI);
					
					//Update players money after LandOnField method has been called (usually LandOnField messes with accounts money)					
					matadorGUI.updateMoney(playerList);
					
					//Check if a player has died - could be nicer without gui pass perhaps
					//Maybe something like if(playerHasDied) { matadorGUI.playerdied(player)				
					playerList.checkIfPlayerIsDead(matadorGUI);
					
					
				}
			}		
		}
		gameEnded = true;	//Used for testing purposes
		playerList.setWinningPlayer();
		winningPlayer = playerList.getWinningPlayer();
		matadorGUI.playerWon(winningPlayer);	
	}
	
	/**
	 * Used for testing purposes
	 * @return Returns boolean variable true if the game has ended.
	 */
	public boolean getGameEnded() {
		return gameEnded;
	}
	
	
	/**
	 * Checks if a player is dead according to game rules
	 * @param playerList
	 * @param matadorGUI
	 */
	@Deprecated
	public void checkIfPlayerIsDead(PlayerList playerList, MatadorGUI matadorGUI) {		
	for (int i = 0; i < playerList.getPlayers().length; i++) {
		if(playerList.getPlayer(i).getBalance() <= 0) {
			playerList.getPlayer(i).setDeath(true);
			matadorGUI.playerDied(playerList.getPlayer(i));
			}
		}
	}
	/**
	 * Finds the player object that has won in the playerList.
	 * Has been moved to PlayerList class, according to information expert principle
	 * @param playerlist
	 * @return winning player object
	 */
	@Deprecated
	public Player findWinningPlayer(PlayerList playerlist) {
		Player winningPlayer = new Player();
		//We have already established that someone has won, meaning only one player is alive
		for (int i = 0; i < playerList.getPlayers().length; i++) {
			System.out.println(i);
			System.out.println(playerList.getPlayers().length);
			if(playerList.getPlayer(i).getHasWon()) {
				System.out.println("Nogen har vundet");
				winningPlayer = playerList.getPlayer(i);
			}
		}
		return winningPlayer;
	}
	
	/**
	 * This method finds one player who has won, and sets their hasWon boolean variable to true
	 * @param playerList
	 */
	public void setPlayerHasWon(PlayerList playerList) {		
		for (int i = 0; i < playerList.getPlayers().length; i++) {
			if(playerList.getPlayer(i).getDeath() == false) {
				playerList.getPlayer(i).setHasWon(true);
			}
		}
	}
	/**
	 * Check's if there is only one player left alive in the playerlist
	 * @param playerList2
	 * @return
	 */
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
	
	@Deprecated
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