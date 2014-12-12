package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import controller.Fleet;
import entity.Board;
import entity.Player;
import entity.PlayerList;

public class TestFleet {

	@Test
	public void test() {
		//Test fleet class functionality!
		
		//Fleet classes are on field[19] to field[22]
		Fleet field;
		Board board = new Board();
		PlayerList playerList = new PlayerList(2);
		Player buyingPlayer;
		Player payingPlayer;
		
		//Making two player variables used for testing, one buys fleet, one pays rent for it
		buyingPlayer = playerList.getPlayer(0);
		payingPlayer = playerList.getPlayer(1);		
		
		//Making the fleet object based on field 19, which is a fleet object in the board list
		field = (Fleet) board.getField(19);
	
			
		//Making sure player has enough money to buy a fleet field (price is 4000)
		buyingPlayer.setBalance(field.getPrice());
		
		//Player buys field
		field.buyField(buyingPlayer);
		
		//Make sure the player is owner now		
		assertEquals(field.getOwner(),buyingPlayer);
		
		//Make sure that amount is 500
		assertEquals(field.getRent(),500);
		
		//Setting amount for payingPlayer
		payingPlayer.setBalance(field.getRent());
		
		//payingPlayer is supposed to pay 500, since buyingPlayer owns 1 fleet field
		field.landOnField(payingPlayer);
		
		//assert that payingPlayer now has 0 on account, since we started with the player only having the rent amount on account
		assertEquals(payingPlayer.getBalance(),0);
		
				
		
		
	}

}
