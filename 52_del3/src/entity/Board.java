/**
 * Board class contains all the field objects used on the board in the game
 */

package entity;
import controller.Fleet;
import controller.LaborCamp;
import controller.Refuge;
import controller.Tax;
import controller.Territory;


public class Board {
	Field[] fields = new Field[23];	//Set as 23, because field[0] and field[1] doesnt exist or is used
	
	public Field getField(int FieldNr) {
		Field Field = fields[FieldNr];
		return Field;
	}
	public Board() {
			fields[2] = new Territory(1, "Tribe Encampment", 100, 1000);
			fields[3] = new Territory(2, "Crater", 300, 1500);
			fields[4] = new Territory(3, "Mountain", 500, 2000);
			fields[5] = new Territory(4, "Cold Desert", 700, 3000);
			fields[6] = new Territory(5, "Black Cave", 1000, 4000);
			fields[7] = new Territory(6, "The Werewall", 1300, 4300);
			fields[8] = new Territory(7, "Mountain Village", 1600, 4750);
			fields[9] = new Territory(8, "South Citadel", 2000, 5000);
			fields[10] = new Territory(9, "Palace Gates", 2600, 5500);
			fields[11] = new Territory(10, "Tower", 3200, 6000);
			fields[12] = new Territory(11, "Castle", 4000, 8000);
			fields[13] = new Refuge(12, "Walled City", 5000);
			fields[14] = new Refuge(13, "Monastery", 500);
			fields[15] = new LaborCamp(14, "Huts In The Mountain", 2500, 500);
			fields[16] = new LaborCamp(15, "The Pit", 2500, 500);
			fields[17] = new Tax(16, "Goldmine", 2000);
			fields[18] = new Tax(17, "Caravan", 4000, 10);
			fields[19] = new Fleet(18, "Second Sail", 4000);
			fields[20] = new Fleet(19, "Sea Grover", 4000);
			fields[21] = new Fleet(20, "The Buccaneers", 4000);
			fields[22] = new Fleet(21, "Privateer armade", 4000);

	}
}
