package controller;

import entity.Field;
import entity.Player;

public class Tax extends Field  {
	private int taxAmount;
	private int taxPercent;
	
	/**
	 * Two constructors, one for when the Taxfield has a possibility for tax percent of assets, and not
	 * @param fieldName
	 * @param fieldNumber
	 * @param taxAmount
	 * @param taxRate
	 */
	public Tax(int fieldNumber, String fieldName, int taxAmount, int taxPercent) {
		super(fieldName, fieldNumber);
		this.taxAmount = taxAmount; 
		this.taxPercent = taxPercent;
	}	
	public Tax(int fieldNumber, String fieldName, int taxAmount) {
		super(fieldName, fieldNumber);
		this.taxAmount = taxAmount; 

	}
	@Override
	public void landOnField(Player player) {
		// TODO Auto-generated method stub		
	}
}
