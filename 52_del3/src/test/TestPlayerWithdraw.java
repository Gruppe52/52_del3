package test;

import static org.junit.Assert.*;
import entity.Player;


import org.junit.Test;

public class TestPlayerWithdraw {
	
	
	private Player player = new Player();
	
	
	@Test
	public void test() {
		//Preconditions	
		int initialAmount = 10000;
		int withdrawAmount = 5000;
		player.setBalance(initialAmount);
		assertEquals(player.getBalance(), initialAmount);

		//Test
		player.withdraw(withdrawAmount);
		
		//Postconditions
		assertEquals(player.getBalance(),(initialAmount-withdrawAmount));
		
		
	}

}
