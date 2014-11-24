package controller;

import boundary.MatadorGUI;
import entity.Player;


/**
 * Territory class
 * @author 52
 *
 */
public class Territory extends Ownable {
	private int rent;
	
	public Territory(int fieldNumber, String fieldName, int rent, int price) {
		super(fieldNumber, fieldName, price);
		this.rent = rent;
		
	}

	@Override
	public int getRent() {
		return rent;
	}

	@Override
	public void landOnField(Player player) {
		System.out.println("Det ejes af " + super.getOwner());
		if(super.getOwner() == null) {			
		}
		
	}
	public String toString() {
		return (fieldNumber + " " + fieldName + ", rent" + rent + ", price" + price);
	}





}
