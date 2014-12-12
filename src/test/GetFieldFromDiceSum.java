package test;

import org.junit.Test;

import entity.Board;
import entity.DiceCup;
import entity.Player;

public class GetFieldFromDiceSum {

	@Test
	public void test() {
		Board board = new Board();
		DiceCup diceCup = new DiceCup();
		Player testPlayer = new Player();
		
		diceCup.throwDice();
		
		board.getField(diceCup.getSum()).landOnField(testPlayer);
		
		
		
		
		
	}

}
