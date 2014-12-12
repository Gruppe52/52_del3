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
	
	


	public int getRent() {
		int rent = 0;
		switch(super.getOwner().getFleetOwned()) {
		case 1: rent = RENT_1;
				break;
		case 2: rent = RENT_2;
				break;
		case 3: rent = RENT_3;
				break;
		case 4: rent = RENT_4;
				break;
		};
		return rent;		
	}
	@Override
	public void buyField(Player player) {
		super.buyField(player);
		player.addFleet();
	}

	@Override
	public void landOnField(Player player) {
		if (!(player == this.getOwner())) {
			payRent(player);
		}
	}


	private void payRent(Player player) {
		player.withdraw(this.getRent());
		
	}	

}
