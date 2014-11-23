package entity;
/**
 * DiceCup klassen indeholder Dice objekter, i det her tilfælde 2 dice objekter
 * @author 52
 *
 */
public class DiceCup {
	private Dice[] dices;
	private final int numberOfDices = 2;	
	/**
	 * Constructs an Dice[] array with a specified number of dice objects
	 * @param numberOfDices number of dices you want in the game
	 */
	public DiceCup() {
		dices = new Dice[numberOfDices];
		for ( int i = 0; i < numberOfDices; i++)
			dices[i]=new Dice();
	} 	
	/**
	 * Throws/Randomizes a "numberOfDices" dices
	 */
	public void throwDice() {
		for (int i = 0; i < dices.length; i++) {
			dices[i].rollDice();
		}
	}	
	/**
	 * @return Returns a Dice[] object
	 */
	public int[] getDice() {
		int[] faceValues = new int[2];
		faceValues[0] = dices[0].getDice();
		faceValues[1] = dices[1].getDice();
		return faceValues;
	}
	/**
	 * Takes all dices in the dices array and returns the sum
	 * @return An integer of all dices eyes sum
	 */
	public int getSum() {
		int sum = 0;
		for (int i = 0; i < dices.length; i++) {
			sum += dices[i].getDice();			
		}
		return sum;
	}
}
