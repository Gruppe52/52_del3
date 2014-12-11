package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import boundary.MatadorGUI;
import controller.GameController;
import entity.DiceCup;
import entity.Player;
import entity.PlayerList;

public class PlayerMovementTest {

	@Test
	public void test() {
		PlayerList playerList = new PlayerList(1);
		Player testPlayer = new Player();
		GameController gameController = new GameController();
		DiceCup diceCup = new DiceCup();
		MatadorGUI matadorGUI = new MatadorGUI();
		
		testPlayer = playerList.getPlayer(0);
		
		//Test if the players movements fits with dice's		
		assertEquals(testPlayer.getCarField(),0);
		
		testPlayer.addCarField(23);
		
		assertEquals(testPlayer.getCarField(),1);
		
		
		
	}

}
