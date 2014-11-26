package test;

import static org.junit.Assert.*;
import controller.Territory;
import entity.Player;
import controller.GameController;
import entity.Board;
import entity.DiceCup;
import entity.Field;

import org.junit.Test;

public class TestIfPlayerCanOwnTerritory {

	@Test
	public void test() {
		Board board = new Board();
		Player player = new Player();
		Field territory;
		GameController gameController = new GameController();

		
		//Preconditions
		
		int diceSum = 5;
		territory = board.getField(diceSum);

		
		
		
		
		
	}

}
