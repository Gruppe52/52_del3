package entity;
/**
 * Field class
 * @author 52
 *
 */
public abstract class Field {
	protected String fieldName;
	protected int fieldNumber;
	
	public abstract void landOnField(Player player);
	
	public Field(String fieldName, int fieldNumber) {
		this.fieldName = fieldName;
		this.fieldNumber = fieldNumber;
	}

}
