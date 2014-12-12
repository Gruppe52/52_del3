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
		Fleet field1;
		Fleet field2;
		Board board = new Board();
		PlayerList playerList = new PlayerList(2);
		Player buyingPlayer;
		Player payingPlayer;
		
		//Making two player variables used for testing, one buys fleet, one pays rent for it
		buyingPlayer = playerList.getPlayer(0);
		payingPlayer = playerList.getPlayer(1);		
		
		//Making the fleet object based on field 19, which is a fleet object in the board list
		field1 = (Fleet) board.getField(19);
	
			
		//Making sure player has enough money to buy a fleet field (price is 4000)
		buyingPlayer.setBalance(field1.getPrice());
		
		//Player buys field
		field1.buyField(buyingPlayer);
		
		//Make sure the player is owner now		
		assertEquals(field1.getOwner(),buyingPlayer);
		
		//Make sure that amount is 500
		assertEquals(field1.getRent(),500);
		
		//Setting amount for payingPlayer
		payingPlayer.setBalance(field1.getRent());
		
		//payingPlayer is supposed to pay 500, since buyingPlayer owns 1 fleet field
		field1.landOnField(payingPlayer);
		
		//assert that payingPlayer now has 0 on account, since we started with the player only having the rent amount on account
		assertEquals(payingPlayer.getBalance(),0);
		
		
		//Now testing if payingPlayer must also pay 1000 if buyingPlayer owns 2 fleet fields!
		
		//Setting field2 as number 20 from board list..
		field2 = (Fleet) board.getField(20);
		
		//Setting buyingPlayers account balance, so he can buy the field
		buyingPlayer.setBalance(field2.getPrice());

		//Player buys field
		field2.buyField(buyingPlayer);
		
		//Making sure player is now owner of two fleet fields
		assertEquals(field1.getOwner(),buyingPlayer);
		assertEquals(field2.getOwner(),buyingPlayer);
		
		//Making sure that getRent now is 1000
		assertEquals(field1.getRent(),1000);
		
		
		//Last test, does payingPlayer have to pay 2000 if buyingPlayer owns 3 fleets ?
		
		//Field3 is now number 21 from board, a fleet object
		Fleet field3 = (Fleet) board.getField(21);
		
		//Setting buyingPlayers account balance
		buyingPlayer.setBalance(field3.getPrice());
		
		//Player buys field
		field3.buyField(buyingPlayer);
		
		//Making sure player is now owner of 3 fleet fields!
		assertEquals(field1.getOwner(),buyingPlayer);
		assertEquals(field2.getOwner(),buyingPlayer);
		assertEquals(field3.getOwner(),buyingPlayer);
		
		//Making sure that getRent is now 2000!
		assertEquals(field1.getRent(),2000);
		assertEquals(field2.getRent(),2000);
		assertEquals(field3.getRent(),2000);
				
		
		
	}

}
