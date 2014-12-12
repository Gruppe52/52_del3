

/**
 * Labor camp class
 * @author 52
 *
 */
package controller;

import boundary.MatadorGUI;
import entity.Player;

public class LaborCamp extends Ownable {
	int baseRent = 100;
	public LaborCamp(int fieldNumber, String fieldName, int price, int baseRent) {
		super(fieldNumber, fieldName, price);
		this.baseRent = 100;		//Had trouble figuring out how to accept the initial baseRent = 100 value ?
	}

	@Override
	public int getRent() {
		return baseRent;
	}

	@Override
	public void landOnField(Player player) {
		System.out.println("landed on laborcamp");		
	}

	@Override
	public void landOnField(Player player, MatadorGUI matadorGUI) {
		//Gets the dice	for player
		int dice = player.getDice();
		
		int totalRent = dice * baseRent;
		
		player.withdraw(totalRent);
		
		matadorGUI.landedOnLaborCamp(player);
		
	}	
}
