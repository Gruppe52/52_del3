package controller;

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
		// TODO Auto-generated method stub
		
	}

}
