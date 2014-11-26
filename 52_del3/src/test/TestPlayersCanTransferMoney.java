package test;

import static org.junit.Assert.*;

import org.junit.Test;
import entity.Player;

public class TestPlayersCanTransferMoney {
	Player playerA = new Player();
	Player playerB = new Player();
	int transferAmount = 5000;
	int initialAmount = 10000;
	
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
