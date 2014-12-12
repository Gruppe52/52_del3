/**
 * Board class contains all the field objects used on the board in the game
 */

package entity;
import controller.Fleet;
import controller.LaborCamp;
import controller.Ownable;
import controller.Refuge;
import controller.Tax;
import controller.Territory;


public class Board {

	Field[] fields = new Field[23];	//Set as 23, because field[0] and field[1] doesnt exist or is used (not sure it's the right way to do this.. )
	
	public Field getField(int FieldNr) {
		Field Field = fields[FieldNr];
		return Field;
	}
	
	public Board() {
		    fields[1] = new Territory(1, "Start", 100, 1000);
			fields[2] = new Territory(2, "Tribe Encampment", 100, 1000);
			fields[3] = new Territory(3, "Crater", 300, 1500);
			fields[4] = new Territory(4, "Mountain", 500, 2000);
			fields[5] = new Territory(5, "Cold Desert", 700, 3000);
			fields[6] = new Territory(6, "Black Cave", 1000, 4000);
			fields[7] = new Territory(7, "The Werewall", 1300, 4300);
			fields[8] = new Territory(8, "Mountain Village", 1600, 4750);
			fields[9] = new Territory(9, "South Citadel", 2000, 5000);
			fields[10] = new Territory(10, "Palace Gates", 2600, 5500);
			fields[11] = new Territory(11, "Tower", 3200, 6000);
			fields[12] = new Territory(12, "Castle", 4000, 8000);
			fields[13] = new Refuge(13, "Walled City", 5000);
			fields[14] = new Refuge(14, "Monastery", 500);
			fields[15] = new LaborCamp(15, "Huts In The Mountain", 2500, 500);
			fields[16] = new LaborCamp(16, "The Pit", 2500, 500);
			fields[17] = new Tax(17, "Goldmine", 2000);
			fields[18] = new Tax(18, "Caravan", 4000, 10);
			fields[19] = new Fleet(19, "Second Sail", 4000);
			fields[20] = new Fleet(20, "Sea Grover", 4000);
			fields[21] = new Fleet(21, "The Buccaneers", 4000);
			fields[22] = new Fleet(22, "Privateer armade", 4000);
	}
	
	public Field[] getFields() {
		return fields;
	}
	public void resetOwnerShip(Player player) {
		for (int i = 0; i < fields.length; i++) {
			if( fields[i] instanceof Ownable ) {
//				fields[i].resetOwner(player);				
			}
		}
		
	}

}
