
/**
 * Player klassen, indeholder spillerens navn og Account klassen
 * @author 52
 *
 */

package entity;

public class Player extends Account {
	String playerName;		//Spiller navn
	
	/** 
	 * @return Returnerer spillerens navn
	 */
	public String getName() {
		return playerName;
	}

	public boolean isWinner() {

		return false;
	}

	public void setName(String name) {
		playerName = name;		
	}

	public void setColor(int i) {
		// TODO Auto-generated method stub
		
	}


}
