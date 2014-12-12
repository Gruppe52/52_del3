package test;

import org.junit.Test;

import entity.PlayerList;

public class FindWinningPlayer {

	@Test
	public void test() {
		//Finds winning player in playerList
		
		PlayerList playerList = new PlayerList(2);
		
		playerList.getPlayer(0).setName("Stefan");
		playerList.getPlayer(1).setName("Jens");
		
		
		//Making only one
		playerList.getPlayer(0).setDeath(false);
		playerList.getPlayer(1).setDeath(true);
		
	}

}
