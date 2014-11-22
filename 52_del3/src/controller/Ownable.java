package controller;

/**
 * Ownable class
 * 
 * @author 52
 *
 */

// abstrakte klasser skal forlænges, de kan ikke instantieres.

public abstract class Ownable {
	
	public abstract void  getRent();
	  
	Fleet fleet = new Fleet();				//Hvorfor bliver der lavet objekter herinde? -Stefan
	LaborCamp LaborCamp = new LaborCamp();
	Territory Territory = new Territory();
	

}
