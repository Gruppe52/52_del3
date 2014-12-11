package entity;

import boundary.MatadorGUI;

/**
 * Field class
 * @author 52
 *
 */
public abstract class Field {
	protected String fieldName;
	protected int fieldNumber;
	
	public abstract void landOnField(Player player, MatadorGUI matadorGUI);
	
	public Field(String fieldName, int fieldNumber) {
		this.fieldName = fieldName;
		this.fieldNumber = fieldNumber;
	}
	
	public String toString() {
		String x = "Feltnavn:" + fieldName + ", felt nr.:" + fieldNumber;
		return x;
	}

	public void landOnField(Player player) {
		// TODO Auto-generated method stub
		
	}


//	public void getRent() {
//		// TODO Auto-generated method stub
//		
//	}
	
	

}
