package controller;
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
	

}
