package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import boundary.MatadorGUI;
import controller.Field;
import controller.GameController;
import controller.Territory;
import entity.Board;
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
	private Board board = new Board();
	private Field fields[];

	
	
	@Test
	public void test() {
		playerList.getPlayer(0).setName("Test player");

		assertEquals(playerList.getPlayer(0).getName(), "Test player");
		
		player = playerList.getPlayer(0);
//		player.setName("TestPlayer");
		//Preconditions
//		player.setBalance(5000);
		
//		
//		fields = board.getFields();
//		
//		fields[1].landOnField(playerList.getPlayer(0));
		
		territory = (Territory) board.getField(2);
		
		territory.landOnField(playerList.getPlayer(0));	
		
		territory.buyField(playerList.getPlayer(0));		
				
		//Is player owner now ?
		assertEquals(territory.getOwner().getName(),"Test player");
		
		//Now we make the player dead 
		
		player.setDeath(true);
		
		assertEquals(player.getDeath(), true);
		
		board.resetOwnerShip(player);
		
		
		assertEquals(territory.getOwner(),null);
				
		//Postconditions
		
		
		
		
		
	}

}
