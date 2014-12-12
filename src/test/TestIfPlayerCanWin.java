package test;

import static org.junit.Assert.*;

import org.junit.Test;

import entity.Player;
import entity.PlayerList;
import controller.GameController;

public class TestIfPlayerCanWin {

	private GameController gameController = new GameController();
	private int numberOfPlayers = 3;
	private PlayerList playerList = new PlayerList(numberOfPlayers);
	private int winningBorderAmount = 1;
	private int losingAmount = 0;
	private int indexOfWinningPlayer = 0;
	
	@Test
	public void test() {
		/**Preconditions**/
		
		//Is two players created ?
		assertEquals(playerList.getPlayers().length,numberOfPlayers);
		
		//Puts all players balance at zero, except for one player
		for (int i = 0; i < playerList.getPlayers().length; i++) {
			//Makes sure we have one winner
			if(i == indexOfWinningPlayer) {
				playerList.getPlayer(i).setBalance(winningBorderAmount);
			//And everyone else a loser
			} else {				
				playerList.getPlayer(i).setBalance(losingAmount);
			}
		}
		
		//Making sure players balance's are as expected
		for (int i = 0; i < playerList.getPlayers().length; i++) {
			if(i == indexOfWinningPlayer) {
				assertEquals(playerList.getPlayer(i).getBalance(),winningBorderAmount);
			} else {				//Makes sure we have one winner
				assertEquals(playerList.getPlayer(i).getBalance(),losingAmount);
			}
		}
		
		//Sets players death
		gameController.checkIfPlayerIsDead(playerList);

		
		
		/***Test***/		
		//Postcondition
		assertEquals(gameController.checkIfPlayerHasWon(playerList),true);	
		
		assertEquals(playerList.getPlayer(0).getDeath(),false);
		assertEquals(playerList.getPlayer(1).getDeath(),true);
		assertEquals(playerList.getPlayer(2).getDeath(),true);
		
		
		gameController.setPlayerHasWon(playerList);
		
		assertEquals(playerList.getPlayer(0).getDeath(),false);
		
		assertEquals(gameController.testForLoops(),10);
		
		//What ??
		gameController.findWinningPlayer(playerList);
//		assertEquals(gameController.findWinningPlayer(playerList),playerList.getPlayer(0));
		
//		assertEquals(gameController.findWinningPlayer(playerList),playerList.getPlayer(0));
	}
	
	public PlayerList getPlayerList() {
		return playerList;
	}
	
	public int getIndexOfWinningPlayer() {
		return indexOfWinningPlayer;
	}
@Deprecated
	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}
}
