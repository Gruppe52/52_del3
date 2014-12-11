package test;

import static org.junit.Assert.*;
import entity.PlayerList;
import controller.GameController;
import entity.Player;

import org.junit.Test;

public class DoAllPlayersGetTurnTest2 {

	@Test
	public void test() {
		//Create array of 2 players
		PlayerList playerList = new PlayerList(2);
		GameController gameController = new GameController();
		Player currentPlayer = new Player();
		
		//Test if living players get turn
		for (int i = 0; i < playerList.getPlayers().length; i++) {
			if(!playerList.getPlayer(i).getDeath()) {
				currentPlayer = playerList.getPlayer(i);
			}
			
		//PostConditions
			assertEquals(playerList.getPlayer(i), currentPlayer);
		//Since both players are alive, they should both be given a turn
		}
		
		
		
		
		
	}

}
