package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import controller.GameController;
import entity.Player;
import entity.PlayerList;

public class FindWinningPlayer {

	@Test
	public void test() {
		//Finds winning player in playerList
		Player winningPlayer = new Player();
		PlayerList playerList = new PlayerList(2);
		GameController gameController = new GameController();
		
		playerList.getPlayer(0).setName("Stefan");
		playerList.getPlayer(1).setName("Jens");
		
		
		//Making only one
		playerList.getPlayer(0).setDeath(false);
		playerList.getPlayer(1).setDeath(true);
		
		//Making one a winner, not everyone's a winner
		playerList.setWinningPlayer();
		
		
		winningPlayer = playerList.getWinningPlayer();
		
		assertEquals(playerList.getPlayer(0),winningPlayer);
		
		System.out.println("Winner " + winningPlayer.getName());
		
		
	}

}
