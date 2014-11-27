package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import boundary.MatadorGUI;
import controller.GameController;
import controller.Territory;
import entity.Player;
import entity.PlayerList;

public class TestIfPlayerLosesPropertyWhenDead {
	
//	private Player player;
//	private Territory territory;
	private PlayerList playerList = new PlayerList(1);
	private Territory territory = new Territory(0, "Test", 500, 5000);
	private GameController gameController = new GameController();
	private MatadorGUI matadorGUI = new MatadorGUI();
	private Player player;
	
	
	@Test
	public void test() {
		playerList.getPlayer(0).setName("Test player");
		player = playerList.getPlayer(0);
//		player.setName("TestPlayer");
		//Preconditions
//		player.setBalance(5000);
		territory.buyField(playerList.getPlayer(0));
		
		//Is player owner now ?
		assertEquals(territory.getOwner(),playerList.getPlayer(0));
		
		//Now we make the player dead by game rules
		player.setBalance(0);
		
		matadorGUI.playerDied(playerList.getPlayer(0));
		
		//Test	
		
		//Run gameLoop once, which should check if players are dead, and reset property
		gameController.gameLoop(0, playerList);
		
		System.out.println(player.getDeath());
				
		assertEquals(player.getDeath(),true);


		
		//Postconditions
		
		
		
		
		
	}

}
