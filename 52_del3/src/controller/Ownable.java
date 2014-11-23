package controller;
import boundary.MatadorGUI;
import entity.Field;
import entity.Player;

/**
 * Ownable class
 * 
 * @author 52
 *
 */

// abstrakte klasser skal forlænges, de kan ikke instantieres.

public abstract class Ownable extends Field {
	protected int price;
	private Player owner;
	
	public Ownable(int fieldNumber, String fieldName, int price) {
		super(fieldName, fieldNumber);
		this.price = price;
	}	
	public abstract int getRent(); 
	
	public Player getOwner() {
		return owner;
	}
	
	public String toString() {
		String x = "Feltnavn:" + fieldName + ", felt nr.:" + fieldNumber;
		return x;
	}
	
	
	@Override
	public void landOnField(Player player, MatadorGUI matadorGUI) {
		if(getOwner() == null) {
			boolean x = matadorGUI.askIfPlayerWantsToBuyTerritory();	//Gets yes/no answer if the players wants to buy
			if(x) {
				if(price <= player.getBalance()) {
					player.withdraw(price);
					owner = player;
				} else if(price > player.getBalance()) {
					matadorGUI.playerCantAfford();
				}
			}		
		}
	}
}


