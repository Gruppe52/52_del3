package test;

import static org.junit.Assert.*;
import entity.Player;
import controller.GameController;

import org.junit.Test;

public class TestIfPlayerCanDie {

	private Player player = new Player();
	private GameController gameController = new GameController();
	
	@Test
	public void test() {
		//Preconditions
		player.setBalance(0);
		assertEquals(player.getBalance(),0);
		assertEquals(player.getDeath(),false);	//Death is only set to true after gamelogic from gameController has been used
		
		//Test
		gameController.checkIfPlayerIsDead(player);
		
		//Postconditions
		assertEquals(player.getDeath(),true);
	}

}
