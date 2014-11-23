package entity;
/**
 * Klassen bruges til at lave et terningeobjekt, i dette tilfælde er det et tilfældigt tal mellem 1-6
 * @author 52
 *
 */

public class Dice {
	private int dice;
	private int diceside = 6;
	
	public int getDice() {
		return dice;
	}
	
	public int getDiceSides() {
		return diceside;
	}
	
	public int rollDice() {
		dice = (int)(Math.random()* diceside + 1);
		return dice;
	}
}
