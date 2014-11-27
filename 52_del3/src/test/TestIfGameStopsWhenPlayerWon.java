package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import controller.GameController;
import entity.PlayerList;

public class TestIfGameStopsWhenPlayerWon {
	private PlayerList playerList;
	private GameController gameController = new GameController();
	private TestIfPlayerCanWin testIfPlayerCanWin = new TestIfPlayerCanWin();
	
	@Test
	public void test() {
		//Preconditions
		
		//Make sure that only one player has won, this test will
		testIfPlayerCanWin.test();
		//Retrieving the playerList with only one winner
		playerList = testIfPlayerCanWin.getPlayerList();
		
		//Test
		
		//Warning! Can get stuck at this loop, if the test fails!
		gameController.gameLoop(0, playerList);	// 0 is just the index of starting player from playerList array
		
		//Postcondtions		
		assertEquals(gameController.getGameEnded(),true);
		
	}

}
