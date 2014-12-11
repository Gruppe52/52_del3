package controller;

import boundary.MatadorGUI;
import entity.Field;
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

	@Override
	public void landOnField(Player player, MatadorGUI matadorGUI) {
		// TODO Auto-generated method stub
		
	}

}
