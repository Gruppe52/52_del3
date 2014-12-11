package test;

import static org.junit.Assert.*;

import org.junit.Test;
import entity.Player;

public class TestPlayersCanTransferMoney {
	private Player playerA = new Player();
	private Player playerB = new Player();
	private int transferAmount = 5000;
	private int initialAmount = 10000;
	
	@Test
	public void test() {
		//Precondtions
		playerA.setBalance(initialAmount);
		playerB.setBalance(initialAmount);
		assertEquals(playerA.getBalance(),initialAmount);
		assertEquals(playerB.getBalance(),initialAmount);
		
		//Test
		playerA.transfer(transferAmount, playerB);
		
		//Postconditions
		assertEquals(playerA.getBalance(),(initialAmount-transferAmount));
		assertEquals(playerB.getBalance(),(initialAmount+transferAmount));
		
	}

}
