package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import controller.GameController;
import entity.PlayerList;

public class TestIfPlayerLosesTurnWhenDead {
	TestIfPlayerCanWin testIfPlayerCanWin = new TestIfPlayerCanWin();
	PlayerList playerList;
	int indexOfWinningPlayer;
//	int numberOfPlayers = testIfPlayerCanWin.getNumberOfPlayers();		//not needed because we can just use .length on playerList array
	GameController gameController = new GameController();
	@Test
	public void test() {
		
		//Preconditions
		
		//Making sure we have one winner and some losers
		testIfPlayerCanWin.test();
		playerList = testIfPlayerCanWin.getPlayerList();
		indexOfWinningPlayer = testIfPlayerCanWin.getIndexOfWinningPlayer();
		
		
		//Test
		
		for (int i = 0; i < playerList.getPlayers().length; i++) {
			if(i != indexOfWinningPlayer) {
				assertEquals(gameController.checkIfPlayerCanHaveTurn(playerList.getPlayer(i)), false);
				assertEquals(gameController.checkIfPlayerIsDead(playerList.getPlayer(i)),true);
			}
		}
		
		
		
		
	}

}
