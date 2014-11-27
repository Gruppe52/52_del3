package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import controller.GameController;
import controller.Ownable;
import controller.Territory;
import entity.Board;
import entity.Player;

public class TestIfPlayerCanOwnTerritory {
	
	private Board board = new Board();
	private Player player = new Player();
	private Territory territory = new Territory(1, "Test territory", 5000, 5000);
	private GameController gameController = new GameController();

	@Test
	public void test() {		
		
		//Preconditions		
		player.setBalance(5000);		
		territory.buyField(player);		
		//Postconditions
		assertEquals(territory.getOwner(),player);				
		
	}
	
	public Player getPlayer() {
		return player;
	}
	public Territory getTerritory() {
		return territory;
	}

}
