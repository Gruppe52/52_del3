

/**
 * Labor camp class
 * @author 52
 *
 */
package controller;

import entity.Player;

public class LaborCamp extends Ownable {
	int baseRent;
	public LaborCamp(int fieldNumber, String fieldName, int price, int baseRent) {
		super(fieldNumber, fieldName, price);
		this.baseRent = baseRent;
	}

	@Override
	public int getRent() {
		return baseRent;
	}

	@Override
	public void landOnField(Player player) {
		// TODO Auto-generated method stub
		
	}


	/* Der skal betales en afgift til ejeren. Beløbet bestemmes ved at slå 
      på terninger  og gange resultatet med 100. dette tal skal så ganges med laborcamps (baseRent? -stefan ) */
	
	
}
