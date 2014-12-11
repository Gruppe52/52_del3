/**
 * Fleet class
 * @author 52
 *
 */
package controller;
import entity.Player;
public class Fleet extends Ownable {
	private int RENT_1 = 500;
	private int RENT_2 = 1000;
	private int RENT_3 = 2000;
	private int RENT_4 = 4000;
	
	public Fleet(int fieldNumber, String fieldName, int price) {
		super(fieldNumber, fieldName, price);
	}


	// der skal betales en afgift til ejeren.
	// beløbet bestemmes ud fra antallet af Fleets med den samme ejer.
	
	

/**
 * Returns randomized rent between among rent variables
 */
	public int getRent() {
		int rent = 0;
		return rent;		
	}

	@Override
	public void landOnField(Player player) {
		System.out.println(player.getName() + " has landed on fleet");
	}	

}
