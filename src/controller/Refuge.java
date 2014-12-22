package controller;

import boundary.MatadorGUI;
import entity.Player;

public class Refuge extends Field {
	private int bonus;
	
	public Refuge(int fieldNumber, String fieldName, int bonus) {
		super(fieldName, fieldNumber);
		this.bonus = bonus;
	}

	@Override
	public void landOnField(Player player) {
		System.out.println("landed on Refuge");
		
	}

	/**
	 * This method deposits a specific bonus to a players account when the player lands on the field
	 */
	@Override
	public void landOnField(Player player, MatadorGUI matadorGUI) {
		
		//Calls GUI message
		matadorGUI.landedOnRefuge(player);
		
		//Deposit bonus to player
		player.deposit(bonus);
		
	}

}
